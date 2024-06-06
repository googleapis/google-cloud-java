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

package com.google.shopping.merchant.accounts.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.shopping.merchant.accounts.v1beta.stub.ProgramsServiceStub;
import com.google.shopping.merchant.accounts.v1beta.stub.ProgramsServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for program management.
 *
 * <p>Programs provide a mechanism for adding functionality to merchant accounts. A typical example
 * of this is the [Free product
 * listings](https://support.google.com/merchants/topic/9240261?ref_topic=7257954,7259405,&amp;sjid=796648681813264022-EU)
 * program, which enables products from a merchant's store to be shown across Google for free.
 *
 * <p>This service exposes methods to retrieve a merchant's participation in all available programs,
 * in addition to methods for explicitly enabling or disabling participation in each program.
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
 * try (ProgramsServiceClient programsServiceClient = ProgramsServiceClient.create()) {
 *   ProgramName name = ProgramName.of("[ACCOUNT]", "[PROGRAM]");
 *   Program response = programsServiceClient.getProgram(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ProgramsServiceClient object to clean up resources
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
 *      <td><p> GetProgram</td>
 *      <td><p> Retrieves the specified program for the account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getProgram(GetProgramRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getProgram(ProgramName name)
 *           <li><p> getProgram(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getProgramCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPrograms</td>
 *      <td><p> Retrieves all programs for the account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPrograms(ListProgramsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPrograms(AccountName parent)
 *           <li><p> listPrograms(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listProgramsPagedCallable()
 *           <li><p> listProgramsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> EnableProgram</td>
 *      <td><p> Enable participation in the specified program for the account. Executing this method requires admin access.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> enableProgram(EnableProgramRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> enableProgram(ProgramName name)
 *           <li><p> enableProgram(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> enableProgramCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DisableProgram</td>
 *      <td><p> Disable participation in the specified program for the account. Executing this method requires admin access.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> disableProgram(DisableProgramRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> disableProgram(ProgramName name)
 *           <li><p> disableProgram(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> disableProgramCallable()
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
 * <p>This class can be customized by passing in a custom instance of ProgramsServiceSettings to
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
 * ProgramsServiceSettings programsServiceSettings =
 *     ProgramsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ProgramsServiceClient programsServiceClient =
 *     ProgramsServiceClient.create(programsServiceSettings);
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
 * ProgramsServiceSettings programsServiceSettings =
 *     ProgramsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ProgramsServiceClient programsServiceClient =
 *     ProgramsServiceClient.create(programsServiceSettings);
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
 * ProgramsServiceSettings programsServiceSettings =
 *     ProgramsServiceSettings.newHttpJsonBuilder().build();
 * ProgramsServiceClient programsServiceClient =
 *     ProgramsServiceClient.create(programsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ProgramsServiceClient implements BackgroundResource {
  private final ProgramsServiceSettings settings;
  private final ProgramsServiceStub stub;

  /** Constructs an instance of ProgramsServiceClient with default settings. */
  public static final ProgramsServiceClient create() throws IOException {
    return create(ProgramsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ProgramsServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ProgramsServiceClient create(ProgramsServiceSettings settings)
      throws IOException {
    return new ProgramsServiceClient(settings);
  }

  /**
   * Constructs an instance of ProgramsServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ProgramsServiceSettings).
   */
  public static final ProgramsServiceClient create(ProgramsServiceStub stub) {
    return new ProgramsServiceClient(stub);
  }

  /**
   * Constructs an instance of ProgramsServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ProgramsServiceClient(ProgramsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ProgramsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ProgramsServiceClient(ProgramsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ProgramsServiceSettings getSettings() {
    return settings;
  }

  public ProgramsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified program for the account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgramsServiceClient programsServiceClient = ProgramsServiceClient.create()) {
   *   ProgramName name = ProgramName.of("[ACCOUNT]", "[PROGRAM]");
   *   Program response = programsServiceClient.getProgram(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the program to retrieve. Format:
   *     `accounts/{account}/programs/{program}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Program getProgram(ProgramName name) {
    GetProgramRequest request =
        GetProgramRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getProgram(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified program for the account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgramsServiceClient programsServiceClient = ProgramsServiceClient.create()) {
   *   String name = ProgramName.of("[ACCOUNT]", "[PROGRAM]").toString();
   *   Program response = programsServiceClient.getProgram(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the program to retrieve. Format:
   *     `accounts/{account}/programs/{program}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Program getProgram(String name) {
    GetProgramRequest request = GetProgramRequest.newBuilder().setName(name).build();
    return getProgram(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified program for the account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgramsServiceClient programsServiceClient = ProgramsServiceClient.create()) {
   *   GetProgramRequest request =
   *       GetProgramRequest.newBuilder()
   *           .setName(ProgramName.of("[ACCOUNT]", "[PROGRAM]").toString())
   *           .build();
   *   Program response = programsServiceClient.getProgram(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Program getProgram(GetProgramRequest request) {
    return getProgramCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified program for the account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgramsServiceClient programsServiceClient = ProgramsServiceClient.create()) {
   *   GetProgramRequest request =
   *       GetProgramRequest.newBuilder()
   *           .setName(ProgramName.of("[ACCOUNT]", "[PROGRAM]").toString())
   *           .build();
   *   ApiFuture<Program> future = programsServiceClient.getProgramCallable().futureCall(request);
   *   // Do something.
   *   Program response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetProgramRequest, Program> getProgramCallable() {
    return stub.getProgramCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves all programs for the account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgramsServiceClient programsServiceClient = ProgramsServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   for (Program element : programsServiceClient.listPrograms(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the account for which to retrieve all programs. Format:
   *     `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProgramsPagedResponse listPrograms(AccountName parent) {
    ListProgramsRequest request =
        ListProgramsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPrograms(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves all programs for the account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgramsServiceClient programsServiceClient = ProgramsServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   for (Program element : programsServiceClient.listPrograms(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the account for which to retrieve all programs. Format:
   *     `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProgramsPagedResponse listPrograms(String parent) {
    ListProgramsRequest request = ListProgramsRequest.newBuilder().setParent(parent).build();
    return listPrograms(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves all programs for the account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgramsServiceClient programsServiceClient = ProgramsServiceClient.create()) {
   *   ListProgramsRequest request =
   *       ListProgramsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Program element : programsServiceClient.listPrograms(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProgramsPagedResponse listPrograms(ListProgramsRequest request) {
    return listProgramsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves all programs for the account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgramsServiceClient programsServiceClient = ProgramsServiceClient.create()) {
   *   ListProgramsRequest request =
   *       ListProgramsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Program> future =
   *       programsServiceClient.listProgramsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Program element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListProgramsRequest, ListProgramsPagedResponse>
      listProgramsPagedCallable() {
    return stub.listProgramsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves all programs for the account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgramsServiceClient programsServiceClient = ProgramsServiceClient.create()) {
   *   ListProgramsRequest request =
   *       ListProgramsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListProgramsResponse response = programsServiceClient.listProgramsCallable().call(request);
   *     for (Program element : response.getProgramsList()) {
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
  public final UnaryCallable<ListProgramsRequest, ListProgramsResponse> listProgramsCallable() {
    return stub.listProgramsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable participation in the specified program for the account. Executing this method requires
   * admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgramsServiceClient programsServiceClient = ProgramsServiceClient.create()) {
   *   ProgramName name = ProgramName.of("[ACCOUNT]", "[PROGRAM]");
   *   Program response = programsServiceClient.enableProgram(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the program for which to enable participation for the given
   *     account. Format: `accounts/{account}/programs/{program}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Program enableProgram(ProgramName name) {
    EnableProgramRequest request =
        EnableProgramRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return enableProgram(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable participation in the specified program for the account. Executing this method requires
   * admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgramsServiceClient programsServiceClient = ProgramsServiceClient.create()) {
   *   String name = ProgramName.of("[ACCOUNT]", "[PROGRAM]").toString();
   *   Program response = programsServiceClient.enableProgram(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the program for which to enable participation for the given
   *     account. Format: `accounts/{account}/programs/{program}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Program enableProgram(String name) {
    EnableProgramRequest request = EnableProgramRequest.newBuilder().setName(name).build();
    return enableProgram(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable participation in the specified program for the account. Executing this method requires
   * admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgramsServiceClient programsServiceClient = ProgramsServiceClient.create()) {
   *   EnableProgramRequest request =
   *       EnableProgramRequest.newBuilder()
   *           .setName(ProgramName.of("[ACCOUNT]", "[PROGRAM]").toString())
   *           .build();
   *   Program response = programsServiceClient.enableProgram(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Program enableProgram(EnableProgramRequest request) {
    return enableProgramCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable participation in the specified program for the account. Executing this method requires
   * admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgramsServiceClient programsServiceClient = ProgramsServiceClient.create()) {
   *   EnableProgramRequest request =
   *       EnableProgramRequest.newBuilder()
   *           .setName(ProgramName.of("[ACCOUNT]", "[PROGRAM]").toString())
   *           .build();
   *   ApiFuture<Program> future = programsServiceClient.enableProgramCallable().futureCall(request);
   *   // Do something.
   *   Program response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EnableProgramRequest, Program> enableProgramCallable() {
    return stub.enableProgramCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable participation in the specified program for the account. Executing this method requires
   * admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgramsServiceClient programsServiceClient = ProgramsServiceClient.create()) {
   *   ProgramName name = ProgramName.of("[ACCOUNT]", "[PROGRAM]");
   *   Program response = programsServiceClient.disableProgram(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the program for which to disable participation for the given
   *     account. Format: `accounts/{account}/programs/{program}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Program disableProgram(ProgramName name) {
    DisableProgramRequest request =
        DisableProgramRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return disableProgram(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable participation in the specified program for the account. Executing this method requires
   * admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgramsServiceClient programsServiceClient = ProgramsServiceClient.create()) {
   *   String name = ProgramName.of("[ACCOUNT]", "[PROGRAM]").toString();
   *   Program response = programsServiceClient.disableProgram(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the program for which to disable participation for the given
   *     account. Format: `accounts/{account}/programs/{program}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Program disableProgram(String name) {
    DisableProgramRequest request = DisableProgramRequest.newBuilder().setName(name).build();
    return disableProgram(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable participation in the specified program for the account. Executing this method requires
   * admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgramsServiceClient programsServiceClient = ProgramsServiceClient.create()) {
   *   DisableProgramRequest request =
   *       DisableProgramRequest.newBuilder()
   *           .setName(ProgramName.of("[ACCOUNT]", "[PROGRAM]").toString())
   *           .build();
   *   Program response = programsServiceClient.disableProgram(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Program disableProgram(DisableProgramRequest request) {
    return disableProgramCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable participation in the specified program for the account. Executing this method requires
   * admin access.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProgramsServiceClient programsServiceClient = ProgramsServiceClient.create()) {
   *   DisableProgramRequest request =
   *       DisableProgramRequest.newBuilder()
   *           .setName(ProgramName.of("[ACCOUNT]", "[PROGRAM]").toString())
   *           .build();
   *   ApiFuture<Program> future =
   *       programsServiceClient.disableProgramCallable().futureCall(request);
   *   // Do something.
   *   Program response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DisableProgramRequest, Program> disableProgramCallable() {
    return stub.disableProgramCallable();
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

  public static class ListProgramsPagedResponse
      extends AbstractPagedListResponse<
          ListProgramsRequest,
          ListProgramsResponse,
          Program,
          ListProgramsPage,
          ListProgramsFixedSizeCollection> {

    public static ApiFuture<ListProgramsPagedResponse> createAsync(
        PageContext<ListProgramsRequest, ListProgramsResponse, Program> context,
        ApiFuture<ListProgramsResponse> futureResponse) {
      ApiFuture<ListProgramsPage> futurePage =
          ListProgramsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListProgramsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListProgramsPagedResponse(ListProgramsPage page) {
      super(page, ListProgramsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListProgramsPage
      extends AbstractPage<ListProgramsRequest, ListProgramsResponse, Program, ListProgramsPage> {

    private ListProgramsPage(
        PageContext<ListProgramsRequest, ListProgramsResponse, Program> context,
        ListProgramsResponse response) {
      super(context, response);
    }

    private static ListProgramsPage createEmptyPage() {
      return new ListProgramsPage(null, null);
    }

    @Override
    protected ListProgramsPage createPage(
        PageContext<ListProgramsRequest, ListProgramsResponse, Program> context,
        ListProgramsResponse response) {
      return new ListProgramsPage(context, response);
    }

    @Override
    public ApiFuture<ListProgramsPage> createPageAsync(
        PageContext<ListProgramsRequest, ListProgramsResponse, Program> context,
        ApiFuture<ListProgramsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListProgramsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListProgramsRequest,
          ListProgramsResponse,
          Program,
          ListProgramsPage,
          ListProgramsFixedSizeCollection> {

    private ListProgramsFixedSizeCollection(List<ListProgramsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListProgramsFixedSizeCollection createEmptyCollection() {
      return new ListProgramsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListProgramsFixedSizeCollection createCollection(
        List<ListProgramsPage> pages, int collectionSize) {
      return new ListProgramsFixedSizeCollection(pages, collectionSize);
    }
  }
}
