/*
 * Copyright 2020 Google LLC
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

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.stub.PredictionServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.PredictionServiceStubSettings;
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
 * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
 *   EndpointName endpoint = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
 *   List<Value> instances = new ArrayList<>();
 *   Value parameters = Value.newBuilder().build();
 *   PredictResponse response = predictionServiceClient.predict(endpoint, instances, parameters);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PredictionServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of PredictionServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
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
 * PredictionServiceSettings predictionServiceSettings =
 *     PredictionServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PredictionServiceClient predictionServiceClient =
 *     PredictionServiceClient.create(predictionServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
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
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected PredictionServiceClient(PredictionServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PredictionServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   EndpointName endpoint = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
   *   List<Value> instances = new ArrayList<>();
   *   Value parameters = Value.newBuilder().build();
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
   *     [Model's][google.cloud.aiplatform.v1beta1.DeployedModel.model]
   *     [PredictSchemata's][google.cloud.aiplatform.v1beta1.Model.predict_schemata]
   *     [instance_schema_uri][google.cloud.aiplatform.v1beta1.PredictSchemata.instance_schema_uri].
   * @param parameters The parameters that govern the prediction. The schema of the parameters may
   *     be specified via Endpoint's DeployedModels' [Model's
   *     ][google.cloud.aiplatform.v1beta1.DeployedModel.model]
   *     [PredictSchemata's][google.cloud.aiplatform.v1beta1.Model.predict_schemata]
   *     [parameters_schema_uri][google.cloud.aiplatform.v1beta1.PredictSchemata.parameters_schema_uri].
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
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   String endpoint = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString();
   *   List<Value> instances = new ArrayList<>();
   *   Value parameters = Value.newBuilder().build();
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
   *     [Model's][google.cloud.aiplatform.v1beta1.DeployedModel.model]
   *     [PredictSchemata's][google.cloud.aiplatform.v1beta1.Model.predict_schemata]
   *     [instance_schema_uri][google.cloud.aiplatform.v1beta1.PredictSchemata.instance_schema_uri].
   * @param parameters The parameters that govern the prediction. The schema of the parameters may
   *     be specified via Endpoint's DeployedModels' [Model's
   *     ][google.cloud.aiplatform.v1beta1.DeployedModel.model]
   *     [PredictSchemata's][google.cloud.aiplatform.v1beta1.Model.predict_schemata]
   *     [parameters_schema_uri][google.cloud.aiplatform.v1beta1.PredictSchemata.parameters_schema_uri].
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
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   PredictRequest request =
   *       PredictRequest.newBuilder()
   *           .setEndpoint(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
   *           .addAllInstances(new ArrayList<Value>())
   *           .setParameters(Value.newBuilder().build())
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
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   PredictRequest request =
   *       PredictRequest.newBuilder()
   *           .setEndpoint(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
   *           .addAllInstances(new ArrayList<Value>())
   *           .setParameters(Value.newBuilder().build())
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
   * Perform an online explanation.
   *
   * <p>If [deployed_model_id][google.cloud.aiplatform.v1beta1.ExplainRequest.deployed_model_id] is
   * specified, the corresponding DeployModel must have
   * [explanation_spec][google.cloud.aiplatform.v1beta1.DeployedModel.explanation_spec] populated.
   * If [deployed_model_id][google.cloud.aiplatform.v1beta1.ExplainRequest.deployed_model_id] is not
   * specified, all DeployedModels must have
   * [explanation_spec][google.cloud.aiplatform.v1beta1.DeployedModel.explanation_spec] populated.
   * Only deployed AutoML tabular Models have explanation_spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   EndpointName endpoint = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
   *   List<Value> instances = new ArrayList<>();
   *   Value parameters = Value.newBuilder().build();
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
   *     [Model's][google.cloud.aiplatform.v1beta1.DeployedModel.model]
   *     [PredictSchemata's][google.cloud.aiplatform.v1beta1.Model.predict_schemata]
   *     [instance_schema_uri][google.cloud.aiplatform.v1beta1.PredictSchemata.instance_schema_uri].
   * @param parameters The parameters that govern the prediction. The schema of the parameters may
   *     be specified via Endpoint's DeployedModels' [Model's
   *     ][google.cloud.aiplatform.v1beta1.DeployedModel.model]
   *     [PredictSchemata's][google.cloud.aiplatform.v1beta1.Model.predict_schemata]
   *     [parameters_schema_uri][google.cloud.aiplatform.v1beta1.PredictSchemata.parameters_schema_uri].
   * @param deployedModelId If specified, this ExplainRequest will be served by the chosen
   *     DeployedModel, overriding
   *     [Endpoint.traffic_split][google.cloud.aiplatform.v1beta1.Endpoint.traffic_split].
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
   * <p>If [deployed_model_id][google.cloud.aiplatform.v1beta1.ExplainRequest.deployed_model_id] is
   * specified, the corresponding DeployModel must have
   * [explanation_spec][google.cloud.aiplatform.v1beta1.DeployedModel.explanation_spec] populated.
   * If [deployed_model_id][google.cloud.aiplatform.v1beta1.ExplainRequest.deployed_model_id] is not
   * specified, all DeployedModels must have
   * [explanation_spec][google.cloud.aiplatform.v1beta1.DeployedModel.explanation_spec] populated.
   * Only deployed AutoML tabular Models have explanation_spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   String endpoint = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString();
   *   List<Value> instances = new ArrayList<>();
   *   Value parameters = Value.newBuilder().build();
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
   *     [Model's][google.cloud.aiplatform.v1beta1.DeployedModel.model]
   *     [PredictSchemata's][google.cloud.aiplatform.v1beta1.Model.predict_schemata]
   *     [instance_schema_uri][google.cloud.aiplatform.v1beta1.PredictSchemata.instance_schema_uri].
   * @param parameters The parameters that govern the prediction. The schema of the parameters may
   *     be specified via Endpoint's DeployedModels' [Model's
   *     ][google.cloud.aiplatform.v1beta1.DeployedModel.model]
   *     [PredictSchemata's][google.cloud.aiplatform.v1beta1.Model.predict_schemata]
   *     [parameters_schema_uri][google.cloud.aiplatform.v1beta1.PredictSchemata.parameters_schema_uri].
   * @param deployedModelId If specified, this ExplainRequest will be served by the chosen
   *     DeployedModel, overriding
   *     [Endpoint.traffic_split][google.cloud.aiplatform.v1beta1.Endpoint.traffic_split].
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
   * <p>If [deployed_model_id][google.cloud.aiplatform.v1beta1.ExplainRequest.deployed_model_id] is
   * specified, the corresponding DeployModel must have
   * [explanation_spec][google.cloud.aiplatform.v1beta1.DeployedModel.explanation_spec] populated.
   * If [deployed_model_id][google.cloud.aiplatform.v1beta1.ExplainRequest.deployed_model_id] is not
   * specified, all DeployedModels must have
   * [explanation_spec][google.cloud.aiplatform.v1beta1.DeployedModel.explanation_spec] populated.
   * Only deployed AutoML tabular Models have explanation_spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   ExplainRequest request =
   *       ExplainRequest.newBuilder()
   *           .setEndpoint(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
   *           .addAllInstances(new ArrayList<Value>())
   *           .setParameters(Value.newBuilder().build())
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
   * <p>If [deployed_model_id][google.cloud.aiplatform.v1beta1.ExplainRequest.deployed_model_id] is
   * specified, the corresponding DeployModel must have
   * [explanation_spec][google.cloud.aiplatform.v1beta1.DeployedModel.explanation_spec] populated.
   * If [deployed_model_id][google.cloud.aiplatform.v1beta1.ExplainRequest.deployed_model_id] is not
   * specified, all DeployedModels must have
   * [explanation_spec][google.cloud.aiplatform.v1beta1.DeployedModel.explanation_spec] populated.
   * Only deployed AutoML tabular Models have explanation_spec.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   ExplainRequest request =
   *       ExplainRequest.newBuilder()
   *           .setEndpoint(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
   *           .addAllInstances(new ArrayList<Value>())
   *           .setParameters(Value.newBuilder().build())
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
