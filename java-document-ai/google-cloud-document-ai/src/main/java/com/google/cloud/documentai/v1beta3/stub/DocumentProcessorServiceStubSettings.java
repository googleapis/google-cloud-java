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

package com.google.cloud.documentai.v1beta3.stub;

import static com.google.cloud.documentai.v1beta3.DocumentProcessorServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.documentai.v1beta3.DocumentProcessorServiceClient.ListProcessorTypesPagedResponse;
import static com.google.cloud.documentai.v1beta3.DocumentProcessorServiceClient.ListProcessorVersionsPagedResponse;
import static com.google.cloud.documentai.v1beta3.DocumentProcessorServiceClient.ListProcessorsPagedResponse;

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
import com.google.cloud.documentai.v1beta3.BatchProcessMetadata;
import com.google.cloud.documentai.v1beta3.BatchProcessRequest;
import com.google.cloud.documentai.v1beta3.BatchProcessResponse;
import com.google.cloud.documentai.v1beta3.CreateProcessorRequest;
import com.google.cloud.documentai.v1beta3.DeleteProcessorMetadata;
import com.google.cloud.documentai.v1beta3.DeleteProcessorRequest;
import com.google.cloud.documentai.v1beta3.DeleteProcessorVersionMetadata;
import com.google.cloud.documentai.v1beta3.DeleteProcessorVersionRequest;
import com.google.cloud.documentai.v1beta3.DeployProcessorVersionMetadata;
import com.google.cloud.documentai.v1beta3.DeployProcessorVersionRequest;
import com.google.cloud.documentai.v1beta3.DeployProcessorVersionResponse;
import com.google.cloud.documentai.v1beta3.DisableProcessorMetadata;
import com.google.cloud.documentai.v1beta3.DisableProcessorRequest;
import com.google.cloud.documentai.v1beta3.DisableProcessorResponse;
import com.google.cloud.documentai.v1beta3.EnableProcessorMetadata;
import com.google.cloud.documentai.v1beta3.EnableProcessorRequest;
import com.google.cloud.documentai.v1beta3.EnableProcessorResponse;
import com.google.cloud.documentai.v1beta3.FetchProcessorTypesRequest;
import com.google.cloud.documentai.v1beta3.FetchProcessorTypesResponse;
import com.google.cloud.documentai.v1beta3.GetProcessorRequest;
import com.google.cloud.documentai.v1beta3.GetProcessorVersionRequest;
import com.google.cloud.documentai.v1beta3.ListProcessorTypesRequest;
import com.google.cloud.documentai.v1beta3.ListProcessorTypesResponse;
import com.google.cloud.documentai.v1beta3.ListProcessorVersionsRequest;
import com.google.cloud.documentai.v1beta3.ListProcessorVersionsResponse;
import com.google.cloud.documentai.v1beta3.ListProcessorsRequest;
import com.google.cloud.documentai.v1beta3.ListProcessorsResponse;
import com.google.cloud.documentai.v1beta3.ProcessRequest;
import com.google.cloud.documentai.v1beta3.ProcessResponse;
import com.google.cloud.documentai.v1beta3.Processor;
import com.google.cloud.documentai.v1beta3.ProcessorType;
import com.google.cloud.documentai.v1beta3.ProcessorVersion;
import com.google.cloud.documentai.v1beta3.ReviewDocumentOperationMetadata;
import com.google.cloud.documentai.v1beta3.ReviewDocumentRequest;
import com.google.cloud.documentai.v1beta3.ReviewDocumentResponse;
import com.google.cloud.documentai.v1beta3.SetDefaultProcessorVersionMetadata;
import com.google.cloud.documentai.v1beta3.SetDefaultProcessorVersionRequest;
import com.google.cloud.documentai.v1beta3.SetDefaultProcessorVersionResponse;
import com.google.cloud.documentai.v1beta3.UndeployProcessorVersionMetadata;
import com.google.cloud.documentai.v1beta3.UndeployProcessorVersionRequest;
import com.google.cloud.documentai.v1beta3.UndeployProcessorVersionResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * Settings class to configure an instance of {@link DocumentProcessorServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (documentai.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of processDocument to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DocumentProcessorServiceStubSettings.Builder documentProcessorServiceSettingsBuilder =
 *     DocumentProcessorServiceStubSettings.newBuilder();
 * documentProcessorServiceSettingsBuilder
 *     .processDocumentSettings()
 *     .setRetrySettings(
 *         documentProcessorServiceSettingsBuilder
 *             .processDocumentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DocumentProcessorServiceStubSettings documentProcessorServiceSettings =
 *     documentProcessorServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DocumentProcessorServiceStubSettings
    extends StubSettings<DocumentProcessorServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<ProcessRequest, ProcessResponse> processDocumentSettings;
  private final UnaryCallSettings<BatchProcessRequest, Operation> batchProcessDocumentsSettings;
  private final OperationCallSettings<
          BatchProcessRequest, BatchProcessResponse, BatchProcessMetadata>
      batchProcessDocumentsOperationSettings;
  private final UnaryCallSettings<FetchProcessorTypesRequest, FetchProcessorTypesResponse>
      fetchProcessorTypesSettings;
  private final PagedCallSettings<
          ListProcessorTypesRequest, ListProcessorTypesResponse, ListProcessorTypesPagedResponse>
      listProcessorTypesSettings;
  private final PagedCallSettings<
          ListProcessorsRequest, ListProcessorsResponse, ListProcessorsPagedResponse>
      listProcessorsSettings;
  private final UnaryCallSettings<GetProcessorRequest, Processor> getProcessorSettings;
  private final UnaryCallSettings<GetProcessorVersionRequest, ProcessorVersion>
      getProcessorVersionSettings;
  private final PagedCallSettings<
          ListProcessorVersionsRequest,
          ListProcessorVersionsResponse,
          ListProcessorVersionsPagedResponse>
      listProcessorVersionsSettings;
  private final UnaryCallSettings<DeleteProcessorVersionRequest, Operation>
      deleteProcessorVersionSettings;
  private final OperationCallSettings<
          DeleteProcessorVersionRequest, Empty, DeleteProcessorVersionMetadata>
      deleteProcessorVersionOperationSettings;
  private final UnaryCallSettings<DeployProcessorVersionRequest, Operation>
      deployProcessorVersionSettings;
  private final OperationCallSettings<
          DeployProcessorVersionRequest,
          DeployProcessorVersionResponse,
          DeployProcessorVersionMetadata>
      deployProcessorVersionOperationSettings;
  private final UnaryCallSettings<UndeployProcessorVersionRequest, Operation>
      undeployProcessorVersionSettings;
  private final OperationCallSettings<
          UndeployProcessorVersionRequest,
          UndeployProcessorVersionResponse,
          UndeployProcessorVersionMetadata>
      undeployProcessorVersionOperationSettings;
  private final UnaryCallSettings<CreateProcessorRequest, Processor> createProcessorSettings;
  private final UnaryCallSettings<DeleteProcessorRequest, Operation> deleteProcessorSettings;
  private final OperationCallSettings<DeleteProcessorRequest, Empty, DeleteProcessorMetadata>
      deleteProcessorOperationSettings;
  private final UnaryCallSettings<EnableProcessorRequest, Operation> enableProcessorSettings;
  private final OperationCallSettings<
          EnableProcessorRequest, EnableProcessorResponse, EnableProcessorMetadata>
      enableProcessorOperationSettings;
  private final UnaryCallSettings<DisableProcessorRequest, Operation> disableProcessorSettings;
  private final OperationCallSettings<
          DisableProcessorRequest, DisableProcessorResponse, DisableProcessorMetadata>
      disableProcessorOperationSettings;
  private final UnaryCallSettings<SetDefaultProcessorVersionRequest, Operation>
      setDefaultProcessorVersionSettings;
  private final OperationCallSettings<
          SetDefaultProcessorVersionRequest,
          SetDefaultProcessorVersionResponse,
          SetDefaultProcessorVersionMetadata>
      setDefaultProcessorVersionOperationSettings;
  private final UnaryCallSettings<ReviewDocumentRequest, Operation> reviewDocumentSettings;
  private final OperationCallSettings<
          ReviewDocumentRequest, ReviewDocumentResponse, ReviewDocumentOperationMetadata>
      reviewDocumentOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListProcessorTypesRequest, ListProcessorTypesResponse, ProcessorType>
      LIST_PROCESSOR_TYPES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListProcessorTypesRequest, ListProcessorTypesResponse, ProcessorType>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListProcessorTypesRequest injectToken(
                ListProcessorTypesRequest payload, String token) {
              return ListProcessorTypesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListProcessorTypesRequest injectPageSize(
                ListProcessorTypesRequest payload, int pageSize) {
              return ListProcessorTypesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListProcessorTypesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListProcessorTypesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ProcessorType> extractResources(ListProcessorTypesResponse payload) {
              return payload.getProcessorTypesList() == null
                  ? ImmutableList.<ProcessorType>of()
                  : payload.getProcessorTypesList();
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

  private static final PagedListDescriptor<
          ListProcessorVersionsRequest, ListProcessorVersionsResponse, ProcessorVersion>
      LIST_PROCESSOR_VERSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListProcessorVersionsRequest, ListProcessorVersionsResponse, ProcessorVersion>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListProcessorVersionsRequest injectToken(
                ListProcessorVersionsRequest payload, String token) {
              return ListProcessorVersionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListProcessorVersionsRequest injectPageSize(
                ListProcessorVersionsRequest payload, int pageSize) {
              return ListProcessorVersionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListProcessorVersionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListProcessorVersionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ProcessorVersion> extractResources(
                ListProcessorVersionsResponse payload) {
              return payload.getProcessorVersionsList() == null
                  ? ImmutableList.<ProcessorVersion>of()
                  : payload.getProcessorVersionsList();
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
          ListProcessorTypesRequest, ListProcessorTypesResponse, ListProcessorTypesPagedResponse>
      LIST_PROCESSOR_TYPES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListProcessorTypesRequest,
              ListProcessorTypesResponse,
              ListProcessorTypesPagedResponse>() {
            @Override
            public ApiFuture<ListProcessorTypesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListProcessorTypesRequest, ListProcessorTypesResponse> callable,
                ListProcessorTypesRequest request,
                ApiCallContext context,
                ApiFuture<ListProcessorTypesResponse> futureResponse) {
              PageContext<ListProcessorTypesRequest, ListProcessorTypesResponse, ProcessorType>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PROCESSOR_TYPES_PAGE_STR_DESC, request, context);
              return ListProcessorTypesPagedResponse.createAsync(pageContext, futureResponse);
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

  private static final PagedListResponseFactory<
          ListProcessorVersionsRequest,
          ListProcessorVersionsResponse,
          ListProcessorVersionsPagedResponse>
      LIST_PROCESSOR_VERSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListProcessorVersionsRequest,
              ListProcessorVersionsResponse,
              ListProcessorVersionsPagedResponse>() {
            @Override
            public ApiFuture<ListProcessorVersionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListProcessorVersionsRequest, ListProcessorVersionsResponse> callable,
                ListProcessorVersionsRequest request,
                ApiCallContext context,
                ApiFuture<ListProcessorVersionsResponse> futureResponse) {
              PageContext<
                      ListProcessorVersionsRequest, ListProcessorVersionsResponse, ProcessorVersion>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PROCESSOR_VERSIONS_PAGE_STR_DESC, request, context);
              return ListProcessorVersionsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to processDocument. */
  public UnaryCallSettings<ProcessRequest, ProcessResponse> processDocumentSettings() {
    return processDocumentSettings;
  }

  /** Returns the object with the settings used for calls to batchProcessDocuments. */
  public UnaryCallSettings<BatchProcessRequest, Operation> batchProcessDocumentsSettings() {
    return batchProcessDocumentsSettings;
  }

  /** Returns the object with the settings used for calls to batchProcessDocuments. */
  public OperationCallSettings<BatchProcessRequest, BatchProcessResponse, BatchProcessMetadata>
      batchProcessDocumentsOperationSettings() {
    return batchProcessDocumentsOperationSettings;
  }

  /** Returns the object with the settings used for calls to fetchProcessorTypes. */
  public UnaryCallSettings<FetchProcessorTypesRequest, FetchProcessorTypesResponse>
      fetchProcessorTypesSettings() {
    return fetchProcessorTypesSettings;
  }

  /** Returns the object with the settings used for calls to listProcessorTypes. */
  public PagedCallSettings<
          ListProcessorTypesRequest, ListProcessorTypesResponse, ListProcessorTypesPagedResponse>
      listProcessorTypesSettings() {
    return listProcessorTypesSettings;
  }

  /** Returns the object with the settings used for calls to listProcessors. */
  public PagedCallSettings<
          ListProcessorsRequest, ListProcessorsResponse, ListProcessorsPagedResponse>
      listProcessorsSettings() {
    return listProcessorsSettings;
  }

  /** Returns the object with the settings used for calls to getProcessor. */
  public UnaryCallSettings<GetProcessorRequest, Processor> getProcessorSettings() {
    return getProcessorSettings;
  }

  /** Returns the object with the settings used for calls to getProcessorVersion. */
  public UnaryCallSettings<GetProcessorVersionRequest, ProcessorVersion>
      getProcessorVersionSettings() {
    return getProcessorVersionSettings;
  }

  /** Returns the object with the settings used for calls to listProcessorVersions. */
  public PagedCallSettings<
          ListProcessorVersionsRequest,
          ListProcessorVersionsResponse,
          ListProcessorVersionsPagedResponse>
      listProcessorVersionsSettings() {
    return listProcessorVersionsSettings;
  }

  /** Returns the object with the settings used for calls to deleteProcessorVersion. */
  public UnaryCallSettings<DeleteProcessorVersionRequest, Operation>
      deleteProcessorVersionSettings() {
    return deleteProcessorVersionSettings;
  }

  /** Returns the object with the settings used for calls to deleteProcessorVersion. */
  public OperationCallSettings<DeleteProcessorVersionRequest, Empty, DeleteProcessorVersionMetadata>
      deleteProcessorVersionOperationSettings() {
    return deleteProcessorVersionOperationSettings;
  }

  /** Returns the object with the settings used for calls to deployProcessorVersion. */
  public UnaryCallSettings<DeployProcessorVersionRequest, Operation>
      deployProcessorVersionSettings() {
    return deployProcessorVersionSettings;
  }

  /** Returns the object with the settings used for calls to deployProcessorVersion. */
  public OperationCallSettings<
          DeployProcessorVersionRequest,
          DeployProcessorVersionResponse,
          DeployProcessorVersionMetadata>
      deployProcessorVersionOperationSettings() {
    return deployProcessorVersionOperationSettings;
  }

  /** Returns the object with the settings used for calls to undeployProcessorVersion. */
  public UnaryCallSettings<UndeployProcessorVersionRequest, Operation>
      undeployProcessorVersionSettings() {
    return undeployProcessorVersionSettings;
  }

  /** Returns the object with the settings used for calls to undeployProcessorVersion. */
  public OperationCallSettings<
          UndeployProcessorVersionRequest,
          UndeployProcessorVersionResponse,
          UndeployProcessorVersionMetadata>
      undeployProcessorVersionOperationSettings() {
    return undeployProcessorVersionOperationSettings;
  }

  /** Returns the object with the settings used for calls to createProcessor. */
  public UnaryCallSettings<CreateProcessorRequest, Processor> createProcessorSettings() {
    return createProcessorSettings;
  }

  /** Returns the object with the settings used for calls to deleteProcessor. */
  public UnaryCallSettings<DeleteProcessorRequest, Operation> deleteProcessorSettings() {
    return deleteProcessorSettings;
  }

  /** Returns the object with the settings used for calls to deleteProcessor. */
  public OperationCallSettings<DeleteProcessorRequest, Empty, DeleteProcessorMetadata>
      deleteProcessorOperationSettings() {
    return deleteProcessorOperationSettings;
  }

  /** Returns the object with the settings used for calls to enableProcessor. */
  public UnaryCallSettings<EnableProcessorRequest, Operation> enableProcessorSettings() {
    return enableProcessorSettings;
  }

  /** Returns the object with the settings used for calls to enableProcessor. */
  public OperationCallSettings<
          EnableProcessorRequest, EnableProcessorResponse, EnableProcessorMetadata>
      enableProcessorOperationSettings() {
    return enableProcessorOperationSettings;
  }

  /** Returns the object with the settings used for calls to disableProcessor. */
  public UnaryCallSettings<DisableProcessorRequest, Operation> disableProcessorSettings() {
    return disableProcessorSettings;
  }

  /** Returns the object with the settings used for calls to disableProcessor. */
  public OperationCallSettings<
          DisableProcessorRequest, DisableProcessorResponse, DisableProcessorMetadata>
      disableProcessorOperationSettings() {
    return disableProcessorOperationSettings;
  }

  /** Returns the object with the settings used for calls to setDefaultProcessorVersion. */
  public UnaryCallSettings<SetDefaultProcessorVersionRequest, Operation>
      setDefaultProcessorVersionSettings() {
    return setDefaultProcessorVersionSettings;
  }

  /** Returns the object with the settings used for calls to setDefaultProcessorVersion. */
  public OperationCallSettings<
          SetDefaultProcessorVersionRequest,
          SetDefaultProcessorVersionResponse,
          SetDefaultProcessorVersionMetadata>
      setDefaultProcessorVersionOperationSettings() {
    return setDefaultProcessorVersionOperationSettings;
  }

  /** Returns the object with the settings used for calls to reviewDocument. */
  public UnaryCallSettings<ReviewDocumentRequest, Operation> reviewDocumentSettings() {
    return reviewDocumentSettings;
  }

  /** Returns the object with the settings used for calls to reviewDocument. */
  public OperationCallSettings<
          ReviewDocumentRequest, ReviewDocumentResponse, ReviewDocumentOperationMetadata>
      reviewDocumentOperationSettings() {
    return reviewDocumentOperationSettings;
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

  public DocumentProcessorServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDocumentProcessorServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDocumentProcessorServiceStub.create(this);
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
    return "documentai.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "documentai.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DocumentProcessorServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DocumentProcessorServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DocumentProcessorServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DocumentProcessorServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    processDocumentSettings = settingsBuilder.processDocumentSettings().build();
    batchProcessDocumentsSettings = settingsBuilder.batchProcessDocumentsSettings().build();
    batchProcessDocumentsOperationSettings =
        settingsBuilder.batchProcessDocumentsOperationSettings().build();
    fetchProcessorTypesSettings = settingsBuilder.fetchProcessorTypesSettings().build();
    listProcessorTypesSettings = settingsBuilder.listProcessorTypesSettings().build();
    listProcessorsSettings = settingsBuilder.listProcessorsSettings().build();
    getProcessorSettings = settingsBuilder.getProcessorSettings().build();
    getProcessorVersionSettings = settingsBuilder.getProcessorVersionSettings().build();
    listProcessorVersionsSettings = settingsBuilder.listProcessorVersionsSettings().build();
    deleteProcessorVersionSettings = settingsBuilder.deleteProcessorVersionSettings().build();
    deleteProcessorVersionOperationSettings =
        settingsBuilder.deleteProcessorVersionOperationSettings().build();
    deployProcessorVersionSettings = settingsBuilder.deployProcessorVersionSettings().build();
    deployProcessorVersionOperationSettings =
        settingsBuilder.deployProcessorVersionOperationSettings().build();
    undeployProcessorVersionSettings = settingsBuilder.undeployProcessorVersionSettings().build();
    undeployProcessorVersionOperationSettings =
        settingsBuilder.undeployProcessorVersionOperationSettings().build();
    createProcessorSettings = settingsBuilder.createProcessorSettings().build();
    deleteProcessorSettings = settingsBuilder.deleteProcessorSettings().build();
    deleteProcessorOperationSettings = settingsBuilder.deleteProcessorOperationSettings().build();
    enableProcessorSettings = settingsBuilder.enableProcessorSettings().build();
    enableProcessorOperationSettings = settingsBuilder.enableProcessorOperationSettings().build();
    disableProcessorSettings = settingsBuilder.disableProcessorSettings().build();
    disableProcessorOperationSettings = settingsBuilder.disableProcessorOperationSettings().build();
    setDefaultProcessorVersionSettings =
        settingsBuilder.setDefaultProcessorVersionSettings().build();
    setDefaultProcessorVersionOperationSettings =
        settingsBuilder.setDefaultProcessorVersionOperationSettings().build();
    reviewDocumentSettings = settingsBuilder.reviewDocumentSettings().build();
    reviewDocumentOperationSettings = settingsBuilder.reviewDocumentOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for DocumentProcessorServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<DocumentProcessorServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<ProcessRequest, ProcessResponse>
        processDocumentSettings;
    private final UnaryCallSettings.Builder<BatchProcessRequest, Operation>
        batchProcessDocumentsSettings;
    private final OperationCallSettings.Builder<
            BatchProcessRequest, BatchProcessResponse, BatchProcessMetadata>
        batchProcessDocumentsOperationSettings;
    private final UnaryCallSettings.Builder<FetchProcessorTypesRequest, FetchProcessorTypesResponse>
        fetchProcessorTypesSettings;
    private final PagedCallSettings.Builder<
            ListProcessorTypesRequest, ListProcessorTypesResponse, ListProcessorTypesPagedResponse>
        listProcessorTypesSettings;
    private final PagedCallSettings.Builder<
            ListProcessorsRequest, ListProcessorsResponse, ListProcessorsPagedResponse>
        listProcessorsSettings;
    private final UnaryCallSettings.Builder<GetProcessorRequest, Processor> getProcessorSettings;
    private final UnaryCallSettings.Builder<GetProcessorVersionRequest, ProcessorVersion>
        getProcessorVersionSettings;
    private final PagedCallSettings.Builder<
            ListProcessorVersionsRequest,
            ListProcessorVersionsResponse,
            ListProcessorVersionsPagedResponse>
        listProcessorVersionsSettings;
    private final UnaryCallSettings.Builder<DeleteProcessorVersionRequest, Operation>
        deleteProcessorVersionSettings;
    private final OperationCallSettings.Builder<
            DeleteProcessorVersionRequest, Empty, DeleteProcessorVersionMetadata>
        deleteProcessorVersionOperationSettings;
    private final UnaryCallSettings.Builder<DeployProcessorVersionRequest, Operation>
        deployProcessorVersionSettings;
    private final OperationCallSettings.Builder<
            DeployProcessorVersionRequest,
            DeployProcessorVersionResponse,
            DeployProcessorVersionMetadata>
        deployProcessorVersionOperationSettings;
    private final UnaryCallSettings.Builder<UndeployProcessorVersionRequest, Operation>
        undeployProcessorVersionSettings;
    private final OperationCallSettings.Builder<
            UndeployProcessorVersionRequest,
            UndeployProcessorVersionResponse,
            UndeployProcessorVersionMetadata>
        undeployProcessorVersionOperationSettings;
    private final UnaryCallSettings.Builder<CreateProcessorRequest, Processor>
        createProcessorSettings;
    private final UnaryCallSettings.Builder<DeleteProcessorRequest, Operation>
        deleteProcessorSettings;
    private final OperationCallSettings.Builder<
            DeleteProcessorRequest, Empty, DeleteProcessorMetadata>
        deleteProcessorOperationSettings;
    private final UnaryCallSettings.Builder<EnableProcessorRequest, Operation>
        enableProcessorSettings;
    private final OperationCallSettings.Builder<
            EnableProcessorRequest, EnableProcessorResponse, EnableProcessorMetadata>
        enableProcessorOperationSettings;
    private final UnaryCallSettings.Builder<DisableProcessorRequest, Operation>
        disableProcessorSettings;
    private final OperationCallSettings.Builder<
            DisableProcessorRequest, DisableProcessorResponse, DisableProcessorMetadata>
        disableProcessorOperationSettings;
    private final UnaryCallSettings.Builder<SetDefaultProcessorVersionRequest, Operation>
        setDefaultProcessorVersionSettings;
    private final OperationCallSettings.Builder<
            SetDefaultProcessorVersionRequest,
            SetDefaultProcessorVersionResponse,
            SetDefaultProcessorVersionMetadata>
        setDefaultProcessorVersionOperationSettings;
    private final UnaryCallSettings.Builder<ReviewDocumentRequest, Operation>
        reviewDocumentSettings;
    private final OperationCallSettings.Builder<
            ReviewDocumentRequest, ReviewDocumentResponse, ReviewDocumentOperationMetadata>
        reviewDocumentOperationSettings;
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
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
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
              .setInitialRpcTimeout(Duration.ofMillis(120000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(120000L))
              .setTotalTimeout(Duration.ofMillis(120000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      processDocumentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchProcessDocumentsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchProcessDocumentsOperationSettings = OperationCallSettings.newBuilder();
      fetchProcessorTypesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listProcessorTypesSettings = PagedCallSettings.newBuilder(LIST_PROCESSOR_TYPES_PAGE_STR_FACT);
      listProcessorsSettings = PagedCallSettings.newBuilder(LIST_PROCESSORS_PAGE_STR_FACT);
      getProcessorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getProcessorVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listProcessorVersionsSettings =
          PagedCallSettings.newBuilder(LIST_PROCESSOR_VERSIONS_PAGE_STR_FACT);
      deleteProcessorVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteProcessorVersionOperationSettings = OperationCallSettings.newBuilder();
      deployProcessorVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deployProcessorVersionOperationSettings = OperationCallSettings.newBuilder();
      undeployProcessorVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      undeployProcessorVersionOperationSettings = OperationCallSettings.newBuilder();
      createProcessorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteProcessorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteProcessorOperationSettings = OperationCallSettings.newBuilder();
      enableProcessorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      enableProcessorOperationSettings = OperationCallSettings.newBuilder();
      disableProcessorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      disableProcessorOperationSettings = OperationCallSettings.newBuilder();
      setDefaultProcessorVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setDefaultProcessorVersionOperationSettings = OperationCallSettings.newBuilder();
      reviewDocumentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      reviewDocumentOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              processDocumentSettings,
              batchProcessDocumentsSettings,
              fetchProcessorTypesSettings,
              listProcessorTypesSettings,
              listProcessorsSettings,
              getProcessorSettings,
              getProcessorVersionSettings,
              listProcessorVersionsSettings,
              deleteProcessorVersionSettings,
              deployProcessorVersionSettings,
              undeployProcessorVersionSettings,
              createProcessorSettings,
              deleteProcessorSettings,
              enableProcessorSettings,
              disableProcessorSettings,
              setDefaultProcessorVersionSettings,
              reviewDocumentSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(DocumentProcessorServiceStubSettings settings) {
      super(settings);

      processDocumentSettings = settings.processDocumentSettings.toBuilder();
      batchProcessDocumentsSettings = settings.batchProcessDocumentsSettings.toBuilder();
      batchProcessDocumentsOperationSettings =
          settings.batchProcessDocumentsOperationSettings.toBuilder();
      fetchProcessorTypesSettings = settings.fetchProcessorTypesSettings.toBuilder();
      listProcessorTypesSettings = settings.listProcessorTypesSettings.toBuilder();
      listProcessorsSettings = settings.listProcessorsSettings.toBuilder();
      getProcessorSettings = settings.getProcessorSettings.toBuilder();
      getProcessorVersionSettings = settings.getProcessorVersionSettings.toBuilder();
      listProcessorVersionsSettings = settings.listProcessorVersionsSettings.toBuilder();
      deleteProcessorVersionSettings = settings.deleteProcessorVersionSettings.toBuilder();
      deleteProcessorVersionOperationSettings =
          settings.deleteProcessorVersionOperationSettings.toBuilder();
      deployProcessorVersionSettings = settings.deployProcessorVersionSettings.toBuilder();
      deployProcessorVersionOperationSettings =
          settings.deployProcessorVersionOperationSettings.toBuilder();
      undeployProcessorVersionSettings = settings.undeployProcessorVersionSettings.toBuilder();
      undeployProcessorVersionOperationSettings =
          settings.undeployProcessorVersionOperationSettings.toBuilder();
      createProcessorSettings = settings.createProcessorSettings.toBuilder();
      deleteProcessorSettings = settings.deleteProcessorSettings.toBuilder();
      deleteProcessorOperationSettings = settings.deleteProcessorOperationSettings.toBuilder();
      enableProcessorSettings = settings.enableProcessorSettings.toBuilder();
      enableProcessorOperationSettings = settings.enableProcessorOperationSettings.toBuilder();
      disableProcessorSettings = settings.disableProcessorSettings.toBuilder();
      disableProcessorOperationSettings = settings.disableProcessorOperationSettings.toBuilder();
      setDefaultProcessorVersionSettings = settings.setDefaultProcessorVersionSettings.toBuilder();
      setDefaultProcessorVersionOperationSettings =
          settings.setDefaultProcessorVersionOperationSettings.toBuilder();
      reviewDocumentSettings = settings.reviewDocumentSettings.toBuilder();
      reviewDocumentOperationSettings = settings.reviewDocumentOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              processDocumentSettings,
              batchProcessDocumentsSettings,
              fetchProcessorTypesSettings,
              listProcessorTypesSettings,
              listProcessorsSettings,
              getProcessorSettings,
              getProcessorVersionSettings,
              listProcessorVersionsSettings,
              deleteProcessorVersionSettings,
              deployProcessorVersionSettings,
              undeployProcessorVersionSettings,
              createProcessorSettings,
              deleteProcessorSettings,
              enableProcessorSettings,
              disableProcessorSettings,
              setDefaultProcessorVersionSettings,
              reviewDocumentSettings,
              listLocationsSettings,
              getLocationSettings);
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
          .processDocumentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchProcessDocumentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .fetchProcessorTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listProcessorTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listProcessorsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getProcessorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getProcessorVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listProcessorVersionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteProcessorVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deployProcessorVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .undeployProcessorVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createProcessorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteProcessorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .enableProcessorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .disableProcessorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .setDefaultProcessorVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .reviewDocumentSettings()
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

      builder
          .batchProcessDocumentsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchProcessRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(BatchProcessResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(BatchProcessMetadata.class))
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
          .deleteProcessorVersionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteProcessorVersionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  DeleteProcessorVersionMetadata.class))
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
          .deployProcessorVersionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeployProcessorVersionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  DeployProcessorVersionResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  DeployProcessorVersionMetadata.class))
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
          .undeployProcessorVersionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UndeployProcessorVersionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  UndeployProcessorVersionResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UndeployProcessorVersionMetadata.class))
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
              ProtoOperationTransformers.MetadataTransformer.create(DeleteProcessorMetadata.class))
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
          .enableProcessorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<EnableProcessorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(EnableProcessorResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(EnableProcessorMetadata.class))
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
          .disableProcessorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DisableProcessorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DisableProcessorResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DisableProcessorMetadata.class))
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
          .setDefaultProcessorVersionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetDefaultProcessorVersionRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  SetDefaultProcessorVersionResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  SetDefaultProcessorVersionMetadata.class))
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
          .reviewDocumentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ReviewDocumentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ReviewDocumentResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ReviewDocumentOperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to processDocument. */
    public UnaryCallSettings.Builder<ProcessRequest, ProcessResponse> processDocumentSettings() {
      return processDocumentSettings;
    }

    /** Returns the builder for the settings used for calls to batchProcessDocuments. */
    public UnaryCallSettings.Builder<BatchProcessRequest, Operation>
        batchProcessDocumentsSettings() {
      return batchProcessDocumentsSettings;
    }

    /** Returns the builder for the settings used for calls to batchProcessDocuments. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            BatchProcessRequest, BatchProcessResponse, BatchProcessMetadata>
        batchProcessDocumentsOperationSettings() {
      return batchProcessDocumentsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to fetchProcessorTypes. */
    public UnaryCallSettings.Builder<FetchProcessorTypesRequest, FetchProcessorTypesResponse>
        fetchProcessorTypesSettings() {
      return fetchProcessorTypesSettings;
    }

    /** Returns the builder for the settings used for calls to listProcessorTypes. */
    public PagedCallSettings.Builder<
            ListProcessorTypesRequest, ListProcessorTypesResponse, ListProcessorTypesPagedResponse>
        listProcessorTypesSettings() {
      return listProcessorTypesSettings;
    }

    /** Returns the builder for the settings used for calls to listProcessors. */
    public PagedCallSettings.Builder<
            ListProcessorsRequest, ListProcessorsResponse, ListProcessorsPagedResponse>
        listProcessorsSettings() {
      return listProcessorsSettings;
    }

    /** Returns the builder for the settings used for calls to getProcessor. */
    public UnaryCallSettings.Builder<GetProcessorRequest, Processor> getProcessorSettings() {
      return getProcessorSettings;
    }

    /** Returns the builder for the settings used for calls to getProcessorVersion. */
    public UnaryCallSettings.Builder<GetProcessorVersionRequest, ProcessorVersion>
        getProcessorVersionSettings() {
      return getProcessorVersionSettings;
    }

    /** Returns the builder for the settings used for calls to listProcessorVersions. */
    public PagedCallSettings.Builder<
            ListProcessorVersionsRequest,
            ListProcessorVersionsResponse,
            ListProcessorVersionsPagedResponse>
        listProcessorVersionsSettings() {
      return listProcessorVersionsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteProcessorVersion. */
    public UnaryCallSettings.Builder<DeleteProcessorVersionRequest, Operation>
        deleteProcessorVersionSettings() {
      return deleteProcessorVersionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteProcessorVersion. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeleteProcessorVersionRequest, Empty, DeleteProcessorVersionMetadata>
        deleteProcessorVersionOperationSettings() {
      return deleteProcessorVersionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deployProcessorVersion. */
    public UnaryCallSettings.Builder<DeployProcessorVersionRequest, Operation>
        deployProcessorVersionSettings() {
      return deployProcessorVersionSettings;
    }

    /** Returns the builder for the settings used for calls to deployProcessorVersion. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeployProcessorVersionRequest,
            DeployProcessorVersionResponse,
            DeployProcessorVersionMetadata>
        deployProcessorVersionOperationSettings() {
      return deployProcessorVersionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to undeployProcessorVersion. */
    public UnaryCallSettings.Builder<UndeployProcessorVersionRequest, Operation>
        undeployProcessorVersionSettings() {
      return undeployProcessorVersionSettings;
    }

    /** Returns the builder for the settings used for calls to undeployProcessorVersion. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UndeployProcessorVersionRequest,
            UndeployProcessorVersionResponse,
            UndeployProcessorVersionMetadata>
        undeployProcessorVersionOperationSettings() {
      return undeployProcessorVersionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createProcessor. */
    public UnaryCallSettings.Builder<CreateProcessorRequest, Processor> createProcessorSettings() {
      return createProcessorSettings;
    }

    /** Returns the builder for the settings used for calls to deleteProcessor. */
    public UnaryCallSettings.Builder<DeleteProcessorRequest, Operation> deleteProcessorSettings() {
      return deleteProcessorSettings;
    }

    /** Returns the builder for the settings used for calls to deleteProcessor. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteProcessorRequest, Empty, DeleteProcessorMetadata>
        deleteProcessorOperationSettings() {
      return deleteProcessorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to enableProcessor. */
    public UnaryCallSettings.Builder<EnableProcessorRequest, Operation> enableProcessorSettings() {
      return enableProcessorSettings;
    }

    /** Returns the builder for the settings used for calls to enableProcessor. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            EnableProcessorRequest, EnableProcessorResponse, EnableProcessorMetadata>
        enableProcessorOperationSettings() {
      return enableProcessorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to disableProcessor. */
    public UnaryCallSettings.Builder<DisableProcessorRequest, Operation>
        disableProcessorSettings() {
      return disableProcessorSettings;
    }

    /** Returns the builder for the settings used for calls to disableProcessor. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DisableProcessorRequest, DisableProcessorResponse, DisableProcessorMetadata>
        disableProcessorOperationSettings() {
      return disableProcessorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setDefaultProcessorVersion. */
    public UnaryCallSettings.Builder<SetDefaultProcessorVersionRequest, Operation>
        setDefaultProcessorVersionSettings() {
      return setDefaultProcessorVersionSettings;
    }

    /** Returns the builder for the settings used for calls to setDefaultProcessorVersion. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            SetDefaultProcessorVersionRequest,
            SetDefaultProcessorVersionResponse,
            SetDefaultProcessorVersionMetadata>
        setDefaultProcessorVersionOperationSettings() {
      return setDefaultProcessorVersionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to reviewDocument. */
    public UnaryCallSettings.Builder<ReviewDocumentRequest, Operation> reviewDocumentSettings() {
      return reviewDocumentSettings;
    }

    /** Returns the builder for the settings used for calls to reviewDocument. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ReviewDocumentRequest, ReviewDocumentResponse, ReviewDocumentOperationMetadata>
        reviewDocumentOperationSettings() {
      return reviewDocumentOperationSettings;
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
    public DocumentProcessorServiceStubSettings build() throws IOException {
      return new DocumentProcessorServiceStubSettings(this);
    }
  }
}
