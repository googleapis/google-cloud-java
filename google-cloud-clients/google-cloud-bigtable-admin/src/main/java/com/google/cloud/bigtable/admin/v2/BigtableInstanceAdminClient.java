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
package com.google.cloud.bigtable.admin.v2;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.bigtable.admin.v2.DeleteInstanceRequest;
import com.google.bigtable.admin.v2.GetInstanceRequest;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ListInstancesRequest;
import com.google.bigtable.admin.v2.ListInstancesResponse;
import com.google.bigtable.admin.v2.LocationName;
import com.google.bigtable.admin.v2.ProjectName;
import com.google.cloud.bigtable.admin.v2.models.CreateInstanceRequest;
import com.google.cloud.bigtable.admin.v2.models.Instance;
import com.google.cloud.bigtable.admin.v2.models.UpdateInstanceRequest;
import com.google.cloud.bigtable.admin.v2.stub.BigtableInstanceAdminStub;
import com.google.common.base.Verify;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Client for creating, configuring and delete Cloud Bigtable instances (including AppProfiles and
 * Clusters).
 *
 * <p>See the individual methods for example code.
 *
 * <pre>{@code
 * try(BigtableInstanceAdminClient client =  BigtableInstanceAdminClient.create(ProjectName.of("[PROJECT]"))) {
 *   CreateInstanceRequest request = CreateInstanceRequest.of("my-instance")
 *     .addCluster("my-cluster", "us-east1-c", 3, StorageType.SSD);
 *
 *   Instance instance = client.createInstance(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the client object to clean up resources such as threads.
 * In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>This class can be customized by passing in a custom instance of BigtableInstanceAdminSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * BigtableInstanceAdminSettings settings = BigtableInstanceAdminSettings.newBuilder()
 *   .setProjectName(ProjectName.of("[PROJECT]"))
 *   .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *   .build();
 *
 * BigtableInstanceAdminClient client = BigtableInstanceAdminClient.create(settings);
 * }</pre>
 *
 * To customize the endpoint:
 *
 * <pre>{@code
 * BigtableInstanceAdminSettings settings = BigtableInstanceAdminSettings.newBuilder()
 *   .setProjectName(ProjectName.of("[PROJECT]"))
 *   .setEndpoint(myEndpoint)
 *   .build();
 *
 * BigtableInstanceAdminClient client = BigtableInstanceAdminClient.create(settings);
 * }</pre>
 */
public final class BigtableInstanceAdminClient implements AutoCloseable {
  private final ProjectName projectName;
  private final BigtableInstanceAdminStub stub;

  /** Constructs an instance of BigtableInstanceAdminClient with the given ProjectName. */
  public static BigtableInstanceAdminClient create(@Nonnull ProjectName projectName)
      throws IOException {
    return create(BigtableInstanceAdminSettings.newBuilder().setProjectName(projectName).build());
  }

  /** Constructs an instance of BigtableInstanceAdminClient with the given settings. */
  public static BigtableInstanceAdminClient create(@Nonnull BigtableInstanceAdminSettings settings)
      throws IOException {
    return create(settings.getProjectName(), settings.getStubSettings().createStub());
  }

  /** Constructs an instance of BigtableInstanceAdminClient with the given Projectname and stub. */
  public static BigtableInstanceAdminClient create(@Nonnull ProjectName projectName,
      @Nonnull BigtableInstanceAdminStub stub) {
    return new BigtableInstanceAdminClient(projectName, stub);
  }


  private BigtableInstanceAdminClient(
      @Nonnull ProjectName projectName, @Nonnull BigtableInstanceAdminStub stub) {
    this.projectName = projectName;
    this.stub = stub;
  }

  /** Gets the ProjectName this client is associated with. */
  public ProjectName getProjectName() {
    return projectName;
  }

  /** Closes the client and frees all resources associated with it (like thread pools) */
  @Override
  public void close() {
    stub.close();
  }

  /**
   * Creates a new instance and returns its representation.
   *
   * @see CreateInstanceRequest for details.
   */
  public Instance createInstance(CreateInstanceRequest request) {
    return awaitFuture(createInstanceAsync(request));
  }

  /**
   * Asynchronously creates a new instance and returns its representation wrapped in a future.
   *
   * @see CreateInstanceRequest for details.
   */
  public ApiFuture<Instance> createInstanceAsync(CreateInstanceRequest request) {
    return ApiFutures.transform(
        stub.createInstanceOperationCallable().futureCall(request.toProto(projectName)),
        Instance.PROTO_TRANSFORMER,
        MoreExecutors.directExecutor());
  }

  /**
   * Updates a new instance and returns its representation.
   *
   * @see UpdateInstanceRequest for details.
   */
  public Instance updateInstance(UpdateInstanceRequest request) {
    return awaitFuture(updateInstanceAsync(request));
  }

  /**
   * Asynchronously updates a new instance and returns its representation wrapped in a future.
   *
   * @see UpdateInstanceRequest for details.
   */
  public ApiFuture<Instance> updateInstanceAsync(UpdateInstanceRequest request) {
    return ApiFutures.transform(
        stub.partialUpdateInstanceOperationCallable().futureCall(request.toProto(projectName)),
        Instance.PROTO_TRANSFORMER,
        MoreExecutors.directExecutor());
  }

  /** Get the instance representation. */
  public Instance getInstance(String id) {
    return awaitFuture(getInstanceAsync(id));
  }

  /** Asynchronously gets the instance representation wrapped in a future. */
  public ApiFuture<Instance> getInstanceAsync(String instanceId) {

    InstanceName name = InstanceName.of(projectName.getProject(), instanceId);

    GetInstanceRequest request = GetInstanceRequest.newBuilder()
        .setName(name.toString())
        .build();

    return ApiFutures.transform(
        stub.getInstanceCallable().futureCall(request),
        Instance.PROTO_TRANSFORMER,
        MoreExecutors.directExecutor());
  }

  /** Lists all of the instances in the current project. */
  public List<Instance> listInstances() {
    return awaitFuture(listInstancesAsync());
  }

  /** Asynchronously lists all of the instances in the current project. */
  public ApiFuture<List<Instance>> listInstancesAsync() {
    ListInstancesRequest request = ListInstancesRequest.newBuilder()
        .setParent(projectName.toString())
        .build();

    ApiFuture<ListInstancesResponse> responseFuture = stub.listInstancesCallable()
        .futureCall(request);

    return ApiFutures.transform(responseFuture, new ApiFunction<ListInstancesResponse, List<Instance>>() {
      @Override
      public List<Instance> apply(ListInstancesResponse proto) {
        // NOTE: pagination is intentionally ignored. The server does not implement it.
        Verify.verify(proto.getNextPageToken().isEmpty(),
            "Server returned an unexpected paginated response");

        ImmutableList.Builder<Instance> instances = ImmutableList.builder();

        for (com.google.bigtable.admin.v2.Instance protoInstance : proto.getInstancesList()) {
          instances.add(Instance.PROTO_TRANSFORMER.apply(protoInstance));
        }

        ImmutableList.Builder<String> failedZones = ImmutableList.builder();
        for (String locationStr : proto.getFailedLocationsList()) {
          failedZones.add(LocationName.parse(locationStr).getLocation());
        }


        if (!failedZones.build().isEmpty()) {
          throw new PartialListInstancesException(failedZones.build(), instances.build());
        }

        return instances.build();
      }
    }, MoreExecutors.directExecutor());
  }

  /** Deletes the specified instance. */
  public void deleteInstance(String instanceId) {
    awaitFuture(deleteInstanceAsync(instanceId));
  }

  /** Asynchronously deletes the specified instance. */
  private ApiFuture<Void> deleteInstanceAsync(String instanceId) {
    InstanceName instanceName = InstanceName.of(projectName.getProject(), instanceId);

    DeleteInstanceRequest request = DeleteInstanceRequest.newBuilder()
        .setName(instanceName.toString())
        .build();

    return ApiFutures.transform(stub.deleteInstanceCallable().futureCall(request),
        new ApiFunction<Empty, Void>() {
          @Override
          public Void apply(Empty input) {
            return null;
          }
        },
        MoreExecutors.directExecutor()
    );
  }


  private <T> T awaitFuture(ApiFuture<T> future) {
    try {
      return future.get();
    } catch(Throwable t) {
      // TODO(igorbernstein2): figure out a better wrapper exception.
      throw new RuntimeException(t);
    }
  }

  /**
   * Exception thrown when some zones are unavailable and listInstances is unable to return a full
   * instance list. This exception can be inspected to get a partial list.
   */
  public static class PartialListInstancesException extends RuntimeException {
    private final List<String> failedZones;
    private final List<Instance> instances;

    PartialListInstancesException(List<String> failedZones, List<Instance> instances) {
      super("Failed to list all instances, some zones where unavailable");

      this.failedZones = failedZones;
      this.instances = instances;
    }

    /** A list of zones, whose unavailability caused this error. */
    public List<String> getFailedZones() {
      return failedZones;
    }

    /** A partial list of instances that were found in the available zones. */
    public List<Instance> getInstances() {
      return instances;
    }
  }
}
