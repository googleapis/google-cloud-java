/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.devtools.containeranalysis.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.devtools.containeranalysis.v1.stub.ContainerAnalysisStub;
import com.google.cloud.devtools.containeranalysis.v1.stub.ContainerAnalysisStubSettings;
import com.google.containeranalysis.v1.IamResourceName;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import io.grafeas.v1.GrafeasClient;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Retrieves analysis results of Cloud components such as Docker container
 * images. The Container Analysis API is an implementation of the [Grafeas](https://grafeas.io) API.
 *
 * <p>Analysis results are stored as a series of occurrences. An `Occurrence` contains information
 * about a specific analysis instance on a resource. An occurrence refers to a `Note`. A note
 * contains details describing the analysis and is generally stored in a separate project, called a
 * `Provider`. Multiple occurrences can refer to the same note.
 *
 * <p>For example, an SSL vulnerability could affect multiple images. In this case, there would be
 * one note for the vulnerability and an occurrence for each image with the vulnerability referring
 * to that note.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
 *   IamResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
 *   Policy policy = Policy.newBuilder().build();
 *   Policy response = containerAnalysisClient.setIamPolicy(resource, policy);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the containerAnalysisClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of ContainerAnalysisSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * ContainerAnalysisSettings containerAnalysisSettings =
 *     ContainerAnalysisSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ContainerAnalysisClient containerAnalysisClient =
 *     ContainerAnalysisClient.create(containerAnalysisSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ContainerAnalysisSettings containerAnalysisSettings =
 *     ContainerAnalysisSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ContainerAnalysisClient containerAnalysisClient =
 *     ContainerAnalysisClient.create(containerAnalysisSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ContainerAnalysisClient implements BackgroundResource {
  private final ContainerAnalysisSettings settings;
  private final ContainerAnalysisStub stub;
  /**
   * Returns a new GrafeasClient with the same configured settings.
   *
   * @throws IOException
   */
  public GrafeasClient getGrafeasClient() throws IOException {
    return GrafeasClient.create(GrafeasUtils.transformSettings(settings));
  }

  /** Constructs an instance of ContainerAnalysisClient with default settings. */
  public static final ContainerAnalysisClient create() throws IOException {
    return create(ContainerAnalysisSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ContainerAnalysisClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ContainerAnalysisClient create(ContainerAnalysisSettings settings)
      throws IOException {
    return new ContainerAnalysisClient(settings);
  }

  /**
   * Constructs an instance of ContainerAnalysisClient, using the given stub for making calls. This
   * is for advanced usage - prefer to use ContainerAnalysisSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ContainerAnalysisClient create(ContainerAnalysisStub stub) {
    return new ContainerAnalysisClient(stub);
  }

  /**
   * Constructs an instance of ContainerAnalysisClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ContainerAnalysisClient(ContainerAnalysisSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ContainerAnalysisStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ContainerAnalysisClient(ContainerAnalysisStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ContainerAnalysisSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ContainerAnalysisStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified note or occurrence. Requires
   * `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy`
   * permission if the resource is a note or an occurrence, respectively.
   *
   * <p>The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and
   * `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   IamResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = containerAnalysisClient.setIamPolicy(resource, policy);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(IamResourceName resource, Policy policy) {

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setPolicy(policy)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified note or occurrence. Requires
   * `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy`
   * permission if the resource is a note or an occurrence, respectively.
   *
   * <p>The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and
   * `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   IamResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = containerAnalysisClient.setIamPolicy(resource.toString(), policy);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource, Policy policy) {

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified note or occurrence. Requires
   * `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy`
   * permission if the resource is a note or an occurrence, respectively.
   *
   * <p>The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and
   * `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   ResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .setPolicy(policy)
   *     .build();
   *   Policy response = containerAnalysisClient.setIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sets the access control policy on the specified note or occurrence. Requires
   * `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy`
   * permission if the resource is a note or an occurrence, respectively.
   *
   * <p>The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and
   * `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   ResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .setPolicy(policy)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = containerAnalysisClient.setIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a note or an occurrence resource. Requires
   * `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy`
   * permission if the resource is a note or occurrence, respectively.
   *
   * <p>The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and
   * `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   IamResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
   *   Policy response = containerAnalysisClient.getIamPolicy(resource);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(IamResourceName resource) {

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a note or an occurrence resource. Requires
   * `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy`
   * permission if the resource is a note or occurrence, respectively.
   *
   * <p>The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and
   * `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   IamResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
   *   Policy response = containerAnalysisClient.getIamPolicy(resource.toString());
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {

    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a note or an occurrence resource. Requires
   * `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy`
   * permission if the resource is a note or occurrence, respectively.
   *
   * <p>The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and
   * `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   ResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .build();
   *   Policy response = containerAnalysisClient.getIamPolicy(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the access control policy for a note or an occurrence resource. Requires
   * `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy`
   * permission if the resource is a note or occurrence, respectively.
   *
   * <p>The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and
   * `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   ResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = containerAnalysisClient.getIamPolicyCallable().futureCall(request);
   *   // Do something
   *   Policy response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the permissions that a caller has on the specified note or occurrence. Requires list
   * permission on the project (for example, `containeranalysis.notes.list`).
   *
   * <p>The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and
   * `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   IamResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsResponse response = containerAnalysisClient.testIamPermissions(resource, permissions);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      IamResourceName resource, List<String> permissions) {

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the permissions that a caller has on the specified note or occurrence. Requires list
   * permission on the project (for example, `containeranalysis.notes.list`).
   *
   * <p>The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and
   * `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   IamResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsResponse response = containerAnalysisClient.testIamPermissions(resource.toString(), permissions);
   * }
   * </code></pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      String resource, List<String> permissions) {

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the permissions that a caller has on the specified note or occurrence. Requires list
   * permission on the project (for example, `containeranalysis.notes.list`).
   *
   * <p>The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and
   * `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   ResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .addAllPermissions(permissions)
   *     .build();
   *   TestIamPermissionsResponse response = containerAnalysisClient.testIamPermissions(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the permissions that a caller has on the specified note or occurrence. Requires list
   * permission on the project (for example, `containeranalysis.notes.list`).
   *
   * <p>The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and
   * `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   ResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .addAllPermissions(permissions)
   *     .build();
   *   ApiFuture&lt;TestIamPermissionsResponse&gt; future = containerAnalysisClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something
   *   TestIamPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }
}
