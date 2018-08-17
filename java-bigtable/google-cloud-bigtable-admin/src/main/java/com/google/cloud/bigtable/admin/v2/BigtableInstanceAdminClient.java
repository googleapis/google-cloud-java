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

import com.google.bigtable.admin.v2.ProjectName;
import com.google.cloud.bigtable.admin.v2.stub.BigtableInstanceAdminStub;
import java.io.IOException;
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
}
