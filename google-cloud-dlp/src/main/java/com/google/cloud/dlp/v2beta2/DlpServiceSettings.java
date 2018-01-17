/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.dlp.v2beta2;

import static com.google.cloud.dlp.v2beta2.PagedResponseWrappers.ListDeidentifyTemplatesPagedResponse;
import static com.google.cloud.dlp.v2beta2.PagedResponseWrappers.ListDlpJobsPagedResponse;
import static com.google.cloud.dlp.v2beta2.PagedResponseWrappers.ListInspectTemplatesPagedResponse;

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
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dlp.v2beta2.stub.DlpServiceStub;
import com.google.cloud.dlp.v2beta2.stub.GrpcDlpServiceStub;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.privacy.dlp.v2beta2.AnalyzeDataSourceRiskRequest;
import com.google.privacy.dlp.v2beta2.CancelDlpJobRequest;
import com.google.privacy.dlp.v2beta2.CreateDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2beta2.CreateInspectTemplateRequest;
import com.google.privacy.dlp.v2beta2.DeidentifyContentRequest;
import com.google.privacy.dlp.v2beta2.DeidentifyContentResponse;
import com.google.privacy.dlp.v2beta2.DeidentifyTemplate;
import com.google.privacy.dlp.v2beta2.DeleteDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2beta2.DeleteDlpJobRequest;
import com.google.privacy.dlp.v2beta2.DeleteInspectTemplateRequest;
import com.google.privacy.dlp.v2beta2.DlpJob;
import com.google.privacy.dlp.v2beta2.GetDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2beta2.GetDlpJobRequest;
import com.google.privacy.dlp.v2beta2.GetInspectTemplateRequest;
import com.google.privacy.dlp.v2beta2.InspectContentRequest;
import com.google.privacy.dlp.v2beta2.InspectContentResponse;
import com.google.privacy.dlp.v2beta2.InspectDataSourceRequest;
import com.google.privacy.dlp.v2beta2.InspectTemplate;
import com.google.privacy.dlp.v2beta2.ListDeidentifyTemplatesRequest;
import com.google.privacy.dlp.v2beta2.ListDeidentifyTemplatesResponse;
import com.google.privacy.dlp.v2beta2.ListDlpJobsRequest;
import com.google.privacy.dlp.v2beta2.ListDlpJobsResponse;
import com.google.privacy.dlp.v2beta2.ListInfoTypesRequest;
import com.google.privacy.dlp.v2beta2.ListInfoTypesResponse;
import com.google.privacy.dlp.v2beta2.ListInspectTemplatesRequest;
import com.google.privacy.dlp.v2beta2.ListInspectTemplatesResponse;
import com.google.privacy.dlp.v2beta2.RedactImageRequest;
import com.google.privacy.dlp.v2beta2.RedactImageResponse;
import com.google.privacy.dlp.v2beta2.ReidentifyContentRequest;
import com.google.privacy.dlp.v2beta2.ReidentifyContentResponse;
import com.google.privacy.dlp.v2beta2.UpdateDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2beta2.UpdateInspectTemplateRequest;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link DlpServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dlp.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of inspectContent to 30 seconds:
 *
 * <pre>
 * <code>
 * DlpServiceSettings.Builder dlpServiceSettingsBuilder =
 *     DlpServiceSettings.newBuilder();
 * dlpServiceSettingsBuilder.inspectContentSettings().getRetrySettingsBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * DlpServiceSettings dlpServiceSettings = dlpServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class DlpServiceSettings extends ClientSettings<DlpServiceSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<InspectContentRequest, InspectContentResponse>
      inspectContentSettings;
  private final UnaryCallSettings<RedactImageRequest, RedactImageResponse> redactImageSettings;
  private final UnaryCallSettings<DeidentifyContentRequest, DeidentifyContentResponse>
      deidentifyContentSettings;
  private final UnaryCallSettings<ReidentifyContentRequest, ReidentifyContentResponse>
      reidentifyContentSettings;
  private final UnaryCallSettings<InspectDataSourceRequest, DlpJob> inspectDataSourceSettings;
  private final UnaryCallSettings<AnalyzeDataSourceRiskRequest, DlpJob>
      analyzeDataSourceRiskSettings;
  private final UnaryCallSettings<ListInfoTypesRequest, ListInfoTypesResponse>
      listInfoTypesSettings;
  private final UnaryCallSettings<CreateInspectTemplateRequest, InspectTemplate>
      createInspectTemplateSettings;
  private final UnaryCallSettings<UpdateInspectTemplateRequest, InspectTemplate>
      updateInspectTemplateSettings;
  private final UnaryCallSettings<GetInspectTemplateRequest, InspectTemplate>
      getInspectTemplateSettings;
  private final PagedCallSettings<
          ListInspectTemplatesRequest, ListInspectTemplatesResponse,
          ListInspectTemplatesPagedResponse>
      listInspectTemplatesSettings;
  private final UnaryCallSettings<DeleteInspectTemplateRequest, Empty>
      deleteInspectTemplateSettings;
  private final UnaryCallSettings<CreateDeidentifyTemplateRequest, DeidentifyTemplate>
      createDeidentifyTemplateSettings;
  private final UnaryCallSettings<UpdateDeidentifyTemplateRequest, DeidentifyTemplate>
      updateDeidentifyTemplateSettings;
  private final UnaryCallSettings<GetDeidentifyTemplateRequest, DeidentifyTemplate>
      getDeidentifyTemplateSettings;
  private final PagedCallSettings<
          ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse,
          ListDeidentifyTemplatesPagedResponse>
      listDeidentifyTemplatesSettings;
  private final UnaryCallSettings<DeleteDeidentifyTemplateRequest, Empty>
      deleteDeidentifyTemplateSettings;
  private final PagedCallSettings<ListDlpJobsRequest, ListDlpJobsResponse, ListDlpJobsPagedResponse>
      listDlpJobsSettings;
  private final UnaryCallSettings<GetDlpJobRequest, DlpJob> getDlpJobSettings;
  private final UnaryCallSettings<DeleteDlpJobRequest, Empty> deleteDlpJobSettings;
  private final UnaryCallSettings<CancelDlpJobRequest, Empty> cancelDlpJobSettings;

  /** Returns the object with the settings used for calls to inspectContent. */
  public UnaryCallSettings<InspectContentRequest, InspectContentResponse> inspectContentSettings() {
    return inspectContentSettings;
  }

  /** Returns the object with the settings used for calls to redactImage. */
  public UnaryCallSettings<RedactImageRequest, RedactImageResponse> redactImageSettings() {
    return redactImageSettings;
  }

  /** Returns the object with the settings used for calls to deidentifyContent. */
  public UnaryCallSettings<DeidentifyContentRequest, DeidentifyContentResponse>
      deidentifyContentSettings() {
    return deidentifyContentSettings;
  }

  /** Returns the object with the settings used for calls to reidentifyContent. */
  public UnaryCallSettings<ReidentifyContentRequest, ReidentifyContentResponse>
      reidentifyContentSettings() {
    return reidentifyContentSettings;
  }

  /** Returns the object with the settings used for calls to inspectDataSource. */
  public UnaryCallSettings<InspectDataSourceRequest, DlpJob> inspectDataSourceSettings() {
    return inspectDataSourceSettings;
  }

  /** Returns the object with the settings used for calls to analyzeDataSourceRisk. */
  public UnaryCallSettings<AnalyzeDataSourceRiskRequest, DlpJob> analyzeDataSourceRiskSettings() {
    return analyzeDataSourceRiskSettings;
  }

  /** Returns the object with the settings used for calls to listInfoTypes. */
  public UnaryCallSettings<ListInfoTypesRequest, ListInfoTypesResponse> listInfoTypesSettings() {
    return listInfoTypesSettings;
  }

  /** Returns the object with the settings used for calls to createInspectTemplate. */
  public UnaryCallSettings<CreateInspectTemplateRequest, InspectTemplate>
      createInspectTemplateSettings() {
    return createInspectTemplateSettings;
  }

  /** Returns the object with the settings used for calls to updateInspectTemplate. */
  public UnaryCallSettings<UpdateInspectTemplateRequest, InspectTemplate>
      updateInspectTemplateSettings() {
    return updateInspectTemplateSettings;
  }

  /** Returns the object with the settings used for calls to getInspectTemplate. */
  public UnaryCallSettings<GetInspectTemplateRequest, InspectTemplate>
      getInspectTemplateSettings() {
    return getInspectTemplateSettings;
  }

  /** Returns the object with the settings used for calls to listInspectTemplates. */
  public PagedCallSettings<
          ListInspectTemplatesRequest, ListInspectTemplatesResponse,
          ListInspectTemplatesPagedResponse>
      listInspectTemplatesSettings() {
    return listInspectTemplatesSettings;
  }

  /** Returns the object with the settings used for calls to deleteInspectTemplate. */
  public UnaryCallSettings<DeleteInspectTemplateRequest, Empty> deleteInspectTemplateSettings() {
    return deleteInspectTemplateSettings;
  }

  /** Returns the object with the settings used for calls to createDeidentifyTemplate. */
  public UnaryCallSettings<CreateDeidentifyTemplateRequest, DeidentifyTemplate>
      createDeidentifyTemplateSettings() {
    return createDeidentifyTemplateSettings;
  }

  /** Returns the object with the settings used for calls to updateDeidentifyTemplate. */
  public UnaryCallSettings<UpdateDeidentifyTemplateRequest, DeidentifyTemplate>
      updateDeidentifyTemplateSettings() {
    return updateDeidentifyTemplateSettings;
  }

  /** Returns the object with the settings used for calls to getDeidentifyTemplate. */
  public UnaryCallSettings<GetDeidentifyTemplateRequest, DeidentifyTemplate>
      getDeidentifyTemplateSettings() {
    return getDeidentifyTemplateSettings;
  }

  /** Returns the object with the settings used for calls to listDeidentifyTemplates. */
  public PagedCallSettings<
          ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse,
          ListDeidentifyTemplatesPagedResponse>
      listDeidentifyTemplatesSettings() {
    return listDeidentifyTemplatesSettings;
  }

  /** Returns the object with the settings used for calls to deleteDeidentifyTemplate. */
  public UnaryCallSettings<DeleteDeidentifyTemplateRequest, Empty>
      deleteDeidentifyTemplateSettings() {
    return deleteDeidentifyTemplateSettings;
  }

  /** Returns the object with the settings used for calls to listDlpJobs. */
  public PagedCallSettings<ListDlpJobsRequest, ListDlpJobsResponse, ListDlpJobsPagedResponse>
      listDlpJobsSettings() {
    return listDlpJobsSettings;
  }

  /** Returns the object with the settings used for calls to getDlpJob. */
  public UnaryCallSettings<GetDlpJobRequest, DlpJob> getDlpJobSettings() {
    return getDlpJobSettings;
  }

  /** Returns the object with the settings used for calls to deleteDlpJob. */
  public UnaryCallSettings<DeleteDlpJobRequest, Empty> deleteDlpJobSettings() {
    return deleteDlpJobSettings;
  }

  /** Returns the object with the settings used for calls to cancelDlpJob. */
  public UnaryCallSettings<CancelDlpJobRequest, Empty> cancelDlpJobSettings() {
    return cancelDlpJobSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public DlpServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDlpServiceStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "dlp.googleapis.com:443";
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
    return InstantiatingGrpcChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(DlpServiceSettings.class))
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

  protected DlpServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    inspectContentSettings = settingsBuilder.inspectContentSettings().build();
    redactImageSettings = settingsBuilder.redactImageSettings().build();
    deidentifyContentSettings = settingsBuilder.deidentifyContentSettings().build();
    reidentifyContentSettings = settingsBuilder.reidentifyContentSettings().build();
    inspectDataSourceSettings = settingsBuilder.inspectDataSourceSettings().build();
    analyzeDataSourceRiskSettings = settingsBuilder.analyzeDataSourceRiskSettings().build();
    listInfoTypesSettings = settingsBuilder.listInfoTypesSettings().build();
    createInspectTemplateSettings = settingsBuilder.createInspectTemplateSettings().build();
    updateInspectTemplateSettings = settingsBuilder.updateInspectTemplateSettings().build();
    getInspectTemplateSettings = settingsBuilder.getInspectTemplateSettings().build();
    listInspectTemplatesSettings = settingsBuilder.listInspectTemplatesSettings().build();
    deleteInspectTemplateSettings = settingsBuilder.deleteInspectTemplateSettings().build();
    createDeidentifyTemplateSettings = settingsBuilder.createDeidentifyTemplateSettings().build();
    updateDeidentifyTemplateSettings = settingsBuilder.updateDeidentifyTemplateSettings().build();
    getDeidentifyTemplateSettings = settingsBuilder.getDeidentifyTemplateSettings().build();
    listDeidentifyTemplatesSettings = settingsBuilder.listDeidentifyTemplatesSettings().build();
    deleteDeidentifyTemplateSettings = settingsBuilder.deleteDeidentifyTemplateSettings().build();
    listDlpJobsSettings = settingsBuilder.listDlpJobsSettings().build();
    getDlpJobSettings = settingsBuilder.getDlpJobSettings().build();
    deleteDlpJobSettings = settingsBuilder.deleteDlpJobSettings().build();
    cancelDlpJobSettings = settingsBuilder.cancelDlpJobSettings().build();
  }

  private static final PagedListDescriptor<
          ListInspectTemplatesRequest, ListInspectTemplatesResponse, InspectTemplate>
      LIST_INSPECT_TEMPLATES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListInspectTemplatesRequest, ListInspectTemplatesResponse, InspectTemplate>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInspectTemplatesRequest injectToken(
                ListInspectTemplatesRequest payload, String token) {
              return ListInspectTemplatesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListInspectTemplatesRequest injectPageSize(
                ListInspectTemplatesRequest payload, int pageSize) {
              return ListInspectTemplatesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListInspectTemplatesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListInspectTemplatesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<InspectTemplate> extractResources(
                ListInspectTemplatesResponse payload) {
              return payload.getInspectTemplatesList();
            }
          };

  private static final PagedListDescriptor<
          ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse, DeidentifyTemplate>
      LIST_DEIDENTIFY_TEMPLATES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse,
              DeidentifyTemplate>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDeidentifyTemplatesRequest injectToken(
                ListDeidentifyTemplatesRequest payload, String token) {
              return ListDeidentifyTemplatesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDeidentifyTemplatesRequest injectPageSize(
                ListDeidentifyTemplatesRequest payload, int pageSize) {
              return ListDeidentifyTemplatesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListDeidentifyTemplatesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDeidentifyTemplatesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DeidentifyTemplate> extractResources(
                ListDeidentifyTemplatesResponse payload) {
              return payload.getDeidentifyTemplatesList();
            }
          };

  private static final PagedListDescriptor<ListDlpJobsRequest, ListDlpJobsResponse, DlpJob>
      LIST_DLP_JOBS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDlpJobsRequest, ListDlpJobsResponse, DlpJob>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDlpJobsRequest injectToken(ListDlpJobsRequest payload, String token) {
              return ListDlpJobsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDlpJobsRequest injectPageSize(ListDlpJobsRequest payload, int pageSize) {
              return ListDlpJobsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDlpJobsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDlpJobsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DlpJob> extractResources(ListDlpJobsResponse payload) {
              return payload.getJobsList();
            }
          };

  private static final PagedListResponseFactory<
          ListInspectTemplatesRequest, ListInspectTemplatesResponse,
          ListInspectTemplatesPagedResponse>
      LIST_INSPECT_TEMPLATES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInspectTemplatesRequest, ListInspectTemplatesResponse,
              ListInspectTemplatesPagedResponse>() {
            @Override
            public ApiFuture<ListInspectTemplatesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListInspectTemplatesRequest, ListInspectTemplatesResponse> callable,
                ListInspectTemplatesRequest request,
                ApiCallContext context,
                ApiFuture<ListInspectTemplatesResponse> futureResponse) {
              PageContext<
                      ListInspectTemplatesRequest, ListInspectTemplatesResponse, InspectTemplate>
                  pageContext =
                      PageContext.create(
                          callable, LIST_INSPECT_TEMPLATES_PAGE_STR_DESC, request, context);
              return ListInspectTemplatesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse,
          ListDeidentifyTemplatesPagedResponse>
      LIST_DEIDENTIFY_TEMPLATES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse,
              ListDeidentifyTemplatesPagedResponse>() {
            @Override
            public ApiFuture<ListDeidentifyTemplatesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse>
                    callable,
                ListDeidentifyTemplatesRequest request,
                ApiCallContext context,
                ApiFuture<ListDeidentifyTemplatesResponse> futureResponse) {
              PageContext<
                      ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse,
                      DeidentifyTemplate>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DEIDENTIFY_TEMPLATES_PAGE_STR_DESC, request, context);
              return ListDeidentifyTemplatesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDlpJobsRequest, ListDlpJobsResponse, ListDlpJobsPagedResponse>
      LIST_DLP_JOBS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDlpJobsRequest, ListDlpJobsResponse, ListDlpJobsPagedResponse>() {
            @Override
            public ApiFuture<ListDlpJobsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDlpJobsRequest, ListDlpJobsResponse> callable,
                ListDlpJobsRequest request,
                ApiCallContext context,
                ApiFuture<ListDlpJobsResponse> futureResponse) {
              PageContext<ListDlpJobsRequest, ListDlpJobsResponse, DlpJob> pageContext =
                  PageContext.create(callable, LIST_DLP_JOBS_PAGE_STR_DESC, request, context);
              return ListDlpJobsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for DlpServiceSettings. */
  public static class Builder extends ClientSettings.Builder<DlpServiceSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<InspectContentRequest, InspectContentResponse>
        inspectContentSettings;
    private final UnaryCallSettings.Builder<RedactImageRequest, RedactImageResponse>
        redactImageSettings;
    private final UnaryCallSettings.Builder<DeidentifyContentRequest, DeidentifyContentResponse>
        deidentifyContentSettings;
    private final UnaryCallSettings.Builder<ReidentifyContentRequest, ReidentifyContentResponse>
        reidentifyContentSettings;
    private final UnaryCallSettings.Builder<InspectDataSourceRequest, DlpJob>
        inspectDataSourceSettings;
    private final UnaryCallSettings.Builder<AnalyzeDataSourceRiskRequest, DlpJob>
        analyzeDataSourceRiskSettings;
    private final UnaryCallSettings.Builder<ListInfoTypesRequest, ListInfoTypesResponse>
        listInfoTypesSettings;
    private final UnaryCallSettings.Builder<CreateInspectTemplateRequest, InspectTemplate>
        createInspectTemplateSettings;
    private final UnaryCallSettings.Builder<UpdateInspectTemplateRequest, InspectTemplate>
        updateInspectTemplateSettings;
    private final UnaryCallSettings.Builder<GetInspectTemplateRequest, InspectTemplate>
        getInspectTemplateSettings;
    private final PagedCallSettings.Builder<
            ListInspectTemplatesRequest, ListInspectTemplatesResponse,
            ListInspectTemplatesPagedResponse>
        listInspectTemplatesSettings;
    private final UnaryCallSettings.Builder<DeleteInspectTemplateRequest, Empty>
        deleteInspectTemplateSettings;
    private final UnaryCallSettings.Builder<CreateDeidentifyTemplateRequest, DeidentifyTemplate>
        createDeidentifyTemplateSettings;
    private final UnaryCallSettings.Builder<UpdateDeidentifyTemplateRequest, DeidentifyTemplate>
        updateDeidentifyTemplateSettings;
    private final UnaryCallSettings.Builder<GetDeidentifyTemplateRequest, DeidentifyTemplate>
        getDeidentifyTemplateSettings;
    private final PagedCallSettings.Builder<
            ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse,
            ListDeidentifyTemplatesPagedResponse>
        listDeidentifyTemplatesSettings;
    private final UnaryCallSettings.Builder<DeleteDeidentifyTemplateRequest, Empty>
        deleteDeidentifyTemplateSettings;
    private final PagedCallSettings.Builder<
            ListDlpJobsRequest, ListDlpJobsResponse, ListDlpJobsPagedResponse>
        listDlpJobsSettings;
    private final UnaryCallSettings.Builder<GetDlpJobRequest, DlpJob> getDlpJobSettings;
    private final UnaryCallSettings.Builder<DeleteDlpJobRequest, Empty> deleteDlpJobSettings;
    private final UnaryCallSettings.Builder<CancelDlpJobRequest, Empty> cancelDlpJobSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      inspectContentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      redactImageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deidentifyContentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      reidentifyContentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      inspectDataSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      analyzeDataSourceRiskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listInfoTypesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createInspectTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateInspectTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getInspectTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listInspectTemplatesSettings =
          PagedCallSettings.newBuilder(LIST_INSPECT_TEMPLATES_PAGE_STR_FACT);

      deleteInspectTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createDeidentifyTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateDeidentifyTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getDeidentifyTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listDeidentifyTemplatesSettings =
          PagedCallSettings.newBuilder(LIST_DEIDENTIFY_TEMPLATES_PAGE_STR_FACT);

      deleteDeidentifyTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listDlpJobsSettings = PagedCallSettings.newBuilder(LIST_DLP_JOBS_PAGE_STR_FACT);

      getDlpJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteDlpJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      cancelDlpJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              inspectContentSettings,
              redactImageSettings,
              deidentifyContentSettings,
              reidentifyContentSettings,
              inspectDataSourceSettings,
              analyzeDataSourceRiskSettings,
              listInfoTypesSettings,
              createInspectTemplateSettings,
              updateInspectTemplateSettings,
              getInspectTemplateSettings,
              listInspectTemplatesSettings,
              deleteInspectTemplateSettings,
              createDeidentifyTemplateSettings,
              updateDeidentifyTemplateSettings,
              getDeidentifyTemplateSettings,
              listDeidentifyTemplatesSettings,
              deleteDeidentifyTemplateSettings,
              listDlpJobsSettings,
              getDlpJobSettings,
              deleteDlpJobSettings,
              cancelDlpJobSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .inspectContentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .redactImageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deidentifyContentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .reidentifyContentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .inspectDataSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .analyzeDataSourceRiskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listInfoTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createInspectTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateInspectTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getInspectTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listInspectTemplatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteInspectTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createDeidentifyTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateDeidentifyTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getDeidentifyTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listDeidentifyTemplatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteDeidentifyTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listDlpJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getDlpJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteDlpJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .cancelDlpJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(DlpServiceSettings settings) {
      super(settings);

      inspectContentSettings = settings.inspectContentSettings.toBuilder();
      redactImageSettings = settings.redactImageSettings.toBuilder();
      deidentifyContentSettings = settings.deidentifyContentSettings.toBuilder();
      reidentifyContentSettings = settings.reidentifyContentSettings.toBuilder();
      inspectDataSourceSettings = settings.inspectDataSourceSettings.toBuilder();
      analyzeDataSourceRiskSettings = settings.analyzeDataSourceRiskSettings.toBuilder();
      listInfoTypesSettings = settings.listInfoTypesSettings.toBuilder();
      createInspectTemplateSettings = settings.createInspectTemplateSettings.toBuilder();
      updateInspectTemplateSettings = settings.updateInspectTemplateSettings.toBuilder();
      getInspectTemplateSettings = settings.getInspectTemplateSettings.toBuilder();
      listInspectTemplatesSettings = settings.listInspectTemplatesSettings.toBuilder();
      deleteInspectTemplateSettings = settings.deleteInspectTemplateSettings.toBuilder();
      createDeidentifyTemplateSettings = settings.createDeidentifyTemplateSettings.toBuilder();
      updateDeidentifyTemplateSettings = settings.updateDeidentifyTemplateSettings.toBuilder();
      getDeidentifyTemplateSettings = settings.getDeidentifyTemplateSettings.toBuilder();
      listDeidentifyTemplatesSettings = settings.listDeidentifyTemplatesSettings.toBuilder();
      deleteDeidentifyTemplateSettings = settings.deleteDeidentifyTemplateSettings.toBuilder();
      listDlpJobsSettings = settings.listDlpJobsSettings.toBuilder();
      getDlpJobSettings = settings.getDlpJobSettings.toBuilder();
      deleteDlpJobSettings = settings.deleteDlpJobSettings.toBuilder();
      cancelDlpJobSettings = settings.cancelDlpJobSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              inspectContentSettings,
              redactImageSettings,
              deidentifyContentSettings,
              reidentifyContentSettings,
              inspectDataSourceSettings,
              analyzeDataSourceRiskSettings,
              listInfoTypesSettings,
              createInspectTemplateSettings,
              updateInspectTemplateSettings,
              getInspectTemplateSettings,
              listInspectTemplatesSettings,
              deleteInspectTemplateSettings,
              createDeidentifyTemplateSettings,
              updateDeidentifyTemplateSettings,
              getDeidentifyTemplateSettings,
              listDeidentifyTemplatesSettings,
              deleteDeidentifyTemplateSettings,
              listDlpJobsSettings,
              getDlpJobSettings,
              deleteDlpJobSettings,
              cancelDlpJobSettings);
    }

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

    /** Returns the builder for the settings used for calls to inspectContent. */
    public UnaryCallSettings.Builder<InspectContentRequest, InspectContentResponse>
        inspectContentSettings() {
      return inspectContentSettings;
    }

    /** Returns the builder for the settings used for calls to redactImage. */
    public UnaryCallSettings.Builder<RedactImageRequest, RedactImageResponse>
        redactImageSettings() {
      return redactImageSettings;
    }

    /** Returns the builder for the settings used for calls to deidentifyContent. */
    public UnaryCallSettings.Builder<DeidentifyContentRequest, DeidentifyContentResponse>
        deidentifyContentSettings() {
      return deidentifyContentSettings;
    }

    /** Returns the builder for the settings used for calls to reidentifyContent. */
    public UnaryCallSettings.Builder<ReidentifyContentRequest, ReidentifyContentResponse>
        reidentifyContentSettings() {
      return reidentifyContentSettings;
    }

    /** Returns the builder for the settings used for calls to inspectDataSource. */
    public UnaryCallSettings.Builder<InspectDataSourceRequest, DlpJob> inspectDataSourceSettings() {
      return inspectDataSourceSettings;
    }

    /** Returns the builder for the settings used for calls to analyzeDataSourceRisk. */
    public UnaryCallSettings.Builder<AnalyzeDataSourceRiskRequest, DlpJob>
        analyzeDataSourceRiskSettings() {
      return analyzeDataSourceRiskSettings;
    }

    /** Returns the builder for the settings used for calls to listInfoTypes. */
    public UnaryCallSettings.Builder<ListInfoTypesRequest, ListInfoTypesResponse>
        listInfoTypesSettings() {
      return listInfoTypesSettings;
    }

    /** Returns the builder for the settings used for calls to createInspectTemplate. */
    public UnaryCallSettings.Builder<CreateInspectTemplateRequest, InspectTemplate>
        createInspectTemplateSettings() {
      return createInspectTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to updateInspectTemplate. */
    public UnaryCallSettings.Builder<UpdateInspectTemplateRequest, InspectTemplate>
        updateInspectTemplateSettings() {
      return updateInspectTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to getInspectTemplate. */
    public UnaryCallSettings.Builder<GetInspectTemplateRequest, InspectTemplate>
        getInspectTemplateSettings() {
      return getInspectTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to listInspectTemplates. */
    public PagedCallSettings.Builder<
            ListInspectTemplatesRequest, ListInspectTemplatesResponse,
            ListInspectTemplatesPagedResponse>
        listInspectTemplatesSettings() {
      return listInspectTemplatesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInspectTemplate. */
    public UnaryCallSettings.Builder<DeleteInspectTemplateRequest, Empty>
        deleteInspectTemplateSettings() {
      return deleteInspectTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to createDeidentifyTemplate. */
    public UnaryCallSettings.Builder<CreateDeidentifyTemplateRequest, DeidentifyTemplate>
        createDeidentifyTemplateSettings() {
      return createDeidentifyTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to updateDeidentifyTemplate. */
    public UnaryCallSettings.Builder<UpdateDeidentifyTemplateRequest, DeidentifyTemplate>
        updateDeidentifyTemplateSettings() {
      return updateDeidentifyTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to getDeidentifyTemplate. */
    public UnaryCallSettings.Builder<GetDeidentifyTemplateRequest, DeidentifyTemplate>
        getDeidentifyTemplateSettings() {
      return getDeidentifyTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to listDeidentifyTemplates. */
    public PagedCallSettings.Builder<
            ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse,
            ListDeidentifyTemplatesPagedResponse>
        listDeidentifyTemplatesSettings() {
      return listDeidentifyTemplatesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDeidentifyTemplate. */
    public UnaryCallSettings.Builder<DeleteDeidentifyTemplateRequest, Empty>
        deleteDeidentifyTemplateSettings() {
      return deleteDeidentifyTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to listDlpJobs. */
    public PagedCallSettings.Builder<
            ListDlpJobsRequest, ListDlpJobsResponse, ListDlpJobsPagedResponse>
        listDlpJobsSettings() {
      return listDlpJobsSettings;
    }

    /** Returns the builder for the settings used for calls to getDlpJob. */
    public UnaryCallSettings.Builder<GetDlpJobRequest, DlpJob> getDlpJobSettings() {
      return getDlpJobSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDlpJob. */
    public UnaryCallSettings.Builder<DeleteDlpJobRequest, Empty> deleteDlpJobSettings() {
      return deleteDlpJobSettings;
    }

    /** Returns the builder for the settings used for calls to cancelDlpJob. */
    public UnaryCallSettings.Builder<CancelDlpJobRequest, Empty> cancelDlpJobSettings() {
      return cancelDlpJobSettings;
    }

    @Override
    public DlpServiceSettings build() throws IOException {
      return new DlpServiceSettings(this);
    }
  }
}
