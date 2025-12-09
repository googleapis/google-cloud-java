/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.dataplex.v1;

import static com.google.cloud.dataplex.v1.BusinessGlossaryServiceClient.ListGlossariesPagedResponse;
import static com.google.cloud.dataplex.v1.BusinessGlossaryServiceClient.ListGlossaryCategoriesPagedResponse;
import static com.google.cloud.dataplex.v1.BusinessGlossaryServiceClient.ListGlossaryTermsPagedResponse;
import static com.google.cloud.dataplex.v1.BusinessGlossaryServiceClient.ListLocationsPagedResponse;

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
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.dataplex.v1.stub.BusinessGlossaryServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link BusinessGlossaryServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dataplex.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getGlossary:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BusinessGlossaryServiceSettings.Builder businessGlossaryServiceSettingsBuilder =
 *     BusinessGlossaryServiceSettings.newBuilder();
 * businessGlossaryServiceSettingsBuilder
 *     .getGlossarySettings()
 *     .setRetrySettings(
 *         businessGlossaryServiceSettingsBuilder
 *             .getGlossarySettings()
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
 * BusinessGlossaryServiceSettings businessGlossaryServiceSettings =
 *     businessGlossaryServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createGlossary:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BusinessGlossaryServiceSettings.Builder businessGlossaryServiceSettingsBuilder =
 *     BusinessGlossaryServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * businessGlossaryServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class BusinessGlossaryServiceSettings
    extends ClientSettings<BusinessGlossaryServiceSettings> {

  /** Returns the object with the settings used for calls to createGlossary. */
  public UnaryCallSettings<CreateGlossaryRequest, Operation> createGlossarySettings() {
    return ((BusinessGlossaryServiceStubSettings) getStubSettings()).createGlossarySettings();
  }

  /** Returns the object with the settings used for calls to createGlossary. */
  public OperationCallSettings<CreateGlossaryRequest, Glossary, OperationMetadata>
      createGlossaryOperationSettings() {
    return ((BusinessGlossaryServiceStubSettings) getStubSettings())
        .createGlossaryOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateGlossary. */
  public UnaryCallSettings<UpdateGlossaryRequest, Operation> updateGlossarySettings() {
    return ((BusinessGlossaryServiceStubSettings) getStubSettings()).updateGlossarySettings();
  }

  /** Returns the object with the settings used for calls to updateGlossary. */
  public OperationCallSettings<UpdateGlossaryRequest, Glossary, OperationMetadata>
      updateGlossaryOperationSettings() {
    return ((BusinessGlossaryServiceStubSettings) getStubSettings())
        .updateGlossaryOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteGlossary. */
  public UnaryCallSettings<DeleteGlossaryRequest, Operation> deleteGlossarySettings() {
    return ((BusinessGlossaryServiceStubSettings) getStubSettings()).deleteGlossarySettings();
  }

  /** Returns the object with the settings used for calls to deleteGlossary. */
  public OperationCallSettings<DeleteGlossaryRequest, Empty, OperationMetadata>
      deleteGlossaryOperationSettings() {
    return ((BusinessGlossaryServiceStubSettings) getStubSettings())
        .deleteGlossaryOperationSettings();
  }

  /** Returns the object with the settings used for calls to getGlossary. */
  public UnaryCallSettings<GetGlossaryRequest, Glossary> getGlossarySettings() {
    return ((BusinessGlossaryServiceStubSettings) getStubSettings()).getGlossarySettings();
  }

  /** Returns the object with the settings used for calls to listGlossaries. */
  public PagedCallSettings<
          ListGlossariesRequest, ListGlossariesResponse, ListGlossariesPagedResponse>
      listGlossariesSettings() {
    return ((BusinessGlossaryServiceStubSettings) getStubSettings()).listGlossariesSettings();
  }

  /** Returns the object with the settings used for calls to createGlossaryCategory. */
  public UnaryCallSettings<CreateGlossaryCategoryRequest, GlossaryCategory>
      createGlossaryCategorySettings() {
    return ((BusinessGlossaryServiceStubSettings) getStubSettings())
        .createGlossaryCategorySettings();
  }

  /** Returns the object with the settings used for calls to updateGlossaryCategory. */
  public UnaryCallSettings<UpdateGlossaryCategoryRequest, GlossaryCategory>
      updateGlossaryCategorySettings() {
    return ((BusinessGlossaryServiceStubSettings) getStubSettings())
        .updateGlossaryCategorySettings();
  }

  /** Returns the object with the settings used for calls to deleteGlossaryCategory. */
  public UnaryCallSettings<DeleteGlossaryCategoryRequest, Empty> deleteGlossaryCategorySettings() {
    return ((BusinessGlossaryServiceStubSettings) getStubSettings())
        .deleteGlossaryCategorySettings();
  }

  /** Returns the object with the settings used for calls to getGlossaryCategory. */
  public UnaryCallSettings<GetGlossaryCategoryRequest, GlossaryCategory>
      getGlossaryCategorySettings() {
    return ((BusinessGlossaryServiceStubSettings) getStubSettings()).getGlossaryCategorySettings();
  }

  /** Returns the object with the settings used for calls to listGlossaryCategories. */
  public PagedCallSettings<
          ListGlossaryCategoriesRequest,
          ListGlossaryCategoriesResponse,
          ListGlossaryCategoriesPagedResponse>
      listGlossaryCategoriesSettings() {
    return ((BusinessGlossaryServiceStubSettings) getStubSettings())
        .listGlossaryCategoriesSettings();
  }

  /** Returns the object with the settings used for calls to createGlossaryTerm. */
  public UnaryCallSettings<CreateGlossaryTermRequest, GlossaryTerm> createGlossaryTermSettings() {
    return ((BusinessGlossaryServiceStubSettings) getStubSettings()).createGlossaryTermSettings();
  }

  /** Returns the object with the settings used for calls to updateGlossaryTerm. */
  public UnaryCallSettings<UpdateGlossaryTermRequest, GlossaryTerm> updateGlossaryTermSettings() {
    return ((BusinessGlossaryServiceStubSettings) getStubSettings()).updateGlossaryTermSettings();
  }

  /** Returns the object with the settings used for calls to deleteGlossaryTerm. */
  public UnaryCallSettings<DeleteGlossaryTermRequest, Empty> deleteGlossaryTermSettings() {
    return ((BusinessGlossaryServiceStubSettings) getStubSettings()).deleteGlossaryTermSettings();
  }

  /** Returns the object with the settings used for calls to getGlossaryTerm. */
  public UnaryCallSettings<GetGlossaryTermRequest, GlossaryTerm> getGlossaryTermSettings() {
    return ((BusinessGlossaryServiceStubSettings) getStubSettings()).getGlossaryTermSettings();
  }

  /** Returns the object with the settings used for calls to listGlossaryTerms. */
  public PagedCallSettings<
          ListGlossaryTermsRequest, ListGlossaryTermsResponse, ListGlossaryTermsPagedResponse>
      listGlossaryTermsSettings() {
    return ((BusinessGlossaryServiceStubSettings) getStubSettings()).listGlossaryTermsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((BusinessGlossaryServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((BusinessGlossaryServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final BusinessGlossaryServiceSettings create(
      BusinessGlossaryServiceStubSettings stub) throws IOException {
    return new BusinessGlossaryServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return BusinessGlossaryServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return BusinessGlossaryServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return BusinessGlossaryServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return BusinessGlossaryServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return BusinessGlossaryServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return BusinessGlossaryServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return BusinessGlossaryServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BusinessGlossaryServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected BusinessGlossaryServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for BusinessGlossaryServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<BusinessGlossaryServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(BusinessGlossaryServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(BusinessGlossaryServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(BusinessGlossaryServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(BusinessGlossaryServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(BusinessGlossaryServiceStubSettings.newHttpJsonBuilder());
    }

    public BusinessGlossaryServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((BusinessGlossaryServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createGlossary. */
    public UnaryCallSettings.Builder<CreateGlossaryRequest, Operation> createGlossarySettings() {
      return getStubSettingsBuilder().createGlossarySettings();
    }

    /** Returns the builder for the settings used for calls to createGlossary. */
    public OperationCallSettings.Builder<CreateGlossaryRequest, Glossary, OperationMetadata>
        createGlossaryOperationSettings() {
      return getStubSettingsBuilder().createGlossaryOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateGlossary. */
    public UnaryCallSettings.Builder<UpdateGlossaryRequest, Operation> updateGlossarySettings() {
      return getStubSettingsBuilder().updateGlossarySettings();
    }

    /** Returns the builder for the settings used for calls to updateGlossary. */
    public OperationCallSettings.Builder<UpdateGlossaryRequest, Glossary, OperationMetadata>
        updateGlossaryOperationSettings() {
      return getStubSettingsBuilder().updateGlossaryOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGlossary. */
    public UnaryCallSettings.Builder<DeleteGlossaryRequest, Operation> deleteGlossarySettings() {
      return getStubSettingsBuilder().deleteGlossarySettings();
    }

    /** Returns the builder for the settings used for calls to deleteGlossary. */
    public OperationCallSettings.Builder<DeleteGlossaryRequest, Empty, OperationMetadata>
        deleteGlossaryOperationSettings() {
      return getStubSettingsBuilder().deleteGlossaryOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getGlossary. */
    public UnaryCallSettings.Builder<GetGlossaryRequest, Glossary> getGlossarySettings() {
      return getStubSettingsBuilder().getGlossarySettings();
    }

    /** Returns the builder for the settings used for calls to listGlossaries. */
    public PagedCallSettings.Builder<
            ListGlossariesRequest, ListGlossariesResponse, ListGlossariesPagedResponse>
        listGlossariesSettings() {
      return getStubSettingsBuilder().listGlossariesSettings();
    }

    /** Returns the builder for the settings used for calls to createGlossaryCategory. */
    public UnaryCallSettings.Builder<CreateGlossaryCategoryRequest, GlossaryCategory>
        createGlossaryCategorySettings() {
      return getStubSettingsBuilder().createGlossaryCategorySettings();
    }

    /** Returns the builder for the settings used for calls to updateGlossaryCategory. */
    public UnaryCallSettings.Builder<UpdateGlossaryCategoryRequest, GlossaryCategory>
        updateGlossaryCategorySettings() {
      return getStubSettingsBuilder().updateGlossaryCategorySettings();
    }

    /** Returns the builder for the settings used for calls to deleteGlossaryCategory. */
    public UnaryCallSettings.Builder<DeleteGlossaryCategoryRequest, Empty>
        deleteGlossaryCategorySettings() {
      return getStubSettingsBuilder().deleteGlossaryCategorySettings();
    }

    /** Returns the builder for the settings used for calls to getGlossaryCategory. */
    public UnaryCallSettings.Builder<GetGlossaryCategoryRequest, GlossaryCategory>
        getGlossaryCategorySettings() {
      return getStubSettingsBuilder().getGlossaryCategorySettings();
    }

    /** Returns the builder for the settings used for calls to listGlossaryCategories. */
    public PagedCallSettings.Builder<
            ListGlossaryCategoriesRequest,
            ListGlossaryCategoriesResponse,
            ListGlossaryCategoriesPagedResponse>
        listGlossaryCategoriesSettings() {
      return getStubSettingsBuilder().listGlossaryCategoriesSettings();
    }

    /** Returns the builder for the settings used for calls to createGlossaryTerm. */
    public UnaryCallSettings.Builder<CreateGlossaryTermRequest, GlossaryTerm>
        createGlossaryTermSettings() {
      return getStubSettingsBuilder().createGlossaryTermSettings();
    }

    /** Returns the builder for the settings used for calls to updateGlossaryTerm. */
    public UnaryCallSettings.Builder<UpdateGlossaryTermRequest, GlossaryTerm>
        updateGlossaryTermSettings() {
      return getStubSettingsBuilder().updateGlossaryTermSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGlossaryTerm. */
    public UnaryCallSettings.Builder<DeleteGlossaryTermRequest, Empty>
        deleteGlossaryTermSettings() {
      return getStubSettingsBuilder().deleteGlossaryTermSettings();
    }

    /** Returns the builder for the settings used for calls to getGlossaryTerm. */
    public UnaryCallSettings.Builder<GetGlossaryTermRequest, GlossaryTerm>
        getGlossaryTermSettings() {
      return getStubSettingsBuilder().getGlossaryTermSettings();
    }

    /** Returns the builder for the settings used for calls to listGlossaryTerms. */
    public PagedCallSettings.Builder<
            ListGlossaryTermsRequest, ListGlossaryTermsResponse, ListGlossaryTermsPagedResponse>
        listGlossaryTermsSettings() {
      return getStubSettingsBuilder().listGlossaryTermsSettings();
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
    public BusinessGlossaryServiceSettings build() throws IOException {
      return new BusinessGlossaryServiceSettings(this);
    }
  }
}
