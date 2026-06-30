/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.gkerecommender.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkerecommender.v1.stub.GkeInferenceQuickstartStub;
import com.google.cloud.gkerecommender.v1.stub.GkeInferenceQuickstartStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: GKE Inference Quickstart (GIQ) service provides profiles with performance
 * metrics for popular models and model servers across multiple accelerators. These profiles help
 * generate optimized best practices for running inference on GKE.
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
 * try (GkeInferenceQuickstartClient gkeInferenceQuickstartClient =
 *     GkeInferenceQuickstartClient.create()) {
 *   GenerateOptimizedManifestRequest request =
 *       GenerateOptimizedManifestRequest.newBuilder()
 *           .setModelServerInfo(ModelServerInfo.newBuilder().build())
 *           .setAcceleratorType("acceleratorType-82462651")
 *           .setKubernetesNamespace("kubernetesNamespace-1862862667")
 *           .setPerformanceRequirements(PerformanceRequirements.newBuilder().build())
 *           .setStorageConfig(StorageConfig.newBuilder().build())
 *           .build();
 *   GenerateOptimizedManifestResponse response =
 *       gkeInferenceQuickstartClient.generateOptimizedManifest(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GkeInferenceQuickstartClient object to clean up
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
 *      <td><p> FetchModels</td>
 *      <td><p> Fetches available models. Open-source models follow the Huggingface Hub `owner/model_name` format.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchModels(FetchModelsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchModelsPagedCallable()
 *           <li><p> fetchModelsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchModelServers</td>
 *      <td><p> Fetches available model servers. Open-source model servers use simplified, lowercase names (e.g., `vllm`).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchModelServers(FetchModelServersRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchModelServersPagedCallable()
 *           <li><p> fetchModelServersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchModelServerVersions</td>
 *      <td><p> Fetches available model server versions. Open-source servers use their own versioning schemas (e.g., `vllm` uses semver like `v1.0.0`).
 * <p>  Some model servers have different versioning schemas depending on the accelerator. For example, `vllm` uses semver on GPUs, but returns nightly build tags on TPUs. All available versions will be returned when different schemas are present.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchModelServerVersions(FetchModelServerVersionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchModelServerVersionsPagedCallable()
 *           <li><p> fetchModelServerVersionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchProfiles</td>
 *      <td><p> Fetches available profiles. A profile contains performance metrics and cost information for a specific model server setup. Profiles can be filtered by parameters. If no filters are provided, all profiles are returned.
 * <p>  Profiles display a single value per performance metric based on the provided performance requirements. If no requirements are given, the metrics represent the inflection point. See [Run best practice inference with GKE Inference Quickstart recipes](https://cloud.google.com/kubernetes-engine/docs/how-to/machine-learning/inference/inference-quickstart#how) for details.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchProfiles(FetchProfilesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchProfilesPagedCallable()
 *           <li><p> fetchProfilesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateOptimizedManifest</td>
 *      <td><p> Generates an optimized deployment manifest for a given model and model server, based on the specified accelerator, performance targets, and configurations. See [Run best practice inference with GKE Inference Quickstart recipes](https://cloud.google.com/kubernetes-engine/docs/how-to/machine-learning/inference/inference-quickstart) for deployment details.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateOptimizedManifest(GenerateOptimizedManifestRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateOptimizedManifestCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchBenchmarkingData</td>
 *      <td><p> Fetches all of the benchmarking data available for a profile. Benchmarking data returns all of the performance metrics available for a given model server setup on a given instance type.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchBenchmarkingData(FetchBenchmarkingDataRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchBenchmarkingDataCallable()
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
 * <p>This class can be customized by passing in a custom instance of GkeInferenceQuickstartSettings
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
 * GkeInferenceQuickstartSettings gkeInferenceQuickstartSettings =
 *     GkeInferenceQuickstartSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GkeInferenceQuickstartClient gkeInferenceQuickstartClient =
 *     GkeInferenceQuickstartClient.create(gkeInferenceQuickstartSettings);
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
 * GkeInferenceQuickstartSettings gkeInferenceQuickstartSettings =
 *     GkeInferenceQuickstartSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GkeInferenceQuickstartClient gkeInferenceQuickstartClient =
 *     GkeInferenceQuickstartClient.create(gkeInferenceQuickstartSettings);
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
 * GkeInferenceQuickstartSettings gkeInferenceQuickstartSettings =
 *     GkeInferenceQuickstartSettings.newHttpJsonBuilder().build();
 * GkeInferenceQuickstartClient gkeInferenceQuickstartClient =
 *     GkeInferenceQuickstartClient.create(gkeInferenceQuickstartSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class GkeInferenceQuickstartClient implements BackgroundResource {
  private final GkeInferenceQuickstartSettings settings;
  private final GkeInferenceQuickstartStub stub;

  /** Constructs an instance of GkeInferenceQuickstartClient with default settings. */
  public static final GkeInferenceQuickstartClient create() throws IOException {
    return create(GkeInferenceQuickstartSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GkeInferenceQuickstartClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final GkeInferenceQuickstartClient create(GkeInferenceQuickstartSettings settings)
      throws IOException {
    return new GkeInferenceQuickstartClient(settings);
  }

  /**
   * Constructs an instance of GkeInferenceQuickstartClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(GkeInferenceQuickstartSettings).
   */
  public static final GkeInferenceQuickstartClient create(GkeInferenceQuickstartStub stub) {
    return new GkeInferenceQuickstartClient(stub);
  }

  /**
   * Constructs an instance of GkeInferenceQuickstartClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GkeInferenceQuickstartClient(GkeInferenceQuickstartSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((GkeInferenceQuickstartStubSettings) settings.getStubSettings()).createStub();
  }

  protected GkeInferenceQuickstartClient(GkeInferenceQuickstartStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GkeInferenceQuickstartSettings getSettings() {
    return settings;
  }

  public GkeInferenceQuickstartStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches available models. Open-source models follow the Huggingface Hub `owner/model_name`
   * format.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeInferenceQuickstartClient gkeInferenceQuickstartClient =
   *     GkeInferenceQuickstartClient.create()) {
   *   FetchModelsRequest request =
   *       FetchModelsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (String element : gkeInferenceQuickstartClient.fetchModels(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchModelsPagedResponse fetchModels(FetchModelsRequest request) {
    return fetchModelsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches available models. Open-source models follow the Huggingface Hub `owner/model_name`
   * format.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeInferenceQuickstartClient gkeInferenceQuickstartClient =
   *     GkeInferenceQuickstartClient.create()) {
   *   FetchModelsRequest request =
   *       FetchModelsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<String> future =
   *       gkeInferenceQuickstartClient.fetchModelsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (String element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchModelsRequest, FetchModelsPagedResponse>
      fetchModelsPagedCallable() {
    return stub.fetchModelsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches available models. Open-source models follow the Huggingface Hub `owner/model_name`
   * format.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeInferenceQuickstartClient gkeInferenceQuickstartClient =
   *     GkeInferenceQuickstartClient.create()) {
   *   FetchModelsRequest request =
   *       FetchModelsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     FetchModelsResponse response =
   *         gkeInferenceQuickstartClient.fetchModelsCallable().call(request);
   *     for (String element : response.getModelsList()) {
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
  public final UnaryCallable<FetchModelsRequest, FetchModelsResponse> fetchModelsCallable() {
    return stub.fetchModelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches available model servers. Open-source model servers use simplified, lowercase names
   * (e.g., `vllm`).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeInferenceQuickstartClient gkeInferenceQuickstartClient =
   *     GkeInferenceQuickstartClient.create()) {
   *   FetchModelServersRequest request =
   *       FetchModelServersRequest.newBuilder()
   *           .setModel("model104069929")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (String element : gkeInferenceQuickstartClient.fetchModelServers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchModelServersPagedResponse fetchModelServers(FetchModelServersRequest request) {
    return fetchModelServersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches available model servers. Open-source model servers use simplified, lowercase names
   * (e.g., `vllm`).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeInferenceQuickstartClient gkeInferenceQuickstartClient =
   *     GkeInferenceQuickstartClient.create()) {
   *   FetchModelServersRequest request =
   *       FetchModelServersRequest.newBuilder()
   *           .setModel("model104069929")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<String> future =
   *       gkeInferenceQuickstartClient.fetchModelServersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (String element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchModelServersRequest, FetchModelServersPagedResponse>
      fetchModelServersPagedCallable() {
    return stub.fetchModelServersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches available model servers. Open-source model servers use simplified, lowercase names
   * (e.g., `vllm`).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeInferenceQuickstartClient gkeInferenceQuickstartClient =
   *     GkeInferenceQuickstartClient.create()) {
   *   FetchModelServersRequest request =
   *       FetchModelServersRequest.newBuilder()
   *           .setModel("model104069929")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     FetchModelServersResponse response =
   *         gkeInferenceQuickstartClient.fetchModelServersCallable().call(request);
   *     for (String element : response.getModelServersList()) {
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
  public final UnaryCallable<FetchModelServersRequest, FetchModelServersResponse>
      fetchModelServersCallable() {
    return stub.fetchModelServersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches available model server versions. Open-source servers use their own versioning schemas
   * (e.g., `vllm` uses semver like `v1.0.0`).
   *
   * <p>Some model servers have different versioning schemas depending on the accelerator. For
   * example, `vllm` uses semver on GPUs, but returns nightly build tags on TPUs. All available
   * versions will be returned when different schemas are present.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeInferenceQuickstartClient gkeInferenceQuickstartClient =
   *     GkeInferenceQuickstartClient.create()) {
   *   FetchModelServerVersionsRequest request =
   *       FetchModelServerVersionsRequest.newBuilder()
   *           .setModel("model104069929")
   *           .setModelServer("modelServer475157452")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (String element :
   *       gkeInferenceQuickstartClient.fetchModelServerVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchModelServerVersionsPagedResponse fetchModelServerVersions(
      FetchModelServerVersionsRequest request) {
    return fetchModelServerVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches available model server versions. Open-source servers use their own versioning schemas
   * (e.g., `vllm` uses semver like `v1.0.0`).
   *
   * <p>Some model servers have different versioning schemas depending on the accelerator. For
   * example, `vllm` uses semver on GPUs, but returns nightly build tags on TPUs. All available
   * versions will be returned when different schemas are present.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeInferenceQuickstartClient gkeInferenceQuickstartClient =
   *     GkeInferenceQuickstartClient.create()) {
   *   FetchModelServerVersionsRequest request =
   *       FetchModelServerVersionsRequest.newBuilder()
   *           .setModel("model104069929")
   *           .setModelServer("modelServer475157452")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<String> future =
   *       gkeInferenceQuickstartClient.fetchModelServerVersionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (String element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchModelServerVersionsRequest, FetchModelServerVersionsPagedResponse>
      fetchModelServerVersionsPagedCallable() {
    return stub.fetchModelServerVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches available model server versions. Open-source servers use their own versioning schemas
   * (e.g., `vllm` uses semver like `v1.0.0`).
   *
   * <p>Some model servers have different versioning schemas depending on the accelerator. For
   * example, `vllm` uses semver on GPUs, but returns nightly build tags on TPUs. All available
   * versions will be returned when different schemas are present.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeInferenceQuickstartClient gkeInferenceQuickstartClient =
   *     GkeInferenceQuickstartClient.create()) {
   *   FetchModelServerVersionsRequest request =
   *       FetchModelServerVersionsRequest.newBuilder()
   *           .setModel("model104069929")
   *           .setModelServer("modelServer475157452")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     FetchModelServerVersionsResponse response =
   *         gkeInferenceQuickstartClient.fetchModelServerVersionsCallable().call(request);
   *     for (String element : response.getModelServerVersionsList()) {
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
  public final UnaryCallable<FetchModelServerVersionsRequest, FetchModelServerVersionsResponse>
      fetchModelServerVersionsCallable() {
    return stub.fetchModelServerVersionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches available profiles. A profile contains performance metrics and cost information for a
   * specific model server setup. Profiles can be filtered by parameters. If no filters are
   * provided, all profiles are returned.
   *
   * <p>Profiles display a single value per performance metric based on the provided performance
   * requirements. If no requirements are given, the metrics represent the inflection point. See
   * [Run best practice inference with GKE Inference Quickstart
   * recipes](https://cloud.google.com/kubernetes-engine/docs/how-to/machine-learning/inference/inference-quickstart#how)
   * for details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeInferenceQuickstartClient gkeInferenceQuickstartClient =
   *     GkeInferenceQuickstartClient.create()) {
   *   FetchProfilesRequest request =
   *       FetchProfilesRequest.newBuilder()
   *           .setModel("model104069929")
   *           .setModelServer("modelServer475157452")
   *           .setModelServerVersion("modelServerVersion77054828")
   *           .setPerformanceRequirements(PerformanceRequirements.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Profile element : gkeInferenceQuickstartClient.fetchProfiles(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchProfilesPagedResponse fetchProfiles(FetchProfilesRequest request) {
    return fetchProfilesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches available profiles. A profile contains performance metrics and cost information for a
   * specific model server setup. Profiles can be filtered by parameters. If no filters are
   * provided, all profiles are returned.
   *
   * <p>Profiles display a single value per performance metric based on the provided performance
   * requirements. If no requirements are given, the metrics represent the inflection point. See
   * [Run best practice inference with GKE Inference Quickstart
   * recipes](https://cloud.google.com/kubernetes-engine/docs/how-to/machine-learning/inference/inference-quickstart#how)
   * for details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeInferenceQuickstartClient gkeInferenceQuickstartClient =
   *     GkeInferenceQuickstartClient.create()) {
   *   FetchProfilesRequest request =
   *       FetchProfilesRequest.newBuilder()
   *           .setModel("model104069929")
   *           .setModelServer("modelServer475157452")
   *           .setModelServerVersion("modelServerVersion77054828")
   *           .setPerformanceRequirements(PerformanceRequirements.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Profile> future =
   *       gkeInferenceQuickstartClient.fetchProfilesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Profile element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchProfilesRequest, FetchProfilesPagedResponse>
      fetchProfilesPagedCallable() {
    return stub.fetchProfilesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches available profiles. A profile contains performance metrics and cost information for a
   * specific model server setup. Profiles can be filtered by parameters. If no filters are
   * provided, all profiles are returned.
   *
   * <p>Profiles display a single value per performance metric based on the provided performance
   * requirements. If no requirements are given, the metrics represent the inflection point. See
   * [Run best practice inference with GKE Inference Quickstart
   * recipes](https://cloud.google.com/kubernetes-engine/docs/how-to/machine-learning/inference/inference-quickstart#how)
   * for details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeInferenceQuickstartClient gkeInferenceQuickstartClient =
   *     GkeInferenceQuickstartClient.create()) {
   *   FetchProfilesRequest request =
   *       FetchProfilesRequest.newBuilder()
   *           .setModel("model104069929")
   *           .setModelServer("modelServer475157452")
   *           .setModelServerVersion("modelServerVersion77054828")
   *           .setPerformanceRequirements(PerformanceRequirements.newBuilder().build())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     FetchProfilesResponse response =
   *         gkeInferenceQuickstartClient.fetchProfilesCallable().call(request);
   *     for (Profile element : response.getProfileList()) {
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
  public final UnaryCallable<FetchProfilesRequest, FetchProfilesResponse> fetchProfilesCallable() {
    return stub.fetchProfilesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates an optimized deployment manifest for a given model and model server, based on the
   * specified accelerator, performance targets, and configurations. See [Run best practice
   * inference with GKE Inference Quickstart
   * recipes](https://cloud.google.com/kubernetes-engine/docs/how-to/machine-learning/inference/inference-quickstart)
   * for deployment details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeInferenceQuickstartClient gkeInferenceQuickstartClient =
   *     GkeInferenceQuickstartClient.create()) {
   *   GenerateOptimizedManifestRequest request =
   *       GenerateOptimizedManifestRequest.newBuilder()
   *           .setModelServerInfo(ModelServerInfo.newBuilder().build())
   *           .setAcceleratorType("acceleratorType-82462651")
   *           .setKubernetesNamespace("kubernetesNamespace-1862862667")
   *           .setPerformanceRequirements(PerformanceRequirements.newBuilder().build())
   *           .setStorageConfig(StorageConfig.newBuilder().build())
   *           .build();
   *   GenerateOptimizedManifestResponse response =
   *       gkeInferenceQuickstartClient.generateOptimizedManifest(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateOptimizedManifestResponse generateOptimizedManifest(
      GenerateOptimizedManifestRequest request) {
    return generateOptimizedManifestCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates an optimized deployment manifest for a given model and model server, based on the
   * specified accelerator, performance targets, and configurations. See [Run best practice
   * inference with GKE Inference Quickstart
   * recipes](https://cloud.google.com/kubernetes-engine/docs/how-to/machine-learning/inference/inference-quickstart)
   * for deployment details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeInferenceQuickstartClient gkeInferenceQuickstartClient =
   *     GkeInferenceQuickstartClient.create()) {
   *   GenerateOptimizedManifestRequest request =
   *       GenerateOptimizedManifestRequest.newBuilder()
   *           .setModelServerInfo(ModelServerInfo.newBuilder().build())
   *           .setAcceleratorType("acceleratorType-82462651")
   *           .setKubernetesNamespace("kubernetesNamespace-1862862667")
   *           .setPerformanceRequirements(PerformanceRequirements.newBuilder().build())
   *           .setStorageConfig(StorageConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<GenerateOptimizedManifestResponse> future =
   *       gkeInferenceQuickstartClient.generateOptimizedManifestCallable().futureCall(request);
   *   // Do something.
   *   GenerateOptimizedManifestResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateOptimizedManifestRequest, GenerateOptimizedManifestResponse>
      generateOptimizedManifestCallable() {
    return stub.generateOptimizedManifestCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches all of the benchmarking data available for a profile. Benchmarking data returns all of
   * the performance metrics available for a given model server setup on a given instance type.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeInferenceQuickstartClient gkeInferenceQuickstartClient =
   *     GkeInferenceQuickstartClient.create()) {
   *   FetchBenchmarkingDataRequest request =
   *       FetchBenchmarkingDataRequest.newBuilder()
   *           .setModelServerInfo(ModelServerInfo.newBuilder().build())
   *           .setInstanceType("instanceType-737655441")
   *           .setPricingModel("pricingModel1050892035")
   *           .build();
   *   FetchBenchmarkingDataResponse response =
   *       gkeInferenceQuickstartClient.fetchBenchmarkingData(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchBenchmarkingDataResponse fetchBenchmarkingData(
      FetchBenchmarkingDataRequest request) {
    return fetchBenchmarkingDataCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches all of the benchmarking data available for a profile. Benchmarking data returns all of
   * the performance metrics available for a given model server setup on a given instance type.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GkeInferenceQuickstartClient gkeInferenceQuickstartClient =
   *     GkeInferenceQuickstartClient.create()) {
   *   FetchBenchmarkingDataRequest request =
   *       FetchBenchmarkingDataRequest.newBuilder()
   *           .setModelServerInfo(ModelServerInfo.newBuilder().build())
   *           .setInstanceType("instanceType-737655441")
   *           .setPricingModel("pricingModel1050892035")
   *           .build();
   *   ApiFuture<FetchBenchmarkingDataResponse> future =
   *       gkeInferenceQuickstartClient.fetchBenchmarkingDataCallable().futureCall(request);
   *   // Do something.
   *   FetchBenchmarkingDataResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchBenchmarkingDataRequest, FetchBenchmarkingDataResponse>
      fetchBenchmarkingDataCallable() {
    return stub.fetchBenchmarkingDataCallable();
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

  public static class FetchModelsPagedResponse
      extends AbstractPagedListResponse<
          FetchModelsRequest,
          FetchModelsResponse,
          String,
          FetchModelsPage,
          FetchModelsFixedSizeCollection> {

    public static ApiFuture<FetchModelsPagedResponse> createAsync(
        PageContext<FetchModelsRequest, FetchModelsResponse, String> context,
        ApiFuture<FetchModelsResponse> futureResponse) {
      ApiFuture<FetchModelsPage> futurePage =
          FetchModelsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new FetchModelsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private FetchModelsPagedResponse(FetchModelsPage page) {
      super(page, FetchModelsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class FetchModelsPage
      extends AbstractPage<FetchModelsRequest, FetchModelsResponse, String, FetchModelsPage> {

    private FetchModelsPage(
        PageContext<FetchModelsRequest, FetchModelsResponse, String> context,
        FetchModelsResponse response) {
      super(context, response);
    }

    private static FetchModelsPage createEmptyPage() {
      return new FetchModelsPage(null, null);
    }

    @Override
    protected FetchModelsPage createPage(
        PageContext<FetchModelsRequest, FetchModelsResponse, String> context,
        FetchModelsResponse response) {
      return new FetchModelsPage(context, response);
    }

    @Override
    public ApiFuture<FetchModelsPage> createPageAsync(
        PageContext<FetchModelsRequest, FetchModelsResponse, String> context,
        ApiFuture<FetchModelsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class FetchModelsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          FetchModelsRequest,
          FetchModelsResponse,
          String,
          FetchModelsPage,
          FetchModelsFixedSizeCollection> {

    private FetchModelsFixedSizeCollection(List<FetchModelsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static FetchModelsFixedSizeCollection createEmptyCollection() {
      return new FetchModelsFixedSizeCollection(null, 0);
    }

    @Override
    protected FetchModelsFixedSizeCollection createCollection(
        List<FetchModelsPage> pages, int collectionSize) {
      return new FetchModelsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class FetchModelServersPagedResponse
      extends AbstractPagedListResponse<
          FetchModelServersRequest,
          FetchModelServersResponse,
          String,
          FetchModelServersPage,
          FetchModelServersFixedSizeCollection> {

    public static ApiFuture<FetchModelServersPagedResponse> createAsync(
        PageContext<FetchModelServersRequest, FetchModelServersResponse, String> context,
        ApiFuture<FetchModelServersResponse> futureResponse) {
      ApiFuture<FetchModelServersPage> futurePage =
          FetchModelServersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new FetchModelServersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private FetchModelServersPagedResponse(FetchModelServersPage page) {
      super(page, FetchModelServersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class FetchModelServersPage
      extends AbstractPage<
          FetchModelServersRequest, FetchModelServersResponse, String, FetchModelServersPage> {

    private FetchModelServersPage(
        PageContext<FetchModelServersRequest, FetchModelServersResponse, String> context,
        FetchModelServersResponse response) {
      super(context, response);
    }

    private static FetchModelServersPage createEmptyPage() {
      return new FetchModelServersPage(null, null);
    }

    @Override
    protected FetchModelServersPage createPage(
        PageContext<FetchModelServersRequest, FetchModelServersResponse, String> context,
        FetchModelServersResponse response) {
      return new FetchModelServersPage(context, response);
    }

    @Override
    public ApiFuture<FetchModelServersPage> createPageAsync(
        PageContext<FetchModelServersRequest, FetchModelServersResponse, String> context,
        ApiFuture<FetchModelServersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class FetchModelServersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          FetchModelServersRequest,
          FetchModelServersResponse,
          String,
          FetchModelServersPage,
          FetchModelServersFixedSizeCollection> {

    private FetchModelServersFixedSizeCollection(
        List<FetchModelServersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static FetchModelServersFixedSizeCollection createEmptyCollection() {
      return new FetchModelServersFixedSizeCollection(null, 0);
    }

    @Override
    protected FetchModelServersFixedSizeCollection createCollection(
        List<FetchModelServersPage> pages, int collectionSize) {
      return new FetchModelServersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class FetchModelServerVersionsPagedResponse
      extends AbstractPagedListResponse<
          FetchModelServerVersionsRequest,
          FetchModelServerVersionsResponse,
          String,
          FetchModelServerVersionsPage,
          FetchModelServerVersionsFixedSizeCollection> {

    public static ApiFuture<FetchModelServerVersionsPagedResponse> createAsync(
        PageContext<FetchModelServerVersionsRequest, FetchModelServerVersionsResponse, String>
            context,
        ApiFuture<FetchModelServerVersionsResponse> futureResponse) {
      ApiFuture<FetchModelServerVersionsPage> futurePage =
          FetchModelServerVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new FetchModelServerVersionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private FetchModelServerVersionsPagedResponse(FetchModelServerVersionsPage page) {
      super(page, FetchModelServerVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class FetchModelServerVersionsPage
      extends AbstractPage<
          FetchModelServerVersionsRequest,
          FetchModelServerVersionsResponse,
          String,
          FetchModelServerVersionsPage> {

    private FetchModelServerVersionsPage(
        PageContext<FetchModelServerVersionsRequest, FetchModelServerVersionsResponse, String>
            context,
        FetchModelServerVersionsResponse response) {
      super(context, response);
    }

    private static FetchModelServerVersionsPage createEmptyPage() {
      return new FetchModelServerVersionsPage(null, null);
    }

    @Override
    protected FetchModelServerVersionsPage createPage(
        PageContext<FetchModelServerVersionsRequest, FetchModelServerVersionsResponse, String>
            context,
        FetchModelServerVersionsResponse response) {
      return new FetchModelServerVersionsPage(context, response);
    }

    @Override
    public ApiFuture<FetchModelServerVersionsPage> createPageAsync(
        PageContext<FetchModelServerVersionsRequest, FetchModelServerVersionsResponse, String>
            context,
        ApiFuture<FetchModelServerVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class FetchModelServerVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          FetchModelServerVersionsRequest,
          FetchModelServerVersionsResponse,
          String,
          FetchModelServerVersionsPage,
          FetchModelServerVersionsFixedSizeCollection> {

    private FetchModelServerVersionsFixedSizeCollection(
        List<FetchModelServerVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static FetchModelServerVersionsFixedSizeCollection createEmptyCollection() {
      return new FetchModelServerVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected FetchModelServerVersionsFixedSizeCollection createCollection(
        List<FetchModelServerVersionsPage> pages, int collectionSize) {
      return new FetchModelServerVersionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class FetchProfilesPagedResponse
      extends AbstractPagedListResponse<
          FetchProfilesRequest,
          FetchProfilesResponse,
          Profile,
          FetchProfilesPage,
          FetchProfilesFixedSizeCollection> {

    public static ApiFuture<FetchProfilesPagedResponse> createAsync(
        PageContext<FetchProfilesRequest, FetchProfilesResponse, Profile> context,
        ApiFuture<FetchProfilesResponse> futureResponse) {
      ApiFuture<FetchProfilesPage> futurePage =
          FetchProfilesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new FetchProfilesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private FetchProfilesPagedResponse(FetchProfilesPage page) {
      super(page, FetchProfilesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class FetchProfilesPage
      extends AbstractPage<
          FetchProfilesRequest, FetchProfilesResponse, Profile, FetchProfilesPage> {

    private FetchProfilesPage(
        PageContext<FetchProfilesRequest, FetchProfilesResponse, Profile> context,
        FetchProfilesResponse response) {
      super(context, response);
    }

    private static FetchProfilesPage createEmptyPage() {
      return new FetchProfilesPage(null, null);
    }

    @Override
    protected FetchProfilesPage createPage(
        PageContext<FetchProfilesRequest, FetchProfilesResponse, Profile> context,
        FetchProfilesResponse response) {
      return new FetchProfilesPage(context, response);
    }

    @Override
    public ApiFuture<FetchProfilesPage> createPageAsync(
        PageContext<FetchProfilesRequest, FetchProfilesResponse, Profile> context,
        ApiFuture<FetchProfilesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class FetchProfilesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          FetchProfilesRequest,
          FetchProfilesResponse,
          Profile,
          FetchProfilesPage,
          FetchProfilesFixedSizeCollection> {

    private FetchProfilesFixedSizeCollection(List<FetchProfilesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static FetchProfilesFixedSizeCollection createEmptyCollection() {
      return new FetchProfilesFixedSizeCollection(null, 0);
    }

    @Override
    protected FetchProfilesFixedSizeCollection createCollection(
        List<FetchProfilesPage> pages, int collectionSize) {
      return new FetchProfilesFixedSizeCollection(pages, collectionSize);
    }
  }
}
