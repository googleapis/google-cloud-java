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

package com.google.cloud.apphub.v1.stub;

import static com.google.cloud.apphub.v1.AppHubClient.ListApplicationsPagedResponse;
import static com.google.cloud.apphub.v1.AppHubClient.ListDiscoveredServicesPagedResponse;
import static com.google.cloud.apphub.v1.AppHubClient.ListDiscoveredWorkloadsPagedResponse;
import static com.google.cloud.apphub.v1.AppHubClient.ListLocationsPagedResponse;
import static com.google.cloud.apphub.v1.AppHubClient.ListServiceProjectAttachmentsPagedResponse;
import static com.google.cloud.apphub.v1.AppHubClient.ListServicesPagedResponse;
import static com.google.cloud.apphub.v1.AppHubClient.ListWorkloadsPagedResponse;

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
import com.google.cloud.apphub.v1.Application;
import com.google.cloud.apphub.v1.CreateApplicationRequest;
import com.google.cloud.apphub.v1.CreateServiceProjectAttachmentRequest;
import com.google.cloud.apphub.v1.CreateServiceRequest;
import com.google.cloud.apphub.v1.CreateWorkloadRequest;
import com.google.cloud.apphub.v1.DeleteApplicationRequest;
import com.google.cloud.apphub.v1.DeleteServiceProjectAttachmentRequest;
import com.google.cloud.apphub.v1.DeleteServiceRequest;
import com.google.cloud.apphub.v1.DeleteWorkloadRequest;
import com.google.cloud.apphub.v1.DetachServiceProjectAttachmentRequest;
import com.google.cloud.apphub.v1.DetachServiceProjectAttachmentResponse;
import com.google.cloud.apphub.v1.DiscoveredService;
import com.google.cloud.apphub.v1.DiscoveredWorkload;
import com.google.cloud.apphub.v1.GetApplicationRequest;
import com.google.cloud.apphub.v1.GetDiscoveredServiceRequest;
import com.google.cloud.apphub.v1.GetDiscoveredWorkloadRequest;
import com.google.cloud.apphub.v1.GetServiceProjectAttachmentRequest;
import com.google.cloud.apphub.v1.GetServiceRequest;
import com.google.cloud.apphub.v1.GetWorkloadRequest;
import com.google.cloud.apphub.v1.ListApplicationsRequest;
import com.google.cloud.apphub.v1.ListApplicationsResponse;
import com.google.cloud.apphub.v1.ListDiscoveredServicesRequest;
import com.google.cloud.apphub.v1.ListDiscoveredServicesResponse;
import com.google.cloud.apphub.v1.ListDiscoveredWorkloadsRequest;
import com.google.cloud.apphub.v1.ListDiscoveredWorkloadsResponse;
import com.google.cloud.apphub.v1.ListServiceProjectAttachmentsRequest;
import com.google.cloud.apphub.v1.ListServiceProjectAttachmentsResponse;
import com.google.cloud.apphub.v1.ListServicesRequest;
import com.google.cloud.apphub.v1.ListServicesResponse;
import com.google.cloud.apphub.v1.ListWorkloadsRequest;
import com.google.cloud.apphub.v1.ListWorkloadsResponse;
import com.google.cloud.apphub.v1.LookupDiscoveredServiceRequest;
import com.google.cloud.apphub.v1.LookupDiscoveredServiceResponse;
import com.google.cloud.apphub.v1.LookupDiscoveredWorkloadRequest;
import com.google.cloud.apphub.v1.LookupDiscoveredWorkloadResponse;
import com.google.cloud.apphub.v1.LookupServiceProjectAttachmentRequest;
import com.google.cloud.apphub.v1.LookupServiceProjectAttachmentResponse;
import com.google.cloud.apphub.v1.OperationMetadata;
import com.google.cloud.apphub.v1.Service;
import com.google.cloud.apphub.v1.ServiceProjectAttachment;
import com.google.cloud.apphub.v1.UpdateApplicationRequest;
import com.google.cloud.apphub.v1.UpdateServiceRequest;
import com.google.cloud.apphub.v1.UpdateWorkloadRequest;
import com.google.cloud.apphub.v1.Workload;
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
 * Settings class to configure an instance of {@link AppHubStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (apphub.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of lookupServiceProjectAttachment to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AppHubStubSettings.Builder appHubSettingsBuilder = AppHubStubSettings.newBuilder();
 * appHubSettingsBuilder
 *     .lookupServiceProjectAttachmentSettings()
 *     .setRetrySettings(
 *         appHubSettingsBuilder
 *             .lookupServiceProjectAttachmentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AppHubStubSettings appHubSettings = appHubSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AppHubStubSettings extends StubSettings<AppHubStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<
          LookupServiceProjectAttachmentRequest, LookupServiceProjectAttachmentResponse>
      lookupServiceProjectAttachmentSettings;
  private final PagedCallSettings<
          ListServiceProjectAttachmentsRequest,
          ListServiceProjectAttachmentsResponse,
          ListServiceProjectAttachmentsPagedResponse>
      listServiceProjectAttachmentsSettings;
  private final UnaryCallSettings<CreateServiceProjectAttachmentRequest, Operation>
      createServiceProjectAttachmentSettings;
  private final OperationCallSettings<
          CreateServiceProjectAttachmentRequest, ServiceProjectAttachment, OperationMetadata>
      createServiceProjectAttachmentOperationSettings;
  private final UnaryCallSettings<GetServiceProjectAttachmentRequest, ServiceProjectAttachment>
      getServiceProjectAttachmentSettings;
  private final UnaryCallSettings<DeleteServiceProjectAttachmentRequest, Operation>
      deleteServiceProjectAttachmentSettings;
  private final OperationCallSettings<
          DeleteServiceProjectAttachmentRequest, Empty, OperationMetadata>
      deleteServiceProjectAttachmentOperationSettings;
  private final UnaryCallSettings<
          DetachServiceProjectAttachmentRequest, DetachServiceProjectAttachmentResponse>
      detachServiceProjectAttachmentSettings;
  private final PagedCallSettings<
          ListDiscoveredServicesRequest,
          ListDiscoveredServicesResponse,
          ListDiscoveredServicesPagedResponse>
      listDiscoveredServicesSettings;
  private final UnaryCallSettings<GetDiscoveredServiceRequest, DiscoveredService>
      getDiscoveredServiceSettings;
  private final UnaryCallSettings<LookupDiscoveredServiceRequest, LookupDiscoveredServiceResponse>
      lookupDiscoveredServiceSettings;
  private final PagedCallSettings<
          ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      listServicesSettings;
  private final UnaryCallSettings<CreateServiceRequest, Operation> createServiceSettings;
  private final OperationCallSettings<CreateServiceRequest, Service, OperationMetadata>
      createServiceOperationSettings;
  private final UnaryCallSettings<GetServiceRequest, Service> getServiceSettings;
  private final UnaryCallSettings<UpdateServiceRequest, Operation> updateServiceSettings;
  private final OperationCallSettings<UpdateServiceRequest, Service, OperationMetadata>
      updateServiceOperationSettings;
  private final UnaryCallSettings<DeleteServiceRequest, Operation> deleteServiceSettings;
  private final OperationCallSettings<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationSettings;
  private final PagedCallSettings<
          ListDiscoveredWorkloadsRequest,
          ListDiscoveredWorkloadsResponse,
          ListDiscoveredWorkloadsPagedResponse>
      listDiscoveredWorkloadsSettings;
  private final UnaryCallSettings<GetDiscoveredWorkloadRequest, DiscoveredWorkload>
      getDiscoveredWorkloadSettings;
  private final UnaryCallSettings<LookupDiscoveredWorkloadRequest, LookupDiscoveredWorkloadResponse>
      lookupDiscoveredWorkloadSettings;
  private final PagedCallSettings<
          ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>
      listWorkloadsSettings;
  private final UnaryCallSettings<CreateWorkloadRequest, Operation> createWorkloadSettings;
  private final OperationCallSettings<CreateWorkloadRequest, Workload, OperationMetadata>
      createWorkloadOperationSettings;
  private final UnaryCallSettings<GetWorkloadRequest, Workload> getWorkloadSettings;
  private final UnaryCallSettings<UpdateWorkloadRequest, Operation> updateWorkloadSettings;
  private final OperationCallSettings<UpdateWorkloadRequest, Workload, OperationMetadata>
      updateWorkloadOperationSettings;
  private final UnaryCallSettings<DeleteWorkloadRequest, Operation> deleteWorkloadSettings;
  private final OperationCallSettings<DeleteWorkloadRequest, Empty, OperationMetadata>
      deleteWorkloadOperationSettings;
  private final PagedCallSettings<
          ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>
      listApplicationsSettings;
  private final UnaryCallSettings<CreateApplicationRequest, Operation> createApplicationSettings;
  private final OperationCallSettings<CreateApplicationRequest, Application, OperationMetadata>
      createApplicationOperationSettings;
  private final UnaryCallSettings<GetApplicationRequest, Application> getApplicationSettings;
  private final UnaryCallSettings<UpdateApplicationRequest, Operation> updateApplicationSettings;
  private final OperationCallSettings<UpdateApplicationRequest, Application, OperationMetadata>
      updateApplicationOperationSettings;
  private final UnaryCallSettings<DeleteApplicationRequest, Operation> deleteApplicationSettings;
  private final OperationCallSettings<DeleteApplicationRequest, Empty, OperationMetadata>
      deleteApplicationOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListServiceProjectAttachmentsRequest,
          ListServiceProjectAttachmentsResponse,
          ServiceProjectAttachment>
      LIST_SERVICE_PROJECT_ATTACHMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListServiceProjectAttachmentsRequest,
              ListServiceProjectAttachmentsResponse,
              ServiceProjectAttachment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListServiceProjectAttachmentsRequest injectToken(
                ListServiceProjectAttachmentsRequest payload, String token) {
              return ListServiceProjectAttachmentsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListServiceProjectAttachmentsRequest injectPageSize(
                ListServiceProjectAttachmentsRequest payload, int pageSize) {
              return ListServiceProjectAttachmentsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListServiceProjectAttachmentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListServiceProjectAttachmentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ServiceProjectAttachment> extractResources(
                ListServiceProjectAttachmentsResponse payload) {
              return payload.getServiceProjectAttachmentsList() == null
                  ? ImmutableList.<ServiceProjectAttachment>of()
                  : payload.getServiceProjectAttachmentsList();
            }
          };

  private static final PagedListDescriptor<
          ListDiscoveredServicesRequest, ListDiscoveredServicesResponse, DiscoveredService>
      LIST_DISCOVERED_SERVICES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDiscoveredServicesRequest, ListDiscoveredServicesResponse, DiscoveredService>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDiscoveredServicesRequest injectToken(
                ListDiscoveredServicesRequest payload, String token) {
              return ListDiscoveredServicesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDiscoveredServicesRequest injectPageSize(
                ListDiscoveredServicesRequest payload, int pageSize) {
              return ListDiscoveredServicesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListDiscoveredServicesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDiscoveredServicesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DiscoveredService> extractResources(
                ListDiscoveredServicesResponse payload) {
              return payload.getDiscoveredServicesList() == null
                  ? ImmutableList.<DiscoveredService>of()
                  : payload.getDiscoveredServicesList();
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

  private static final PagedListDescriptor<
          ListDiscoveredWorkloadsRequest, ListDiscoveredWorkloadsResponse, DiscoveredWorkload>
      LIST_DISCOVERED_WORKLOADS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDiscoveredWorkloadsRequest,
              ListDiscoveredWorkloadsResponse,
              DiscoveredWorkload>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDiscoveredWorkloadsRequest injectToken(
                ListDiscoveredWorkloadsRequest payload, String token) {
              return ListDiscoveredWorkloadsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDiscoveredWorkloadsRequest injectPageSize(
                ListDiscoveredWorkloadsRequest payload, int pageSize) {
              return ListDiscoveredWorkloadsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListDiscoveredWorkloadsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDiscoveredWorkloadsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DiscoveredWorkload> extractResources(
                ListDiscoveredWorkloadsResponse payload) {
              return payload.getDiscoveredWorkloadsList() == null
                  ? ImmutableList.<DiscoveredWorkload>of()
                  : payload.getDiscoveredWorkloadsList();
            }
          };

  private static final PagedListDescriptor<ListWorkloadsRequest, ListWorkloadsResponse, Workload>
      LIST_WORKLOADS_PAGE_STR_DESC =
          new PagedListDescriptor<ListWorkloadsRequest, ListWorkloadsResponse, Workload>() {
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
            public Iterable<Workload> extractResources(ListWorkloadsResponse payload) {
              return payload.getWorkloadsList() == null
                  ? ImmutableList.<Workload>of()
                  : payload.getWorkloadsList();
            }
          };

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
          ListServiceProjectAttachmentsRequest,
          ListServiceProjectAttachmentsResponse,
          ListServiceProjectAttachmentsPagedResponse>
      LIST_SERVICE_PROJECT_ATTACHMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListServiceProjectAttachmentsRequest,
              ListServiceProjectAttachmentsResponse,
              ListServiceProjectAttachmentsPagedResponse>() {
            @Override
            public ApiFuture<ListServiceProjectAttachmentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListServiceProjectAttachmentsRequest, ListServiceProjectAttachmentsResponse>
                    callable,
                ListServiceProjectAttachmentsRequest request,
                ApiCallContext context,
                ApiFuture<ListServiceProjectAttachmentsResponse> futureResponse) {
              PageContext<
                      ListServiceProjectAttachmentsRequest,
                      ListServiceProjectAttachmentsResponse,
                      ServiceProjectAttachment>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_SERVICE_PROJECT_ATTACHMENTS_PAGE_STR_DESC,
                          request,
                          context);
              return ListServiceProjectAttachmentsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDiscoveredServicesRequest,
          ListDiscoveredServicesResponse,
          ListDiscoveredServicesPagedResponse>
      LIST_DISCOVERED_SERVICES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDiscoveredServicesRequest,
              ListDiscoveredServicesResponse,
              ListDiscoveredServicesPagedResponse>() {
            @Override
            public ApiFuture<ListDiscoveredServicesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDiscoveredServicesRequest, ListDiscoveredServicesResponse>
                    callable,
                ListDiscoveredServicesRequest request,
                ApiCallContext context,
                ApiFuture<ListDiscoveredServicesResponse> futureResponse) {
              PageContext<
                      ListDiscoveredServicesRequest,
                      ListDiscoveredServicesResponse,
                      DiscoveredService>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DISCOVERED_SERVICES_PAGE_STR_DESC, request, context);
              return ListDiscoveredServicesPagedResponse.createAsync(pageContext, futureResponse);
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
          ListDiscoveredWorkloadsRequest,
          ListDiscoveredWorkloadsResponse,
          ListDiscoveredWorkloadsPagedResponse>
      LIST_DISCOVERED_WORKLOADS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDiscoveredWorkloadsRequest,
              ListDiscoveredWorkloadsResponse,
              ListDiscoveredWorkloadsPagedResponse>() {
            @Override
            public ApiFuture<ListDiscoveredWorkloadsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDiscoveredWorkloadsRequest, ListDiscoveredWorkloadsResponse>
                    callable,
                ListDiscoveredWorkloadsRequest request,
                ApiCallContext context,
                ApiFuture<ListDiscoveredWorkloadsResponse> futureResponse) {
              PageContext<
                      ListDiscoveredWorkloadsRequest,
                      ListDiscoveredWorkloadsResponse,
                      DiscoveredWorkload>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DISCOVERED_WORKLOADS_PAGE_STR_DESC, request, context);
              return ListDiscoveredWorkloadsPagedResponse.createAsync(pageContext, futureResponse);
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
              PageContext<ListWorkloadsRequest, ListWorkloadsResponse, Workload> pageContext =
                  PageContext.create(callable, LIST_WORKLOADS_PAGE_STR_DESC, request, context);
              return ListWorkloadsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to lookupServiceProjectAttachment. */
  public UnaryCallSettings<
          LookupServiceProjectAttachmentRequest, LookupServiceProjectAttachmentResponse>
      lookupServiceProjectAttachmentSettings() {
    return lookupServiceProjectAttachmentSettings;
  }

  /** Returns the object with the settings used for calls to listServiceProjectAttachments. */
  public PagedCallSettings<
          ListServiceProjectAttachmentsRequest,
          ListServiceProjectAttachmentsResponse,
          ListServiceProjectAttachmentsPagedResponse>
      listServiceProjectAttachmentsSettings() {
    return listServiceProjectAttachmentsSettings;
  }

  /** Returns the object with the settings used for calls to createServiceProjectAttachment. */
  public UnaryCallSettings<CreateServiceProjectAttachmentRequest, Operation>
      createServiceProjectAttachmentSettings() {
    return createServiceProjectAttachmentSettings;
  }

  /** Returns the object with the settings used for calls to createServiceProjectAttachment. */
  public OperationCallSettings<
          CreateServiceProjectAttachmentRequest, ServiceProjectAttachment, OperationMetadata>
      createServiceProjectAttachmentOperationSettings() {
    return createServiceProjectAttachmentOperationSettings;
  }

  /** Returns the object with the settings used for calls to getServiceProjectAttachment. */
  public UnaryCallSettings<GetServiceProjectAttachmentRequest, ServiceProjectAttachment>
      getServiceProjectAttachmentSettings() {
    return getServiceProjectAttachmentSettings;
  }

  /** Returns the object with the settings used for calls to deleteServiceProjectAttachment. */
  public UnaryCallSettings<DeleteServiceProjectAttachmentRequest, Operation>
      deleteServiceProjectAttachmentSettings() {
    return deleteServiceProjectAttachmentSettings;
  }

  /** Returns the object with the settings used for calls to deleteServiceProjectAttachment. */
  public OperationCallSettings<DeleteServiceProjectAttachmentRequest, Empty, OperationMetadata>
      deleteServiceProjectAttachmentOperationSettings() {
    return deleteServiceProjectAttachmentOperationSettings;
  }

  /** Returns the object with the settings used for calls to detachServiceProjectAttachment. */
  public UnaryCallSettings<
          DetachServiceProjectAttachmentRequest, DetachServiceProjectAttachmentResponse>
      detachServiceProjectAttachmentSettings() {
    return detachServiceProjectAttachmentSettings;
  }

  /** Returns the object with the settings used for calls to listDiscoveredServices. */
  public PagedCallSettings<
          ListDiscoveredServicesRequest,
          ListDiscoveredServicesResponse,
          ListDiscoveredServicesPagedResponse>
      listDiscoveredServicesSettings() {
    return listDiscoveredServicesSettings;
  }

  /** Returns the object with the settings used for calls to getDiscoveredService. */
  public UnaryCallSettings<GetDiscoveredServiceRequest, DiscoveredService>
      getDiscoveredServiceSettings() {
    return getDiscoveredServiceSettings;
  }

  /** Returns the object with the settings used for calls to lookupDiscoveredService. */
  public UnaryCallSettings<LookupDiscoveredServiceRequest, LookupDiscoveredServiceResponse>
      lookupDiscoveredServiceSettings() {
    return lookupDiscoveredServiceSettings;
  }

  /** Returns the object with the settings used for calls to listServices. */
  public PagedCallSettings<ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      listServicesSettings() {
    return listServicesSettings;
  }

  /** Returns the object with the settings used for calls to createService. */
  public UnaryCallSettings<CreateServiceRequest, Operation> createServiceSettings() {
    return createServiceSettings;
  }

  /** Returns the object with the settings used for calls to createService. */
  public OperationCallSettings<CreateServiceRequest, Service, OperationMetadata>
      createServiceOperationSettings() {
    return createServiceOperationSettings;
  }

  /** Returns the object with the settings used for calls to getService. */
  public UnaryCallSettings<GetServiceRequest, Service> getServiceSettings() {
    return getServiceSettings;
  }

  /** Returns the object with the settings used for calls to updateService. */
  public UnaryCallSettings<UpdateServiceRequest, Operation> updateServiceSettings() {
    return updateServiceSettings;
  }

  /** Returns the object with the settings used for calls to updateService. */
  public OperationCallSettings<UpdateServiceRequest, Service, OperationMetadata>
      updateServiceOperationSettings() {
    return updateServiceOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteService. */
  public UnaryCallSettings<DeleteServiceRequest, Operation> deleteServiceSettings() {
    return deleteServiceSettings;
  }

  /** Returns the object with the settings used for calls to deleteService. */
  public OperationCallSettings<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationSettings() {
    return deleteServiceOperationSettings;
  }

  /** Returns the object with the settings used for calls to listDiscoveredWorkloads. */
  public PagedCallSettings<
          ListDiscoveredWorkloadsRequest,
          ListDiscoveredWorkloadsResponse,
          ListDiscoveredWorkloadsPagedResponse>
      listDiscoveredWorkloadsSettings() {
    return listDiscoveredWorkloadsSettings;
  }

  /** Returns the object with the settings used for calls to getDiscoveredWorkload. */
  public UnaryCallSettings<GetDiscoveredWorkloadRequest, DiscoveredWorkload>
      getDiscoveredWorkloadSettings() {
    return getDiscoveredWorkloadSettings;
  }

  /** Returns the object with the settings used for calls to lookupDiscoveredWorkload. */
  public UnaryCallSettings<LookupDiscoveredWorkloadRequest, LookupDiscoveredWorkloadResponse>
      lookupDiscoveredWorkloadSettings() {
    return lookupDiscoveredWorkloadSettings;
  }

  /** Returns the object with the settings used for calls to listWorkloads. */
  public PagedCallSettings<ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>
      listWorkloadsSettings() {
    return listWorkloadsSettings;
  }

  /** Returns the object with the settings used for calls to createWorkload. */
  public UnaryCallSettings<CreateWorkloadRequest, Operation> createWorkloadSettings() {
    return createWorkloadSettings;
  }

  /** Returns the object with the settings used for calls to createWorkload. */
  public OperationCallSettings<CreateWorkloadRequest, Workload, OperationMetadata>
      createWorkloadOperationSettings() {
    return createWorkloadOperationSettings;
  }

  /** Returns the object with the settings used for calls to getWorkload. */
  public UnaryCallSettings<GetWorkloadRequest, Workload> getWorkloadSettings() {
    return getWorkloadSettings;
  }

  /** Returns the object with the settings used for calls to updateWorkload. */
  public UnaryCallSettings<UpdateWorkloadRequest, Operation> updateWorkloadSettings() {
    return updateWorkloadSettings;
  }

  /** Returns the object with the settings used for calls to updateWorkload. */
  public OperationCallSettings<UpdateWorkloadRequest, Workload, OperationMetadata>
      updateWorkloadOperationSettings() {
    return updateWorkloadOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteWorkload. */
  public UnaryCallSettings<DeleteWorkloadRequest, Operation> deleteWorkloadSettings() {
    return deleteWorkloadSettings;
  }

  /** Returns the object with the settings used for calls to deleteWorkload. */
  public OperationCallSettings<DeleteWorkloadRequest, Empty, OperationMetadata>
      deleteWorkloadOperationSettings() {
    return deleteWorkloadOperationSettings;
  }

  /** Returns the object with the settings used for calls to listApplications. */
  public PagedCallSettings<
          ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>
      listApplicationsSettings() {
    return listApplicationsSettings;
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

  /** Returns the object with the settings used for calls to getApplication. */
  public UnaryCallSettings<GetApplicationRequest, Application> getApplicationSettings() {
    return getApplicationSettings;
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

  public AppHubStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAppHubStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAppHubStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "apphub";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "apphub.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "apphub.mtls.googleapis.com:443";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(AppHubStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(AppHubStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AppHubStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected AppHubStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    lookupServiceProjectAttachmentSettings =
        settingsBuilder.lookupServiceProjectAttachmentSettings().build();
    listServiceProjectAttachmentsSettings =
        settingsBuilder.listServiceProjectAttachmentsSettings().build();
    createServiceProjectAttachmentSettings =
        settingsBuilder.createServiceProjectAttachmentSettings().build();
    createServiceProjectAttachmentOperationSettings =
        settingsBuilder.createServiceProjectAttachmentOperationSettings().build();
    getServiceProjectAttachmentSettings =
        settingsBuilder.getServiceProjectAttachmentSettings().build();
    deleteServiceProjectAttachmentSettings =
        settingsBuilder.deleteServiceProjectAttachmentSettings().build();
    deleteServiceProjectAttachmentOperationSettings =
        settingsBuilder.deleteServiceProjectAttachmentOperationSettings().build();
    detachServiceProjectAttachmentSettings =
        settingsBuilder.detachServiceProjectAttachmentSettings().build();
    listDiscoveredServicesSettings = settingsBuilder.listDiscoveredServicesSettings().build();
    getDiscoveredServiceSettings = settingsBuilder.getDiscoveredServiceSettings().build();
    lookupDiscoveredServiceSettings = settingsBuilder.lookupDiscoveredServiceSettings().build();
    listServicesSettings = settingsBuilder.listServicesSettings().build();
    createServiceSettings = settingsBuilder.createServiceSettings().build();
    createServiceOperationSettings = settingsBuilder.createServiceOperationSettings().build();
    getServiceSettings = settingsBuilder.getServiceSettings().build();
    updateServiceSettings = settingsBuilder.updateServiceSettings().build();
    updateServiceOperationSettings = settingsBuilder.updateServiceOperationSettings().build();
    deleteServiceSettings = settingsBuilder.deleteServiceSettings().build();
    deleteServiceOperationSettings = settingsBuilder.deleteServiceOperationSettings().build();
    listDiscoveredWorkloadsSettings = settingsBuilder.listDiscoveredWorkloadsSettings().build();
    getDiscoveredWorkloadSettings = settingsBuilder.getDiscoveredWorkloadSettings().build();
    lookupDiscoveredWorkloadSettings = settingsBuilder.lookupDiscoveredWorkloadSettings().build();
    listWorkloadsSettings = settingsBuilder.listWorkloadsSettings().build();
    createWorkloadSettings = settingsBuilder.createWorkloadSettings().build();
    createWorkloadOperationSettings = settingsBuilder.createWorkloadOperationSettings().build();
    getWorkloadSettings = settingsBuilder.getWorkloadSettings().build();
    updateWorkloadSettings = settingsBuilder.updateWorkloadSettings().build();
    updateWorkloadOperationSettings = settingsBuilder.updateWorkloadOperationSettings().build();
    deleteWorkloadSettings = settingsBuilder.deleteWorkloadSettings().build();
    deleteWorkloadOperationSettings = settingsBuilder.deleteWorkloadOperationSettings().build();
    listApplicationsSettings = settingsBuilder.listApplicationsSettings().build();
    createApplicationSettings = settingsBuilder.createApplicationSettings().build();
    createApplicationOperationSettings =
        settingsBuilder.createApplicationOperationSettings().build();
    getApplicationSettings = settingsBuilder.getApplicationSettings().build();
    updateApplicationSettings = settingsBuilder.updateApplicationSettings().build();
    updateApplicationOperationSettings =
        settingsBuilder.updateApplicationOperationSettings().build();
    deleteApplicationSettings = settingsBuilder.deleteApplicationSettings().build();
    deleteApplicationOperationSettings =
        settingsBuilder.deleteApplicationOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for AppHubStubSettings. */
  public static class Builder extends StubSettings.Builder<AppHubStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<
            LookupServiceProjectAttachmentRequest, LookupServiceProjectAttachmentResponse>
        lookupServiceProjectAttachmentSettings;
    private final PagedCallSettings.Builder<
            ListServiceProjectAttachmentsRequest,
            ListServiceProjectAttachmentsResponse,
            ListServiceProjectAttachmentsPagedResponse>
        listServiceProjectAttachmentsSettings;
    private final UnaryCallSettings.Builder<CreateServiceProjectAttachmentRequest, Operation>
        createServiceProjectAttachmentSettings;
    private final OperationCallSettings.Builder<
            CreateServiceProjectAttachmentRequest, ServiceProjectAttachment, OperationMetadata>
        createServiceProjectAttachmentOperationSettings;
    private final UnaryCallSettings.Builder<
            GetServiceProjectAttachmentRequest, ServiceProjectAttachment>
        getServiceProjectAttachmentSettings;
    private final UnaryCallSettings.Builder<DeleteServiceProjectAttachmentRequest, Operation>
        deleteServiceProjectAttachmentSettings;
    private final OperationCallSettings.Builder<
            DeleteServiceProjectAttachmentRequest, Empty, OperationMetadata>
        deleteServiceProjectAttachmentOperationSettings;
    private final UnaryCallSettings.Builder<
            DetachServiceProjectAttachmentRequest, DetachServiceProjectAttachmentResponse>
        detachServiceProjectAttachmentSettings;
    private final PagedCallSettings.Builder<
            ListDiscoveredServicesRequest,
            ListDiscoveredServicesResponse,
            ListDiscoveredServicesPagedResponse>
        listDiscoveredServicesSettings;
    private final UnaryCallSettings.Builder<GetDiscoveredServiceRequest, DiscoveredService>
        getDiscoveredServiceSettings;
    private final UnaryCallSettings.Builder<
            LookupDiscoveredServiceRequest, LookupDiscoveredServiceResponse>
        lookupDiscoveredServiceSettings;
    private final PagedCallSettings.Builder<
            ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
        listServicesSettings;
    private final UnaryCallSettings.Builder<CreateServiceRequest, Operation> createServiceSettings;
    private final OperationCallSettings.Builder<CreateServiceRequest, Service, OperationMetadata>
        createServiceOperationSettings;
    private final UnaryCallSettings.Builder<GetServiceRequest, Service> getServiceSettings;
    private final UnaryCallSettings.Builder<UpdateServiceRequest, Operation> updateServiceSettings;
    private final OperationCallSettings.Builder<UpdateServiceRequest, Service, OperationMetadata>
        updateServiceOperationSettings;
    private final UnaryCallSettings.Builder<DeleteServiceRequest, Operation> deleteServiceSettings;
    private final OperationCallSettings.Builder<DeleteServiceRequest, Empty, OperationMetadata>
        deleteServiceOperationSettings;
    private final PagedCallSettings.Builder<
            ListDiscoveredWorkloadsRequest,
            ListDiscoveredWorkloadsResponse,
            ListDiscoveredWorkloadsPagedResponse>
        listDiscoveredWorkloadsSettings;
    private final UnaryCallSettings.Builder<GetDiscoveredWorkloadRequest, DiscoveredWorkload>
        getDiscoveredWorkloadSettings;
    private final UnaryCallSettings.Builder<
            LookupDiscoveredWorkloadRequest, LookupDiscoveredWorkloadResponse>
        lookupDiscoveredWorkloadSettings;
    private final PagedCallSettings.Builder<
            ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>
        listWorkloadsSettings;
    private final UnaryCallSettings.Builder<CreateWorkloadRequest, Operation>
        createWorkloadSettings;
    private final OperationCallSettings.Builder<CreateWorkloadRequest, Workload, OperationMetadata>
        createWorkloadOperationSettings;
    private final UnaryCallSettings.Builder<GetWorkloadRequest, Workload> getWorkloadSettings;
    private final UnaryCallSettings.Builder<UpdateWorkloadRequest, Operation>
        updateWorkloadSettings;
    private final OperationCallSettings.Builder<UpdateWorkloadRequest, Workload, OperationMetadata>
        updateWorkloadOperationSettings;
    private final UnaryCallSettings.Builder<DeleteWorkloadRequest, Operation>
        deleteWorkloadSettings;
    private final OperationCallSettings.Builder<DeleteWorkloadRequest, Empty, OperationMetadata>
        deleteWorkloadOperationSettings;
    private final PagedCallSettings.Builder<
            ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>
        listApplicationsSettings;
    private final UnaryCallSettings.Builder<CreateApplicationRequest, Operation>
        createApplicationSettings;
    private final OperationCallSettings.Builder<
            CreateApplicationRequest, Application, OperationMetadata>
        createApplicationOperationSettings;
    private final UnaryCallSettings.Builder<GetApplicationRequest, Application>
        getApplicationSettings;
    private final UnaryCallSettings.Builder<UpdateApplicationRequest, Operation>
        updateApplicationSettings;
    private final OperationCallSettings.Builder<
            UpdateApplicationRequest, Application, OperationMetadata>
        updateApplicationOperationSettings;
    private final UnaryCallSettings.Builder<DeleteApplicationRequest, Operation>
        deleteApplicationSettings;
    private final OperationCallSettings.Builder<DeleteApplicationRequest, Empty, OperationMetadata>
        deleteApplicationOperationSettings;
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
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      lookupServiceProjectAttachmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listServiceProjectAttachmentsSettings =
          PagedCallSettings.newBuilder(LIST_SERVICE_PROJECT_ATTACHMENTS_PAGE_STR_FACT);
      createServiceProjectAttachmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createServiceProjectAttachmentOperationSettings = OperationCallSettings.newBuilder();
      getServiceProjectAttachmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteServiceProjectAttachmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteServiceProjectAttachmentOperationSettings = OperationCallSettings.newBuilder();
      detachServiceProjectAttachmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDiscoveredServicesSettings =
          PagedCallSettings.newBuilder(LIST_DISCOVERED_SERVICES_PAGE_STR_FACT);
      getDiscoveredServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      lookupDiscoveredServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listServicesSettings = PagedCallSettings.newBuilder(LIST_SERVICES_PAGE_STR_FACT);
      createServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createServiceOperationSettings = OperationCallSettings.newBuilder();
      getServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateServiceOperationSettings = OperationCallSettings.newBuilder();
      deleteServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteServiceOperationSettings = OperationCallSettings.newBuilder();
      listDiscoveredWorkloadsSettings =
          PagedCallSettings.newBuilder(LIST_DISCOVERED_WORKLOADS_PAGE_STR_FACT);
      getDiscoveredWorkloadSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      lookupDiscoveredWorkloadSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listWorkloadsSettings = PagedCallSettings.newBuilder(LIST_WORKLOADS_PAGE_STR_FACT);
      createWorkloadSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createWorkloadOperationSettings = OperationCallSettings.newBuilder();
      getWorkloadSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateWorkloadSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateWorkloadOperationSettings = OperationCallSettings.newBuilder();
      deleteWorkloadSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteWorkloadOperationSettings = OperationCallSettings.newBuilder();
      listApplicationsSettings = PagedCallSettings.newBuilder(LIST_APPLICATIONS_PAGE_STR_FACT);
      createApplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createApplicationOperationSettings = OperationCallSettings.newBuilder();
      getApplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateApplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateApplicationOperationSettings = OperationCallSettings.newBuilder();
      deleteApplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteApplicationOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              lookupServiceProjectAttachmentSettings,
              listServiceProjectAttachmentsSettings,
              createServiceProjectAttachmentSettings,
              getServiceProjectAttachmentSettings,
              deleteServiceProjectAttachmentSettings,
              detachServiceProjectAttachmentSettings,
              listDiscoveredServicesSettings,
              getDiscoveredServiceSettings,
              lookupDiscoveredServiceSettings,
              listServicesSettings,
              createServiceSettings,
              getServiceSettings,
              updateServiceSettings,
              deleteServiceSettings,
              listDiscoveredWorkloadsSettings,
              getDiscoveredWorkloadSettings,
              lookupDiscoveredWorkloadSettings,
              listWorkloadsSettings,
              createWorkloadSettings,
              getWorkloadSettings,
              updateWorkloadSettings,
              deleteWorkloadSettings,
              listApplicationsSettings,
              createApplicationSettings,
              getApplicationSettings,
              updateApplicationSettings,
              deleteApplicationSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(AppHubStubSettings settings) {
      super(settings);

      lookupServiceProjectAttachmentSettings =
          settings.lookupServiceProjectAttachmentSettings.toBuilder();
      listServiceProjectAttachmentsSettings =
          settings.listServiceProjectAttachmentsSettings.toBuilder();
      createServiceProjectAttachmentSettings =
          settings.createServiceProjectAttachmentSettings.toBuilder();
      createServiceProjectAttachmentOperationSettings =
          settings.createServiceProjectAttachmentOperationSettings.toBuilder();
      getServiceProjectAttachmentSettings =
          settings.getServiceProjectAttachmentSettings.toBuilder();
      deleteServiceProjectAttachmentSettings =
          settings.deleteServiceProjectAttachmentSettings.toBuilder();
      deleteServiceProjectAttachmentOperationSettings =
          settings.deleteServiceProjectAttachmentOperationSettings.toBuilder();
      detachServiceProjectAttachmentSettings =
          settings.detachServiceProjectAttachmentSettings.toBuilder();
      listDiscoveredServicesSettings = settings.listDiscoveredServicesSettings.toBuilder();
      getDiscoveredServiceSettings = settings.getDiscoveredServiceSettings.toBuilder();
      lookupDiscoveredServiceSettings = settings.lookupDiscoveredServiceSettings.toBuilder();
      listServicesSettings = settings.listServicesSettings.toBuilder();
      createServiceSettings = settings.createServiceSettings.toBuilder();
      createServiceOperationSettings = settings.createServiceOperationSettings.toBuilder();
      getServiceSettings = settings.getServiceSettings.toBuilder();
      updateServiceSettings = settings.updateServiceSettings.toBuilder();
      updateServiceOperationSettings = settings.updateServiceOperationSettings.toBuilder();
      deleteServiceSettings = settings.deleteServiceSettings.toBuilder();
      deleteServiceOperationSettings = settings.deleteServiceOperationSettings.toBuilder();
      listDiscoveredWorkloadsSettings = settings.listDiscoveredWorkloadsSettings.toBuilder();
      getDiscoveredWorkloadSettings = settings.getDiscoveredWorkloadSettings.toBuilder();
      lookupDiscoveredWorkloadSettings = settings.lookupDiscoveredWorkloadSettings.toBuilder();
      listWorkloadsSettings = settings.listWorkloadsSettings.toBuilder();
      createWorkloadSettings = settings.createWorkloadSettings.toBuilder();
      createWorkloadOperationSettings = settings.createWorkloadOperationSettings.toBuilder();
      getWorkloadSettings = settings.getWorkloadSettings.toBuilder();
      updateWorkloadSettings = settings.updateWorkloadSettings.toBuilder();
      updateWorkloadOperationSettings = settings.updateWorkloadOperationSettings.toBuilder();
      deleteWorkloadSettings = settings.deleteWorkloadSettings.toBuilder();
      deleteWorkloadOperationSettings = settings.deleteWorkloadOperationSettings.toBuilder();
      listApplicationsSettings = settings.listApplicationsSettings.toBuilder();
      createApplicationSettings = settings.createApplicationSettings.toBuilder();
      createApplicationOperationSettings = settings.createApplicationOperationSettings.toBuilder();
      getApplicationSettings = settings.getApplicationSettings.toBuilder();
      updateApplicationSettings = settings.updateApplicationSettings.toBuilder();
      updateApplicationOperationSettings = settings.updateApplicationOperationSettings.toBuilder();
      deleteApplicationSettings = settings.deleteApplicationSettings.toBuilder();
      deleteApplicationOperationSettings = settings.deleteApplicationOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              lookupServiceProjectAttachmentSettings,
              listServiceProjectAttachmentsSettings,
              createServiceProjectAttachmentSettings,
              getServiceProjectAttachmentSettings,
              deleteServiceProjectAttachmentSettings,
              detachServiceProjectAttachmentSettings,
              listDiscoveredServicesSettings,
              getDiscoveredServiceSettings,
              lookupDiscoveredServiceSettings,
              listServicesSettings,
              createServiceSettings,
              getServiceSettings,
              updateServiceSettings,
              deleteServiceSettings,
              listDiscoveredWorkloadsSettings,
              getDiscoveredWorkloadSettings,
              lookupDiscoveredWorkloadSettings,
              listWorkloadsSettings,
              createWorkloadSettings,
              getWorkloadSettings,
              updateWorkloadSettings,
              deleteWorkloadSettings,
              listApplicationsSettings,
              createApplicationSettings,
              getApplicationSettings,
              updateApplicationSettings,
              deleteApplicationSettings,
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
          .lookupServiceProjectAttachmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listServiceProjectAttachmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createServiceProjectAttachmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getServiceProjectAttachmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteServiceProjectAttachmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .detachServiceProjectAttachmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listDiscoveredServicesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getDiscoveredServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .lookupDiscoveredServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listServicesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listDiscoveredWorkloadsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getDiscoveredWorkloadSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .lookupDiscoveredWorkloadSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listWorkloadsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createWorkloadSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getWorkloadSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateWorkloadSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteWorkloadSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listApplicationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createApplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getApplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateApplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteApplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

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
          .createServiceProjectAttachmentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateServiceProjectAttachmentRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ServiceProjectAttachment.class))
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
          .deleteServiceProjectAttachmentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteServiceProjectAttachmentRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
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
          .createServiceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateServiceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Service.class))
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
          .updateServiceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateServiceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Service.class))
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
          .deleteServiceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteServiceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .createWorkloadOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateWorkloadRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Workload.class))
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
          .updateWorkloadOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateWorkloadRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Workload.class))
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
          .deleteWorkloadOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteWorkloadRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .createApplicationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateApplicationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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

    /** Returns the builder for the settings used for calls to lookupServiceProjectAttachment. */
    public UnaryCallSettings.Builder<
            LookupServiceProjectAttachmentRequest, LookupServiceProjectAttachmentResponse>
        lookupServiceProjectAttachmentSettings() {
      return lookupServiceProjectAttachmentSettings;
    }

    /** Returns the builder for the settings used for calls to listServiceProjectAttachments. */
    public PagedCallSettings.Builder<
            ListServiceProjectAttachmentsRequest,
            ListServiceProjectAttachmentsResponse,
            ListServiceProjectAttachmentsPagedResponse>
        listServiceProjectAttachmentsSettings() {
      return listServiceProjectAttachmentsSettings;
    }

    /** Returns the builder for the settings used for calls to createServiceProjectAttachment. */
    public UnaryCallSettings.Builder<CreateServiceProjectAttachmentRequest, Operation>
        createServiceProjectAttachmentSettings() {
      return createServiceProjectAttachmentSettings;
    }

    /** Returns the builder for the settings used for calls to createServiceProjectAttachment. */
    public OperationCallSettings.Builder<
            CreateServiceProjectAttachmentRequest, ServiceProjectAttachment, OperationMetadata>
        createServiceProjectAttachmentOperationSettings() {
      return createServiceProjectAttachmentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getServiceProjectAttachment. */
    public UnaryCallSettings.Builder<GetServiceProjectAttachmentRequest, ServiceProjectAttachment>
        getServiceProjectAttachmentSettings() {
      return getServiceProjectAttachmentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteServiceProjectAttachment. */
    public UnaryCallSettings.Builder<DeleteServiceProjectAttachmentRequest, Operation>
        deleteServiceProjectAttachmentSettings() {
      return deleteServiceProjectAttachmentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteServiceProjectAttachment. */
    public OperationCallSettings.Builder<
            DeleteServiceProjectAttachmentRequest, Empty, OperationMetadata>
        deleteServiceProjectAttachmentOperationSettings() {
      return deleteServiceProjectAttachmentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to detachServiceProjectAttachment. */
    public UnaryCallSettings.Builder<
            DetachServiceProjectAttachmentRequest, DetachServiceProjectAttachmentResponse>
        detachServiceProjectAttachmentSettings() {
      return detachServiceProjectAttachmentSettings;
    }

    /** Returns the builder for the settings used for calls to listDiscoveredServices. */
    public PagedCallSettings.Builder<
            ListDiscoveredServicesRequest,
            ListDiscoveredServicesResponse,
            ListDiscoveredServicesPagedResponse>
        listDiscoveredServicesSettings() {
      return listDiscoveredServicesSettings;
    }

    /** Returns the builder for the settings used for calls to getDiscoveredService. */
    public UnaryCallSettings.Builder<GetDiscoveredServiceRequest, DiscoveredService>
        getDiscoveredServiceSettings() {
      return getDiscoveredServiceSettings;
    }

    /** Returns the builder for the settings used for calls to lookupDiscoveredService. */
    public UnaryCallSettings.Builder<
            LookupDiscoveredServiceRequest, LookupDiscoveredServiceResponse>
        lookupDiscoveredServiceSettings() {
      return lookupDiscoveredServiceSettings;
    }

    /** Returns the builder for the settings used for calls to listServices. */
    public PagedCallSettings.Builder<
            ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
        listServicesSettings() {
      return listServicesSettings;
    }

    /** Returns the builder for the settings used for calls to createService. */
    public UnaryCallSettings.Builder<CreateServiceRequest, Operation> createServiceSettings() {
      return createServiceSettings;
    }

    /** Returns the builder for the settings used for calls to createService. */
    public OperationCallSettings.Builder<CreateServiceRequest, Service, OperationMetadata>
        createServiceOperationSettings() {
      return createServiceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getService. */
    public UnaryCallSettings.Builder<GetServiceRequest, Service> getServiceSettings() {
      return getServiceSettings;
    }

    /** Returns the builder for the settings used for calls to updateService. */
    public UnaryCallSettings.Builder<UpdateServiceRequest, Operation> updateServiceSettings() {
      return updateServiceSettings;
    }

    /** Returns the builder for the settings used for calls to updateService. */
    public OperationCallSettings.Builder<UpdateServiceRequest, Service, OperationMetadata>
        updateServiceOperationSettings() {
      return updateServiceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteService. */
    public UnaryCallSettings.Builder<DeleteServiceRequest, Operation> deleteServiceSettings() {
      return deleteServiceSettings;
    }

    /** Returns the builder for the settings used for calls to deleteService. */
    public OperationCallSettings.Builder<DeleteServiceRequest, Empty, OperationMetadata>
        deleteServiceOperationSettings() {
      return deleteServiceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listDiscoveredWorkloads. */
    public PagedCallSettings.Builder<
            ListDiscoveredWorkloadsRequest,
            ListDiscoveredWorkloadsResponse,
            ListDiscoveredWorkloadsPagedResponse>
        listDiscoveredWorkloadsSettings() {
      return listDiscoveredWorkloadsSettings;
    }

    /** Returns the builder for the settings used for calls to getDiscoveredWorkload. */
    public UnaryCallSettings.Builder<GetDiscoveredWorkloadRequest, DiscoveredWorkload>
        getDiscoveredWorkloadSettings() {
      return getDiscoveredWorkloadSettings;
    }

    /** Returns the builder for the settings used for calls to lookupDiscoveredWorkload. */
    public UnaryCallSettings.Builder<
            LookupDiscoveredWorkloadRequest, LookupDiscoveredWorkloadResponse>
        lookupDiscoveredWorkloadSettings() {
      return lookupDiscoveredWorkloadSettings;
    }

    /** Returns the builder for the settings used for calls to listWorkloads. */
    public PagedCallSettings.Builder<
            ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>
        listWorkloadsSettings() {
      return listWorkloadsSettings;
    }

    /** Returns the builder for the settings used for calls to createWorkload. */
    public UnaryCallSettings.Builder<CreateWorkloadRequest, Operation> createWorkloadSettings() {
      return createWorkloadSettings;
    }

    /** Returns the builder for the settings used for calls to createWorkload. */
    public OperationCallSettings.Builder<CreateWorkloadRequest, Workload, OperationMetadata>
        createWorkloadOperationSettings() {
      return createWorkloadOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getWorkload. */
    public UnaryCallSettings.Builder<GetWorkloadRequest, Workload> getWorkloadSettings() {
      return getWorkloadSettings;
    }

    /** Returns the builder for the settings used for calls to updateWorkload. */
    public UnaryCallSettings.Builder<UpdateWorkloadRequest, Operation> updateWorkloadSettings() {
      return updateWorkloadSettings;
    }

    /** Returns the builder for the settings used for calls to updateWorkload. */
    public OperationCallSettings.Builder<UpdateWorkloadRequest, Workload, OperationMetadata>
        updateWorkloadOperationSettings() {
      return updateWorkloadOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteWorkload. */
    public UnaryCallSettings.Builder<DeleteWorkloadRequest, Operation> deleteWorkloadSettings() {
      return deleteWorkloadSettings;
    }

    /** Returns the builder for the settings used for calls to deleteWorkload. */
    public OperationCallSettings.Builder<DeleteWorkloadRequest, Empty, OperationMetadata>
        deleteWorkloadOperationSettings() {
      return deleteWorkloadOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listApplications. */
    public PagedCallSettings.Builder<
            ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>
        listApplicationsSettings() {
      return listApplicationsSettings;
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

    /** Returns the builder for the settings used for calls to getApplication. */
    public UnaryCallSettings.Builder<GetApplicationRequest, Application> getApplicationSettings() {
      return getApplicationSettings;
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
    public AppHubStubSettings build() throws IOException {
      return new AppHubStubSettings(this);
    }
  }
}
