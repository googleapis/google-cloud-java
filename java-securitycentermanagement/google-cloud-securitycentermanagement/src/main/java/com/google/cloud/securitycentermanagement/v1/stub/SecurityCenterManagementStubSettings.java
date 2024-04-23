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

package com.google.cloud.securitycentermanagement.v1.stub;

import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListDescendantEventThreatDetectionCustomModulesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListEffectiveEventThreatDetectionCustomModulesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListEventThreatDetectionCustomModulesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListLocationsPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListSecurityHealthAnalyticsCustomModulesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.securitycentermanagement.v1.CreateEventThreatDetectionCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.CreateSecurityHealthAnalyticsCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.DeleteEventThreatDetectionCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.DeleteSecurityHealthAnalyticsCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.EffectiveEventThreatDetectionCustomModule;
import com.google.cloud.securitycentermanagement.v1.EffectiveSecurityHealthAnalyticsCustomModule;
import com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule;
import com.google.cloud.securitycentermanagement.v1.GetEffectiveEventThreatDetectionCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.GetEffectiveSecurityHealthAnalyticsCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.GetEventThreatDetectionCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.GetSecurityHealthAnalyticsCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.ListDescendantEventThreatDetectionCustomModulesRequest;
import com.google.cloud.securitycentermanagement.v1.ListDescendantEventThreatDetectionCustomModulesResponse;
import com.google.cloud.securitycentermanagement.v1.ListDescendantSecurityHealthAnalyticsCustomModulesRequest;
import com.google.cloud.securitycentermanagement.v1.ListDescendantSecurityHealthAnalyticsCustomModulesResponse;
import com.google.cloud.securitycentermanagement.v1.ListEffectiveEventThreatDetectionCustomModulesRequest;
import com.google.cloud.securitycentermanagement.v1.ListEffectiveEventThreatDetectionCustomModulesResponse;
import com.google.cloud.securitycentermanagement.v1.ListEffectiveSecurityHealthAnalyticsCustomModulesRequest;
import com.google.cloud.securitycentermanagement.v1.ListEffectiveSecurityHealthAnalyticsCustomModulesResponse;
import com.google.cloud.securitycentermanagement.v1.ListEventThreatDetectionCustomModulesRequest;
import com.google.cloud.securitycentermanagement.v1.ListEventThreatDetectionCustomModulesResponse;
import com.google.cloud.securitycentermanagement.v1.ListSecurityHealthAnalyticsCustomModulesRequest;
import com.google.cloud.securitycentermanagement.v1.ListSecurityHealthAnalyticsCustomModulesResponse;
import com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule;
import com.google.cloud.securitycentermanagement.v1.SimulateSecurityHealthAnalyticsCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.SimulateSecurityHealthAnalyticsCustomModuleResponse;
import com.google.cloud.securitycentermanagement.v1.UpdateEventThreatDetectionCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.UpdateSecurityHealthAnalyticsCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.ValidateEventThreatDetectionCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.ValidateEventThreatDetectionCustomModuleResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SecurityCenterManagementStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (securitycentermanagement.googleapis.com) and default port
 *       (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getEffectiveSecurityHealthAnalyticsCustomModule to 30
 * seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SecurityCenterManagementStubSettings.Builder securityCenterManagementSettingsBuilder =
 *     SecurityCenterManagementStubSettings.newBuilder();
 * securityCenterManagementSettingsBuilder
 *     .getEffectiveSecurityHealthAnalyticsCustomModuleSettings()
 *     .setRetrySettings(
 *         securityCenterManagementSettingsBuilder
 *             .getEffectiveSecurityHealthAnalyticsCustomModuleSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SecurityCenterManagementStubSettings securityCenterManagementSettings =
 *     securityCenterManagementSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SecurityCenterManagementStubSettings
    extends StubSettings<SecurityCenterManagementStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesResponse,
          ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse>
      listEffectiveSecurityHealthAnalyticsCustomModulesSettings;
  private final UnaryCallSettings<
          GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
          EffectiveSecurityHealthAnalyticsCustomModule>
      getEffectiveSecurityHealthAnalyticsCustomModuleSettings;
  private final PagedCallSettings<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesResponse,
          ListSecurityHealthAnalyticsCustomModulesPagedResponse>
      listSecurityHealthAnalyticsCustomModulesSettings;
  private final PagedCallSettings<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesResponse,
          ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse>
      listDescendantSecurityHealthAnalyticsCustomModulesSettings;
  private final UnaryCallSettings<
          GetSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      getSecurityHealthAnalyticsCustomModuleSettings;
  private final UnaryCallSettings<
          CreateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      createSecurityHealthAnalyticsCustomModuleSettings;
  private final UnaryCallSettings<
          UpdateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      updateSecurityHealthAnalyticsCustomModuleSettings;
  private final UnaryCallSettings<DeleteSecurityHealthAnalyticsCustomModuleRequest, Empty>
      deleteSecurityHealthAnalyticsCustomModuleSettings;
  private final UnaryCallSettings<
          SimulateSecurityHealthAnalyticsCustomModuleRequest,
          SimulateSecurityHealthAnalyticsCustomModuleResponse>
      simulateSecurityHealthAnalyticsCustomModuleSettings;
  private final PagedCallSettings<
          ListEffectiveEventThreatDetectionCustomModulesRequest,
          ListEffectiveEventThreatDetectionCustomModulesResponse,
          ListEffectiveEventThreatDetectionCustomModulesPagedResponse>
      listEffectiveEventThreatDetectionCustomModulesSettings;
  private final UnaryCallSettings<
          GetEffectiveEventThreatDetectionCustomModuleRequest,
          EffectiveEventThreatDetectionCustomModule>
      getEffectiveEventThreatDetectionCustomModuleSettings;
  private final PagedCallSettings<
          ListEventThreatDetectionCustomModulesRequest,
          ListEventThreatDetectionCustomModulesResponse,
          ListEventThreatDetectionCustomModulesPagedResponse>
      listEventThreatDetectionCustomModulesSettings;
  private final PagedCallSettings<
          ListDescendantEventThreatDetectionCustomModulesRequest,
          ListDescendantEventThreatDetectionCustomModulesResponse,
          ListDescendantEventThreatDetectionCustomModulesPagedResponse>
      listDescendantEventThreatDetectionCustomModulesSettings;
  private final UnaryCallSettings<
          GetEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      getEventThreatDetectionCustomModuleSettings;
  private final UnaryCallSettings<
          CreateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      createEventThreatDetectionCustomModuleSettings;
  private final UnaryCallSettings<
          UpdateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      updateEventThreatDetectionCustomModuleSettings;
  private final UnaryCallSettings<DeleteEventThreatDetectionCustomModuleRequest, Empty>
      deleteEventThreatDetectionCustomModuleSettings;
  private final UnaryCallSettings<
          ValidateEventThreatDetectionCustomModuleRequest,
          ValidateEventThreatDetectionCustomModuleResponse>
      validateEventThreatDetectionCustomModuleSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesResponse,
          EffectiveSecurityHealthAnalyticsCustomModule>
      LIST_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
              ListEffectiveSecurityHealthAnalyticsCustomModulesResponse,
              EffectiveSecurityHealthAnalyticsCustomModule>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEffectiveSecurityHealthAnalyticsCustomModulesRequest injectToken(
                ListEffectiveSecurityHealthAnalyticsCustomModulesRequest payload, String token) {
              return ListEffectiveSecurityHealthAnalyticsCustomModulesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListEffectiveSecurityHealthAnalyticsCustomModulesRequest injectPageSize(
                ListEffectiveSecurityHealthAnalyticsCustomModulesRequest payload, int pageSize) {
              return ListEffectiveSecurityHealthAnalyticsCustomModulesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(
                ListEffectiveSecurityHealthAnalyticsCustomModulesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(
                ListEffectiveSecurityHealthAnalyticsCustomModulesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<EffectiveSecurityHealthAnalyticsCustomModule> extractResources(
                ListEffectiveSecurityHealthAnalyticsCustomModulesResponse payload) {
              return payload.getEffectiveSecurityHealthAnalyticsCustomModulesList() == null
                  ? ImmutableList.<EffectiveSecurityHealthAnalyticsCustomModule>of()
                  : payload.getEffectiveSecurityHealthAnalyticsCustomModulesList();
            }
          };

  private static final PagedListDescriptor<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesResponse,
          SecurityHealthAnalyticsCustomModule>
      LIST_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListSecurityHealthAnalyticsCustomModulesRequest,
              ListSecurityHealthAnalyticsCustomModulesResponse,
              SecurityHealthAnalyticsCustomModule>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSecurityHealthAnalyticsCustomModulesRequest injectToken(
                ListSecurityHealthAnalyticsCustomModulesRequest payload, String token) {
              return ListSecurityHealthAnalyticsCustomModulesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListSecurityHealthAnalyticsCustomModulesRequest injectPageSize(
                ListSecurityHealthAnalyticsCustomModulesRequest payload, int pageSize) {
              return ListSecurityHealthAnalyticsCustomModulesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(
                ListSecurityHealthAnalyticsCustomModulesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(
                ListSecurityHealthAnalyticsCustomModulesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SecurityHealthAnalyticsCustomModule> extractResources(
                ListSecurityHealthAnalyticsCustomModulesResponse payload) {
              return payload.getSecurityHealthAnalyticsCustomModulesList() == null
                  ? ImmutableList.<SecurityHealthAnalyticsCustomModule>of()
                  : payload.getSecurityHealthAnalyticsCustomModulesList();
            }
          };

  private static final PagedListDescriptor<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesResponse,
          SecurityHealthAnalyticsCustomModule>
      LIST_DESCENDANT_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
              ListDescendantSecurityHealthAnalyticsCustomModulesResponse,
              SecurityHealthAnalyticsCustomModule>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDescendantSecurityHealthAnalyticsCustomModulesRequest injectToken(
                ListDescendantSecurityHealthAnalyticsCustomModulesRequest payload, String token) {
              return ListDescendantSecurityHealthAnalyticsCustomModulesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListDescendantSecurityHealthAnalyticsCustomModulesRequest injectPageSize(
                ListDescendantSecurityHealthAnalyticsCustomModulesRequest payload, int pageSize) {
              return ListDescendantSecurityHealthAnalyticsCustomModulesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(
                ListDescendantSecurityHealthAnalyticsCustomModulesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(
                ListDescendantSecurityHealthAnalyticsCustomModulesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SecurityHealthAnalyticsCustomModule> extractResources(
                ListDescendantSecurityHealthAnalyticsCustomModulesResponse payload) {
              return payload.getSecurityHealthAnalyticsCustomModulesList() == null
                  ? ImmutableList.<SecurityHealthAnalyticsCustomModule>of()
                  : payload.getSecurityHealthAnalyticsCustomModulesList();
            }
          };

  private static final PagedListDescriptor<
          ListEffectiveEventThreatDetectionCustomModulesRequest,
          ListEffectiveEventThreatDetectionCustomModulesResponse,
          EffectiveEventThreatDetectionCustomModule>
      LIST_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListEffectiveEventThreatDetectionCustomModulesRequest,
              ListEffectiveEventThreatDetectionCustomModulesResponse,
              EffectiveEventThreatDetectionCustomModule>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEffectiveEventThreatDetectionCustomModulesRequest injectToken(
                ListEffectiveEventThreatDetectionCustomModulesRequest payload, String token) {
              return ListEffectiveEventThreatDetectionCustomModulesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListEffectiveEventThreatDetectionCustomModulesRequest injectPageSize(
                ListEffectiveEventThreatDetectionCustomModulesRequest payload, int pageSize) {
              return ListEffectiveEventThreatDetectionCustomModulesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(
                ListEffectiveEventThreatDetectionCustomModulesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(
                ListEffectiveEventThreatDetectionCustomModulesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<EffectiveEventThreatDetectionCustomModule> extractResources(
                ListEffectiveEventThreatDetectionCustomModulesResponse payload) {
              return payload.getEffectiveEventThreatDetectionCustomModulesList() == null
                  ? ImmutableList.<EffectiveEventThreatDetectionCustomModule>of()
                  : payload.getEffectiveEventThreatDetectionCustomModulesList();
            }
          };

  private static final PagedListDescriptor<
          ListEventThreatDetectionCustomModulesRequest,
          ListEventThreatDetectionCustomModulesResponse,
          EventThreatDetectionCustomModule>
      LIST_EVENT_THREAT_DETECTION_CUSTOM_MODULES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListEventThreatDetectionCustomModulesRequest,
              ListEventThreatDetectionCustomModulesResponse,
              EventThreatDetectionCustomModule>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEventThreatDetectionCustomModulesRequest injectToken(
                ListEventThreatDetectionCustomModulesRequest payload, String token) {
              return ListEventThreatDetectionCustomModulesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListEventThreatDetectionCustomModulesRequest injectPageSize(
                ListEventThreatDetectionCustomModulesRequest payload, int pageSize) {
              return ListEventThreatDetectionCustomModulesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListEventThreatDetectionCustomModulesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEventThreatDetectionCustomModulesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<EventThreatDetectionCustomModule> extractResources(
                ListEventThreatDetectionCustomModulesResponse payload) {
              return payload.getEventThreatDetectionCustomModulesList() == null
                  ? ImmutableList.<EventThreatDetectionCustomModule>of()
                  : payload.getEventThreatDetectionCustomModulesList();
            }
          };

  private static final PagedListDescriptor<
          ListDescendantEventThreatDetectionCustomModulesRequest,
          ListDescendantEventThreatDetectionCustomModulesResponse,
          EventThreatDetectionCustomModule>
      LIST_DESCENDANT_EVENT_THREAT_DETECTION_CUSTOM_MODULES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDescendantEventThreatDetectionCustomModulesRequest,
              ListDescendantEventThreatDetectionCustomModulesResponse,
              EventThreatDetectionCustomModule>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDescendantEventThreatDetectionCustomModulesRequest injectToken(
                ListDescendantEventThreatDetectionCustomModulesRequest payload, String token) {
              return ListDescendantEventThreatDetectionCustomModulesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListDescendantEventThreatDetectionCustomModulesRequest injectPageSize(
                ListDescendantEventThreatDetectionCustomModulesRequest payload, int pageSize) {
              return ListDescendantEventThreatDetectionCustomModulesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(
                ListDescendantEventThreatDetectionCustomModulesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(
                ListDescendantEventThreatDetectionCustomModulesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<EventThreatDetectionCustomModule> extractResources(
                ListDescendantEventThreatDetectionCustomModulesResponse payload) {
              return payload.getEventThreatDetectionCustomModulesList() == null
                  ? ImmutableList.<EventThreatDetectionCustomModule>of()
                  : payload.getEventThreatDetectionCustomModulesList();
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
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesResponse,
          ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse>
      LIST_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
              ListEffectiveSecurityHealthAnalyticsCustomModulesResponse,
              ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse>() {
            @Override
            public ApiFuture<ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse>
                getFuturePagedResponse(
                    UnaryCallable<
                            ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
                            ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>
                        callable,
                    ListEffectiveSecurityHealthAnalyticsCustomModulesRequest request,
                    ApiCallContext context,
                    ApiFuture<ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>
                        futureResponse) {
              PageContext<
                      ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
                      ListEffectiveSecurityHealthAnalyticsCustomModulesResponse,
                      EffectiveSecurityHealthAnalyticsCustomModule>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULES_PAGE_STR_DESC,
                          request,
                          context);
              return ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesResponse,
          ListSecurityHealthAnalyticsCustomModulesPagedResponse>
      LIST_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSecurityHealthAnalyticsCustomModulesRequest,
              ListSecurityHealthAnalyticsCustomModulesResponse,
              ListSecurityHealthAnalyticsCustomModulesPagedResponse>() {
            @Override
            public ApiFuture<ListSecurityHealthAnalyticsCustomModulesPagedResponse>
                getFuturePagedResponse(
                    UnaryCallable<
                            ListSecurityHealthAnalyticsCustomModulesRequest,
                            ListSecurityHealthAnalyticsCustomModulesResponse>
                        callable,
                    ListSecurityHealthAnalyticsCustomModulesRequest request,
                    ApiCallContext context,
                    ApiFuture<ListSecurityHealthAnalyticsCustomModulesResponse> futureResponse) {
              PageContext<
                      ListSecurityHealthAnalyticsCustomModulesRequest,
                      ListSecurityHealthAnalyticsCustomModulesResponse,
                      SecurityHealthAnalyticsCustomModule>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULES_PAGE_STR_DESC,
                          request,
                          context);
              return ListSecurityHealthAnalyticsCustomModulesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesResponse,
          ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse>
      LIST_DESCENDANT_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
              ListDescendantSecurityHealthAnalyticsCustomModulesResponse,
              ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse>() {
            @Override
            public ApiFuture<ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse>
                getFuturePagedResponse(
                    UnaryCallable<
                            ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
                            ListDescendantSecurityHealthAnalyticsCustomModulesResponse>
                        callable,
                    ListDescendantSecurityHealthAnalyticsCustomModulesRequest request,
                    ApiCallContext context,
                    ApiFuture<ListDescendantSecurityHealthAnalyticsCustomModulesResponse>
                        futureResponse) {
              PageContext<
                      ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
                      ListDescendantSecurityHealthAnalyticsCustomModulesResponse,
                      SecurityHealthAnalyticsCustomModule>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_DESCENDANT_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULES_PAGE_STR_DESC,
                          request,
                          context);
              return ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListEffectiveEventThreatDetectionCustomModulesRequest,
          ListEffectiveEventThreatDetectionCustomModulesResponse,
          ListEffectiveEventThreatDetectionCustomModulesPagedResponse>
      LIST_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEffectiveEventThreatDetectionCustomModulesRequest,
              ListEffectiveEventThreatDetectionCustomModulesResponse,
              ListEffectiveEventThreatDetectionCustomModulesPagedResponse>() {
            @Override
            public ApiFuture<ListEffectiveEventThreatDetectionCustomModulesPagedResponse>
                getFuturePagedResponse(
                    UnaryCallable<
                            ListEffectiveEventThreatDetectionCustomModulesRequest,
                            ListEffectiveEventThreatDetectionCustomModulesResponse>
                        callable,
                    ListEffectiveEventThreatDetectionCustomModulesRequest request,
                    ApiCallContext context,
                    ApiFuture<ListEffectiveEventThreatDetectionCustomModulesResponse>
                        futureResponse) {
              PageContext<
                      ListEffectiveEventThreatDetectionCustomModulesRequest,
                      ListEffectiveEventThreatDetectionCustomModulesResponse,
                      EffectiveEventThreatDetectionCustomModule>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULES_PAGE_STR_DESC,
                          request,
                          context);
              return ListEffectiveEventThreatDetectionCustomModulesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListEventThreatDetectionCustomModulesRequest,
          ListEventThreatDetectionCustomModulesResponse,
          ListEventThreatDetectionCustomModulesPagedResponse>
      LIST_EVENT_THREAT_DETECTION_CUSTOM_MODULES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEventThreatDetectionCustomModulesRequest,
              ListEventThreatDetectionCustomModulesResponse,
              ListEventThreatDetectionCustomModulesPagedResponse>() {
            @Override
            public ApiFuture<ListEventThreatDetectionCustomModulesPagedResponse>
                getFuturePagedResponse(
                    UnaryCallable<
                            ListEventThreatDetectionCustomModulesRequest,
                            ListEventThreatDetectionCustomModulesResponse>
                        callable,
                    ListEventThreatDetectionCustomModulesRequest request,
                    ApiCallContext context,
                    ApiFuture<ListEventThreatDetectionCustomModulesResponse> futureResponse) {
              PageContext<
                      ListEventThreatDetectionCustomModulesRequest,
                      ListEventThreatDetectionCustomModulesResponse,
                      EventThreatDetectionCustomModule>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_EVENT_THREAT_DETECTION_CUSTOM_MODULES_PAGE_STR_DESC,
                          request,
                          context);
              return ListEventThreatDetectionCustomModulesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDescendantEventThreatDetectionCustomModulesRequest,
          ListDescendantEventThreatDetectionCustomModulesResponse,
          ListDescendantEventThreatDetectionCustomModulesPagedResponse>
      LIST_DESCENDANT_EVENT_THREAT_DETECTION_CUSTOM_MODULES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDescendantEventThreatDetectionCustomModulesRequest,
              ListDescendantEventThreatDetectionCustomModulesResponse,
              ListDescendantEventThreatDetectionCustomModulesPagedResponse>() {
            @Override
            public ApiFuture<ListDescendantEventThreatDetectionCustomModulesPagedResponse>
                getFuturePagedResponse(
                    UnaryCallable<
                            ListDescendantEventThreatDetectionCustomModulesRequest,
                            ListDescendantEventThreatDetectionCustomModulesResponse>
                        callable,
                    ListDescendantEventThreatDetectionCustomModulesRequest request,
                    ApiCallContext context,
                    ApiFuture<ListDescendantEventThreatDetectionCustomModulesResponse>
                        futureResponse) {
              PageContext<
                      ListDescendantEventThreatDetectionCustomModulesRequest,
                      ListDescendantEventThreatDetectionCustomModulesResponse,
                      EventThreatDetectionCustomModule>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_DESCENDANT_EVENT_THREAT_DETECTION_CUSTOM_MODULES_PAGE_STR_DESC,
                          request,
                          context);
              return ListDescendantEventThreatDetectionCustomModulesPagedResponse.createAsync(
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

  /**
   * Returns the object with the settings used for calls to
   * listEffectiveSecurityHealthAnalyticsCustomModules.
   */
  public PagedCallSettings<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesResponse,
          ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse>
      listEffectiveSecurityHealthAnalyticsCustomModulesSettings() {
    return listEffectiveSecurityHealthAnalyticsCustomModulesSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * getEffectiveSecurityHealthAnalyticsCustomModule.
   */
  public UnaryCallSettings<
          GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
          EffectiveSecurityHealthAnalyticsCustomModule>
      getEffectiveSecurityHealthAnalyticsCustomModuleSettings() {
    return getEffectiveSecurityHealthAnalyticsCustomModuleSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * listSecurityHealthAnalyticsCustomModules.
   */
  public PagedCallSettings<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesResponse,
          ListSecurityHealthAnalyticsCustomModulesPagedResponse>
      listSecurityHealthAnalyticsCustomModulesSettings() {
    return listSecurityHealthAnalyticsCustomModulesSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * listDescendantSecurityHealthAnalyticsCustomModules.
   */
  public PagedCallSettings<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesResponse,
          ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse>
      listDescendantSecurityHealthAnalyticsCustomModulesSettings() {
    return listDescendantSecurityHealthAnalyticsCustomModulesSettings;
  }

  /**
   * Returns the object with the settings used for calls to getSecurityHealthAnalyticsCustomModule.
   */
  public UnaryCallSettings<
          GetSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      getSecurityHealthAnalyticsCustomModuleSettings() {
    return getSecurityHealthAnalyticsCustomModuleSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * createSecurityHealthAnalyticsCustomModule.
   */
  public UnaryCallSettings<
          CreateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      createSecurityHealthAnalyticsCustomModuleSettings() {
    return createSecurityHealthAnalyticsCustomModuleSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * updateSecurityHealthAnalyticsCustomModule.
   */
  public UnaryCallSettings<
          UpdateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      updateSecurityHealthAnalyticsCustomModuleSettings() {
    return updateSecurityHealthAnalyticsCustomModuleSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * deleteSecurityHealthAnalyticsCustomModule.
   */
  public UnaryCallSettings<DeleteSecurityHealthAnalyticsCustomModuleRequest, Empty>
      deleteSecurityHealthAnalyticsCustomModuleSettings() {
    return deleteSecurityHealthAnalyticsCustomModuleSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * simulateSecurityHealthAnalyticsCustomModule.
   */
  public UnaryCallSettings<
          SimulateSecurityHealthAnalyticsCustomModuleRequest,
          SimulateSecurityHealthAnalyticsCustomModuleResponse>
      simulateSecurityHealthAnalyticsCustomModuleSettings() {
    return simulateSecurityHealthAnalyticsCustomModuleSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * listEffectiveEventThreatDetectionCustomModules.
   */
  public PagedCallSettings<
          ListEffectiveEventThreatDetectionCustomModulesRequest,
          ListEffectiveEventThreatDetectionCustomModulesResponse,
          ListEffectiveEventThreatDetectionCustomModulesPagedResponse>
      listEffectiveEventThreatDetectionCustomModulesSettings() {
    return listEffectiveEventThreatDetectionCustomModulesSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * getEffectiveEventThreatDetectionCustomModule.
   */
  public UnaryCallSettings<
          GetEffectiveEventThreatDetectionCustomModuleRequest,
          EffectiveEventThreatDetectionCustomModule>
      getEffectiveEventThreatDetectionCustomModuleSettings() {
    return getEffectiveEventThreatDetectionCustomModuleSettings;
  }

  /**
   * Returns the object with the settings used for calls to listEventThreatDetectionCustomModules.
   */
  public PagedCallSettings<
          ListEventThreatDetectionCustomModulesRequest,
          ListEventThreatDetectionCustomModulesResponse,
          ListEventThreatDetectionCustomModulesPagedResponse>
      listEventThreatDetectionCustomModulesSettings() {
    return listEventThreatDetectionCustomModulesSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * listDescendantEventThreatDetectionCustomModules.
   */
  public PagedCallSettings<
          ListDescendantEventThreatDetectionCustomModulesRequest,
          ListDescendantEventThreatDetectionCustomModulesResponse,
          ListDescendantEventThreatDetectionCustomModulesPagedResponse>
      listDescendantEventThreatDetectionCustomModulesSettings() {
    return listDescendantEventThreatDetectionCustomModulesSettings;
  }

  /** Returns the object with the settings used for calls to getEventThreatDetectionCustomModule. */
  public UnaryCallSettings<
          GetEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      getEventThreatDetectionCustomModuleSettings() {
    return getEventThreatDetectionCustomModuleSettings;
  }

  /**
   * Returns the object with the settings used for calls to createEventThreatDetectionCustomModule.
   */
  public UnaryCallSettings<
          CreateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      createEventThreatDetectionCustomModuleSettings() {
    return createEventThreatDetectionCustomModuleSettings;
  }

  /**
   * Returns the object with the settings used for calls to updateEventThreatDetectionCustomModule.
   */
  public UnaryCallSettings<
          UpdateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      updateEventThreatDetectionCustomModuleSettings() {
    return updateEventThreatDetectionCustomModuleSettings;
  }

  /**
   * Returns the object with the settings used for calls to deleteEventThreatDetectionCustomModule.
   */
  public UnaryCallSettings<DeleteEventThreatDetectionCustomModuleRequest, Empty>
      deleteEventThreatDetectionCustomModuleSettings() {
    return deleteEventThreatDetectionCustomModuleSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * validateEventThreatDetectionCustomModule.
   */
  public UnaryCallSettings<
          ValidateEventThreatDetectionCustomModuleRequest,
          ValidateEventThreatDetectionCustomModuleResponse>
      validateEventThreatDetectionCustomModuleSettings() {
    return validateEventThreatDetectionCustomModuleSettings;
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

  public SecurityCenterManagementStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcSecurityCenterManagementStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonSecurityCenterManagementStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "securitycentermanagement";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "securitycentermanagement.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "securitycentermanagement.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(SecurityCenterManagementStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(SecurityCenterManagementStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SecurityCenterManagementStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected SecurityCenterManagementStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listEffectiveSecurityHealthAnalyticsCustomModulesSettings =
        settingsBuilder.listEffectiveSecurityHealthAnalyticsCustomModulesSettings().build();
    getEffectiveSecurityHealthAnalyticsCustomModuleSettings =
        settingsBuilder.getEffectiveSecurityHealthAnalyticsCustomModuleSettings().build();
    listSecurityHealthAnalyticsCustomModulesSettings =
        settingsBuilder.listSecurityHealthAnalyticsCustomModulesSettings().build();
    listDescendantSecurityHealthAnalyticsCustomModulesSettings =
        settingsBuilder.listDescendantSecurityHealthAnalyticsCustomModulesSettings().build();
    getSecurityHealthAnalyticsCustomModuleSettings =
        settingsBuilder.getSecurityHealthAnalyticsCustomModuleSettings().build();
    createSecurityHealthAnalyticsCustomModuleSettings =
        settingsBuilder.createSecurityHealthAnalyticsCustomModuleSettings().build();
    updateSecurityHealthAnalyticsCustomModuleSettings =
        settingsBuilder.updateSecurityHealthAnalyticsCustomModuleSettings().build();
    deleteSecurityHealthAnalyticsCustomModuleSettings =
        settingsBuilder.deleteSecurityHealthAnalyticsCustomModuleSettings().build();
    simulateSecurityHealthAnalyticsCustomModuleSettings =
        settingsBuilder.simulateSecurityHealthAnalyticsCustomModuleSettings().build();
    listEffectiveEventThreatDetectionCustomModulesSettings =
        settingsBuilder.listEffectiveEventThreatDetectionCustomModulesSettings().build();
    getEffectiveEventThreatDetectionCustomModuleSettings =
        settingsBuilder.getEffectiveEventThreatDetectionCustomModuleSettings().build();
    listEventThreatDetectionCustomModulesSettings =
        settingsBuilder.listEventThreatDetectionCustomModulesSettings().build();
    listDescendantEventThreatDetectionCustomModulesSettings =
        settingsBuilder.listDescendantEventThreatDetectionCustomModulesSettings().build();
    getEventThreatDetectionCustomModuleSettings =
        settingsBuilder.getEventThreatDetectionCustomModuleSettings().build();
    createEventThreatDetectionCustomModuleSettings =
        settingsBuilder.createEventThreatDetectionCustomModuleSettings().build();
    updateEventThreatDetectionCustomModuleSettings =
        settingsBuilder.updateEventThreatDetectionCustomModuleSettings().build();
    deleteEventThreatDetectionCustomModuleSettings =
        settingsBuilder.deleteEventThreatDetectionCustomModuleSettings().build();
    validateEventThreatDetectionCustomModuleSettings =
        settingsBuilder.validateEventThreatDetectionCustomModuleSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for SecurityCenterManagementStubSettings. */
  public static class Builder
      extends StubSettings.Builder<SecurityCenterManagementStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
            ListEffectiveSecurityHealthAnalyticsCustomModulesResponse,
            ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse>
        listEffectiveSecurityHealthAnalyticsCustomModulesSettings;
    private final UnaryCallSettings.Builder<
            GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
            EffectiveSecurityHealthAnalyticsCustomModule>
        getEffectiveSecurityHealthAnalyticsCustomModuleSettings;
    private final PagedCallSettings.Builder<
            ListSecurityHealthAnalyticsCustomModulesRequest,
            ListSecurityHealthAnalyticsCustomModulesResponse,
            ListSecurityHealthAnalyticsCustomModulesPagedResponse>
        listSecurityHealthAnalyticsCustomModulesSettings;
    private final PagedCallSettings.Builder<
            ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
            ListDescendantSecurityHealthAnalyticsCustomModulesResponse,
            ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse>
        listDescendantSecurityHealthAnalyticsCustomModulesSettings;
    private final UnaryCallSettings.Builder<
            GetSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
        getSecurityHealthAnalyticsCustomModuleSettings;
    private final UnaryCallSettings.Builder<
            CreateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
        createSecurityHealthAnalyticsCustomModuleSettings;
    private final UnaryCallSettings.Builder<
            UpdateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
        updateSecurityHealthAnalyticsCustomModuleSettings;
    private final UnaryCallSettings.Builder<DeleteSecurityHealthAnalyticsCustomModuleRequest, Empty>
        deleteSecurityHealthAnalyticsCustomModuleSettings;
    private final UnaryCallSettings.Builder<
            SimulateSecurityHealthAnalyticsCustomModuleRequest,
            SimulateSecurityHealthAnalyticsCustomModuleResponse>
        simulateSecurityHealthAnalyticsCustomModuleSettings;
    private final PagedCallSettings.Builder<
            ListEffectiveEventThreatDetectionCustomModulesRequest,
            ListEffectiveEventThreatDetectionCustomModulesResponse,
            ListEffectiveEventThreatDetectionCustomModulesPagedResponse>
        listEffectiveEventThreatDetectionCustomModulesSettings;
    private final UnaryCallSettings.Builder<
            GetEffectiveEventThreatDetectionCustomModuleRequest,
            EffectiveEventThreatDetectionCustomModule>
        getEffectiveEventThreatDetectionCustomModuleSettings;
    private final PagedCallSettings.Builder<
            ListEventThreatDetectionCustomModulesRequest,
            ListEventThreatDetectionCustomModulesResponse,
            ListEventThreatDetectionCustomModulesPagedResponse>
        listEventThreatDetectionCustomModulesSettings;
    private final PagedCallSettings.Builder<
            ListDescendantEventThreatDetectionCustomModulesRequest,
            ListDescendantEventThreatDetectionCustomModulesResponse,
            ListDescendantEventThreatDetectionCustomModulesPagedResponse>
        listDescendantEventThreatDetectionCustomModulesSettings;
    private final UnaryCallSettings.Builder<
            GetEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
        getEventThreatDetectionCustomModuleSettings;
    private final UnaryCallSettings.Builder<
            CreateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
        createEventThreatDetectionCustomModuleSettings;
    private final UnaryCallSettings.Builder<
            UpdateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
        updateEventThreatDetectionCustomModuleSettings;
    private final UnaryCallSettings.Builder<DeleteEventThreatDetectionCustomModuleRequest, Empty>
        deleteEventThreatDetectionCustomModuleSettings;
    private final UnaryCallSettings.Builder<
            ValidateEventThreatDetectionCustomModuleRequest,
            ValidateEventThreatDetectionCustomModuleResponse>
        validateEventThreatDetectionCustomModuleSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
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
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
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

      listEffectiveSecurityHealthAnalyticsCustomModulesSettings =
          PagedCallSettings.newBuilder(
              LIST_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULES_PAGE_STR_FACT);
      getEffectiveSecurityHealthAnalyticsCustomModuleSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSecurityHealthAnalyticsCustomModulesSettings =
          PagedCallSettings.newBuilder(LIST_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULES_PAGE_STR_FACT);
      listDescendantSecurityHealthAnalyticsCustomModulesSettings =
          PagedCallSettings.newBuilder(
              LIST_DESCENDANT_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULES_PAGE_STR_FACT);
      getSecurityHealthAnalyticsCustomModuleSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSecurityHealthAnalyticsCustomModuleSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSecurityHealthAnalyticsCustomModuleSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSecurityHealthAnalyticsCustomModuleSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      simulateSecurityHealthAnalyticsCustomModuleSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      listEffectiveEventThreatDetectionCustomModulesSettings =
          PagedCallSettings.newBuilder(
              LIST_EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULES_PAGE_STR_FACT);
      getEffectiveEventThreatDetectionCustomModuleSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      listEventThreatDetectionCustomModulesSettings =
          PagedCallSettings.newBuilder(LIST_EVENT_THREAT_DETECTION_CUSTOM_MODULES_PAGE_STR_FACT);
      listDescendantEventThreatDetectionCustomModulesSettings =
          PagedCallSettings.newBuilder(
              LIST_DESCENDANT_EVENT_THREAT_DETECTION_CUSTOM_MODULES_PAGE_STR_FACT);
      getEventThreatDetectionCustomModuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEventThreatDetectionCustomModuleSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEventThreatDetectionCustomModuleSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEventThreatDetectionCustomModuleSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      validateEventThreatDetectionCustomModuleSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listEffectiveSecurityHealthAnalyticsCustomModulesSettings,
              getEffectiveSecurityHealthAnalyticsCustomModuleSettings,
              listSecurityHealthAnalyticsCustomModulesSettings,
              listDescendantSecurityHealthAnalyticsCustomModulesSettings,
              getSecurityHealthAnalyticsCustomModuleSettings,
              createSecurityHealthAnalyticsCustomModuleSettings,
              updateSecurityHealthAnalyticsCustomModuleSettings,
              deleteSecurityHealthAnalyticsCustomModuleSettings,
              simulateSecurityHealthAnalyticsCustomModuleSettings,
              listEffectiveEventThreatDetectionCustomModulesSettings,
              getEffectiveEventThreatDetectionCustomModuleSettings,
              listEventThreatDetectionCustomModulesSettings,
              listDescendantEventThreatDetectionCustomModulesSettings,
              getEventThreatDetectionCustomModuleSettings,
              createEventThreatDetectionCustomModuleSettings,
              updateEventThreatDetectionCustomModuleSettings,
              deleteEventThreatDetectionCustomModuleSettings,
              validateEventThreatDetectionCustomModuleSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(SecurityCenterManagementStubSettings settings) {
      super(settings);

      listEffectiveSecurityHealthAnalyticsCustomModulesSettings =
          settings.listEffectiveSecurityHealthAnalyticsCustomModulesSettings.toBuilder();
      getEffectiveSecurityHealthAnalyticsCustomModuleSettings =
          settings.getEffectiveSecurityHealthAnalyticsCustomModuleSettings.toBuilder();
      listSecurityHealthAnalyticsCustomModulesSettings =
          settings.listSecurityHealthAnalyticsCustomModulesSettings.toBuilder();
      listDescendantSecurityHealthAnalyticsCustomModulesSettings =
          settings.listDescendantSecurityHealthAnalyticsCustomModulesSettings.toBuilder();
      getSecurityHealthAnalyticsCustomModuleSettings =
          settings.getSecurityHealthAnalyticsCustomModuleSettings.toBuilder();
      createSecurityHealthAnalyticsCustomModuleSettings =
          settings.createSecurityHealthAnalyticsCustomModuleSettings.toBuilder();
      updateSecurityHealthAnalyticsCustomModuleSettings =
          settings.updateSecurityHealthAnalyticsCustomModuleSettings.toBuilder();
      deleteSecurityHealthAnalyticsCustomModuleSettings =
          settings.deleteSecurityHealthAnalyticsCustomModuleSettings.toBuilder();
      simulateSecurityHealthAnalyticsCustomModuleSettings =
          settings.simulateSecurityHealthAnalyticsCustomModuleSettings.toBuilder();
      listEffectiveEventThreatDetectionCustomModulesSettings =
          settings.listEffectiveEventThreatDetectionCustomModulesSettings.toBuilder();
      getEffectiveEventThreatDetectionCustomModuleSettings =
          settings.getEffectiveEventThreatDetectionCustomModuleSettings.toBuilder();
      listEventThreatDetectionCustomModulesSettings =
          settings.listEventThreatDetectionCustomModulesSettings.toBuilder();
      listDescendantEventThreatDetectionCustomModulesSettings =
          settings.listDescendantEventThreatDetectionCustomModulesSettings.toBuilder();
      getEventThreatDetectionCustomModuleSettings =
          settings.getEventThreatDetectionCustomModuleSettings.toBuilder();
      createEventThreatDetectionCustomModuleSettings =
          settings.createEventThreatDetectionCustomModuleSettings.toBuilder();
      updateEventThreatDetectionCustomModuleSettings =
          settings.updateEventThreatDetectionCustomModuleSettings.toBuilder();
      deleteEventThreatDetectionCustomModuleSettings =
          settings.deleteEventThreatDetectionCustomModuleSettings.toBuilder();
      validateEventThreatDetectionCustomModuleSettings =
          settings.validateEventThreatDetectionCustomModuleSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listEffectiveSecurityHealthAnalyticsCustomModulesSettings,
              getEffectiveSecurityHealthAnalyticsCustomModuleSettings,
              listSecurityHealthAnalyticsCustomModulesSettings,
              listDescendantSecurityHealthAnalyticsCustomModulesSettings,
              getSecurityHealthAnalyticsCustomModuleSettings,
              createSecurityHealthAnalyticsCustomModuleSettings,
              updateSecurityHealthAnalyticsCustomModuleSettings,
              deleteSecurityHealthAnalyticsCustomModuleSettings,
              simulateSecurityHealthAnalyticsCustomModuleSettings,
              listEffectiveEventThreatDetectionCustomModulesSettings,
              getEffectiveEventThreatDetectionCustomModuleSettings,
              listEventThreatDetectionCustomModulesSettings,
              listDescendantEventThreatDetectionCustomModulesSettings,
              getEventThreatDetectionCustomModuleSettings,
              createEventThreatDetectionCustomModuleSettings,
              updateEventThreatDetectionCustomModuleSettings,
              deleteEventThreatDetectionCustomModuleSettings,
              validateEventThreatDetectionCustomModuleSettings,
              listLocationsSettings,
              getLocationSettings);
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
          .listEffectiveSecurityHealthAnalyticsCustomModulesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getEffectiveSecurityHealthAnalyticsCustomModuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listSecurityHealthAnalyticsCustomModulesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDescendantSecurityHealthAnalyticsCustomModulesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getSecurityHealthAnalyticsCustomModuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createSecurityHealthAnalyticsCustomModuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateSecurityHealthAnalyticsCustomModuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteSecurityHealthAnalyticsCustomModuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .simulateSecurityHealthAnalyticsCustomModuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listEffectiveEventThreatDetectionCustomModulesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getEffectiveEventThreatDetectionCustomModuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listEventThreatDetectionCustomModulesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDescendantEventThreatDetectionCustomModulesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getEventThreatDetectionCustomModuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createEventThreatDetectionCustomModuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateEventThreatDetectionCustomModuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteEventThreatDetectionCustomModuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .validateEventThreatDetectionCustomModuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

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

    /**
     * Returns the builder for the settings used for calls to
     * listEffectiveSecurityHealthAnalyticsCustomModules.
     */
    public PagedCallSettings.Builder<
            ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
            ListEffectiveSecurityHealthAnalyticsCustomModulesResponse,
            ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse>
        listEffectiveSecurityHealthAnalyticsCustomModulesSettings() {
      return listEffectiveSecurityHealthAnalyticsCustomModulesSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * getEffectiveSecurityHealthAnalyticsCustomModule.
     */
    public UnaryCallSettings.Builder<
            GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
            EffectiveSecurityHealthAnalyticsCustomModule>
        getEffectiveSecurityHealthAnalyticsCustomModuleSettings() {
      return getEffectiveSecurityHealthAnalyticsCustomModuleSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * listSecurityHealthAnalyticsCustomModules.
     */
    public PagedCallSettings.Builder<
            ListSecurityHealthAnalyticsCustomModulesRequest,
            ListSecurityHealthAnalyticsCustomModulesResponse,
            ListSecurityHealthAnalyticsCustomModulesPagedResponse>
        listSecurityHealthAnalyticsCustomModulesSettings() {
      return listSecurityHealthAnalyticsCustomModulesSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * listDescendantSecurityHealthAnalyticsCustomModules.
     */
    public PagedCallSettings.Builder<
            ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
            ListDescendantSecurityHealthAnalyticsCustomModulesResponse,
            ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse>
        listDescendantSecurityHealthAnalyticsCustomModulesSettings() {
      return listDescendantSecurityHealthAnalyticsCustomModulesSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * getSecurityHealthAnalyticsCustomModule.
     */
    public UnaryCallSettings.Builder<
            GetSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
        getSecurityHealthAnalyticsCustomModuleSettings() {
      return getSecurityHealthAnalyticsCustomModuleSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * createSecurityHealthAnalyticsCustomModule.
     */
    public UnaryCallSettings.Builder<
            CreateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
        createSecurityHealthAnalyticsCustomModuleSettings() {
      return createSecurityHealthAnalyticsCustomModuleSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * updateSecurityHealthAnalyticsCustomModule.
     */
    public UnaryCallSettings.Builder<
            UpdateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
        updateSecurityHealthAnalyticsCustomModuleSettings() {
      return updateSecurityHealthAnalyticsCustomModuleSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * deleteSecurityHealthAnalyticsCustomModule.
     */
    public UnaryCallSettings.Builder<DeleteSecurityHealthAnalyticsCustomModuleRequest, Empty>
        deleteSecurityHealthAnalyticsCustomModuleSettings() {
      return deleteSecurityHealthAnalyticsCustomModuleSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * simulateSecurityHealthAnalyticsCustomModule.
     */
    public UnaryCallSettings.Builder<
            SimulateSecurityHealthAnalyticsCustomModuleRequest,
            SimulateSecurityHealthAnalyticsCustomModuleResponse>
        simulateSecurityHealthAnalyticsCustomModuleSettings() {
      return simulateSecurityHealthAnalyticsCustomModuleSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * listEffectiveEventThreatDetectionCustomModules.
     */
    public PagedCallSettings.Builder<
            ListEffectiveEventThreatDetectionCustomModulesRequest,
            ListEffectiveEventThreatDetectionCustomModulesResponse,
            ListEffectiveEventThreatDetectionCustomModulesPagedResponse>
        listEffectiveEventThreatDetectionCustomModulesSettings() {
      return listEffectiveEventThreatDetectionCustomModulesSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * getEffectiveEventThreatDetectionCustomModule.
     */
    public UnaryCallSettings.Builder<
            GetEffectiveEventThreatDetectionCustomModuleRequest,
            EffectiveEventThreatDetectionCustomModule>
        getEffectiveEventThreatDetectionCustomModuleSettings() {
      return getEffectiveEventThreatDetectionCustomModuleSettings;
    }

    /**
     * Returns the builder for the settings used for calls to listEventThreatDetectionCustomModules.
     */
    public PagedCallSettings.Builder<
            ListEventThreatDetectionCustomModulesRequest,
            ListEventThreatDetectionCustomModulesResponse,
            ListEventThreatDetectionCustomModulesPagedResponse>
        listEventThreatDetectionCustomModulesSettings() {
      return listEventThreatDetectionCustomModulesSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * listDescendantEventThreatDetectionCustomModules.
     */
    public PagedCallSettings.Builder<
            ListDescendantEventThreatDetectionCustomModulesRequest,
            ListDescendantEventThreatDetectionCustomModulesResponse,
            ListDescendantEventThreatDetectionCustomModulesPagedResponse>
        listDescendantEventThreatDetectionCustomModulesSettings() {
      return listDescendantEventThreatDetectionCustomModulesSettings;
    }

    /**
     * Returns the builder for the settings used for calls to getEventThreatDetectionCustomModule.
     */
    public UnaryCallSettings.Builder<
            GetEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
        getEventThreatDetectionCustomModuleSettings() {
      return getEventThreatDetectionCustomModuleSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * createEventThreatDetectionCustomModule.
     */
    public UnaryCallSettings.Builder<
            CreateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
        createEventThreatDetectionCustomModuleSettings() {
      return createEventThreatDetectionCustomModuleSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * updateEventThreatDetectionCustomModule.
     */
    public UnaryCallSettings.Builder<
            UpdateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
        updateEventThreatDetectionCustomModuleSettings() {
      return updateEventThreatDetectionCustomModuleSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * deleteEventThreatDetectionCustomModule.
     */
    public UnaryCallSettings.Builder<DeleteEventThreatDetectionCustomModuleRequest, Empty>
        deleteEventThreatDetectionCustomModuleSettings() {
      return deleteEventThreatDetectionCustomModuleSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * validateEventThreatDetectionCustomModule.
     */
    public UnaryCallSettings.Builder<
            ValidateEventThreatDetectionCustomModuleRequest,
            ValidateEventThreatDetectionCustomModuleResponse>
        validateEventThreatDetectionCustomModuleSettings() {
      return validateEventThreatDetectionCustomModuleSettings;
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

    @Override
    public SecurityCenterManagementStubSettings build() throws IOException {
      return new SecurityCenterManagementStubSettings(this);
    }
  }
}
