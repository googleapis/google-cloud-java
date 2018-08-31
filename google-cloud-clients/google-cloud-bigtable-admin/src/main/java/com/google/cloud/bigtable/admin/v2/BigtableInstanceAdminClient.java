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

import com.google.api.core.ApiAsyncFunction;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.bigtable.admin.v2.AppProfile.SingleClusterRouting;
import com.google.bigtable.admin.v2.AppProfileName;
import com.google.bigtable.admin.v2.DeleteAppProfileRequest;
import com.google.bigtable.admin.v2.GetAppProfileRequest;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ListAppProfilesRequest;
import com.google.bigtable.admin.v2.ProjectName;
import com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListAppProfilesPage;
import com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListAppProfilesPagedResponse;
import com.google.cloud.bigtable.admin.v2.models.AppProfile;
import com.google.cloud.bigtable.admin.v2.models.AppProfile.SingleClusterRoutingPolicy;
import com.google.cloud.bigtable.admin.v2.models.CreateAppProfileRequest;
import com.google.cloud.bigtable.admin.v2.models.UpdateAppProfileRequest;
import com.google.cloud.bigtable.admin.v2.stub.BigtableInstanceAdminStub;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.UncheckedExecutionException;
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
 * try(BigtableInstanceAdminClient client =  BigtableInstanceAdminClient.create(ProjectName.of("my-project"))) {
 *   CreateInstanceRequest request = CreateInstanceRequest.of("my-instance")
 *     .addFamily("cf1")
 *     .addFamily("cf2", GCRULES.maxVersions(10))
 *     .addSplit(ByteString.copyFromUtf8("b"))
 *     .addSplit(ByteString.copyFromUtf8("q"));
 *
 *   client.createInstance(request);
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
   * Creates a new app profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * AppProfile appProfile = client.createAppProfile(
   *   CreateAppProfileRequest.of("my-instance", "my-new-app-profile")
   *     .setRoutingPolicy(SingleClusterRoutingPolicy.of("my-cluster"))
   * );
   * }</pre>
   *
   * @see CreateAppProfileRequest
   */
  @SuppressWarnings("WeakerAccess")
  public AppProfile createAppProfile(CreateAppProfileRequest request) {
    return awaitFuture(createAppProfileAsync(request));
  }

  /**
   * Asynchronously creates a new app profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<AppProfile> appProfileFuture = client.createAppProfileAsync(
   *   CreateAppProfileRequest.of("my-instance", "my-new-app-profile")
   *     .setRoutingPolicy(SingleClusterRoutingPolicy.of("my-cluster"))
   * );
   *
   * AppProfile appProfile = appProfileFuture.get();
   * }</pre>
   *
   * @see CreateAppProfileRequest
   */
  @SuppressWarnings("WeakerAccess")
  public ApiFuture<AppProfile> createAppProfileAsync(CreateAppProfileRequest request) {
    return ApiFutures.transform(
        stub.createAppProfileCallable().futureCall(request.toProto(projectName)),
        new ApiFunction<com.google.bigtable.admin.v2.AppProfile, AppProfile>() {
          @Override
          public AppProfile apply(com.google.bigtable.admin.v2.AppProfile proto) {
            return AppProfile.fromProto(proto);
          }
        },
        MoreExecutors.directExecutor()
    );
  }

  /**
   * Get the app profile by id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * AppProfile appProfile = client.getAppProfile("my-instance", "my-app-profile");
   * }</pre>
   *
   * @see AppProfile
   */
  @SuppressWarnings("WeakerAccess")
  public AppProfile getAppProfile(String instanceId, String appProfileId) {
    return awaitFuture(getAppProfileAsync(instanceId, appProfileId));
  }

  /**
   * Asynchronously get the app profile by id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<AppProfile> appProfileFuture = client.getAppProfileAsync("my-instance", "my-app-profile");
   *
   * AppProfile appProfile = appProfileFuture.get();
   * }</pre>
   *
   * @see AppProfile
   */
  @SuppressWarnings("WeakerAccess")
  public ApiFuture<AppProfile> getAppProfileAsync(String instanceId, String appProfileId) {
    AppProfileName name = AppProfileName.of(projectName.getProject(), instanceId, appProfileId);

    GetAppProfileRequest request = GetAppProfileRequest.newBuilder()
        .setName(name.toString())
        .build();

    return ApiFutures.transform(
        stub.getAppProfileCallable().futureCall(request),
        new ApiFunction<com.google.bigtable.admin.v2.AppProfile, AppProfile>() {
          @Override
          public AppProfile apply(com.google.bigtable.admin.v2.AppProfile proto) {
            return AppProfile.fromProto(proto);
          }
        },
        MoreExecutors.directExecutor()
    );
  }

  /**
   * Lists all app profiles of the specified instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * List<AppProfile> appProfiles = client.listAppProfiles("my-instance");
   * }</pre>
   *
   * @see AppProfile
   */
  @SuppressWarnings("WeakerAccess")
  public List<AppProfile> listAppProfiles(String instanceId) {
    return awaitFuture(listAppProfilesAsync(instanceId));
  }

  /**
   * Asynchronously lists all app profiles of the specified instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<List<AppProfile>> appProfilesFuture = client.listAppProfilesAsync("my-instance");
   *
   * List<AppProfile> appProfiles = appProfileFuture.get();
   * }</pre>
   *
   * @see AppProfile
   */
  @SuppressWarnings("WeakerAccess")
  public ApiFuture<List<AppProfile>> listAppProfilesAsync(String instanceId) {
    InstanceName instanceName = InstanceName.of(projectName.getProject(), instanceId);

    ListAppProfilesRequest request = ListAppProfilesRequest.newBuilder()
        .setParent(instanceName.toString())
        .build();

    // TODO(igorbernstein2): try to upstream pagination spooling or figure out a way to expose the
    // paginated responses while maintaining the wrapper facade.

    // Fetch the first page.
    ApiFuture<ListAppProfilesPage> firstPageFuture = ApiFutures.transform(
        stub.listAppProfilesPagedCallable().futureCall(request),
        new ApiFunction<ListAppProfilesPagedResponse, ListAppProfilesPage>() {
          @Override
          public ListAppProfilesPage apply(ListAppProfilesPagedResponse response) {
            return response.getPage();
          }
        },
        MoreExecutors.directExecutor()
    );

    // Fetch the rest of the pages by chaining the futures.
    ApiFuture<List<com.google.bigtable.admin.v2.AppProfile>> allProtos = ApiFutures
        .transformAsync(
            firstPageFuture,
            new ApiAsyncFunction<ListAppProfilesPage, List<com.google.bigtable.admin.v2.AppProfile>>() {
              List<com.google.bigtable.admin.v2.AppProfile> responseAccumulator = Lists
                  .newArrayList();

              @Override
              public ApiFuture<List<com.google.bigtable.admin.v2.AppProfile>> apply(
                  ListAppProfilesPage page) {
                // Add all entries from the page
                responseAccumulator.addAll(Lists.newArrayList(page.getValues()));

                // If this is the last page, just return the accumulated responses.
                if (!page.hasNextPage()) {
                  return ApiFutures.immediateFuture(responseAccumulator);
                }

                // Otherwise fetch the next page.
                return ApiFutures.transformAsync(
                    page.getNextPageAsync(),
                    this,
                    MoreExecutors.directExecutor()
                );
              }
            },
            MoreExecutors.directExecutor()
        );

    // Wrap all of the accumulated protos.
    return ApiFutures.transform(allProtos,
        new ApiFunction<List<com.google.bigtable.admin.v2.AppProfile>, List<AppProfile>>() {
          @Override
          public List<AppProfile> apply(List<com.google.bigtable.admin.v2.AppProfile> input) {
            List<AppProfile> results = Lists.newArrayListWithCapacity(input.size());
            for (com.google.bigtable.admin.v2.AppProfile appProfile : input) {
              results.add(AppProfile.fromProto(appProfile));
            }
            return results;
          }
        },
        MoreExecutors.directExecutor()
    );
  }

  /**
   * Updates an existing app profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * AppProfile existingAppProfile = client.getAppProfile("my-instance", "my-app-profile");
   *
   * AppProfile updatedAppProfile = client.updateAppProfile(
   *   UpdateAppProfileRequest.of(existingAppProfile)
   *     .setRoutingPolicy(SingleClusterRoutingPolicy.of("my-cluster"))
   * );
   * }</pre>
   *
   * @see UpdateAppProfileRequest
   */
  @SuppressWarnings("WeakerAccess")
  public AppProfile updateAppProfile(UpdateAppProfileRequest request) {
    return awaitFuture(updateAppProfileAsync(request));
  }

  /**
   * Asynchronously updates an existing app profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   *
   * ApiFuture<AppProfile> existingAppProfileFuture = client.getAppProfileAsync("my-instance", "my-app-profile");
   *
   * ApiFuture<AppProfile> updatedAppProfileFuture = ApiFutures.transformAsync(
   *   existingAppProfileFuture,
   *   new ApiAsyncFunction<AppProfile, AppProfile>() {
   *     @Override
   *     public ApiFuture<AppProfile> apply(AppProfile existingAppProfile) {
   *       return client.updateAppProfileAsync(
   *         UpdateAppProfileRequest.of(existingAppProfile)
   *           .setRoutingPolicy(SingleClusterRoutingPolicy.of("my-other-cluster"))
   *       );
   *     }
   *   },
   *   MoreExecutors.directExecutor()
   * );
   *
   * ApiFuture<AppProfile> appProfile = updatedAppProfileFuture.get();
   * }</pre>
   *
   * @see UpdateAppProfileRequest
   */
  @SuppressWarnings("WeakerAccess")
  public ApiFuture<AppProfile> updateAppProfileAsync(UpdateAppProfileRequest request) {
    return ApiFutures.transform(
        stub.updateAppProfileOperationCallable().futureCall(request.toProto(projectName)),
        new ApiFunction<com.google.bigtable.admin.v2.AppProfile, AppProfile>() {
          @Override
          public AppProfile apply(com.google.bigtable.admin.v2.AppProfile proto) {
            return AppProfile.fromProto(proto);
          }
        },
        MoreExecutors.directExecutor()
    );
  }

  /**
   * Deletes the specified app profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * client.deleteAppProfile("my-instance", "my-app-profile");
   * }</pre>
   */
  @SuppressWarnings("WeakerAccess")
  public void deleteAppProfile(String instanceId, String appProfileId) {
    awaitFuture(deleteAppProfileAsync(instanceId, appProfileId));
  }

  /**
   * Asynchronously deletes the specified app profile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<Void> deleteFuture = client.deleteAppProfileAsync("my-instance", "my-app-profile");
   *
   * deleteFuture.get();
   * }</pre>
   */
  @SuppressWarnings("WeakerAccess")
  public ApiFuture<Void> deleteAppProfileAsync(String instanceId, String appProfileId) {
    AppProfileName name = AppProfileName.of(projectName.getProject(), instanceId, appProfileId);
    DeleteAppProfileRequest request = DeleteAppProfileRequest.newBuilder()
        .setName(name.toString())
        .build();

    return ApiFutures.transform(
        stub.deleteAppProfileCallable().futureCall(request),
        new ApiFunction<Empty, Void>() {
          @Override
          public Void apply(Empty input) {
            return null;
          }
        },
        MoreExecutors.directExecutor()
    );
  }

  /**
   * Awaits the result of a future, taking care to propagate errors while maintaining the call site
   * in a suppressed exception. This allows semantic errors to be caught across threads, while
   * preserving the call site in the error. The caller's stacktrace will be made available as a
   * suppressed exception.
   */
  // TODO(igorbernstein2): try to move this into gax
  private <T> T awaitFuture(ApiFuture<T> future) {
    RuntimeException error;
    try {
      return Futures.getUnchecked(future);
    } catch (UncheckedExecutionException e) {
      if (e.getCause() instanceof RuntimeException) {
        error = (RuntimeException) e.getCause();
      } else {
        error = e;
      }
    } catch (RuntimeException e) {
      error = e;
    }
    // Add the caller's stack as a suppressed exception
    error.addSuppressed(new RuntimeException("Encountered error while awaiting future"));
    throw error;
  }
}
