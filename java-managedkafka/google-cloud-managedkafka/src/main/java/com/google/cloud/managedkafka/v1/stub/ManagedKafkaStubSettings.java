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

package com.google.cloud.managedkafka.v1.stub;

import static com.google.cloud.managedkafka.v1.ManagedKafkaClient.ListAclsPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaClient.ListClustersPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaClient.ListConsumerGroupsPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaClient.ListLocationsPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaClient.ListTopicsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.managedkafka.v1.Acl;
import com.google.cloud.managedkafka.v1.AddAclEntryRequest;
import com.google.cloud.managedkafka.v1.AddAclEntryResponse;
import com.google.cloud.managedkafka.v1.Cluster;
import com.google.cloud.managedkafka.v1.ConsumerGroup;
import com.google.cloud.managedkafka.v1.CreateAclRequest;
import com.google.cloud.managedkafka.v1.CreateClusterRequest;
import com.google.cloud.managedkafka.v1.CreateTopicRequest;
import com.google.cloud.managedkafka.v1.DeleteAclRequest;
import com.google.cloud.managedkafka.v1.DeleteClusterRequest;
import com.google.cloud.managedkafka.v1.DeleteConsumerGroupRequest;
import com.google.cloud.managedkafka.v1.DeleteTopicRequest;
import com.google.cloud.managedkafka.v1.GetAclRequest;
import com.google.cloud.managedkafka.v1.GetClusterRequest;
import com.google.cloud.managedkafka.v1.GetConsumerGroupRequest;
import com.google.cloud.managedkafka.v1.GetTopicRequest;
import com.google.cloud.managedkafka.v1.ListAclsRequest;
import com.google.cloud.managedkafka.v1.ListAclsResponse;
import com.google.cloud.managedkafka.v1.ListClustersRequest;
import com.google.cloud.managedkafka.v1.ListClustersResponse;
import com.google.cloud.managedkafka.v1.ListConsumerGroupsRequest;
import com.google.cloud.managedkafka.v1.ListConsumerGroupsResponse;
import com.google.cloud.managedkafka.v1.ListTopicsRequest;
import com.google.cloud.managedkafka.v1.ListTopicsResponse;
import com.google.cloud.managedkafka.v1.OperationMetadata;
import com.google.cloud.managedkafka.v1.RemoveAclEntryRequest;
import com.google.cloud.managedkafka.v1.RemoveAclEntryResponse;
import com.google.cloud.managedkafka.v1.Topic;
import com.google.cloud.managedkafka.v1.UpdateAclRequest;
import com.google.cloud.managedkafka.v1.UpdateClusterRequest;
import com.google.cloud.managedkafka.v1.UpdateConsumerGroupRequest;
import com.google.cloud.managedkafka.v1.UpdateTopicRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ManagedKafkaStub}.
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
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getCluster:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ManagedKafkaStubSettings.Builder managedKafkaSettingsBuilder =
 *     ManagedKafkaStubSettings.newBuilder();
 * managedKafkaSettingsBuilder
 *     .getClusterSettings()
 *     .setRetrySettings(
 *         managedKafkaSettingsBuilder
 *             .getClusterSettings()
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
 * ManagedKafkaStubSettings managedKafkaSettings = managedKafkaSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createCluster:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ManagedKafkaStubSettings.Builder managedKafkaSettingsBuilder =
 *     ManagedKafkaStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * managedKafkaSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ManagedKafkaStubSettings extends StubSettings<ManagedKafkaStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
      listClustersSettings;
  private final UnaryCallSettings<GetClusterRequest, Cluster> getClusterSettings;
  private final UnaryCallSettings<CreateClusterRequest, Operation> createClusterSettings;
  private final OperationCallSettings<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationSettings;
  private final UnaryCallSettings<UpdateClusterRequest, Operation> updateClusterSettings;
  private final OperationCallSettings<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationSettings;
  private final UnaryCallSettings<DeleteClusterRequest, Operation> deleteClusterSettings;
  private final OperationCallSettings<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationSettings;
  private final PagedCallSettings<ListTopicsRequest, ListTopicsResponse, ListTopicsPagedResponse>
      listTopicsSettings;
  private final UnaryCallSettings<GetTopicRequest, Topic> getTopicSettings;
  private final UnaryCallSettings<CreateTopicRequest, Topic> createTopicSettings;
  private final UnaryCallSettings<UpdateTopicRequest, Topic> updateTopicSettings;
  private final UnaryCallSettings<DeleteTopicRequest, Empty> deleteTopicSettings;
  private final PagedCallSettings<
          ListConsumerGroupsRequest, ListConsumerGroupsResponse, ListConsumerGroupsPagedResponse>
      listConsumerGroupsSettings;
  private final UnaryCallSettings<GetConsumerGroupRequest, ConsumerGroup> getConsumerGroupSettings;
  private final UnaryCallSettings<UpdateConsumerGroupRequest, ConsumerGroup>
      updateConsumerGroupSettings;
  private final UnaryCallSettings<DeleteConsumerGroupRequest, Empty> deleteConsumerGroupSettings;
  private final PagedCallSettings<ListAclsRequest, ListAclsResponse, ListAclsPagedResponse>
      listAclsSettings;
  private final UnaryCallSettings<GetAclRequest, Acl> getAclSettings;
  private final UnaryCallSettings<CreateAclRequest, Acl> createAclSettings;
  private final UnaryCallSettings<UpdateAclRequest, Acl> updateAclSettings;
  private final UnaryCallSettings<DeleteAclRequest, Empty> deleteAclSettings;
  private final UnaryCallSettings<AddAclEntryRequest, AddAclEntryResponse> addAclEntrySettings;
  private final UnaryCallSettings<RemoveAclEntryRequest, RemoveAclEntryResponse>
      removeAclEntrySettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListClustersRequest, ListClustersResponse, Cluster>
      LIST_CLUSTERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListClustersRequest, ListClustersResponse, Cluster>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListClustersRequest injectToken(ListClustersRequest payload, String token) {
              return ListClustersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListClustersRequest injectPageSize(ListClustersRequest payload, int pageSize) {
              return ListClustersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListClustersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListClustersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Cluster> extractResources(ListClustersResponse payload) {
              return payload.getClustersList();
            }
          };

  private static final PagedListDescriptor<ListTopicsRequest, ListTopicsResponse, Topic>
      LIST_TOPICS_PAGE_STR_DESC =
          new PagedListDescriptor<ListTopicsRequest, ListTopicsResponse, Topic>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTopicsRequest injectToken(ListTopicsRequest payload, String token) {
              return ListTopicsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTopicsRequest injectPageSize(ListTopicsRequest payload, int pageSize) {
              return ListTopicsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTopicsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTopicsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Topic> extractResources(ListTopicsResponse payload) {
              return payload.getTopicsList();
            }
          };

  private static final PagedListDescriptor<
          ListConsumerGroupsRequest, ListConsumerGroupsResponse, ConsumerGroup>
      LIST_CONSUMER_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListConsumerGroupsRequest, ListConsumerGroupsResponse, ConsumerGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListConsumerGroupsRequest injectToken(
                ListConsumerGroupsRequest payload, String token) {
              return ListConsumerGroupsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListConsumerGroupsRequest injectPageSize(
                ListConsumerGroupsRequest payload, int pageSize) {
              return ListConsumerGroupsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListConsumerGroupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListConsumerGroupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ConsumerGroup> extractResources(ListConsumerGroupsResponse payload) {
              return payload.getConsumerGroupsList();
            }
          };

  private static final PagedListDescriptor<ListAclsRequest, ListAclsResponse, Acl>
      LIST_ACLS_PAGE_STR_DESC =
          new PagedListDescriptor<ListAclsRequest, ListAclsResponse, Acl>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAclsRequest injectToken(ListAclsRequest payload, String token) {
              return ListAclsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAclsRequest injectPageSize(ListAclsRequest payload, int pageSize) {
              return ListAclsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAclsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAclsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Acl> extractResources(ListAclsResponse payload) {
              return payload.getAclsList();
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
              return payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
      LIST_CLUSTERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>() {
            @Override
            public ApiFuture<ListClustersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListClustersRequest, ListClustersResponse> callable,
                ListClustersRequest request,
                ApiCallContext context,
                ApiFuture<ListClustersResponse> futureResponse) {
              PageContext<ListClustersRequest, ListClustersResponse, Cluster> pageContext =
                  PageContext.create(callable, LIST_CLUSTERS_PAGE_STR_DESC, request, context);
              return ListClustersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTopicsRequest, ListTopicsResponse, ListTopicsPagedResponse>
      LIST_TOPICS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTopicsRequest, ListTopicsResponse, ListTopicsPagedResponse>() {
            @Override
            public ApiFuture<ListTopicsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTopicsRequest, ListTopicsResponse> callable,
                ListTopicsRequest request,
                ApiCallContext context,
                ApiFuture<ListTopicsResponse> futureResponse) {
              PageContext<ListTopicsRequest, ListTopicsResponse, Topic> pageContext =
                  PageContext.create(callable, LIST_TOPICS_PAGE_STR_DESC, request, context);
              return ListTopicsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListConsumerGroupsRequest, ListConsumerGroupsResponse, ListConsumerGroupsPagedResponse>
      LIST_CONSUMER_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListConsumerGroupsRequest,
              ListConsumerGroupsResponse,
              ListConsumerGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListConsumerGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListConsumerGroupsRequest, ListConsumerGroupsResponse> callable,
                ListConsumerGroupsRequest request,
                ApiCallContext context,
                ApiFuture<ListConsumerGroupsResponse> futureResponse) {
              PageContext<ListConsumerGroupsRequest, ListConsumerGroupsResponse, ConsumerGroup>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CONSUMER_GROUPS_PAGE_STR_DESC, request, context);
              return ListConsumerGroupsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAclsRequest, ListAclsResponse, ListAclsPagedResponse>
      LIST_ACLS_PAGE_STR_FACT =
          new PagedListResponseFactory<ListAclsRequest, ListAclsResponse, ListAclsPagedResponse>() {
            @Override
            public ApiFuture<ListAclsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAclsRequest, ListAclsResponse> callable,
                ListAclsRequest request,
                ApiCallContext context,
                ApiFuture<ListAclsResponse> futureResponse) {
              PageContext<ListAclsRequest, ListAclsResponse, Acl> pageContext =
                  PageContext.create(callable, LIST_ACLS_PAGE_STR_DESC, request, context);
              return ListAclsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listClusters. */
  public PagedCallSettings<ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
      listClustersSettings() {
    return listClustersSettings;
  }

  /** Returns the object with the settings used for calls to getCluster. */
  public UnaryCallSettings<GetClusterRequest, Cluster> getClusterSettings() {
    return getClusterSettings;
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public UnaryCallSettings<CreateClusterRequest, Operation> createClusterSettings() {
    return createClusterSettings;
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public OperationCallSettings<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationSettings() {
    return createClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public UnaryCallSettings<UpdateClusterRequest, Operation> updateClusterSettings() {
    return updateClusterSettings;
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public OperationCallSettings<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationSettings() {
    return updateClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public UnaryCallSettings<DeleteClusterRequest, Operation> deleteClusterSettings() {
    return deleteClusterSettings;
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public OperationCallSettings<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationSettings() {
    return deleteClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to listTopics. */
  public PagedCallSettings<ListTopicsRequest, ListTopicsResponse, ListTopicsPagedResponse>
      listTopicsSettings() {
    return listTopicsSettings;
  }

  /** Returns the object with the settings used for calls to getTopic. */
  public UnaryCallSettings<GetTopicRequest, Topic> getTopicSettings() {
    return getTopicSettings;
  }

  /** Returns the object with the settings used for calls to createTopic. */
  public UnaryCallSettings<CreateTopicRequest, Topic> createTopicSettings() {
    return createTopicSettings;
  }

  /** Returns the object with the settings used for calls to updateTopic. */
  public UnaryCallSettings<UpdateTopicRequest, Topic> updateTopicSettings() {
    return updateTopicSettings;
  }

  /** Returns the object with the settings used for calls to deleteTopic. */
  public UnaryCallSettings<DeleteTopicRequest, Empty> deleteTopicSettings() {
    return deleteTopicSettings;
  }

  /** Returns the object with the settings used for calls to listConsumerGroups. */
  public PagedCallSettings<
          ListConsumerGroupsRequest, ListConsumerGroupsResponse, ListConsumerGroupsPagedResponse>
      listConsumerGroupsSettings() {
    return listConsumerGroupsSettings;
  }

  /** Returns the object with the settings used for calls to getConsumerGroup. */
  public UnaryCallSettings<GetConsumerGroupRequest, ConsumerGroup> getConsumerGroupSettings() {
    return getConsumerGroupSettings;
  }

  /** Returns the object with the settings used for calls to updateConsumerGroup. */
  public UnaryCallSettings<UpdateConsumerGroupRequest, ConsumerGroup>
      updateConsumerGroupSettings() {
    return updateConsumerGroupSettings;
  }

  /** Returns the object with the settings used for calls to deleteConsumerGroup. */
  public UnaryCallSettings<DeleteConsumerGroupRequest, Empty> deleteConsumerGroupSettings() {
    return deleteConsumerGroupSettings;
  }

  /** Returns the object with the settings used for calls to listAcls. */
  public PagedCallSettings<ListAclsRequest, ListAclsResponse, ListAclsPagedResponse>
      listAclsSettings() {
    return listAclsSettings;
  }

  /** Returns the object with the settings used for calls to getAcl. */
  public UnaryCallSettings<GetAclRequest, Acl> getAclSettings() {
    return getAclSettings;
  }

  /** Returns the object with the settings used for calls to createAcl. */
  public UnaryCallSettings<CreateAclRequest, Acl> createAclSettings() {
    return createAclSettings;
  }

  /** Returns the object with the settings used for calls to updateAcl. */
  public UnaryCallSettings<UpdateAclRequest, Acl> updateAclSettings() {
    return updateAclSettings;
  }

  /** Returns the object with the settings used for calls to deleteAcl. */
  public UnaryCallSettings<DeleteAclRequest, Empty> deleteAclSettings() {
    return deleteAclSettings;
  }

  /** Returns the object with the settings used for calls to addAclEntry. */
  public UnaryCallSettings<AddAclEntryRequest, AddAclEntryResponse> addAclEntrySettings() {
    return addAclEntrySettings;
  }

  /** Returns the object with the settings used for calls to removeAclEntry. */
  public UnaryCallSettings<RemoveAclEntryRequest, RemoveAclEntryResponse> removeAclEntrySettings() {
    return removeAclEntrySettings;
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

  public ManagedKafkaStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcManagedKafkaStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonManagedKafkaStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "managedkafka";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "managedkafka.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "managedkafka.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(ManagedKafkaStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ManagedKafkaStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ManagedKafkaStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected ManagedKafkaStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listClustersSettings = settingsBuilder.listClustersSettings().build();
    getClusterSettings = settingsBuilder.getClusterSettings().build();
    createClusterSettings = settingsBuilder.createClusterSettings().build();
    createClusterOperationSettings = settingsBuilder.createClusterOperationSettings().build();
    updateClusterSettings = settingsBuilder.updateClusterSettings().build();
    updateClusterOperationSettings = settingsBuilder.updateClusterOperationSettings().build();
    deleteClusterSettings = settingsBuilder.deleteClusterSettings().build();
    deleteClusterOperationSettings = settingsBuilder.deleteClusterOperationSettings().build();
    listTopicsSettings = settingsBuilder.listTopicsSettings().build();
    getTopicSettings = settingsBuilder.getTopicSettings().build();
    createTopicSettings = settingsBuilder.createTopicSettings().build();
    updateTopicSettings = settingsBuilder.updateTopicSettings().build();
    deleteTopicSettings = settingsBuilder.deleteTopicSettings().build();
    listConsumerGroupsSettings = settingsBuilder.listConsumerGroupsSettings().build();
    getConsumerGroupSettings = settingsBuilder.getConsumerGroupSettings().build();
    updateConsumerGroupSettings = settingsBuilder.updateConsumerGroupSettings().build();
    deleteConsumerGroupSettings = settingsBuilder.deleteConsumerGroupSettings().build();
    listAclsSettings = settingsBuilder.listAclsSettings().build();
    getAclSettings = settingsBuilder.getAclSettings().build();
    createAclSettings = settingsBuilder.createAclSettings().build();
    updateAclSettings = settingsBuilder.updateAclSettings().build();
    deleteAclSettings = settingsBuilder.deleteAclSettings().build();
    addAclEntrySettings = settingsBuilder.addAclEntrySettings().build();
    removeAclEntrySettings = settingsBuilder.removeAclEntrySettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for ManagedKafkaStubSettings. */
  public static class Builder extends StubSettings.Builder<ManagedKafkaStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
        listClustersSettings;
    private final UnaryCallSettings.Builder<GetClusterRequest, Cluster> getClusterSettings;
    private final UnaryCallSettings.Builder<CreateClusterRequest, Operation> createClusterSettings;
    private final OperationCallSettings.Builder<CreateClusterRequest, Cluster, OperationMetadata>
        createClusterOperationSettings;
    private final UnaryCallSettings.Builder<UpdateClusterRequest, Operation> updateClusterSettings;
    private final OperationCallSettings.Builder<UpdateClusterRequest, Cluster, OperationMetadata>
        updateClusterOperationSettings;
    private final UnaryCallSettings.Builder<DeleteClusterRequest, Operation> deleteClusterSettings;
    private final OperationCallSettings.Builder<DeleteClusterRequest, Empty, OperationMetadata>
        deleteClusterOperationSettings;
    private final PagedCallSettings.Builder<
            ListTopicsRequest, ListTopicsResponse, ListTopicsPagedResponse>
        listTopicsSettings;
    private final UnaryCallSettings.Builder<GetTopicRequest, Topic> getTopicSettings;
    private final UnaryCallSettings.Builder<CreateTopicRequest, Topic> createTopicSettings;
    private final UnaryCallSettings.Builder<UpdateTopicRequest, Topic> updateTopicSettings;
    private final UnaryCallSettings.Builder<DeleteTopicRequest, Empty> deleteTopicSettings;
    private final PagedCallSettings.Builder<
            ListConsumerGroupsRequest, ListConsumerGroupsResponse, ListConsumerGroupsPagedResponse>
        listConsumerGroupsSettings;
    private final UnaryCallSettings.Builder<GetConsumerGroupRequest, ConsumerGroup>
        getConsumerGroupSettings;
    private final UnaryCallSettings.Builder<UpdateConsumerGroupRequest, ConsumerGroup>
        updateConsumerGroupSettings;
    private final UnaryCallSettings.Builder<DeleteConsumerGroupRequest, Empty>
        deleteConsumerGroupSettings;
    private final PagedCallSettings.Builder<
            ListAclsRequest, ListAclsResponse, ListAclsPagedResponse>
        listAclsSettings;
    private final UnaryCallSettings.Builder<GetAclRequest, Acl> getAclSettings;
    private final UnaryCallSettings.Builder<CreateAclRequest, Acl> createAclSettings;
    private final UnaryCallSettings.Builder<UpdateAclRequest, Acl> updateAclSettings;
    private final UnaryCallSettings.Builder<DeleteAclRequest, Empty> deleteAclSettings;
    private final UnaryCallSettings.Builder<AddAclEntryRequest, AddAclEntryResponse>
        addAclEntrySettings;
    private final UnaryCallSettings.Builder<RemoveAclEntryRequest, RemoveAclEntryResponse>
        removeAclEntrySettings;
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
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
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

      listClustersSettings = PagedCallSettings.newBuilder(LIST_CLUSTERS_PAGE_STR_FACT);
      getClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createClusterOperationSettings = OperationCallSettings.newBuilder();
      updateClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateClusterOperationSettings = OperationCallSettings.newBuilder();
      deleteClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteClusterOperationSettings = OperationCallSettings.newBuilder();
      listTopicsSettings = PagedCallSettings.newBuilder(LIST_TOPICS_PAGE_STR_FACT);
      getTopicSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTopicSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTopicSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTopicSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listConsumerGroupsSettings = PagedCallSettings.newBuilder(LIST_CONSUMER_GROUPS_PAGE_STR_FACT);
      getConsumerGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateConsumerGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteConsumerGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAclsSettings = PagedCallSettings.newBuilder(LIST_ACLS_PAGE_STR_FACT);
      getAclSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAclSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAclSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAclSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      addAclEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removeAclEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listClustersSettings,
              getClusterSettings,
              createClusterSettings,
              updateClusterSettings,
              deleteClusterSettings,
              listTopicsSettings,
              getTopicSettings,
              createTopicSettings,
              updateTopicSettings,
              deleteTopicSettings,
              listConsumerGroupsSettings,
              getConsumerGroupSettings,
              updateConsumerGroupSettings,
              deleteConsumerGroupSettings,
              listAclsSettings,
              getAclSettings,
              createAclSettings,
              updateAclSettings,
              deleteAclSettings,
              addAclEntrySettings,
              removeAclEntrySettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(ManagedKafkaStubSettings settings) {
      super(settings);

      listClustersSettings = settings.listClustersSettings.toBuilder();
      getClusterSettings = settings.getClusterSettings.toBuilder();
      createClusterSettings = settings.createClusterSettings.toBuilder();
      createClusterOperationSettings = settings.createClusterOperationSettings.toBuilder();
      updateClusterSettings = settings.updateClusterSettings.toBuilder();
      updateClusterOperationSettings = settings.updateClusterOperationSettings.toBuilder();
      deleteClusterSettings = settings.deleteClusterSettings.toBuilder();
      deleteClusterOperationSettings = settings.deleteClusterOperationSettings.toBuilder();
      listTopicsSettings = settings.listTopicsSettings.toBuilder();
      getTopicSettings = settings.getTopicSettings.toBuilder();
      createTopicSettings = settings.createTopicSettings.toBuilder();
      updateTopicSettings = settings.updateTopicSettings.toBuilder();
      deleteTopicSettings = settings.deleteTopicSettings.toBuilder();
      listConsumerGroupsSettings = settings.listConsumerGroupsSettings.toBuilder();
      getConsumerGroupSettings = settings.getConsumerGroupSettings.toBuilder();
      updateConsumerGroupSettings = settings.updateConsumerGroupSettings.toBuilder();
      deleteConsumerGroupSettings = settings.deleteConsumerGroupSettings.toBuilder();
      listAclsSettings = settings.listAclsSettings.toBuilder();
      getAclSettings = settings.getAclSettings.toBuilder();
      createAclSettings = settings.createAclSettings.toBuilder();
      updateAclSettings = settings.updateAclSettings.toBuilder();
      deleteAclSettings = settings.deleteAclSettings.toBuilder();
      addAclEntrySettings = settings.addAclEntrySettings.toBuilder();
      removeAclEntrySettings = settings.removeAclEntrySettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listClustersSettings,
              getClusterSettings,
              createClusterSettings,
              updateClusterSettings,
              deleteClusterSettings,
              listTopicsSettings,
              getTopicSettings,
              createTopicSettings,
              updateTopicSettings,
              deleteTopicSettings,
              listConsumerGroupsSettings,
              getConsumerGroupSettings,
              updateConsumerGroupSettings,
              deleteConsumerGroupSettings,
              listAclsSettings,
              getAclSettings,
              createAclSettings,
              updateAclSettings,
              deleteAclSettings,
              addAclEntrySettings,
              removeAclEntrySettings,
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
          .listClustersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listTopicsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getTopicSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createTopicSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateTopicSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteTopicSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listConsumerGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getConsumerGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateConsumerGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteConsumerGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listAclsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getAclSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createAclSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateAclSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteAclSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .addAclEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .removeAclEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Cluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Cluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
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

    /** Returns the builder for the settings used for calls to listClusters. */
    public PagedCallSettings.Builder<
            ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
        listClustersSettings() {
      return listClustersSettings;
    }

    /** Returns the builder for the settings used for calls to getCluster. */
    public UnaryCallSettings.Builder<GetClusterRequest, Cluster> getClusterSettings() {
      return getClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    public UnaryCallSettings.Builder<CreateClusterRequest, Operation> createClusterSettings() {
      return createClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    public OperationCallSettings.Builder<CreateClusterRequest, Cluster, OperationMetadata>
        createClusterOperationSettings() {
      return createClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    public UnaryCallSettings.Builder<UpdateClusterRequest, Operation> updateClusterSettings() {
      return updateClusterSettings;
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    public OperationCallSettings.Builder<UpdateClusterRequest, Cluster, OperationMetadata>
        updateClusterOperationSettings() {
      return updateClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCluster. */
    public UnaryCallSettings.Builder<DeleteClusterRequest, Operation> deleteClusterSettings() {
      return deleteClusterSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCluster. */
    public OperationCallSettings.Builder<DeleteClusterRequest, Empty, OperationMetadata>
        deleteClusterOperationSettings() {
      return deleteClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listTopics. */
    public PagedCallSettings.Builder<ListTopicsRequest, ListTopicsResponse, ListTopicsPagedResponse>
        listTopicsSettings() {
      return listTopicsSettings;
    }

    /** Returns the builder for the settings used for calls to getTopic. */
    public UnaryCallSettings.Builder<GetTopicRequest, Topic> getTopicSettings() {
      return getTopicSettings;
    }

    /** Returns the builder for the settings used for calls to createTopic. */
    public UnaryCallSettings.Builder<CreateTopicRequest, Topic> createTopicSettings() {
      return createTopicSettings;
    }

    /** Returns the builder for the settings used for calls to updateTopic. */
    public UnaryCallSettings.Builder<UpdateTopicRequest, Topic> updateTopicSettings() {
      return updateTopicSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTopic. */
    public UnaryCallSettings.Builder<DeleteTopicRequest, Empty> deleteTopicSettings() {
      return deleteTopicSettings;
    }

    /** Returns the builder for the settings used for calls to listConsumerGroups. */
    public PagedCallSettings.Builder<
            ListConsumerGroupsRequest, ListConsumerGroupsResponse, ListConsumerGroupsPagedResponse>
        listConsumerGroupsSettings() {
      return listConsumerGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to getConsumerGroup. */
    public UnaryCallSettings.Builder<GetConsumerGroupRequest, ConsumerGroup>
        getConsumerGroupSettings() {
      return getConsumerGroupSettings;
    }

    /** Returns the builder for the settings used for calls to updateConsumerGroup. */
    public UnaryCallSettings.Builder<UpdateConsumerGroupRequest, ConsumerGroup>
        updateConsumerGroupSettings() {
      return updateConsumerGroupSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConsumerGroup. */
    public UnaryCallSettings.Builder<DeleteConsumerGroupRequest, Empty>
        deleteConsumerGroupSettings() {
      return deleteConsumerGroupSettings;
    }

    /** Returns the builder for the settings used for calls to listAcls. */
    public PagedCallSettings.Builder<ListAclsRequest, ListAclsResponse, ListAclsPagedResponse>
        listAclsSettings() {
      return listAclsSettings;
    }

    /** Returns the builder for the settings used for calls to getAcl. */
    public UnaryCallSettings.Builder<GetAclRequest, Acl> getAclSettings() {
      return getAclSettings;
    }

    /** Returns the builder for the settings used for calls to createAcl. */
    public UnaryCallSettings.Builder<CreateAclRequest, Acl> createAclSettings() {
      return createAclSettings;
    }

    /** Returns the builder for the settings used for calls to updateAcl. */
    public UnaryCallSettings.Builder<UpdateAclRequest, Acl> updateAclSettings() {
      return updateAclSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAcl. */
    public UnaryCallSettings.Builder<DeleteAclRequest, Empty> deleteAclSettings() {
      return deleteAclSettings;
    }

    /** Returns the builder for the settings used for calls to addAclEntry. */
    public UnaryCallSettings.Builder<AddAclEntryRequest, AddAclEntryResponse>
        addAclEntrySettings() {
      return addAclEntrySettings;
    }

    /** Returns the builder for the settings used for calls to removeAclEntry. */
    public UnaryCallSettings.Builder<RemoveAclEntryRequest, RemoveAclEntryResponse>
        removeAclEntrySettings() {
      return removeAclEntrySettings;
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
    public ManagedKafkaStubSettings build() throws IOException {
      return new ManagedKafkaStubSettings(this);
    }
  }
}
