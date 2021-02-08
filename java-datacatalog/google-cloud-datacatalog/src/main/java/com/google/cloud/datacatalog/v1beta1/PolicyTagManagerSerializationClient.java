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

package com.google.cloud.datacatalog.v1beta1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.datacatalog.v1beta1.stub.PolicyTagManagerSerializationStub;
import com.google.cloud.datacatalog.v1beta1.stub.PolicyTagManagerSerializationStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Policy tag manager serialization API service allows clients to manipulate
 * their taxonomies and policy tags data with serialized format.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (PolicyTagManagerSerializationClient policyTagManagerSerializationClient =
 *     PolicyTagManagerSerializationClient.create()) {
 *   ImportTaxonomiesRequest request =
 *       ImportTaxonomiesRequest.newBuilder()
 *           .setParent(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
 *           .build();
 *   ImportTaxonomiesResponse response =
 *       policyTagManagerSerializationClient.importTaxonomies(request);
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
 * PolicyTagManagerSerializationSettings policyTagManagerSerializationSettings =
 *     PolicyTagManagerSerializationSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PolicyTagManagerSerializationClient policyTagManagerSerializationClient =
 *     PolicyTagManagerSerializationClient.create(policyTagManagerSerializationSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
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
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected PolicyTagManagerSerializationClient(PolicyTagManagerSerializationStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PolicyTagManagerSerializationSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public PolicyTagManagerSerializationStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports all taxonomies and their policy tags to a project as new taxonomies.
   *
   * <p>This method provides a bulk taxonomy / policy tag creation using nested proto structure.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PolicyTagManagerSerializationClient policyTagManagerSerializationClient =
   *     PolicyTagManagerSerializationClient.create()) {
   *   ImportTaxonomiesRequest request =
   *       ImportTaxonomiesRequest.newBuilder()
   *           .setParent(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
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
   * Imports all taxonomies and their policy tags to a project as new taxonomies.
   *
   * <p>This method provides a bulk taxonomy / policy tag creation using nested proto structure.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PolicyTagManagerSerializationClient policyTagManagerSerializationClient =
   *     PolicyTagManagerSerializationClient.create()) {
   *   ImportTaxonomiesRequest request =
   *       ImportTaxonomiesRequest.newBuilder()
   *           .setParent(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
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
   * Exports all taxonomies and their policy tags in a project.
   *
   * <p>This method generates SerializedTaxonomy protos with nested policy tags that can be used as
   * an input for future ImportTaxonomies calls.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PolicyTagManagerSerializationClient policyTagManagerSerializationClient =
   *     PolicyTagManagerSerializationClient.create()) {
   *   ExportTaxonomiesRequest request =
   *       ExportTaxonomiesRequest.newBuilder()
   *           .setParent(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
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
   * Exports all taxonomies and their policy tags in a project.
   *
   * <p>This method generates SerializedTaxonomy protos with nested policy tags that can be used as
   * an input for future ImportTaxonomies calls.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (PolicyTagManagerSerializationClient policyTagManagerSerializationClient =
   *     PolicyTagManagerSerializationClient.create()) {
   *   ExportTaxonomiesRequest request =
   *       ExportTaxonomiesRequest.newBuilder()
   *           .setParent(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
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
