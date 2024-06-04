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

package com.google.cloud.managedkafka.v1;

import static com.google.cloud.managedkafka.v1.ManagedKafkaClient.ListClustersPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaClient.ListConsumerGroupsPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaClient.ListLocationsPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaClient.ListTopicsPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.managedkafka.v1.stub.ManagedKafkaStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ManagedKafkaClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (managedkafka.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getCluster to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ManagedKafkaSettings.Builder managedKafkaSettingsBuilder = ManagedKafkaSettings.newBuilder();
 * managedKafkaSettingsBuilder
 *     .getClusterSettings()
 *     .setRetrySettings(
 *         managedKafkaSettingsBuilder
 *             .getClusterSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ManagedKafkaSettings managedKafkaSettings = managedKafkaSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ManagedKafkaSettings extends ClientSettings<ManagedKafkaSettings> {

  /** Returns the object with the settings used for calls to listClusters. */
  public PagedCallSettings<ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
      listClustersSettings() {
    return ((ManagedKafkaStubSettings) getStubSettings()).listClustersSettings();
  }

  /** Returns the object with the settings used for calls to getCluster. */
  public UnaryCallSettings<GetClusterRequest, Cluster> getClusterSettings() {
    return ((ManagedKafkaStubSettings) getStubSettings()).getClusterSettings();
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public UnaryCallSettings<CreateClusterRequest, Operation> createClusterSettings() {
    return ((ManagedKafkaStubSettings) getStubSettings()).createClusterSettings();
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public OperationCallSettings<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationSettings() {
    return ((ManagedKafkaStubSettings) getStubSettings()).createClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public UnaryCallSettings<UpdateClusterRequest, Operation> updateClusterSettings() {
    return ((ManagedKafkaStubSettings) getStubSettings()).updateClusterSettings();
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public OperationCallSettings<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationSettings() {
    return ((ManagedKafkaStubSettings) getStubSettings()).updateClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public UnaryCallSettings<DeleteClusterRequest, Operation> deleteClusterSettings() {
    return ((ManagedKafkaStubSettings) getStubSettings()).deleteClusterSettings();
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public OperationCallSettings<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationSettings() {
    return ((ManagedKafkaStubSettings) getStubSettings()).deleteClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to listTopics. */
  public PagedCallSettings<ListTopicsRequest, ListTopicsResponse, ListTopicsPagedResponse>
      listTopicsSettings() {
    return ((ManagedKafkaStubSettings) getStubSettings()).listTopicsSettings();
  }

  /** Returns the object with the settings used for calls to getTopic. */
  public UnaryCallSettings<GetTopicRequest, Topic> getTopicSettings() {
    return ((ManagedKafkaStubSettings) getStubSettings()).getTopicSettings();
  }

  /** Returns the object with the settings used for calls to createTopic. */
  public UnaryCallSettings<CreateTopicRequest, Topic> createTopicSettings() {
    return ((ManagedKafkaStubSettings) getStubSettings()).createTopicSettings();
  }

  /** Returns the object with the settings used for calls to updateTopic. */
  public UnaryCallSettings<UpdateTopicRequest, Topic> updateTopicSettings() {
    return ((ManagedKafkaStubSettings) getStubSettings()).updateTopicSettings();
  }

  /** Returns the object with the settings used for calls to deleteTopic. */
  public UnaryCallSettings<DeleteTopicRequest, Empty> deleteTopicSettings() {
    return ((ManagedKafkaStubSettings) getStubSettings()).deleteTopicSettings();
  }

  /** Returns the object with the settings used for calls to listConsumerGroups. */
  public PagedCallSettings<
          ListConsumerGroupsRequest, ListConsumerGroupsResponse, ListConsumerGroupsPagedResponse>
      listConsumerGroupsSettings() {
    return ((ManagedKafkaStubSettings) getStubSettings()).listConsumerGroupsSettings();
  }

  /** Returns the object with the settings used for calls to getConsumerGroup. */
  public UnaryCallSettings<GetConsumerGroupRequest, ConsumerGroup> getConsumerGroupSettings() {
    return ((ManagedKafkaStubSettings) getStubSettings()).getConsumerGroupSettings();
  }

  /** Returns the object with the settings used for calls to updateConsumerGroup. */
  public UnaryCallSettings<UpdateConsumerGroupRequest, ConsumerGroup>
      updateConsumerGroupSettings() {
    return ((ManagedKafkaStubSettings) getStubSettings()).updateConsumerGroupSettings();
  }

  /** Returns the object with the settings used for calls to deleteConsumerGroup. */
  public UnaryCallSettings<DeleteConsumerGroupRequest, Empty> deleteConsumerGroupSettings() {
    return ((ManagedKafkaStubSettings) getStubSettings()).deleteConsumerGroupSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ManagedKafkaStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ManagedKafkaStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final ManagedKafkaSettings create(ManagedKafkaStubSettings stub)
      throws IOException {
    return new ManagedKafkaSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ManagedKafkaStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ManagedKafkaStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ManagedKafkaStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ManagedKafkaStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ManagedKafkaStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ManagedKafkaStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ManagedKafkaStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ManagedKafkaStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ManagedKafkaSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ManagedKafkaSettings. */
  public static class Builder extends ClientSettings.Builder<ManagedKafkaSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ManagedKafkaStubSettings.newBuilder(clientContext));
    }

    protected Builder(ManagedKafkaSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ManagedKafkaStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ManagedKafkaStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(ManagedKafkaStubSettings.newHttpJsonBuilder());
    }

    public ManagedKafkaStubSettings.Builder getStubSettingsBuilder() {
      return ((ManagedKafkaStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listClusters. */
    public PagedCallSettings.Builder<
            ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
        listClustersSettings() {
      return getStubSettingsBuilder().listClustersSettings();
    }

    /** Returns the builder for the settings used for calls to getCluster. */
    public UnaryCallSettings.Builder<GetClusterRequest, Cluster> getClusterSettings() {
      return getStubSettingsBuilder().getClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    public UnaryCallSettings.Builder<CreateClusterRequest, Operation> createClusterSettings() {
      return getStubSettingsBuilder().createClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    public OperationCallSettings.Builder<CreateClusterRequest, Cluster, OperationMetadata>
        createClusterOperationSettings() {
      return getStubSettingsBuilder().createClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    public UnaryCallSettings.Builder<UpdateClusterRequest, Operation> updateClusterSettings() {
      return getStubSettingsBuilder().updateClusterSettings();
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    public OperationCallSettings.Builder<UpdateClusterRequest, Cluster, OperationMetadata>
        updateClusterOperationSettings() {
      return getStubSettingsBuilder().updateClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCluster. */
    public UnaryCallSettings.Builder<DeleteClusterRequest, Operation> deleteClusterSettings() {
      return getStubSettingsBuilder().deleteClusterSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCluster. */
    public OperationCallSettings.Builder<DeleteClusterRequest, Empty, OperationMetadata>
        deleteClusterOperationSettings() {
      return getStubSettingsBuilder().deleteClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listTopics. */
    public PagedCallSettings.Builder<ListTopicsRequest, ListTopicsResponse, ListTopicsPagedResponse>
        listTopicsSettings() {
      return getStubSettingsBuilder().listTopicsSettings();
    }

    /** Returns the builder for the settings used for calls to getTopic. */
    public UnaryCallSettings.Builder<GetTopicRequest, Topic> getTopicSettings() {
      return getStubSettingsBuilder().getTopicSettings();
    }

    /** Returns the builder for the settings used for calls to createTopic. */
    public UnaryCallSettings.Builder<CreateTopicRequest, Topic> createTopicSettings() {
      return getStubSettingsBuilder().createTopicSettings();
    }

    /** Returns the builder for the settings used for calls to updateTopic. */
    public UnaryCallSettings.Builder<UpdateTopicRequest, Topic> updateTopicSettings() {
      return getStubSettingsBuilder().updateTopicSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTopic. */
    public UnaryCallSettings.Builder<DeleteTopicRequest, Empty> deleteTopicSettings() {
      return getStubSettingsBuilder().deleteTopicSettings();
    }

    /** Returns the builder for the settings used for calls to listConsumerGroups. */
    public PagedCallSettings.Builder<
            ListConsumerGroupsRequest, ListConsumerGroupsResponse, ListConsumerGroupsPagedResponse>
        listConsumerGroupsSettings() {
      return getStubSettingsBuilder().listConsumerGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to getConsumerGroup. */
    public UnaryCallSettings.Builder<GetConsumerGroupRequest, ConsumerGroup>
        getConsumerGroupSettings() {
      return getStubSettingsBuilder().getConsumerGroupSettings();
    }

    /** Returns the builder for the settings used for calls to updateConsumerGroup. */
    public UnaryCallSettings.Builder<UpdateConsumerGroupRequest, ConsumerGroup>
        updateConsumerGroupSettings() {
      return getStubSettingsBuilder().updateConsumerGroupSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConsumerGroup. */
    public UnaryCallSettings.Builder<DeleteConsumerGroupRequest, Empty>
        deleteConsumerGroupSettings() {
      return getStubSettingsBuilder().deleteConsumerGroupSettings();
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
    public ManagedKafkaSettings build() throws IOException {
      return new ManagedKafkaSettings(this);
    }
  }
}
