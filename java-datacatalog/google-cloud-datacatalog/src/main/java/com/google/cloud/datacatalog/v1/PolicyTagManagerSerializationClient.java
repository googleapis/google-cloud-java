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

package com.google.cloud.datacatalog.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.datacatalog.v1.stub.PolicyTagManagerSerializationStub;
import com.google.cloud.datacatalog.v1.stub.PolicyTagManagerSerializationStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Policy Tag Manager Serialization API service allows you to manipulate your
 * policy tags and taxonomies in a serialized format.
 *
 * <p>Taxonomy is a hierarchical group of policy tags.
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
 * try (PolicyTagManagerSerializationClient policyTagManagerSerializationClient =
 *     PolicyTagManagerSerializationClient.create()) {
 *   ReplaceTaxonomyRequest request =
 *       ReplaceTaxonomyRequest.newBuilder()
 *           .setName(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
 *           .setSerializedTaxonomy(SerializedTaxonomy.newBuilder().build())
 *           .build();
 *   Taxonomy response = policyTagManagerSerializationClient.replaceTaxonomy(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PolicyTagManagerSerializationClient object to clean up
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
 * PolicyTagManagerSerializationSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PolicyTagManagerSerializationSettings policyTagManagerSerializationSettings =
 *     PolicyTagManagerSerializationSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PolicyTagManagerSerializationClient policyTagManagerSerializationClient =
 *     PolicyTagManagerSerializationClient.create(policyTagManagerSerializationSettings);
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
 * PolicyTagManagerSerializationSettings policyTagManagerSerializationSettings =
 *     PolicyTagManagerSerializationSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PolicyTagManagerSerializationClient policyTagManagerSerializationClient =
 *     PolicyTagManagerSerializationClient.create(policyTagManagerSerializationSettings);
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
 * PolicyTagManagerSerializationSettings policyTagManagerSerializationSettings =
 *     PolicyTagManagerSerializationSettings.newHttpJsonBuilder().build();
 * PolicyTagManagerSerializationClient policyTagManagerSerializationClient =
 *     PolicyTagManagerSerializationClient.create(policyTagManagerSerializationSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class PolicyTagManagerSerializationClient implements BackgroundResource {
  private final PolicyTagManagerSerializationSettings settings;
  private final PolicyTagManagerSerializationStub stub;

  /** Constructs an instance of PolicyTagManagerSerializationClient with default settings. */
  public static final PolicyTagManagerSerializationClient create() throws IOException {
    return create(PolicyTagManagerSerializationSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PolicyTagManagerSerializationClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final PolicyTagManagerSerializationClient create(
      PolicyTagManagerSerializationSettings settings) throws IOException {
    return new PolicyTagManagerSerializationClient(settings);
  }

  /**
   * Constructs an instance of PolicyTagManagerSerializationClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(PolicyTagManagerSerializationSettings).
   */
  public static final PolicyTagManagerSerializationClient create(
      PolicyTagManagerSerializationStub stub) {
    return new PolicyTagManagerSerializationClient(stub);
  }

  /**
   * Constructs an instance of PolicyTagManagerSerializationClient, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected PolicyTagManagerSerializationClient(PolicyTagManagerSerializationSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((PolicyTagManagerSerializationStubSettings) settings.getStubSettings()).createStub();
  }

  protected PolicyTagManagerSerializationClient(PolicyTagManagerSerializationStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PolicyTagManagerSerializationSettings getSettings() {
    return settings;
  }

  public PolicyTagManagerSerializationStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Replaces (updates) a taxonomy and all its policy tags.
   *
   * <p>The taxonomy and its entire hierarchy of policy tags must be represented literally by
   * `SerializedTaxonomy` and the nested `SerializedPolicyTag` messages.
   *
   * <p>This operation automatically does the following:
   *
   * <p>- Deletes the existing policy tags that are missing from the `SerializedPolicyTag`. -
   * Creates policy tags that don't have resource names. They are considered new. - Updates policy
   * tags with valid resources names accordingly.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerSerializationClient policyTagManagerSerializationClient =
   *     PolicyTagManagerSerializationClient.create()) {
   *   ReplaceTaxonomyRequest request =
   *       ReplaceTaxonomyRequest.newBuilder()
   *           .setName(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
   *           .setSerializedTaxonomy(SerializedTaxonomy.newBuilder().build())
   *           .build();
   *   Taxonomy response = policyTagManagerSerializationClient.replaceTaxonomy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Taxonomy replaceTaxonomy(ReplaceTaxonomyRequest request) {
    return replaceTaxonomyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Replaces (updates) a taxonomy and all its policy tags.
   *
   * <p>The taxonomy and its entire hierarchy of policy tags must be represented literally by
   * `SerializedTaxonomy` and the nested `SerializedPolicyTag` messages.
   *
   * <p>This operation automatically does the following:
   *
   * <p>- Deletes the existing policy tags that are missing from the `SerializedPolicyTag`. -
   * Creates policy tags that don't have resource names. They are considered new. - Updates policy
   * tags with valid resources names accordingly.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerSerializationClient policyTagManagerSerializationClient =
   *     PolicyTagManagerSerializationClient.create()) {
   *   ReplaceTaxonomyRequest request =
   *       ReplaceTaxonomyRequest.newBuilder()
   *           .setName(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
   *           .setSerializedTaxonomy(SerializedTaxonomy.newBuilder().build())
   *           .build();
   *   ApiFuture<Taxonomy> future =
   *       policyTagManagerSerializationClient.replaceTaxonomyCallable().futureCall(request);
   *   // Do something.
   *   Taxonomy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ReplaceTaxonomyRequest, Taxonomy> replaceTaxonomyCallable() {
    return stub.replaceTaxonomyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new taxonomies (including their policy tags) in a given project by importing from
   * inlined or cross-regional sources.
   *
   * <p>For a cross-regional source, new taxonomies are created by copying from a source in another
   * region.
   *
   * <p>For an inlined source, taxonomies and policy tags are created in bulk using nested protocol
   * buffer structures.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerSerializationClient policyTagManagerSerializationClient =
   *     PolicyTagManagerSerializationClient.create()) {
   *   ImportTaxonomiesRequest request =
   *       ImportTaxonomiesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ImportTaxonomiesResponse response =
   *       policyTagManagerSerializationClient.importTaxonomies(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportTaxonomiesResponse importTaxonomies(ImportTaxonomiesRequest request) {
    return importTaxonomiesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new taxonomies (including their policy tags) in a given project by importing from
   * inlined or cross-regional sources.
   *
   * <p>For a cross-regional source, new taxonomies are created by copying from a source in another
   * region.
   *
   * <p>For an inlined source, taxonomies and policy tags are created in bulk using nested protocol
   * buffer structures.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerSerializationClient policyTagManagerSerializationClient =
   *     PolicyTagManagerSerializationClient.create()) {
   *   ImportTaxonomiesRequest request =
   *       ImportTaxonomiesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<ImportTaxonomiesResponse> future =
   *       policyTagManagerSerializationClient.importTaxonomiesCallable().futureCall(request);
   *   // Do something.
   *   ImportTaxonomiesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportTaxonomiesRequest, ImportTaxonomiesResponse>
      importTaxonomiesCallable() {
    return stub.importTaxonomiesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports taxonomies in the requested type and returns them, including their policy tags. The
   * requested taxonomies must belong to the same project.
   *
   * <p>This method generates `SerializedTaxonomy` protocol buffers with nested policy tags that can
   * be used as input for `ImportTaxonomies` calls.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerSerializationClient policyTagManagerSerializationClient =
   *     PolicyTagManagerSerializationClient.create()) {
   *   ExportTaxonomiesRequest request =
   *       ExportTaxonomiesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllTaxonomies(new ArrayList<String>())
   *           .build();
   *   ExportTaxonomiesResponse response =
   *       policyTagManagerSerializationClient.exportTaxonomies(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExportTaxonomiesResponse exportTaxonomies(ExportTaxonomiesRequest request) {
    return exportTaxonomiesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports taxonomies in the requested type and returns them, including their policy tags. The
   * requested taxonomies must belong to the same project.
   *
   * <p>This method generates `SerializedTaxonomy` protocol buffers with nested policy tags that can
   * be used as input for `ImportTaxonomies` calls.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTagManagerSerializationClient policyTagManagerSerializationClient =
   *     PolicyTagManagerSerializationClient.create()) {
   *   ExportTaxonomiesRequest request =
   *       ExportTaxonomiesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllTaxonomies(new ArrayList<String>())
   *           .build();
   *   ApiFuture<ExportTaxonomiesResponse> future =
   *       policyTagManagerSerializationClient.exportTaxonomiesCallable().futureCall(request);
   *   // Do something.
   *   ExportTaxonomiesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportTaxonomiesRequest, ExportTaxonomiesResponse>
      exportTaxonomiesCallable() {
    return stub.exportTaxonomiesCallable();
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
