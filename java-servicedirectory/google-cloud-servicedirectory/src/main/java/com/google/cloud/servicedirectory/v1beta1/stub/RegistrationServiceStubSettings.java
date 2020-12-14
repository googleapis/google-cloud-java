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

package com.google.cloud.servicedirectory.v1beta1.stub;

import static com.google.cloud.servicedirectory.v1beta1.RegistrationServiceClient.ListEndpointsPagedResponse;
import static com.google.cloud.servicedirectory.v1beta1.RegistrationServiceClient.ListNamespacesPagedResponse;
import static com.google.cloud.servicedirectory.v1beta1.RegistrationServiceClient.ListServicesPagedResponse;

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
import com.google.cloud.servicedirectory.v1beta1.CreateEndpointRequest;
import com.google.cloud.servicedirectory.v1beta1.CreateNamespaceRequest;
import com.google.cloud.servicedirectory.v1beta1.CreateServiceRequest;
import com.google.cloud.servicedirectory.v1beta1.DeleteEndpointRequest;
import com.google.cloud.servicedirectory.v1beta1.DeleteNamespaceRequest;
import com.google.cloud.servicedirectory.v1beta1.DeleteServiceRequest;
import com.google.cloud.servicedirectory.v1beta1.Endpoint;
import com.google.cloud.servicedirectory.v1beta1.GetEndpointRequest;
import com.google.cloud.servicedirectory.v1beta1.GetNamespaceRequest;
import com.google.cloud.servicedirectory.v1beta1.GetServiceRequest;
import com.google.cloud.servicedirectory.v1beta1.ListEndpointsRequest;
import com.google.cloud.servicedirectory.v1beta1.ListEndpointsResponse;
import com.google.cloud.servicedirectory.v1beta1.ListNamespacesRequest;
import com.google.cloud.servicedirectory.v1beta1.ListNamespacesResponse;
import com.google.cloud.servicedirectory.v1beta1.ListServicesRequest;
import com.google.cloud.servicedirectory.v1beta1.ListServicesResponse;
import com.google.cloud.servicedirectory.v1beta1.Namespace;
import com.google.cloud.servicedirectory.v1beta1.Service;
import com.google.cloud.servicedirectory.v1beta1.UpdateEndpointRequest;
import com.google.cloud.servicedirectory.v1beta1.UpdateNamespaceRequest;
import com.google.cloud.servicedirectory.v1beta1.UpdateServiceRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RegistrationServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (servicedirectory.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createNamespace to 30 seconds:
 *
 * <pre>{@code
 * RegistrationServiceStubSettings.Builder registrationServiceSettingsBuilder =
 *     RegistrationServiceStubSettings.newBuilder();
 * registrationServiceSettingsBuilder
 *     .createNamespaceSettings()
 *     .setRetrySettings(
 *         registrationServiceSettingsBuilder
 *             .createNamespaceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RegistrationServiceStubSettings registrationServiceSettings =
 *     registrationServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class RegistrationServiceStubSettings extends StubSettings<RegistrationServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateNamespaceRequest, Namespace> createNamespaceSettings;
  private final PagedCallSettings<
          ListNamespacesRequest, ListNamespacesResponse, ListNamespacesPagedResponse>
      listNamespacesSettings;
  private final UnaryCallSettings<GetNamespaceRequest, Namespace> getNamespaceSettings;
  private final UnaryCallSettings<UpdateNamespaceRequest, Namespace> updateNamespaceSettings;
  private final UnaryCallSettings<DeleteNamespaceRequest, Empty> deleteNamespaceSettings;
  private final UnaryCallSettings<CreateServiceRequest, Service> createServiceSettings;
  private final PagedCallSettings<
          ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      listServicesSettings;
  private final UnaryCallSettings<GetServiceRequest, Service> getServiceSettings;
  private final UnaryCallSettings<UpdateServiceRequest, Service> updateServiceSettings;
  private final UnaryCallSettings<DeleteServiceRequest, Empty> deleteServiceSettings;
  private final UnaryCallSettings<CreateEndpointRequest, Endpoint> createEndpointSettings;
  private final PagedCallSettings<
          ListEndpointsRequest, ListEndpointsResponse, ListEndpointsPagedResponse>
      listEndpointsSettings;
  private final UnaryCallSettings<GetEndpointRequest, Endpoint> getEndpointSettings;
  private final UnaryCallSettings<UpdateEndpointRequest, Endpoint> updateEndpointSettings;
  private final UnaryCallSettings<DeleteEndpointRequest, Empty> deleteEndpointSettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<ListNamespacesRequest, ListNamespacesResponse, Namespace>
      LIST_NAMESPACES_PAGE_STR_DESC =
          new PagedListDescriptor<ListNamespacesRequest, ListNamespacesResponse, Namespace>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNamespacesRequest injectToken(ListNamespacesRequest payload, String token) {
              return ListNamespacesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNamespacesRequest injectPageSize(
                ListNamespacesRequest payload, int pageSize) {
              return ListNamespacesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListNamespacesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNamespacesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Namespace> extractResources(ListNamespacesResponse payload) {
              return payload.getNamespacesList() == null
                  ? ImmutableList.<Namespace>of()
                  : payload.getNamespacesList();
            }
          };

  private static final PagedListDescriptor<ListServicesRequest, ListServicesResponse, Service>
      LIST_SERVICES_PAGE_STR_DESC =
          new PagedListDescriptor<ListServicesRequest, ListServicesResponse, Service>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListServicesRequest injectToken(ListServicesRequest payload, String token) {
              return ListServicesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListServicesRequest injectPageSize(ListServicesRequest payload, int pageSize) {
              return ListServicesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListServicesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListServicesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Service> extractResources(ListServicesResponse payload) {
              return payload.getServicesList() == null
                  ? ImmutableList.<Service>of()
                  : payload.getServicesList();
            }
          };

  private static final PagedListDescriptor<ListEndpointsRequest, ListEndpointsResponse, Endpoint>
      LIST_ENDPOINTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListEndpointsRequest, ListEndpointsResponse, Endpoint>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEndpointsRequest injectToken(ListEndpointsRequest payload, String token) {
              return ListEndpointsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEndpointsRequest injectPageSize(ListEndpointsRequest payload, int pageSize) {
              return ListEndpointsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEndpointsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEndpointsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Endpoint> extractResources(ListEndpointsResponse payload) {
              return payload.getEndpointsList() == null
                  ? ImmutableList.<Endpoint>of()
                  : payload.getEndpointsList();
            }
          };

  private static final PagedListResponseFactory<
          ListNamespacesRequest, ListNamespacesResponse, ListNamespacesPagedResponse>
      LIST_NAMESPACES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNamespacesRequest, ListNamespacesResponse, ListNamespacesPagedResponse>() {
            @Override
            public ApiFuture<ListNamespacesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNamespacesRequest, ListNamespacesResponse> callable,
                ListNamespacesRequest request,
                ApiCallContext context,
                ApiFuture<ListNamespacesResponse> futureResponse) {
              PageContext<ListNamespacesRequest, ListNamespacesResponse, Namespace> pageContext =
                  PageContext.create(callable, LIST_NAMESPACES_PAGE_STR_DESC, request, context);
              return ListNamespacesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      LIST_SERVICES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>() {
            @Override
            public ApiFuture<ListServicesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListServicesRequest, ListServicesResponse> callable,
                ListServicesRequest request,
                ApiCallContext context,
                ApiFuture<ListServicesResponse> futureResponse) {
              PageContext<ListServicesRequest, ListServicesResponse, Service> pageContext =
                  PageContext.create(callable, LIST_SERVICES_PAGE_STR_DESC, request, context);
              return ListServicesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListEndpointsRequest, ListEndpointsResponse, ListEndpointsPagedResponse>
      LIST_ENDPOINTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEndpointsRequest, ListEndpointsResponse, ListEndpointsPagedResponse>() {
            @Override
            public ApiFuture<ListEndpointsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEndpointsRequest, ListEndpointsResponse> callable,
                ListEndpointsRequest request,
                ApiCallContext context,
                ApiFuture<ListEndpointsResponse> futureResponse) {
              PageContext<ListEndpointsRequest, ListEndpointsResponse, Endpoint> pageContext =
                  PageContext.create(callable, LIST_ENDPOINTS_PAGE_STR_DESC, request, context);
              return ListEndpointsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createNamespace. */
  public UnaryCallSettings<CreateNamespaceRequest, Namespace> createNamespaceSettings() {
    return createNamespaceSettings;
  }

  /** Returns the object with the settings used for calls to listNamespaces. */
  public PagedCallSettings<
          ListNamespacesRequest, ListNamespacesResponse, ListNamespacesPagedResponse>
      listNamespacesSettings() {
    return listNamespacesSettings;
  }

  /** Returns the object with the settings used for calls to getNamespace. */
  public UnaryCallSettings<GetNamespaceRequest, Namespace> getNamespaceSettings() {
    return getNamespaceSettings;
  }

  /** Returns the object with the settings used for calls to updateNamespace. */
  public UnaryCallSettings<UpdateNamespaceRequest, Namespace> updateNamespaceSettings() {
    return updateNamespaceSettings;
  }

  /** Returns the object with the settings used for calls to deleteNamespace. */
  public UnaryCallSettings<DeleteNamespaceRequest, Empty> deleteNamespaceSettings() {
    return deleteNamespaceSettings;
  }

  /** Returns the object with the settings used for calls to createService. */
  public UnaryCallSettings<CreateServiceRequest, Service> createServiceSettings() {
    return createServiceSettings;
  }

  /** Returns the object with the settings used for calls to listServices. */
  public PagedCallSettings<ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      listServicesSettings() {
    return listServicesSettings;
  }

  /** Returns the object with the settings used for calls to getService. */
  public UnaryCallSettings<GetServiceRequest, Service> getServiceSettings() {
    return getServiceSettings;
  }

  /** Returns the object with the settings used for calls to updateService. */
  public UnaryCallSettings<UpdateServiceRequest, Service> updateServiceSettings() {
    return updateServiceSettings;
  }

  /** Returns the object with the settings used for calls to deleteService. */
  public UnaryCallSettings<DeleteServiceRequest, Empty> deleteServiceSettings() {
    return deleteServiceSettings;
  }

  /** Returns the object with the settings used for calls to createEndpoint. */
  public UnaryCallSettings<CreateEndpointRequest, Endpoint> createEndpointSettings() {
    return createEndpointSettings;
  }

  /** Returns the object with the settings used for calls to listEndpoints. */
  public PagedCallSettings<ListEndpointsRequest, ListEndpointsResponse, ListEndpointsPagedResponse>
      listEndpointsSettings() {
    return listEndpointsSettings;
  }

  /** Returns the object with the settings used for calls to getEndpoint. */
  public UnaryCallSettings<GetEndpointRequest, Endpoint> getEndpointSettings() {
    return getEndpointSettings;
  }

  /** Returns the object with the settings used for calls to updateEndpoint. */
  public UnaryCallSettings<UpdateEndpointRequest, Endpoint> updateEndpointSettings() {
    return updateEndpointSettings;
  }

  /** Returns the object with the settings used for calls to deleteEndpoint. */
  public UnaryCallSettings<DeleteEndpointRequest, Empty> deleteEndpointSettings() {
    return deleteEndpointSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
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

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegistrationServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcRegistrationServiceStub.create(this);
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
    return "servicedirectory.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(RegistrationServiceStubSettings.class))
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

  protected RegistrationServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createNamespaceSettings = settingsBuilder.createNamespaceSettings().build();
    listNamespacesSettings = settingsBuilder.listNamespacesSettings().build();
    getNamespaceSettings = settingsBuilder.getNamespaceSettings().build();
    updateNamespaceSettings = settingsBuilder.updateNamespaceSettings().build();
    deleteNamespaceSettings = settingsBuilder.deleteNamespaceSettings().build();
    createServiceSettings = settingsBuilder.createServiceSettings().build();
    listServicesSettings = settingsBuilder.listServicesSettings().build();
    getServiceSettings = settingsBuilder.getServiceSettings().build();
    updateServiceSettings = settingsBuilder.updateServiceSettings().build();
    deleteServiceSettings = settingsBuilder.deleteServiceSettings().build();
    createEndpointSettings = settingsBuilder.createEndpointSettings().build();
    listEndpointsSettings = settingsBuilder.listEndpointsSettings().build();
    getEndpointSettings = settingsBuilder.getEndpointSettings().build();
    updateEndpointSettings = settingsBuilder.updateEndpointSettings().build();
    deleteEndpointSettings = settingsBuilder.deleteEndpointSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for RegistrationServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<RegistrationServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateNamespaceRequest, Namespace>
        createNamespaceSettings;
    private final PagedCallSettings.Builder<
            ListNamespacesRequest, ListNamespacesResponse, ListNamespacesPagedResponse>
        listNamespacesSettings;
    private final UnaryCallSettings.Builder<GetNamespaceRequest, Namespace> getNamespaceSettings;
    private final UnaryCallSettings.Builder<UpdateNamespaceRequest, Namespace>
        updateNamespaceSettings;
    private final UnaryCallSettings.Builder<DeleteNamespaceRequest, Empty> deleteNamespaceSettings;
    private final UnaryCallSettings.Builder<CreateServiceRequest, Service> createServiceSettings;
    private final PagedCallSettings.Builder<
            ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
        listServicesSettings;
    private final UnaryCallSettings.Builder<GetServiceRequest, Service> getServiceSettings;
    private final UnaryCallSettings.Builder<UpdateServiceRequest, Service> updateServiceSettings;
    private final UnaryCallSettings.Builder<DeleteServiceRequest, Empty> deleteServiceSettings;
    private final UnaryCallSettings.Builder<CreateEndpointRequest, Endpoint> createEndpointSettings;
    private final PagedCallSettings.Builder<
            ListEndpointsRequest, ListEndpointsResponse, ListEndpointsPagedResponse>
        listEndpointsSettings;
    private final UnaryCallSettings.Builder<GetEndpointRequest, Endpoint> getEndpointSettings;
    private final UnaryCallSettings.Builder<UpdateEndpointRequest, Endpoint> updateEndpointSettings;
    private final UnaryCallSettings.Builder<DeleteEndpointRequest, Empty> deleteEndpointSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.UNKNOWN)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(15000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(15000L))
              .setTotalTimeout(Duration.ofMillis(15000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createNamespaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listNamespacesSettings = PagedCallSettings.newBuilder(LIST_NAMESPACES_PAGE_STR_FACT);
      getNamespaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateNamespaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteNamespaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listServicesSettings = PagedCallSettings.newBuilder(LIST_SERVICES_PAGE_STR_FACT);
      getServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEndpointSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listEndpointsSettings = PagedCallSettings.newBuilder(LIST_ENDPOINTS_PAGE_STR_FACT);
      getEndpointSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEndpointSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEndpointSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createNamespaceSettings,
              listNamespacesSettings,
              getNamespaceSettings,
              updateNamespaceSettings,
              deleteNamespaceSettings,
              createServiceSettings,
              listServicesSettings,
              getServiceSettings,
              updateServiceSettings,
              deleteServiceSettings,
              createEndpointSettings,
              listEndpointsSettings,
              getEndpointSettings,
              updateEndpointSettings,
              deleteEndpointSettings,
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(RegistrationServiceStubSettings settings) {
      super(settings);

      createNamespaceSettings = settings.createNamespaceSettings.toBuilder();
      listNamespacesSettings = settings.listNamespacesSettings.toBuilder();
      getNamespaceSettings = settings.getNamespaceSettings.toBuilder();
      updateNamespaceSettings = settings.updateNamespaceSettings.toBuilder();
      deleteNamespaceSettings = settings.deleteNamespaceSettings.toBuilder();
      createServiceSettings = settings.createServiceSettings.toBuilder();
      listServicesSettings = settings.listServicesSettings.toBuilder();
      getServiceSettings = settings.getServiceSettings.toBuilder();
      updateServiceSettings = settings.updateServiceSettings.toBuilder();
      deleteServiceSettings = settings.deleteServiceSettings.toBuilder();
      createEndpointSettings = settings.createEndpointSettings.toBuilder();
      listEndpointsSettings = settings.listEndpointsSettings.toBuilder();
      getEndpointSettings = settings.getEndpointSettings.toBuilder();
      updateEndpointSettings = settings.updateEndpointSettings.toBuilder();
      deleteEndpointSettings = settings.deleteEndpointSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createNamespaceSettings,
              listNamespacesSettings,
              getNamespaceSettings,
              updateNamespaceSettings,
              deleteNamespaceSettings,
              createServiceSettings,
              listServicesSettings,
              getServiceSettings,
              updateServiceSettings,
              deleteServiceSettings,
              createEndpointSettings,
              listEndpointsSettings,
              getEndpointSettings,
              updateEndpointSettings,
              deleteEndpointSettings,
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings);
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
          .createNamespaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listNamespacesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getNamespaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateNamespaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteNamespaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listServicesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createEndpointSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listEndpointsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getEndpointSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateEndpointSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteEndpointSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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

    /** Returns the builder for the settings used for calls to createNamespace. */
    public UnaryCallSettings.Builder<CreateNamespaceRequest, Namespace> createNamespaceSettings() {
      return createNamespaceSettings;
    }

    /** Returns the builder for the settings used for calls to listNamespaces. */
    public PagedCallSettings.Builder<
            ListNamespacesRequest, ListNamespacesResponse, ListNamespacesPagedResponse>
        listNamespacesSettings() {
      return listNamespacesSettings;
    }

    /** Returns the builder for the settings used for calls to getNamespace. */
    public UnaryCallSettings.Builder<GetNamespaceRequest, Namespace> getNamespaceSettings() {
      return getNamespaceSettings;
    }

    /** Returns the builder for the settings used for calls to updateNamespace. */
    public UnaryCallSettings.Builder<UpdateNamespaceRequest, Namespace> updateNamespaceSettings() {
      return updateNamespaceSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNamespace. */
    public UnaryCallSettings.Builder<DeleteNamespaceRequest, Empty> deleteNamespaceSettings() {
      return deleteNamespaceSettings;
    }

    /** Returns the builder for the settings used for calls to createService. */
    public UnaryCallSettings.Builder<CreateServiceRequest, Service> createServiceSettings() {
      return createServiceSettings;
    }

    /** Returns the builder for the settings used for calls to listServices. */
    public PagedCallSettings.Builder<
            ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
        listServicesSettings() {
      return listServicesSettings;
    }

    /** Returns the builder for the settings used for calls to getService. */
    public UnaryCallSettings.Builder<GetServiceRequest, Service> getServiceSettings() {
      return getServiceSettings;
    }

    /** Returns the builder for the settings used for calls to updateService. */
    public UnaryCallSettings.Builder<UpdateServiceRequest, Service> updateServiceSettings() {
      return updateServiceSettings;
    }

    /** Returns the builder for the settings used for calls to deleteService. */
    public UnaryCallSettings.Builder<DeleteServiceRequest, Empty> deleteServiceSettings() {
      return deleteServiceSettings;
    }

    /** Returns the builder for the settings used for calls to createEndpoint. */
    public UnaryCallSettings.Builder<CreateEndpointRequest, Endpoint> createEndpointSettings() {
      return createEndpointSettings;
    }

    /** Returns the builder for the settings used for calls to listEndpoints. */
    public PagedCallSettings.Builder<
            ListEndpointsRequest, ListEndpointsResponse, ListEndpointsPagedResponse>
        listEndpointsSettings() {
      return listEndpointsSettings;
    }

    /** Returns the builder for the settings used for calls to getEndpoint. */
    public UnaryCallSettings.Builder<GetEndpointRequest, Endpoint> getEndpointSettings() {
      return getEndpointSettings;
    }

    /** Returns the builder for the settings used for calls to updateEndpoint. */
    public UnaryCallSettings.Builder<UpdateEndpointRequest, Endpoint> updateEndpointSettings() {
      return updateEndpointSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEndpoint. */
    public UnaryCallSettings.Builder<DeleteEndpointRequest, Empty> deleteEndpointSettings() {
      return deleteEndpointSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
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

    @Override
    public RegistrationServiceStubSettings build() throws IOException {
      return new RegistrationServiceStubSettings(this);
    }
  }
}
