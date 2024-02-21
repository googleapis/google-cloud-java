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

package com.google.cloud.pubsub.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.pubsub.v1.stub.SchemaServiceStub;
import com.google.cloud.pubsub.v1.stub.SchemaServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.CommitSchemaRequest;
import com.google.pubsub.v1.CreateSchemaRequest;
import com.google.pubsub.v1.DeleteSchemaRequest;
import com.google.pubsub.v1.DeleteSchemaRevisionRequest;
import com.google.pubsub.v1.GetSchemaRequest;
import com.google.pubsub.v1.ListSchemaRevisionsRequest;
import com.google.pubsub.v1.ListSchemaRevisionsResponse;
import com.google.pubsub.v1.ListSchemasRequest;
import com.google.pubsub.v1.ListSchemasResponse;
import com.google.pubsub.v1.ProjectName;
import com.google.pubsub.v1.RollbackSchemaRequest;
import com.google.pubsub.v1.Schema;
import com.google.pubsub.v1.SchemaName;
import com.google.pubsub.v1.ValidateMessageRequest;
import com.google.pubsub.v1.ValidateMessageResponse;
import com.google.pubsub.v1.ValidateSchemaRequest;
import com.google.pubsub.v1.ValidateSchemaResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for doing schema-related operations.
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
 * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   Schema schema = Schema.newBuilder().build();
 *   String schemaId = "schemaId-697673060";
 *   Schema response = schemaServiceClient.createSchema(parent, schema, schemaId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SchemaServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSchema</td>
 *      <td><p> Creates a schema.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSchema(CreateSchemaRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSchema(ProjectName parent, Schema schema, String schemaId)
 *           <li><p> createSchema(String parent, Schema schema, String schemaId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSchemaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSchema</td>
 *      <td><p> Gets a schema.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSchema(GetSchemaRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSchema(SchemaName name)
 *           <li><p> getSchema(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSchemaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSchemas</td>
 *      <td><p> Lists schemas in a project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSchemas(ListSchemasRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSchemas(ProjectName parent)
 *           <li><p> listSchemas(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSchemasPagedCallable()
 *           <li><p> listSchemasCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSchemaRevisions</td>
 *      <td><p> Lists all schema revisions for the named schema.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSchemaRevisions(ListSchemaRevisionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSchemaRevisions(SchemaName name)
 *           <li><p> listSchemaRevisions(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSchemaRevisionsPagedCallable()
 *           <li><p> listSchemaRevisionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CommitSchema</td>
 *      <td><p> Commits a new schema revision to an existing schema.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> commitSchema(CommitSchemaRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> commitSchema(SchemaName name, Schema schema)
 *           <li><p> commitSchema(String name, Schema schema)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> commitSchemaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RollbackSchema</td>
 *      <td><p> Creates a new schema revision that is a copy of the provided revision_id.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> rollbackSchema(RollbackSchemaRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> rollbackSchema(SchemaName name, String revisionId)
 *           <li><p> rollbackSchema(String name, String revisionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> rollbackSchemaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSchemaRevision</td>
 *      <td><p> Deletes a specific schema revision.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSchemaRevision(DeleteSchemaRevisionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteSchemaRevision(SchemaName name, String revisionId)
 *           <li><p> deleteSchemaRevision(String name, String revisionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSchemaRevisionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSchema</td>
 *      <td><p> Deletes a schema.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSchema(DeleteSchemaRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteSchema(SchemaName name)
 *           <li><p> deleteSchema(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSchemaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ValidateSchema</td>
 *      <td><p> Validates a schema.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> validateSchema(ValidateSchemaRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> validateSchema(ProjectName parent, Schema schema)
 *           <li><p> validateSchema(String parent, Schema schema)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> validateSchemaCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ValidateMessage</td>
 *      <td><p> Validates a message against a schema.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> validateMessage(ValidateMessageRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> validateMessageCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy on the specified resource. Replacesany existing policy.
 * <p> Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a resource. Returns an empty policyif the resource exists and does not have a policy set.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns permissions that a caller has on the specified resource. If theresource does not exist, this will return an empty set ofpermissions, not a `NOT_FOUND` error.
 * <p> Note: This operation is designed to be used for buildingpermission-aware UIs and command-line tools, not for authorizationchecking. This operation may "fail open" without warning.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
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
 * <p>This class can be customized by passing in a custom instance of SchemaServiceSettings to
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
 * SchemaServiceSettings schemaServiceSettings =
 *     SchemaServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SchemaServiceClient schemaServiceClient = SchemaServiceClient.create(schemaServiceSettings);
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
 * SchemaServiceSettings schemaServiceSettings =
 *     SchemaServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SchemaServiceClient schemaServiceClient = SchemaServiceClient.create(schemaServiceSettings);
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
 * SchemaServiceSettings schemaServiceSettings =
 *     SchemaServiceSettings.newHttpJsonBuilder().build();
 * SchemaServiceClient schemaServiceClient = SchemaServiceClient.create(schemaServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class SchemaServiceClient implements BackgroundResource {
  private final SchemaServiceSettings settings;
  private final SchemaServiceStub stub;

  /** Constructs an instance of SchemaServiceClient with default settings. */
  public static final SchemaServiceClient create() throws IOException {
    return create(SchemaServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SchemaServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final SchemaServiceClient create(SchemaServiceSettings settings)
      throws IOException {
    return new SchemaServiceClient(settings);
  }

  /**
   * Constructs an instance of SchemaServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(SchemaServiceSettings).
   */
  public static final SchemaServiceClient create(SchemaServiceStub stub) {
    return new SchemaServiceClient(stub);
  }

  /**
   * Constructs an instance of SchemaServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected SchemaServiceClient(SchemaServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SchemaServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected SchemaServiceClient(SchemaServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SchemaServiceSettings getSettings() {
    return settings;
  }

  public SchemaServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Schema schema = Schema.newBuilder().build();
   *   String schemaId = "schemaId-697673060";
   *   Schema response = schemaServiceClient.createSchema(parent, schema, schemaId);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project in which to create the schema. Format is
   *     `projects/{project-id}`.
   * @param schema Required. The schema object to create.
   *     <p>This schema's `name` parameter is ignored. The schema object returned by CreateSchema
   *     will have a `name` made using the given `parent` and `schema_id`.
   * @param schemaId The ID to use for the schema, which will become the final component of the
   *     schema's resource name.
   *     <p>See https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names for resource name
   *     constraints.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schema createSchema(ProjectName parent, Schema schema, String schemaId) {
    CreateSchemaRequest request =
        CreateSchemaRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSchema(schema)
            .setSchemaId(schemaId)
            .build();
    return createSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   Schema schema = Schema.newBuilder().build();
   *   String schemaId = "schemaId-697673060";
   *   Schema response = schemaServiceClient.createSchema(parent, schema, schemaId);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project in which to create the schema. Format is
   *     `projects/{project-id}`.
   * @param schema Required. The schema object to create.
   *     <p>This schema's `name` parameter is ignored. The schema object returned by CreateSchema
   *     will have a `name` made using the given `parent` and `schema_id`.
   * @param schemaId The ID to use for the schema, which will become the final component of the
   *     schema's resource name.
   *     <p>See https://cloud.google.com/pubsub/docs/pubsub-basics#resource_names for resource name
   *     constraints.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schema createSchema(String parent, Schema schema, String schemaId) {
    CreateSchemaRequest request =
        CreateSchemaRequest.newBuilder()
            .setParent(parent)
            .setSchema(schema)
            .setSchemaId(schemaId)
            .build();
    return createSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   CreateSchemaRequest request =
   *       CreateSchemaRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setSchema(Schema.newBuilder().build())
   *           .setSchemaId("schemaId-697673060")
   *           .build();
   *   Schema response = schemaServiceClient.createSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schema createSchema(CreateSchemaRequest request) {
    return createSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   CreateSchemaRequest request =
   *       CreateSchemaRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setSchema(Schema.newBuilder().build())
   *           .setSchemaId("schemaId-697673060")
   *           .build();
   *   ApiFuture<Schema> future = schemaServiceClient.createSchemaCallable().futureCall(request);
   *   // Do something.
   *   Schema response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSchemaRequest, Schema> createSchemaCallable() {
    return stub.createSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   SchemaName name = SchemaName.of("[PROJECT]", "[SCHEMA]");
   *   Schema response = schemaServiceClient.getSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the schema to get. Format is
   *     `projects/{project}/schemas/{schema}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schema getSchema(SchemaName name) {
    GetSchemaRequest request =
        GetSchemaRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   String name = SchemaName.of("[PROJECT]", "[SCHEMA]").toString();
   *   Schema response = schemaServiceClient.getSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the schema to get. Format is
   *     `projects/{project}/schemas/{schema}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schema getSchema(String name) {
    GetSchemaRequest request = GetSchemaRequest.newBuilder().setName(name).build();
    return getSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   GetSchemaRequest request =
   *       GetSchemaRequest.newBuilder()
   *           .setName(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .setView(SchemaView.forNumber(0))
   *           .build();
   *   Schema response = schemaServiceClient.getSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schema getSchema(GetSchemaRequest request) {
    return getSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   GetSchemaRequest request =
   *       GetSchemaRequest.newBuilder()
   *           .setName(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .setView(SchemaView.forNumber(0))
   *           .build();
   *   ApiFuture<Schema> future = schemaServiceClient.getSchemaCallable().futureCall(request);
   *   // Do something.
   *   Schema response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSchemaRequest, Schema> getSchemaCallable() {
    return stub.getSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists schemas in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (Schema element : schemaServiceClient.listSchemas(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project in which to list schemas. Format is
   *     `projects/{project-id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSchemasPagedResponse listSchemas(ProjectName parent) {
    ListSchemasRequest request =
        ListSchemasRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSchemas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists schemas in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (Schema element : schemaServiceClient.listSchemas(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project in which to list schemas. Format is
   *     `projects/{project-id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSchemasPagedResponse listSchemas(String parent) {
    ListSchemasRequest request = ListSchemasRequest.newBuilder().setParent(parent).build();
    return listSchemas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists schemas in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ListSchemasRequest request =
   *       ListSchemasRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setView(SchemaView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Schema element : schemaServiceClient.listSchemas(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSchemasPagedResponse listSchemas(ListSchemasRequest request) {
    return listSchemasPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists schemas in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ListSchemasRequest request =
   *       ListSchemasRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setView(SchemaView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Schema> future = schemaServiceClient.listSchemasPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Schema element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSchemasRequest, ListSchemasPagedResponse>
      listSchemasPagedCallable() {
    return stub.listSchemasPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists schemas in a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ListSchemasRequest request =
   *       ListSchemasRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setView(SchemaView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSchemasResponse response = schemaServiceClient.listSchemasCallable().call(request);
   *     for (Schema element : response.getSchemasList()) {
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
  public final UnaryCallable<ListSchemasRequest, ListSchemasResponse> listSchemasCallable() {
    return stub.listSchemasCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all schema revisions for the named schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   SchemaName name = SchemaName.of("[PROJECT]", "[SCHEMA]");
   *   for (Schema element : schemaServiceClient.listSchemaRevisions(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The name of the schema to list revisions for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSchemaRevisionsPagedResponse listSchemaRevisions(SchemaName name) {
    ListSchemaRevisionsRequest request =
        ListSchemaRevisionsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return listSchemaRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all schema revisions for the named schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   String name = SchemaName.of("[PROJECT]", "[SCHEMA]").toString();
   *   for (Schema element : schemaServiceClient.listSchemaRevisions(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The name of the schema to list revisions for.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSchemaRevisionsPagedResponse listSchemaRevisions(String name) {
    ListSchemaRevisionsRequest request =
        ListSchemaRevisionsRequest.newBuilder().setName(name).build();
    return listSchemaRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all schema revisions for the named schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ListSchemaRevisionsRequest request =
   *       ListSchemaRevisionsRequest.newBuilder()
   *           .setName(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .setView(SchemaView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Schema element : schemaServiceClient.listSchemaRevisions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSchemaRevisionsPagedResponse listSchemaRevisions(
      ListSchemaRevisionsRequest request) {
    return listSchemaRevisionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all schema revisions for the named schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ListSchemaRevisionsRequest request =
   *       ListSchemaRevisionsRequest.newBuilder()
   *           .setName(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .setView(SchemaView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Schema> future =
   *       schemaServiceClient.listSchemaRevisionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Schema element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSchemaRevisionsRequest, ListSchemaRevisionsPagedResponse>
      listSchemaRevisionsPagedCallable() {
    return stub.listSchemaRevisionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all schema revisions for the named schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ListSchemaRevisionsRequest request =
   *       ListSchemaRevisionsRequest.newBuilder()
   *           .setName(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .setView(SchemaView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSchemaRevisionsResponse response =
   *         schemaServiceClient.listSchemaRevisionsCallable().call(request);
   *     for (Schema element : response.getSchemasList()) {
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
  public final UnaryCallable<ListSchemaRevisionsRequest, ListSchemaRevisionsResponse>
      listSchemaRevisionsCallable() {
    return stub.listSchemaRevisionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Commits a new schema revision to an existing schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   SchemaName name = SchemaName.of("[PROJECT]", "[SCHEMA]");
   *   Schema schema = Schema.newBuilder().build();
   *   Schema response = schemaServiceClient.commitSchema(name, schema);
   * }
   * }</pre>
   *
   * @param name Required. The name of the schema we are revising. Format is
   *     `projects/{project}/schemas/{schema}`.
   * @param schema Required. The schema revision to commit.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schema commitSchema(SchemaName name, Schema schema) {
    CommitSchemaRequest request =
        CommitSchemaRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setSchema(schema)
            .build();
    return commitSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Commits a new schema revision to an existing schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   String name = SchemaName.of("[PROJECT]", "[SCHEMA]").toString();
   *   Schema schema = Schema.newBuilder().build();
   *   Schema response = schemaServiceClient.commitSchema(name, schema);
   * }
   * }</pre>
   *
   * @param name Required. The name of the schema we are revising. Format is
   *     `projects/{project}/schemas/{schema}`.
   * @param schema Required. The schema revision to commit.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schema commitSchema(String name, Schema schema) {
    CommitSchemaRequest request =
        CommitSchemaRequest.newBuilder().setName(name).setSchema(schema).build();
    return commitSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Commits a new schema revision to an existing schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   CommitSchemaRequest request =
   *       CommitSchemaRequest.newBuilder()
   *           .setName(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .setSchema(Schema.newBuilder().build())
   *           .build();
   *   Schema response = schemaServiceClient.commitSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schema commitSchema(CommitSchemaRequest request) {
    return commitSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Commits a new schema revision to an existing schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   CommitSchemaRequest request =
   *       CommitSchemaRequest.newBuilder()
   *           .setName(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .setSchema(Schema.newBuilder().build())
   *           .build();
   *   ApiFuture<Schema> future = schemaServiceClient.commitSchemaCallable().futureCall(request);
   *   // Do something.
   *   Schema response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CommitSchemaRequest, Schema> commitSchemaCallable() {
    return stub.commitSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new schema revision that is a copy of the provided revision_id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   SchemaName name = SchemaName.of("[PROJECT]", "[SCHEMA]");
   *   String revisionId = "revisionId-1507445162";
   *   Schema response = schemaServiceClient.rollbackSchema(name, revisionId);
   * }
   * }</pre>
   *
   * @param name Required. The schema being rolled back with revision id.
   * @param revisionId Required. The revision ID to roll back to. It must be a revision of the same
   *     schema.
   *     <p>Example: c7cfa2a8
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schema rollbackSchema(SchemaName name, String revisionId) {
    RollbackSchemaRequest request =
        RollbackSchemaRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setRevisionId(revisionId)
            .build();
    return rollbackSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new schema revision that is a copy of the provided revision_id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   String name = SchemaName.of("[PROJECT]", "[SCHEMA]").toString();
   *   String revisionId = "revisionId-1507445162";
   *   Schema response = schemaServiceClient.rollbackSchema(name, revisionId);
   * }
   * }</pre>
   *
   * @param name Required. The schema being rolled back with revision id.
   * @param revisionId Required. The revision ID to roll back to. It must be a revision of the same
   *     schema.
   *     <p>Example: c7cfa2a8
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schema rollbackSchema(String name, String revisionId) {
    RollbackSchemaRequest request =
        RollbackSchemaRequest.newBuilder().setName(name).setRevisionId(revisionId).build();
    return rollbackSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new schema revision that is a copy of the provided revision_id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   RollbackSchemaRequest request =
   *       RollbackSchemaRequest.newBuilder()
   *           .setName(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .setRevisionId("revisionId-1507445162")
   *           .build();
   *   Schema response = schemaServiceClient.rollbackSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schema rollbackSchema(RollbackSchemaRequest request) {
    return rollbackSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new schema revision that is a copy of the provided revision_id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   RollbackSchemaRequest request =
   *       RollbackSchemaRequest.newBuilder()
   *           .setName(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .setRevisionId("revisionId-1507445162")
   *           .build();
   *   ApiFuture<Schema> future = schemaServiceClient.rollbackSchemaCallable().futureCall(request);
   *   // Do something.
   *   Schema response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RollbackSchemaRequest, Schema> rollbackSchemaCallable() {
    return stub.rollbackSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific schema revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   SchemaName name = SchemaName.of("[PROJECT]", "[SCHEMA]");
   *   String revisionId = "revisionId-1507445162";
   *   Schema response = schemaServiceClient.deleteSchemaRevision(name, revisionId);
   * }
   * }</pre>
   *
   * @param name Required. The name of the schema revision to be deleted, with a revision ID
   *     explicitly included.
   *     <p>Example: `projects/123/schemas/my-schema{@literal @}c7cfa2a8`
   * @param revisionId Optional. This field is deprecated and should not be used for specifying the
   *     revision ID. The revision ID should be specified via the `name` parameter.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schema deleteSchemaRevision(SchemaName name, String revisionId) {
    DeleteSchemaRevisionRequest request =
        DeleteSchemaRevisionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setRevisionId(revisionId)
            .build();
    return deleteSchemaRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific schema revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   String name = SchemaName.of("[PROJECT]", "[SCHEMA]").toString();
   *   String revisionId = "revisionId-1507445162";
   *   Schema response = schemaServiceClient.deleteSchemaRevision(name, revisionId);
   * }
   * }</pre>
   *
   * @param name Required. The name of the schema revision to be deleted, with a revision ID
   *     explicitly included.
   *     <p>Example: `projects/123/schemas/my-schema{@literal @}c7cfa2a8`
   * @param revisionId Optional. This field is deprecated and should not be used for specifying the
   *     revision ID. The revision ID should be specified via the `name` parameter.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schema deleteSchemaRevision(String name, String revisionId) {
    DeleteSchemaRevisionRequest request =
        DeleteSchemaRevisionRequest.newBuilder().setName(name).setRevisionId(revisionId).build();
    return deleteSchemaRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific schema revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   DeleteSchemaRevisionRequest request =
   *       DeleteSchemaRevisionRequest.newBuilder()
   *           .setName(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .setRevisionId("revisionId-1507445162")
   *           .build();
   *   Schema response = schemaServiceClient.deleteSchemaRevision(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schema deleteSchemaRevision(DeleteSchemaRevisionRequest request) {
    return deleteSchemaRevisionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific schema revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   DeleteSchemaRevisionRequest request =
   *       DeleteSchemaRevisionRequest.newBuilder()
   *           .setName(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .setRevisionId("revisionId-1507445162")
   *           .build();
   *   ApiFuture<Schema> future =
   *       schemaServiceClient.deleteSchemaRevisionCallable().futureCall(request);
   *   // Do something.
   *   Schema response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSchemaRevisionRequest, Schema> deleteSchemaRevisionCallable() {
    return stub.deleteSchemaRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   SchemaName name = SchemaName.of("[PROJECT]", "[SCHEMA]");
   *   schemaServiceClient.deleteSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the schema to delete. Format is
   *     `projects/{project}/schemas/{schema}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSchema(SchemaName name) {
    DeleteSchemaRequest request =
        DeleteSchemaRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   String name = SchemaName.of("[PROJECT]", "[SCHEMA]").toString();
   *   schemaServiceClient.deleteSchema(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the schema to delete. Format is
   *     `projects/{project}/schemas/{schema}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSchema(String name) {
    DeleteSchemaRequest request = DeleteSchemaRequest.newBuilder().setName(name).build();
    deleteSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   DeleteSchemaRequest request =
   *       DeleteSchemaRequest.newBuilder()
   *           .setName(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .build();
   *   schemaServiceClient.deleteSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSchema(DeleteSchemaRequest request) {
    deleteSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   DeleteSchemaRequest request =
   *       DeleteSchemaRequest.newBuilder()
   *           .setName(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .build();
   *   ApiFuture<Empty> future = schemaServiceClient.deleteSchemaCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSchemaRequest, Empty> deleteSchemaCallable() {
    return stub.deleteSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Validates a schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Schema schema = Schema.newBuilder().build();
   *   ValidateSchemaResponse response = schemaServiceClient.validateSchema(parent, schema);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project in which to validate schemas. Format is
   *     `projects/{project-id}`.
   * @param schema Required. The schema object to validate.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ValidateSchemaResponse validateSchema(ProjectName parent, Schema schema) {
    ValidateSchemaRequest request =
        ValidateSchemaRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSchema(schema)
            .build();
    return validateSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Validates a schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   Schema schema = Schema.newBuilder().build();
   *   ValidateSchemaResponse response = schemaServiceClient.validateSchema(parent, schema);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project in which to validate schemas. Format is
   *     `projects/{project-id}`.
   * @param schema Required. The schema object to validate.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ValidateSchemaResponse validateSchema(String parent, Schema schema) {
    ValidateSchemaRequest request =
        ValidateSchemaRequest.newBuilder().setParent(parent).setSchema(schema).build();
    return validateSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Validates a schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ValidateSchemaRequest request =
   *       ValidateSchemaRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setSchema(Schema.newBuilder().build())
   *           .build();
   *   ValidateSchemaResponse response = schemaServiceClient.validateSchema(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ValidateSchemaResponse validateSchema(ValidateSchemaRequest request) {
    return validateSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Validates a schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ValidateSchemaRequest request =
   *       ValidateSchemaRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setSchema(Schema.newBuilder().build())
   *           .build();
   *   ApiFuture<ValidateSchemaResponse> future =
   *       schemaServiceClient.validateSchemaCallable().futureCall(request);
   *   // Do something.
   *   ValidateSchemaResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ValidateSchemaRequest, ValidateSchemaResponse>
      validateSchemaCallable() {
    return stub.validateSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Validates a message against a schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ValidateMessageRequest request =
   *       ValidateMessageRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setMessage(ByteString.EMPTY)
   *           .setEncoding(Encoding.forNumber(0))
   *           .build();
   *   ValidateMessageResponse response = schemaServiceClient.validateMessage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ValidateMessageResponse validateMessage(ValidateMessageRequest request) {
    return validateMessageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Validates a message against a schema.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ValidateMessageRequest request =
   *       ValidateMessageRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setMessage(ByteString.EMPTY)
   *           .setEncoding(Encoding.forNumber(0))
   *           .build();
   *   ApiFuture<ValidateMessageResponse> future =
   *       schemaServiceClient.validateMessageCallable().futureCall(request);
   *   // Do something.
   *   ValidateMessageResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ValidateMessageRequest, ValidateMessageResponse>
      validateMessageCallable() {
    return stub.validateMessageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = schemaServiceClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = schemaServiceClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = schemaServiceClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = schemaServiceClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = schemaServiceClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(SchemaName.of("[PROJECT]", "[SCHEMA]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       schemaServiceClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
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

  public static class ListSchemasPagedResponse
      extends AbstractPagedListResponse<
          ListSchemasRequest,
          ListSchemasResponse,
          Schema,
          ListSchemasPage,
          ListSchemasFixedSizeCollection> {

    public static ApiFuture<ListSchemasPagedResponse> createAsync(
        PageContext<ListSchemasRequest, ListSchemasResponse, Schema> context,
        ApiFuture<ListSchemasResponse> futureResponse) {
      ApiFuture<ListSchemasPage> futurePage =
          ListSchemasPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSchemasPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSchemasPagedResponse(ListSchemasPage page) {
      super(page, ListSchemasFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSchemasPage
      extends AbstractPage<ListSchemasRequest, ListSchemasResponse, Schema, ListSchemasPage> {

    private ListSchemasPage(
        PageContext<ListSchemasRequest, ListSchemasResponse, Schema> context,
        ListSchemasResponse response) {
      super(context, response);
    }

    private static ListSchemasPage createEmptyPage() {
      return new ListSchemasPage(null, null);
    }

    @Override
    protected ListSchemasPage createPage(
        PageContext<ListSchemasRequest, ListSchemasResponse, Schema> context,
        ListSchemasResponse response) {
      return new ListSchemasPage(context, response);
    }

    @Override
    public ApiFuture<ListSchemasPage> createPageAsync(
        PageContext<ListSchemasRequest, ListSchemasResponse, Schema> context,
        ApiFuture<ListSchemasResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSchemasFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSchemasRequest,
          ListSchemasResponse,
          Schema,
          ListSchemasPage,
          ListSchemasFixedSizeCollection> {

    private ListSchemasFixedSizeCollection(List<ListSchemasPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSchemasFixedSizeCollection createEmptyCollection() {
      return new ListSchemasFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSchemasFixedSizeCollection createCollection(
        List<ListSchemasPage> pages, int collectionSize) {
      return new ListSchemasFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSchemaRevisionsPagedResponse
      extends AbstractPagedListResponse<
          ListSchemaRevisionsRequest,
          ListSchemaRevisionsResponse,
          Schema,
          ListSchemaRevisionsPage,
          ListSchemaRevisionsFixedSizeCollection> {

    public static ApiFuture<ListSchemaRevisionsPagedResponse> createAsync(
        PageContext<ListSchemaRevisionsRequest, ListSchemaRevisionsResponse, Schema> context,
        ApiFuture<ListSchemaRevisionsResponse> futureResponse) {
      ApiFuture<ListSchemaRevisionsPage> futurePage =
          ListSchemaRevisionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSchemaRevisionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSchemaRevisionsPagedResponse(ListSchemaRevisionsPage page) {
      super(page, ListSchemaRevisionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSchemaRevisionsPage
      extends AbstractPage<
          ListSchemaRevisionsRequest,
          ListSchemaRevisionsResponse,
          Schema,
          ListSchemaRevisionsPage> {

    private ListSchemaRevisionsPage(
        PageContext<ListSchemaRevisionsRequest, ListSchemaRevisionsResponse, Schema> context,
        ListSchemaRevisionsResponse response) {
      super(context, response);
    }

    private static ListSchemaRevisionsPage createEmptyPage() {
      return new ListSchemaRevisionsPage(null, null);
    }

    @Override
    protected ListSchemaRevisionsPage createPage(
        PageContext<ListSchemaRevisionsRequest, ListSchemaRevisionsResponse, Schema> context,
        ListSchemaRevisionsResponse response) {
      return new ListSchemaRevisionsPage(context, response);
    }

    @Override
    public ApiFuture<ListSchemaRevisionsPage> createPageAsync(
        PageContext<ListSchemaRevisionsRequest, ListSchemaRevisionsResponse, Schema> context,
        ApiFuture<ListSchemaRevisionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSchemaRevisionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSchemaRevisionsRequest,
          ListSchemaRevisionsResponse,
          Schema,
          ListSchemaRevisionsPage,
          ListSchemaRevisionsFixedSizeCollection> {

    private ListSchemaRevisionsFixedSizeCollection(
        List<ListSchemaRevisionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSchemaRevisionsFixedSizeCollection createEmptyCollection() {
      return new ListSchemaRevisionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSchemaRevisionsFixedSizeCollection createCollection(
        List<ListSchemaRevisionsPage> pages, int collectionSize) {
      return new ListSchemaRevisionsFixedSizeCollection(pages, collectionSize);
    }
  }
}
