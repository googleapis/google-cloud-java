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
import com.google.api.resourcenames.ResourceName;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ProjectName;
import com.google.cloud.Policy;
import com.google.cloud.Policy.DefaultMarshaller;
import com.google.cloud.bigtable.admin.v2.stub.BigtableInstanceAdminStub;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import java.io.IOException;
import java.util.Arrays;
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
   * Gets the IAM access control policy for the specified instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * Policy policy = client.getIamPolicy("my-instance");
   * for(Map.Entry<Role, Set<Identity>> entry : policy.getBindings().entrySet()) {
   *   System.out.printf("Role: %s Identities: %s\n", entry.getKey(), entry.getValue());
   * }
   * }</pre>
   *
   * @see <a href="https://cloud.google.com/bigtable/docs/access-control#iam-management-instance">Instance-level
   * IAM management</a>
   */
  @SuppressWarnings("WeakerAccess")
  public Policy getIamPolicy(String instanceId) {
    return awaitFuture(getIamPolicyAsync(instanceId));
  }

  /**
   * Asynchronously gets the IAM access control policy for the specified instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<Policy> policyFuture = client.getIamPolicyAsync("my-instance");
   *
   *
   * ApiFutures.addCallback(policyFuture,
   *   new ApiFutureCallback<Policy>() {
   *     public void onSuccess(Policy policy) {
   *       for (Entry<Role, Set<Identity>> entry : policy.getBindings().entrySet()) {
   *         System.out.printf("Role: %s Identities: %s\n", entry.getKey(), entry.getValue());
   *       }
   *     }
   *
   *     public void onFailure(Throwable t) {
   *       t.printStackTrace();
   *     }
   *   },
   *   MoreExecutors.directExecutor());
   * }</pre>
   *
   * @see <a href="https://cloud.google.com/bigtable/docs/access-control#iam-management-instance">Instance-level IAM management</a>
   */
  @SuppressWarnings("WeakerAccess")
  public ApiFuture<Policy> getIamPolicyAsync(String instanceId) {
    InstanceName name = InstanceName.of(projectName.getProject(), instanceId);

    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
        .setResource(name.toString())
        .build();

    final IamPolicyMarshaller marshaller = new IamPolicyMarshaller();

    return ApiFutures.transform(
        stub.getIamPolicyCallable().futureCall(request),
        new ApiFunction<com.google.iam.v1.Policy, Policy>() {
          @Override
          public Policy apply(com.google.iam.v1.Policy proto) {
            return marshaller.fromPb(proto);
          }
        },
        MoreExecutors.directExecutor()
    );
  }

  /**
   * Replaces the IAM policy associated with the specified instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * Policy newPolicy = client.setIamPolicy("my-instance",
   *   Policy.newBuilder()
   *     .addIdentity(Role.of("bigtable.user"), Identity.user("someone@example.com"))
   *     .addIdentity(Role.of("bigtable.admin"), Identity.group("admins@example.com"))
   *     .build());
   * }</pre>
   *
   * @see <a href="https://cloud.google.com/bigtable/docs/access-control#iam-management-instance">Instance-level IAM management</a>
   */
  @SuppressWarnings("WeakerAccess")
  public Policy setIamPolicy(String instanceId, Policy policy) {
    return awaitFuture(setIamPolicyAsync(instanceId, policy));
  }

  /**
   * Asynchronously replaces the IAM policy associated with the specified instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<Policy> newPolicyFuture = client.setIamPolicyAsync("my-instance",
   *   Policy.newBuilder()
   *     .addIdentity(Role.of("bigtable.user"), Identity.user("someone@example.com"))
   *     .addIdentity(Role.of("bigtable.admin"), Identity.group("admins@example.com"))
   *     .build());
   *
   * ApiFutures.addCallback(policyFuture,
   *   new ApiFutureCallback<Policy>() {
   *     public void onSuccess(Policy policy) {
   *       for (Entry<Role, Set<Identity>> entry : policy.getBindings().entrySet()) {
   *         System.out.printf("Role: %s Identities: %s\n", entry.getKey(), entry.getValue());
   *       }
   *     }
   *
   *     public void onFailure(Throwable t) {
   *       t.printStackTrace();
   *     }
   *   },
   *   MoreExecutors.directExecutor());
   * }</pre>
   *
   * @see <a href="https://cloud.google.com/bigtable/docs/access-control#iam-management-instance">Instance-level IAM management</a>
   */
  @SuppressWarnings("WeakerAccess")
  public ApiFuture<Policy> setIamPolicyAsync(String instanceId, Policy policy) {
    InstanceName name = InstanceName.of(projectName.getProject(), instanceId);
    final IamPolicyMarshaller marshaller = new IamPolicyMarshaller();

    SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
        .setResource(name.toString())
        .setPolicy(marshaller.toPb(policy))
        .build();

    return ApiFutures.transform(
        stub.setIamPolicyCallable().futureCall(request),
        new ApiFunction<com.google.iam.v1.Policy, Policy>() {
          @Override
          public Policy apply(com.google.iam.v1.Policy proto) {
            return marshaller.fromPb(proto);
          }
        },
        MoreExecutors.directExecutor()
    );
  }

  /**
   * Tests whether the caller has the given permissions for the specified instance.
   * Returns a subset of the specified permissions that the caller has.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * List<String> grantedPermissions = client.testIamPermission("my-instance",
   *   "bigtable.tables.readRows", "bigtable.tables.mutateRows");
   * }</pre>
   *
   * System.out.println("Has read access: " + grantedPermissions.contains("bigtable.tables.readRows"));
   * System.out.println("Has write access: " + grantedPermissions.contains("bigtable.tables.mutateRows"));
   *
   * @see <a href="https://cloud.google.com/bigtable/docs/access-control#permissions">Cloud Bigtable permissions</a>
   */
  @SuppressWarnings("WeakerAccess")
  public List<String> testIamPermission(String instanceId, String... permissions) {
    return testIamPermission(InstanceName.of(projectName.getProject(), instanceId), permissions);
  }

  /**
   * Asynchronously tests whether the caller has the given permissions for the specified instance.
   * Returns a subset of the specified permissions that the caller has.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<List<String>> grantedPermissionsFuture = client.testIamPermission("my-instance",
   *   "bigtable.tables.readRows", "bigtable.tables.mutateRows");
   *
   * ApiFutures.addCallback(grantedPermissionsFuture,
   *   new ApiFutureCallback<List<String>>() {
   *     public void onSuccess(List<String> grantedPermissions) {
   *       System.out.println("Has read access: " + grantedPermissions.contains("bigtable.tables.readRows"));
   *       System.out.println("Has write access: " + grantedPermissions.contains("bigtable.tables.mutateRows"));
   *     }
   *
   *     public void onFailure(Throwable t) {
   *       t.printStackTrace();
   *     }
   *   },
   *   MoreExecutors.directExecutor());
   * }</pre>
   *
   * @see <a href="https://cloud.google.com/bigtable/docs/access-control#permissions">Cloud Bigtable permissions</a>
   */
  @SuppressWarnings("WeakerAccess")
  public ApiFuture<List<String>> testIamPermissionAsync(String instanceId, String... permissions) {
    return testIamPermissionAsync(InstanceName.of(projectName.getProject(), instanceId), permissions);
  }

  /**
   * Tests whether the caller has the given permissions for the specified absolute resource name
   * (note that the current project of the client is ignored).
   *
   * Returns a subset of the specified permissions that the caller has.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * List<String> grantedPermissions = client.testIamPermission(
   *   TableName.of("my-project", "my-instance", "my-table"),
   *   "bigtable.tables.readRows", "bigtable.tables.mutateRows");
   *
   * System.out.println("Has read access: " + grantedPermissions.contains("bigtable.tables.readRows"));
   * System.out.println("Has write access: " + grantedPermissions.contains("bigtable.tables.mutateRows"));
   * }</pre>
   *
   * @see <a href="https://cloud.google.com/bigtable/docs/access-control#permissions">Cloud Bigtable permissions</a>
   */
  @SuppressWarnings("WeakerAccess")
  public List<String> testIamPermission(ResourceName resourceName, String... permissions) {
    return awaitFuture(testIamPermissionAsync(resourceName, permissions));
  }


  /**
   * Asynchronously tests whether the caller has the given permissions for the the specified
   * absolute resource name (note that the current project of the client is ignored).
   * Returns a subset of the specified permissions that the caller has.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * ApiFuture<List<String>> grantedPermissionsFuture = client.testIamPermission(
   *   TableName.of("my-project", "my-instance", "my-table"),
   *   "bigtable.tables.readRows", "bigtable.tables.mutateRows");
   *
   * ApiFutures.addCallback(grantedPermissionsFuture,
   *   new ApiFutureCallback<List<String>>() {
   *     public void onSuccess(List<String> grantedPermissions) {
   *       System.out.println("Has read access: " + grantedPermissions.contains("bigtable.tables.readRows"));
   *       System.out.println("Has write access: " + grantedPermissions.contains("bigtable.tables.mutateRows"));
   *     }
   *
   *     public void onFailure(Throwable t) {
   *       t.printStackTrace();
   *     }
   *   },
   *   MoreExecutors.directExecutor());
   * }</pre>
   *
   * @see <a href="https://cloud.google.com/bigtable/docs/access-control#permissions">Cloud Bigtable permissions</a>
   */
  @SuppressWarnings("WeakerAccess")
  public ApiFuture<List<String>> testIamPermissionAsync(ResourceName resourceName, String... permissions) {
    TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
        .setResource(resourceName.toString())
        .addAllPermissions(Arrays.asList(permissions))
        .build();

    return ApiFutures.transform(
        stub.testIamPermissionsCallable().futureCall(request),
        new ApiFunction<TestIamPermissionsResponse, List<String>>() {
          @Override
          public List<String> apply(TestIamPermissionsResponse input) {
            return input.getPermissionsList();
          }
        },
        MoreExecutors.directExecutor()
    );
  }

  /**
   * Simple adapter to expose {@link DefaultMarshaller} to this class. It enables this client to
   * convert to/from IAM wrappers and protobufs.
   */
  private static class IamPolicyMarshaller extends DefaultMarshaller {
    @Override
    public Policy fromPb(com.google.iam.v1.Policy policyPb) {
      return super.fromPb(policyPb);
    }

    @Override
    public com.google.iam.v1.Policy toPb(Policy policy) {
      return super.toPb(policy);
    }
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
