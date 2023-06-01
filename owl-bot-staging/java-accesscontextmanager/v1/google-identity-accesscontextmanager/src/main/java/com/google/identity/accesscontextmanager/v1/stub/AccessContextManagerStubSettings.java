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

package com.google.identity.accesscontextmanager.v1.stub;

import static com.google.identity.accesscontextmanager.v1.AccessContextManagerClient.ListAccessLevelsPagedResponse;
import static com.google.identity.accesscontextmanager.v1.AccessContextManagerClient.ListAccessPoliciesPagedResponse;
import static com.google.identity.accesscontextmanager.v1.AccessContextManagerClient.ListGcpUserAccessBindingsPagedResponse;
import static com.google.identity.accesscontextmanager.v1.AccessContextManagerClient.ListServicePerimetersPagedResponse;

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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.identity.accesscontextmanager.v1.AccessContextManagerOperationMetadata;
import com.google.identity.accesscontextmanager.v1.AccessLevel;
import com.google.identity.accesscontextmanager.v1.AccessPolicy;
import com.google.identity.accesscontextmanager.v1.CommitServicePerimetersRequest;
import com.google.identity.accesscontextmanager.v1.CommitServicePerimetersResponse;
import com.google.identity.accesscontextmanager.v1.CreateAccessLevelRequest;
import com.google.identity.accesscontextmanager.v1.CreateGcpUserAccessBindingRequest;
import com.google.identity.accesscontextmanager.v1.CreateServicePerimeterRequest;
import com.google.identity.accesscontextmanager.v1.DeleteAccessLevelRequest;
import com.google.identity.accesscontextmanager.v1.DeleteAccessPolicyRequest;
import com.google.identity.accesscontextmanager.v1.DeleteGcpUserAccessBindingRequest;
import com.google.identity.accesscontextmanager.v1.DeleteServicePerimeterRequest;
import com.google.identity.accesscontextmanager.v1.GcpUserAccessBinding;
import com.google.identity.accesscontextmanager.v1.GcpUserAccessBindingOperationMetadata;
import com.google.identity.accesscontextmanager.v1.GetAccessLevelRequest;
import com.google.identity.accesscontextmanager.v1.GetAccessPolicyRequest;
import com.google.identity.accesscontextmanager.v1.GetGcpUserAccessBindingRequest;
import com.google.identity.accesscontextmanager.v1.GetServicePerimeterRequest;
import com.google.identity.accesscontextmanager.v1.ListAccessLevelsRequest;
import com.google.identity.accesscontextmanager.v1.ListAccessLevelsResponse;
import com.google.identity.accesscontextmanager.v1.ListAccessPoliciesRequest;
import com.google.identity.accesscontextmanager.v1.ListAccessPoliciesResponse;
import com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsRequest;
import com.google.identity.accesscontextmanager.v1.ListGcpUserAccessBindingsResponse;
import com.google.identity.accesscontextmanager.v1.ListServicePerimetersRequest;
import com.google.identity.accesscontextmanager.v1.ListServicePerimetersResponse;
import com.google.identity.accesscontextmanager.v1.ReplaceAccessLevelsRequest;
import com.google.identity.accesscontextmanager.v1.ReplaceAccessLevelsResponse;
import com.google.identity.accesscontextmanager.v1.ReplaceServicePerimetersRequest;
import com.google.identity.accesscontextmanager.v1.ReplaceServicePerimetersResponse;
import com.google.identity.accesscontextmanager.v1.ServicePerimeter;
import com.google.identity.accesscontextmanager.v1.UpdateAccessLevelRequest;
import com.google.identity.accesscontextmanager.v1.UpdateAccessPolicyRequest;
import com.google.identity.accesscontextmanager.v1.UpdateGcpUserAccessBindingRequest;
import com.google.identity.accesscontextmanager.v1.UpdateServicePerimeterRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AccessContextManagerStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (accesscontextmanager.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getAccessPolicy to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AccessContextManagerStubSettings.Builder accessContextManagerSettingsBuilder =
 *     AccessContextManagerStubSettings.newBuilder();
 * accessContextManagerSettingsBuilder
 *     .getAccessPolicySettings()
 *     .setRetrySettings(
 *         accessContextManagerSettingsBuilder
 *             .getAccessPolicySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AccessContextManagerStubSettings accessContextManagerSettings =
 *     accessContextManagerSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AccessContextManagerStubSettings
    extends StubSettings<AccessContextManagerStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListAccessPoliciesRequest, ListAccessPoliciesResponse, ListAccessPoliciesPagedResponse>
      listAccessPoliciesSettings;
  private final UnaryCallSettings<GetAccessPolicyRequest, AccessPolicy> getAccessPolicySettings;
  private final UnaryCallSettings<AccessPolicy, Operation> createAccessPolicySettings;
  private final OperationCallSettings<
          AccessPolicy, AccessPolicy, AccessContextManagerOperationMetadata>
      createAccessPolicyOperationSettings;
  private final UnaryCallSettings<UpdateAccessPolicyRequest, Operation> updateAccessPolicySettings;
  private final OperationCallSettings<
          UpdateAccessPolicyRequest, AccessPolicy, AccessContextManagerOperationMetadata>
      updateAccessPolicyOperationSettings;
  private final UnaryCallSettings<DeleteAccessPolicyRequest, Operation> deleteAccessPolicySettings;
  private final OperationCallSettings<
          DeleteAccessPolicyRequest, Empty, AccessContextManagerOperationMetadata>
      deleteAccessPolicyOperationSettings;
  private final PagedCallSettings<
          ListAccessLevelsRequest, ListAccessLevelsResponse, ListAccessLevelsPagedResponse>
      listAccessLevelsSettings;
  private final UnaryCallSettings<GetAccessLevelRequest, AccessLevel> getAccessLevelSettings;
  private final UnaryCallSettings<CreateAccessLevelRequest, Operation> createAccessLevelSettings;
  private final OperationCallSettings<
          CreateAccessLevelRequest, AccessLevel, AccessContextManagerOperationMetadata>
      createAccessLevelOperationSettings;
  private final UnaryCallSettings<UpdateAccessLevelRequest, Operation> updateAccessLevelSettings;
  private final OperationCallSettings<
          UpdateAccessLevelRequest, AccessLevel, AccessContextManagerOperationMetadata>
      updateAccessLevelOperationSettings;
  private final UnaryCallSettings<DeleteAccessLevelRequest, Operation> deleteAccessLevelSettings;
  private final OperationCallSettings<
          DeleteAccessLevelRequest, Empty, AccessContextManagerOperationMetadata>
      deleteAccessLevelOperationSettings;
  private final UnaryCallSettings<ReplaceAccessLevelsRequest, Operation>
      replaceAccessLevelsSettings;
  private final OperationCallSettings<
          ReplaceAccessLevelsRequest,
          ReplaceAccessLevelsResponse,
          AccessContextManagerOperationMetadata>
      replaceAccessLevelsOperationSettings;
  private final PagedCallSettings<
          ListServicePerimetersRequest,
          ListServicePerimetersResponse,
          ListServicePerimetersPagedResponse>
      listServicePerimetersSettings;
  private final UnaryCallSettings<GetServicePerimeterRequest, ServicePerimeter>
      getServicePerimeterSettings;
  private final UnaryCallSettings<CreateServicePerimeterRequest, Operation>
      createServicePerimeterSettings;
  private final OperationCallSettings<
          CreateServicePerimeterRequest, ServicePerimeter, AccessContextManagerOperationMetadata>
      createServicePerimeterOperationSettings;
  private final UnaryCallSettings<UpdateServicePerimeterRequest, Operation>
      updateServicePerimeterSettings;
  private final OperationCallSettings<
          UpdateServicePerimeterRequest, ServicePerimeter, AccessContextManagerOperationMetadata>
      updateServicePerimeterOperationSettings;
  private final UnaryCallSettings<DeleteServicePerimeterRequest, Operation>
      deleteServicePerimeterSettings;
  private final OperationCallSettings<
          DeleteServicePerimeterRequest, Empty, AccessContextManagerOperationMetadata>
      deleteServicePerimeterOperationSettings;
  private final UnaryCallSettings<ReplaceServicePerimetersRequest, Operation>
      replaceServicePerimetersSettings;
  private final OperationCallSettings<
          ReplaceServicePerimetersRequest,
          ReplaceServicePerimetersResponse,
          AccessContextManagerOperationMetadata>
      replaceServicePerimetersOperationSettings;
  private final UnaryCallSettings<CommitServicePerimetersRequest, Operation>
      commitServicePerimetersSettings;
  private final OperationCallSettings<
          CommitServicePerimetersRequest,
          CommitServicePerimetersResponse,
          AccessContextManagerOperationMetadata>
      commitServicePerimetersOperationSettings;
  private final PagedCallSettings<
          ListGcpUserAccessBindingsRequest,
          ListGcpUserAccessBindingsResponse,
          ListGcpUserAccessBindingsPagedResponse>
      listGcpUserAccessBindingsSettings;
  private final UnaryCallSettings<GetGcpUserAccessBindingRequest, GcpUserAccessBinding>
      getGcpUserAccessBindingSettings;
  private final UnaryCallSettings<CreateGcpUserAccessBindingRequest, Operation>
      createGcpUserAccessBindingSettings;
  private final OperationCallSettings<
          CreateGcpUserAccessBindingRequest,
          GcpUserAccessBinding,
          GcpUserAccessBindingOperationMetadata>
      createGcpUserAccessBindingOperationSettings;
  private final UnaryCallSettings<UpdateGcpUserAccessBindingRequest, Operation>
      updateGcpUserAccessBindingSettings;
  private final OperationCallSettings<
          UpdateGcpUserAccessBindingRequest,
          GcpUserAccessBinding,
          GcpUserAccessBindingOperationMetadata>
      updateGcpUserAccessBindingOperationSettings;
  private final UnaryCallSettings<DeleteGcpUserAccessBindingRequest, Operation>
      deleteGcpUserAccessBindingSettings;
  private final OperationCallSettings<
          DeleteGcpUserAccessBindingRequest, Empty, GcpUserAccessBindingOperationMetadata>
      deleteGcpUserAccessBindingOperationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListAccessPoliciesRequest, ListAccessPoliciesResponse, AccessPolicy>
      LIST_ACCESS_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAccessPoliciesRequest, ListAccessPoliciesResponse, AccessPolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAccessPoliciesRequest injectToken(
                ListAccessPoliciesRequest payload, String token) {
              return ListAccessPoliciesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAccessPoliciesRequest injectPageSize(
                ListAccessPoliciesRequest payload, int pageSize) {
              return ListAccessPoliciesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAccessPoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAccessPoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AccessPolicy> extractResources(ListAccessPoliciesResponse payload) {
              return payload.getAccessPoliciesList() == null
                  ? ImmutableList.<AccessPolicy>of()
                  : payload.getAccessPoliciesList();
            }
          };

  private static final PagedListDescriptor<
          ListAccessLevelsRequest, ListAccessLevelsResponse, AccessLevel>
      LIST_ACCESS_LEVELS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAccessLevelsRequest, ListAccessLevelsResponse, AccessLevel>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAccessLevelsRequest injectToken(
                ListAccessLevelsRequest payload, String token) {
              return ListAccessLevelsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAccessLevelsRequest injectPageSize(
                ListAccessLevelsRequest payload, int pageSize) {
              return ListAccessLevelsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAccessLevelsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAccessLevelsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AccessLevel> extractResources(ListAccessLevelsResponse payload) {
              return payload.getAccessLevelsList() == null
                  ? ImmutableList.<AccessLevel>of()
                  : payload.getAccessLevelsList();
            }
          };

  private static final PagedListDescriptor<
          ListServicePerimetersRequest, ListServicePerimetersResponse, ServicePerimeter>
      LIST_SERVICE_PERIMETERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListServicePerimetersRequest, ListServicePerimetersResponse, ServicePerimeter>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListServicePerimetersRequest injectToken(
                ListServicePerimetersRequest payload, String token) {
              return ListServicePerimetersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListServicePerimetersRequest injectPageSize(
                ListServicePerimetersRequest payload, int pageSize) {
              return ListServicePerimetersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListServicePerimetersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListServicePerimetersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ServicePerimeter> extractResources(
                ListServicePerimetersResponse payload) {
              return payload.getServicePerimetersList() == null
                  ? ImmutableList.<ServicePerimeter>of()
                  : payload.getServicePerimetersList();
            }
          };

  private static final PagedListDescriptor<
          ListGcpUserAccessBindingsRequest, ListGcpUserAccessBindingsResponse, GcpUserAccessBinding>
      LIST_GCP_USER_ACCESS_BINDINGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListGcpUserAccessBindingsRequest,
              ListGcpUserAccessBindingsResponse,
              GcpUserAccessBinding>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGcpUserAccessBindingsRequest injectToken(
                ListGcpUserAccessBindingsRequest payload, String token) {
              return ListGcpUserAccessBindingsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListGcpUserAccessBindingsRequest injectPageSize(
                ListGcpUserAccessBindingsRequest payload, int pageSize) {
              return ListGcpUserAccessBindingsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListGcpUserAccessBindingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListGcpUserAccessBindingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<GcpUserAccessBinding> extractResources(
                ListGcpUserAccessBindingsResponse payload) {
              return payload.getGcpUserAccessBindingsList() == null
                  ? ImmutableList.<GcpUserAccessBinding>of()
                  : payload.getGcpUserAccessBindingsList();
            }
          };

  private static final PagedListResponseFactory<
          ListAccessPoliciesRequest, ListAccessPoliciesResponse, ListAccessPoliciesPagedResponse>
      LIST_ACCESS_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAccessPoliciesRequest,
              ListAccessPoliciesResponse,
              ListAccessPoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListAccessPoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAccessPoliciesRequest, ListAccessPoliciesResponse> callable,
                ListAccessPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<ListAccessPoliciesResponse> futureResponse) {
              PageContext<ListAccessPoliciesRequest, ListAccessPoliciesResponse, AccessPolicy>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ACCESS_POLICIES_PAGE_STR_DESC, request, context);
              return ListAccessPoliciesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAccessLevelsRequest, ListAccessLevelsResponse, ListAccessLevelsPagedResponse>
      LIST_ACCESS_LEVELS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAccessLevelsRequest, ListAccessLevelsResponse, ListAccessLevelsPagedResponse>() {
            @Override
            public ApiFuture<ListAccessLevelsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAccessLevelsRequest, ListAccessLevelsResponse> callable,
                ListAccessLevelsRequest request,
                ApiCallContext context,
                ApiFuture<ListAccessLevelsResponse> futureResponse) {
              PageContext<ListAccessLevelsRequest, ListAccessLevelsResponse, AccessLevel>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ACCESS_LEVELS_PAGE_STR_DESC, request, context);
              return ListAccessLevelsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListServicePerimetersRequest,
          ListServicePerimetersResponse,
          ListServicePerimetersPagedResponse>
      LIST_SERVICE_PERIMETERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListServicePerimetersRequest,
              ListServicePerimetersResponse,
              ListServicePerimetersPagedResponse>() {
            @Override
            public ApiFuture<ListServicePerimetersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListServicePerimetersRequest, ListServicePerimetersResponse> callable,
                ListServicePerimetersRequest request,
                ApiCallContext context,
                ApiFuture<ListServicePerimetersResponse> futureResponse) {
              PageContext<
                      ListServicePerimetersRequest, ListServicePerimetersResponse, ServicePerimeter>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SERVICE_PERIMETERS_PAGE_STR_DESC, request, context);
              return ListServicePerimetersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListGcpUserAccessBindingsRequest,
          ListGcpUserAccessBindingsResponse,
          ListGcpUserAccessBindingsPagedResponse>
      LIST_GCP_USER_ACCESS_BINDINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGcpUserAccessBindingsRequest,
              ListGcpUserAccessBindingsResponse,
              ListGcpUserAccessBindingsPagedResponse>() {
            @Override
            public ApiFuture<ListGcpUserAccessBindingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGcpUserAccessBindingsRequest, ListGcpUserAccessBindingsResponse>
                    callable,
                ListGcpUserAccessBindingsRequest request,
                ApiCallContext context,
                ApiFuture<ListGcpUserAccessBindingsResponse> futureResponse) {
              PageContext<
                      ListGcpUserAccessBindingsRequest,
                      ListGcpUserAccessBindingsResponse,
                      GcpUserAccessBinding>
                  pageContext =
                      PageContext.create(
                          callable, LIST_GCP_USER_ACCESS_BINDINGS_PAGE_STR_DESC, request, context);
              return ListGcpUserAccessBindingsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listAccessPolicies. */
  public PagedCallSettings<
          ListAccessPoliciesRequest, ListAccessPoliciesResponse, ListAccessPoliciesPagedResponse>
      listAccessPoliciesSettings() {
    return listAccessPoliciesSettings;
  }

  /** Returns the object with the settings used for calls to getAccessPolicy. */
  public UnaryCallSettings<GetAccessPolicyRequest, AccessPolicy> getAccessPolicySettings() {
    return getAccessPolicySettings;
  }

  /** Returns the object with the settings used for calls to createAccessPolicy. */
  public UnaryCallSettings<AccessPolicy, Operation> createAccessPolicySettings() {
    return createAccessPolicySettings;
  }

  /** Returns the object with the settings used for calls to createAccessPolicy. */
  public OperationCallSettings<AccessPolicy, AccessPolicy, AccessContextManagerOperationMetadata>
      createAccessPolicyOperationSettings() {
    return createAccessPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateAccessPolicy. */
  public UnaryCallSettings<UpdateAccessPolicyRequest, Operation> updateAccessPolicySettings() {
    return updateAccessPolicySettings;
  }

  /** Returns the object with the settings used for calls to updateAccessPolicy. */
  public OperationCallSettings<
          UpdateAccessPolicyRequest, AccessPolicy, AccessContextManagerOperationMetadata>
      updateAccessPolicyOperationSettings() {
    return updateAccessPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteAccessPolicy. */
  public UnaryCallSettings<DeleteAccessPolicyRequest, Operation> deleteAccessPolicySettings() {
    return deleteAccessPolicySettings;
  }

  /** Returns the object with the settings used for calls to deleteAccessPolicy. */
  public OperationCallSettings<
          DeleteAccessPolicyRequest, Empty, AccessContextManagerOperationMetadata>
      deleteAccessPolicyOperationSettings() {
    return deleteAccessPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to listAccessLevels. */
  public PagedCallSettings<
          ListAccessLevelsRequest, ListAccessLevelsResponse, ListAccessLevelsPagedResponse>
      listAccessLevelsSettings() {
    return listAccessLevelsSettings;
  }

  /** Returns the object with the settings used for calls to getAccessLevel. */
  public UnaryCallSettings<GetAccessLevelRequest, AccessLevel> getAccessLevelSettings() {
    return getAccessLevelSettings;
  }

  /** Returns the object with the settings used for calls to createAccessLevel. */
  public UnaryCallSettings<CreateAccessLevelRequest, Operation> createAccessLevelSettings() {
    return createAccessLevelSettings;
  }

  /** Returns the object with the settings used for calls to createAccessLevel. */
  public OperationCallSettings<
          CreateAccessLevelRequest, AccessLevel, AccessContextManagerOperationMetadata>
      createAccessLevelOperationSettings() {
    return createAccessLevelOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateAccessLevel. */
  public UnaryCallSettings<UpdateAccessLevelRequest, Operation> updateAccessLevelSettings() {
    return updateAccessLevelSettings;
  }

  /** Returns the object with the settings used for calls to updateAccessLevel. */
  public OperationCallSettings<
          UpdateAccessLevelRequest, AccessLevel, AccessContextManagerOperationMetadata>
      updateAccessLevelOperationSettings() {
    return updateAccessLevelOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteAccessLevel. */
  public UnaryCallSettings<DeleteAccessLevelRequest, Operation> deleteAccessLevelSettings() {
    return deleteAccessLevelSettings;
  }

  /** Returns the object with the settings used for calls to deleteAccessLevel. */
  public OperationCallSettings<
          DeleteAccessLevelRequest, Empty, AccessContextManagerOperationMetadata>
      deleteAccessLevelOperationSettings() {
    return deleteAccessLevelOperationSettings;
  }

  /** Returns the object with the settings used for calls to replaceAccessLevels. */
  public UnaryCallSettings<ReplaceAccessLevelsRequest, Operation> replaceAccessLevelsSettings() {
    return replaceAccessLevelsSettings;
  }

  /** Returns the object with the settings used for calls to replaceAccessLevels. */
  public OperationCallSettings<
          ReplaceAccessLevelsRequest,
          ReplaceAccessLevelsResponse,
          AccessContextManagerOperationMetadata>
      replaceAccessLevelsOperationSettings() {
    return replaceAccessLevelsOperationSettings;
  }

  /** Returns the object with the settings used for calls to listServicePerimeters. */
  public PagedCallSettings<
          ListServicePerimetersRequest,
          ListServicePerimetersResponse,
          ListServicePerimetersPagedResponse>
      listServicePerimetersSettings() {
    return listServicePerimetersSettings;
  }

  /** Returns the object with the settings used for calls to getServicePerimeter. */
  public UnaryCallSettings<GetServicePerimeterRequest, ServicePerimeter>
      getServicePerimeterSettings() {
    return getServicePerimeterSettings;
  }

  /** Returns the object with the settings used for calls to createServicePerimeter. */
  public UnaryCallSettings<CreateServicePerimeterRequest, Operation>
      createServicePerimeterSettings() {
    return createServicePerimeterSettings;
  }

  /** Returns the object with the settings used for calls to createServicePerimeter. */
  public OperationCallSettings<
          CreateServicePerimeterRequest, ServicePerimeter, AccessContextManagerOperationMetadata>
      createServicePerimeterOperationSettings() {
    return createServicePerimeterOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateServicePerimeter. */
  public UnaryCallSettings<UpdateServicePerimeterRequest, Operation>
      updateServicePerimeterSettings() {
    return updateServicePerimeterSettings;
  }

  /** Returns the object with the settings used for calls to updateServicePerimeter. */
  public OperationCallSettings<
          UpdateServicePerimeterRequest, ServicePerimeter, AccessContextManagerOperationMetadata>
      updateServicePerimeterOperationSettings() {
    return updateServicePerimeterOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteServicePerimeter. */
  public UnaryCallSettings<DeleteServicePerimeterRequest, Operation>
      deleteServicePerimeterSettings() {
    return deleteServicePerimeterSettings;
  }

  /** Returns the object with the settings used for calls to deleteServicePerimeter. */
  public OperationCallSettings<
          DeleteServicePerimeterRequest, Empty, AccessContextManagerOperationMetadata>
      deleteServicePerimeterOperationSettings() {
    return deleteServicePerimeterOperationSettings;
  }

  /** Returns the object with the settings used for calls to replaceServicePerimeters. */
  public UnaryCallSettings<ReplaceServicePerimetersRequest, Operation>
      replaceServicePerimetersSettings() {
    return replaceServicePerimetersSettings;
  }

  /** Returns the object with the settings used for calls to replaceServicePerimeters. */
  public OperationCallSettings<
          ReplaceServicePerimetersRequest,
          ReplaceServicePerimetersResponse,
          AccessContextManagerOperationMetadata>
      replaceServicePerimetersOperationSettings() {
    return replaceServicePerimetersOperationSettings;
  }

  /** Returns the object with the settings used for calls to commitServicePerimeters. */
  public UnaryCallSettings<CommitServicePerimetersRequest, Operation>
      commitServicePerimetersSettings() {
    return commitServicePerimetersSettings;
  }

  /** Returns the object with the settings used for calls to commitServicePerimeters. */
  public OperationCallSettings<
          CommitServicePerimetersRequest,
          CommitServicePerimetersResponse,
          AccessContextManagerOperationMetadata>
      commitServicePerimetersOperationSettings() {
    return commitServicePerimetersOperationSettings;
  }

  /** Returns the object with the settings used for calls to listGcpUserAccessBindings. */
  public PagedCallSettings<
          ListGcpUserAccessBindingsRequest,
          ListGcpUserAccessBindingsResponse,
          ListGcpUserAccessBindingsPagedResponse>
      listGcpUserAccessBindingsSettings() {
    return listGcpUserAccessBindingsSettings;
  }

  /** Returns the object with the settings used for calls to getGcpUserAccessBinding. */
  public UnaryCallSettings<GetGcpUserAccessBindingRequest, GcpUserAccessBinding>
      getGcpUserAccessBindingSettings() {
    return getGcpUserAccessBindingSettings;
  }

  /** Returns the object with the settings used for calls to createGcpUserAccessBinding. */
  public UnaryCallSettings<CreateGcpUserAccessBindingRequest, Operation>
      createGcpUserAccessBindingSettings() {
    return createGcpUserAccessBindingSettings;
  }

  /** Returns the object with the settings used for calls to createGcpUserAccessBinding. */
  public OperationCallSettings<
          CreateGcpUserAccessBindingRequest,
          GcpUserAccessBinding,
          GcpUserAccessBindingOperationMetadata>
      createGcpUserAccessBindingOperationSettings() {
    return createGcpUserAccessBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateGcpUserAccessBinding. */
  public UnaryCallSettings<UpdateGcpUserAccessBindingRequest, Operation>
      updateGcpUserAccessBindingSettings() {
    return updateGcpUserAccessBindingSettings;
  }

  /** Returns the object with the settings used for calls to updateGcpUserAccessBinding. */
  public OperationCallSettings<
          UpdateGcpUserAccessBindingRequest,
          GcpUserAccessBinding,
          GcpUserAccessBindingOperationMetadata>
      updateGcpUserAccessBindingOperationSettings() {
    return updateGcpUserAccessBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteGcpUserAccessBinding. */
  public UnaryCallSettings<DeleteGcpUserAccessBindingRequest, Operation>
      deleteGcpUserAccessBindingSettings() {
    return deleteGcpUserAccessBindingSettings;
  }

  /** Returns the object with the settings used for calls to deleteGcpUserAccessBinding. */
  public OperationCallSettings<
          DeleteGcpUserAccessBindingRequest, Empty, GcpUserAccessBindingOperationMetadata>
      deleteGcpUserAccessBindingOperationSettings() {
    return deleteGcpUserAccessBindingOperationSettings;
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

  public AccessContextManagerStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAccessContextManagerStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAccessContextManagerStub.create(this);
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
    return "accesscontextmanager.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "accesscontextmanager.mtls.googleapis.com:443";
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AccessContextManagerStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AccessContextManagerStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AccessContextManagerStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected AccessContextManagerStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listAccessPoliciesSettings = settingsBuilder.listAccessPoliciesSettings().build();
    getAccessPolicySettings = settingsBuilder.getAccessPolicySettings().build();
    createAccessPolicySettings = settingsBuilder.createAccessPolicySettings().build();
    createAccessPolicyOperationSettings =
        settingsBuilder.createAccessPolicyOperationSettings().build();
    updateAccessPolicySettings = settingsBuilder.updateAccessPolicySettings().build();
    updateAccessPolicyOperationSettings =
        settingsBuilder.updateAccessPolicyOperationSettings().build();
    deleteAccessPolicySettings = settingsBuilder.deleteAccessPolicySettings().build();
    deleteAccessPolicyOperationSettings =
        settingsBuilder.deleteAccessPolicyOperationSettings().build();
    listAccessLevelsSettings = settingsBuilder.listAccessLevelsSettings().build();
    getAccessLevelSettings = settingsBuilder.getAccessLevelSettings().build();
    createAccessLevelSettings = settingsBuilder.createAccessLevelSettings().build();
    createAccessLevelOperationSettings =
        settingsBuilder.createAccessLevelOperationSettings().build();
    updateAccessLevelSettings = settingsBuilder.updateAccessLevelSettings().build();
    updateAccessLevelOperationSettings =
        settingsBuilder.updateAccessLevelOperationSettings().build();
    deleteAccessLevelSettings = settingsBuilder.deleteAccessLevelSettings().build();
    deleteAccessLevelOperationSettings =
        settingsBuilder.deleteAccessLevelOperationSettings().build();
    replaceAccessLevelsSettings = settingsBuilder.replaceAccessLevelsSettings().build();
    replaceAccessLevelsOperationSettings =
        settingsBuilder.replaceAccessLevelsOperationSettings().build();
    listServicePerimetersSettings = settingsBuilder.listServicePerimetersSettings().build();
    getServicePerimeterSettings = settingsBuilder.getServicePerimeterSettings().build();
    createServicePerimeterSettings = settingsBuilder.createServicePerimeterSettings().build();
    createServicePerimeterOperationSettings =
        settingsBuilder.createServicePerimeterOperationSettings().build();
    updateServicePerimeterSettings = settingsBuilder.updateServicePerimeterSettings().build();
    updateServicePerimeterOperationSettings =
        settingsBuilder.updateServicePerimeterOperationSettings().build();
    deleteServicePerimeterSettings = settingsBuilder.deleteServicePerimeterSettings().build();
    deleteServicePerimeterOperationSettings =
        settingsBuilder.deleteServicePerimeterOperationSettings().build();
    replaceServicePerimetersSettings = settingsBuilder.replaceServicePerimetersSettings().build();
    replaceServicePerimetersOperationSettings =
        settingsBuilder.replaceServicePerimetersOperationSettings().build();
    commitServicePerimetersSettings = settingsBuilder.commitServicePerimetersSettings().build();
    commitServicePerimetersOperationSettings =
        settingsBuilder.commitServicePerimetersOperationSettings().build();
    listGcpUserAccessBindingsSettings = settingsBuilder.listGcpUserAccessBindingsSettings().build();
    getGcpUserAccessBindingSettings = settingsBuilder.getGcpUserAccessBindingSettings().build();
    createGcpUserAccessBindingSettings =
        settingsBuilder.createGcpUserAccessBindingSettings().build();
    createGcpUserAccessBindingOperationSettings =
        settingsBuilder.createGcpUserAccessBindingOperationSettings().build();
    updateGcpUserAccessBindingSettings =
        settingsBuilder.updateGcpUserAccessBindingSettings().build();
    updateGcpUserAccessBindingOperationSettings =
        settingsBuilder.updateGcpUserAccessBindingOperationSettings().build();
    deleteGcpUserAccessBindingSettings =
        settingsBuilder.deleteGcpUserAccessBindingSettings().build();
    deleteGcpUserAccessBindingOperationSettings =
        settingsBuilder.deleteGcpUserAccessBindingOperationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for AccessContextManagerStubSettings. */
  public static class Builder
      extends StubSettings.Builder<AccessContextManagerStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListAccessPoliciesRequest, ListAccessPoliciesResponse, ListAccessPoliciesPagedResponse>
        listAccessPoliciesSettings;
    private final UnaryCallSettings.Builder<GetAccessPolicyRequest, AccessPolicy>
        getAccessPolicySettings;
    private final UnaryCallSettings.Builder<AccessPolicy, Operation> createAccessPolicySettings;
    private final OperationCallSettings.Builder<
            AccessPolicy, AccessPolicy, AccessContextManagerOperationMetadata>
        createAccessPolicyOperationSettings;
    private final UnaryCallSettings.Builder<UpdateAccessPolicyRequest, Operation>
        updateAccessPolicySettings;
    private final OperationCallSettings.Builder<
            UpdateAccessPolicyRequest, AccessPolicy, AccessContextManagerOperationMetadata>
        updateAccessPolicyOperationSettings;
    private final UnaryCallSettings.Builder<DeleteAccessPolicyRequest, Operation>
        deleteAccessPolicySettings;
    private final OperationCallSettings.Builder<
            DeleteAccessPolicyRequest, Empty, AccessContextManagerOperationMetadata>
        deleteAccessPolicyOperationSettings;
    private final PagedCallSettings.Builder<
            ListAccessLevelsRequest, ListAccessLevelsResponse, ListAccessLevelsPagedResponse>
        listAccessLevelsSettings;
    private final UnaryCallSettings.Builder<GetAccessLevelRequest, AccessLevel>
        getAccessLevelSettings;
    private final UnaryCallSettings.Builder<CreateAccessLevelRequest, Operation>
        createAccessLevelSettings;
    private final OperationCallSettings.Builder<
            CreateAccessLevelRequest, AccessLevel, AccessContextManagerOperationMetadata>
        createAccessLevelOperationSettings;
    private final UnaryCallSettings.Builder<UpdateAccessLevelRequest, Operation>
        updateAccessLevelSettings;
    private final OperationCallSettings.Builder<
            UpdateAccessLevelRequest, AccessLevel, AccessContextManagerOperationMetadata>
        updateAccessLevelOperationSettings;
    private final UnaryCallSettings.Builder<DeleteAccessLevelRequest, Operation>
        deleteAccessLevelSettings;
    private final OperationCallSettings.Builder<
            DeleteAccessLevelRequest, Empty, AccessContextManagerOperationMetadata>
        deleteAccessLevelOperationSettings;
    private final UnaryCallSettings.Builder<ReplaceAccessLevelsRequest, Operation>
        replaceAccessLevelsSettings;
    private final OperationCallSettings.Builder<
            ReplaceAccessLevelsRequest,
            ReplaceAccessLevelsResponse,
            AccessContextManagerOperationMetadata>
        replaceAccessLevelsOperationSettings;
    private final PagedCallSettings.Builder<
            ListServicePerimetersRequest,
            ListServicePerimetersResponse,
            ListServicePerimetersPagedResponse>
        listServicePerimetersSettings;
    private final UnaryCallSettings.Builder<GetServicePerimeterRequest, ServicePerimeter>
        getServicePerimeterSettings;
    private final UnaryCallSettings.Builder<CreateServicePerimeterRequest, Operation>
        createServicePerimeterSettings;
    private final OperationCallSettings.Builder<
            CreateServicePerimeterRequest, ServicePerimeter, AccessContextManagerOperationMetadata>
        createServicePerimeterOperationSettings;
    private final UnaryCallSettings.Builder<UpdateServicePerimeterRequest, Operation>
        updateServicePerimeterSettings;
    private final OperationCallSettings.Builder<
            UpdateServicePerimeterRequest, ServicePerimeter, AccessContextManagerOperationMetadata>
        updateServicePerimeterOperationSettings;
    private final UnaryCallSettings.Builder<DeleteServicePerimeterRequest, Operation>
        deleteServicePerimeterSettings;
    private final OperationCallSettings.Builder<
            DeleteServicePerimeterRequest, Empty, AccessContextManagerOperationMetadata>
        deleteServicePerimeterOperationSettings;
    private final UnaryCallSettings.Builder<ReplaceServicePerimetersRequest, Operation>
        replaceServicePerimetersSettings;
    private final OperationCallSettings.Builder<
            ReplaceServicePerimetersRequest,
            ReplaceServicePerimetersResponse,
            AccessContextManagerOperationMetadata>
        replaceServicePerimetersOperationSettings;
    private final UnaryCallSettings.Builder<CommitServicePerimetersRequest, Operation>
        commitServicePerimetersSettings;
    private final OperationCallSettings.Builder<
            CommitServicePerimetersRequest,
            CommitServicePerimetersResponse,
            AccessContextManagerOperationMetadata>
        commitServicePerimetersOperationSettings;
    private final PagedCallSettings.Builder<
            ListGcpUserAccessBindingsRequest,
            ListGcpUserAccessBindingsResponse,
            ListGcpUserAccessBindingsPagedResponse>
        listGcpUserAccessBindingsSettings;
    private final UnaryCallSettings.Builder<GetGcpUserAccessBindingRequest, GcpUserAccessBinding>
        getGcpUserAccessBindingSettings;
    private final UnaryCallSettings.Builder<CreateGcpUserAccessBindingRequest, Operation>
        createGcpUserAccessBindingSettings;
    private final OperationCallSettings.Builder<
            CreateGcpUserAccessBindingRequest,
            GcpUserAccessBinding,
            GcpUserAccessBindingOperationMetadata>
        createGcpUserAccessBindingOperationSettings;
    private final UnaryCallSettings.Builder<UpdateGcpUserAccessBindingRequest, Operation>
        updateGcpUserAccessBindingSettings;
    private final OperationCallSettings.Builder<
            UpdateGcpUserAccessBindingRequest,
            GcpUserAccessBinding,
            GcpUserAccessBindingOperationMetadata>
        updateGcpUserAccessBindingOperationSettings;
    private final UnaryCallSettings.Builder<DeleteGcpUserAccessBindingRequest, Operation>
        deleteGcpUserAccessBindingSettings;
    private final OperationCallSettings.Builder<
            DeleteGcpUserAccessBindingRequest, Empty, GcpUserAccessBindingOperationMetadata>
        deleteGcpUserAccessBindingOperationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listAccessPoliciesSettings = PagedCallSettings.newBuilder(LIST_ACCESS_POLICIES_PAGE_STR_FACT);
      getAccessPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAccessPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAccessPolicyOperationSettings = OperationCallSettings.newBuilder();
      updateAccessPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAccessPolicyOperationSettings = OperationCallSettings.newBuilder();
      deleteAccessPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAccessPolicyOperationSettings = OperationCallSettings.newBuilder();
      listAccessLevelsSettings = PagedCallSettings.newBuilder(LIST_ACCESS_LEVELS_PAGE_STR_FACT);
      getAccessLevelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAccessLevelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAccessLevelOperationSettings = OperationCallSettings.newBuilder();
      updateAccessLevelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAccessLevelOperationSettings = OperationCallSettings.newBuilder();
      deleteAccessLevelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAccessLevelOperationSettings = OperationCallSettings.newBuilder();
      replaceAccessLevelsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      replaceAccessLevelsOperationSettings = OperationCallSettings.newBuilder();
      listServicePerimetersSettings =
          PagedCallSettings.newBuilder(LIST_SERVICE_PERIMETERS_PAGE_STR_FACT);
      getServicePerimeterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createServicePerimeterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createServicePerimeterOperationSettings = OperationCallSettings.newBuilder();
      updateServicePerimeterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateServicePerimeterOperationSettings = OperationCallSettings.newBuilder();
      deleteServicePerimeterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteServicePerimeterOperationSettings = OperationCallSettings.newBuilder();
      replaceServicePerimetersSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      replaceServicePerimetersOperationSettings = OperationCallSettings.newBuilder();
      commitServicePerimetersSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      commitServicePerimetersOperationSettings = OperationCallSettings.newBuilder();
      listGcpUserAccessBindingsSettings =
          PagedCallSettings.newBuilder(LIST_GCP_USER_ACCESS_BINDINGS_PAGE_STR_FACT);
      getGcpUserAccessBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGcpUserAccessBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGcpUserAccessBindingOperationSettings = OperationCallSettings.newBuilder();
      updateGcpUserAccessBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateGcpUserAccessBindingOperationSettings = OperationCallSettings.newBuilder();
      deleteGcpUserAccessBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteGcpUserAccessBindingOperationSettings = OperationCallSettings.newBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAccessPoliciesSettings,
              getAccessPolicySettings,
              createAccessPolicySettings,
              updateAccessPolicySettings,
              deleteAccessPolicySettings,
              listAccessLevelsSettings,
              getAccessLevelSettings,
              createAccessLevelSettings,
              updateAccessLevelSettings,
              deleteAccessLevelSettings,
              replaceAccessLevelsSettings,
              listServicePerimetersSettings,
              getServicePerimeterSettings,
              createServicePerimeterSettings,
              updateServicePerimeterSettings,
              deleteServicePerimeterSettings,
              replaceServicePerimetersSettings,
              commitServicePerimetersSettings,
              listGcpUserAccessBindingsSettings,
              getGcpUserAccessBindingSettings,
              createGcpUserAccessBindingSettings,
              updateGcpUserAccessBindingSettings,
              deleteGcpUserAccessBindingSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(AccessContextManagerStubSettings settings) {
      super(settings);

      listAccessPoliciesSettings = settings.listAccessPoliciesSettings.toBuilder();
      getAccessPolicySettings = settings.getAccessPolicySettings.toBuilder();
      createAccessPolicySettings = settings.createAccessPolicySettings.toBuilder();
      createAccessPolicyOperationSettings =
          settings.createAccessPolicyOperationSettings.toBuilder();
      updateAccessPolicySettings = settings.updateAccessPolicySettings.toBuilder();
      updateAccessPolicyOperationSettings =
          settings.updateAccessPolicyOperationSettings.toBuilder();
      deleteAccessPolicySettings = settings.deleteAccessPolicySettings.toBuilder();
      deleteAccessPolicyOperationSettings =
          settings.deleteAccessPolicyOperationSettings.toBuilder();
      listAccessLevelsSettings = settings.listAccessLevelsSettings.toBuilder();
      getAccessLevelSettings = settings.getAccessLevelSettings.toBuilder();
      createAccessLevelSettings = settings.createAccessLevelSettings.toBuilder();
      createAccessLevelOperationSettings = settings.createAccessLevelOperationSettings.toBuilder();
      updateAccessLevelSettings = settings.updateAccessLevelSettings.toBuilder();
      updateAccessLevelOperationSettings = settings.updateAccessLevelOperationSettings.toBuilder();
      deleteAccessLevelSettings = settings.deleteAccessLevelSettings.toBuilder();
      deleteAccessLevelOperationSettings = settings.deleteAccessLevelOperationSettings.toBuilder();
      replaceAccessLevelsSettings = settings.replaceAccessLevelsSettings.toBuilder();
      replaceAccessLevelsOperationSettings =
          settings.replaceAccessLevelsOperationSettings.toBuilder();
      listServicePerimetersSettings = settings.listServicePerimetersSettings.toBuilder();
      getServicePerimeterSettings = settings.getServicePerimeterSettings.toBuilder();
      createServicePerimeterSettings = settings.createServicePerimeterSettings.toBuilder();
      createServicePerimeterOperationSettings =
          settings.createServicePerimeterOperationSettings.toBuilder();
      updateServicePerimeterSettings = settings.updateServicePerimeterSettings.toBuilder();
      updateServicePerimeterOperationSettings =
          settings.updateServicePerimeterOperationSettings.toBuilder();
      deleteServicePerimeterSettings = settings.deleteServicePerimeterSettings.toBuilder();
      deleteServicePerimeterOperationSettings =
          settings.deleteServicePerimeterOperationSettings.toBuilder();
      replaceServicePerimetersSettings = settings.replaceServicePerimetersSettings.toBuilder();
      replaceServicePerimetersOperationSettings =
          settings.replaceServicePerimetersOperationSettings.toBuilder();
      commitServicePerimetersSettings = settings.commitServicePerimetersSettings.toBuilder();
      commitServicePerimetersOperationSettings =
          settings.commitServicePerimetersOperationSettings.toBuilder();
      listGcpUserAccessBindingsSettings = settings.listGcpUserAccessBindingsSettings.toBuilder();
      getGcpUserAccessBindingSettings = settings.getGcpUserAccessBindingSettings.toBuilder();
      createGcpUserAccessBindingSettings = settings.createGcpUserAccessBindingSettings.toBuilder();
      createGcpUserAccessBindingOperationSettings =
          settings.createGcpUserAccessBindingOperationSettings.toBuilder();
      updateGcpUserAccessBindingSettings = settings.updateGcpUserAccessBindingSettings.toBuilder();
      updateGcpUserAccessBindingOperationSettings =
          settings.updateGcpUserAccessBindingOperationSettings.toBuilder();
      deleteGcpUserAccessBindingSettings = settings.deleteGcpUserAccessBindingSettings.toBuilder();
      deleteGcpUserAccessBindingOperationSettings =
          settings.deleteGcpUserAccessBindingOperationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAccessPoliciesSettings,
              getAccessPolicySettings,
              createAccessPolicySettings,
              updateAccessPolicySettings,
              deleteAccessPolicySettings,
              listAccessLevelsSettings,
              getAccessLevelSettings,
              createAccessLevelSettings,
              updateAccessLevelSettings,
              deleteAccessLevelSettings,
              replaceAccessLevelsSettings,
              listServicePerimetersSettings,
              getServicePerimeterSettings,
              createServicePerimeterSettings,
              updateServicePerimeterSettings,
              deleteServicePerimeterSettings,
              replaceServicePerimetersSettings,
              commitServicePerimetersSettings,
              listGcpUserAccessBindingsSettings,
              getGcpUserAccessBindingSettings,
              createGcpUserAccessBindingSettings,
              updateGcpUserAccessBindingSettings,
              deleteGcpUserAccessBindingSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
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

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listAccessPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getAccessPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createAccessPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateAccessPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteAccessPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listAccessLevelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getAccessLevelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createAccessLevelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateAccessLevelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteAccessLevelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .replaceAccessLevelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listServicePerimetersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getServicePerimeterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createServicePerimeterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateServicePerimeterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteServicePerimeterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .replaceServicePerimetersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .commitServicePerimetersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listGcpUserAccessBindingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getGcpUserAccessBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createGcpUserAccessBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateGcpUserAccessBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteGcpUserAccessBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createAccessPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<AccessPolicy, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AccessPolicy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  AccessContextManagerOperationMetadata.class))
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
          .updateAccessPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateAccessPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AccessPolicy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  AccessContextManagerOperationMetadata.class))
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
          .deleteAccessPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteAccessPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  AccessContextManagerOperationMetadata.class))
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
          .createAccessLevelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAccessLevelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AccessLevel.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  AccessContextManagerOperationMetadata.class))
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
          .updateAccessLevelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateAccessLevelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AccessLevel.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  AccessContextManagerOperationMetadata.class))
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
          .deleteAccessLevelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteAccessLevelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  AccessContextManagerOperationMetadata.class))
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
          .replaceAccessLevelsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ReplaceAccessLevelsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ReplaceAccessLevelsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  AccessContextManagerOperationMetadata.class))
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
          .createServicePerimeterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateServicePerimeterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ServicePerimeter.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  AccessContextManagerOperationMetadata.class))
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
          .updateServicePerimeterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateServicePerimeterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ServicePerimeter.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  AccessContextManagerOperationMetadata.class))
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
          .deleteServicePerimeterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteServicePerimeterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  AccessContextManagerOperationMetadata.class))
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
          .replaceServicePerimetersOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ReplaceServicePerimetersRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ReplaceServicePerimetersResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  AccessContextManagerOperationMetadata.class))
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
          .commitServicePerimetersOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CommitServicePerimetersRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  CommitServicePerimetersResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  AccessContextManagerOperationMetadata.class))
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
          .createGcpUserAccessBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateGcpUserAccessBindingRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(GcpUserAccessBinding.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  GcpUserAccessBindingOperationMetadata.class))
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
          .updateGcpUserAccessBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateGcpUserAccessBindingRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(GcpUserAccessBinding.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  GcpUserAccessBindingOperationMetadata.class))
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
          .deleteGcpUserAccessBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteGcpUserAccessBindingRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  GcpUserAccessBindingOperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to listAccessPolicies. */
    public PagedCallSettings.Builder<
            ListAccessPoliciesRequest, ListAccessPoliciesResponse, ListAccessPoliciesPagedResponse>
        listAccessPoliciesSettings() {
      return listAccessPoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to getAccessPolicy. */
    public UnaryCallSettings.Builder<GetAccessPolicyRequest, AccessPolicy>
        getAccessPolicySettings() {
      return getAccessPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createAccessPolicy. */
    public UnaryCallSettings.Builder<AccessPolicy, Operation> createAccessPolicySettings() {
      return createAccessPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createAccessPolicy. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            AccessPolicy, AccessPolicy, AccessContextManagerOperationMetadata>
        createAccessPolicyOperationSettings() {
      return createAccessPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateAccessPolicy. */
    public UnaryCallSettings.Builder<UpdateAccessPolicyRequest, Operation>
        updateAccessPolicySettings() {
      return updateAccessPolicySettings;
    }

    /** Returns the builder for the settings used for calls to updateAccessPolicy. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateAccessPolicyRequest, AccessPolicy, AccessContextManagerOperationMetadata>
        updateAccessPolicyOperationSettings() {
      return updateAccessPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAccessPolicy. */
    public UnaryCallSettings.Builder<DeleteAccessPolicyRequest, Operation>
        deleteAccessPolicySettings() {
      return deleteAccessPolicySettings;
    }

    /** Returns the builder for the settings used for calls to deleteAccessPolicy. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeleteAccessPolicyRequest, Empty, AccessContextManagerOperationMetadata>
        deleteAccessPolicyOperationSettings() {
      return deleteAccessPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listAccessLevels. */
    public PagedCallSettings.Builder<
            ListAccessLevelsRequest, ListAccessLevelsResponse, ListAccessLevelsPagedResponse>
        listAccessLevelsSettings() {
      return listAccessLevelsSettings;
    }

    /** Returns the builder for the settings used for calls to getAccessLevel. */
    public UnaryCallSettings.Builder<GetAccessLevelRequest, AccessLevel> getAccessLevelSettings() {
      return getAccessLevelSettings;
    }

    /** Returns the builder for the settings used for calls to createAccessLevel. */
    public UnaryCallSettings.Builder<CreateAccessLevelRequest, Operation>
        createAccessLevelSettings() {
      return createAccessLevelSettings;
    }

    /** Returns the builder for the settings used for calls to createAccessLevel. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateAccessLevelRequest, AccessLevel, AccessContextManagerOperationMetadata>
        createAccessLevelOperationSettings() {
      return createAccessLevelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateAccessLevel. */
    public UnaryCallSettings.Builder<UpdateAccessLevelRequest, Operation>
        updateAccessLevelSettings() {
      return updateAccessLevelSettings;
    }

    /** Returns the builder for the settings used for calls to updateAccessLevel. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateAccessLevelRequest, AccessLevel, AccessContextManagerOperationMetadata>
        updateAccessLevelOperationSettings() {
      return updateAccessLevelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAccessLevel. */
    public UnaryCallSettings.Builder<DeleteAccessLevelRequest, Operation>
        deleteAccessLevelSettings() {
      return deleteAccessLevelSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAccessLevel. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeleteAccessLevelRequest, Empty, AccessContextManagerOperationMetadata>
        deleteAccessLevelOperationSettings() {
      return deleteAccessLevelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to replaceAccessLevels. */
    public UnaryCallSettings.Builder<ReplaceAccessLevelsRequest, Operation>
        replaceAccessLevelsSettings() {
      return replaceAccessLevelsSettings;
    }

    /** Returns the builder for the settings used for calls to replaceAccessLevels. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ReplaceAccessLevelsRequest,
            ReplaceAccessLevelsResponse,
            AccessContextManagerOperationMetadata>
        replaceAccessLevelsOperationSettings() {
      return replaceAccessLevelsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listServicePerimeters. */
    public PagedCallSettings.Builder<
            ListServicePerimetersRequest,
            ListServicePerimetersResponse,
            ListServicePerimetersPagedResponse>
        listServicePerimetersSettings() {
      return listServicePerimetersSettings;
    }

    /** Returns the builder for the settings used for calls to getServicePerimeter. */
    public UnaryCallSettings.Builder<GetServicePerimeterRequest, ServicePerimeter>
        getServicePerimeterSettings() {
      return getServicePerimeterSettings;
    }

    /** Returns the builder for the settings used for calls to createServicePerimeter. */
    public UnaryCallSettings.Builder<CreateServicePerimeterRequest, Operation>
        createServicePerimeterSettings() {
      return createServicePerimeterSettings;
    }

    /** Returns the builder for the settings used for calls to createServicePerimeter. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateServicePerimeterRequest, ServicePerimeter, AccessContextManagerOperationMetadata>
        createServicePerimeterOperationSettings() {
      return createServicePerimeterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateServicePerimeter. */
    public UnaryCallSettings.Builder<UpdateServicePerimeterRequest, Operation>
        updateServicePerimeterSettings() {
      return updateServicePerimeterSettings;
    }

    /** Returns the builder for the settings used for calls to updateServicePerimeter. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateServicePerimeterRequest, ServicePerimeter, AccessContextManagerOperationMetadata>
        updateServicePerimeterOperationSettings() {
      return updateServicePerimeterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteServicePerimeter. */
    public UnaryCallSettings.Builder<DeleteServicePerimeterRequest, Operation>
        deleteServicePerimeterSettings() {
      return deleteServicePerimeterSettings;
    }

    /** Returns the builder for the settings used for calls to deleteServicePerimeter. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeleteServicePerimeterRequest, Empty, AccessContextManagerOperationMetadata>
        deleteServicePerimeterOperationSettings() {
      return deleteServicePerimeterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to replaceServicePerimeters. */
    public UnaryCallSettings.Builder<ReplaceServicePerimetersRequest, Operation>
        replaceServicePerimetersSettings() {
      return replaceServicePerimetersSettings;
    }

    /** Returns the builder for the settings used for calls to replaceServicePerimeters. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ReplaceServicePerimetersRequest,
            ReplaceServicePerimetersResponse,
            AccessContextManagerOperationMetadata>
        replaceServicePerimetersOperationSettings() {
      return replaceServicePerimetersOperationSettings;
    }

    /** Returns the builder for the settings used for calls to commitServicePerimeters. */
    public UnaryCallSettings.Builder<CommitServicePerimetersRequest, Operation>
        commitServicePerimetersSettings() {
      return commitServicePerimetersSettings;
    }

    /** Returns the builder for the settings used for calls to commitServicePerimeters. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CommitServicePerimetersRequest,
            CommitServicePerimetersResponse,
            AccessContextManagerOperationMetadata>
        commitServicePerimetersOperationSettings() {
      return commitServicePerimetersOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listGcpUserAccessBindings. */
    public PagedCallSettings.Builder<
            ListGcpUserAccessBindingsRequest,
            ListGcpUserAccessBindingsResponse,
            ListGcpUserAccessBindingsPagedResponse>
        listGcpUserAccessBindingsSettings() {
      return listGcpUserAccessBindingsSettings;
    }

    /** Returns the builder for the settings used for calls to getGcpUserAccessBinding. */
    public UnaryCallSettings.Builder<GetGcpUserAccessBindingRequest, GcpUserAccessBinding>
        getGcpUserAccessBindingSettings() {
      return getGcpUserAccessBindingSettings;
    }

    /** Returns the builder for the settings used for calls to createGcpUserAccessBinding. */
    public UnaryCallSettings.Builder<CreateGcpUserAccessBindingRequest, Operation>
        createGcpUserAccessBindingSettings() {
      return createGcpUserAccessBindingSettings;
    }

    /** Returns the builder for the settings used for calls to createGcpUserAccessBinding. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateGcpUserAccessBindingRequest,
            GcpUserAccessBinding,
            GcpUserAccessBindingOperationMetadata>
        createGcpUserAccessBindingOperationSettings() {
      return createGcpUserAccessBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateGcpUserAccessBinding. */
    public UnaryCallSettings.Builder<UpdateGcpUserAccessBindingRequest, Operation>
        updateGcpUserAccessBindingSettings() {
      return updateGcpUserAccessBindingSettings;
    }

    /** Returns the builder for the settings used for calls to updateGcpUserAccessBinding. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateGcpUserAccessBindingRequest,
            GcpUserAccessBinding,
            GcpUserAccessBindingOperationMetadata>
        updateGcpUserAccessBindingOperationSettings() {
      return updateGcpUserAccessBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGcpUserAccessBinding. */
    public UnaryCallSettings.Builder<DeleteGcpUserAccessBindingRequest, Operation>
        deleteGcpUserAccessBindingSettings() {
      return deleteGcpUserAccessBindingSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGcpUserAccessBinding. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeleteGcpUserAccessBindingRequest, Empty, GcpUserAccessBindingOperationMetadata>
        deleteGcpUserAccessBindingOperationSettings() {
      return deleteGcpUserAccessBindingOperationSettings;
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
    public AccessContextManagerStubSettings build() throws IOException {
      return new AccessContextManagerStubSettings(this);
    }
  }
}
