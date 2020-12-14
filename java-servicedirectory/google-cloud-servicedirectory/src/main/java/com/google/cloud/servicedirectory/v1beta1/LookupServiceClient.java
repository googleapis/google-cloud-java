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

package com.google.cloud.servicedirectory.v1beta1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.servicedirectory.v1beta1.stub.LookupServiceStub;
import com.google.cloud.servicedirectory.v1beta1.stub.LookupServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service Directory API for looking up service data at runtime.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the LookupServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of LookupServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * LookupServiceSettings lookupServiceSettings =
 *     LookupServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LookupServiceClient lookupServiceClient = LookupServiceClient.create(lookupServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * LookupServiceSettings lookupServiceSettings =
 *     LookupServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LookupServiceClient lookupServiceClient = LookupServiceClient.create(lookupServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
public class LookupServiceClient implements BackgroundResource {
  private final LookupServiceSettings settings;
  private final LookupServiceStub stub;

  /** Constructs an instance of LookupServiceClient with default settings. */
  public static final LookupServiceClient create() throws IOException {
    return create(LookupServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LookupServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LookupServiceClient create(LookupServiceSettings settings)
      throws IOException {
    return new LookupServiceClient(settings);
  }

  /**
   * Constructs an instance of LookupServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(LookupServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final LookupServiceClient create(LookupServiceStub stub) {
    return new LookupServiceClient(stub);
  }

  /**
   * Constructs an instance of LookupServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected LookupServiceClient(LookupServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LookupServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected LookupServiceClient(LookupServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final LookupServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public LookupServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a [service][google.cloud.servicedirectory.v1beta1.Service] and its associated
   * endpoints. Resolving a service is not considered an active developer method.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResolveServiceResponse resolveService(ResolveServiceRequest request) {
    return resolveServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a [service][google.cloud.servicedirectory.v1beta1.Service] and its associated
   * endpoints. Resolving a service is not considered an active developer method.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ResolveServiceRequest, ResolveServiceResponse>
      resolveServiceCallable() {
    return stub.resolveServiceCallable();
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
