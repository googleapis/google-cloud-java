/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.devtools.containeranalysis.v1beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.devtools.containeranalysis.v1beta1.stub.ContainerAnalysisV1Beta1Stub;
import com.google.cloud.devtools.containeranalysis.v1beta1.stub.ContainerAnalysisV1Beta1StubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.containeranalysis.v1beta1.GetScanConfigRequest;
import com.google.containeranalysis.v1beta1.IamResourceName;
import com.google.containeranalysis.v1beta1.ListScanConfigsRequest;
import com.google.containeranalysis.v1beta1.ListScanConfigsResponse;
import com.google.containeranalysis.v1beta1.ProjectName;
import com.google.containeranalysis.v1beta1.ScanConfig;
import com.google.containeranalysis.v1beta1.ScanConfigName;
import com.google.containeranalysis.v1beta1.UpdateScanConfigRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Retrieves analysis results of Cloud components such as Docker container
 * images. The Container Analysis API is an implementation of the [Grafeas](grafeas.io) API.
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
 * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
 *   IamResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
 *   Policy policy = Policy.newBuilder().build();
 *   Policy response = containerAnalysisV1Beta1Client.setIamPolicy(resource, policy);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the containerAnalysisV1Beta1Client object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of
 * ContainerAnalysisV1Beta1Settings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * ContainerAnalysisV1Beta1Settings containerAnalysisV1Beta1Settings =
 *     ContainerAnalysisV1Beta1Settings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client =
 *     ContainerAnalysisV1Beta1Client.create(containerAnalysisV1Beta1Settings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ContainerAnalysisV1Beta1Settings containerAnalysisV1Beta1Settings =
 *     ContainerAnalysisV1Beta1Settings.newBuilder().setEndpoint(myEndpoint).build();
 * ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client =
 *     ContainerAnalysisV1Beta1Client.create(containerAnalysisV1Beta1Settings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ContainerAnalysisV1Beta1Client implements BackgroundResource {
  private final ContainerAnalysisV1Beta1Settings settings;
  private final ContainerAnalysisV1Beta1Stub stub;

  /** Constructs an instance of ContainerAnalysisV1Beta1Client with default settings. */
  public static final ContainerAnalysisV1Beta1Client create() throws IOException {
    return create(ContainerAnalysisV1Beta1Settings.newBuilder().build());
  }

  /**
   * Constructs an instance of ContainerAnalysisV1Beta1Client, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final ContainerAnalysisV1Beta1Client create(
      ContainerAnalysisV1Beta1Settings settings) throws IOException {
    return new ContainerAnalysisV1Beta1Client(settings);
  }

  /**
   * Constructs an instance of ContainerAnalysisV1Beta1Client, using the given stub for making
   * calls. This is for advanced usage - prefer to use ContainerAnalysisV1Beta1Settings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ContainerAnalysisV1Beta1Client create(ContainerAnalysisV1Beta1Stub stub) {
    return new ContainerAnalysisV1Beta1Client(stub);
  }

  /**
   * Constructs an instance of ContainerAnalysisV1Beta1Client, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ContainerAnalysisV1Beta1Client(ContainerAnalysisV1Beta1Settings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((ContainerAnalysisV1Beta1StubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ContainerAnalysisV1Beta1Client(ContainerAnalysisV1Beta1Stub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ContainerAnalysisV1Beta1Settings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ContainerAnalysisV1Beta1Stub getStub() {
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
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
   *   IamResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = containerAnalysisV1Beta1Client.setIamPolicy(resource, policy);
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
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
   *   IamResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = containerAnalysisV1Beta1Client.setIamPolicy(resource.toString(), policy);
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
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
   *   IamResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .setPolicy(policy)
   *     .build();
   *   Policy response = containerAnalysisV1Beta1Client.setIamPolicy(request);
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
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
   *   IamResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
   *   Policy policy = Policy.newBuilder().build();
   *   SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .setPolicy(policy)
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = containerAnalysisV1Beta1Client.setIamPolicyCallable().futureCall(request);
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
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
   *   IamResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
   *   Policy response = containerAnalysisV1Beta1Client.getIamPolicy(resource);
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
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
   *   IamResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
   *   Policy response = containerAnalysisV1Beta1Client.getIamPolicy(resource.toString());
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
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
   *   IamResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .build();
   *   Policy response = containerAnalysisV1Beta1Client.getIamPolicy(request);
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
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
   *   IamResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
   *   GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .build();
   *   ApiFuture&lt;Policy&gt; future = containerAnalysisV1Beta1Client.getIamPolicyCallable().futureCall(request);
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
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
   *   IamResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsResponse response = containerAnalysisV1Beta1Client.testIamPermissions(resource, permissions);
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
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
   *   IamResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsResponse response = containerAnalysisV1Beta1Client.testIamPermissions(resource.toString(), permissions);
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
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
   *   IamResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .addAllPermissions(permissions)
   *     .build();
   *   TestIamPermissionsResponse response = containerAnalysisV1Beta1Client.testIamPermissions(request);
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
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
   *   IamResourceName resource = NoteName.of("[PROJECT]", "[NOTE]");
   *   List&lt;String&gt; permissions = new ArrayList&lt;&gt;();
   *   TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
   *     .setResource(resource.toString())
   *     .addAllPermissions(permissions)
   *     .build();
   *   ApiFuture&lt;TestIamPermissionsResponse&gt; future = containerAnalysisV1Beta1Client.testIamPermissionsCallable().futureCall(request);
   *   // Do something
   *   TestIamPermissionsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the specified scan configuration.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
   *   ScanConfigName name = ScanConfigName.of("[PROJECT]", "[SCAN_CONFIG]");
   *   ScanConfig response = containerAnalysisV1Beta1Client.getScanConfig(name);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the scan configuration in the form of
   *     `projects/[PROJECT_ID]/scanConfigs/[SCAN_CONFIG_ID]`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScanConfig getScanConfig(ScanConfigName name) {
    GetScanConfigRequest request =
        GetScanConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getScanConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the specified scan configuration.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
   *   ScanConfigName name = ScanConfigName.of("[PROJECT]", "[SCAN_CONFIG]");
   *   ScanConfig response = containerAnalysisV1Beta1Client.getScanConfig(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required. The name of the scan configuration in the form of
   *     `projects/[PROJECT_ID]/scanConfigs/[SCAN_CONFIG_ID]`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScanConfig getScanConfig(String name) {
    GetScanConfigRequest request = GetScanConfigRequest.newBuilder().setName(name).build();
    return getScanConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the specified scan configuration.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
   *   ScanConfigName name = ScanConfigName.of("[PROJECT]", "[SCAN_CONFIG]");
   *   GetScanConfigRequest request = GetScanConfigRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ScanConfig response = containerAnalysisV1Beta1Client.getScanConfig(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScanConfig getScanConfig(GetScanConfigRequest request) {
    return getScanConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets the specified scan configuration.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
   *   ScanConfigName name = ScanConfigName.of("[PROJECT]", "[SCAN_CONFIG]");
   *   GetScanConfigRequest request = GetScanConfigRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;ScanConfig&gt; future = containerAnalysisV1Beta1Client.getScanConfigCallable().futureCall(request);
   *   // Do something
   *   ScanConfig response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetScanConfigRequest, ScanConfig> getScanConfigCallable() {
    return stub.getScanConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists scan configurations for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String filter = "";
   *   for (ScanConfig element : containerAnalysisV1Beta1Client.listScanConfigs(parent, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the project to list scan configurations for in the form of
   *     `projects/[PROJECT_ID]`.
   * @param filter Required. The filter expression.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScanConfigsPagedResponse listScanConfigs(ProjectName parent, String filter) {
    ListScanConfigsRequest request =
        ListScanConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFilter(filter)
            .build();
    return listScanConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists scan configurations for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String filter = "";
   *   for (ScanConfig element : containerAnalysisV1Beta1Client.listScanConfigs(parent.toString(), filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the project to list scan configurations for in the form of
   *     `projects/[PROJECT_ID]`.
   * @param filter Required. The filter expression.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScanConfigsPagedResponse listScanConfigs(String parent, String filter) {
    ListScanConfigsRequest request =
        ListScanConfigsRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return listScanConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists scan configurations for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ListScanConfigsRequest request = ListScanConfigsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (ScanConfig element : containerAnalysisV1Beta1Client.listScanConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListScanConfigsPagedResponse listScanConfigs(ListScanConfigsRequest request) {
    return listScanConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists scan configurations for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ListScanConfigsRequest request = ListScanConfigsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListScanConfigsPagedResponse&gt; future = containerAnalysisV1Beta1Client.listScanConfigsPagedCallable().futureCall(request);
   *   // Do something
   *   for (ScanConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListScanConfigsRequest, ListScanConfigsPagedResponse>
      listScanConfigsPagedCallable() {
    return stub.listScanConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists scan configurations for the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ListScanConfigsRequest request = ListScanConfigsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListScanConfigsResponse response = containerAnalysisV1Beta1Client.listScanConfigsCallable().call(request);
   *     for (ScanConfig element : response.getScanConfigsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListScanConfigsRequest, ListScanConfigsResponse>
      listScanConfigsCallable() {
    return stub.listScanConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified scan configuration.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
   *   ScanConfigName name = ScanConfigName.of("[PROJECT]", "[SCAN_CONFIG]");
   *   ScanConfig scanConfig = ScanConfig.newBuilder().build();
   *   ScanConfig response = containerAnalysisV1Beta1Client.updateScanConfig(name, scanConfig);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the scan configuration in the form of
   *     `projects/[PROJECT_ID]/scanConfigs/[SCAN_CONFIG_ID]`.
   * @param scanConfig Required. The updated scan configuration.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScanConfig updateScanConfig(ScanConfigName name, ScanConfig scanConfig) {
    UpdateScanConfigRequest request =
        UpdateScanConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setScanConfig(scanConfig)
            .build();
    return updateScanConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified scan configuration.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
   *   ScanConfigName name = ScanConfigName.of("[PROJECT]", "[SCAN_CONFIG]");
   *   ScanConfig scanConfig = ScanConfig.newBuilder().build();
   *   ScanConfig response = containerAnalysisV1Beta1Client.updateScanConfig(name.toString(), scanConfig);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the scan configuration in the form of
   *     `projects/[PROJECT_ID]/scanConfigs/[SCAN_CONFIG_ID]`.
   * @param scanConfig Required. The updated scan configuration.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScanConfig updateScanConfig(String name, ScanConfig scanConfig) {
    UpdateScanConfigRequest request =
        UpdateScanConfigRequest.newBuilder().setName(name).setScanConfig(scanConfig).build();
    return updateScanConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified scan configuration.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
   *   ScanConfigName name = ScanConfigName.of("[PROJECT]", "[SCAN_CONFIG]");
   *   ScanConfig scanConfig = ScanConfig.newBuilder().build();
   *   UpdateScanConfigRequest request = UpdateScanConfigRequest.newBuilder()
   *     .setName(name.toString())
   *     .setScanConfig(scanConfig)
   *     .build();
   *   ScanConfig response = containerAnalysisV1Beta1Client.updateScanConfig(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ScanConfig updateScanConfig(UpdateScanConfigRequest request) {
    return updateScanConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified scan configuration.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client = ContainerAnalysisV1Beta1Client.create()) {
   *   ScanConfigName name = ScanConfigName.of("[PROJECT]", "[SCAN_CONFIG]");
   *   ScanConfig scanConfig = ScanConfig.newBuilder().build();
   *   UpdateScanConfigRequest request = UpdateScanConfigRequest.newBuilder()
   *     .setName(name.toString())
   *     .setScanConfig(scanConfig)
   *     .build();
   *   ApiFuture&lt;ScanConfig&gt; future = containerAnalysisV1Beta1Client.updateScanConfigCallable().futureCall(request);
   *   // Do something
   *   ScanConfig response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateScanConfigRequest, ScanConfig> updateScanConfigCallable() {
    return stub.updateScanConfigCallable();
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

  public static class ListScanConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListScanConfigsRequest,
          ListScanConfigsResponse,
          ScanConfig,
          ListScanConfigsPage,
          ListScanConfigsFixedSizeCollection> {

    public static ApiFuture<ListScanConfigsPagedResponse> createAsync(
        PageContext<ListScanConfigsRequest, ListScanConfigsResponse, ScanConfig> context,
        ApiFuture<ListScanConfigsResponse> futureResponse) {
      ApiFuture<ListScanConfigsPage> futurePage =
          ListScanConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListScanConfigsPage, ListScanConfigsPagedResponse>() {
            @Override
            public ListScanConfigsPagedResponse apply(ListScanConfigsPage input) {
              return new ListScanConfigsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListScanConfigsPagedResponse(ListScanConfigsPage page) {
      super(page, ListScanConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListScanConfigsPage
      extends AbstractPage<
          ListScanConfigsRequest, ListScanConfigsResponse, ScanConfig, ListScanConfigsPage> {

    private ListScanConfigsPage(
        PageContext<ListScanConfigsRequest, ListScanConfigsResponse, ScanConfig> context,
        ListScanConfigsResponse response) {
      super(context, response);
    }

    private static ListScanConfigsPage createEmptyPage() {
      return new ListScanConfigsPage(null, null);
    }

    @Override
    protected ListScanConfigsPage createPage(
        PageContext<ListScanConfigsRequest, ListScanConfigsResponse, ScanConfig> context,
        ListScanConfigsResponse response) {
      return new ListScanConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListScanConfigsPage> createPageAsync(
        PageContext<ListScanConfigsRequest, ListScanConfigsResponse, ScanConfig> context,
        ApiFuture<ListScanConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListScanConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListScanConfigsRequest,
          ListScanConfigsResponse,
          ScanConfig,
          ListScanConfigsPage,
          ListScanConfigsFixedSizeCollection> {

    private ListScanConfigsFixedSizeCollection(
        List<ListScanConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListScanConfigsFixedSizeCollection createEmptyCollection() {
      return new ListScanConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListScanConfigsFixedSizeCollection createCollection(
        List<ListScanConfigsPage> pages, int collectionSize) {
      return new ListScanConfigsFixedSizeCollection(pages, collectionSize);
    }
  }
}
