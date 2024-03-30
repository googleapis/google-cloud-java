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

package com.google.cloud.aiplatform.v1;

import com.google.api.HttpBody;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.stub.PredictionServiceStub;
import com.google.cloud.aiplatform.v1.stub.PredictionServiceStubSettings;
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
import com.google.protobuf.Value;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service for online predictions and explanations.
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
 * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
 *   EndpointName endpoint =
 *       EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
 *   List<Value> instances = new ArrayList<>();
 *   Value parameters = Value.newBuilder().setBoolValue(true).build();
 *   PredictResponse response = predictionServiceClient.predict(endpoint, instances, parameters);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PredictionServiceClient object to clean up resources
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
 *      <td><p> Predict</td>
 *      <td><p> Perform an online prediction.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> predict(PredictRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> predict(EndpointName endpoint, List&lt;Value&gt; instances, Value parameters)
 *           <li><p> predict(String endpoint, List&lt;Value&gt; instances, Value parameters)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> predictCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RawPredict</td>
 *      <td><p> Perform an online prediction with an arbitrary HTTP payload.
 * <p>  The response includes the following HTTP headers:
 * <ul>
 * <li>  `X-Vertex-AI-Endpoint-Id`: ID of the [Endpoint][google.cloud.aiplatform.v1.Endpoint] that served this prediction.
 * </ul>
 * <ul>
 * <li>  `X-Vertex-AI-Deployed-Model-Id`: ID of the Endpoint's [DeployedModel][google.cloud.aiplatform.v1.DeployedModel] that served this prediction.
 * </ul></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> rawPredict(RawPredictRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> rawPredict(EndpointName endpoint, HttpBody httpBody)
 *           <li><p> rawPredict(String endpoint, HttpBody httpBody)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> rawPredictCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StreamRawPredict</td>
 *      <td><p> Perform a streaming online prediction with an arbitrary HTTP payload.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> streamRawPredictCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DirectPredict</td>
 *      <td><p> Perform an unary online prediction request to a gRPC model server for Vertex first-party products and frameworks.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> directPredict(DirectPredictRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> directPredictCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DirectRawPredict</td>
 *      <td><p> Perform an unary online prediction request to a gRPC model server for custom containers.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> directRawPredict(DirectRawPredictRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> directRawPredictCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StreamDirectPredict</td>
 *      <td><p> Perform a streaming online prediction request to a gRPC model server for Vertex first-party products and frameworks.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> streamDirectPredictCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StreamDirectRawPredict</td>
 *      <td><p> Perform a streaming online prediction request to a gRPC model server for custom containers.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> streamDirectRawPredictCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StreamingPredict</td>
 *      <td><p> Perform a streaming online prediction request for Vertex first-party products and frameworks.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> streamingPredictCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ServerStreamingPredict</td>
 *      <td><p> Perform a server-side streaming online prediction request for Vertex LLM streaming.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> serverStreamingPredictCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StreamingRawPredict</td>
 *      <td><p> Perform a streaming online prediction request through gRPC.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> streamingRawPredictCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Explain</td>
 *      <td><p> Perform an online explanation.
 * <p>  If [deployed_model_id][google.cloud.aiplatform.v1.ExplainRequest.deployed_model_id] is specified, the corresponding DeployModel must have [explanation_spec][google.cloud.aiplatform.v1.DeployedModel.explanation_spec] populated. If [deployed_model_id][google.cloud.aiplatform.v1.ExplainRequest.deployed_model_id] is not specified, all DeployedModels must have [explanation_spec][google.cloud.aiplatform.v1.DeployedModel.explanation_spec] populated.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> explain(ExplainRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> explain(EndpointName endpoint, List&lt;Value&gt; instances, Value parameters, String deployedModelId)
 *           <li><p> explain(String endpoint, List&lt;Value&gt; instances, Value parameters, String deployedModelId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> explainCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateContent</td>
 *      <td><p> Generate content with multimodal inputs.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateContent(GenerateContentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> generateContent(String model, List&lt;Content&gt; contents)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateContentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StreamGenerateContent</td>
 *      <td><p> Generate content with multimodal inputs with streaming support.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> streamGenerateContentCallable()
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
 * <p>This class can be customized by passing in a custom instance of PredictionServiceSettings to
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
 * PredictionServiceSettings predictionServiceSettings =
 *     PredictionServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PredictionServiceClient predictionServiceClient =
 *     PredictionServiceClient.create(predictionServiceSettings);
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
 * PredictionServiceSettings predictionServiceSettings =
 *     PredictionServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PredictionServiceClient predictionServiceClient =
 *     PredictionServiceClient.create(predictionServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class PredictionServiceClient implements BackgroundResource {
  private final PredictionServiceSettings settings;
  private final PredictionServiceStub stub;

  /** Constructs an instance of PredictionServiceClient with default settings. */
  public static final PredictionServiceClient create() throws IOException {
    return create(PredictionServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PredictionServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PredictionServiceClient create(PredictionServiceSettings settings)
      throws IOException {
    return new PredictionServiceClient(settings);
  }

  /**
   * Constructs an instance of PredictionServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(PredictionServiceSettings).
   */
  public static final PredictionServiceClient create(PredictionServiceStub stub) {
    return new PredictionServiceClient(stub);
  }

  /**
   * Constructs an instance of PredictionServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected PredictionServiceClient(PredictionServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PredictionServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected PredictionServiceClient(PredictionServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PredictionServiceSettings getSettings() {
    return settings;
  }

  public PredictionServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an online prediction.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   EndpointName endpoint =
   *       EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
   *   List<Value> instances = new ArrayList<>();
   *   Value parameters = Value.newBuilder().setBoolValue(true).build();
   *   PredictResponse response = predictionServiceClient.predict(endpoint, instances, parameters);
   * }
   * }</pre>
   *
   * @param endpoint Required. The name of the Endpoint requested to serve the prediction. Format:
   *     `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @param instances Required. The instances that are the input to the prediction call. A
   *     DeployedModel may have an upper limit on the number of instances it supports per request,
   *     and when it is exceeded the prediction call errors in case of AutoML Models, or, in case of
   *     customer created Models, the behaviour is as documented by that Model. The schema of any
   *     single instance may be specified via Endpoint's DeployedModels'
   *     [Model's][google.cloud.aiplatform.v1.DeployedModel.model]
   *     [PredictSchemata's][google.cloud.aiplatform.v1.Model.predict_schemata]
   *     [instance_schema_uri][google.cloud.aiplatform.v1.PredictSchemata.instance_schema_uri].
   * @param parameters The parameters that govern the prediction. The schema of the parameters may
   *     be specified via Endpoint's DeployedModels' [Model's
   *     ][google.cloud.aiplatform.v1.DeployedModel.model]
   *     [PredictSchemata's][google.cloud.aiplatform.v1.Model.predict_schemata]
   *     [parameters_schema_uri][google.cloud.aiplatform.v1.PredictSchemata.parameters_schema_uri].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PredictResponse predict(
      EndpointName endpoint, List<Value> instances, Value parameters) {
    PredictRequest request =
        PredictRequest.newBuilder()
            .setEndpoint(endpoint == null ? null : endpoint.toString())
            .addAllInstances(instances)
            .setParameters(parameters)
            .build();
    return predict(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an online prediction.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   String endpoint =
   *       EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *           .toString();
   *   List<Value> instances = new ArrayList<>();
   *   Value parameters = Value.newBuilder().setBoolValue(true).build();
   *   PredictResponse response = predictionServiceClient.predict(endpoint, instances, parameters);
   * }
   * }</pre>
   *
   * @param endpoint Required. The name of the Endpoint requested to serve the prediction. Format:
   *     `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @param instances Required. The instances that are the input to the prediction call. A
   *     DeployedModel may have an upper limit on the number of instances it supports per request,
   *     and when it is exceeded the prediction call errors in case of AutoML Models, or, in case of
   *     customer created Models, the behaviour is as documented by that Model. The schema of any
   *     single instance may be specified via Endpoint's DeployedModels'
   *     [Model's][google.cloud.aiplatform.v1.DeployedModel.model]
   *     [PredictSchemata's][google.cloud.aiplatform.v1.Model.predict_schemata]
   *     [instance_schema_uri][google.cloud.aiplatform.v1.PredictSchemata.instance_schema_uri].
   * @param parameters The parameters that govern the prediction. The schema of the parameters may
   *     be specified via Endpoint's DeployedModels' [Model's
   *     ][google.cloud.aiplatform.v1.DeployedModel.model]
   *     [PredictSchemata's][google.cloud.aiplatform.v1.Model.predict_schemata]
   *     [parameters_schema_uri][google.cloud.aiplatform.v1.PredictSchemata.parameters_schema_uri].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PredictResponse predict(String endpoint, List<Value> instances, Value parameters) {
    PredictRequest request =
        PredictRequest.newBuilder()
            .setEndpoint(endpoint)
            .addAllInstances(instances)
            .setParameters(parameters)
            .build();
    return predict(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an online prediction.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   PredictRequest request =
   *       PredictRequest.newBuilder()
   *           .setEndpoint(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllInstances(new ArrayList<Value>())
   *           .setParameters(Value.newBuilder().setBoolValue(true).build())
   *           .build();
   *   PredictResponse response = predictionServiceClient.predict(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PredictResponse predict(PredictRequest request) {
    return predictCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an online prediction.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   PredictRequest request =
   *       PredictRequest.newBuilder()
   *           .setEndpoint(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllInstances(new ArrayList<Value>())
   *           .setParameters(Value.newBuilder().setBoolValue(true).build())
   *           .build();
   *   ApiFuture<PredictResponse> future =
   *       predictionServiceClient.predictCallable().futureCall(request);
   *   // Do something.
   *   PredictResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PredictRequest, PredictResponse> predictCallable() {
    return stub.predictCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an online prediction with an arbitrary HTTP payload.
   *
   * <p>The response includes the following HTTP headers:
   *
   * <ul>
   *   <li>`X-Vertex-AI-Endpoint-Id`: ID of the [Endpoint][google.cloud.aiplatform.v1.Endpoint] that
   *       served this prediction.
   * </ul>
   *
   * <ul>
   *   <li>`X-Vertex-AI-Deployed-Model-Id`: ID of the Endpoint's
   *       [DeployedModel][google.cloud.aiplatform.v1.DeployedModel] that served this prediction.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   EndpointName endpoint =
   *       EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
   *   HttpBody httpBody = HttpBody.newBuilder().build();
   *   HttpBody response = predictionServiceClient.rawPredict(endpoint, httpBody);
   * }
   * }</pre>
   *
   * @param endpoint Required. The name of the Endpoint requested to serve the prediction. Format:
   *     `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @param httpBody The prediction input. Supports HTTP headers and arbitrary data payload.
   *     <p>A [DeployedModel][google.cloud.aiplatform.v1.DeployedModel] may have an upper limit on
   *     the number of instances it supports per request. When this limit it is exceeded for an
   *     AutoML model, the [RawPredict][google.cloud.aiplatform.v1.PredictionService.RawPredict]
   *     method returns an error. When this limit is exceeded for a custom-trained model, the
   *     behavior varies depending on the model.
   *     <p>You can specify the schema for each instance in the
   *     [predict_schemata.instance_schema_uri][google.cloud.aiplatform.v1.PredictSchemata.instance_schema_uri]
   *     field when you create a [Model][google.cloud.aiplatform.v1.Model]. This schema applies when
   *     you deploy the `Model` as a `DeployedModel` to an
   *     [Endpoint][google.cloud.aiplatform.v1.Endpoint] and use the `RawPredict` method.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpBody rawPredict(EndpointName endpoint, HttpBody httpBody) {
    RawPredictRequest request =
        RawPredictRequest.newBuilder()
            .setEndpoint(endpoint == null ? null : endpoint.toString())
            .setHttpBody(httpBody)
            .build();
    return rawPredict(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an online prediction with an arbitrary HTTP payload.
   *
   * <p>The response includes the following HTTP headers:
   *
   * <ul>
   *   <li>`X-Vertex-AI-Endpoint-Id`: ID of the [Endpoint][google.cloud.aiplatform.v1.Endpoint] that
   *       served this prediction.
   * </ul>
   *
   * <ul>
   *   <li>`X-Vertex-AI-Deployed-Model-Id`: ID of the Endpoint's
   *       [DeployedModel][google.cloud.aiplatform.v1.DeployedModel] that served this prediction.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   String endpoint =
   *       EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *           .toString();
   *   HttpBody httpBody = HttpBody.newBuilder().build();
   *   HttpBody response = predictionServiceClient.rawPredict(endpoint, httpBody);
   * }
   * }</pre>
   *
   * @param endpoint Required. The name of the Endpoint requested to serve the prediction. Format:
   *     `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @param httpBody The prediction input. Supports HTTP headers and arbitrary data payload.
   *     <p>A [DeployedModel][google.cloud.aiplatform.v1.DeployedModel] may have an upper limit on
   *     the number of instances it supports per request. When this limit it is exceeded for an
   *     AutoML model, the [RawPredict][google.cloud.aiplatform.v1.PredictionService.RawPredict]
   *     method returns an error. When this limit is exceeded for a custom-trained model, the
   *     behavior varies depending on the model.
   *     <p>You can specify the schema for each instance in the
   *     [predict_schemata.instance_schema_uri][google.cloud.aiplatform.v1.PredictSchemata.instance_schema_uri]
   *     field when you create a [Model][google.cloud.aiplatform.v1.Model]. This schema applies when
   *     you deploy the `Model` as a `DeployedModel` to an
   *     [Endpoint][google.cloud.aiplatform.v1.Endpoint] and use the `RawPredict` method.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpBody rawPredict(String endpoint, HttpBody httpBody) {
    RawPredictRequest request =
        RawPredictRequest.newBuilder().setEndpoint(endpoint).setHttpBody(httpBody).build();
    return rawPredict(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an online prediction with an arbitrary HTTP payload.
   *
   * <p>The response includes the following HTTP headers:
   *
   * <ul>
   *   <li>`X-Vertex-AI-Endpoint-Id`: ID of the [Endpoint][google.cloud.aiplatform.v1.Endpoint] that
   *       served this prediction.
   * </ul>
   *
   * <ul>
   *   <li>`X-Vertex-AI-Deployed-Model-Id`: ID of the Endpoint's
   *       [DeployedModel][google.cloud.aiplatform.v1.DeployedModel] that served this prediction.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   RawPredictRequest request =
   *       RawPredictRequest.newBuilder()
   *           .setEndpoint(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setHttpBody(HttpBody.newBuilder().build())
   *           .build();
   *   HttpBody response = predictionServiceClient.rawPredict(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpBody rawPredict(RawPredictRequest request) {
    return rawPredictCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an online prediction with an arbitrary HTTP payload.
   *
   * <p>The response includes the following HTTP headers:
   *
   * <ul>
   *   <li>`X-Vertex-AI-Endpoint-Id`: ID of the [Endpoint][google.cloud.aiplatform.v1.Endpoint] that
   *       served this prediction.
   * </ul>
   *
   * <ul>
   *   <li>`X-Vertex-AI-Deployed-Model-Id`: ID of the Endpoint's
   *       [DeployedModel][google.cloud.aiplatform.v1.DeployedModel] that served this prediction.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   RawPredictRequest request =
   *       RawPredictRequest.newBuilder()
   *           .setEndpoint(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setHttpBody(HttpBody.newBuilder().build())
   *           .build();
   *   ApiFuture<HttpBody> future = predictionServiceClient.rawPredictCallable().futureCall(request);
   *   // Do something.
   *   HttpBody response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RawPredictRequest, HttpBody> rawPredictCallable() {
    return stub.rawPredictCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform a streaming online prediction with an arbitrary HTTP payload.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   StreamRawPredictRequest request =
   *       StreamRawPredictRequest.newBuilder()
   *           .setEndpoint(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setHttpBody(HttpBody.newBuilder().build())
   *           .build();
   *   ServerStream<HttpBody> stream =
   *       predictionServiceClient.streamRawPredictCallable().call(request);
   *   for (HttpBody response : stream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final ServerStreamingCallable<StreamRawPredictRequest, HttpBody>
      streamRawPredictCallable() {
    return stub.streamRawPredictCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an unary online prediction request to a gRPC model server for Vertex first-party
   * products and frameworks.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   DirectPredictRequest request =
   *       DirectPredictRequest.newBuilder()
   *           .setEndpoint(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllInputs(new ArrayList<Tensor>())
   *           .setParameters(Tensor.newBuilder().build())
   *           .build();
   *   DirectPredictResponse response = predictionServiceClient.directPredict(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DirectPredictResponse directPredict(DirectPredictRequest request) {
    return directPredictCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an unary online prediction request to a gRPC model server for Vertex first-party
   * products and frameworks.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   DirectPredictRequest request =
   *       DirectPredictRequest.newBuilder()
   *           .setEndpoint(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllInputs(new ArrayList<Tensor>())
   *           .setParameters(Tensor.newBuilder().build())
   *           .build();
   *   ApiFuture<DirectPredictResponse> future =
   *       predictionServiceClient.directPredictCallable().futureCall(request);
   *   // Do something.
   *   DirectPredictResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DirectPredictRequest, DirectPredictResponse> directPredictCallable() {
    return stub.directPredictCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an unary online prediction request to a gRPC model server for custom containers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   DirectRawPredictRequest request =
   *       DirectRawPredictRequest.newBuilder()
   *           .setEndpoint(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setMethodName("methodName-723163380")
   *           .setInput(ByteString.EMPTY)
   *           .build();
   *   DirectRawPredictResponse response = predictionServiceClient.directRawPredict(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DirectRawPredictResponse directRawPredict(DirectRawPredictRequest request) {
    return directRawPredictCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an unary online prediction request to a gRPC model server for custom containers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   DirectRawPredictRequest request =
   *       DirectRawPredictRequest.newBuilder()
   *           .setEndpoint(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setMethodName("methodName-723163380")
   *           .setInput(ByteString.EMPTY)
   *           .build();
   *   ApiFuture<DirectRawPredictResponse> future =
   *       predictionServiceClient.directRawPredictCallable().futureCall(request);
   *   // Do something.
   *   DirectRawPredictResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DirectRawPredictRequest, DirectRawPredictResponse>
      directRawPredictCallable() {
    return stub.directRawPredictCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform a streaming online prediction request to a gRPC model server for Vertex first-party
   * products and frameworks.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   BidiStream<StreamDirectPredictRequest, StreamDirectPredictResponse> bidiStream =
   *       predictionServiceClient.streamDirectPredictCallable().call();
   *   StreamDirectPredictRequest request =
   *       StreamDirectPredictRequest.newBuilder()
   *           .setEndpoint(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllInputs(new ArrayList<Tensor>())
   *           .setParameters(Tensor.newBuilder().build())
   *           .build();
   *   bidiStream.send(request);
   *   for (StreamDirectPredictResponse response : bidiStream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final BidiStreamingCallable<StreamDirectPredictRequest, StreamDirectPredictResponse>
      streamDirectPredictCallable() {
    return stub.streamDirectPredictCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform a streaming online prediction request to a gRPC model server for custom containers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   BidiStream<StreamDirectRawPredictRequest, StreamDirectRawPredictResponse> bidiStream =
   *       predictionServiceClient.streamDirectRawPredictCallable().call();
   *   StreamDirectRawPredictRequest request =
   *       StreamDirectRawPredictRequest.newBuilder()
   *           .setEndpoint(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setMethodName("methodName-723163380")
   *           .setInput(ByteString.EMPTY)
   *           .build();
   *   bidiStream.send(request);
   *   for (StreamDirectRawPredictResponse response : bidiStream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final BidiStreamingCallable<StreamDirectRawPredictRequest, StreamDirectRawPredictResponse>
      streamDirectRawPredictCallable() {
    return stub.streamDirectRawPredictCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform a streaming online prediction request for Vertex first-party products and frameworks.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   BidiStream<StreamingPredictRequest, StreamingPredictResponse> bidiStream =
   *       predictionServiceClient.streamingPredictCallable().call();
   *   StreamingPredictRequest request =
   *       StreamingPredictRequest.newBuilder()
   *           .setEndpoint(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllInputs(new ArrayList<Tensor>())
   *           .setParameters(Tensor.newBuilder().build())
   *           .build();
   *   bidiStream.send(request);
   *   for (StreamingPredictResponse response : bidiStream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final BidiStreamingCallable<StreamingPredictRequest, StreamingPredictResponse>
      streamingPredictCallable() {
    return stub.streamingPredictCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform a server-side streaming online prediction request for Vertex LLM streaming.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   StreamingPredictRequest request =
   *       StreamingPredictRequest.newBuilder()
   *           .setEndpoint(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllInputs(new ArrayList<Tensor>())
   *           .setParameters(Tensor.newBuilder().build())
   *           .build();
   *   ServerStream<StreamingPredictResponse> stream =
   *       predictionServiceClient.serverStreamingPredictCallable().call(request);
   *   for (StreamingPredictResponse response : stream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final ServerStreamingCallable<StreamingPredictRequest, StreamingPredictResponse>
      serverStreamingPredictCallable() {
    return stub.serverStreamingPredictCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform a streaming online prediction request through gRPC.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   BidiStream<StreamingRawPredictRequest, StreamingRawPredictResponse> bidiStream =
   *       predictionServiceClient.streamingRawPredictCallable().call();
   *   StreamingRawPredictRequest request =
   *       StreamingRawPredictRequest.newBuilder()
   *           .setEndpoint(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setMethodName("methodName-723163380")
   *           .setInput(ByteString.EMPTY)
   *           .build();
   *   bidiStream.send(request);
   *   for (StreamingRawPredictResponse response : bidiStream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final BidiStreamingCallable<StreamingRawPredictRequest, StreamingRawPredictResponse>
      streamingRawPredictCallable() {
    return stub.streamingRawPredictCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an online explanation.
   *
   * <p>If [deployed_model_id][google.cloud.aiplatform.v1.ExplainRequest.deployed_model_id] is
   * specified, the corresponding DeployModel must have
   * [explanation_spec][google.cloud.aiplatform.v1.DeployedModel.explanation_spec] populated. If
   * [deployed_model_id][google.cloud.aiplatform.v1.ExplainRequest.deployed_model_id] is not
   * specified, all DeployedModels must have
   * [explanation_spec][google.cloud.aiplatform.v1.DeployedModel.explanation_spec] populated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   EndpointName endpoint =
   *       EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
   *   List<Value> instances = new ArrayList<>();
   *   Value parameters = Value.newBuilder().setBoolValue(true).build();
   *   String deployedModelId = "deployedModelId-1817547906";
   *   ExplainResponse response =
   *       predictionServiceClient.explain(endpoint, instances, parameters, deployedModelId);
   * }
   * }</pre>
   *
   * @param endpoint Required. The name of the Endpoint requested to serve the explanation. Format:
   *     `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @param instances Required. The instances that are the input to the explanation call. A
   *     DeployedModel may have an upper limit on the number of instances it supports per request,
   *     and when it is exceeded the explanation call errors in case of AutoML Models, or, in case
   *     of customer created Models, the behaviour is as documented by that Model. The schema of any
   *     single instance may be specified via Endpoint's DeployedModels'
   *     [Model's][google.cloud.aiplatform.v1.DeployedModel.model]
   *     [PredictSchemata's][google.cloud.aiplatform.v1.Model.predict_schemata]
   *     [instance_schema_uri][google.cloud.aiplatform.v1.PredictSchemata.instance_schema_uri].
   * @param parameters The parameters that govern the prediction. The schema of the parameters may
   *     be specified via Endpoint's DeployedModels' [Model's
   *     ][google.cloud.aiplatform.v1.DeployedModel.model]
   *     [PredictSchemata's][google.cloud.aiplatform.v1.Model.predict_schemata]
   *     [parameters_schema_uri][google.cloud.aiplatform.v1.PredictSchemata.parameters_schema_uri].
   * @param deployedModelId If specified, this ExplainRequest will be served by the chosen
   *     DeployedModel, overriding
   *     [Endpoint.traffic_split][google.cloud.aiplatform.v1.Endpoint.traffic_split].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExplainResponse explain(
      EndpointName endpoint, List<Value> instances, Value parameters, String deployedModelId) {
    ExplainRequest request =
        ExplainRequest.newBuilder()
            .setEndpoint(endpoint == null ? null : endpoint.toString())
            .addAllInstances(instances)
            .setParameters(parameters)
            .setDeployedModelId(deployedModelId)
            .build();
    return explain(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an online explanation.
   *
   * <p>If [deployed_model_id][google.cloud.aiplatform.v1.ExplainRequest.deployed_model_id] is
   * specified, the corresponding DeployModel must have
   * [explanation_spec][google.cloud.aiplatform.v1.DeployedModel.explanation_spec] populated. If
   * [deployed_model_id][google.cloud.aiplatform.v1.ExplainRequest.deployed_model_id] is not
   * specified, all DeployedModels must have
   * [explanation_spec][google.cloud.aiplatform.v1.DeployedModel.explanation_spec] populated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   String endpoint =
   *       EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *           .toString();
   *   List<Value> instances = new ArrayList<>();
   *   Value parameters = Value.newBuilder().setBoolValue(true).build();
   *   String deployedModelId = "deployedModelId-1817547906";
   *   ExplainResponse response =
   *       predictionServiceClient.explain(endpoint, instances, parameters, deployedModelId);
   * }
   * }</pre>
   *
   * @param endpoint Required. The name of the Endpoint requested to serve the explanation. Format:
   *     `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @param instances Required. The instances that are the input to the explanation call. A
   *     DeployedModel may have an upper limit on the number of instances it supports per request,
   *     and when it is exceeded the explanation call errors in case of AutoML Models, or, in case
   *     of customer created Models, the behaviour is as documented by that Model. The schema of any
   *     single instance may be specified via Endpoint's DeployedModels'
   *     [Model's][google.cloud.aiplatform.v1.DeployedModel.model]
   *     [PredictSchemata's][google.cloud.aiplatform.v1.Model.predict_schemata]
   *     [instance_schema_uri][google.cloud.aiplatform.v1.PredictSchemata.instance_schema_uri].
   * @param parameters The parameters that govern the prediction. The schema of the parameters may
   *     be specified via Endpoint's DeployedModels' [Model's
   *     ][google.cloud.aiplatform.v1.DeployedModel.model]
   *     [PredictSchemata's][google.cloud.aiplatform.v1.Model.predict_schemata]
   *     [parameters_schema_uri][google.cloud.aiplatform.v1.PredictSchemata.parameters_schema_uri].
   * @param deployedModelId If specified, this ExplainRequest will be served by the chosen
   *     DeployedModel, overriding
   *     [Endpoint.traffic_split][google.cloud.aiplatform.v1.Endpoint.traffic_split].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExplainResponse explain(
      String endpoint, List<Value> instances, Value parameters, String deployedModelId) {
    ExplainRequest request =
        ExplainRequest.newBuilder()
            .setEndpoint(endpoint)
            .addAllInstances(instances)
            .setParameters(parameters)
            .setDeployedModelId(deployedModelId)
            .build();
    return explain(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an online explanation.
   *
   * <p>If [deployed_model_id][google.cloud.aiplatform.v1.ExplainRequest.deployed_model_id] is
   * specified, the corresponding DeployModel must have
   * [explanation_spec][google.cloud.aiplatform.v1.DeployedModel.explanation_spec] populated. If
   * [deployed_model_id][google.cloud.aiplatform.v1.ExplainRequest.deployed_model_id] is not
   * specified, all DeployedModels must have
   * [explanation_spec][google.cloud.aiplatform.v1.DeployedModel.explanation_spec] populated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   ExplainRequest request =
   *       ExplainRequest.newBuilder()
   *           .setEndpoint(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllInstances(new ArrayList<Value>())
   *           .setParameters(Value.newBuilder().setBoolValue(true).build())
   *           .setExplanationSpecOverride(ExplanationSpecOverride.newBuilder().build())
   *           .setDeployedModelId("deployedModelId-1817547906")
   *           .build();
   *   ExplainResponse response = predictionServiceClient.explain(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExplainResponse explain(ExplainRequest request) {
    return explainCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an online explanation.
   *
   * <p>If [deployed_model_id][google.cloud.aiplatform.v1.ExplainRequest.deployed_model_id] is
   * specified, the corresponding DeployModel must have
   * [explanation_spec][google.cloud.aiplatform.v1.DeployedModel.explanation_spec] populated. If
   * [deployed_model_id][google.cloud.aiplatform.v1.ExplainRequest.deployed_model_id] is not
   * specified, all DeployedModels must have
   * [explanation_spec][google.cloud.aiplatform.v1.DeployedModel.explanation_spec] populated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   ExplainRequest request =
   *       ExplainRequest.newBuilder()
   *           .setEndpoint(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllInstances(new ArrayList<Value>())
   *           .setParameters(Value.newBuilder().setBoolValue(true).build())
   *           .setExplanationSpecOverride(ExplanationSpecOverride.newBuilder().build())
   *           .setDeployedModelId("deployedModelId-1817547906")
   *           .build();
   *   ApiFuture<ExplainResponse> future =
   *       predictionServiceClient.explainCallable().futureCall(request);
   *   // Do something.
   *   ExplainResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExplainRequest, ExplainResponse> explainCallable() {
    return stub.explainCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate content with multimodal inputs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   String model = "model104069929";
   *   List<Content> contents = new ArrayList<>();
   *   GenerateContentResponse response = predictionServiceClient.generateContent(model, contents);
   * }
   * }</pre>
   *
   * @param model Required. The name of the publisher model requested to serve the prediction.
   *     Format: `projects/{project}/locations/{location}/publishers/&#42;/models/&#42;`
   * @param contents Required. The content of the current conversation with the model.
   *     <p>For single-turn queries, this is a single instance. For multi-turn queries, this is a
   *     repeated field that contains conversation history + latest request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateContentResponse generateContent(String model, List<Content> contents) {
    GenerateContentRequest request =
        GenerateContentRequest.newBuilder().setModel(model).addAllContents(contents).build();
    return generateContent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate content with multimodal inputs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   GenerateContentRequest request =
   *       GenerateContentRequest.newBuilder()
   *           .setModel("model104069929")
   *           .addAllContents(new ArrayList<Content>())
   *           .setSystemInstruction(Content.newBuilder().build())
   *           .addAllTools(new ArrayList<Tool>())
   *           .addAllSafetySettings(new ArrayList<SafetySetting>())
   *           .setGenerationConfig(GenerationConfig.newBuilder().build())
   *           .build();
   *   GenerateContentResponse response = predictionServiceClient.generateContent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateContentResponse generateContent(GenerateContentRequest request) {
    return generateContentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate content with multimodal inputs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   GenerateContentRequest request =
   *       GenerateContentRequest.newBuilder()
   *           .setModel("model104069929")
   *           .addAllContents(new ArrayList<Content>())
   *           .setSystemInstruction(Content.newBuilder().build())
   *           .addAllTools(new ArrayList<Tool>())
   *           .addAllSafetySettings(new ArrayList<SafetySetting>())
   *           .setGenerationConfig(GenerationConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<GenerateContentResponse> future =
   *       predictionServiceClient.generateContentCallable().futureCall(request);
   *   // Do something.
   *   GenerateContentResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateContentRequest, GenerateContentResponse>
      generateContentCallable() {
    return stub.generateContentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate content with multimodal inputs with streaming support.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   GenerateContentRequest request =
   *       GenerateContentRequest.newBuilder()
   *           .setModel("model104069929")
   *           .addAllContents(new ArrayList<Content>())
   *           .setSystemInstruction(Content.newBuilder().build())
   *           .addAllTools(new ArrayList<Tool>())
   *           .addAllSafetySettings(new ArrayList<SafetySetting>())
   *           .setGenerationConfig(GenerationConfig.newBuilder().build())
   *           .build();
   *   ServerStream<GenerateContentResponse> stream =
   *       predictionServiceClient.streamGenerateContentCallable().call(request);
   *   for (GenerateContentResponse response : stream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final ServerStreamingCallable<GenerateContentRequest, GenerateContentResponse>
      streamGenerateContentCallable() {
    return stub.streamGenerateContentCallable();
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
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : predictionServiceClient.listLocations(request).iterateAll()) {
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
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       predictionServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         predictionServiceClient.listLocationsCallable().call(request);
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
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = predictionServiceClient.getLocation(request);
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
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       predictionServiceClient.getLocationCallable().futureCall(request);
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
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = predictionServiceClient.setIamPolicy(request);
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
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = predictionServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = predictionServiceClient.getIamPolicy(request);
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
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = predictionServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = predictionServiceClient.testIamPermissions(request);
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
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       predictionServiceClient.testIamPermissionsCallable().futureCall(request);
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
