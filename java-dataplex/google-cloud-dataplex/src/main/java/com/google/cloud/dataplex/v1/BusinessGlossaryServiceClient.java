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

package com.google.cloud.dataplex.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataplex.v1.stub.BusinessGlossaryServiceStub;
import com.google.cloud.dataplex.v1.stub.BusinessGlossaryServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: BusinessGlossaryService provides APIs for managing business glossary
 * resources for enterprise customers. The resources currently supported in Business Glossary are:
 * 1. Glossary 2. GlossaryCategory 3. GlossaryTerm
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
 * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
 *     BusinessGlossaryServiceClient.create()) {
 *   GlossaryName name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
 *   Glossary response = businessGlossaryServiceClient.getGlossary(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the BusinessGlossaryServiceClient object to clean up
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
 *      <td><p> CreateGlossary</td>
 *      <td><p> Creates a new Glossary resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createGlossaryAsync(CreateGlossaryRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createGlossaryAsync(LocationName parent, Glossary glossary, String glossaryId)
 *           <li><p> createGlossaryAsync(String parent, Glossary glossary, String glossaryId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createGlossaryOperationCallable()
 *           <li><p> createGlossaryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateGlossary</td>
 *      <td><p> Updates a Glossary resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateGlossaryAsync(UpdateGlossaryRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateGlossaryAsync(Glossary glossary, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateGlossaryOperationCallable()
 *           <li><p> updateGlossaryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteGlossary</td>
 *      <td><p> Deletes a Glossary resource. All the categories and terms within the Glossary must be deleted before the Glossary can be deleted.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteGlossaryAsync(DeleteGlossaryRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteGlossaryAsync(GlossaryName name)
 *           <li><p> deleteGlossaryAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteGlossaryOperationCallable()
 *           <li><p> deleteGlossaryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetGlossary</td>
 *      <td><p> Gets a Glossary resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getGlossary(GetGlossaryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getGlossary(GlossaryName name)
 *           <li><p> getGlossary(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getGlossaryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListGlossaries</td>
 *      <td><p> Lists Glossary resources in a project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listGlossaries(ListGlossariesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listGlossaries(LocationName parent)
 *           <li><p> listGlossaries(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listGlossariesPagedCallable()
 *           <li><p> listGlossariesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateGlossaryCategory</td>
 *      <td><p> Creates a new GlossaryCategory resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createGlossaryCategory(CreateGlossaryCategoryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createGlossaryCategory(GlossaryName parent, GlossaryCategory category, String categoryId)
 *           <li><p> createGlossaryCategory(String parent, GlossaryCategory category, String categoryId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createGlossaryCategoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateGlossaryCategory</td>
 *      <td><p> Updates a GlossaryCategory resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateGlossaryCategory(UpdateGlossaryCategoryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateGlossaryCategory(GlossaryCategory category, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateGlossaryCategoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteGlossaryCategory</td>
 *      <td><p> Deletes a GlossaryCategory resource. All the GlossaryCategories and GlossaryTerms nested directly under the specified GlossaryCategory will be moved one level up to the parent in the hierarchy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteGlossaryCategory(DeleteGlossaryCategoryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteGlossaryCategory(GlossaryCategoryName name)
 *           <li><p> deleteGlossaryCategory(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteGlossaryCategoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetGlossaryCategory</td>
 *      <td><p> Gets a GlossaryCategory resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getGlossaryCategory(GetGlossaryCategoryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getGlossaryCategory(GlossaryCategoryName name)
 *           <li><p> getGlossaryCategory(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getGlossaryCategoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListGlossaryCategories</td>
 *      <td><p> Lists GlossaryCategory resources in a Glossary.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listGlossaryCategories(ListGlossaryCategoriesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listGlossaryCategories(GlossaryName parent)
 *           <li><p> listGlossaryCategories(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listGlossaryCategoriesPagedCallable()
 *           <li><p> listGlossaryCategoriesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateGlossaryTerm</td>
 *      <td><p> Creates a new GlossaryTerm resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createGlossaryTerm(CreateGlossaryTermRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createGlossaryTerm(GlossaryName parent, GlossaryTerm term, String termId)
 *           <li><p> createGlossaryTerm(String parent, GlossaryTerm term, String termId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createGlossaryTermCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateGlossaryTerm</td>
 *      <td><p> Updates a GlossaryTerm resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateGlossaryTerm(UpdateGlossaryTermRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateGlossaryTerm(GlossaryTerm term, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateGlossaryTermCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteGlossaryTerm</td>
 *      <td><p> Deletes a GlossaryTerm resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteGlossaryTerm(DeleteGlossaryTermRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteGlossaryTerm(GlossaryTermName name)
 *           <li><p> deleteGlossaryTerm(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteGlossaryTermCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetGlossaryTerm</td>
 *      <td><p> Gets a GlossaryTerm resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getGlossaryTerm(GetGlossaryTermRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getGlossaryTerm(GlossaryTermName name)
 *           <li><p> getGlossaryTerm(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getGlossaryTermCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListGlossaryTerms</td>
 *      <td><p> Lists GlossaryTerm resources in a Glossary.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listGlossaryTerms(ListGlossaryTermsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listGlossaryTerms(GlossaryName parent)
 *           <li><p> listGlossaryTerms(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listGlossaryTermsPagedCallable()
 *           <li><p> listGlossaryTermsCallable()
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
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of
 * BusinessGlossaryServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BusinessGlossaryServiceSettings businessGlossaryServiceSettings =
 *     BusinessGlossaryServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BusinessGlossaryServiceClient businessGlossaryServiceClient =
 *     BusinessGlossaryServiceClient.create(businessGlossaryServiceSettings);
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
 * BusinessGlossaryServiceSettings businessGlossaryServiceSettings =
 *     BusinessGlossaryServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BusinessGlossaryServiceClient businessGlossaryServiceClient =
 *     BusinessGlossaryServiceClient.create(businessGlossaryServiceSettings);
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
 * BusinessGlossaryServiceSettings businessGlossaryServiceSettings =
 *     BusinessGlossaryServiceSettings.newHttpJsonBuilder().build();
 * BusinessGlossaryServiceClient businessGlossaryServiceClient =
 *     BusinessGlossaryServiceClient.create(businessGlossaryServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class BusinessGlossaryServiceClient implements BackgroundResource {
  private final BusinessGlossaryServiceSettings settings;
  private final BusinessGlossaryServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of BusinessGlossaryServiceClient with default settings. */
  public static final BusinessGlossaryServiceClient create() throws IOException {
    return create(BusinessGlossaryServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BusinessGlossaryServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BusinessGlossaryServiceClient create(BusinessGlossaryServiceSettings settings)
      throws IOException {
    return new BusinessGlossaryServiceClient(settings);
  }

  /**
   * Constructs an instance of BusinessGlossaryServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(BusinessGlossaryServiceSettings).
   */
  public static final BusinessGlossaryServiceClient create(BusinessGlossaryServiceStub stub) {
    return new BusinessGlossaryServiceClient(stub);
  }

  /**
   * Constructs an instance of BusinessGlossaryServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected BusinessGlossaryServiceClient(BusinessGlossaryServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((BusinessGlossaryServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected BusinessGlossaryServiceClient(BusinessGlossaryServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final BusinessGlossaryServiceSettings getSettings() {
    return settings;
  }

  public BusinessGlossaryServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Glossary resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Glossary glossary = Glossary.newBuilder().build();
   *   String glossaryId = "glossaryId1849967577";
   *   Glossary response =
   *       businessGlossaryServiceClient.createGlossaryAsync(parent, glossary, glossaryId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this Glossary will be created. Format:
   *     projects/{project_id_or_number}/locations/{location_id} where `location_id` refers to a
   *     Google Cloud region.
   * @param glossary Required. The Glossary to create.
   * @param glossaryId Required. Glossary ID: Glossary identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Glossary, OperationMetadata> createGlossaryAsync(
      LocationName parent, Glossary glossary, String glossaryId) {
    CreateGlossaryRequest request =
        CreateGlossaryRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGlossary(glossary)
            .setGlossaryId(glossaryId)
            .build();
    return createGlossaryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Glossary resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Glossary glossary = Glossary.newBuilder().build();
   *   String glossaryId = "glossaryId1849967577";
   *   Glossary response =
   *       businessGlossaryServiceClient.createGlossaryAsync(parent, glossary, glossaryId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this Glossary will be created. Format:
   *     projects/{project_id_or_number}/locations/{location_id} where `location_id` refers to a
   *     Google Cloud region.
   * @param glossary Required. The Glossary to create.
   * @param glossaryId Required. Glossary ID: Glossary identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Glossary, OperationMetadata> createGlossaryAsync(
      String parent, Glossary glossary, String glossaryId) {
    CreateGlossaryRequest request =
        CreateGlossaryRequest.newBuilder()
            .setParent(parent)
            .setGlossary(glossary)
            .setGlossaryId(glossaryId)
            .build();
    return createGlossaryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Glossary resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   CreateGlossaryRequest request =
   *       CreateGlossaryRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGlossaryId("glossaryId1849967577")
   *           .setGlossary(Glossary.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Glossary response = businessGlossaryServiceClient.createGlossaryAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Glossary, OperationMetadata> createGlossaryAsync(
      CreateGlossaryRequest request) {
    return createGlossaryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Glossary resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   CreateGlossaryRequest request =
   *       CreateGlossaryRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGlossaryId("glossaryId1849967577")
   *           .setGlossary(Glossary.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Glossary, OperationMetadata> future =
   *       businessGlossaryServiceClient.createGlossaryOperationCallable().futureCall(request);
   *   // Do something.
   *   Glossary response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateGlossaryRequest, Glossary, OperationMetadata>
      createGlossaryOperationCallable() {
    return stub.createGlossaryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Glossary resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   CreateGlossaryRequest request =
   *       CreateGlossaryRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGlossaryId("glossaryId1849967577")
   *           .setGlossary(Glossary.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       businessGlossaryServiceClient.createGlossaryCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateGlossaryRequest, Operation> createGlossaryCallable() {
    return stub.createGlossaryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Glossary resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   Glossary glossary = Glossary.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Glossary response =
   *       businessGlossaryServiceClient.updateGlossaryAsync(glossary, updateMask).get();
   * }
   * }</pre>
   *
   * @param glossary Required. The Glossary to update. The Glossary's `name` field is used to
   *     identify the Glossary to update. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/glossaries/{glossary_id}
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Glossary, OperationMetadata> updateGlossaryAsync(
      Glossary glossary, FieldMask updateMask) {
    UpdateGlossaryRequest request =
        UpdateGlossaryRequest.newBuilder().setGlossary(glossary).setUpdateMask(updateMask).build();
    return updateGlossaryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Glossary resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   UpdateGlossaryRequest request =
   *       UpdateGlossaryRequest.newBuilder()
   *           .setGlossary(Glossary.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Glossary response = businessGlossaryServiceClient.updateGlossaryAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Glossary, OperationMetadata> updateGlossaryAsync(
      UpdateGlossaryRequest request) {
    return updateGlossaryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Glossary resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   UpdateGlossaryRequest request =
   *       UpdateGlossaryRequest.newBuilder()
   *           .setGlossary(Glossary.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Glossary, OperationMetadata> future =
   *       businessGlossaryServiceClient.updateGlossaryOperationCallable().futureCall(request);
   *   // Do something.
   *   Glossary response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateGlossaryRequest, Glossary, OperationMetadata>
      updateGlossaryOperationCallable() {
    return stub.updateGlossaryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Glossary resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   UpdateGlossaryRequest request =
   *       UpdateGlossaryRequest.newBuilder()
   *           .setGlossary(Glossary.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       businessGlossaryServiceClient.updateGlossaryCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateGlossaryRequest, Operation> updateGlossaryCallable() {
    return stub.updateGlossaryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Glossary resource. All the categories and terms within the Glossary must be deleted
   * before the Glossary can be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   GlossaryName name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
   *   businessGlossaryServiceClient.deleteGlossaryAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Glossary to delete. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/glossaries/{glossary_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGlossaryAsync(GlossaryName name) {
    DeleteGlossaryRequest request =
        DeleteGlossaryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteGlossaryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Glossary resource. All the categories and terms within the Glossary must be deleted
   * before the Glossary can be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   String name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString();
   *   businessGlossaryServiceClient.deleteGlossaryAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Glossary to delete. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/glossaries/{glossary_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGlossaryAsync(String name) {
    DeleteGlossaryRequest request = DeleteGlossaryRequest.newBuilder().setName(name).build();
    return deleteGlossaryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Glossary resource. All the categories and terms within the Glossary must be deleted
   * before the Glossary can be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   DeleteGlossaryRequest request =
   *       DeleteGlossaryRequest.newBuilder()
   *           .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   businessGlossaryServiceClient.deleteGlossaryAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGlossaryAsync(
      DeleteGlossaryRequest request) {
    return deleteGlossaryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Glossary resource. All the categories and terms within the Glossary must be deleted
   * before the Glossary can be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   DeleteGlossaryRequest request =
   *       DeleteGlossaryRequest.newBuilder()
   *           .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       businessGlossaryServiceClient.deleteGlossaryOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteGlossaryRequest, Empty, OperationMetadata>
      deleteGlossaryOperationCallable() {
    return stub.deleteGlossaryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Glossary resource. All the categories and terms within the Glossary must be deleted
   * before the Glossary can be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   DeleteGlossaryRequest request =
   *       DeleteGlossaryRequest.newBuilder()
   *           .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       businessGlossaryServiceClient.deleteGlossaryCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGlossaryRequest, Operation> deleteGlossaryCallable() {
    return stub.deleteGlossaryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Glossary resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   GlossaryName name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
   *   Glossary response = businessGlossaryServiceClient.getGlossary(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Glossary to retrieve. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/glossaries/{glossary_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Glossary getGlossary(GlossaryName name) {
    GetGlossaryRequest request =
        GetGlossaryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getGlossary(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Glossary resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   String name = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString();
   *   Glossary response = businessGlossaryServiceClient.getGlossary(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Glossary to retrieve. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/glossaries/{glossary_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Glossary getGlossary(String name) {
    GetGlossaryRequest request = GetGlossaryRequest.newBuilder().setName(name).build();
    return getGlossary(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Glossary resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   GetGlossaryRequest request =
   *       GetGlossaryRequest.newBuilder()
   *           .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .build();
   *   Glossary response = businessGlossaryServiceClient.getGlossary(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Glossary getGlossary(GetGlossaryRequest request) {
    return getGlossaryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Glossary resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   GetGlossaryRequest request =
   *       GetGlossaryRequest.newBuilder()
   *           .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .build();
   *   ApiFuture<Glossary> future =
   *       businessGlossaryServiceClient.getGlossaryCallable().futureCall(request);
   *   // Do something.
   *   Glossary response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGlossaryRequest, Glossary> getGlossaryCallable() {
    return stub.getGlossaryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Glossary resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Glossary element : businessGlossaryServiceClient.listGlossaries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which has this collection of Glossaries. Format:
   *     projects/{project_id_or_number}/locations/{location_id} where `location_id` refers to a
   *     Google Cloud region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGlossariesPagedResponse listGlossaries(LocationName parent) {
    ListGlossariesRequest request =
        ListGlossariesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listGlossaries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Glossary resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Glossary element : businessGlossaryServiceClient.listGlossaries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which has this collection of Glossaries. Format:
   *     projects/{project_id_or_number}/locations/{location_id} where `location_id` refers to a
   *     Google Cloud region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGlossariesPagedResponse listGlossaries(String parent) {
    ListGlossariesRequest request = ListGlossariesRequest.newBuilder().setParent(parent).build();
    return listGlossaries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Glossary resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   ListGlossariesRequest request =
   *       ListGlossariesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Glossary element : businessGlossaryServiceClient.listGlossaries(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGlossariesPagedResponse listGlossaries(ListGlossariesRequest request) {
    return listGlossariesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Glossary resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   ListGlossariesRequest request =
   *       ListGlossariesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Glossary> future =
   *       businessGlossaryServiceClient.listGlossariesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Glossary element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGlossariesRequest, ListGlossariesPagedResponse>
      listGlossariesPagedCallable() {
    return stub.listGlossariesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Glossary resources in a project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   ListGlossariesRequest request =
   *       ListGlossariesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListGlossariesResponse response =
   *         businessGlossaryServiceClient.listGlossariesCallable().call(request);
   *     for (Glossary element : response.getGlossariesList()) {
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
  public final UnaryCallable<ListGlossariesRequest, ListGlossariesResponse>
      listGlossariesCallable() {
    return stub.listGlossariesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new GlossaryCategory resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   GlossaryName parent = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
   *   GlossaryCategory category = GlossaryCategory.newBuilder().build();
   *   String categoryId = "categoryId1296531129";
   *   GlossaryCategory response =
   *       businessGlossaryServiceClient.createGlossaryCategory(parent, category, categoryId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this GlossaryCategory will be created.
   *     Format: projects/{project_id_or_number}/locations/{location_id}/glossaries/{glossary_id}
   *     where `locationId` refers to a Google Cloud region.
   * @param category Required. The GlossaryCategory to create.
   * @param categoryId Required. GlossaryCategory identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlossaryCategory createGlossaryCategory(
      GlossaryName parent, GlossaryCategory category, String categoryId) {
    CreateGlossaryCategoryRequest request =
        CreateGlossaryCategoryRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCategory(category)
            .setCategoryId(categoryId)
            .build();
    return createGlossaryCategory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new GlossaryCategory resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   String parent = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString();
   *   GlossaryCategory category = GlossaryCategory.newBuilder().build();
   *   String categoryId = "categoryId1296531129";
   *   GlossaryCategory response =
   *       businessGlossaryServiceClient.createGlossaryCategory(parent, category, categoryId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this GlossaryCategory will be created.
   *     Format: projects/{project_id_or_number}/locations/{location_id}/glossaries/{glossary_id}
   *     where `locationId` refers to a Google Cloud region.
   * @param category Required. The GlossaryCategory to create.
   * @param categoryId Required. GlossaryCategory identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlossaryCategory createGlossaryCategory(
      String parent, GlossaryCategory category, String categoryId) {
    CreateGlossaryCategoryRequest request =
        CreateGlossaryCategoryRequest.newBuilder()
            .setParent(parent)
            .setCategory(category)
            .setCategoryId(categoryId)
            .build();
    return createGlossaryCategory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new GlossaryCategory resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   CreateGlossaryCategoryRequest request =
   *       CreateGlossaryCategoryRequest.newBuilder()
   *           .setParent(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .setCategoryId("categoryId1296531129")
   *           .setCategory(GlossaryCategory.newBuilder().build())
   *           .build();
   *   GlossaryCategory response = businessGlossaryServiceClient.createGlossaryCategory(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlossaryCategory createGlossaryCategory(CreateGlossaryCategoryRequest request) {
    return createGlossaryCategoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new GlossaryCategory resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   CreateGlossaryCategoryRequest request =
   *       CreateGlossaryCategoryRequest.newBuilder()
   *           .setParent(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .setCategoryId("categoryId1296531129")
   *           .setCategory(GlossaryCategory.newBuilder().build())
   *           .build();
   *   ApiFuture<GlossaryCategory> future =
   *       businessGlossaryServiceClient.createGlossaryCategoryCallable().futureCall(request);
   *   // Do something.
   *   GlossaryCategory response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateGlossaryCategoryRequest, GlossaryCategory>
      createGlossaryCategoryCallable() {
    return stub.createGlossaryCategoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a GlossaryCategory resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   GlossaryCategory category = GlossaryCategory.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   GlossaryCategory response =
   *       businessGlossaryServiceClient.updateGlossaryCategory(category, updateMask);
   * }
   * }</pre>
   *
   * @param category Required. The GlossaryCategory to update. The GlossaryCategory's `name` field
   *     is used to identify the GlossaryCategory to update. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/glossaries/{glossary_id}/categories/{category_id}
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlossaryCategory updateGlossaryCategory(
      GlossaryCategory category, FieldMask updateMask) {
    UpdateGlossaryCategoryRequest request =
        UpdateGlossaryCategoryRequest.newBuilder()
            .setCategory(category)
            .setUpdateMask(updateMask)
            .build();
    return updateGlossaryCategory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a GlossaryCategory resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   UpdateGlossaryCategoryRequest request =
   *       UpdateGlossaryCategoryRequest.newBuilder()
   *           .setCategory(GlossaryCategory.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   GlossaryCategory response = businessGlossaryServiceClient.updateGlossaryCategory(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlossaryCategory updateGlossaryCategory(UpdateGlossaryCategoryRequest request) {
    return updateGlossaryCategoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a GlossaryCategory resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   UpdateGlossaryCategoryRequest request =
   *       UpdateGlossaryCategoryRequest.newBuilder()
   *           .setCategory(GlossaryCategory.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<GlossaryCategory> future =
   *       businessGlossaryServiceClient.updateGlossaryCategoryCallable().futureCall(request);
   *   // Do something.
   *   GlossaryCategory response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateGlossaryCategoryRequest, GlossaryCategory>
      updateGlossaryCategoryCallable() {
    return stub.updateGlossaryCategoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a GlossaryCategory resource. All the GlossaryCategories and GlossaryTerms nested
   * directly under the specified GlossaryCategory will be moved one level up to the parent in the
   * hierarchy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   GlossaryCategoryName name =
   *       GlossaryCategoryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_CATEGORY]");
   *   businessGlossaryServiceClient.deleteGlossaryCategory(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the GlossaryCategory to delete. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/glossaries/{glossary_id}/categories/{category_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteGlossaryCategory(GlossaryCategoryName name) {
    DeleteGlossaryCategoryRequest request =
        DeleteGlossaryCategoryRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteGlossaryCategory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a GlossaryCategory resource. All the GlossaryCategories and GlossaryTerms nested
   * directly under the specified GlossaryCategory will be moved one level up to the parent in the
   * hierarchy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   String name =
   *       GlossaryCategoryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_CATEGORY]")
   *           .toString();
   *   businessGlossaryServiceClient.deleteGlossaryCategory(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the GlossaryCategory to delete. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/glossaries/{glossary_id}/categories/{category_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteGlossaryCategory(String name) {
    DeleteGlossaryCategoryRequest request =
        DeleteGlossaryCategoryRequest.newBuilder().setName(name).build();
    deleteGlossaryCategory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a GlossaryCategory resource. All the GlossaryCategories and GlossaryTerms nested
   * directly under the specified GlossaryCategory will be moved one level up to the parent in the
   * hierarchy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   DeleteGlossaryCategoryRequest request =
   *       DeleteGlossaryCategoryRequest.newBuilder()
   *           .setName(
   *               GlossaryCategoryName.of(
   *                       "[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_CATEGORY]")
   *                   .toString())
   *           .build();
   *   businessGlossaryServiceClient.deleteGlossaryCategory(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteGlossaryCategory(DeleteGlossaryCategoryRequest request) {
    deleteGlossaryCategoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a GlossaryCategory resource. All the GlossaryCategories and GlossaryTerms nested
   * directly under the specified GlossaryCategory will be moved one level up to the parent in the
   * hierarchy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   DeleteGlossaryCategoryRequest request =
   *       DeleteGlossaryCategoryRequest.newBuilder()
   *           .setName(
   *               GlossaryCategoryName.of(
   *                       "[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_CATEGORY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       businessGlossaryServiceClient.deleteGlossaryCategoryCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGlossaryCategoryRequest, Empty>
      deleteGlossaryCategoryCallable() {
    return stub.deleteGlossaryCategoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a GlossaryCategory resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   GlossaryCategoryName name =
   *       GlossaryCategoryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_CATEGORY]");
   *   GlossaryCategory response = businessGlossaryServiceClient.getGlossaryCategory(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the GlossaryCategory to retrieve. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/glossaries/{glossary_id}/categories/{category_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlossaryCategory getGlossaryCategory(GlossaryCategoryName name) {
    GetGlossaryCategoryRequest request =
        GetGlossaryCategoryRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getGlossaryCategory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a GlossaryCategory resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   String name =
   *       GlossaryCategoryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_CATEGORY]")
   *           .toString();
   *   GlossaryCategory response = businessGlossaryServiceClient.getGlossaryCategory(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the GlossaryCategory to retrieve. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/glossaries/{glossary_id}/categories/{category_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlossaryCategory getGlossaryCategory(String name) {
    GetGlossaryCategoryRequest request =
        GetGlossaryCategoryRequest.newBuilder().setName(name).build();
    return getGlossaryCategory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a GlossaryCategory resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   GetGlossaryCategoryRequest request =
   *       GetGlossaryCategoryRequest.newBuilder()
   *           .setName(
   *               GlossaryCategoryName.of(
   *                       "[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_CATEGORY]")
   *                   .toString())
   *           .build();
   *   GlossaryCategory response = businessGlossaryServiceClient.getGlossaryCategory(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlossaryCategory getGlossaryCategory(GetGlossaryCategoryRequest request) {
    return getGlossaryCategoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a GlossaryCategory resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   GetGlossaryCategoryRequest request =
   *       GetGlossaryCategoryRequest.newBuilder()
   *           .setName(
   *               GlossaryCategoryName.of(
   *                       "[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_CATEGORY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<GlossaryCategory> future =
   *       businessGlossaryServiceClient.getGlossaryCategoryCallable().futureCall(request);
   *   // Do something.
   *   GlossaryCategory response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGlossaryCategoryRequest, GlossaryCategory>
      getGlossaryCategoryCallable() {
    return stub.getGlossaryCategoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GlossaryCategory resources in a Glossary.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   GlossaryName parent = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
   *   for (GlossaryCategory element :
   *       businessGlossaryServiceClient.listGlossaryCategories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which has this collection of GlossaryCategories. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/glossaries/{glossary_id} Location
   *     is the Google Cloud region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGlossaryCategoriesPagedResponse listGlossaryCategories(GlossaryName parent) {
    ListGlossaryCategoriesRequest request =
        ListGlossaryCategoriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listGlossaryCategories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GlossaryCategory resources in a Glossary.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   String parent = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString();
   *   for (GlossaryCategory element :
   *       businessGlossaryServiceClient.listGlossaryCategories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which has this collection of GlossaryCategories. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/glossaries/{glossary_id} Location
   *     is the Google Cloud region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGlossaryCategoriesPagedResponse listGlossaryCategories(String parent) {
    ListGlossaryCategoriesRequest request =
        ListGlossaryCategoriesRequest.newBuilder().setParent(parent).build();
    return listGlossaryCategories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GlossaryCategory resources in a Glossary.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   ListGlossaryCategoriesRequest request =
   *       ListGlossaryCategoriesRequest.newBuilder()
   *           .setParent(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (GlossaryCategory element :
   *       businessGlossaryServiceClient.listGlossaryCategories(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGlossaryCategoriesPagedResponse listGlossaryCategories(
      ListGlossaryCategoriesRequest request) {
    return listGlossaryCategoriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GlossaryCategory resources in a Glossary.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   ListGlossaryCategoriesRequest request =
   *       ListGlossaryCategoriesRequest.newBuilder()
   *           .setParent(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<GlossaryCategory> future =
   *       businessGlossaryServiceClient.listGlossaryCategoriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (GlossaryCategory element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGlossaryCategoriesRequest, ListGlossaryCategoriesPagedResponse>
      listGlossaryCategoriesPagedCallable() {
    return stub.listGlossaryCategoriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GlossaryCategory resources in a Glossary.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   ListGlossaryCategoriesRequest request =
   *       ListGlossaryCategoriesRequest.newBuilder()
   *           .setParent(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListGlossaryCategoriesResponse response =
   *         businessGlossaryServiceClient.listGlossaryCategoriesCallable().call(request);
   *     for (GlossaryCategory element : response.getCategoriesList()) {
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
  public final UnaryCallable<ListGlossaryCategoriesRequest, ListGlossaryCategoriesResponse>
      listGlossaryCategoriesCallable() {
    return stub.listGlossaryCategoriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new GlossaryTerm resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   GlossaryName parent = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
   *   GlossaryTerm term = GlossaryTerm.newBuilder().build();
   *   String termId = "termId-877206873";
   *   GlossaryTerm response =
   *       businessGlossaryServiceClient.createGlossaryTerm(parent, term, termId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where the GlossaryTerm will be created. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/glossaries/{glossary_id} where
   *     `location_id` refers to a Google Cloud region.
   * @param term Required. The GlossaryTerm to create.
   * @param termId Required. GlossaryTerm identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlossaryTerm createGlossaryTerm(
      GlossaryName parent, GlossaryTerm term, String termId) {
    CreateGlossaryTermRequest request =
        CreateGlossaryTermRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTerm(term)
            .setTermId(termId)
            .build();
    return createGlossaryTerm(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new GlossaryTerm resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   String parent = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString();
   *   GlossaryTerm term = GlossaryTerm.newBuilder().build();
   *   String termId = "termId-877206873";
   *   GlossaryTerm response =
   *       businessGlossaryServiceClient.createGlossaryTerm(parent, term, termId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where the GlossaryTerm will be created. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/glossaries/{glossary_id} where
   *     `location_id` refers to a Google Cloud region.
   * @param term Required. The GlossaryTerm to create.
   * @param termId Required. GlossaryTerm identifier.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlossaryTerm createGlossaryTerm(String parent, GlossaryTerm term, String termId) {
    CreateGlossaryTermRequest request =
        CreateGlossaryTermRequest.newBuilder()
            .setParent(parent)
            .setTerm(term)
            .setTermId(termId)
            .build();
    return createGlossaryTerm(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new GlossaryTerm resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   CreateGlossaryTermRequest request =
   *       CreateGlossaryTermRequest.newBuilder()
   *           .setParent(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .setTermId("termId-877206873")
   *           .setTerm(GlossaryTerm.newBuilder().build())
   *           .build();
   *   GlossaryTerm response = businessGlossaryServiceClient.createGlossaryTerm(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlossaryTerm createGlossaryTerm(CreateGlossaryTermRequest request) {
    return createGlossaryTermCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new GlossaryTerm resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   CreateGlossaryTermRequest request =
   *       CreateGlossaryTermRequest.newBuilder()
   *           .setParent(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .setTermId("termId-877206873")
   *           .setTerm(GlossaryTerm.newBuilder().build())
   *           .build();
   *   ApiFuture<GlossaryTerm> future =
   *       businessGlossaryServiceClient.createGlossaryTermCallable().futureCall(request);
   *   // Do something.
   *   GlossaryTerm response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateGlossaryTermRequest, GlossaryTerm> createGlossaryTermCallable() {
    return stub.createGlossaryTermCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a GlossaryTerm resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   GlossaryTerm term = GlossaryTerm.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   GlossaryTerm response = businessGlossaryServiceClient.updateGlossaryTerm(term, updateMask);
   * }
   * }</pre>
   *
   * @param term Required. The GlossaryTerm to update. The GlossaryTerm's `name` field is used to
   *     identify the GlossaryTerm to update. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/glossaries/{glossary_id}/terms/{term_id}
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlossaryTerm updateGlossaryTerm(GlossaryTerm term, FieldMask updateMask) {
    UpdateGlossaryTermRequest request =
        UpdateGlossaryTermRequest.newBuilder().setTerm(term).setUpdateMask(updateMask).build();
    return updateGlossaryTerm(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a GlossaryTerm resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   UpdateGlossaryTermRequest request =
   *       UpdateGlossaryTermRequest.newBuilder()
   *           .setTerm(GlossaryTerm.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   GlossaryTerm response = businessGlossaryServiceClient.updateGlossaryTerm(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlossaryTerm updateGlossaryTerm(UpdateGlossaryTermRequest request) {
    return updateGlossaryTermCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a GlossaryTerm resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   UpdateGlossaryTermRequest request =
   *       UpdateGlossaryTermRequest.newBuilder()
   *           .setTerm(GlossaryTerm.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<GlossaryTerm> future =
   *       businessGlossaryServiceClient.updateGlossaryTermCallable().futureCall(request);
   *   // Do something.
   *   GlossaryTerm response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateGlossaryTermRequest, GlossaryTerm> updateGlossaryTermCallable() {
    return stub.updateGlossaryTermCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a GlossaryTerm resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   GlossaryTermName name =
   *       GlossaryTermName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_TERM]");
   *   businessGlossaryServiceClient.deleteGlossaryTerm(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the GlossaryTerm to delete. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/glossaries/{glossary_id}/terms/{term_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteGlossaryTerm(GlossaryTermName name) {
    DeleteGlossaryTermRequest request =
        DeleteGlossaryTermRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteGlossaryTerm(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a GlossaryTerm resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   String name =
   *       GlossaryTermName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_TERM]")
   *           .toString();
   *   businessGlossaryServiceClient.deleteGlossaryTerm(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the GlossaryTerm to delete. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/glossaries/{glossary_id}/terms/{term_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteGlossaryTerm(String name) {
    DeleteGlossaryTermRequest request =
        DeleteGlossaryTermRequest.newBuilder().setName(name).build();
    deleteGlossaryTerm(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a GlossaryTerm resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   DeleteGlossaryTermRequest request =
   *       DeleteGlossaryTermRequest.newBuilder()
   *           .setName(
   *               GlossaryTermName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_TERM]")
   *                   .toString())
   *           .build();
   *   businessGlossaryServiceClient.deleteGlossaryTerm(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteGlossaryTerm(DeleteGlossaryTermRequest request) {
    deleteGlossaryTermCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a GlossaryTerm resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   DeleteGlossaryTermRequest request =
   *       DeleteGlossaryTermRequest.newBuilder()
   *           .setName(
   *               GlossaryTermName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_TERM]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       businessGlossaryServiceClient.deleteGlossaryTermCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGlossaryTermRequest, Empty> deleteGlossaryTermCallable() {
    return stub.deleteGlossaryTermCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a GlossaryTerm resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   GlossaryTermName name =
   *       GlossaryTermName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_TERM]");
   *   GlossaryTerm response = businessGlossaryServiceClient.getGlossaryTerm(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the GlossaryTerm to retrieve. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/glossaries/{glossary_id}/terms/{term_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlossaryTerm getGlossaryTerm(GlossaryTermName name) {
    GetGlossaryTermRequest request =
        GetGlossaryTermRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getGlossaryTerm(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a GlossaryTerm resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   String name =
   *       GlossaryTermName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_TERM]")
   *           .toString();
   *   GlossaryTerm response = businessGlossaryServiceClient.getGlossaryTerm(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the GlossaryTerm to retrieve. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/glossaries/{glossary_id}/terms/{term_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlossaryTerm getGlossaryTerm(String name) {
    GetGlossaryTermRequest request = GetGlossaryTermRequest.newBuilder().setName(name).build();
    return getGlossaryTerm(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a GlossaryTerm resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   GetGlossaryTermRequest request =
   *       GetGlossaryTermRequest.newBuilder()
   *           .setName(
   *               GlossaryTermName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_TERM]")
   *                   .toString())
   *           .build();
   *   GlossaryTerm response = businessGlossaryServiceClient.getGlossaryTerm(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlossaryTerm getGlossaryTerm(GetGlossaryTermRequest request) {
    return getGlossaryTermCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a GlossaryTerm resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   GetGlossaryTermRequest request =
   *       GetGlossaryTermRequest.newBuilder()
   *           .setName(
   *               GlossaryTermName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]", "[GLOSSARY_TERM]")
   *                   .toString())
   *           .build();
   *   ApiFuture<GlossaryTerm> future =
   *       businessGlossaryServiceClient.getGlossaryTermCallable().futureCall(request);
   *   // Do something.
   *   GlossaryTerm response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGlossaryTermRequest, GlossaryTerm> getGlossaryTermCallable() {
    return stub.getGlossaryTermCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GlossaryTerm resources in a Glossary.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   GlossaryName parent = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]");
   *   for (GlossaryTerm element :
   *       businessGlossaryServiceClient.listGlossaryTerms(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which has this collection of GlossaryTerms. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/glossaries/{glossary_id} where
   *     `location_id` refers to a Google Cloud region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGlossaryTermsPagedResponse listGlossaryTerms(GlossaryName parent) {
    ListGlossaryTermsRequest request =
        ListGlossaryTermsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listGlossaryTerms(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GlossaryTerm resources in a Glossary.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   String parent = GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString();
   *   for (GlossaryTerm element :
   *       businessGlossaryServiceClient.listGlossaryTerms(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which has this collection of GlossaryTerms. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/glossaries/{glossary_id} where
   *     `location_id` refers to a Google Cloud region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGlossaryTermsPagedResponse listGlossaryTerms(String parent) {
    ListGlossaryTermsRequest request =
        ListGlossaryTermsRequest.newBuilder().setParent(parent).build();
    return listGlossaryTerms(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GlossaryTerm resources in a Glossary.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   ListGlossaryTermsRequest request =
   *       ListGlossaryTermsRequest.newBuilder()
   *           .setParent(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (GlossaryTerm element :
   *       businessGlossaryServiceClient.listGlossaryTerms(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGlossaryTermsPagedResponse listGlossaryTerms(ListGlossaryTermsRequest request) {
    return listGlossaryTermsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GlossaryTerm resources in a Glossary.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   ListGlossaryTermsRequest request =
   *       ListGlossaryTermsRequest.newBuilder()
   *           .setParent(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<GlossaryTerm> future =
   *       businessGlossaryServiceClient.listGlossaryTermsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (GlossaryTerm element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGlossaryTermsRequest, ListGlossaryTermsPagedResponse>
      listGlossaryTermsPagedCallable() {
    return stub.listGlossaryTermsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GlossaryTerm resources in a Glossary.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   ListGlossaryTermsRequest request =
   *       ListGlossaryTermsRequest.newBuilder()
   *           .setParent(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListGlossaryTermsResponse response =
   *         businessGlossaryServiceClient.listGlossaryTermsCallable().call(request);
   *     for (GlossaryTerm element : response.getTermsList()) {
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
  public final UnaryCallable<ListGlossaryTermsRequest, ListGlossaryTermsResponse>
      listGlossaryTermsCallable() {
    return stub.listGlossaryTermsCallable();
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
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : businessGlossaryServiceClient.listLocations(request).iterateAll()) {
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
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       businessGlossaryServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         businessGlossaryServiceClient.listLocationsCallable().call(request);
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
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = businessGlossaryServiceClient.getLocation(request);
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
   * try (BusinessGlossaryServiceClient businessGlossaryServiceClient =
   *     BusinessGlossaryServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       businessGlossaryServiceClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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

  public static class ListGlossariesPagedResponse
      extends AbstractPagedListResponse<
          ListGlossariesRequest,
          ListGlossariesResponse,
          Glossary,
          ListGlossariesPage,
          ListGlossariesFixedSizeCollection> {

    public static ApiFuture<ListGlossariesPagedResponse> createAsync(
        PageContext<ListGlossariesRequest, ListGlossariesResponse, Glossary> context,
        ApiFuture<ListGlossariesResponse> futureResponse) {
      ApiFuture<ListGlossariesPage> futurePage =
          ListGlossariesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListGlossariesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListGlossariesPagedResponse(ListGlossariesPage page) {
      super(page, ListGlossariesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGlossariesPage
      extends AbstractPage<
          ListGlossariesRequest, ListGlossariesResponse, Glossary, ListGlossariesPage> {

    private ListGlossariesPage(
        PageContext<ListGlossariesRequest, ListGlossariesResponse, Glossary> context,
        ListGlossariesResponse response) {
      super(context, response);
    }

    private static ListGlossariesPage createEmptyPage() {
      return new ListGlossariesPage(null, null);
    }

    @Override
    protected ListGlossariesPage createPage(
        PageContext<ListGlossariesRequest, ListGlossariesResponse, Glossary> context,
        ListGlossariesResponse response) {
      return new ListGlossariesPage(context, response);
    }

    @Override
    public ApiFuture<ListGlossariesPage> createPageAsync(
        PageContext<ListGlossariesRequest, ListGlossariesResponse, Glossary> context,
        ApiFuture<ListGlossariesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGlossariesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGlossariesRequest,
          ListGlossariesResponse,
          Glossary,
          ListGlossariesPage,
          ListGlossariesFixedSizeCollection> {

    private ListGlossariesFixedSizeCollection(List<ListGlossariesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGlossariesFixedSizeCollection createEmptyCollection() {
      return new ListGlossariesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGlossariesFixedSizeCollection createCollection(
        List<ListGlossariesPage> pages, int collectionSize) {
      return new ListGlossariesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListGlossaryCategoriesPagedResponse
      extends AbstractPagedListResponse<
          ListGlossaryCategoriesRequest,
          ListGlossaryCategoriesResponse,
          GlossaryCategory,
          ListGlossaryCategoriesPage,
          ListGlossaryCategoriesFixedSizeCollection> {

    public static ApiFuture<ListGlossaryCategoriesPagedResponse> createAsync(
        PageContext<ListGlossaryCategoriesRequest, ListGlossaryCategoriesResponse, GlossaryCategory>
            context,
        ApiFuture<ListGlossaryCategoriesResponse> futureResponse) {
      ApiFuture<ListGlossaryCategoriesPage> futurePage =
          ListGlossaryCategoriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListGlossaryCategoriesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListGlossaryCategoriesPagedResponse(ListGlossaryCategoriesPage page) {
      super(page, ListGlossaryCategoriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGlossaryCategoriesPage
      extends AbstractPage<
          ListGlossaryCategoriesRequest,
          ListGlossaryCategoriesResponse,
          GlossaryCategory,
          ListGlossaryCategoriesPage> {

    private ListGlossaryCategoriesPage(
        PageContext<ListGlossaryCategoriesRequest, ListGlossaryCategoriesResponse, GlossaryCategory>
            context,
        ListGlossaryCategoriesResponse response) {
      super(context, response);
    }

    private static ListGlossaryCategoriesPage createEmptyPage() {
      return new ListGlossaryCategoriesPage(null, null);
    }

    @Override
    protected ListGlossaryCategoriesPage createPage(
        PageContext<ListGlossaryCategoriesRequest, ListGlossaryCategoriesResponse, GlossaryCategory>
            context,
        ListGlossaryCategoriesResponse response) {
      return new ListGlossaryCategoriesPage(context, response);
    }

    @Override
    public ApiFuture<ListGlossaryCategoriesPage> createPageAsync(
        PageContext<ListGlossaryCategoriesRequest, ListGlossaryCategoriesResponse, GlossaryCategory>
            context,
        ApiFuture<ListGlossaryCategoriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGlossaryCategoriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGlossaryCategoriesRequest,
          ListGlossaryCategoriesResponse,
          GlossaryCategory,
          ListGlossaryCategoriesPage,
          ListGlossaryCategoriesFixedSizeCollection> {

    private ListGlossaryCategoriesFixedSizeCollection(
        List<ListGlossaryCategoriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGlossaryCategoriesFixedSizeCollection createEmptyCollection() {
      return new ListGlossaryCategoriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGlossaryCategoriesFixedSizeCollection createCollection(
        List<ListGlossaryCategoriesPage> pages, int collectionSize) {
      return new ListGlossaryCategoriesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListGlossaryTermsPagedResponse
      extends AbstractPagedListResponse<
          ListGlossaryTermsRequest,
          ListGlossaryTermsResponse,
          GlossaryTerm,
          ListGlossaryTermsPage,
          ListGlossaryTermsFixedSizeCollection> {

    public static ApiFuture<ListGlossaryTermsPagedResponse> createAsync(
        PageContext<ListGlossaryTermsRequest, ListGlossaryTermsResponse, GlossaryTerm> context,
        ApiFuture<ListGlossaryTermsResponse> futureResponse) {
      ApiFuture<ListGlossaryTermsPage> futurePage =
          ListGlossaryTermsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListGlossaryTermsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListGlossaryTermsPagedResponse(ListGlossaryTermsPage page) {
      super(page, ListGlossaryTermsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGlossaryTermsPage
      extends AbstractPage<
          ListGlossaryTermsRequest,
          ListGlossaryTermsResponse,
          GlossaryTerm,
          ListGlossaryTermsPage> {

    private ListGlossaryTermsPage(
        PageContext<ListGlossaryTermsRequest, ListGlossaryTermsResponse, GlossaryTerm> context,
        ListGlossaryTermsResponse response) {
      super(context, response);
    }

    private static ListGlossaryTermsPage createEmptyPage() {
      return new ListGlossaryTermsPage(null, null);
    }

    @Override
    protected ListGlossaryTermsPage createPage(
        PageContext<ListGlossaryTermsRequest, ListGlossaryTermsResponse, GlossaryTerm> context,
        ListGlossaryTermsResponse response) {
      return new ListGlossaryTermsPage(context, response);
    }

    @Override
    public ApiFuture<ListGlossaryTermsPage> createPageAsync(
        PageContext<ListGlossaryTermsRequest, ListGlossaryTermsResponse, GlossaryTerm> context,
        ApiFuture<ListGlossaryTermsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGlossaryTermsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGlossaryTermsRequest,
          ListGlossaryTermsResponse,
          GlossaryTerm,
          ListGlossaryTermsPage,
          ListGlossaryTermsFixedSizeCollection> {

    private ListGlossaryTermsFixedSizeCollection(
        List<ListGlossaryTermsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGlossaryTermsFixedSizeCollection createEmptyCollection() {
      return new ListGlossaryTermsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGlossaryTermsFixedSizeCollection createCollection(
        List<ListGlossaryTermsPage> pages, int collectionSize) {
      return new ListGlossaryTermsFixedSizeCollection(pages, collectionSize);
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
