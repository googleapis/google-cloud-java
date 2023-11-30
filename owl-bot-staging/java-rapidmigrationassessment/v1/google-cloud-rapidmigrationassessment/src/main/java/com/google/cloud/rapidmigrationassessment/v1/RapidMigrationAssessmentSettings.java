/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.rapidmigrationassessment.v1;

import static com.google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessmentClient.ListCollectorsPagedResponse;
import static com.google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessmentClient.ListLocationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.rapidmigrationassessment.v1.stub.RapidMigrationAssessmentStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RapidMigrationAssessmentClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (rapidmigrationassessment.googleapis.com) and default port
 *       (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getAnnotation to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RapidMigrationAssessmentSettings.Builder rapidMigrationAssessmentSettingsBuilder =
 *     RapidMigrationAssessmentSettings.newBuilder();
 * rapidMigrationAssessmentSettingsBuilder
 *     .getAnnotationSettings()
 *     .setRetrySettings(
 *         rapidMigrationAssessmentSettingsBuilder
 *             .getAnnotationSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RapidMigrationAssessmentSettings rapidMigrationAssessmentSettings =
 *     rapidMigrationAssessmentSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RapidMigrationAssessmentSettings
    extends ClientSettings<RapidMigrationAssessmentSettings> {

  /** Returns the object with the settings used for calls to createCollector. */
  public UnaryCallSettings<CreateCollectorRequest, Operation> createCollectorSettings() {
    return ((RapidMigrationAssessmentStubSettings) getStubSettings()).createCollectorSettings();
  }

  /** Returns the object with the settings used for calls to createCollector. */
  public OperationCallSettings<CreateCollectorRequest, Collector, OperationMetadata>
      createCollectorOperationSettings() {
    return ((RapidMigrationAssessmentStubSettings) getStubSettings())
        .createCollectorOperationSettings();
  }

  /** Returns the object with the settings used for calls to createAnnotation. */
  public UnaryCallSettings<CreateAnnotationRequest, Operation> createAnnotationSettings() {
    return ((RapidMigrationAssessmentStubSettings) getStubSettings()).createAnnotationSettings();
  }

  /** Returns the object with the settings used for calls to createAnnotation. */
  public OperationCallSettings<CreateAnnotationRequest, Annotation, OperationMetadata>
      createAnnotationOperationSettings() {
    return ((RapidMigrationAssessmentStubSettings) getStubSettings())
        .createAnnotationOperationSettings();
  }

  /** Returns the object with the settings used for calls to getAnnotation. */
  public UnaryCallSettings<GetAnnotationRequest, Annotation> getAnnotationSettings() {
    return ((RapidMigrationAssessmentStubSettings) getStubSettings()).getAnnotationSettings();
  }

  /** Returns the object with the settings used for calls to listCollectors. */
  public PagedCallSettings<
          ListCollectorsRequest, ListCollectorsResponse, ListCollectorsPagedResponse>
      listCollectorsSettings() {
    return ((RapidMigrationAssessmentStubSettings) getStubSettings()).listCollectorsSettings();
  }

  /** Returns the object with the settings used for calls to getCollector. */
  public UnaryCallSettings<GetCollectorRequest, Collector> getCollectorSettings() {
    return ((RapidMigrationAssessmentStubSettings) getStubSettings()).getCollectorSettings();
  }

  /** Returns the object with the settings used for calls to updateCollector. */
  public UnaryCallSettings<UpdateCollectorRequest, Operation> updateCollectorSettings() {
    return ((RapidMigrationAssessmentStubSettings) getStubSettings()).updateCollectorSettings();
  }

  /** Returns the object with the settings used for calls to updateCollector. */
  public OperationCallSettings<UpdateCollectorRequest, Collector, OperationMetadata>
      updateCollectorOperationSettings() {
    return ((RapidMigrationAssessmentStubSettings) getStubSettings())
        .updateCollectorOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteCollector. */
  public UnaryCallSettings<DeleteCollectorRequest, Operation> deleteCollectorSettings() {
    return ((RapidMigrationAssessmentStubSettings) getStubSettings()).deleteCollectorSettings();
  }

  /** Returns the object with the settings used for calls to deleteCollector. */
  public OperationCallSettings<DeleteCollectorRequest, Collector, OperationMetadata>
      deleteCollectorOperationSettings() {
    return ((RapidMigrationAssessmentStubSettings) getStubSettings())
        .deleteCollectorOperationSettings();
  }

  /** Returns the object with the settings used for calls to resumeCollector. */
  public UnaryCallSettings<ResumeCollectorRequest, Operation> resumeCollectorSettings() {
    return ((RapidMigrationAssessmentStubSettings) getStubSettings()).resumeCollectorSettings();
  }

  /** Returns the object with the settings used for calls to resumeCollector. */
  public OperationCallSettings<ResumeCollectorRequest, Collector, OperationMetadata>
      resumeCollectorOperationSettings() {
    return ((RapidMigrationAssessmentStubSettings) getStubSettings())
        .resumeCollectorOperationSettings();
  }

  /** Returns the object with the settings used for calls to registerCollector. */
  public UnaryCallSettings<RegisterCollectorRequest, Operation> registerCollectorSettings() {
    return ((RapidMigrationAssessmentStubSettings) getStubSettings()).registerCollectorSettings();
  }

  /** Returns the object with the settings used for calls to registerCollector. */
  public OperationCallSettings<RegisterCollectorRequest, Collector, OperationMetadata>
      registerCollectorOperationSettings() {
    return ((RapidMigrationAssessmentStubSettings) getStubSettings())
        .registerCollectorOperationSettings();
  }

  /** Returns the object with the settings used for calls to pauseCollector. */
  public UnaryCallSettings<PauseCollectorRequest, Operation> pauseCollectorSettings() {
    return ((RapidMigrationAssessmentStubSettings) getStubSettings()).pauseCollectorSettings();
  }

  /** Returns the object with the settings used for calls to pauseCollector. */
  public OperationCallSettings<PauseCollectorRequest, Collector, OperationMetadata>
      pauseCollectorOperationSettings() {
    return ((RapidMigrationAssessmentStubSettings) getStubSettings())
        .pauseCollectorOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((RapidMigrationAssessmentStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((RapidMigrationAssessmentStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final RapidMigrationAssessmentSettings create(
      RapidMigrationAssessmentStubSettings stub) throws IOException {
    return new RapidMigrationAssessmentSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RapidMigrationAssessmentStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RapidMigrationAssessmentStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RapidMigrationAssessmentStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RapidMigrationAssessmentStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return RapidMigrationAssessmentStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RapidMigrationAssessmentStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RapidMigrationAssessmentStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RapidMigrationAssessmentStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RapidMigrationAssessmentSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RapidMigrationAssessmentSettings. */
  public static class Builder
      extends ClientSettings.Builder<RapidMigrationAssessmentSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(RapidMigrationAssessmentStubSettings.newBuilder(clientContext));
    }

    protected Builder(RapidMigrationAssessmentSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RapidMigrationAssessmentStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(RapidMigrationAssessmentStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(RapidMigrationAssessmentStubSettings.newHttpJsonBuilder());
    }

    public RapidMigrationAssessmentStubSettings.Builder getStubSettingsBuilder() {
      return ((RapidMigrationAssessmentStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createCollector. */
    public UnaryCallSettings.Builder<CreateCollectorRequest, Operation> createCollectorSettings() {
      return getStubSettingsBuilder().createCollectorSettings();
    }

    /** Returns the builder for the settings used for calls to createCollector. */
    public OperationCallSettings.Builder<CreateCollectorRequest, Collector, OperationMetadata>
        createCollectorOperationSettings() {
      return getStubSettingsBuilder().createCollectorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createAnnotation. */
    public UnaryCallSettings.Builder<CreateAnnotationRequest, Operation>
        createAnnotationSettings() {
      return getStubSettingsBuilder().createAnnotationSettings();
    }

    /** Returns the builder for the settings used for calls to createAnnotation. */
    public OperationCallSettings.Builder<CreateAnnotationRequest, Annotation, OperationMetadata>
        createAnnotationOperationSettings() {
      return getStubSettingsBuilder().createAnnotationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getAnnotation. */
    public UnaryCallSettings.Builder<GetAnnotationRequest, Annotation> getAnnotationSettings() {
      return getStubSettingsBuilder().getAnnotationSettings();
    }

    /** Returns the builder for the settings used for calls to listCollectors. */
    public PagedCallSettings.Builder<
            ListCollectorsRequest, ListCollectorsResponse, ListCollectorsPagedResponse>
        listCollectorsSettings() {
      return getStubSettingsBuilder().listCollectorsSettings();
    }

    /** Returns the builder for the settings used for calls to getCollector. */
    public UnaryCallSettings.Builder<GetCollectorRequest, Collector> getCollectorSettings() {
      return getStubSettingsBuilder().getCollectorSettings();
    }

    /** Returns the builder for the settings used for calls to updateCollector. */
    public UnaryCallSettings.Builder<UpdateCollectorRequest, Operation> updateCollectorSettings() {
      return getStubSettingsBuilder().updateCollectorSettings();
    }

    /** Returns the builder for the settings used for calls to updateCollector. */
    public OperationCallSettings.Builder<UpdateCollectorRequest, Collector, OperationMetadata>
        updateCollectorOperationSettings() {
      return getStubSettingsBuilder().updateCollectorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCollector. */
    public UnaryCallSettings.Builder<DeleteCollectorRequest, Operation> deleteCollectorSettings() {
      return getStubSettingsBuilder().deleteCollectorSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCollector. */
    public OperationCallSettings.Builder<DeleteCollectorRequest, Collector, OperationMetadata>
        deleteCollectorOperationSettings() {
      return getStubSettingsBuilder().deleteCollectorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to resumeCollector. */
    public UnaryCallSettings.Builder<ResumeCollectorRequest, Operation> resumeCollectorSettings() {
      return getStubSettingsBuilder().resumeCollectorSettings();
    }

    /** Returns the builder for the settings used for calls to resumeCollector. */
    public OperationCallSettings.Builder<ResumeCollectorRequest, Collector, OperationMetadata>
        resumeCollectorOperationSettings() {
      return getStubSettingsBuilder().resumeCollectorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to registerCollector. */
    public UnaryCallSettings.Builder<RegisterCollectorRequest, Operation>
        registerCollectorSettings() {
      return getStubSettingsBuilder().registerCollectorSettings();
    }

    /** Returns the builder for the settings used for calls to registerCollector. */
    public OperationCallSettings.Builder<RegisterCollectorRequest, Collector, OperationMetadata>
        registerCollectorOperationSettings() {
      return getStubSettingsBuilder().registerCollectorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to pauseCollector. */
    public UnaryCallSettings.Builder<PauseCollectorRequest, Operation> pauseCollectorSettings() {
      return getStubSettingsBuilder().pauseCollectorSettings();
    }

    /** Returns the builder for the settings used for calls to pauseCollector. */
    public OperationCallSettings.Builder<PauseCollectorRequest, Collector, OperationMetadata>
        pauseCollectorOperationSettings() {
      return getStubSettingsBuilder().pauseCollectorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    @Override
    public RapidMigrationAssessmentSettings build() throws IOException {
      return new RapidMigrationAssessmentSettings(this);
    }
  }
}
