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

package google.cloud.chronicle.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import google.cloud.chronicle.v1.stub.DataAccessControlServiceStub;
import google.cloud.chronicle.v1.stub.DataAccessControlServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: DataAccessControlService exposes resources and endpoints related to data
 * access control.
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
 * try (DataAccessControlServiceClient dataAccessControlServiceClient =
 *     DataAccessControlServiceClient.create()) {
 *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   DataAccessLabel dataAccessLabel = DataAccessLabel.newBuilder().build();
 *   String dataAccessLabelId = "dataAccessLabelId1775298977";
 *   DataAccessLabel response =
 *       dataAccessControlServiceClient.createDataAccessLabel(
 *           parent, dataAccessLabel, dataAccessLabelId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DataAccessControlServiceClient object to clean up
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
 *      <td><p> CreateDataAccessLabel</td>
 *      <td><p> Creates a data access label. Data access labels are applied to incoming event data and selected in data access scopes (another resource), and only users with scopes containing the label can see data with that label. Currently, the data access label resource only includes custom labels, which are labels that correspond to UDM queries over event data.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDataAccessLabel(CreateDataAccessLabelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createDataAccessLabel(InstanceName parent, DataAccessLabel dataAccessLabel, String dataAccessLabelId)
 *           <li><p> createDataAccessLabel(String parent, DataAccessLabel dataAccessLabel, String dataAccessLabelId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDataAccessLabelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDataAccessLabel</td>
 *      <td><p> Gets a data access label.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDataAccessLabel(GetDataAccessLabelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDataAccessLabel(DataAccessLabelName name)
 *           <li><p> getDataAccessLabel(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDataAccessLabelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDataAccessLabels</td>
 *      <td><p> Lists all data access labels for the customer.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDataAccessLabels(ListDataAccessLabelsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDataAccessLabels(InstanceName parent)
 *           <li><p> listDataAccessLabels(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDataAccessLabelsPagedCallable()
 *           <li><p> listDataAccessLabelsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDataAccessLabel</td>
 *      <td><p> Updates a data access label.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDataAccessLabel(UpdateDataAccessLabelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDataAccessLabel(DataAccessLabel dataAccessLabel, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDataAccessLabelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDataAccessLabel</td>
 *      <td><p> Deletes a data access label. When a label is deleted, new data that enters in the system will not receive the label, but the label will not be removed from old data that still refers to it.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDataAccessLabel(DeleteDataAccessLabelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteDataAccessLabel(DataAccessLabelName name)
 *           <li><p> deleteDataAccessLabel(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDataAccessLabelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDataAccessScope</td>
 *      <td><p> Creates a data access scope. Data access scope is a combination of allowed and denied labels attached to a permission group. If a scope has allowed labels A and B and denied labels C and D, then the group of people attached to the scope will have permissions to see all events labeled with A or B (or both) and not labeled with either C or D.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDataAccessScope(CreateDataAccessScopeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createDataAccessScope(InstanceName parent, DataAccessScope dataAccessScope, String dataAccessScopeId)
 *           <li><p> createDataAccessScope(String parent, DataAccessScope dataAccessScope, String dataAccessScopeId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDataAccessScopeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDataAccessScope</td>
 *      <td><p> Retrieves an existing data access scope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDataAccessScope(GetDataAccessScopeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDataAccessScope(DataAccessScopeName name)
 *           <li><p> getDataAccessScope(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDataAccessScopeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDataAccessScopes</td>
 *      <td><p> Lists all existing data access scopes for the customer.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDataAccessScopes(ListDataAccessScopesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDataAccessScopes(InstanceName parent)
 *           <li><p> listDataAccessScopes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDataAccessScopesPagedCallable()
 *           <li><p> listDataAccessScopesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDataAccessScope</td>
 *      <td><p> Updates a data access scope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDataAccessScope(UpdateDataAccessScopeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDataAccessScope(DataAccessScope dataAccessScope, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDataAccessScopeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDataAccessScope</td>
 *      <td><p> Deletes a data access scope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDataAccessScope(DeleteDataAccessScopeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteDataAccessScope(DataAccessScopeName name)
 *           <li><p> deleteDataAccessScope(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDataAccessScopeCallable()
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
 * DataAccessControlServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataAccessControlServiceSettings dataAccessControlServiceSettings =
 *     DataAccessControlServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataAccessControlServiceClient dataAccessControlServiceClient =
 *     DataAccessControlServiceClient.create(dataAccessControlServiceSettings);
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
 * DataAccessControlServiceSettings dataAccessControlServiceSettings =
 *     DataAccessControlServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataAccessControlServiceClient dataAccessControlServiceClient =
 *     DataAccessControlServiceClient.create(dataAccessControlServiceSettings);
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
 * DataAccessControlServiceSettings dataAccessControlServiceSettings =
 *     DataAccessControlServiceSettings.newHttpJsonBuilder().build();
 * DataAccessControlServiceClient dataAccessControlServiceClient =
 *     DataAccessControlServiceClient.create(dataAccessControlServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DataAccessControlServiceClient implements BackgroundResource {
  private final DataAccessControlServiceSettings settings;
  private final DataAccessControlServiceStub stub;

  /** Constructs an instance of DataAccessControlServiceClient with default settings. */
  public static final DataAccessControlServiceClient create() throws IOException {
    return create(DataAccessControlServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataAccessControlServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final DataAccessControlServiceClient create(
      DataAccessControlServiceSettings settings) throws IOException {
    return new DataAccessControlServiceClient(settings);
  }

  /**
   * Constructs an instance of DataAccessControlServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(DataAccessControlServiceSettings).
   */
  public static final DataAccessControlServiceClient create(DataAccessControlServiceStub stub) {
    return new DataAccessControlServiceClient(stub);
  }

  /**
   * Constructs an instance of DataAccessControlServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected DataAccessControlServiceClient(DataAccessControlServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((DataAccessControlServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected DataAccessControlServiceClient(DataAccessControlServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DataAccessControlServiceSettings getSettings() {
    return settings;
  }

  public DataAccessControlServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a data access label. Data access labels are applied to incoming event data and selected
   * in data access scopes (another resource), and only users with scopes containing the label can
   * see data with that label. Currently, the data access label resource only includes custom
   * labels, which are labels that correspond to UDM queries over event data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   DataAccessLabel dataAccessLabel = DataAccessLabel.newBuilder().build();
   *   String dataAccessLabelId = "dataAccessLabelId1775298977";
   *   DataAccessLabel response =
   *       dataAccessControlServiceClient.createDataAccessLabel(
   *           parent, dataAccessLabel, dataAccessLabelId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this Data Access Label will be created.
   *     Format: `projects/{project}/locations/{location}/instances/{instance}`
   * @param dataAccessLabel Required. Data access label to create.
   * @param dataAccessLabelId Required. The ID to use for the data access label, which will become
   *     the label's display name and the final component of the label's resource name. The maximum
   *     number of characters should be 63. Regex pattern is as per AIP:
   *     https://google.aip.dev/122#resource-id-segments
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAccessLabel createDataAccessLabel(
      InstanceName parent, DataAccessLabel dataAccessLabel, String dataAccessLabelId) {
    CreateDataAccessLabelRequest request =
        CreateDataAccessLabelRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataAccessLabel(dataAccessLabel)
            .setDataAccessLabelId(dataAccessLabelId)
            .build();
    return createDataAccessLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a data access label. Data access labels are applied to incoming event data and selected
   * in data access scopes (another resource), and only users with scopes containing the label can
   * see data with that label. Currently, the data access label resource only includes custom
   * labels, which are labels that correspond to UDM queries over event data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   DataAccessLabel dataAccessLabel = DataAccessLabel.newBuilder().build();
   *   String dataAccessLabelId = "dataAccessLabelId1775298977";
   *   DataAccessLabel response =
   *       dataAccessControlServiceClient.createDataAccessLabel(
   *           parent, dataAccessLabel, dataAccessLabelId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this Data Access Label will be created.
   *     Format: `projects/{project}/locations/{location}/instances/{instance}`
   * @param dataAccessLabel Required. Data access label to create.
   * @param dataAccessLabelId Required. The ID to use for the data access label, which will become
   *     the label's display name and the final component of the label's resource name. The maximum
   *     number of characters should be 63. Regex pattern is as per AIP:
   *     https://google.aip.dev/122#resource-id-segments
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAccessLabel createDataAccessLabel(
      String parent, DataAccessLabel dataAccessLabel, String dataAccessLabelId) {
    CreateDataAccessLabelRequest request =
        CreateDataAccessLabelRequest.newBuilder()
            .setParent(parent)
            .setDataAccessLabel(dataAccessLabel)
            .setDataAccessLabelId(dataAccessLabelId)
            .build();
    return createDataAccessLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a data access label. Data access labels are applied to incoming event data and selected
   * in data access scopes (another resource), and only users with scopes containing the label can
   * see data with that label. Currently, the data access label resource only includes custom
   * labels, which are labels that correspond to UDM queries over event data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   CreateDataAccessLabelRequest request =
   *       CreateDataAccessLabelRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setDataAccessLabel(DataAccessLabel.newBuilder().build())
   *           .setDataAccessLabelId("dataAccessLabelId1775298977")
   *           .build();
   *   DataAccessLabel response = dataAccessControlServiceClient.createDataAccessLabel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAccessLabel createDataAccessLabel(CreateDataAccessLabelRequest request) {
    return createDataAccessLabelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a data access label. Data access labels are applied to incoming event data and selected
   * in data access scopes (another resource), and only users with scopes containing the label can
   * see data with that label. Currently, the data access label resource only includes custom
   * labels, which are labels that correspond to UDM queries over event data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   CreateDataAccessLabelRequest request =
   *       CreateDataAccessLabelRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setDataAccessLabel(DataAccessLabel.newBuilder().build())
   *           .setDataAccessLabelId("dataAccessLabelId1775298977")
   *           .build();
   *   ApiFuture<DataAccessLabel> future =
   *       dataAccessControlServiceClient.createDataAccessLabelCallable().futureCall(request);
   *   // Do something.
   *   DataAccessLabel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDataAccessLabelRequest, DataAccessLabel>
      createDataAccessLabelCallable() {
    return stub.createDataAccessLabelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a data access label.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   DataAccessLabelName name =
   *       DataAccessLabelName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]");
   *   DataAccessLabel response = dataAccessControlServiceClient.getDataAccessLabel(name);
   * }
   * }</pre>
   *
   * @param name Required. The ID of the data access label to retrieve. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/dataAccessLabels/{data_access_label}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAccessLabel getDataAccessLabel(DataAccessLabelName name) {
    GetDataAccessLabelRequest request =
        GetDataAccessLabelRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDataAccessLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a data access label.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   String name =
   *       DataAccessLabelName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]")
   *           .toString();
   *   DataAccessLabel response = dataAccessControlServiceClient.getDataAccessLabel(name);
   * }
   * }</pre>
   *
   * @param name Required. The ID of the data access label to retrieve. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/dataAccessLabels/{data_access_label}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAccessLabel getDataAccessLabel(String name) {
    GetDataAccessLabelRequest request =
        GetDataAccessLabelRequest.newBuilder().setName(name).build();
    return getDataAccessLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a data access label.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   GetDataAccessLabelRequest request =
   *       GetDataAccessLabelRequest.newBuilder()
   *           .setName(
   *               DataAccessLabelName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]")
   *                   .toString())
   *           .build();
   *   DataAccessLabel response = dataAccessControlServiceClient.getDataAccessLabel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAccessLabel getDataAccessLabel(GetDataAccessLabelRequest request) {
    return getDataAccessLabelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a data access label.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   GetDataAccessLabelRequest request =
   *       GetDataAccessLabelRequest.newBuilder()
   *           .setName(
   *               DataAccessLabelName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DataAccessLabel> future =
   *       dataAccessControlServiceClient.getDataAccessLabelCallable().futureCall(request);
   *   // Do something.
   *   DataAccessLabel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataAccessLabelRequest, DataAccessLabel>
      getDataAccessLabelCallable() {
    return stub.getDataAccessLabelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all data access labels for the customer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   for (DataAccessLabel element :
   *       dataAccessControlServiceClient.listDataAccessLabels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this data access label will be created.
   *     Format: `projects/{project}/locations/{location}/instances/{instance}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataAccessLabelsPagedResponse listDataAccessLabels(InstanceName parent) {
    ListDataAccessLabelsRequest request =
        ListDataAccessLabelsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDataAccessLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all data access labels for the customer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   for (DataAccessLabel element :
   *       dataAccessControlServiceClient.listDataAccessLabels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this data access label will be created.
   *     Format: `projects/{project}/locations/{location}/instances/{instance}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataAccessLabelsPagedResponse listDataAccessLabels(String parent) {
    ListDataAccessLabelsRequest request =
        ListDataAccessLabelsRequest.newBuilder().setParent(parent).build();
    return listDataAccessLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all data access labels for the customer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   ListDataAccessLabelsRequest request =
   *       ListDataAccessLabelsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (DataAccessLabel element :
   *       dataAccessControlServiceClient.listDataAccessLabels(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataAccessLabelsPagedResponse listDataAccessLabels(
      ListDataAccessLabelsRequest request) {
    return listDataAccessLabelsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all data access labels for the customer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   ListDataAccessLabelsRequest request =
   *       ListDataAccessLabelsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<DataAccessLabel> future =
   *       dataAccessControlServiceClient.listDataAccessLabelsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DataAccessLabel element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDataAccessLabelsRequest, ListDataAccessLabelsPagedResponse>
      listDataAccessLabelsPagedCallable() {
    return stub.listDataAccessLabelsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all data access labels for the customer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   ListDataAccessLabelsRequest request =
   *       ListDataAccessLabelsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListDataAccessLabelsResponse response =
   *         dataAccessControlServiceClient.listDataAccessLabelsCallable().call(request);
   *     for (DataAccessLabel element : response.getDataAccessLabelsList()) {
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
  public final UnaryCallable<ListDataAccessLabelsRequest, ListDataAccessLabelsResponse>
      listDataAccessLabelsCallable() {
    return stub.listDataAccessLabelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a data access label.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   DataAccessLabel dataAccessLabel = DataAccessLabel.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DataAccessLabel response =
   *       dataAccessControlServiceClient.updateDataAccessLabel(dataAccessLabel, updateMask);
   * }
   * }</pre>
   *
   * @param dataAccessLabel Required. The data access label to update.
   *     <p>The label's `name` field is used to identify the label to update. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/dataAccessLabels/{data_access_label}`
   * @param updateMask The list of fields to update. If not included, all fields with a non-empty
   *     value will be overwritten. Currently, only the description and definition fields are
   *     supported for update; an update call that attempts to update any other fields will return
   *     INVALID_ARGUMENT.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAccessLabel updateDataAccessLabel(
      DataAccessLabel dataAccessLabel, FieldMask updateMask) {
    UpdateDataAccessLabelRequest request =
        UpdateDataAccessLabelRequest.newBuilder()
            .setDataAccessLabel(dataAccessLabel)
            .setUpdateMask(updateMask)
            .build();
    return updateDataAccessLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a data access label.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   UpdateDataAccessLabelRequest request =
   *       UpdateDataAccessLabelRequest.newBuilder()
   *           .setDataAccessLabel(DataAccessLabel.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   DataAccessLabel response = dataAccessControlServiceClient.updateDataAccessLabel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAccessLabel updateDataAccessLabel(UpdateDataAccessLabelRequest request) {
    return updateDataAccessLabelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a data access label.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   UpdateDataAccessLabelRequest request =
   *       UpdateDataAccessLabelRequest.newBuilder()
   *           .setDataAccessLabel(DataAccessLabel.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<DataAccessLabel> future =
   *       dataAccessControlServiceClient.updateDataAccessLabelCallable().futureCall(request);
   *   // Do something.
   *   DataAccessLabel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDataAccessLabelRequest, DataAccessLabel>
      updateDataAccessLabelCallable() {
    return stub.updateDataAccessLabelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a data access label. When a label is deleted, new data that enters in the system will
   * not receive the label, but the label will not be removed from old data that still refers to it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   DataAccessLabelName name =
   *       DataAccessLabelName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]");
   *   dataAccessControlServiceClient.deleteDataAccessLabel(name);
   * }
   * }</pre>
   *
   * @param name Required. The ID of the data access label to delete. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/dataAccessLabels/{data_access_label}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataAccessLabel(DataAccessLabelName name) {
    DeleteDataAccessLabelRequest request =
        DeleteDataAccessLabelRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteDataAccessLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a data access label. When a label is deleted, new data that enters in the system will
   * not receive the label, but the label will not be removed from old data that still refers to it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   String name =
   *       DataAccessLabelName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]")
   *           .toString();
   *   dataAccessControlServiceClient.deleteDataAccessLabel(name);
   * }
   * }</pre>
   *
   * @param name Required. The ID of the data access label to delete. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/dataAccessLabels/{data_access_label}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataAccessLabel(String name) {
    DeleteDataAccessLabelRequest request =
        DeleteDataAccessLabelRequest.newBuilder().setName(name).build();
    deleteDataAccessLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a data access label. When a label is deleted, new data that enters in the system will
   * not receive the label, but the label will not be removed from old data that still refers to it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   DeleteDataAccessLabelRequest request =
   *       DeleteDataAccessLabelRequest.newBuilder()
   *           .setName(
   *               DataAccessLabelName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]")
   *                   .toString())
   *           .build();
   *   dataAccessControlServiceClient.deleteDataAccessLabel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataAccessLabel(DeleteDataAccessLabelRequest request) {
    deleteDataAccessLabelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a data access label. When a label is deleted, new data that enters in the system will
   * not receive the label, but the label will not be removed from old data that still refers to it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   DeleteDataAccessLabelRequest request =
   *       DeleteDataAccessLabelRequest.newBuilder()
   *           .setName(
   *               DataAccessLabelName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_LABEL]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       dataAccessControlServiceClient.deleteDataAccessLabelCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDataAccessLabelRequest, Empty> deleteDataAccessLabelCallable() {
    return stub.deleteDataAccessLabelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a data access scope. Data access scope is a combination of allowed and denied labels
   * attached to a permission group. If a scope has allowed labels A and B and denied labels C and
   * D, then the group of people attached to the scope will have permissions to see all events
   * labeled with A or B (or both) and not labeled with either C or D.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   DataAccessScope dataAccessScope = DataAccessScope.newBuilder().build();
   *   String dataAccessScopeId = "dataAccessScopeId-532524799";
   *   DataAccessScope response =
   *       dataAccessControlServiceClient.createDataAccessScope(
   *           parent, dataAccessScope, dataAccessScopeId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this Data Access Scope will be created.
   *     Format: `projects/{project}/locations/{location}/instances/{instance}`
   * @param dataAccessScope Required. Data access scope to create.
   * @param dataAccessScopeId Required. The user provided scope id which will become the last part
   *     of the name of the scope resource. Needs to be compliant with https://google.aip.dev/122
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAccessScope createDataAccessScope(
      InstanceName parent, DataAccessScope dataAccessScope, String dataAccessScopeId) {
    CreateDataAccessScopeRequest request =
        CreateDataAccessScopeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataAccessScope(dataAccessScope)
            .setDataAccessScopeId(dataAccessScopeId)
            .build();
    return createDataAccessScope(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a data access scope. Data access scope is a combination of allowed and denied labels
   * attached to a permission group. If a scope has allowed labels A and B and denied labels C and
   * D, then the group of people attached to the scope will have permissions to see all events
   * labeled with A or B (or both) and not labeled with either C or D.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   DataAccessScope dataAccessScope = DataAccessScope.newBuilder().build();
   *   String dataAccessScopeId = "dataAccessScopeId-532524799";
   *   DataAccessScope response =
   *       dataAccessControlServiceClient.createDataAccessScope(
   *           parent, dataAccessScope, dataAccessScopeId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this Data Access Scope will be created.
   *     Format: `projects/{project}/locations/{location}/instances/{instance}`
   * @param dataAccessScope Required. Data access scope to create.
   * @param dataAccessScopeId Required. The user provided scope id which will become the last part
   *     of the name of the scope resource. Needs to be compliant with https://google.aip.dev/122
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAccessScope createDataAccessScope(
      String parent, DataAccessScope dataAccessScope, String dataAccessScopeId) {
    CreateDataAccessScopeRequest request =
        CreateDataAccessScopeRequest.newBuilder()
            .setParent(parent)
            .setDataAccessScope(dataAccessScope)
            .setDataAccessScopeId(dataAccessScopeId)
            .build();
    return createDataAccessScope(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a data access scope. Data access scope is a combination of allowed and denied labels
   * attached to a permission group. If a scope has allowed labels A and B and denied labels C and
   * D, then the group of people attached to the scope will have permissions to see all events
   * labeled with A or B (or both) and not labeled with either C or D.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   CreateDataAccessScopeRequest request =
   *       CreateDataAccessScopeRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setDataAccessScope(DataAccessScope.newBuilder().build())
   *           .setDataAccessScopeId("dataAccessScopeId-532524799")
   *           .build();
   *   DataAccessScope response = dataAccessControlServiceClient.createDataAccessScope(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAccessScope createDataAccessScope(CreateDataAccessScopeRequest request) {
    return createDataAccessScopeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a data access scope. Data access scope is a combination of allowed and denied labels
   * attached to a permission group. If a scope has allowed labels A and B and denied labels C and
   * D, then the group of people attached to the scope will have permissions to see all events
   * labeled with A or B (or both) and not labeled with either C or D.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   CreateDataAccessScopeRequest request =
   *       CreateDataAccessScopeRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setDataAccessScope(DataAccessScope.newBuilder().build())
   *           .setDataAccessScopeId("dataAccessScopeId-532524799")
   *           .build();
   *   ApiFuture<DataAccessScope> future =
   *       dataAccessControlServiceClient.createDataAccessScopeCallable().futureCall(request);
   *   // Do something.
   *   DataAccessScope response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDataAccessScopeRequest, DataAccessScope>
      createDataAccessScopeCallable() {
    return stub.createDataAccessScopeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an existing data access scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   DataAccessScopeName name =
   *       DataAccessScopeName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]");
   *   DataAccessScope response = dataAccessControlServiceClient.getDataAccessScope(name);
   * }
   * }</pre>
   *
   * @param name Required. The ID of the data access scope to retrieve. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/dataAccessScopes/{data_access_scope}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAccessScope getDataAccessScope(DataAccessScopeName name) {
    GetDataAccessScopeRequest request =
        GetDataAccessScopeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDataAccessScope(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an existing data access scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   String name =
   *       DataAccessScopeName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]")
   *           .toString();
   *   DataAccessScope response = dataAccessControlServiceClient.getDataAccessScope(name);
   * }
   * }</pre>
   *
   * @param name Required. The ID of the data access scope to retrieve. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/dataAccessScopes/{data_access_scope}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAccessScope getDataAccessScope(String name) {
    GetDataAccessScopeRequest request =
        GetDataAccessScopeRequest.newBuilder().setName(name).build();
    return getDataAccessScope(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an existing data access scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   GetDataAccessScopeRequest request =
   *       GetDataAccessScopeRequest.newBuilder()
   *           .setName(
   *               DataAccessScopeName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]")
   *                   .toString())
   *           .build();
   *   DataAccessScope response = dataAccessControlServiceClient.getDataAccessScope(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAccessScope getDataAccessScope(GetDataAccessScopeRequest request) {
    return getDataAccessScopeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an existing data access scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   GetDataAccessScopeRequest request =
   *       GetDataAccessScopeRequest.newBuilder()
   *           .setName(
   *               DataAccessScopeName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DataAccessScope> future =
   *       dataAccessControlServiceClient.getDataAccessScopeCallable().futureCall(request);
   *   // Do something.
   *   DataAccessScope response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataAccessScopeRequest, DataAccessScope>
      getDataAccessScopeCallable() {
    return stub.getDataAccessScopeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all existing data access scopes for the customer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   for (DataAccessScope element :
   *       dataAccessControlServiceClient.listDataAccessScopes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this data access scope will be created.
   *     Format: `projects/{project}/locations/{location}/instances/{instance}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataAccessScopesPagedResponse listDataAccessScopes(InstanceName parent) {
    ListDataAccessScopesRequest request =
        ListDataAccessScopesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDataAccessScopes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all existing data access scopes for the customer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   for (DataAccessScope element :
   *       dataAccessControlServiceClient.listDataAccessScopes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this data access scope will be created.
   *     Format: `projects/{project}/locations/{location}/instances/{instance}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataAccessScopesPagedResponse listDataAccessScopes(String parent) {
    ListDataAccessScopesRequest request =
        ListDataAccessScopesRequest.newBuilder().setParent(parent).build();
    return listDataAccessScopes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all existing data access scopes for the customer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   ListDataAccessScopesRequest request =
   *       ListDataAccessScopesRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (DataAccessScope element :
   *       dataAccessControlServiceClient.listDataAccessScopes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataAccessScopesPagedResponse listDataAccessScopes(
      ListDataAccessScopesRequest request) {
    return listDataAccessScopesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all existing data access scopes for the customer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   ListDataAccessScopesRequest request =
   *       ListDataAccessScopesRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<DataAccessScope> future =
   *       dataAccessControlServiceClient.listDataAccessScopesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DataAccessScope element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDataAccessScopesRequest, ListDataAccessScopesPagedResponse>
      listDataAccessScopesPagedCallable() {
    return stub.listDataAccessScopesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all existing data access scopes for the customer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   ListDataAccessScopesRequest request =
   *       ListDataAccessScopesRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListDataAccessScopesResponse response =
   *         dataAccessControlServiceClient.listDataAccessScopesCallable().call(request);
   *     for (DataAccessScope element : response.getDataAccessScopesList()) {
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
  public final UnaryCallable<ListDataAccessScopesRequest, ListDataAccessScopesResponse>
      listDataAccessScopesCallable() {
    return stub.listDataAccessScopesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a data access scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   DataAccessScope dataAccessScope = DataAccessScope.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DataAccessScope response =
   *       dataAccessControlServiceClient.updateDataAccessScope(dataAccessScope, updateMask);
   * }
   * }</pre>
   *
   * @param dataAccessScope Required. The data access scope to update.
   *     <p>The scope's `name` field is used to identify the scope to update. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/dataAccessScopes/{data_access_scope}`
   * @param updateMask The list of fields to update. If not included, all fields with a non-empty
   *     value will be overwritten. Currently, only the description, the allowed and denied labels
   *     list fields are supported for update; an update call that attempts to update any other
   *     fields will return INVALID_ARGUMENT.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAccessScope updateDataAccessScope(
      DataAccessScope dataAccessScope, FieldMask updateMask) {
    UpdateDataAccessScopeRequest request =
        UpdateDataAccessScopeRequest.newBuilder()
            .setDataAccessScope(dataAccessScope)
            .setUpdateMask(updateMask)
            .build();
    return updateDataAccessScope(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a data access scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   UpdateDataAccessScopeRequest request =
   *       UpdateDataAccessScopeRequest.newBuilder()
   *           .setDataAccessScope(DataAccessScope.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   DataAccessScope response = dataAccessControlServiceClient.updateDataAccessScope(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataAccessScope updateDataAccessScope(UpdateDataAccessScopeRequest request) {
    return updateDataAccessScopeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a data access scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   UpdateDataAccessScopeRequest request =
   *       UpdateDataAccessScopeRequest.newBuilder()
   *           .setDataAccessScope(DataAccessScope.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<DataAccessScope> future =
   *       dataAccessControlServiceClient.updateDataAccessScopeCallable().futureCall(request);
   *   // Do something.
   *   DataAccessScope response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDataAccessScopeRequest, DataAccessScope>
      updateDataAccessScopeCallable() {
    return stub.updateDataAccessScopeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a data access scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   DataAccessScopeName name =
   *       DataAccessScopeName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]");
   *   dataAccessControlServiceClient.deleteDataAccessScope(name);
   * }
   * }</pre>
   *
   * @param name Required. The ID of the data access scope to delete. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/dataAccessScopes/{data_access_scope}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataAccessScope(DataAccessScopeName name) {
    DeleteDataAccessScopeRequest request =
        DeleteDataAccessScopeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteDataAccessScope(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a data access scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   String name =
   *       DataAccessScopeName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]")
   *           .toString();
   *   dataAccessControlServiceClient.deleteDataAccessScope(name);
   * }
   * }</pre>
   *
   * @param name Required. The ID of the data access scope to delete. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/dataAccessScopes/{data_access_scope}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataAccessScope(String name) {
    DeleteDataAccessScopeRequest request =
        DeleteDataAccessScopeRequest.newBuilder().setName(name).build();
    deleteDataAccessScope(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a data access scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   DeleteDataAccessScopeRequest request =
   *       DeleteDataAccessScopeRequest.newBuilder()
   *           .setName(
   *               DataAccessScopeName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]")
   *                   .toString())
   *           .build();
   *   dataAccessControlServiceClient.deleteDataAccessScope(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataAccessScope(DeleteDataAccessScopeRequest request) {
    deleteDataAccessScopeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a data access scope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataAccessControlServiceClient dataAccessControlServiceClient =
   *     DataAccessControlServiceClient.create()) {
   *   DeleteDataAccessScopeRequest request =
   *       DeleteDataAccessScopeRequest.newBuilder()
   *           .setName(
   *               DataAccessScopeName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       dataAccessControlServiceClient.deleteDataAccessScopeCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDataAccessScopeRequest, Empty> deleteDataAccessScopeCallable() {
    return stub.deleteDataAccessScopeCallable();
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

  public static class ListDataAccessLabelsPagedResponse
      extends AbstractPagedListResponse<
          ListDataAccessLabelsRequest,
          ListDataAccessLabelsResponse,
          DataAccessLabel,
          ListDataAccessLabelsPage,
          ListDataAccessLabelsFixedSizeCollection> {

    public static ApiFuture<ListDataAccessLabelsPagedResponse> createAsync(
        PageContext<ListDataAccessLabelsRequest, ListDataAccessLabelsResponse, DataAccessLabel>
            context,
        ApiFuture<ListDataAccessLabelsResponse> futureResponse) {
      ApiFuture<ListDataAccessLabelsPage> futurePage =
          ListDataAccessLabelsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDataAccessLabelsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDataAccessLabelsPagedResponse(ListDataAccessLabelsPage page) {
      super(page, ListDataAccessLabelsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDataAccessLabelsPage
      extends AbstractPage<
          ListDataAccessLabelsRequest,
          ListDataAccessLabelsResponse,
          DataAccessLabel,
          ListDataAccessLabelsPage> {

    private ListDataAccessLabelsPage(
        PageContext<ListDataAccessLabelsRequest, ListDataAccessLabelsResponse, DataAccessLabel>
            context,
        ListDataAccessLabelsResponse response) {
      super(context, response);
    }

    private static ListDataAccessLabelsPage createEmptyPage() {
      return new ListDataAccessLabelsPage(null, null);
    }

    @Override
    protected ListDataAccessLabelsPage createPage(
        PageContext<ListDataAccessLabelsRequest, ListDataAccessLabelsResponse, DataAccessLabel>
            context,
        ListDataAccessLabelsResponse response) {
      return new ListDataAccessLabelsPage(context, response);
    }

    @Override
    public ApiFuture<ListDataAccessLabelsPage> createPageAsync(
        PageContext<ListDataAccessLabelsRequest, ListDataAccessLabelsResponse, DataAccessLabel>
            context,
        ApiFuture<ListDataAccessLabelsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDataAccessLabelsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDataAccessLabelsRequest,
          ListDataAccessLabelsResponse,
          DataAccessLabel,
          ListDataAccessLabelsPage,
          ListDataAccessLabelsFixedSizeCollection> {

    private ListDataAccessLabelsFixedSizeCollection(
        List<ListDataAccessLabelsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDataAccessLabelsFixedSizeCollection createEmptyCollection() {
      return new ListDataAccessLabelsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDataAccessLabelsFixedSizeCollection createCollection(
        List<ListDataAccessLabelsPage> pages, int collectionSize) {
      return new ListDataAccessLabelsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDataAccessScopesPagedResponse
      extends AbstractPagedListResponse<
          ListDataAccessScopesRequest,
          ListDataAccessScopesResponse,
          DataAccessScope,
          ListDataAccessScopesPage,
          ListDataAccessScopesFixedSizeCollection> {

    public static ApiFuture<ListDataAccessScopesPagedResponse> createAsync(
        PageContext<ListDataAccessScopesRequest, ListDataAccessScopesResponse, DataAccessScope>
            context,
        ApiFuture<ListDataAccessScopesResponse> futureResponse) {
      ApiFuture<ListDataAccessScopesPage> futurePage =
          ListDataAccessScopesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDataAccessScopesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDataAccessScopesPagedResponse(ListDataAccessScopesPage page) {
      super(page, ListDataAccessScopesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDataAccessScopesPage
      extends AbstractPage<
          ListDataAccessScopesRequest,
          ListDataAccessScopesResponse,
          DataAccessScope,
          ListDataAccessScopesPage> {

    private ListDataAccessScopesPage(
        PageContext<ListDataAccessScopesRequest, ListDataAccessScopesResponse, DataAccessScope>
            context,
        ListDataAccessScopesResponse response) {
      super(context, response);
    }

    private static ListDataAccessScopesPage createEmptyPage() {
      return new ListDataAccessScopesPage(null, null);
    }

    @Override
    protected ListDataAccessScopesPage createPage(
        PageContext<ListDataAccessScopesRequest, ListDataAccessScopesResponse, DataAccessScope>
            context,
        ListDataAccessScopesResponse response) {
      return new ListDataAccessScopesPage(context, response);
    }

    @Override
    public ApiFuture<ListDataAccessScopesPage> createPageAsync(
        PageContext<ListDataAccessScopesRequest, ListDataAccessScopesResponse, DataAccessScope>
            context,
        ApiFuture<ListDataAccessScopesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDataAccessScopesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDataAccessScopesRequest,
          ListDataAccessScopesResponse,
          DataAccessScope,
          ListDataAccessScopesPage,
          ListDataAccessScopesFixedSizeCollection> {

    private ListDataAccessScopesFixedSizeCollection(
        List<ListDataAccessScopesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDataAccessScopesFixedSizeCollection createEmptyCollection() {
      return new ListDataAccessScopesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDataAccessScopesFixedSizeCollection createCollection(
        List<ListDataAccessScopesPage> pages, int collectionSize) {
      return new ListDataAccessScopesFixedSizeCollection(pages, collectionSize);
    }
  }
}
