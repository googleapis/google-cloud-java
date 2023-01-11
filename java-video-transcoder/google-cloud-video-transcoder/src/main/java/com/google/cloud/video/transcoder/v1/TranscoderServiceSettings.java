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

package com.google.cloud.video.transcoder.v1;

import static com.google.cloud.video.transcoder.v1.TranscoderServiceClient.ListJobTemplatesPagedResponse;
import static com.google.cloud.video.transcoder.v1.TranscoderServiceClient.ListJobsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.video.transcoder.v1.stub.TranscoderServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TranscoderServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (transcoder.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createJob to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TranscoderServiceSettings.Builder transcoderServiceSettingsBuilder =
 *     TranscoderServiceSettings.newBuilder();
 * transcoderServiceSettingsBuilder
 *     .createJobSettings()
 *     .setRetrySettings(
 *         transcoderServiceSettingsBuilder
 *             .createJobSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TranscoderServiceSettings transcoderServiceSettings = transcoderServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TranscoderServiceSettings extends ClientSettings<TranscoderServiceSettings> {

  /** Returns the object with the settings used for calls to createJob. */
  public UnaryCallSettings<CreateJobRequest, Job> createJobSettings() {
    return ((TranscoderServiceStubSettings) getStubSettings()).createJobSettings();
  }

  /** Returns the object with the settings used for calls to listJobs. */
  public PagedCallSettings<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
      listJobsSettings() {
    return ((TranscoderServiceStubSettings) getStubSettings()).listJobsSettings();
  }

  /** Returns the object with the settings used for calls to getJob. */
  public UnaryCallSettings<GetJobRequest, Job> getJobSettings() {
    return ((TranscoderServiceStubSettings) getStubSettings()).getJobSettings();
  }

  /** Returns the object with the settings used for calls to deleteJob. */
  public UnaryCallSettings<DeleteJobRequest, Empty> deleteJobSettings() {
    return ((TranscoderServiceStubSettings) getStubSettings()).deleteJobSettings();
  }

  /** Returns the object with the settings used for calls to createJobTemplate. */
  public UnaryCallSettings<CreateJobTemplateRequest, JobTemplate> createJobTemplateSettings() {
    return ((TranscoderServiceStubSettings) getStubSettings()).createJobTemplateSettings();
  }

  /** Returns the object with the settings used for calls to listJobTemplates. */
  public PagedCallSettings<
          ListJobTemplatesRequest, ListJobTemplatesResponse, ListJobTemplatesPagedResponse>
      listJobTemplatesSettings() {
    return ((TranscoderServiceStubSettings) getStubSettings()).listJobTemplatesSettings();
  }

  /** Returns the object with the settings used for calls to getJobTemplate. */
  public UnaryCallSettings<GetJobTemplateRequest, JobTemplate> getJobTemplateSettings() {
    return ((TranscoderServiceStubSettings) getStubSettings()).getJobTemplateSettings();
  }

  /** Returns the object with the settings used for calls to deleteJobTemplate. */
  public UnaryCallSettings<DeleteJobTemplateRequest, Empty> deleteJobTemplateSettings() {
    return ((TranscoderServiceStubSettings) getStubSettings()).deleteJobTemplateSettings();
  }

  public static final TranscoderServiceSettings create(TranscoderServiceStubSettings stub)
      throws IOException {
    return new TranscoderServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return TranscoderServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return TranscoderServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return TranscoderServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return TranscoderServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return TranscoderServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return TranscoderServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return TranscoderServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TranscoderServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
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

  protected TranscoderServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for TranscoderServiceSettings. */
  public static class Builder extends ClientSettings.Builder<TranscoderServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(TranscoderServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(TranscoderServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(TranscoderServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(TranscoderServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(TranscoderServiceStubSettings.newHttpJsonBuilder());
    }

    public TranscoderServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((TranscoderServiceStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to createJob. */
    public UnaryCallSettings.Builder<CreateJobRequest, Job> createJobSettings() {
      return getStubSettingsBuilder().createJobSettings();
    }

    /** Returns the builder for the settings used for calls to listJobs. */
    public PagedCallSettings.Builder<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
        listJobsSettings() {
      return getStubSettingsBuilder().listJobsSettings();
    }

    /** Returns the builder for the settings used for calls to getJob. */
    public UnaryCallSettings.Builder<GetJobRequest, Job> getJobSettings() {
      return getStubSettingsBuilder().getJobSettings();
    }

    /** Returns the builder for the settings used for calls to deleteJob. */
    public UnaryCallSettings.Builder<DeleteJobRequest, Empty> deleteJobSettings() {
      return getStubSettingsBuilder().deleteJobSettings();
    }

    /** Returns the builder for the settings used for calls to createJobTemplate. */
    public UnaryCallSettings.Builder<CreateJobTemplateRequest, JobTemplate>
        createJobTemplateSettings() {
      return getStubSettingsBuilder().createJobTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to listJobTemplates. */
    public PagedCallSettings.Builder<
            ListJobTemplatesRequest, ListJobTemplatesResponse, ListJobTemplatesPagedResponse>
        listJobTemplatesSettings() {
      return getStubSettingsBuilder().listJobTemplatesSettings();
    }

    /** Returns the builder for the settings used for calls to getJobTemplate. */
    public UnaryCallSettings.Builder<GetJobTemplateRequest, JobTemplate> getJobTemplateSettings() {
      return getStubSettingsBuilder().getJobTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to deleteJobTemplate. */
    public UnaryCallSettings.Builder<DeleteJobTemplateRequest, Empty> deleteJobTemplateSettings() {
      return getStubSettingsBuilder().deleteJobTemplateSettings();
    }

    @Override
    public TranscoderServiceSettings build() throws IOException {
      return new TranscoderServiceSettings(this);
    }
  }
}
