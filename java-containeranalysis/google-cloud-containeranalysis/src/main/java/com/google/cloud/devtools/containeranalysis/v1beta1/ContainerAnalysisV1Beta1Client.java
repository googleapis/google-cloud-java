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

package com.google.cloud.devtools.containeranalysis.v1beta1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.devtools.containeranalysis.v1beta1.stub.ContainerAnalysisV1Beta1Stub;
import com.google.cloud.devtools.containeranalysis.v1beta1.stub.ContainerAnalysisV1Beta1StubSettings;
import com.google.containeranalysis.v1beta1.ExportSBOMRequest;
import com.google.containeranalysis.v1beta1.ExportSBOMResponse;
import com.google.containeranalysis.v1beta1.GeneratePackagesSummaryRequest;
import com.google.containeranalysis.v1beta1.PackagesSummaryResponse;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client =
 *     ContainerAnalysisV1Beta1Client.create()) {
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
 *   Policy response = containerAnalysisV1Beta1Client.setIamPolicy(resource, policy);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ContainerAnalysisV1Beta1Client object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy on the specified note or occurrence. Requires `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy` permission if the resource is a note or an occurrence, respectively.
 * <p>  The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> setIamPolicy(ResourceName resource, Policy policy)
 *           <li><p> setIamPolicy(String resource, Policy policy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a note or an occurrence resource. Requires `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy` permission if the resource is a note or occurrence, respectively.
 * <p>  The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getIamPolicy(ResourceName resource)
 *           <li><p> getIamPolicy(String resource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns the permissions that a caller has on the specified note or occurrence. Requires list permission on the project (for example, `containeranalysis.notes.list`).
 * <p>  The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> testIamPermissions(ResourceName resource, List&lt;String&gt; permissions)
 *           <li><p> testIamPermissions(String resource, List&lt;String&gt; permissions)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GeneratePackagesSummary</td>
 *      <td><p> Gets a summary of the packages within a given resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generatePackagesSummary(GeneratePackagesSummaryRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generatePackagesSummaryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportSBOM</td>
 *      <td><p> Generates an SBOM and other dependency information for the given resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportSBOM(ExportSBOMRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportSBOMCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
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
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ContainerAnalysisV1Beta1Settings containerAnalysisV1Beta1Settings =
 *     ContainerAnalysisV1Beta1Settings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client =
 *     ContainerAnalysisV1Beta1Client.create(containerAnalysisV1Beta1Settings);
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
 * ContainerAnalysisV1Beta1Settings containerAnalysisV1Beta1Settings =
 *     ContainerAnalysisV1Beta1Settings.newBuilder().setEndpoint(myEndpoint).build();
 * ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client =
 *     ContainerAnalysisV1Beta1Client.create(containerAnalysisV1Beta1Settings);
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
 * ContainerAnalysisV1Beta1Settings containerAnalysisV1Beta1Settings =
 *     ContainerAnalysisV1Beta1Settings.newHttpJsonBuilder().build();
 * ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client =
 *     ContainerAnalysisV1Beta1Client.create(containerAnalysisV1Beta1Settings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
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
   * calls. This is for advanced usage - prefer using create(ContainerAnalysisV1Beta1Settings).
   */
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

  protected ContainerAnalysisV1Beta1Client(ContainerAnalysisV1Beta1Stub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ContainerAnalysisV1Beta1Settings getSettings() {
    return settings;
  }

  public ContainerAnalysisV1Beta1Stub getStub() {
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
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client =
   *     ContainerAnalysisV1Beta1Client.create()) {
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
   *   Policy response = containerAnalysisV1Beta1Client.setIamPolicy(resource, policy);
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
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client =
   *     ContainerAnalysisV1Beta1Client.create()) {
   *   String resource =
   *       new ResourceName() {
   *         {@literal @}Override
   *         public Map<String, String> getFieldValuesMap() {
   *           Map<String, String> fieldValuesMap = new HashMap<>();
   *           fieldValuesMap.put("resource", "resource-341064690");
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
   *           return "resource-341064690";
   *         }
   *       }.toString();
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = containerAnalysisV1Beta1Client.setIamPolicy(resource, policy);
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
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client =
   *     ContainerAnalysisV1Beta1Client.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource("SetIamPolicyRequest1223629066".toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = containerAnalysisV1Beta1Client.setIamPolicy(request);
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
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client =
   *     ContainerAnalysisV1Beta1Client.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource("SetIamPolicyRequest1223629066".toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       containerAnalysisV1Beta1Client.setIamPolicyCallable().futureCall(request);
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
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client =
   *     ContainerAnalysisV1Beta1Client.create()) {
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
   *   Policy response = containerAnalysisV1Beta1Client.getIamPolicy(resource);
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
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client =
   *     ContainerAnalysisV1Beta1Client.create()) {
   *   String resource =
   *       new ResourceName() {
   *         {@literal @}Override
   *         public Map<String, String> getFieldValuesMap() {
   *           Map<String, String> fieldValuesMap = new HashMap<>();
   *           fieldValuesMap.put("resource", "resource-341064690");
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
   *           return "resource-341064690";
   *         }
   *       }.toString();
   *   Policy response = containerAnalysisV1Beta1Client.getIamPolicy(resource);
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
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client =
   *     ContainerAnalysisV1Beta1Client.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource("GetIamPolicyRequest-1527610370".toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = containerAnalysisV1Beta1Client.getIamPolicy(request);
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
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client =
   *     ContainerAnalysisV1Beta1Client.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource("GetIamPolicyRequest-1527610370".toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       containerAnalysisV1Beta1Client.getIamPolicyCallable().futureCall(request);
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
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client =
   *     ContainerAnalysisV1Beta1Client.create()) {
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
   *       containerAnalysisV1Beta1Client.testIamPermissions(resource, permissions);
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
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client =
   *     ContainerAnalysisV1Beta1Client.create()) {
   *   String resource =
   *       new ResourceName() {
   *         {@literal @}Override
   *         public Map<String, String> getFieldValuesMap() {
   *           Map<String, String> fieldValuesMap = new HashMap<>();
   *           fieldValuesMap.put("resource", "resource-341064690");
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
   *           return "resource-341064690";
   *         }
   *       }.toString();
   *   List<String> permissions = new ArrayList<>();
   *   TestIamPermissionsResponse response =
   *       containerAnalysisV1Beta1Client.testIamPermissions(resource, permissions);
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
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client =
   *     ContainerAnalysisV1Beta1Client.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource("TestIamPermissionsRequest942398222".toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response =
   *       containerAnalysisV1Beta1Client.testIamPermissions(request);
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
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client =
   *     ContainerAnalysisV1Beta1Client.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource("TestIamPermissionsRequest942398222".toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       containerAnalysisV1Beta1Client.testIamPermissionsCallable().futureCall(request);
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
   * Gets a summary of the packages within a given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client =
   *     ContainerAnalysisV1Beta1Client.create()) {
   *   GeneratePackagesSummaryRequest request =
   *       GeneratePackagesSummaryRequest.newBuilder().setName("name3373707").build();
   *   PackagesSummaryResponse response =
   *       containerAnalysisV1Beta1Client.generatePackagesSummary(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PackagesSummaryResponse generatePackagesSummary(
      GeneratePackagesSummaryRequest request) {
    return generatePackagesSummaryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a summary of the packages within a given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client =
   *     ContainerAnalysisV1Beta1Client.create()) {
   *   GeneratePackagesSummaryRequest request =
   *       GeneratePackagesSummaryRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<PackagesSummaryResponse> future =
   *       containerAnalysisV1Beta1Client.generatePackagesSummaryCallable().futureCall(request);
   *   // Do something.
   *   PackagesSummaryResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GeneratePackagesSummaryRequest, PackagesSummaryResponse>
      generatePackagesSummaryCallable() {
    return stub.generatePackagesSummaryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates an SBOM and other dependency information for the given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client =
   *     ContainerAnalysisV1Beta1Client.create()) {
   *   ExportSBOMRequest request = ExportSBOMRequest.newBuilder().setName("name3373707").build();
   *   ExportSBOMResponse response = containerAnalysisV1Beta1Client.exportSBOM(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExportSBOMResponse exportSBOM(ExportSBOMRequest request) {
    return exportSBOMCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates an SBOM and other dependency information for the given resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ContainerAnalysisV1Beta1Client containerAnalysisV1Beta1Client =
   *     ContainerAnalysisV1Beta1Client.create()) {
   *   ExportSBOMRequest request = ExportSBOMRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<ExportSBOMResponse> future =
   *       containerAnalysisV1Beta1Client.exportSBOMCallable().futureCall(request);
   *   // Do something.
   *   ExportSBOMResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportSBOMRequest, ExportSBOMResponse> exportSBOMCallable() {
    return stub.exportSBOMCallable();
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
