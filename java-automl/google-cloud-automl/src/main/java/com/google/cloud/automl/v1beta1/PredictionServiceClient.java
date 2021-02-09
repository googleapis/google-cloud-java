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

package com.google.cloud.automl.v1beta1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.automl.v1beta1.stub.PredictionServiceStub;
import com.google.cloud.automl.v1beta1.stub.PredictionServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: AutoML Prediction API.
 *
 * <p>On any input that is documented to expect a string parameter in snake_case or kebab-case,
 * either of those cases is accepted.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
 *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
 *   ExamplePayload payload = ExamplePayload.newBuilder().build();
 *   Map<String, String> params = new HashMap<>();
 *   PredictResponse response = predictionServiceClient.predict(name, payload, params);
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
@Generated("by gapic-generator-java")
public class PredictionServiceClient implements BackgroundResource {
  private final PredictionServiceSettings settings;
  private final PredictionServiceStub stub;
  private final OperationsClient operationsClient;

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
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected PredictionServiceClient(PredictionServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final PredictionServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public PredictionServiceStub getStub() {
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
   * Perform an online prediction. The prediction result will be directly returned in the response.
   * Available for following ML problems, and their expected request payloads:
   *
   * <ul>
   *   <li>Image Classification - Image in .JPEG, .GIF or .PNG format, image_bytes up to 30MB.
   *   <li>Image Object Detection - Image in .JPEG, .GIF or .PNG format, image_bytes up to 30MB.
   *   <li>Text Classification - TextSnippet, content up to 60,000 characters, UTF-8 encoded.
   *   <li>Text Extraction - TextSnippet, content up to 30,000 characters, UTF-8 NFC encoded.
   *   <li>Translation - TextSnippet, content up to 25,000 characters, UTF-8 encoded.
   *   <li>Tables - Row, with column values matching the columns of the model, up to 5MB. Not
   *       available for FORECASTING
   * </ul>
   *
   * <p>[prediction_type][google.cloud.automl.v1beta1.TablesModelMetadata.prediction_type].
   *
   * <ul>
   *   <li>Text Sentiment - TextSnippet, content up 500 characters, UTF-8 encoded.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   ExamplePayload payload = ExamplePayload.newBuilder().build();
   *   Map<String, String> params = new HashMap<>();
   *   PredictResponse response = predictionServiceClient.predict(name, payload, params);
   * }
   * }</pre>
   *
   * @param name Required. Name of the model requested to serve the prediction.
   * @param payload Required. Payload to perform a prediction on. The payload must match the problem
   *     type that the model was trained to solve.
   * @param params Additional domain-specific parameters, any string must be up to 25000 characters
   *     long.
   *     <ul>
   *       <li>For Image Classification:
   *     </ul>
   *     <p>`score_threshold` - (float) A value from 0.0 to 1.0. When the model makes predictions
   *     for an image, it will only produce results that have at least this confidence score. The
   *     default is 0.5.
   *     <p>&#42; For Image Object Detection: `score_threshold` - (float) When Model detects objects
   *     on the image, it will only produce bounding boxes which have at least this confidence
   *     score. Value in 0 to 1 range, default is 0.5. `max_bounding_box_count` - (int64) No more
   *     than this number of bounding boxes will be returned in the response. Default is 100, the
   *     requested value may be limited by server.
   *     <ul>
   *       <li>For Tables: feature_imp&lt;span&gt;ortan&lt;/span&gt;ce - (boolean) Whether feature
   *           importance should be populated in the returned TablesAnnotation. The default is
   *           false.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PredictResponse predict(
      ModelName name, ExamplePayload payload, Map<String, String> params) {
    PredictRequest request =
        PredictRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setPayload(payload)
            .putAllParams(params)
            .build();
    return predict(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an online prediction. The prediction result will be directly returned in the response.
   * Available for following ML problems, and their expected request payloads:
   *
   * <ul>
   *   <li>Image Classification - Image in .JPEG, .GIF or .PNG format, image_bytes up to 30MB.
   *   <li>Image Object Detection - Image in .JPEG, .GIF or .PNG format, image_bytes up to 30MB.
   *   <li>Text Classification - TextSnippet, content up to 60,000 characters, UTF-8 encoded.
   *   <li>Text Extraction - TextSnippet, content up to 30,000 characters, UTF-8 NFC encoded.
   *   <li>Translation - TextSnippet, content up to 25,000 characters, UTF-8 encoded.
   *   <li>Tables - Row, with column values matching the columns of the model, up to 5MB. Not
   *       available for FORECASTING
   * </ul>
   *
   * <p>[prediction_type][google.cloud.automl.v1beta1.TablesModelMetadata.prediction_type].
   *
   * <ul>
   *   <li>Text Sentiment - TextSnippet, content up 500 characters, UTF-8 encoded.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   String name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   ExamplePayload payload = ExamplePayload.newBuilder().build();
   *   Map<String, String> params = new HashMap<>();
   *   PredictResponse response = predictionServiceClient.predict(name, payload, params);
   * }
   * }</pre>
   *
   * @param name Required. Name of the model requested to serve the prediction.
   * @param payload Required. Payload to perform a prediction on. The payload must match the problem
   *     type that the model was trained to solve.
   * @param params Additional domain-specific parameters, any string must be up to 25000 characters
   *     long.
   *     <ul>
   *       <li>For Image Classification:
   *     </ul>
   *     <p>`score_threshold` - (float) A value from 0.0 to 1.0. When the model makes predictions
   *     for an image, it will only produce results that have at least this confidence score. The
   *     default is 0.5.
   *     <p>&#42; For Image Object Detection: `score_threshold` - (float) When Model detects objects
   *     on the image, it will only produce bounding boxes which have at least this confidence
   *     score. Value in 0 to 1 range, default is 0.5. `max_bounding_box_count` - (int64) No more
   *     than this number of bounding boxes will be returned in the response. Default is 100, the
   *     requested value may be limited by server.
   *     <ul>
   *       <li>For Tables: feature_imp&lt;span&gt;ortan&lt;/span&gt;ce - (boolean) Whether feature
   *           importance should be populated in the returned TablesAnnotation. The default is
   *           false.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PredictResponse predict(
      String name, ExamplePayload payload, Map<String, String> params) {
    PredictRequest request =
        PredictRequest.newBuilder().setName(name).setPayload(payload).putAllParams(params).build();
    return predict(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an online prediction. The prediction result will be directly returned in the response.
   * Available for following ML problems, and their expected request payloads:
   *
   * <ul>
   *   <li>Image Classification - Image in .JPEG, .GIF or .PNG format, image_bytes up to 30MB.
   *   <li>Image Object Detection - Image in .JPEG, .GIF or .PNG format, image_bytes up to 30MB.
   *   <li>Text Classification - TextSnippet, content up to 60,000 characters, UTF-8 encoded.
   *   <li>Text Extraction - TextSnippet, content up to 30,000 characters, UTF-8 NFC encoded.
   *   <li>Translation - TextSnippet, content up to 25,000 characters, UTF-8 encoded.
   *   <li>Tables - Row, with column values matching the columns of the model, up to 5MB. Not
   *       available for FORECASTING
   * </ul>
   *
   * <p>[prediction_type][google.cloud.automl.v1beta1.TablesModelMetadata.prediction_type].
   *
   * <ul>
   *   <li>Text Sentiment - TextSnippet, content up 500 characters, UTF-8 encoded.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   PredictRequest request =
   *       PredictRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setPayload(ExamplePayload.newBuilder().build())
   *           .putAllParams(new HashMap<String, String>())
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
   * Perform an online prediction. The prediction result will be directly returned in the response.
   * Available for following ML problems, and their expected request payloads:
   *
   * <ul>
   *   <li>Image Classification - Image in .JPEG, .GIF or .PNG format, image_bytes up to 30MB.
   *   <li>Image Object Detection - Image in .JPEG, .GIF or .PNG format, image_bytes up to 30MB.
   *   <li>Text Classification - TextSnippet, content up to 60,000 characters, UTF-8 encoded.
   *   <li>Text Extraction - TextSnippet, content up to 30,000 characters, UTF-8 NFC encoded.
   *   <li>Translation - TextSnippet, content up to 25,000 characters, UTF-8 encoded.
   *   <li>Tables - Row, with column values matching the columns of the model, up to 5MB. Not
   *       available for FORECASTING
   * </ul>
   *
   * <p>[prediction_type][google.cloud.automl.v1beta1.TablesModelMetadata.prediction_type].
   *
   * <ul>
   *   <li>Text Sentiment - TextSnippet, content up 500 characters, UTF-8 encoded.
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   PredictRequest request =
   *       PredictRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setPayload(ExamplePayload.newBuilder().build())
   *           .putAllParams(new HashMap<String, String>())
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
   * Perform a batch prediction. Unlike the online
   * [Predict][google.cloud.automl.v1beta1.PredictionService.Predict], batch prediction result won't
   * be immediately available in the response. Instead, a long running operation object is returned.
   * User can poll the operation result via
   * [GetOperation][google.longrunning.Operations.GetOperation] method. Once the operation is done,
   * [BatchPredictResult][google.cloud.automl.v1beta1.BatchPredictResult] is returned in the
   * [response][google.longrunning.Operation.response] field. Available for following ML problems:
   *
   * <ul>
   *   <li>Image Classification
   *   <li>Image Object Detection
   *   <li>Video Classification
   *   <li>Video Object Tracking &#42; Text Extraction
   *   <li>Tables
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   ModelName name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]");
   *   BatchPredictInputConfig inputConfig = BatchPredictInputConfig.newBuilder().build();
   *   BatchPredictOutputConfig outputConfig = BatchPredictOutputConfig.newBuilder().build();
   *   Map<String, String> params = new HashMap<>();
   *   BatchPredictResult response =
   *       predictionServiceClient.batchPredictAsync(name, inputConfig, outputConfig, params).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the model requested to serve the batch prediction.
   * @param inputConfig Required. The input configuration for batch prediction.
   * @param outputConfig Required. The Configuration specifying where output predictions should be
   *     written.
   * @param params Required. Additional domain-specific parameters for the predictions, any string
   *     must be up to 25000 characters long.
   *     <ul>
   *       <li>For Text Classification:
   *     </ul>
   *     <p>`score_threshold` - (float) A value from 0.0 to 1.0. When the model makes predictions
   *     for a text snippet, it will only produce results that have at least this confidence score.
   *     The default is 0.5.
   *     <ul>
   *       <li>For Image Classification:
   *     </ul>
   *     <p>`score_threshold` - (float) A value from 0.0 to 1.0. When the model makes predictions
   *     for an image, it will only produce results that have at least this confidence score. The
   *     default is 0.5.
   *     <ul>
   *       <li>For Image Object Detection:
   *     </ul>
   *     <p>`score_threshold` - (float) When Model detects objects on the image, it will only
   *     produce bounding boxes which have at least this confidence score. Value in 0 to 1 range,
   *     default is 0.5. `max_bounding_box_count` - (int64) No more than this number of bounding
   *     boxes will be produced per image. Default is 100, the requested value may be limited by
   *     server.
   *     <ul>
   *       <li>For Video Classification :
   *     </ul>
   *     <p>`score_threshold` - (float) A value from 0.0 to 1.0. When the model makes predictions
   *     for a video, it will only produce results that have at least this confidence score. The
   *     default is 0.5. `segment_classification` - (boolean) Set to true to request segment-level
   *     classification. AutoML Video Intelligence returns labels and their confidence scores for
   *     the entire segment of the video that user specified in the request configuration. The
   *     default is "true". `shot_classification` - (boolean) Set to true to request shot-level
   *     classification. AutoML Video Intelligence determines the boundaries for each camera shot in
   *     the entire segment of the video that user specified in the request configuration. AutoML
   *     Video Intelligence then returns labels and their confidence scores for each detected shot,
   *     along with the start and end time of the shot. WARNING: Model evaluation is not done for
   *     this classification type, the quality of it depends on training data, but there are no
   *     metrics provided to describe that quality. The default is "false".
   *     `1s_interval_classification` - (boolean) Set to true to request classification for a video
   *     at one-second intervals. AutoML Video Intelligence returns labels and their confidence
   *     scores for each second of the entire segment of the video that user specified in the
   *     request configuration. WARNING: Model evaluation is not done for this classification type,
   *     the quality of it depends on training data, but there are no metrics provided to describe
   *     that quality. The default is "false".
   *     <ul>
   *       <li>For Tables:
   *     </ul>
   *     <p>feature_imp&lt;span&gt;ortan&lt;/span&gt;ce - (boolean) Whether feature importance
   *     should be populated in the returned TablesAnnotations. The default is false.
   *     <ul>
   *       <li>For Video Object Tracking:
   *     </ul>
   *     <p>`score_threshold` - (float) When Model detects objects on video frames, it will only
   *     produce bounding boxes which have at least this confidence score. Value in 0 to 1 range,
   *     default is 0.5. `max_bounding_box_count` - (int64) No more than this number of bounding
   *     boxes will be returned per frame. Default is 100, the requested value may be limited by
   *     server. `min_bounding_box_size` - (float) Only bounding boxes with shortest edge at least
   *     that long as a relative value of video frame size will be returned. Value in 0 to 1 range.
   *     Default is 0.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchPredictResult, OperationMetadata> batchPredictAsync(
      ModelName name,
      BatchPredictInputConfig inputConfig,
      BatchPredictOutputConfig outputConfig,
      Map<String, String> params) {
    BatchPredictRequest request =
        BatchPredictRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setInputConfig(inputConfig)
            .setOutputConfig(outputConfig)
            .putAllParams(params)
            .build();
    return batchPredictAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform a batch prediction. Unlike the online
   * [Predict][google.cloud.automl.v1beta1.PredictionService.Predict], batch prediction result won't
   * be immediately available in the response. Instead, a long running operation object is returned.
   * User can poll the operation result via
   * [GetOperation][google.longrunning.Operations.GetOperation] method. Once the operation is done,
   * [BatchPredictResult][google.cloud.automl.v1beta1.BatchPredictResult] is returned in the
   * [response][google.longrunning.Operation.response] field. Available for following ML problems:
   *
   * <ul>
   *   <li>Image Classification
   *   <li>Image Object Detection
   *   <li>Video Classification
   *   <li>Video Object Tracking &#42; Text Extraction
   *   <li>Tables
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   String name = ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString();
   *   BatchPredictInputConfig inputConfig = BatchPredictInputConfig.newBuilder().build();
   *   BatchPredictOutputConfig outputConfig = BatchPredictOutputConfig.newBuilder().build();
   *   Map<String, String> params = new HashMap<>();
   *   BatchPredictResult response =
   *       predictionServiceClient.batchPredictAsync(name, inputConfig, outputConfig, params).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the model requested to serve the batch prediction.
   * @param inputConfig Required. The input configuration for batch prediction.
   * @param outputConfig Required. The Configuration specifying where output predictions should be
   *     written.
   * @param params Required. Additional domain-specific parameters for the predictions, any string
   *     must be up to 25000 characters long.
   *     <ul>
   *       <li>For Text Classification:
   *     </ul>
   *     <p>`score_threshold` - (float) A value from 0.0 to 1.0. When the model makes predictions
   *     for a text snippet, it will only produce results that have at least this confidence score.
   *     The default is 0.5.
   *     <ul>
   *       <li>For Image Classification:
   *     </ul>
   *     <p>`score_threshold` - (float) A value from 0.0 to 1.0. When the model makes predictions
   *     for an image, it will only produce results that have at least this confidence score. The
   *     default is 0.5.
   *     <ul>
   *       <li>For Image Object Detection:
   *     </ul>
   *     <p>`score_threshold` - (float) When Model detects objects on the image, it will only
   *     produce bounding boxes which have at least this confidence score. Value in 0 to 1 range,
   *     default is 0.5. `max_bounding_box_count` - (int64) No more than this number of bounding
   *     boxes will be produced per image. Default is 100, the requested value may be limited by
   *     server.
   *     <ul>
   *       <li>For Video Classification :
   *     </ul>
   *     <p>`score_threshold` - (float) A value from 0.0 to 1.0. When the model makes predictions
   *     for a video, it will only produce results that have at least this confidence score. The
   *     default is 0.5. `segment_classification` - (boolean) Set to true to request segment-level
   *     classification. AutoML Video Intelligence returns labels and their confidence scores for
   *     the entire segment of the video that user specified in the request configuration. The
   *     default is "true". `shot_classification` - (boolean) Set to true to request shot-level
   *     classification. AutoML Video Intelligence determines the boundaries for each camera shot in
   *     the entire segment of the video that user specified in the request configuration. AutoML
   *     Video Intelligence then returns labels and their confidence scores for each detected shot,
   *     along with the start and end time of the shot. WARNING: Model evaluation is not done for
   *     this classification type, the quality of it depends on training data, but there are no
   *     metrics provided to describe that quality. The default is "false".
   *     `1s_interval_classification` - (boolean) Set to true to request classification for a video
   *     at one-second intervals. AutoML Video Intelligence returns labels and their confidence
   *     scores for each second of the entire segment of the video that user specified in the
   *     request configuration. WARNING: Model evaluation is not done for this classification type,
   *     the quality of it depends on training data, but there are no metrics provided to describe
   *     that quality. The default is "false".
   *     <ul>
   *       <li>For Tables:
   *     </ul>
   *     <p>feature_imp&lt;span&gt;ortan&lt;/span&gt;ce - (boolean) Whether feature importance
   *     should be populated in the returned TablesAnnotations. The default is false.
   *     <ul>
   *       <li>For Video Object Tracking:
   *     </ul>
   *     <p>`score_threshold` - (float) When Model detects objects on video frames, it will only
   *     produce bounding boxes which have at least this confidence score. Value in 0 to 1 range,
   *     default is 0.5. `max_bounding_box_count` - (int64) No more than this number of bounding
   *     boxes will be returned per frame. Default is 100, the requested value may be limited by
   *     server. `min_bounding_box_size` - (float) Only bounding boxes with shortest edge at least
   *     that long as a relative value of video frame size will be returned. Value in 0 to 1 range.
   *     Default is 0.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchPredictResult, OperationMetadata> batchPredictAsync(
      String name,
      BatchPredictInputConfig inputConfig,
      BatchPredictOutputConfig outputConfig,
      Map<String, String> params) {
    BatchPredictRequest request =
        BatchPredictRequest.newBuilder()
            .setName(name)
            .setInputConfig(inputConfig)
            .setOutputConfig(outputConfig)
            .putAllParams(params)
            .build();
    return batchPredictAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform a batch prediction. Unlike the online
   * [Predict][google.cloud.automl.v1beta1.PredictionService.Predict], batch prediction result won't
   * be immediately available in the response. Instead, a long running operation object is returned.
   * User can poll the operation result via
   * [GetOperation][google.longrunning.Operations.GetOperation] method. Once the operation is done,
   * [BatchPredictResult][google.cloud.automl.v1beta1.BatchPredictResult] is returned in the
   * [response][google.longrunning.Operation.response] field. Available for following ML problems:
   *
   * <ul>
   *   <li>Image Classification
   *   <li>Image Object Detection
   *   <li>Video Classification
   *   <li>Video Object Tracking &#42; Text Extraction
   *   <li>Tables
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   BatchPredictRequest request =
   *       BatchPredictRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setInputConfig(BatchPredictInputConfig.newBuilder().build())
   *           .setOutputConfig(BatchPredictOutputConfig.newBuilder().build())
   *           .putAllParams(new HashMap<String, String>())
   *           .build();
   *   BatchPredictResult response = predictionServiceClient.batchPredictAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchPredictResult, OperationMetadata> batchPredictAsync(
      BatchPredictRequest request) {
    return batchPredictOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform a batch prediction. Unlike the online
   * [Predict][google.cloud.automl.v1beta1.PredictionService.Predict], batch prediction result won't
   * be immediately available in the response. Instead, a long running operation object is returned.
   * User can poll the operation result via
   * [GetOperation][google.longrunning.Operations.GetOperation] method. Once the operation is done,
   * [BatchPredictResult][google.cloud.automl.v1beta1.BatchPredictResult] is returned in the
   * [response][google.longrunning.Operation.response] field. Available for following ML problems:
   *
   * <ul>
   *   <li>Image Classification
   *   <li>Image Object Detection
   *   <li>Video Classification
   *   <li>Video Object Tracking &#42; Text Extraction
   *   <li>Tables
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   BatchPredictRequest request =
   *       BatchPredictRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setInputConfig(BatchPredictInputConfig.newBuilder().build())
   *           .setOutputConfig(BatchPredictOutputConfig.newBuilder().build())
   *           .putAllParams(new HashMap<String, String>())
   *           .build();
   *   OperationFuture<BatchPredictResult, OperationMetadata> future =
   *       predictionServiceClient.batchPredictOperationCallable().futureCall(request);
   *   // Do something.
   *   BatchPredictResult response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<BatchPredictRequest, BatchPredictResult, OperationMetadata>
      batchPredictOperationCallable() {
    return stub.batchPredictOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform a batch prediction. Unlike the online
   * [Predict][google.cloud.automl.v1beta1.PredictionService.Predict], batch prediction result won't
   * be immediately available in the response. Instead, a long running operation object is returned.
   * User can poll the operation result via
   * [GetOperation][google.longrunning.Operations.GetOperation] method. Once the operation is done,
   * [BatchPredictResult][google.cloud.automl.v1beta1.BatchPredictResult] is returned in the
   * [response][google.longrunning.Operation.response] field. Available for following ML problems:
   *
   * <ul>
   *   <li>Image Classification
   *   <li>Image Object Detection
   *   <li>Video Classification
   *   <li>Video Object Tracking &#42; Text Extraction
   *   <li>Tables
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
   *   BatchPredictRequest request =
   *       BatchPredictRequest.newBuilder()
   *           .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
   *           .setInputConfig(BatchPredictInputConfig.newBuilder().build())
   *           .setOutputConfig(BatchPredictOutputConfig.newBuilder().build())
   *           .putAllParams(new HashMap<String, String>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       predictionServiceClient.batchPredictCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchPredictRequest, Operation> batchPredictCallable() {
    return stub.batchPredictCallable();
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
