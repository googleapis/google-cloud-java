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

package com.google.cloud.orchestration.airflow.service.v1beta1.stub;

import static com.google.cloud.orchestration.airflow.service.v1beta1.EnvironmentsClient.ListEnvironmentsPagedResponse;
import static com.google.cloud.orchestration.airflow.service.v1beta1.EnvironmentsClient.ListUserWorkloadsConfigMapsPagedResponse;
import static com.google.cloud.orchestration.airflow.service.v1beta1.EnvironmentsClient.ListUserWorkloadsSecretsPagedResponse;
import static com.google.cloud.orchestration.airflow.service.v1beta1.EnvironmentsClient.ListWorkloadsPagedResponse;

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
import com.google.cloud.orchestration.airflow.service.v1beta1.CheckUpgradeRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.CheckUpgradeResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.CreateEnvironmentRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsConfigMapRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsSecretRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.DatabaseFailoverRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.DatabaseFailoverResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.DeleteEnvironmentRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsConfigMapRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsSecretRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.Environment;
import com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.GetEnvironmentRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsConfigMapRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsSecretRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.LoadSnapshotRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.LoadSnapshotResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.OperationMetadata;
import com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.RestartWebServerRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.SaveSnapshotRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.SaveSnapshotResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.UpdateEnvironmentRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsConfigMapRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsSecretRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap;
import com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret;
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
 * Settings class to configure an instance of {@link EnvironmentsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (composer.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getEnvironment to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EnvironmentsStubSettings.Builder environmentsSettingsBuilder =
 *     EnvironmentsStubSettings.newBuilder();
 * environmentsSettingsBuilder
 *     .getEnvironmentSettings()
 *     .setRetrySettings(
 *         environmentsSettingsBuilder
 *             .getEnvironmentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * EnvironmentsStubSettings environmentsSettings = environmentsSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class EnvironmentsStubSettings extends StubSettings<EnvironmentsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateEnvironmentRequest, Operation> createEnvironmentSettings;
  private final OperationCallSettings<CreateEnvironmentRequest, Environment, OperationMetadata>
      createEnvironmentOperationSettings;
  private final UnaryCallSettings<GetEnvironmentRequest, Environment> getEnvironmentSettings;
  private final PagedCallSettings<
          ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
      listEnvironmentsSettings;
  private final UnaryCallSettings<UpdateEnvironmentRequest, Operation> updateEnvironmentSettings;
  private final OperationCallSettings<UpdateEnvironmentRequest, Environment, OperationMetadata>
      updateEnvironmentOperationSettings;
  private final UnaryCallSettings<DeleteEnvironmentRequest, Operation> deleteEnvironmentSettings;
  private final OperationCallSettings<DeleteEnvironmentRequest, Empty, OperationMetadata>
      deleteEnvironmentOperationSettings;
  private final UnaryCallSettings<RestartWebServerRequest, Operation> restartWebServerSettings;
  private final OperationCallSettings<RestartWebServerRequest, Environment, OperationMetadata>
      restartWebServerOperationSettings;
  private final UnaryCallSettings<CheckUpgradeRequest, Operation> checkUpgradeSettings;
  private final OperationCallSettings<CheckUpgradeRequest, CheckUpgradeResponse, OperationMetadata>
      checkUpgradeOperationSettings;
  private final UnaryCallSettings<ExecuteAirflowCommandRequest, ExecuteAirflowCommandResponse>
      executeAirflowCommandSettings;
  private final UnaryCallSettings<StopAirflowCommandRequest, StopAirflowCommandResponse>
      stopAirflowCommandSettings;
  private final UnaryCallSettings<PollAirflowCommandRequest, PollAirflowCommandResponse>
      pollAirflowCommandSettings;
  private final PagedCallSettings<
          ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>
      listWorkloadsSettings;
  private final UnaryCallSettings<CreateUserWorkloadsSecretRequest, UserWorkloadsSecret>
      createUserWorkloadsSecretSettings;
  private final UnaryCallSettings<GetUserWorkloadsSecretRequest, UserWorkloadsSecret>
      getUserWorkloadsSecretSettings;
  private final PagedCallSettings<
          ListUserWorkloadsSecretsRequest,
          ListUserWorkloadsSecretsResponse,
          ListUserWorkloadsSecretsPagedResponse>
      listUserWorkloadsSecretsSettings;
  private final UnaryCallSettings<UpdateUserWorkloadsSecretRequest, UserWorkloadsSecret>
      updateUserWorkloadsSecretSettings;
  private final UnaryCallSettings<DeleteUserWorkloadsSecretRequest, Empty>
      deleteUserWorkloadsSecretSettings;
  private final UnaryCallSettings<CreateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
      createUserWorkloadsConfigMapSettings;
  private final UnaryCallSettings<GetUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
      getUserWorkloadsConfigMapSettings;
  private final PagedCallSettings<
          ListUserWorkloadsConfigMapsRequest,
          ListUserWorkloadsConfigMapsResponse,
          ListUserWorkloadsConfigMapsPagedResponse>
      listUserWorkloadsConfigMapsSettings;
  private final UnaryCallSettings<UpdateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
      updateUserWorkloadsConfigMapSettings;
  private final UnaryCallSettings<DeleteUserWorkloadsConfigMapRequest, Empty>
      deleteUserWorkloadsConfigMapSettings;
  private final UnaryCallSettings<SaveSnapshotRequest, Operation> saveSnapshotSettings;
  private final OperationCallSettings<SaveSnapshotRequest, SaveSnapshotResponse, OperationMetadata>
      saveSnapshotOperationSettings;
  private final UnaryCallSettings<LoadSnapshotRequest, Operation> loadSnapshotSettings;
  private final OperationCallSettings<LoadSnapshotRequest, LoadSnapshotResponse, OperationMetadata>
      loadSnapshotOperationSettings;
  private final UnaryCallSettings<DatabaseFailoverRequest, Operation> databaseFailoverSettings;
  private final OperationCallSettings<
          DatabaseFailoverRequest, DatabaseFailoverResponse, OperationMetadata>
      databaseFailoverOperationSettings;
  private final UnaryCallSettings<FetchDatabasePropertiesRequest, FetchDatabasePropertiesResponse>
      fetchDatabasePropertiesSettings;

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

  private static final PagedListDescriptor<
          ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsResponse.ComposerWorkload>
      LIST_WORKLOADS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListWorkloadsRequest,
              ListWorkloadsResponse,
              ListWorkloadsResponse.ComposerWorkload>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListWorkloadsRequest injectToken(ListWorkloadsRequest payload, String token) {
              return ListWorkloadsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListWorkloadsRequest injectPageSize(ListWorkloadsRequest payload, int pageSize) {
              return ListWorkloadsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListWorkloadsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListWorkloadsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ListWorkloadsResponse.ComposerWorkload> extractResources(
                ListWorkloadsResponse payload) {
              return payload.getWorkloadsList() == null
                  ? ImmutableList.<ListWorkloadsResponse.ComposerWorkload>of()
                  : payload.getWorkloadsList();
            }
          };

  private static final PagedListDescriptor<
          ListUserWorkloadsSecretsRequest, ListUserWorkloadsSecretsResponse, UserWorkloadsSecret>
      LIST_USER_WORKLOADS_SECRETS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListUserWorkloadsSecretsRequest,
              ListUserWorkloadsSecretsResponse,
              UserWorkloadsSecret>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListUserWorkloadsSecretsRequest injectToken(
                ListUserWorkloadsSecretsRequest payload, String token) {
              return ListUserWorkloadsSecretsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListUserWorkloadsSecretsRequest injectPageSize(
                ListUserWorkloadsSecretsRequest payload, int pageSize) {
              return ListUserWorkloadsSecretsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListUserWorkloadsSecretsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListUserWorkloadsSecretsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<UserWorkloadsSecret> extractResources(
                ListUserWorkloadsSecretsResponse payload) {
              return payload.getUserWorkloadsSecretsList() == null
                  ? ImmutableList.<UserWorkloadsSecret>of()
                  : payload.getUserWorkloadsSecretsList();
            }
          };

  private static final PagedListDescriptor<
          ListUserWorkloadsConfigMapsRequest,
          ListUserWorkloadsConfigMapsResponse,
          UserWorkloadsConfigMap>
      LIST_USER_WORKLOADS_CONFIG_MAPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListUserWorkloadsConfigMapsRequest,
              ListUserWorkloadsConfigMapsResponse,
              UserWorkloadsConfigMap>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListUserWorkloadsConfigMapsRequest injectToken(
                ListUserWorkloadsConfigMapsRequest payload, String token) {
              return ListUserWorkloadsConfigMapsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListUserWorkloadsConfigMapsRequest injectPageSize(
                ListUserWorkloadsConfigMapsRequest payload, int pageSize) {
              return ListUserWorkloadsConfigMapsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListUserWorkloadsConfigMapsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListUserWorkloadsConfigMapsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<UserWorkloadsConfigMap> extractResources(
                ListUserWorkloadsConfigMapsResponse payload) {
              return payload.getUserWorkloadsConfigMapsList() == null
                  ? ImmutableList.<UserWorkloadsConfigMap>of()
                  : payload.getUserWorkloadsConfigMapsList();
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
          ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>
      LIST_WORKLOADS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>() {
            @Override
            public ApiFuture<ListWorkloadsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListWorkloadsRequest, ListWorkloadsResponse> callable,
                ListWorkloadsRequest request,
                ApiCallContext context,
                ApiFuture<ListWorkloadsResponse> futureResponse) {
              PageContext<
                      ListWorkloadsRequest,
                      ListWorkloadsResponse,
                      ListWorkloadsResponse.ComposerWorkload>
                  pageContext =
                      PageContext.create(callable, LIST_WORKLOADS_PAGE_STR_DESC, request, context);
              return ListWorkloadsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListUserWorkloadsSecretsRequest,
          ListUserWorkloadsSecretsResponse,
          ListUserWorkloadsSecretsPagedResponse>
      LIST_USER_WORKLOADS_SECRETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListUserWorkloadsSecretsRequest,
              ListUserWorkloadsSecretsResponse,
              ListUserWorkloadsSecretsPagedResponse>() {
            @Override
            public ApiFuture<ListUserWorkloadsSecretsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListUserWorkloadsSecretsRequest, ListUserWorkloadsSecretsResponse>
                    callable,
                ListUserWorkloadsSecretsRequest request,
                ApiCallContext context,
                ApiFuture<ListUserWorkloadsSecretsResponse> futureResponse) {
              PageContext<
                      ListUserWorkloadsSecretsRequest,
                      ListUserWorkloadsSecretsResponse,
                      UserWorkloadsSecret>
                  pageContext =
                      PageContext.create(
                          callable, LIST_USER_WORKLOADS_SECRETS_PAGE_STR_DESC, request, context);
              return ListUserWorkloadsSecretsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListUserWorkloadsConfigMapsRequest,
          ListUserWorkloadsConfigMapsResponse,
          ListUserWorkloadsConfigMapsPagedResponse>
      LIST_USER_WORKLOADS_CONFIG_MAPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListUserWorkloadsConfigMapsRequest,
              ListUserWorkloadsConfigMapsResponse,
              ListUserWorkloadsConfigMapsPagedResponse>() {
            @Override
            public ApiFuture<ListUserWorkloadsConfigMapsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListUserWorkloadsConfigMapsRequest, ListUserWorkloadsConfigMapsResponse>
                    callable,
                ListUserWorkloadsConfigMapsRequest request,
                ApiCallContext context,
                ApiFuture<ListUserWorkloadsConfigMapsResponse> futureResponse) {
              PageContext<
                      ListUserWorkloadsConfigMapsRequest,
                      ListUserWorkloadsConfigMapsResponse,
                      UserWorkloadsConfigMap>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_USER_WORKLOADS_CONFIG_MAPS_PAGE_STR_DESC,
                          request,
                          context);
              return ListUserWorkloadsConfigMapsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createEnvironment. */
  public UnaryCallSettings<CreateEnvironmentRequest, Operation> createEnvironmentSettings() {
    return createEnvironmentSettings;
  }

  /** Returns the object with the settings used for calls to createEnvironment. */
  public OperationCallSettings<CreateEnvironmentRequest, Environment, OperationMetadata>
      createEnvironmentOperationSettings() {
    return createEnvironmentOperationSettings;
  }

  /** Returns the object with the settings used for calls to getEnvironment. */
  public UnaryCallSettings<GetEnvironmentRequest, Environment> getEnvironmentSettings() {
    return getEnvironmentSettings;
  }

  /** Returns the object with the settings used for calls to listEnvironments. */
  public PagedCallSettings<
          ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
      listEnvironmentsSettings() {
    return listEnvironmentsSettings;
  }

  /** Returns the object with the settings used for calls to updateEnvironment. */
  public UnaryCallSettings<UpdateEnvironmentRequest, Operation> updateEnvironmentSettings() {
    return updateEnvironmentSettings;
  }

  /** Returns the object with the settings used for calls to updateEnvironment. */
  public OperationCallSettings<UpdateEnvironmentRequest, Environment, OperationMetadata>
      updateEnvironmentOperationSettings() {
    return updateEnvironmentOperationSettings;
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

  /** Returns the object with the settings used for calls to restartWebServer. */
  public UnaryCallSettings<RestartWebServerRequest, Operation> restartWebServerSettings() {
    return restartWebServerSettings;
  }

  /** Returns the object with the settings used for calls to restartWebServer. */
  public OperationCallSettings<RestartWebServerRequest, Environment, OperationMetadata>
      restartWebServerOperationSettings() {
    return restartWebServerOperationSettings;
  }

  /** Returns the object with the settings used for calls to checkUpgrade. */
  public UnaryCallSettings<CheckUpgradeRequest, Operation> checkUpgradeSettings() {
    return checkUpgradeSettings;
  }

  /** Returns the object with the settings used for calls to checkUpgrade. */
  public OperationCallSettings<CheckUpgradeRequest, CheckUpgradeResponse, OperationMetadata>
      checkUpgradeOperationSettings() {
    return checkUpgradeOperationSettings;
  }

  /** Returns the object with the settings used for calls to executeAirflowCommand. */
  public UnaryCallSettings<ExecuteAirflowCommandRequest, ExecuteAirflowCommandResponse>
      executeAirflowCommandSettings() {
    return executeAirflowCommandSettings;
  }

  /** Returns the object with the settings used for calls to stopAirflowCommand. */
  public UnaryCallSettings<StopAirflowCommandRequest, StopAirflowCommandResponse>
      stopAirflowCommandSettings() {
    return stopAirflowCommandSettings;
  }

  /** Returns the object with the settings used for calls to pollAirflowCommand. */
  public UnaryCallSettings<PollAirflowCommandRequest, PollAirflowCommandResponse>
      pollAirflowCommandSettings() {
    return pollAirflowCommandSettings;
  }

  /** Returns the object with the settings used for calls to listWorkloads. */
  public PagedCallSettings<ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>
      listWorkloadsSettings() {
    return listWorkloadsSettings;
  }

  /** Returns the object with the settings used for calls to createUserWorkloadsSecret. */
  public UnaryCallSettings<CreateUserWorkloadsSecretRequest, UserWorkloadsSecret>
      createUserWorkloadsSecretSettings() {
    return createUserWorkloadsSecretSettings;
  }

  /** Returns the object with the settings used for calls to getUserWorkloadsSecret. */
  public UnaryCallSettings<GetUserWorkloadsSecretRequest, UserWorkloadsSecret>
      getUserWorkloadsSecretSettings() {
    return getUserWorkloadsSecretSettings;
  }

  /** Returns the object with the settings used for calls to listUserWorkloadsSecrets. */
  public PagedCallSettings<
          ListUserWorkloadsSecretsRequest,
          ListUserWorkloadsSecretsResponse,
          ListUserWorkloadsSecretsPagedResponse>
      listUserWorkloadsSecretsSettings() {
    return listUserWorkloadsSecretsSettings;
  }

  /** Returns the object with the settings used for calls to updateUserWorkloadsSecret. */
  public UnaryCallSettings<UpdateUserWorkloadsSecretRequest, UserWorkloadsSecret>
      updateUserWorkloadsSecretSettings() {
    return updateUserWorkloadsSecretSettings;
  }

  /** Returns the object with the settings used for calls to deleteUserWorkloadsSecret. */
  public UnaryCallSettings<DeleteUserWorkloadsSecretRequest, Empty>
      deleteUserWorkloadsSecretSettings() {
    return deleteUserWorkloadsSecretSettings;
  }

  /** Returns the object with the settings used for calls to createUserWorkloadsConfigMap. */
  public UnaryCallSettings<CreateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
      createUserWorkloadsConfigMapSettings() {
    return createUserWorkloadsConfigMapSettings;
  }

  /** Returns the object with the settings used for calls to getUserWorkloadsConfigMap. */
  public UnaryCallSettings<GetUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
      getUserWorkloadsConfigMapSettings() {
    return getUserWorkloadsConfigMapSettings;
  }

  /** Returns the object with the settings used for calls to listUserWorkloadsConfigMaps. */
  public PagedCallSettings<
          ListUserWorkloadsConfigMapsRequest,
          ListUserWorkloadsConfigMapsResponse,
          ListUserWorkloadsConfigMapsPagedResponse>
      listUserWorkloadsConfigMapsSettings() {
    return listUserWorkloadsConfigMapsSettings;
  }

  /** Returns the object with the settings used for calls to updateUserWorkloadsConfigMap. */
  public UnaryCallSettings<UpdateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
      updateUserWorkloadsConfigMapSettings() {
    return updateUserWorkloadsConfigMapSettings;
  }

  /** Returns the object with the settings used for calls to deleteUserWorkloadsConfigMap. */
  public UnaryCallSettings<DeleteUserWorkloadsConfigMapRequest, Empty>
      deleteUserWorkloadsConfigMapSettings() {
    return deleteUserWorkloadsConfigMapSettings;
  }

  /** Returns the object with the settings used for calls to saveSnapshot. */
  public UnaryCallSettings<SaveSnapshotRequest, Operation> saveSnapshotSettings() {
    return saveSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to saveSnapshot. */
  public OperationCallSettings<SaveSnapshotRequest, SaveSnapshotResponse, OperationMetadata>
      saveSnapshotOperationSettings() {
    return saveSnapshotOperationSettings;
  }

  /** Returns the object with the settings used for calls to loadSnapshot. */
  public UnaryCallSettings<LoadSnapshotRequest, Operation> loadSnapshotSettings() {
    return loadSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to loadSnapshot. */
  public OperationCallSettings<LoadSnapshotRequest, LoadSnapshotResponse, OperationMetadata>
      loadSnapshotOperationSettings() {
    return loadSnapshotOperationSettings;
  }

  /** Returns the object with the settings used for calls to databaseFailover. */
  public UnaryCallSettings<DatabaseFailoverRequest, Operation> databaseFailoverSettings() {
    return databaseFailoverSettings;
  }

  /** Returns the object with the settings used for calls to databaseFailover. */
  public OperationCallSettings<DatabaseFailoverRequest, DatabaseFailoverResponse, OperationMetadata>
      databaseFailoverOperationSettings() {
    return databaseFailoverOperationSettings;
  }

  /** Returns the object with the settings used for calls to fetchDatabaseProperties. */
  public UnaryCallSettings<FetchDatabasePropertiesRequest, FetchDatabasePropertiesResponse>
      fetchDatabasePropertiesSettings() {
    return fetchDatabasePropertiesSettings;
  }

  public EnvironmentsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcEnvironmentsStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonEnvironmentsStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "composer";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "composer.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "composer.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(EnvironmentsStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(EnvironmentsStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return EnvironmentsStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected EnvironmentsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createEnvironmentSettings = settingsBuilder.createEnvironmentSettings().build();
    createEnvironmentOperationSettings =
        settingsBuilder.createEnvironmentOperationSettings().build();
    getEnvironmentSettings = settingsBuilder.getEnvironmentSettings().build();
    listEnvironmentsSettings = settingsBuilder.listEnvironmentsSettings().build();
    updateEnvironmentSettings = settingsBuilder.updateEnvironmentSettings().build();
    updateEnvironmentOperationSettings =
        settingsBuilder.updateEnvironmentOperationSettings().build();
    deleteEnvironmentSettings = settingsBuilder.deleteEnvironmentSettings().build();
    deleteEnvironmentOperationSettings =
        settingsBuilder.deleteEnvironmentOperationSettings().build();
    restartWebServerSettings = settingsBuilder.restartWebServerSettings().build();
    restartWebServerOperationSettings = settingsBuilder.restartWebServerOperationSettings().build();
    checkUpgradeSettings = settingsBuilder.checkUpgradeSettings().build();
    checkUpgradeOperationSettings = settingsBuilder.checkUpgradeOperationSettings().build();
    executeAirflowCommandSettings = settingsBuilder.executeAirflowCommandSettings().build();
    stopAirflowCommandSettings = settingsBuilder.stopAirflowCommandSettings().build();
    pollAirflowCommandSettings = settingsBuilder.pollAirflowCommandSettings().build();
    listWorkloadsSettings = settingsBuilder.listWorkloadsSettings().build();
    createUserWorkloadsSecretSettings = settingsBuilder.createUserWorkloadsSecretSettings().build();
    getUserWorkloadsSecretSettings = settingsBuilder.getUserWorkloadsSecretSettings().build();
    listUserWorkloadsSecretsSettings = settingsBuilder.listUserWorkloadsSecretsSettings().build();
    updateUserWorkloadsSecretSettings = settingsBuilder.updateUserWorkloadsSecretSettings().build();
    deleteUserWorkloadsSecretSettings = settingsBuilder.deleteUserWorkloadsSecretSettings().build();
    createUserWorkloadsConfigMapSettings =
        settingsBuilder.createUserWorkloadsConfigMapSettings().build();
    getUserWorkloadsConfigMapSettings = settingsBuilder.getUserWorkloadsConfigMapSettings().build();
    listUserWorkloadsConfigMapsSettings =
        settingsBuilder.listUserWorkloadsConfigMapsSettings().build();
    updateUserWorkloadsConfigMapSettings =
        settingsBuilder.updateUserWorkloadsConfigMapSettings().build();
    deleteUserWorkloadsConfigMapSettings =
        settingsBuilder.deleteUserWorkloadsConfigMapSettings().build();
    saveSnapshotSettings = settingsBuilder.saveSnapshotSettings().build();
    saveSnapshotOperationSettings = settingsBuilder.saveSnapshotOperationSettings().build();
    loadSnapshotSettings = settingsBuilder.loadSnapshotSettings().build();
    loadSnapshotOperationSettings = settingsBuilder.loadSnapshotOperationSettings().build();
    databaseFailoverSettings = settingsBuilder.databaseFailoverSettings().build();
    databaseFailoverOperationSettings = settingsBuilder.databaseFailoverOperationSettings().build();
    fetchDatabasePropertiesSettings = settingsBuilder.fetchDatabasePropertiesSettings().build();
  }

  /** Builder for EnvironmentsStubSettings. */
  public static class Builder extends StubSettings.Builder<EnvironmentsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateEnvironmentRequest, Operation>
        createEnvironmentSettings;
    private final OperationCallSettings.Builder<
            CreateEnvironmentRequest, Environment, OperationMetadata>
        createEnvironmentOperationSettings;
    private final UnaryCallSettings.Builder<GetEnvironmentRequest, Environment>
        getEnvironmentSettings;
    private final PagedCallSettings.Builder<
            ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
        listEnvironmentsSettings;
    private final UnaryCallSettings.Builder<UpdateEnvironmentRequest, Operation>
        updateEnvironmentSettings;
    private final OperationCallSettings.Builder<
            UpdateEnvironmentRequest, Environment, OperationMetadata>
        updateEnvironmentOperationSettings;
    private final UnaryCallSettings.Builder<DeleteEnvironmentRequest, Operation>
        deleteEnvironmentSettings;
    private final OperationCallSettings.Builder<DeleteEnvironmentRequest, Empty, OperationMetadata>
        deleteEnvironmentOperationSettings;
    private final UnaryCallSettings.Builder<RestartWebServerRequest, Operation>
        restartWebServerSettings;
    private final OperationCallSettings.Builder<
            RestartWebServerRequest, Environment, OperationMetadata>
        restartWebServerOperationSettings;
    private final UnaryCallSettings.Builder<CheckUpgradeRequest, Operation> checkUpgradeSettings;
    private final OperationCallSettings.Builder<
            CheckUpgradeRequest, CheckUpgradeResponse, OperationMetadata>
        checkUpgradeOperationSettings;
    private final UnaryCallSettings.Builder<
            ExecuteAirflowCommandRequest, ExecuteAirflowCommandResponse>
        executeAirflowCommandSettings;
    private final UnaryCallSettings.Builder<StopAirflowCommandRequest, StopAirflowCommandResponse>
        stopAirflowCommandSettings;
    private final UnaryCallSettings.Builder<PollAirflowCommandRequest, PollAirflowCommandResponse>
        pollAirflowCommandSettings;
    private final PagedCallSettings.Builder<
            ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>
        listWorkloadsSettings;
    private final UnaryCallSettings.Builder<CreateUserWorkloadsSecretRequest, UserWorkloadsSecret>
        createUserWorkloadsSecretSettings;
    private final UnaryCallSettings.Builder<GetUserWorkloadsSecretRequest, UserWorkloadsSecret>
        getUserWorkloadsSecretSettings;
    private final PagedCallSettings.Builder<
            ListUserWorkloadsSecretsRequest,
            ListUserWorkloadsSecretsResponse,
            ListUserWorkloadsSecretsPagedResponse>
        listUserWorkloadsSecretsSettings;
    private final UnaryCallSettings.Builder<UpdateUserWorkloadsSecretRequest, UserWorkloadsSecret>
        updateUserWorkloadsSecretSettings;
    private final UnaryCallSettings.Builder<DeleteUserWorkloadsSecretRequest, Empty>
        deleteUserWorkloadsSecretSettings;
    private final UnaryCallSettings.Builder<
            CreateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
        createUserWorkloadsConfigMapSettings;
    private final UnaryCallSettings.Builder<
            GetUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
        getUserWorkloadsConfigMapSettings;
    private final PagedCallSettings.Builder<
            ListUserWorkloadsConfigMapsRequest,
            ListUserWorkloadsConfigMapsResponse,
            ListUserWorkloadsConfigMapsPagedResponse>
        listUserWorkloadsConfigMapsSettings;
    private final UnaryCallSettings.Builder<
            UpdateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
        updateUserWorkloadsConfigMapSettings;
    private final UnaryCallSettings.Builder<DeleteUserWorkloadsConfigMapRequest, Empty>
        deleteUserWorkloadsConfigMapSettings;
    private final UnaryCallSettings.Builder<SaveSnapshotRequest, Operation> saveSnapshotSettings;
    private final OperationCallSettings.Builder<
            SaveSnapshotRequest, SaveSnapshotResponse, OperationMetadata>
        saveSnapshotOperationSettings;
    private final UnaryCallSettings.Builder<LoadSnapshotRequest, Operation> loadSnapshotSettings;
    private final OperationCallSettings.Builder<
            LoadSnapshotRequest, LoadSnapshotResponse, OperationMetadata>
        loadSnapshotOperationSettings;
    private final UnaryCallSettings.Builder<DatabaseFailoverRequest, Operation>
        databaseFailoverSettings;
    private final OperationCallSettings.Builder<
            DatabaseFailoverRequest, DatabaseFailoverResponse, OperationMetadata>
        databaseFailoverOperationSettings;
    private final UnaryCallSettings.Builder<
            FetchDatabasePropertiesRequest, FetchDatabasePropertiesResponse>
        fetchDatabasePropertiesSettings;
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

      createEnvironmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEnvironmentOperationSettings = OperationCallSettings.newBuilder();
      getEnvironmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listEnvironmentsSettings = PagedCallSettings.newBuilder(LIST_ENVIRONMENTS_PAGE_STR_FACT);
      updateEnvironmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEnvironmentOperationSettings = OperationCallSettings.newBuilder();
      deleteEnvironmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEnvironmentOperationSettings = OperationCallSettings.newBuilder();
      restartWebServerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      restartWebServerOperationSettings = OperationCallSettings.newBuilder();
      checkUpgradeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      checkUpgradeOperationSettings = OperationCallSettings.newBuilder();
      executeAirflowCommandSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      stopAirflowCommandSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      pollAirflowCommandSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listWorkloadsSettings = PagedCallSettings.newBuilder(LIST_WORKLOADS_PAGE_STR_FACT);
      createUserWorkloadsSecretSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getUserWorkloadsSecretSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listUserWorkloadsSecretsSettings =
          PagedCallSettings.newBuilder(LIST_USER_WORKLOADS_SECRETS_PAGE_STR_FACT);
      updateUserWorkloadsSecretSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteUserWorkloadsSecretSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createUserWorkloadsConfigMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getUserWorkloadsConfigMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listUserWorkloadsConfigMapsSettings =
          PagedCallSettings.newBuilder(LIST_USER_WORKLOADS_CONFIG_MAPS_PAGE_STR_FACT);
      updateUserWorkloadsConfigMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteUserWorkloadsConfigMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      saveSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      saveSnapshotOperationSettings = OperationCallSettings.newBuilder();
      loadSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      loadSnapshotOperationSettings = OperationCallSettings.newBuilder();
      databaseFailoverSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      databaseFailoverOperationSettings = OperationCallSettings.newBuilder();
      fetchDatabasePropertiesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createEnvironmentSettings,
              getEnvironmentSettings,
              listEnvironmentsSettings,
              updateEnvironmentSettings,
              deleteEnvironmentSettings,
              restartWebServerSettings,
              checkUpgradeSettings,
              executeAirflowCommandSettings,
              stopAirflowCommandSettings,
              pollAirflowCommandSettings,
              listWorkloadsSettings,
              createUserWorkloadsSecretSettings,
              getUserWorkloadsSecretSettings,
              listUserWorkloadsSecretsSettings,
              updateUserWorkloadsSecretSettings,
              deleteUserWorkloadsSecretSettings,
              createUserWorkloadsConfigMapSettings,
              getUserWorkloadsConfigMapSettings,
              listUserWorkloadsConfigMapsSettings,
              updateUserWorkloadsConfigMapSettings,
              deleteUserWorkloadsConfigMapSettings,
              saveSnapshotSettings,
              loadSnapshotSettings,
              databaseFailoverSettings,
              fetchDatabasePropertiesSettings);
      initDefaults(this);
    }

    protected Builder(EnvironmentsStubSettings settings) {
      super(settings);

      createEnvironmentSettings = settings.createEnvironmentSettings.toBuilder();
      createEnvironmentOperationSettings = settings.createEnvironmentOperationSettings.toBuilder();
      getEnvironmentSettings = settings.getEnvironmentSettings.toBuilder();
      listEnvironmentsSettings = settings.listEnvironmentsSettings.toBuilder();
      updateEnvironmentSettings = settings.updateEnvironmentSettings.toBuilder();
      updateEnvironmentOperationSettings = settings.updateEnvironmentOperationSettings.toBuilder();
      deleteEnvironmentSettings = settings.deleteEnvironmentSettings.toBuilder();
      deleteEnvironmentOperationSettings = settings.deleteEnvironmentOperationSettings.toBuilder();
      restartWebServerSettings = settings.restartWebServerSettings.toBuilder();
      restartWebServerOperationSettings = settings.restartWebServerOperationSettings.toBuilder();
      checkUpgradeSettings = settings.checkUpgradeSettings.toBuilder();
      checkUpgradeOperationSettings = settings.checkUpgradeOperationSettings.toBuilder();
      executeAirflowCommandSettings = settings.executeAirflowCommandSettings.toBuilder();
      stopAirflowCommandSettings = settings.stopAirflowCommandSettings.toBuilder();
      pollAirflowCommandSettings = settings.pollAirflowCommandSettings.toBuilder();
      listWorkloadsSettings = settings.listWorkloadsSettings.toBuilder();
      createUserWorkloadsSecretSettings = settings.createUserWorkloadsSecretSettings.toBuilder();
      getUserWorkloadsSecretSettings = settings.getUserWorkloadsSecretSettings.toBuilder();
      listUserWorkloadsSecretsSettings = settings.listUserWorkloadsSecretsSettings.toBuilder();
      updateUserWorkloadsSecretSettings = settings.updateUserWorkloadsSecretSettings.toBuilder();
      deleteUserWorkloadsSecretSettings = settings.deleteUserWorkloadsSecretSettings.toBuilder();
      createUserWorkloadsConfigMapSettings =
          settings.createUserWorkloadsConfigMapSettings.toBuilder();
      getUserWorkloadsConfigMapSettings = settings.getUserWorkloadsConfigMapSettings.toBuilder();
      listUserWorkloadsConfigMapsSettings =
          settings.listUserWorkloadsConfigMapsSettings.toBuilder();
      updateUserWorkloadsConfigMapSettings =
          settings.updateUserWorkloadsConfigMapSettings.toBuilder();
      deleteUserWorkloadsConfigMapSettings =
          settings.deleteUserWorkloadsConfigMapSettings.toBuilder();
      saveSnapshotSettings = settings.saveSnapshotSettings.toBuilder();
      saveSnapshotOperationSettings = settings.saveSnapshotOperationSettings.toBuilder();
      loadSnapshotSettings = settings.loadSnapshotSettings.toBuilder();
      loadSnapshotOperationSettings = settings.loadSnapshotOperationSettings.toBuilder();
      databaseFailoverSettings = settings.databaseFailoverSettings.toBuilder();
      databaseFailoverOperationSettings = settings.databaseFailoverOperationSettings.toBuilder();
      fetchDatabasePropertiesSettings = settings.fetchDatabasePropertiesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createEnvironmentSettings,
              getEnvironmentSettings,
              listEnvironmentsSettings,
              updateEnvironmentSettings,
              deleteEnvironmentSettings,
              restartWebServerSettings,
              checkUpgradeSettings,
              executeAirflowCommandSettings,
              stopAirflowCommandSettings,
              pollAirflowCommandSettings,
              listWorkloadsSettings,
              createUserWorkloadsSecretSettings,
              getUserWorkloadsSecretSettings,
              listUserWorkloadsSecretsSettings,
              updateUserWorkloadsSecretSettings,
              deleteUserWorkloadsSecretSettings,
              createUserWorkloadsConfigMapSettings,
              getUserWorkloadsConfigMapSettings,
              listUserWorkloadsConfigMapsSettings,
              updateUserWorkloadsConfigMapSettings,
              deleteUserWorkloadsConfigMapSettings,
              saveSnapshotSettings,
              loadSnapshotSettings,
              databaseFailoverSettings,
              fetchDatabasePropertiesSettings);
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
          .createEnvironmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getEnvironmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listEnvironmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateEnvironmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteEnvironmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .restartWebServerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .checkUpgradeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .executeAirflowCommandSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .stopAirflowCommandSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .pollAirflowCommandSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listWorkloadsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createUserWorkloadsSecretSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getUserWorkloadsSecretSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listUserWorkloadsSecretsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateUserWorkloadsSecretSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteUserWorkloadsSecretSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createUserWorkloadsConfigMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getUserWorkloadsConfigMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listUserWorkloadsConfigMapsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateUserWorkloadsConfigMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteUserWorkloadsConfigMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .saveSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .loadSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .databaseFailoverSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .fetchDatabasePropertiesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createEnvironmentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateEnvironmentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
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
          .updateEnvironmentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateEnvironmentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
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
          .restartWebServerOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RestartWebServerRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
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
          .checkUpgradeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CheckUpgradeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CheckUpgradeResponse.class))
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
          .saveSnapshotOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SaveSnapshotRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(SaveSnapshotResponse.class))
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
          .loadSnapshotOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<LoadSnapshotRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(LoadSnapshotResponse.class))
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
          .databaseFailoverOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DatabaseFailoverRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DatabaseFailoverResponse.class))
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

    /** Returns the builder for the settings used for calls to createEnvironment. */
    public UnaryCallSettings.Builder<CreateEnvironmentRequest, Operation>
        createEnvironmentSettings() {
      return createEnvironmentSettings;
    }

    /** Returns the builder for the settings used for calls to createEnvironment. */
    public OperationCallSettings.Builder<CreateEnvironmentRequest, Environment, OperationMetadata>
        createEnvironmentOperationSettings() {
      return createEnvironmentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getEnvironment. */
    public UnaryCallSettings.Builder<GetEnvironmentRequest, Environment> getEnvironmentSettings() {
      return getEnvironmentSettings;
    }

    /** Returns the builder for the settings used for calls to listEnvironments. */
    public PagedCallSettings.Builder<
            ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
        listEnvironmentsSettings() {
      return listEnvironmentsSettings;
    }

    /** Returns the builder for the settings used for calls to updateEnvironment. */
    public UnaryCallSettings.Builder<UpdateEnvironmentRequest, Operation>
        updateEnvironmentSettings() {
      return updateEnvironmentSettings;
    }

    /** Returns the builder for the settings used for calls to updateEnvironment. */
    public OperationCallSettings.Builder<UpdateEnvironmentRequest, Environment, OperationMetadata>
        updateEnvironmentOperationSettings() {
      return updateEnvironmentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEnvironment. */
    public UnaryCallSettings.Builder<DeleteEnvironmentRequest, Operation>
        deleteEnvironmentSettings() {
      return deleteEnvironmentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEnvironment. */
    public OperationCallSettings.Builder<DeleteEnvironmentRequest, Empty, OperationMetadata>
        deleteEnvironmentOperationSettings() {
      return deleteEnvironmentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to restartWebServer. */
    public UnaryCallSettings.Builder<RestartWebServerRequest, Operation>
        restartWebServerSettings() {
      return restartWebServerSettings;
    }

    /** Returns the builder for the settings used for calls to restartWebServer. */
    public OperationCallSettings.Builder<RestartWebServerRequest, Environment, OperationMetadata>
        restartWebServerOperationSettings() {
      return restartWebServerOperationSettings;
    }

    /** Returns the builder for the settings used for calls to checkUpgrade. */
    public UnaryCallSettings.Builder<CheckUpgradeRequest, Operation> checkUpgradeSettings() {
      return checkUpgradeSettings;
    }

    /** Returns the builder for the settings used for calls to checkUpgrade. */
    public OperationCallSettings.Builder<
            CheckUpgradeRequest, CheckUpgradeResponse, OperationMetadata>
        checkUpgradeOperationSettings() {
      return checkUpgradeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to executeAirflowCommand. */
    public UnaryCallSettings.Builder<ExecuteAirflowCommandRequest, ExecuteAirflowCommandResponse>
        executeAirflowCommandSettings() {
      return executeAirflowCommandSettings;
    }

    /** Returns the builder for the settings used for calls to stopAirflowCommand. */
    public UnaryCallSettings.Builder<StopAirflowCommandRequest, StopAirflowCommandResponse>
        stopAirflowCommandSettings() {
      return stopAirflowCommandSettings;
    }

    /** Returns the builder for the settings used for calls to pollAirflowCommand. */
    public UnaryCallSettings.Builder<PollAirflowCommandRequest, PollAirflowCommandResponse>
        pollAirflowCommandSettings() {
      return pollAirflowCommandSettings;
    }

    /** Returns the builder for the settings used for calls to listWorkloads. */
    public PagedCallSettings.Builder<
            ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>
        listWorkloadsSettings() {
      return listWorkloadsSettings;
    }

    /** Returns the builder for the settings used for calls to createUserWorkloadsSecret. */
    public UnaryCallSettings.Builder<CreateUserWorkloadsSecretRequest, UserWorkloadsSecret>
        createUserWorkloadsSecretSettings() {
      return createUserWorkloadsSecretSettings;
    }

    /** Returns the builder for the settings used for calls to getUserWorkloadsSecret. */
    public UnaryCallSettings.Builder<GetUserWorkloadsSecretRequest, UserWorkloadsSecret>
        getUserWorkloadsSecretSettings() {
      return getUserWorkloadsSecretSettings;
    }

    /** Returns the builder for the settings used for calls to listUserWorkloadsSecrets. */
    public PagedCallSettings.Builder<
            ListUserWorkloadsSecretsRequest,
            ListUserWorkloadsSecretsResponse,
            ListUserWorkloadsSecretsPagedResponse>
        listUserWorkloadsSecretsSettings() {
      return listUserWorkloadsSecretsSettings;
    }

    /** Returns the builder for the settings used for calls to updateUserWorkloadsSecret. */
    public UnaryCallSettings.Builder<UpdateUserWorkloadsSecretRequest, UserWorkloadsSecret>
        updateUserWorkloadsSecretSettings() {
      return updateUserWorkloadsSecretSettings;
    }

    /** Returns the builder for the settings used for calls to deleteUserWorkloadsSecret. */
    public UnaryCallSettings.Builder<DeleteUserWorkloadsSecretRequest, Empty>
        deleteUserWorkloadsSecretSettings() {
      return deleteUserWorkloadsSecretSettings;
    }

    /** Returns the builder for the settings used for calls to createUserWorkloadsConfigMap. */
    public UnaryCallSettings.Builder<CreateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
        createUserWorkloadsConfigMapSettings() {
      return createUserWorkloadsConfigMapSettings;
    }

    /** Returns the builder for the settings used for calls to getUserWorkloadsConfigMap. */
    public UnaryCallSettings.Builder<GetUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
        getUserWorkloadsConfigMapSettings() {
      return getUserWorkloadsConfigMapSettings;
    }

    /** Returns the builder for the settings used for calls to listUserWorkloadsConfigMaps. */
    public PagedCallSettings.Builder<
            ListUserWorkloadsConfigMapsRequest,
            ListUserWorkloadsConfigMapsResponse,
            ListUserWorkloadsConfigMapsPagedResponse>
        listUserWorkloadsConfigMapsSettings() {
      return listUserWorkloadsConfigMapsSettings;
    }

    /** Returns the builder for the settings used for calls to updateUserWorkloadsConfigMap. */
    public UnaryCallSettings.Builder<UpdateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
        updateUserWorkloadsConfigMapSettings() {
      return updateUserWorkloadsConfigMapSettings;
    }

    /** Returns the builder for the settings used for calls to deleteUserWorkloadsConfigMap. */
    public UnaryCallSettings.Builder<DeleteUserWorkloadsConfigMapRequest, Empty>
        deleteUserWorkloadsConfigMapSettings() {
      return deleteUserWorkloadsConfigMapSettings;
    }

    /** Returns the builder for the settings used for calls to saveSnapshot. */
    public UnaryCallSettings.Builder<SaveSnapshotRequest, Operation> saveSnapshotSettings() {
      return saveSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to saveSnapshot. */
    public OperationCallSettings.Builder<
            SaveSnapshotRequest, SaveSnapshotResponse, OperationMetadata>
        saveSnapshotOperationSettings() {
      return saveSnapshotOperationSettings;
    }

    /** Returns the builder for the settings used for calls to loadSnapshot. */
    public UnaryCallSettings.Builder<LoadSnapshotRequest, Operation> loadSnapshotSettings() {
      return loadSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to loadSnapshot. */
    public OperationCallSettings.Builder<
            LoadSnapshotRequest, LoadSnapshotResponse, OperationMetadata>
        loadSnapshotOperationSettings() {
      return loadSnapshotOperationSettings;
    }

    /** Returns the builder for the settings used for calls to databaseFailover. */
    public UnaryCallSettings.Builder<DatabaseFailoverRequest, Operation>
        databaseFailoverSettings() {
      return databaseFailoverSettings;
    }

    /** Returns the builder for the settings used for calls to databaseFailover. */
    public OperationCallSettings.Builder<
            DatabaseFailoverRequest, DatabaseFailoverResponse, OperationMetadata>
        databaseFailoverOperationSettings() {
      return databaseFailoverOperationSettings;
    }

    /** Returns the builder for the settings used for calls to fetchDatabaseProperties. */
    public UnaryCallSettings.Builder<
            FetchDatabasePropertiesRequest, FetchDatabasePropertiesResponse>
        fetchDatabasePropertiesSettings() {
      return fetchDatabasePropertiesSettings;
    }

    @Override
    public EnvironmentsStubSettings build() throws IOException {
      return new EnvironmentsStubSettings(this);
    }
  }
}
