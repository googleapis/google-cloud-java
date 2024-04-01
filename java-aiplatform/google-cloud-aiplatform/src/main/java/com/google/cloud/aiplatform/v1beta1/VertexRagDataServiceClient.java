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

package com.google.cloud.aiplatform.v1beta1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.stub.VertexRagDataServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.VertexRagDataServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service for managing user data for RAG.
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
 * try (VertexRagDataServiceClient vertexRagDataServiceClient =
 *     VertexRagDataServiceClient.create()) {
 *   RagCorpusName name = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]");
 *   RagCorpus response = vertexRagDataServiceClient.getRagCorpus(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the VertexRagDataServiceClient object to clean up
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
 *      <td><p> CreateRagCorpus</td>
 *      <td><p> Creates a RagCorpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createRagCorpusAsync(CreateRagCorpusRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createRagCorpusAsync(LocationName parent, RagCorpus ragCorpus)
 *           <li><p> createRagCorpusAsync(String parent, RagCorpus ragCorpus)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createRagCorpusOperationCallable()
 *           <li><p> createRagCorpusCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRagCorpus</td>
 *      <td><p> Gets a RagCorpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRagCorpus(GetRagCorpusRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRagCorpus(RagCorpusName name)
 *           <li><p> getRagCorpus(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRagCorpusCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRagCorpora</td>
 *      <td><p> Lists RagCorpora in a Location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRagCorpora(ListRagCorporaRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRagCorpora(LocationName parent)
 *           <li><p> listRagCorpora(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRagCorporaPagedCallable()
 *           <li><p> listRagCorporaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteRagCorpus</td>
 *      <td><p> Deletes a RagCorpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteRagCorpusAsync(DeleteRagCorpusRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteRagCorpusAsync(RagCorpusName name)
 *           <li><p> deleteRagCorpusAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteRagCorpusOperationCallable()
 *           <li><p> deleteRagCorpusCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UploadRagFile</td>
 *      <td><p> Upload a file into a RagCorpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> uploadRagFile(UploadRagFileRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> uploadRagFile(RagCorpusName parent, RagFile ragFile, UploadRagFileConfig uploadRagFileConfig)
 *           <li><p> uploadRagFile(String parent, RagFile ragFile, UploadRagFileConfig uploadRagFileConfig)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> uploadRagFileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ImportRagFiles</td>
 *      <td><p> Import files from Google Cloud Storage or Google Drive into a RagCorpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> importRagFilesAsync(ImportRagFilesRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> importRagFilesAsync(RagCorpusName parent, ImportRagFilesConfig importRagFilesConfig)
 *           <li><p> importRagFilesAsync(String parent, ImportRagFilesConfig importRagFilesConfig)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> importRagFilesOperationCallable()
 *           <li><p> importRagFilesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRagFile</td>
 *      <td><p> Gets a RagFile.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRagFile(GetRagFileRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRagFile(RagFileName name)
 *           <li><p> getRagFile(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRagFileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRagFiles</td>
 *      <td><p> Lists RagFiles in a RagCorpus.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRagFiles(ListRagFilesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRagFiles(RagCorpusName parent)
 *           <li><p> listRagFiles(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRagFilesPagedCallable()
 *           <li><p> listRagFilesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteRagFile</td>
 *      <td><p> Deletes a RagFile.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteRagFileAsync(DeleteRagFileRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteRagFileAsync(RagFileName name)
 *           <li><p> deleteRagFileAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteRagFileOperationCallable()
 *           <li><p> deleteRagFileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLocationsPagedCallable()
 *           <li><p> listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLocationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy on the specified resource. Replacesany existing policy.
 * <p> Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a resource. Returns an empty policyif the resource exists and does not have a policy set.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns permissions that a caller has on the specified resource. If theresource does not exist, this will return an empty set ofpermissions, not a `NOT_FOUND` error.
 * <p> Note: This operation is designed to be used for buildingpermission-aware UIs and command-line tools, not for authorizationchecking. This operation may "fail open" without warning.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
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
 * <p>This class can be customized by passing in a custom instance of VertexRagDataServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VertexRagDataServiceSettings vertexRagDataServiceSettings =
 *     VertexRagDataServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * VertexRagDataServiceClient vertexRagDataServiceClient =
 *     VertexRagDataServiceClient.create(vertexRagDataServiceSettings);
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
 * VertexRagDataServiceSettings vertexRagDataServiceSettings =
 *     VertexRagDataServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * VertexRagDataServiceClient vertexRagDataServiceClient =
 *     VertexRagDataServiceClient.create(vertexRagDataServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class VertexRagDataServiceClient implements BackgroundResource {
  private final VertexRagDataServiceSettings settings;
  private final VertexRagDataServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of VertexRagDataServiceClient with default settings. */
  public static final VertexRagDataServiceClient create() throws IOException {
    return create(VertexRagDataServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of VertexRagDataServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final VertexRagDataServiceClient create(VertexRagDataServiceSettings settings)
      throws IOException {
    return new VertexRagDataServiceClient(settings);
  }

  /**
   * Constructs an instance of VertexRagDataServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(VertexRagDataServiceSettings).
   */
  public static final VertexRagDataServiceClient create(VertexRagDataServiceStub stub) {
    return new VertexRagDataServiceClient(stub);
  }

  /**
   * Constructs an instance of VertexRagDataServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected VertexRagDataServiceClient(VertexRagDataServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((VertexRagDataServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected VertexRagDataServiceClient(VertexRagDataServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final VertexRagDataServiceSettings getSettings() {
    return settings;
  }

  public VertexRagDataServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   RagCorpus ragCorpus = RagCorpus.newBuilder().build();
   *   RagCorpus response = vertexRagDataServiceClient.createRagCorpusAsync(parent, ragCorpus).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the RagCorpus in. Format:
   *     `projects/{project}/locations/{location}`
   * @param ragCorpus Required. The RagCorpus to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RagCorpus, CreateRagCorpusOperationMetadata> createRagCorpusAsync(
      LocationName parent, RagCorpus ragCorpus) {
    CreateRagCorpusRequest request =
        CreateRagCorpusRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRagCorpus(ragCorpus)
            .build();
    return createRagCorpusAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   RagCorpus ragCorpus = RagCorpus.newBuilder().build();
   *   RagCorpus response = vertexRagDataServiceClient.createRagCorpusAsync(parent, ragCorpus).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the RagCorpus in. Format:
   *     `projects/{project}/locations/{location}`
   * @param ragCorpus Required. The RagCorpus to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RagCorpus, CreateRagCorpusOperationMetadata> createRagCorpusAsync(
      String parent, RagCorpus ragCorpus) {
    CreateRagCorpusRequest request =
        CreateRagCorpusRequest.newBuilder().setParent(parent).setRagCorpus(ragCorpus).build();
    return createRagCorpusAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   CreateRagCorpusRequest request =
   *       CreateRagCorpusRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRagCorpus(RagCorpus.newBuilder().build())
   *           .build();
   *   RagCorpus response = vertexRagDataServiceClient.createRagCorpusAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RagCorpus, CreateRagCorpusOperationMetadata> createRagCorpusAsync(
      CreateRagCorpusRequest request) {
    return createRagCorpusOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   CreateRagCorpusRequest request =
   *       CreateRagCorpusRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRagCorpus(RagCorpus.newBuilder().build())
   *           .build();
   *   OperationFuture<RagCorpus, CreateRagCorpusOperationMetadata> future =
   *       vertexRagDataServiceClient.createRagCorpusOperationCallable().futureCall(request);
   *   // Do something.
   *   RagCorpus response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateRagCorpusRequest, RagCorpus, CreateRagCorpusOperationMetadata>
      createRagCorpusOperationCallable() {
    return stub.createRagCorpusOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   CreateRagCorpusRequest request =
   *       CreateRagCorpusRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRagCorpus(RagCorpus.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vertexRagDataServiceClient.createRagCorpusCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRagCorpusRequest, Operation> createRagCorpusCallable() {
    return stub.createRagCorpusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagCorpusName name = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]");
   *   RagCorpus response = vertexRagDataServiceClient.getRagCorpus(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagCorpus resource. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagCorpus getRagCorpus(RagCorpusName name) {
    GetRagCorpusRequest request =
        GetRagCorpusRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRagCorpus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String name = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString();
   *   RagCorpus response = vertexRagDataServiceClient.getRagCorpus(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagCorpus resource. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagCorpus getRagCorpus(String name) {
    GetRagCorpusRequest request = GetRagCorpusRequest.newBuilder().setName(name).build();
    return getRagCorpus(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   GetRagCorpusRequest request =
   *       GetRagCorpusRequest.newBuilder()
   *           .setName(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .build();
   *   RagCorpus response = vertexRagDataServiceClient.getRagCorpus(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagCorpus getRagCorpus(GetRagCorpusRequest request) {
    return getRagCorpusCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   GetRagCorpusRequest request =
   *       GetRagCorpusRequest.newBuilder()
   *           .setName(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .build();
   *   ApiFuture<RagCorpus> future =
   *       vertexRagDataServiceClient.getRagCorpusCallable().futureCall(request);
   *   // Do something.
   *   RagCorpus response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRagCorpusRequest, RagCorpus> getRagCorpusCallable() {
    return stub.getRagCorpusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagCorpora in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (RagCorpus element : vertexRagDataServiceClient.listRagCorpora(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location from which to list the RagCorpora.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRagCorporaPagedResponse listRagCorpora(LocationName parent) {
    ListRagCorporaRequest request =
        ListRagCorporaRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRagCorpora(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagCorpora in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (RagCorpus element : vertexRagDataServiceClient.listRagCorpora(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location from which to list the RagCorpora.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRagCorporaPagedResponse listRagCorpora(String parent) {
    ListRagCorporaRequest request = ListRagCorporaRequest.newBuilder().setParent(parent).build();
    return listRagCorpora(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagCorpora in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ListRagCorporaRequest request =
   *       ListRagCorporaRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (RagCorpus element : vertexRagDataServiceClient.listRagCorpora(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRagCorporaPagedResponse listRagCorpora(ListRagCorporaRequest request) {
    return listRagCorporaPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagCorpora in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ListRagCorporaRequest request =
   *       ListRagCorporaRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<RagCorpus> future =
   *       vertexRagDataServiceClient.listRagCorporaPagedCallable().futureCall(request);
   *   // Do something.
   *   for (RagCorpus element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRagCorporaRequest, ListRagCorporaPagedResponse>
      listRagCorporaPagedCallable() {
    return stub.listRagCorporaPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagCorpora in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ListRagCorporaRequest request =
   *       ListRagCorporaRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListRagCorporaResponse response =
   *         vertexRagDataServiceClient.listRagCorporaCallable().call(request);
   *     for (RagCorpus element : response.getRagCorporaList()) {
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
   * }</pre>
   */
  public final UnaryCallable<ListRagCorporaRequest, ListRagCorporaResponse>
      listRagCorporaCallable() {
    return stub.listRagCorporaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagCorpusName name = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]");
   *   vertexRagDataServiceClient.deleteRagCorpusAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagCorpus resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteRagCorpusAsync(
      RagCorpusName name) {
    DeleteRagCorpusRequest request =
        DeleteRagCorpusRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteRagCorpusAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String name = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString();
   *   vertexRagDataServiceClient.deleteRagCorpusAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagCorpus resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteRagCorpusAsync(String name) {
    DeleteRagCorpusRequest request = DeleteRagCorpusRequest.newBuilder().setName(name).build();
    return deleteRagCorpusAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   DeleteRagCorpusRequest request =
   *       DeleteRagCorpusRequest.newBuilder()
   *           .setName(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setForce(true)
   *           .build();
   *   vertexRagDataServiceClient.deleteRagCorpusAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteRagCorpusAsync(
      DeleteRagCorpusRequest request) {
    return deleteRagCorpusOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   DeleteRagCorpusRequest request =
   *       DeleteRagCorpusRequest.newBuilder()
   *           .setName(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       vertexRagDataServiceClient.deleteRagCorpusOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRagCorpusRequest, Empty, DeleteOperationMetadata>
      deleteRagCorpusOperationCallable() {
    return stub.deleteRagCorpusOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   DeleteRagCorpusRequest request =
   *       DeleteRagCorpusRequest.newBuilder()
   *           .setName(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       vertexRagDataServiceClient.deleteRagCorpusCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRagCorpusRequest, Operation> deleteRagCorpusCallable() {
    return stub.deleteRagCorpusCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upload a file into a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagCorpusName parent = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]");
   *   RagFile ragFile = RagFile.newBuilder().build();
   *   UploadRagFileConfig uploadRagFileConfig = UploadRagFileConfig.newBuilder().build();
   *   UploadRagFileResponse response =
   *       vertexRagDataServiceClient.uploadRagFile(parent, ragFile, uploadRagFileConfig);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the RagCorpus resource into which to upload the file.
   *     Format: `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}`
   * @param ragFile Required. The RagFile to upload.
   * @param uploadRagFileConfig Required. The config for the RagFiles to be uploaded into the
   *     RagCorpus.
   *     [VertexRagDataService.UploadRagFile][google.cloud.aiplatform.v1beta1.VertexRagDataService.UploadRagFile].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UploadRagFileResponse uploadRagFile(
      RagCorpusName parent, RagFile ragFile, UploadRagFileConfig uploadRagFileConfig) {
    UploadRagFileRequest request =
        UploadRagFileRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRagFile(ragFile)
            .setUploadRagFileConfig(uploadRagFileConfig)
            .build();
    return uploadRagFile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upload a file into a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String parent = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString();
   *   RagFile ragFile = RagFile.newBuilder().build();
   *   UploadRagFileConfig uploadRagFileConfig = UploadRagFileConfig.newBuilder().build();
   *   UploadRagFileResponse response =
   *       vertexRagDataServiceClient.uploadRagFile(parent, ragFile, uploadRagFileConfig);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the RagCorpus resource into which to upload the file.
   *     Format: `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}`
   * @param ragFile Required. The RagFile to upload.
   * @param uploadRagFileConfig Required. The config for the RagFiles to be uploaded into the
   *     RagCorpus.
   *     [VertexRagDataService.UploadRagFile][google.cloud.aiplatform.v1beta1.VertexRagDataService.UploadRagFile].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UploadRagFileResponse uploadRagFile(
      String parent, RagFile ragFile, UploadRagFileConfig uploadRagFileConfig) {
    UploadRagFileRequest request =
        UploadRagFileRequest.newBuilder()
            .setParent(parent)
            .setRagFile(ragFile)
            .setUploadRagFileConfig(uploadRagFileConfig)
            .build();
    return uploadRagFile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upload a file into a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   UploadRagFileRequest request =
   *       UploadRagFileRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setRagFile(RagFile.newBuilder().build())
   *           .setUploadRagFileConfig(UploadRagFileConfig.newBuilder().build())
   *           .build();
   *   UploadRagFileResponse response = vertexRagDataServiceClient.uploadRagFile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UploadRagFileResponse uploadRagFile(UploadRagFileRequest request) {
    return uploadRagFileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upload a file into a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   UploadRagFileRequest request =
   *       UploadRagFileRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setRagFile(RagFile.newBuilder().build())
   *           .setUploadRagFileConfig(UploadRagFileConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<UploadRagFileResponse> future =
   *       vertexRagDataServiceClient.uploadRagFileCallable().futureCall(request);
   *   // Do something.
   *   UploadRagFileResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UploadRagFileRequest, UploadRagFileResponse> uploadRagFileCallable() {
    return stub.uploadRagFileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import files from Google Cloud Storage or Google Drive into a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagCorpusName parent = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]");
   *   ImportRagFilesConfig importRagFilesConfig = ImportRagFilesConfig.newBuilder().build();
   *   ImportRagFilesResponse response =
   *       vertexRagDataServiceClient.importRagFilesAsync(parent, importRagFilesConfig).get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the RagCorpus resource into which to import files. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}`
   * @param importRagFilesConfig Required. The config for the RagFiles to be synced and imported
   *     into the RagCorpus.
   *     [VertexRagDataService.ImportRagFiles][google.cloud.aiplatform.v1beta1.VertexRagDataService.ImportRagFiles].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportRagFilesResponse, ImportRagFilesOperationMetadata>
      importRagFilesAsync(RagCorpusName parent, ImportRagFilesConfig importRagFilesConfig) {
    ImportRagFilesRequest request =
        ImportRagFilesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setImportRagFilesConfig(importRagFilesConfig)
            .build();
    return importRagFilesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import files from Google Cloud Storage or Google Drive into a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String parent = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString();
   *   ImportRagFilesConfig importRagFilesConfig = ImportRagFilesConfig.newBuilder().build();
   *   ImportRagFilesResponse response =
   *       vertexRagDataServiceClient.importRagFilesAsync(parent, importRagFilesConfig).get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the RagCorpus resource into which to import files. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}`
   * @param importRagFilesConfig Required. The config for the RagFiles to be synced and imported
   *     into the RagCorpus.
   *     [VertexRagDataService.ImportRagFiles][google.cloud.aiplatform.v1beta1.VertexRagDataService.ImportRagFiles].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportRagFilesResponse, ImportRagFilesOperationMetadata>
      importRagFilesAsync(String parent, ImportRagFilesConfig importRagFilesConfig) {
    ImportRagFilesRequest request =
        ImportRagFilesRequest.newBuilder()
            .setParent(parent)
            .setImportRagFilesConfig(importRagFilesConfig)
            .build();
    return importRagFilesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import files from Google Cloud Storage or Google Drive into a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ImportRagFilesRequest request =
   *       ImportRagFilesRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setImportRagFilesConfig(ImportRagFilesConfig.newBuilder().build())
   *           .build();
   *   ImportRagFilesResponse response =
   *       vertexRagDataServiceClient.importRagFilesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportRagFilesResponse, ImportRagFilesOperationMetadata>
      importRagFilesAsync(ImportRagFilesRequest request) {
    return importRagFilesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import files from Google Cloud Storage or Google Drive into a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ImportRagFilesRequest request =
   *       ImportRagFilesRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setImportRagFilesConfig(ImportRagFilesConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<ImportRagFilesResponse, ImportRagFilesOperationMetadata> future =
   *       vertexRagDataServiceClient.importRagFilesOperationCallable().futureCall(request);
   *   // Do something.
   *   ImportRagFilesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ImportRagFilesRequest, ImportRagFilesResponse, ImportRagFilesOperationMetadata>
      importRagFilesOperationCallable() {
    return stub.importRagFilesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import files from Google Cloud Storage or Google Drive into a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ImportRagFilesRequest request =
   *       ImportRagFilesRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setImportRagFilesConfig(ImportRagFilesConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vertexRagDataServiceClient.importRagFilesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportRagFilesRequest, Operation> importRagFilesCallable() {
    return stub.importRagFilesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagFile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagFileName name = RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]");
   *   RagFile response = vertexRagDataServiceClient.getRagFile(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagFile resource. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}/ragFiles/{rag_file}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagFile getRagFile(RagFileName name) {
    GetRagFileRequest request =
        GetRagFileRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRagFile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagFile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String name =
   *       RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]").toString();
   *   RagFile response = vertexRagDataServiceClient.getRagFile(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagFile resource. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}/ragFiles/{rag_file}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagFile getRagFile(String name) {
    GetRagFileRequest request = GetRagFileRequest.newBuilder().setName(name).build();
    return getRagFile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagFile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   GetRagFileRequest request =
   *       GetRagFileRequest.newBuilder()
   *           .setName(
   *               RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]")
   *                   .toString())
   *           .build();
   *   RagFile response = vertexRagDataServiceClient.getRagFile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RagFile getRagFile(GetRagFileRequest request) {
    return getRagFileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a RagFile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   GetRagFileRequest request =
   *       GetRagFileRequest.newBuilder()
   *           .setName(
   *               RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<RagFile> future =
   *       vertexRagDataServiceClient.getRagFileCallable().futureCall(request);
   *   // Do something.
   *   RagFile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRagFileRequest, RagFile> getRagFileCallable() {
    return stub.getRagFileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagFiles in a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagCorpusName parent = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]");
   *   for (RagFile element : vertexRagDataServiceClient.listRagFiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the RagCorpus from which to list the RagFiles.
   *     Format: `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRagFilesPagedResponse listRagFiles(RagCorpusName parent) {
    ListRagFilesRequest request =
        ListRagFilesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRagFiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagFiles in a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String parent = RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString();
   *   for (RagFile element : vertexRagDataServiceClient.listRagFiles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the RagCorpus from which to list the RagFiles.
   *     Format: `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRagFilesPagedResponse listRagFiles(String parent) {
    ListRagFilesRequest request = ListRagFilesRequest.newBuilder().setParent(parent).build();
    return listRagFiles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagFiles in a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ListRagFilesRequest request =
   *       ListRagFilesRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (RagFile element : vertexRagDataServiceClient.listRagFiles(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRagFilesPagedResponse listRagFiles(ListRagFilesRequest request) {
    return listRagFilesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagFiles in a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ListRagFilesRequest request =
   *       ListRagFilesRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<RagFile> future =
   *       vertexRagDataServiceClient.listRagFilesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (RagFile element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRagFilesRequest, ListRagFilesPagedResponse>
      listRagFilesPagedCallable() {
    return stub.listRagFilesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RagFiles in a RagCorpus.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ListRagFilesRequest request =
   *       ListRagFilesRequest.newBuilder()
   *           .setParent(RagCorpusName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListRagFilesResponse response =
   *         vertexRagDataServiceClient.listRagFilesCallable().call(request);
   *     for (RagFile element : response.getRagFilesList()) {
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
   * }</pre>
   */
  public final UnaryCallable<ListRagFilesRequest, ListRagFilesResponse> listRagFilesCallable() {
    return stub.listRagFilesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagFile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   RagFileName name = RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]");
   *   vertexRagDataServiceClient.deleteRagFileAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagFile resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}/ragFiles/{rag_file}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteRagFileAsync(
      RagFileName name) {
    DeleteRagFileRequest request =
        DeleteRagFileRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteRagFileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagFile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   String name =
   *       RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]").toString();
   *   vertexRagDataServiceClient.deleteRagFileAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the RagFile resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/ragCorpora/{rag_corpus}/ragFiles/{rag_file}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteRagFileAsync(String name) {
    DeleteRagFileRequest request = DeleteRagFileRequest.newBuilder().setName(name).build();
    return deleteRagFileAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagFile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   DeleteRagFileRequest request =
   *       DeleteRagFileRequest.newBuilder()
   *           .setName(
   *               RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]")
   *                   .toString())
   *           .build();
   *   vertexRagDataServiceClient.deleteRagFileAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteRagFileAsync(
      DeleteRagFileRequest request) {
    return deleteRagFileOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagFile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   DeleteRagFileRequest request =
   *       DeleteRagFileRequest.newBuilder()
   *           .setName(
   *               RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       vertexRagDataServiceClient.deleteRagFileOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRagFileRequest, Empty, DeleteOperationMetadata>
      deleteRagFileOperationCallable() {
    return stub.deleteRagFileOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a RagFile.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   DeleteRagFileRequest request =
   *       DeleteRagFileRequest.newBuilder()
   *           .setName(
   *               RagFileName.of("[PROJECT]", "[LOCATION]", "[RAG_CORPUS]", "[RAG_FILE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       vertexRagDataServiceClient.deleteRagFileCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRagFileRequest, Operation> deleteRagFileCallable() {
    return stub.deleteRagFileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : vertexRagDataServiceClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       vertexRagDataServiceClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         vertexRagDataServiceClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
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
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = vertexRagDataServiceClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       vertexRagDataServiceClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = vertexRagDataServiceClient.setIamPolicy(request);
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
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       vertexRagDataServiceClient.setIamPolicyCallable().futureCall(request);
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
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = vertexRagDataServiceClient.getIamPolicy(request);
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
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       vertexRagDataServiceClient.getIamPolicyCallable().futureCall(request);
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
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = vertexRagDataServiceClient.testIamPermissions(request);
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
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (VertexRagDataServiceClient vertexRagDataServiceClient =
   *     VertexRagDataServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       vertexRagDataServiceClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
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

  public static class ListRagCorporaPagedResponse
      extends AbstractPagedListResponse<
          ListRagCorporaRequest,
          ListRagCorporaResponse,
          RagCorpus,
          ListRagCorporaPage,
          ListRagCorporaFixedSizeCollection> {

    public static ApiFuture<ListRagCorporaPagedResponse> createAsync(
        PageContext<ListRagCorporaRequest, ListRagCorporaResponse, RagCorpus> context,
        ApiFuture<ListRagCorporaResponse> futureResponse) {
      ApiFuture<ListRagCorporaPage> futurePage =
          ListRagCorporaPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRagCorporaPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRagCorporaPagedResponse(ListRagCorporaPage page) {
      super(page, ListRagCorporaFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRagCorporaPage
      extends AbstractPage<
          ListRagCorporaRequest, ListRagCorporaResponse, RagCorpus, ListRagCorporaPage> {

    private ListRagCorporaPage(
        PageContext<ListRagCorporaRequest, ListRagCorporaResponse, RagCorpus> context,
        ListRagCorporaResponse response) {
      super(context, response);
    }

    private static ListRagCorporaPage createEmptyPage() {
      return new ListRagCorporaPage(null, null);
    }

    @Override
    protected ListRagCorporaPage createPage(
        PageContext<ListRagCorporaRequest, ListRagCorporaResponse, RagCorpus> context,
        ListRagCorporaResponse response) {
      return new ListRagCorporaPage(context, response);
    }

    @Override
    public ApiFuture<ListRagCorporaPage> createPageAsync(
        PageContext<ListRagCorporaRequest, ListRagCorporaResponse, RagCorpus> context,
        ApiFuture<ListRagCorporaResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRagCorporaFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRagCorporaRequest,
          ListRagCorporaResponse,
          RagCorpus,
          ListRagCorporaPage,
          ListRagCorporaFixedSizeCollection> {

    private ListRagCorporaFixedSizeCollection(List<ListRagCorporaPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRagCorporaFixedSizeCollection createEmptyCollection() {
      return new ListRagCorporaFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRagCorporaFixedSizeCollection createCollection(
        List<ListRagCorporaPage> pages, int collectionSize) {
      return new ListRagCorporaFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRagFilesPagedResponse
      extends AbstractPagedListResponse<
          ListRagFilesRequest,
          ListRagFilesResponse,
          RagFile,
          ListRagFilesPage,
          ListRagFilesFixedSizeCollection> {

    public static ApiFuture<ListRagFilesPagedResponse> createAsync(
        PageContext<ListRagFilesRequest, ListRagFilesResponse, RagFile> context,
        ApiFuture<ListRagFilesResponse> futureResponse) {
      ApiFuture<ListRagFilesPage> futurePage =
          ListRagFilesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRagFilesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRagFilesPagedResponse(ListRagFilesPage page) {
      super(page, ListRagFilesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRagFilesPage
      extends AbstractPage<ListRagFilesRequest, ListRagFilesResponse, RagFile, ListRagFilesPage> {

    private ListRagFilesPage(
        PageContext<ListRagFilesRequest, ListRagFilesResponse, RagFile> context,
        ListRagFilesResponse response) {
      super(context, response);
    }

    private static ListRagFilesPage createEmptyPage() {
      return new ListRagFilesPage(null, null);
    }

    @Override
    protected ListRagFilesPage createPage(
        PageContext<ListRagFilesRequest, ListRagFilesResponse, RagFile> context,
        ListRagFilesResponse response) {
      return new ListRagFilesPage(context, response);
    }

    @Override
    public ApiFuture<ListRagFilesPage> createPageAsync(
        PageContext<ListRagFilesRequest, ListRagFilesResponse, RagFile> context,
        ApiFuture<ListRagFilesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRagFilesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRagFilesRequest,
          ListRagFilesResponse,
          RagFile,
          ListRagFilesPage,
          ListRagFilesFixedSizeCollection> {

    private ListRagFilesFixedSizeCollection(List<ListRagFilesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRagFilesFixedSizeCollection createEmptyCollection() {
      return new ListRagFilesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRagFilesFixedSizeCollection createCollection(
        List<ListRagFilesPage> pages, int collectionSize) {
      return new ListRagFilesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
