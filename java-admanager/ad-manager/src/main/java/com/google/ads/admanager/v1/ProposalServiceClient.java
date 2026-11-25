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

package com.google.ads.admanager.v1;

import com.google.ads.admanager.v1.stub.ProposalServiceStub;
import com.google.ads.admanager.v1.stub.ProposalServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling `Proposal` objects.
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
 * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
 *   ProposalName name = ProposalName.of("[NETWORK_CODE]", "[PROPOSAL]");
 *   Proposal response = proposalServiceClient.getProposal(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ProposalServiceClient object to clean up resources
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
 *      <td><p> GetProposal</td>
 *      <td><p> Retrieves a `Proposal` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getProposal(GetProposalRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getProposal(ProposalName name)
 *           <li><p> getProposal(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getProposalCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListProposals</td>
 *      <td><p> Lists `Proposal` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listProposals(ListProposalsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listProposals(NetworkName parent)
 *           <li><p> listProposals(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listProposalsPagedCallable()
 *           <li><p> listProposalsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateProposal</td>
 *      <td><p> Creates a `Proposal` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createProposal(CreateProposalRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createProposal(NetworkName parent, Proposal proposal)
 *           <li><p> createProposal(String parent, Proposal proposal)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createProposalCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateProposals</td>
 *      <td><p> Creates `Proposal` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateProposals(NetworkName parent, List&lt;CreateProposalRequest&gt; requests)
 *           <li><p> batchCreateProposals(String parent, List&lt;CreateProposalRequest&gt; requests)
 *           <li><p> batchCreateProposals(BatchCreateProposalsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateProposalsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateProposal</td>
 *      <td><p> Updates a `Proposal` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateProposal(UpdateProposalRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateProposal(Proposal proposal, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateProposalCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateProposals</td>
 *      <td><p> Batch updates `Proposal` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateProposals(NetworkName parent, List&lt;UpdateProposalRequest&gt; requests)
 *           <li><p> batchUpdateProposals(String parent, List&lt;UpdateProposalRequest&gt; requests)
 *           <li><p> batchUpdateProposals(BatchUpdateProposalsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateProposalsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchArchiveProposals</td>
 *      <td><p> Archives `Proposal` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchArchiveProposals(BatchArchiveProposalsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchArchiveProposals(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchArchiveProposals(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchArchiveProposalsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUnarchiveProposals</td>
 *      <td><p> Unarchives `Proposal` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUnarchiveProposals(BatchUnarchiveProposalsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchUnarchiveProposals(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchUnarchiveProposals(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUnarchiveProposalsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchPauseProposals</td>
 *      <td><p> Pauses `Proposal` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchPauseProposals(BatchPauseProposalsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchPauseProposals(NetworkName parent, List&lt;String&gt; names, String reason)
 *           <li><p> batchPauseProposals(String parent, List&lt;String&gt; names, String reason)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchPauseProposalsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchResumeProposals</td>
 *      <td><p> Resumes `Proposal` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchResumeProposals(BatchResumeProposalsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchResumeProposals(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchResumeProposals(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchResumeProposalsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchRequestBuyerReviewProposals</td>
 *      <td><p> Requests buyer review for `Proposal` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchRequestBuyerReviewProposals(BatchRequestBuyerReviewProposalsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchRequestBuyerReviewProposals(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchRequestBuyerReviewProposals(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchRequestBuyerReviewProposalsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchRequestBuyerAcceptProposals</td>
 *      <td><p> Requests buyer acceptance for `Proposal` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchRequestBuyerAcceptProposals(BatchRequestBuyerAcceptProposalsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchRequestBuyerAcceptProposals(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchRequestBuyerAcceptProposals(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchRequestBuyerAcceptProposalsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchReserveProposals</td>
 *      <td><p> Reserves inventory for `Proposal` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchReserveProposals(BatchReserveProposalsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchReserveProposals(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchReserveProposals(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchReserveProposalsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchRedraftProposals</td>
 *      <td><p> Redrafts `Proposal` objects for negotiation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchRedraftProposals(BatchRedraftProposalsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchRedraftProposals(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchRedraftProposals(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchRedraftProposalsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDiscardDraftProposals</td>
 *      <td><p> Discards drafts, or revert local modifications, of `Proposal` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDiscardDraftProposals(BatchDiscardDraftProposalsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchDiscardDraftProposals(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchDiscardDraftProposals(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDiscardDraftProposalsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchTerminateProposals</td>
 *      <td><p> Terminates negotiation on `Proposal` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchTerminateProposals(BatchTerminateProposalsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchTerminateProposals(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchTerminateProposals(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchTerminateProposalsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchPushToOrderProposals</td>
 *      <td><p> Push changes on `Proposal`s to corresponding `Order`s, after negotiations have been finalized.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchPushToOrderProposals(BatchPushToOrderProposalsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchPushToOrderProposals(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchPushToOrderProposals(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchPushToOrderProposalsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchMarketplaceComments</td>
 *      <td><p> Fetches MarketplaceComments made on `Proposal`s.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchMarketplaceComments(FetchMarketplaceCommentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> fetchMarketplaceComments(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> fetchMarketplaceComments(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchMarketplaceCommentsPagedCallable()
 *           <li><p> fetchMarketplaceCommentsCallable()
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
 * <p>This class can be customized by passing in a custom instance of ProposalServiceSettings to
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
 * ProposalServiceSettings proposalServiceSettings =
 *     ProposalServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ProposalServiceClient proposalServiceClient =
 *     ProposalServiceClient.create(proposalServiceSettings);
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
 * ProposalServiceSettings proposalServiceSettings =
 *     ProposalServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ProposalServiceClient proposalServiceClient =
 *     ProposalServiceClient.create(proposalServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class ProposalServiceClient implements BackgroundResource {
  private final @Nullable ProposalServiceSettings settings;
  private final ProposalServiceStub stub;

  /** Constructs an instance of ProposalServiceClient with default settings. */
  public static final ProposalServiceClient create() throws IOException {
    return create(ProposalServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ProposalServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ProposalServiceClient create(ProposalServiceSettings settings)
      throws IOException {
    return new ProposalServiceClient(settings);
  }

  /**
   * Constructs an instance of ProposalServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ProposalServiceSettings).
   */
  public static final ProposalServiceClient create(ProposalServiceStub stub) {
    return new ProposalServiceClient(stub);
  }

  /**
   * Constructs an instance of ProposalServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ProposalServiceClient(ProposalServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ProposalServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ProposalServiceClient(ProposalServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable ProposalServiceSettings getSettings() {
    return settings;
  }

  public ProposalServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `Proposal` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   ProposalName name = ProposalName.of("[NETWORK_CODE]", "[PROPOSAL]");
   *   Proposal response = proposalServiceClient.getProposal(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Proposal. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Proposal getProposal(@Nullable ProposalName name) {
    GetProposalRequest request =
        GetProposalRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getProposal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `Proposal` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   String name = ProposalName.of("[NETWORK_CODE]", "[PROPOSAL]").toString();
   *   Proposal response = proposalServiceClient.getProposal(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Proposal. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Proposal getProposal(String name) {
    GetProposalRequest request = GetProposalRequest.newBuilder().setName(name).build();
    return getProposal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `Proposal` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   GetProposalRequest request =
   *       GetProposalRequest.newBuilder()
   *           .setName(ProposalName.of("[NETWORK_CODE]", "[PROPOSAL]").toString())
   *           .build();
   *   Proposal response = proposalServiceClient.getProposal(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Proposal getProposal(GetProposalRequest request) {
    return getProposalCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `Proposal` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   GetProposalRequest request =
   *       GetProposalRequest.newBuilder()
   *           .setName(ProposalName.of("[NETWORK_CODE]", "[PROPOSAL]").toString())
   *           .build();
   *   ApiFuture<Proposal> future = proposalServiceClient.getProposalCallable().futureCall(request);
   *   // Do something.
   *   Proposal response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetProposalRequest, Proposal> getProposalCallable() {
    return stub.getProposalCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (Proposal element : proposalServiceClient.listProposals(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Proposals. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProposalsPagedResponse listProposals(@Nullable NetworkName parent) {
    ListProposalsRequest request =
        ListProposalsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (Proposal element : proposalServiceClient.listProposals(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Proposals. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProposalsPagedResponse listProposals(String parent) {
    ListProposalsRequest request = ListProposalsRequest.newBuilder().setParent(parent).build();
    return listProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   ListProposalsRequest request =
   *       ListProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (Proposal element : proposalServiceClient.listProposals(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProposalsPagedResponse listProposals(ListProposalsRequest request) {
    return listProposalsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   ListProposalsRequest request =
   *       ListProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<Proposal> future =
   *       proposalServiceClient.listProposalsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Proposal element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListProposalsRequest, ListProposalsPagedResponse>
      listProposalsPagedCallable() {
    return stub.listProposalsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   ListProposalsRequest request =
   *       ListProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListProposalsResponse response =
   *         proposalServiceClient.listProposalsCallable().call(request);
   *     for (Proposal element : response.getProposalsList()) {
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
  public final UnaryCallable<ListProposalsRequest, ListProposalsResponse> listProposalsCallable() {
    return stub.listProposalsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `Proposal` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   Proposal proposal = Proposal.newBuilder().build();
   *   Proposal response = proposalServiceClient.createProposal(parent, proposal);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `Proposal` will be created. Format:
   *     `networks/{network_code}`
   * @param proposal Required. The `Proposal` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Proposal createProposal(@Nullable NetworkName parent, Proposal proposal) {
    CreateProposalRequest request =
        CreateProposalRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setProposal(proposal)
            .build();
    return createProposal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `Proposal` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   Proposal proposal = Proposal.newBuilder().build();
   *   Proposal response = proposalServiceClient.createProposal(parent, proposal);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `Proposal` will be created. Format:
   *     `networks/{network_code}`
   * @param proposal Required. The `Proposal` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Proposal createProposal(String parent, Proposal proposal) {
    CreateProposalRequest request =
        CreateProposalRequest.newBuilder().setParent(parent).setProposal(proposal).build();
    return createProposal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `Proposal` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   CreateProposalRequest request =
   *       CreateProposalRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setProposal(Proposal.newBuilder().build())
   *           .build();
   *   Proposal response = proposalServiceClient.createProposal(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Proposal createProposal(CreateProposalRequest request) {
    return createProposalCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `Proposal` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   CreateProposalRequest request =
   *       CreateProposalRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setProposal(Proposal.newBuilder().build())
   *           .build();
   *   ApiFuture<Proposal> future =
   *       proposalServiceClient.createProposalCallable().futureCall(request);
   *   // Do something.
   *   Proposal response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateProposalRequest, Proposal> createProposalCallable() {
    return stub.createProposalCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreateProposalRequest> requests = new ArrayList<>();
   *   BatchCreateProposalsResponse response =
   *       proposalServiceClient.batchCreateProposals(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Proposals` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateProposalRequest must match this
   *     field.
   * @param requests Required. The `Proposal` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateProposalsResponse batchCreateProposals(
      @Nullable NetworkName parent, List<CreateProposalRequest> requests) {
    BatchCreateProposalsRequest request =
        BatchCreateProposalsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreateProposalRequest> requests = new ArrayList<>();
   *   BatchCreateProposalsResponse response =
   *       proposalServiceClient.batchCreateProposals(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Proposals` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateProposalRequest must match this
   *     field.
   * @param requests Required. The `Proposal` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateProposalsResponse batchCreateProposals(
      String parent, List<CreateProposalRequest> requests) {
    BatchCreateProposalsRequest request =
        BatchCreateProposalsRequest.newBuilder().setParent(parent).addAllRequests(requests).build();
    return batchCreateProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchCreateProposalsRequest request =
   *       BatchCreateProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateProposalRequest>())
   *           .build();
   *   BatchCreateProposalsResponse response = proposalServiceClient.batchCreateProposals(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateProposalsResponse batchCreateProposals(
      BatchCreateProposalsRequest request) {
    return batchCreateProposalsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchCreateProposalsRequest request =
   *       BatchCreateProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateProposalRequest>())
   *           .build();
   *   ApiFuture<BatchCreateProposalsResponse> future =
   *       proposalServiceClient.batchCreateProposalsCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateProposalsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateProposalsRequest, BatchCreateProposalsResponse>
      batchCreateProposalsCallable() {
    return stub.batchCreateProposalsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Proposal` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   Proposal proposal = Proposal.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Proposal response = proposalServiceClient.updateProposal(proposal, updateMask);
   * }
   * }</pre>
   *
   * @param proposal Required. The `Proposal` to update.
   *     <p>The `Proposal`'s `name` is used to identify the `Proposal` to update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Proposal updateProposal(Proposal proposal, FieldMask updateMask) {
    UpdateProposalRequest request =
        UpdateProposalRequest.newBuilder().setProposal(proposal).setUpdateMask(updateMask).build();
    return updateProposal(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Proposal` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   UpdateProposalRequest request =
   *       UpdateProposalRequest.newBuilder()
   *           .setProposal(Proposal.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Proposal response = proposalServiceClient.updateProposal(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Proposal updateProposal(UpdateProposalRequest request) {
    return updateProposalCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `Proposal` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   UpdateProposalRequest request =
   *       UpdateProposalRequest.newBuilder()
   *           .setProposal(Proposal.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Proposal> future =
   *       proposalServiceClient.updateProposalCallable().futureCall(request);
   *   // Do something.
   *   Proposal response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateProposalRequest, Proposal> updateProposalCallable() {
    return stub.updateProposalCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdateProposalRequest> requests = new ArrayList<>();
   *   BatchUpdateProposalsResponse response =
   *       proposalServiceClient.batchUpdateProposals(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Proposals` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateProposalRequest must match this
   *     field.
   * @param requests Required. The `Proposal` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateProposalsResponse batchUpdateProposals(
      @Nullable NetworkName parent, List<UpdateProposalRequest> requests) {
    BatchUpdateProposalsRequest request =
        BatchUpdateProposalsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdateProposalRequest> requests = new ArrayList<>();
   *   BatchUpdateProposalsResponse response =
   *       proposalServiceClient.batchUpdateProposals(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `Proposals` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateProposalRequest must match this
   *     field.
   * @param requests Required. The `Proposal` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateProposalsResponse batchUpdateProposals(
      String parent, List<UpdateProposalRequest> requests) {
    BatchUpdateProposalsRequest request =
        BatchUpdateProposalsRequest.newBuilder().setParent(parent).addAllRequests(requests).build();
    return batchUpdateProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchUpdateProposalsRequest request =
   *       BatchUpdateProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateProposalRequest>())
   *           .build();
   *   BatchUpdateProposalsResponse response = proposalServiceClient.batchUpdateProposals(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateProposalsResponse batchUpdateProposals(
      BatchUpdateProposalsRequest request) {
    return batchUpdateProposalsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchUpdateProposalsRequest request =
   *       BatchUpdateProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateProposalRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateProposalsResponse> future =
   *       proposalServiceClient.batchUpdateProposalsCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdateProposalsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdateProposalsRequest, BatchUpdateProposalsResponse>
      batchUpdateProposalsCallable() {
    return stub.batchUpdateProposalsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchArchiveProposalsResponse response =
   *       proposalServiceClient.batchArchiveProposals(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where proposals will be archived. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the Proposals to archive. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveProposalsResponse batchArchiveProposals(
      @Nullable NetworkName parent, List<String> names) {
    BatchArchiveProposalsRequest request =
        BatchArchiveProposalsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchArchiveProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchArchiveProposalsResponse response =
   *       proposalServiceClient.batchArchiveProposals(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where proposals will be archived. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the Proposals to archive. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveProposalsResponse batchArchiveProposals(
      String parent, List<String> names) {
    BatchArchiveProposalsRequest request =
        BatchArchiveProposalsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchArchiveProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchArchiveProposalsRequest request =
   *       BatchArchiveProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchArchiveProposalsResponse response = proposalServiceClient.batchArchiveProposals(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveProposalsResponse batchArchiveProposals(
      BatchArchiveProposalsRequest request) {
    return batchArchiveProposalsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Archives `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchArchiveProposalsRequest request =
   *       BatchArchiveProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchArchiveProposalsResponse> future =
   *       proposalServiceClient.batchArchiveProposalsCallable().futureCall(request);
   *   // Do something.
   *   BatchArchiveProposalsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchArchiveProposalsRequest, BatchArchiveProposalsResponse>
      batchArchiveProposalsCallable() {
    return stub.batchArchiveProposalsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unarchives `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchUnarchiveProposalsResponse response =
   *       proposalServiceClient.batchUnarchiveProposals(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where proposals will be unarchived. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the Proposals to unarchive. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUnarchiveProposalsResponse batchUnarchiveProposals(
      @Nullable NetworkName parent, List<String> names) {
    BatchUnarchiveProposalsRequest request =
        BatchUnarchiveProposalsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchUnarchiveProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unarchives `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchUnarchiveProposalsResponse response =
   *       proposalServiceClient.batchUnarchiveProposals(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where proposals will be unarchived. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the Proposals to unarchive. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUnarchiveProposalsResponse batchUnarchiveProposals(
      String parent, List<String> names) {
    BatchUnarchiveProposalsRequest request =
        BatchUnarchiveProposalsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchUnarchiveProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unarchives `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchUnarchiveProposalsRequest request =
   *       BatchUnarchiveProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchUnarchiveProposalsResponse response =
   *       proposalServiceClient.batchUnarchiveProposals(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUnarchiveProposalsResponse batchUnarchiveProposals(
      BatchUnarchiveProposalsRequest request) {
    return batchUnarchiveProposalsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unarchives `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchUnarchiveProposalsRequest request =
   *       BatchUnarchiveProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchUnarchiveProposalsResponse> future =
   *       proposalServiceClient.batchUnarchiveProposalsCallable().futureCall(request);
   *   // Do something.
   *   BatchUnarchiveProposalsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUnarchiveProposalsRequest, BatchUnarchiveProposalsResponse>
      batchUnarchiveProposalsCallable() {
    return stub.batchUnarchiveProposalsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   String reason = "reason-934964668";
   *   BatchPauseProposalsResponse response =
   *       proposalServiceClient.batchPauseProposals(parent, names, reason);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where proposals will be paused. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the Proposals to pause. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @param reason Required. The reason for pausing the Proposals.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchPauseProposalsResponse batchPauseProposals(
      @Nullable NetworkName parent, List<String> names, String reason) {
    BatchPauseProposalsRequest request =
        BatchPauseProposalsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .setReason(reason)
            .build();
    return batchPauseProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   String reason = "reason-934964668";
   *   BatchPauseProposalsResponse response =
   *       proposalServiceClient.batchPauseProposals(parent, names, reason);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where proposals will be paused. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the Proposals to pause. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @param reason Required. The reason for pausing the Proposals.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchPauseProposalsResponse batchPauseProposals(
      String parent, List<String> names, String reason) {
    BatchPauseProposalsRequest request =
        BatchPauseProposalsRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .setReason(reason)
            .build();
    return batchPauseProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchPauseProposalsRequest request =
   *       BatchPauseProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setReason("reason-934964668")
   *           .build();
   *   BatchPauseProposalsResponse response = proposalServiceClient.batchPauseProposals(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchPauseProposalsResponse batchPauseProposals(BatchPauseProposalsRequest request) {
    return batchPauseProposalsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchPauseProposalsRequest request =
   *       BatchPauseProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setReason("reason-934964668")
   *           .build();
   *   ApiFuture<BatchPauseProposalsResponse> future =
   *       proposalServiceClient.batchPauseProposalsCallable().futureCall(request);
   *   // Do something.
   *   BatchPauseProposalsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchPauseProposalsRequest, BatchPauseProposalsResponse>
      batchPauseProposalsCallable() {
    return stub.batchPauseProposalsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchResumeProposalsResponse response =
   *       proposalServiceClient.batchResumeProposals(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where proposals will be resumed. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the Proposals to resume. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchResumeProposalsResponse batchResumeProposals(
      @Nullable NetworkName parent, List<String> names) {
    BatchResumeProposalsRequest request =
        BatchResumeProposalsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchResumeProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchResumeProposalsResponse response =
   *       proposalServiceClient.batchResumeProposals(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where proposals will be resumed. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the Proposals to resume. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchResumeProposalsResponse batchResumeProposals(
      String parent, List<String> names) {
    BatchResumeProposalsRequest request =
        BatchResumeProposalsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchResumeProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchResumeProposalsRequest request =
   *       BatchResumeProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchResumeProposalsResponse response = proposalServiceClient.batchResumeProposals(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchResumeProposalsResponse batchResumeProposals(
      BatchResumeProposalsRequest request) {
    return batchResumeProposalsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchResumeProposalsRequest request =
   *       BatchResumeProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchResumeProposalsResponse> future =
   *       proposalServiceClient.batchResumeProposalsCallable().futureCall(request);
   *   // Do something.
   *   BatchResumeProposalsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchResumeProposalsRequest, BatchResumeProposalsResponse>
      batchResumeProposalsCallable() {
    return stub.batchResumeProposalsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests buyer review for `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchRequestBuyerReviewProposalsResponse response =
   *       proposalServiceClient.batchRequestBuyerReviewProposals(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where proposals will be reviewed. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the Proposals to request buyer review. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRequestBuyerReviewProposalsResponse batchRequestBuyerReviewProposals(
      @Nullable NetworkName parent, List<String> names) {
    BatchRequestBuyerReviewProposalsRequest request =
        BatchRequestBuyerReviewProposalsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchRequestBuyerReviewProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests buyer review for `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchRequestBuyerReviewProposalsResponse response =
   *       proposalServiceClient.batchRequestBuyerReviewProposals(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where proposals will be reviewed. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the Proposals to request buyer review. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRequestBuyerReviewProposalsResponse batchRequestBuyerReviewProposals(
      String parent, List<String> names) {
    BatchRequestBuyerReviewProposalsRequest request =
        BatchRequestBuyerReviewProposalsRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchRequestBuyerReviewProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests buyer review for `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchRequestBuyerReviewProposalsRequest request =
   *       BatchRequestBuyerReviewProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchRequestBuyerReviewProposalsResponse response =
   *       proposalServiceClient.batchRequestBuyerReviewProposals(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRequestBuyerReviewProposalsResponse batchRequestBuyerReviewProposals(
      BatchRequestBuyerReviewProposalsRequest request) {
    return batchRequestBuyerReviewProposalsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests buyer review for `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchRequestBuyerReviewProposalsRequest request =
   *       BatchRequestBuyerReviewProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchRequestBuyerReviewProposalsResponse> future =
   *       proposalServiceClient.batchRequestBuyerReviewProposalsCallable().futureCall(request);
   *   // Do something.
   *   BatchRequestBuyerReviewProposalsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchRequestBuyerReviewProposalsRequest, BatchRequestBuyerReviewProposalsResponse>
      batchRequestBuyerReviewProposalsCallable() {
    return stub.batchRequestBuyerReviewProposalsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests buyer acceptance for `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchRequestBuyerAcceptProposalsResponse response =
   *       proposalServiceClient.batchRequestBuyerAcceptProposals(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where proposals will be accepted. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the Proposals to request buyer accept. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRequestBuyerAcceptProposalsResponse batchRequestBuyerAcceptProposals(
      @Nullable NetworkName parent, List<String> names) {
    BatchRequestBuyerAcceptProposalsRequest request =
        BatchRequestBuyerAcceptProposalsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchRequestBuyerAcceptProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests buyer acceptance for `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchRequestBuyerAcceptProposalsResponse response =
   *       proposalServiceClient.batchRequestBuyerAcceptProposals(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where proposals will be accepted. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the Proposals to request buyer accept. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRequestBuyerAcceptProposalsResponse batchRequestBuyerAcceptProposals(
      String parent, List<String> names) {
    BatchRequestBuyerAcceptProposalsRequest request =
        BatchRequestBuyerAcceptProposalsRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchRequestBuyerAcceptProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests buyer acceptance for `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchRequestBuyerAcceptProposalsRequest request =
   *       BatchRequestBuyerAcceptProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setOverbookingAllowed(true)
   *           .build();
   *   BatchRequestBuyerAcceptProposalsResponse response =
   *       proposalServiceClient.batchRequestBuyerAcceptProposals(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRequestBuyerAcceptProposalsResponse batchRequestBuyerAcceptProposals(
      BatchRequestBuyerAcceptProposalsRequest request) {
    return batchRequestBuyerAcceptProposalsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests buyer acceptance for `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchRequestBuyerAcceptProposalsRequest request =
   *       BatchRequestBuyerAcceptProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setOverbookingAllowed(true)
   *           .build();
   *   ApiFuture<BatchRequestBuyerAcceptProposalsResponse> future =
   *       proposalServiceClient.batchRequestBuyerAcceptProposalsCallable().futureCall(request);
   *   // Do something.
   *   BatchRequestBuyerAcceptProposalsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchRequestBuyerAcceptProposalsRequest, BatchRequestBuyerAcceptProposalsResponse>
      batchRequestBuyerAcceptProposalsCallable() {
    return stub.batchRequestBuyerAcceptProposalsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reserves inventory for `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchReserveProposalsResponse response =
   *       proposalServiceClient.batchReserveProposals(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where proposals will be reserved. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the Proposals to reserve. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchReserveProposalsResponse batchReserveProposals(
      @Nullable NetworkName parent, List<String> names) {
    BatchReserveProposalsRequest request =
        BatchReserveProposalsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchReserveProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reserves inventory for `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchReserveProposalsResponse response =
   *       proposalServiceClient.batchReserveProposals(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where proposals will be reserved. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the Proposals to reserve. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchReserveProposalsResponse batchReserveProposals(
      String parent, List<String> names) {
    BatchReserveProposalsRequest request =
        BatchReserveProposalsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchReserveProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reserves inventory for `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchReserveProposalsRequest request =
   *       BatchReserveProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setOverbookingAllowed(true)
   *           .build();
   *   BatchReserveProposalsResponse response = proposalServiceClient.batchReserveProposals(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchReserveProposalsResponse batchReserveProposals(
      BatchReserveProposalsRequest request) {
    return batchReserveProposalsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reserves inventory for `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchReserveProposalsRequest request =
   *       BatchReserveProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setOverbookingAllowed(true)
   *           .build();
   *   ApiFuture<BatchReserveProposalsResponse> future =
   *       proposalServiceClient.batchReserveProposalsCallable().futureCall(request);
   *   // Do something.
   *   BatchReserveProposalsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchReserveProposalsRequest, BatchReserveProposalsResponse>
      batchReserveProposalsCallable() {
    return stub.batchReserveProposalsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Redrafts `Proposal` objects for negotiation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchRedraftProposalsResponse response =
   *       proposalServiceClient.batchRedraftProposals(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where proposals will be redrafted. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the Proposals to redraft. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRedraftProposalsResponse batchRedraftProposals(
      @Nullable NetworkName parent, List<String> names) {
    BatchRedraftProposalsRequest request =
        BatchRedraftProposalsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchRedraftProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Redrafts `Proposal` objects for negotiation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchRedraftProposalsResponse response =
   *       proposalServiceClient.batchRedraftProposals(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where proposals will be redrafted. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the Proposals to redraft. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRedraftProposalsResponse batchRedraftProposals(
      String parent, List<String> names) {
    BatchRedraftProposalsRequest request =
        BatchRedraftProposalsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchRedraftProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Redrafts `Proposal` objects for negotiation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchRedraftProposalsRequest request =
   *       BatchRedraftProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchRedraftProposalsResponse response = proposalServiceClient.batchRedraftProposals(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRedraftProposalsResponse batchRedraftProposals(
      BatchRedraftProposalsRequest request) {
    return batchRedraftProposalsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Redrafts `Proposal` objects for negotiation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchRedraftProposalsRequest request =
   *       BatchRedraftProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchRedraftProposalsResponse> future =
   *       proposalServiceClient.batchRedraftProposalsCallable().futureCall(request);
   *   // Do something.
   *   BatchRedraftProposalsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchRedraftProposalsRequest, BatchRedraftProposalsResponse>
      batchRedraftProposalsCallable() {
    return stub.batchRedraftProposalsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Discards drafts, or revert local modifications, of `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchDiscardDraftProposalsResponse response =
   *       proposalServiceClient.batchDiscardDraftProposals(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where proposals will be discarded. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the Proposals to discard. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDiscardDraftProposalsResponse batchDiscardDraftProposals(
      @Nullable NetworkName parent, List<String> names) {
    BatchDiscardDraftProposalsRequest request =
        BatchDiscardDraftProposalsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchDiscardDraftProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Discards drafts, or revert local modifications, of `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchDiscardDraftProposalsResponse response =
   *       proposalServiceClient.batchDiscardDraftProposals(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where proposals will be discarded. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the Proposals to discard. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDiscardDraftProposalsResponse batchDiscardDraftProposals(
      String parent, List<String> names) {
    BatchDiscardDraftProposalsRequest request =
        BatchDiscardDraftProposalsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchDiscardDraftProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Discards drafts, or revert local modifications, of `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchDiscardDraftProposalsRequest request =
   *       BatchDiscardDraftProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchDiscardDraftProposalsResponse response =
   *       proposalServiceClient.batchDiscardDraftProposals(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchDiscardDraftProposalsResponse batchDiscardDraftProposals(
      BatchDiscardDraftProposalsRequest request) {
    return batchDiscardDraftProposalsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Discards drafts, or revert local modifications, of `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchDiscardDraftProposalsRequest request =
   *       BatchDiscardDraftProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchDiscardDraftProposalsResponse> future =
   *       proposalServiceClient.batchDiscardDraftProposalsCallable().futureCall(request);
   *   // Do something.
   *   BatchDiscardDraftProposalsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDiscardDraftProposalsRequest, BatchDiscardDraftProposalsResponse>
      batchDiscardDraftProposalsCallable() {
    return stub.batchDiscardDraftProposalsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Terminates negotiation on `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchTerminateProposalsResponse response =
   *       proposalServiceClient.batchTerminateProposals(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where proposals will be terminated. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the Proposals to terminate. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchTerminateProposalsResponse batchTerminateProposals(
      @Nullable NetworkName parent, List<String> names) {
    BatchTerminateProposalsRequest request =
        BatchTerminateProposalsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchTerminateProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Terminates negotiation on `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchTerminateProposalsResponse response =
   *       proposalServiceClient.batchTerminateProposals(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where proposals will be terminated. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the Proposals to terminate. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchTerminateProposalsResponse batchTerminateProposals(
      String parent, List<String> names) {
    BatchTerminateProposalsRequest request =
        BatchTerminateProposalsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchTerminateProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Terminates negotiation on `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchTerminateProposalsRequest request =
   *       BatchTerminateProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchTerminateProposalsResponse response =
   *       proposalServiceClient.batchTerminateProposals(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchTerminateProposalsResponse batchTerminateProposals(
      BatchTerminateProposalsRequest request) {
    return batchTerminateProposalsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Terminates negotiation on `Proposal` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchTerminateProposalsRequest request =
   *       BatchTerminateProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchTerminateProposalsResponse> future =
   *       proposalServiceClient.batchTerminateProposalsCallable().futureCall(request);
   *   // Do something.
   *   BatchTerminateProposalsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchTerminateProposalsRequest, BatchTerminateProposalsResponse>
      batchTerminateProposalsCallable() {
    return stub.batchTerminateProposalsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Push changes on `Proposal`s to corresponding `Order`s, after negotiations have been finalized.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchPushToOrderProposalsResponse response =
   *       proposalServiceClient.batchPushToOrderProposals(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where proposals will be pushed to order. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the Proposals to push to order. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchPushToOrderProposalsResponse batchPushToOrderProposals(
      @Nullable NetworkName parent, List<String> names) {
    BatchPushToOrderProposalsRequest request =
        BatchPushToOrderProposalsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchPushToOrderProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Push changes on `Proposal`s to corresponding `Order`s, after negotiations have been finalized.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchPushToOrderProposalsResponse response =
   *       proposalServiceClient.batchPushToOrderProposals(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where proposals will be pushed to order. Format:
   *     `networks/{network_code}`
   * @param names Required. The resource names of the Proposals to push to order. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchPushToOrderProposalsResponse batchPushToOrderProposals(
      String parent, List<String> names) {
    BatchPushToOrderProposalsRequest request =
        BatchPushToOrderProposalsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchPushToOrderProposals(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Push changes on `Proposal`s to corresponding `Order`s, after negotiations have been finalized.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchPushToOrderProposalsRequest request =
   *       BatchPushToOrderProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchPushToOrderProposalsResponse response =
   *       proposalServiceClient.batchPushToOrderProposals(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchPushToOrderProposalsResponse batchPushToOrderProposals(
      BatchPushToOrderProposalsRequest request) {
    return batchPushToOrderProposalsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Push changes on `Proposal`s to corresponding `Order`s, after negotiations have been finalized.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   BatchPushToOrderProposalsRequest request =
   *       BatchPushToOrderProposalsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchPushToOrderProposalsResponse> future =
   *       proposalServiceClient.batchPushToOrderProposalsCallable().futureCall(request);
   *   // Do something.
   *   BatchPushToOrderProposalsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchPushToOrderProposalsRequest, BatchPushToOrderProposalsResponse>
      batchPushToOrderProposalsCallable() {
    return stub.batchPushToOrderProposalsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches MarketplaceComments made on `Proposal`s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   for (MarketplaceComment element :
   *       proposalServiceClient.fetchMarketplaceComments(parent, names).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where MarketplaceComments will be fetched from.
   *     Format: `networks/{network_code}`
   * @param names Required. The resource names of the Proposals for which to fetch marketplace
   *     comments. A maximum of 50 proposal names can be specified. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchMarketplaceCommentsPagedResponse fetchMarketplaceComments(
      @Nullable NetworkName parent, List<String> names) {
    FetchMarketplaceCommentsRequest request =
        FetchMarketplaceCommentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return fetchMarketplaceComments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches MarketplaceComments made on `Proposal`s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   for (MarketplaceComment element :
   *       proposalServiceClient.fetchMarketplaceComments(parent, names).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where MarketplaceComments will be fetched from.
   *     Format: `networks/{network_code}`
   * @param names Required. The resource names of the Proposals for which to fetch marketplace
   *     comments. A maximum of 50 proposal names can be specified. Format:
   *     `networks/{network_code}/proposals/{proposal_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchMarketplaceCommentsPagedResponse fetchMarketplaceComments(
      String parent, List<String> names) {
    FetchMarketplaceCommentsRequest request =
        FetchMarketplaceCommentsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return fetchMarketplaceComments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches MarketplaceComments made on `Proposal`s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   FetchMarketplaceCommentsRequest request =
   *       FetchMarketplaceCommentsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setSkip(3532159)
   *           .build();
   *   for (MarketplaceComment element :
   *       proposalServiceClient.fetchMarketplaceComments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchMarketplaceCommentsPagedResponse fetchMarketplaceComments(
      FetchMarketplaceCommentsRequest request) {
    return fetchMarketplaceCommentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches MarketplaceComments made on `Proposal`s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   FetchMarketplaceCommentsRequest request =
   *       FetchMarketplaceCommentsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<MarketplaceComment> future =
   *       proposalServiceClient.fetchMarketplaceCommentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MarketplaceComment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchMarketplaceCommentsRequest, FetchMarketplaceCommentsPagedResponse>
      fetchMarketplaceCommentsPagedCallable() {
    return stub.fetchMarketplaceCommentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches MarketplaceComments made on `Proposal`s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProposalServiceClient proposalServiceClient = ProposalServiceClient.create()) {
   *   FetchMarketplaceCommentsRequest request =
   *       FetchMarketplaceCommentsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     FetchMarketplaceCommentsResponse response =
   *         proposalServiceClient.fetchMarketplaceCommentsCallable().call(request);
   *     for (MarketplaceComment element : response.getMarketplaceCommentsList()) {
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
  public final UnaryCallable<FetchMarketplaceCommentsRequest, FetchMarketplaceCommentsResponse>
      fetchMarketplaceCommentsCallable() {
    return stub.fetchMarketplaceCommentsCallable();
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

  public static class ListProposalsPagedResponse
      extends AbstractPagedListResponse<
          ListProposalsRequest,
          ListProposalsResponse,
          Proposal,
          ListProposalsPage,
          ListProposalsFixedSizeCollection> {

    public static ApiFuture<ListProposalsPagedResponse> createAsync(
        PageContext<ListProposalsRequest, ListProposalsResponse, Proposal> context,
        ApiFuture<ListProposalsResponse> futureResponse) {
      ApiFuture<ListProposalsPage> futurePage =
          ListProposalsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListProposalsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListProposalsPagedResponse(ListProposalsPage page) {
      super(page, ListProposalsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListProposalsPage
      extends AbstractPage<
          ListProposalsRequest, ListProposalsResponse, Proposal, ListProposalsPage> {

    private ListProposalsPage(
        @Nullable PageContext<ListProposalsRequest, ListProposalsResponse, Proposal> context,
        @Nullable ListProposalsResponse response) {
      super(context, response);
    }

    private static ListProposalsPage createEmptyPage() {
      return new ListProposalsPage(null, null);
    }

    @Override
    protected ListProposalsPage createPage(
        @Nullable PageContext<ListProposalsRequest, ListProposalsResponse, Proposal> context,
        @Nullable ListProposalsResponse response) {
      return new ListProposalsPage(context, response);
    }

    @Override
    public ApiFuture<ListProposalsPage> createPageAsync(
        @Nullable PageContext<ListProposalsRequest, ListProposalsResponse, Proposal> context,
        ApiFuture<ListProposalsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListProposalsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListProposalsRequest,
          ListProposalsResponse,
          Proposal,
          ListProposalsPage,
          ListProposalsFixedSizeCollection> {

    private ListProposalsFixedSizeCollection(
        @Nullable List<ListProposalsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListProposalsFixedSizeCollection createEmptyCollection() {
      return new ListProposalsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListProposalsFixedSizeCollection createCollection(
        @Nullable List<ListProposalsPage> pages, int collectionSize) {
      return new ListProposalsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class FetchMarketplaceCommentsPagedResponse
      extends AbstractPagedListResponse<
          FetchMarketplaceCommentsRequest,
          FetchMarketplaceCommentsResponse,
          MarketplaceComment,
          FetchMarketplaceCommentsPage,
          FetchMarketplaceCommentsFixedSizeCollection> {

    public static ApiFuture<FetchMarketplaceCommentsPagedResponse> createAsync(
        PageContext<
                FetchMarketplaceCommentsRequest,
                FetchMarketplaceCommentsResponse,
                MarketplaceComment>
            context,
        ApiFuture<FetchMarketplaceCommentsResponse> futureResponse) {
      ApiFuture<FetchMarketplaceCommentsPage> futurePage =
          FetchMarketplaceCommentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new FetchMarketplaceCommentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private FetchMarketplaceCommentsPagedResponse(FetchMarketplaceCommentsPage page) {
      super(page, FetchMarketplaceCommentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class FetchMarketplaceCommentsPage
      extends AbstractPage<
          FetchMarketplaceCommentsRequest,
          FetchMarketplaceCommentsResponse,
          MarketplaceComment,
          FetchMarketplaceCommentsPage> {

    private FetchMarketplaceCommentsPage(
        @Nullable
            PageContext<
                FetchMarketplaceCommentsRequest,
                FetchMarketplaceCommentsResponse,
                MarketplaceComment>
            context,
        @Nullable FetchMarketplaceCommentsResponse response) {
      super(context, response);
    }

    private static FetchMarketplaceCommentsPage createEmptyPage() {
      return new FetchMarketplaceCommentsPage(null, null);
    }

    @Override
    protected FetchMarketplaceCommentsPage createPage(
        @Nullable
            PageContext<
                FetchMarketplaceCommentsRequest,
                FetchMarketplaceCommentsResponse,
                MarketplaceComment>
            context,
        @Nullable FetchMarketplaceCommentsResponse response) {
      return new FetchMarketplaceCommentsPage(context, response);
    }

    @Override
    public ApiFuture<FetchMarketplaceCommentsPage> createPageAsync(
        @Nullable
            PageContext<
                FetchMarketplaceCommentsRequest,
                FetchMarketplaceCommentsResponse,
                MarketplaceComment>
            context,
        ApiFuture<FetchMarketplaceCommentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class FetchMarketplaceCommentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          FetchMarketplaceCommentsRequest,
          FetchMarketplaceCommentsResponse,
          MarketplaceComment,
          FetchMarketplaceCommentsPage,
          FetchMarketplaceCommentsFixedSizeCollection> {

    private FetchMarketplaceCommentsFixedSizeCollection(
        @Nullable List<FetchMarketplaceCommentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static FetchMarketplaceCommentsFixedSizeCollection createEmptyCollection() {
      return new FetchMarketplaceCommentsFixedSizeCollection(null, 0);
    }

    @Override
    protected FetchMarketplaceCommentsFixedSizeCollection createCollection(
        @Nullable List<FetchMarketplaceCommentsPage> pages, int collectionSize) {
      return new FetchMarketplaceCommentsFixedSizeCollection(pages, collectionSize);
    }
  }
}
