/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.devtools.containeranalysis.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.devtools.containeranalysis.v1.stub.ContainerAnalysisStub;
import com.google.cloud.devtools.containeranalysis.v1.stub.ContainerAnalysisStubSettings;
import com.google.containeranalysis.v1.GetVulnerabilityOccurrencesSummaryRequest;
import com.google.containeranalysis.v1.ProjectName;
import com.google.containeranalysis.v1.VulnerabilityOccurrencesSummary;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
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
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
 *   ResourceName resource =
 *       new ResourceName() {
 *         {@literal @}Override
 *         public Map<String, String> getFieldValuesMap() {
 *           Map<String, String> fieldValuesMap = new HashMap<>();
 *           fieldValuesMap.put("resource", "projects/project-8432/notes/note-8432");
 *           return fieldValuesMap;
 *         }
 *
 *         {@literal @}Override
 *         public String getFieldValue(String fieldName) {
 *           return getFieldValuesMap().get(fieldName);
 *         }
 *
 *         {@literal @}Override
 *         public String toString() {
 *           return "projects/project-8432/notes/note-8432";
 *         }
 *       };
 *   Policy policy = Policy.newBuilder().build();
 *   Policy response = containerAnalysisClient.setIamPolicy(resource, policy);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ContainerAnalysisClient object to clean up resources
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
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ContainerAnalysisSettings containerAnalysisSettings =
 *     ContainerAnalysisSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ContainerAnalysisClient containerAnalysisClient =
 *     ContainerAnalysisClient.create(containerAnalysisSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ContainerAnalysisSettings containerAnalysisSettings =
 *     ContainerAnalysisSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ContainerAnalysisClient containerAnalysisClient =
 *     ContainerAnalysisClient.create(containerAnalysisSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ContainerAnalysisSettings containerAnalysisSettings =
 *     ContainerAnalysisSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             ContainerAnalysisSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * ContainerAnalysisClient containerAnalysisClient =
 *     ContainerAnalysisClient.create(containerAnalysisSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
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
   * is for advanced usage - prefer using create(ContainerAnalysisSettings).
   */
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

  protected ContainerAnalysisClient(ContainerAnalysisStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ContainerAnalysisSettings getSettings() {
    return settings;
  }

  public ContainerAnalysisStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
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
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   ResourceName resource =
   *       new ResourceName() {
   *         {@literal @}Override
   *         public Map<String, String> getFieldValuesMap() {
   *           Map<String, String> fieldValuesMap = new HashMap<>();
   *           fieldValuesMap.put("resource", "projects/project-8432/notes/note-8432");
   *           return fieldValuesMap;
   *         }
   *
   *         {@literal @}Override
   *         public String getFieldValue(String fieldName) {
   *           return getFieldValuesMap().get(fieldName);
   *         }
   *
   *         {@literal @}Override
   *         public String toString() {
   *           return "projects/project-8432/notes/note-8432";
   *         }
   *       };
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = containerAnalysisClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(ResourceName resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setPolicy(policy)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
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
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String resource = ProjectName.of("[PROJECT]").toString();
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = containerAnalysisClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
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
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource("SetIamPolicyRequest1223629066".toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = containerAnalysisClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
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
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource("SetIamPolicyRequest1223629066".toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = containerAnalysisClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
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
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   ResourceName resource =
   *       new ResourceName() {
   *         {@literal @}Override
   *         public Map<String, String> getFieldValuesMap() {
   *           Map<String, String> fieldValuesMap = new HashMap<>();
   *           fieldValuesMap.put("resource", "projects/project-8432/notes/note-8432");
   *           return fieldValuesMap;
   *         }
   *
   *         {@literal @}Override
   *         public String getFieldValue(String fieldName) {
   *           return getFieldValuesMap().get(fieldName);
   *         }
   *
   *         {@literal @}Override
   *         public String toString() {
   *           return "projects/project-8432/notes/note-8432";
   *         }
   *       };
   *   Policy response = containerAnalysisClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(ResourceName resource) {
    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
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
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String resource = ProjectName.of("[PROJECT]").toString();
   *   Policy response = containerAnalysisClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
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
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource("GetIamPolicyRequest-1527610370".toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = containerAnalysisClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
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
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource("GetIamPolicyRequest-1527610370".toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = containerAnalysisClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the permissions that a caller has on the specified note or occurrence. Requires list
   * permission on the project (for example, `containeranalysis.notes.list`).
   *
   * <p>The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and
   * `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   ResourceName resource =
   *       new ResourceName() {
   *         {@literal @}Override
   *         public Map<String, String> getFieldValuesMap() {
   *           Map<String, String> fieldValuesMap = new HashMap<>();
   *           fieldValuesMap.put("resource", "projects/project-8432/notes/note-8432");
   *           return fieldValuesMap;
   *         }
   *
   *         {@literal @}Override
   *         public String getFieldValue(String fieldName) {
   *           return getFieldValuesMap().get(fieldName);
   *         }
   *
   *         {@literal @}Override
   *         public String toString() {
   *           return "projects/project-8432/notes/note-8432";
   *         }
   *       };
   *   List<String> permissions = new ArrayList<>();
   *   TestIamPermissionsResponse response =
   *       containerAnalysisClient.testIamPermissions(resource, permissions);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      ResourceName resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the permissions that a caller has on the specified note or occurrence. Requires list
   * permission on the project (for example, `containeranalysis.notes.list`).
   *
   * <p>The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and
   * `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String resource = ProjectName.of("[PROJECT]").toString();
   *   List<String> permissions = new ArrayList<>();
   *   TestIamPermissionsResponse response =
   *       containerAnalysisClient.testIamPermissions(resource, permissions);
   * }
   * }</pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the permissions that a caller has on the specified note or occurrence. Requires list
   * permission on the project (for example, `containeranalysis.notes.list`).
   *
   * <p>The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and
   * `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource("TestIamPermissionsRequest942398222".toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = containerAnalysisClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the permissions that a caller has on the specified note or occurrence. Requires list
   * permission on the project (for example, `containeranalysis.notes.list`).
   *
   * <p>The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and
   * `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource("TestIamPermissionsRequest942398222".toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       containerAnalysisClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a summary of the number and severity of occurrences.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   String filter = "filter-1274492040";
   *   VulnerabilityOccurrencesSummary response =
   *       containerAnalysisClient.getVulnerabilityOccurrencesSummary(parent, filter);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project to get a vulnerability summary for in the form
   *     of `projects/[PROJECT_ID]`.
   * @param filter The filter expression.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VulnerabilityOccurrencesSummary getVulnerabilityOccurrencesSummary(
      ProjectName parent, String filter) {
    GetVulnerabilityOccurrencesSummaryRequest request =
        GetVulnerabilityOccurrencesSummaryRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFilter(filter)
            .build();
    return getVulnerabilityOccurrencesSummary(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a summary of the number and severity of occurrences.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   String filter = "filter-1274492040";
   *   VulnerabilityOccurrencesSummary response =
   *       containerAnalysisClient.getVulnerabilityOccurrencesSummary(parent, filter);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project to get a vulnerability summary for in the form
   *     of `projects/[PROJECT_ID]`.
   * @param filter The filter expression.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VulnerabilityOccurrencesSummary getVulnerabilityOccurrencesSummary(
      String parent, String filter) {
    GetVulnerabilityOccurrencesSummaryRequest request =
        GetVulnerabilityOccurrencesSummaryRequest.newBuilder()
            .setParent(parent)
            .setFilter(filter)
            .build();
    return getVulnerabilityOccurrencesSummary(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a summary of the number and severity of occurrences.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   GetVulnerabilityOccurrencesSummaryRequest request =
   *       GetVulnerabilityOccurrencesSummaryRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setFilter("filter-1274492040")
   *           .build();
   *   VulnerabilityOccurrencesSummary response =
   *       containerAnalysisClient.getVulnerabilityOccurrencesSummary(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VulnerabilityOccurrencesSummary getVulnerabilityOccurrencesSummary(
      GetVulnerabilityOccurrencesSummaryRequest request) {
    return getVulnerabilityOccurrencesSummaryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a summary of the number and severity of occurrences.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContainerAnalysisClient containerAnalysisClient = ContainerAnalysisClient.create()) {
   *   GetVulnerabilityOccurrencesSummaryRequest request =
   *       GetVulnerabilityOccurrencesSummaryRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<VulnerabilityOccurrencesSummary> future =
   *       containerAnalysisClient.getVulnerabilityOccurrencesSummaryCallable().futureCall(request);
   *   // Do something.
   *   VulnerabilityOccurrencesSummary response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetVulnerabilityOccurrencesSummaryRequest, VulnerabilityOccurrencesSummary>
      getVulnerabilityOccurrencesSummaryCallable() {
    return stub.getVulnerabilityOccurrencesSummaryCallable();
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
