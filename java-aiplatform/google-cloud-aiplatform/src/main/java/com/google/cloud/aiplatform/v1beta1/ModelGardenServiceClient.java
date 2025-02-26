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
import com.google.cloud.aiplatform.v1beta1.stub.ModelGardenServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.ModelGardenServiceStubSettings;
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
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The interface of Model Garden Service.
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
 * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
 *   PublisherModelName name = PublisherModelName.of("[PUBLISHER]", "[MODEL]");
 *   PublisherModel response = modelGardenServiceClient.getPublisherModel(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ModelGardenServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetPublisherModel</td>
 *      <td><p> Gets a Model Garden publisher model.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPublisherModel(GetPublisherModelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPublisherModel(PublisherModelName name)
 *           <li><p> getPublisherModel(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPublisherModelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPublisherModels</td>
 *      <td><p> Lists publisher models in Model Garden.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPublisherModels(ListPublisherModelsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPublisherModels(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPublisherModelsPagedCallable()
 *           <li><p> listPublisherModelsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Deploy</td>
 *      <td><p> Deploys a model to a new endpoint.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deployAsync(DeployRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deployOperationCallable()
 *           <li><p> deployCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeployPublisherModel</td>
 *      <td><p> Deploys publisher models.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deployPublisherModelAsync(DeployPublisherModelRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deployPublisherModelOperationCallable()
 *           <li><p> deployPublisherModelCallable()
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
 * <p>This class can be customized by passing in a custom instance of ModelGardenServiceSettings to
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
 * ModelGardenServiceSettings modelGardenServiceSettings =
 *     ModelGardenServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ModelGardenServiceClient modelGardenServiceClient =
 *     ModelGardenServiceClient.create(modelGardenServiceSettings);
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
 * ModelGardenServiceSettings modelGardenServiceSettings =
 *     ModelGardenServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ModelGardenServiceClient modelGardenServiceClient =
 *     ModelGardenServiceClient.create(modelGardenServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ModelGardenServiceClient implements BackgroundResource {
  private final ModelGardenServiceSettings settings;
  private final ModelGardenServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of ModelGardenServiceClient with default settings. */
  public static final ModelGardenServiceClient create() throws IOException {
    return create(ModelGardenServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ModelGardenServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ModelGardenServiceClient create(ModelGardenServiceSettings settings)
      throws IOException {
    return new ModelGardenServiceClient(settings);
  }

  /**
   * Constructs an instance of ModelGardenServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(ModelGardenServiceSettings).
   */
  public static final ModelGardenServiceClient create(ModelGardenServiceStub stub) {
    return new ModelGardenServiceClient(stub);
  }

  /**
   * Constructs an instance of ModelGardenServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ModelGardenServiceClient(ModelGardenServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ModelGardenServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected ModelGardenServiceClient(ModelGardenServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final ModelGardenServiceSettings getSettings() {
    return settings;
  }

  public ModelGardenServiceStub getStub() {
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
   * Gets a Model Garden publisher model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
   *   PublisherModelName name = PublisherModelName.of("[PUBLISHER]", "[MODEL]");
   *   PublisherModel response = modelGardenServiceClient.getPublisherModel(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the PublisherModel resource. Format:
   *     `publishers/{publisher}/models/{publisher_model}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PublisherModel getPublisherModel(PublisherModelName name) {
    GetPublisherModelRequest request =
        GetPublisherModelRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getPublisherModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Model Garden publisher model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
   *   String name = PublisherModelName.of("[PUBLISHER]", "[MODEL]").toString();
   *   PublisherModel response = modelGardenServiceClient.getPublisherModel(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the PublisherModel resource. Format:
   *     `publishers/{publisher}/models/{publisher_model}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PublisherModel getPublisherModel(String name) {
    GetPublisherModelRequest request = GetPublisherModelRequest.newBuilder().setName(name).build();
    return getPublisherModel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Model Garden publisher model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
   *   GetPublisherModelRequest request =
   *       GetPublisherModelRequest.newBuilder()
   *           .setName(PublisherModelName.of("[PUBLISHER]", "[MODEL]").toString())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setView(PublisherModelView.forNumber(0))
   *           .setIsHuggingFaceModel(true)
   *           .setHuggingFaceToken("huggingFaceToken74062599")
   *           .build();
   *   PublisherModel response = modelGardenServiceClient.getPublisherModel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PublisherModel getPublisherModel(GetPublisherModelRequest request) {
    return getPublisherModelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Model Garden publisher model.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
   *   GetPublisherModelRequest request =
   *       GetPublisherModelRequest.newBuilder()
   *           .setName(PublisherModelName.of("[PUBLISHER]", "[MODEL]").toString())
   *           .setLanguageCode("languageCode-2092349083")
   *           .setView(PublisherModelView.forNumber(0))
   *           .setIsHuggingFaceModel(true)
   *           .setHuggingFaceToken("huggingFaceToken74062599")
   *           .build();
   *   ApiFuture<PublisherModel> future =
   *       modelGardenServiceClient.getPublisherModelCallable().futureCall(request);
   *   // Do something.
   *   PublisherModel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPublisherModelRequest, PublisherModel> getPublisherModelCallable() {
    return stub.getPublisherModelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists publisher models in Model Garden.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
   *   String parent = "parent-995424086";
   *   for (PublisherModel element :
   *       modelGardenServiceClient.listPublisherModels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the Publisher from which to list the PublisherModels.
   *     Format: `publishers/{publisher}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPublisherModelsPagedResponse listPublisherModels(String parent) {
    ListPublisherModelsRequest request =
        ListPublisherModelsRequest.newBuilder().setParent(parent).build();
    return listPublisherModels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists publisher models in Model Garden.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
   *   ListPublisherModelsRequest request =
   *       ListPublisherModelsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(PublisherModelView.forNumber(0))
   *           .setOrderBy("orderBy-1207110587")
   *           .setLanguageCode("languageCode-2092349083")
   *           .setListAllVersions(true)
   *           .build();
   *   for (PublisherModel element :
   *       modelGardenServiceClient.listPublisherModels(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPublisherModelsPagedResponse listPublisherModels(
      ListPublisherModelsRequest request) {
    return listPublisherModelsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists publisher models in Model Garden.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
   *   ListPublisherModelsRequest request =
   *       ListPublisherModelsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(PublisherModelView.forNumber(0))
   *           .setOrderBy("orderBy-1207110587")
   *           .setLanguageCode("languageCode-2092349083")
   *           .setListAllVersions(true)
   *           .build();
   *   ApiFuture<PublisherModel> future =
   *       modelGardenServiceClient.listPublisherModelsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PublisherModel element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPublisherModelsRequest, ListPublisherModelsPagedResponse>
      listPublisherModelsPagedCallable() {
    return stub.listPublisherModelsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists publisher models in Model Garden.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
   *   ListPublisherModelsRequest request =
   *       ListPublisherModelsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(PublisherModelView.forNumber(0))
   *           .setOrderBy("orderBy-1207110587")
   *           .setLanguageCode("languageCode-2092349083")
   *           .setListAllVersions(true)
   *           .build();
   *   while (true) {
   *     ListPublisherModelsResponse response =
   *         modelGardenServiceClient.listPublisherModelsCallable().call(request);
   *     for (PublisherModel element : response.getPublisherModelsList()) {
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
  public final UnaryCallable<ListPublisherModelsRequest, ListPublisherModelsResponse>
      listPublisherModelsCallable() {
    return stub.listPublisherModelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a model to a new endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
   *   DeployRequest request =
   *       DeployRequest.newBuilder()
   *           .setDestination(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setModelConfig(DeployRequest.ModelConfig.newBuilder().build())
   *           .setEndpointConfig(DeployRequest.EndpointConfig.newBuilder().build())
   *           .setDeployConfig(DeployRequest.DeployConfig.newBuilder().build())
   *           .build();
   *   DeployResponse response = modelGardenServiceClient.deployAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployResponse, DeployOperationMetadata> deployAsync(
      DeployRequest request) {
    return deployOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a model to a new endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
   *   DeployRequest request =
   *       DeployRequest.newBuilder()
   *           .setDestination(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setModelConfig(DeployRequest.ModelConfig.newBuilder().build())
   *           .setEndpointConfig(DeployRequest.EndpointConfig.newBuilder().build())
   *           .setDeployConfig(DeployRequest.DeployConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<DeployResponse, DeployOperationMetadata> future =
   *       modelGardenServiceClient.deployOperationCallable().futureCall(request);
   *   // Do something.
   *   DeployResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeployRequest, DeployResponse, DeployOperationMetadata>
      deployOperationCallable() {
    return stub.deployOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys a model to a new endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
   *   DeployRequest request =
   *       DeployRequest.newBuilder()
   *           .setDestination(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setModelConfig(DeployRequest.ModelConfig.newBuilder().build())
   *           .setEndpointConfig(DeployRequest.EndpointConfig.newBuilder().build())
   *           .setDeployConfig(DeployRequest.DeployConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = modelGardenServiceClient.deployCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeployRequest, Operation> deployCallable() {
    return stub.deployCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys publisher models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
   *   DeployPublisherModelRequest request =
   *       DeployPublisherModelRequest.newBuilder()
   *           .setModel("model104069929")
   *           .setDestination(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEndpointDisplayName("endpointDisplayName697270680")
   *           .setDedicatedResources(DedicatedResources.newBuilder().build())
   *           .setModelDisplayName("modelDisplayName1578770308")
   *           .setHuggingFaceAccessToken("huggingFaceAccessToken-159927933")
   *           .setAcceptEula(true)
   *           .build();
   *   DeployPublisherModelResponse response =
   *       modelGardenServiceClient.deployPublisherModelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DeployPublisherModelResponse, DeployPublisherModelOperationMetadata>
      deployPublisherModelAsync(DeployPublisherModelRequest request) {
    return deployPublisherModelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys publisher models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
   *   DeployPublisherModelRequest request =
   *       DeployPublisherModelRequest.newBuilder()
   *           .setModel("model104069929")
   *           .setDestination(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEndpointDisplayName("endpointDisplayName697270680")
   *           .setDedicatedResources(DedicatedResources.newBuilder().build())
   *           .setModelDisplayName("modelDisplayName1578770308")
   *           .setHuggingFaceAccessToken("huggingFaceAccessToken-159927933")
   *           .setAcceptEula(true)
   *           .build();
   *   OperationFuture<DeployPublisherModelResponse, DeployPublisherModelOperationMetadata> future =
   *       modelGardenServiceClient.deployPublisherModelOperationCallable().futureCall(request);
   *   // Do something.
   *   DeployPublisherModelResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeployPublisherModelRequest,
          DeployPublisherModelResponse,
          DeployPublisherModelOperationMetadata>
      deployPublisherModelOperationCallable() {
    return stub.deployPublisherModelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deploys publisher models.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
   *   DeployPublisherModelRequest request =
   *       DeployPublisherModelRequest.newBuilder()
   *           .setModel("model104069929")
   *           .setDestination(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEndpointDisplayName("endpointDisplayName697270680")
   *           .setDedicatedResources(DedicatedResources.newBuilder().build())
   *           .setModelDisplayName("modelDisplayName1578770308")
   *           .setHuggingFaceAccessToken("huggingFaceAccessToken-159927933")
   *           .setAcceptEula(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       modelGardenServiceClient.deployPublisherModelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeployPublisherModelRequest, Operation>
      deployPublisherModelCallable() {
    return stub.deployPublisherModelCallable();
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
   * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : modelGardenServiceClient.listLocations(request).iterateAll()) {
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
   * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       modelGardenServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         modelGardenServiceClient.listLocationsCallable().call(request);
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
   * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = modelGardenServiceClient.getLocation(request);
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
   * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       modelGardenServiceClient.getLocationCallable().futureCall(request);
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
   * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = modelGardenServiceClient.setIamPolicy(request);
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
   * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
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
   *       modelGardenServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = modelGardenServiceClient.getIamPolicy(request);
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
   * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       modelGardenServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = modelGardenServiceClient.testIamPermissions(request);
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
   * try (ModelGardenServiceClient modelGardenServiceClient = ModelGardenServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       modelGardenServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListPublisherModelsPagedResponse
      extends AbstractPagedListResponse<
          ListPublisherModelsRequest,
          ListPublisherModelsResponse,
          PublisherModel,
          ListPublisherModelsPage,
          ListPublisherModelsFixedSizeCollection> {

    public static ApiFuture<ListPublisherModelsPagedResponse> createAsync(
        PageContext<ListPublisherModelsRequest, ListPublisherModelsResponse, PublisherModel>
            context,
        ApiFuture<ListPublisherModelsResponse> futureResponse) {
      ApiFuture<ListPublisherModelsPage> futurePage =
          ListPublisherModelsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPublisherModelsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPublisherModelsPagedResponse(ListPublisherModelsPage page) {
      super(page, ListPublisherModelsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPublisherModelsPage
      extends AbstractPage<
          ListPublisherModelsRequest,
          ListPublisherModelsResponse,
          PublisherModel,
          ListPublisherModelsPage> {

    private ListPublisherModelsPage(
        PageContext<ListPublisherModelsRequest, ListPublisherModelsResponse, PublisherModel>
            context,
        ListPublisherModelsResponse response) {
      super(context, response);
    }

    private static ListPublisherModelsPage createEmptyPage() {
      return new ListPublisherModelsPage(null, null);
    }

    @Override
    protected ListPublisherModelsPage createPage(
        PageContext<ListPublisherModelsRequest, ListPublisherModelsResponse, PublisherModel>
            context,
        ListPublisherModelsResponse response) {
      return new ListPublisherModelsPage(context, response);
    }

    @Override
    public ApiFuture<ListPublisherModelsPage> createPageAsync(
        PageContext<ListPublisherModelsRequest, ListPublisherModelsResponse, PublisherModel>
            context,
        ApiFuture<ListPublisherModelsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPublisherModelsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPublisherModelsRequest,
          ListPublisherModelsResponse,
          PublisherModel,
          ListPublisherModelsPage,
          ListPublisherModelsFixedSizeCollection> {

    private ListPublisherModelsFixedSizeCollection(
        List<ListPublisherModelsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPublisherModelsFixedSizeCollection createEmptyCollection() {
      return new ListPublisherModelsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPublisherModelsFixedSizeCollection createCollection(
        List<ListPublisherModelsPage> pages, int collectionSize) {
      return new ListPublisherModelsFixedSizeCollection(pages, collectionSize);
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
