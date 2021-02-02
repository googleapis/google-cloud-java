/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.pubsub.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.pubsub.v1.stub.SchemaServiceStub;
import com.google.cloud.pubsub.v1.stub.SchemaServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.CreateSchemaRequest;
import com.google.pubsub.v1.DeleteSchemaRequest;
import com.google.pubsub.v1.GetSchemaRequest;
import com.google.pubsub.v1.ListSchemasRequest;
import com.google.pubsub.v1.ListSchemasResponse;
import com.google.pubsub.v1.ProjectName;
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

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description:
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   Schema schema = Schema.newBuilder().build();
 *   String schemaId = "";
 *   Schema response = schemaServiceClient.createSchema(parent, schema, schemaId);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the schemaServiceClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of SchemaServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * SchemaServiceSettings schemaServiceSettings =
 *     SchemaServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SchemaServiceClient schemaServiceClient =
 *     SchemaServiceClient.create(schemaServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * SchemaServiceSettings schemaServiceSettings =
 *     SchemaServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SchemaServiceClient schemaServiceClient =
 *     SchemaServiceClient.create(schemaServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
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
   * for advanced usage - prefer to use SchemaServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected SchemaServiceClient(SchemaServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SchemaServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public SchemaServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a schema.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Schema schema = Schema.newBuilder().build();
   *   String schemaId = "";
   *   Schema response = schemaServiceClient.createSchema(parent, schema, schemaId);
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the project in which to create the schema. Format is
   *     `projects/{project-id}`.
   * @param schema Required. The schema object to create.
   *     <p>This schema's `name` parameter is ignored. The schema object returned by CreateSchema
   *     will have a `name` made using the given `parent` and `schema_id`.
   * @param schemaId The ID to use for the schema, which will become the final component of the
   *     schema's resource name.
   *     <p>See https://cloud.google.com/pubsub/docs/admin#resource_names for resource name
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a schema.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Schema schema = Schema.newBuilder().build();
   *   String schemaId = "";
   *   Schema response = schemaServiceClient.createSchema(parent.toString(), schema, schemaId);
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the project in which to create the schema. Format is
   *     `projects/{project-id}`.
   * @param schema Required. The schema object to create.
   *     <p>This schema's `name` parameter is ignored. The schema object returned by CreateSchema
   *     will have a `name` made using the given `parent` and `schema_id`.
   * @param schemaId The ID to use for the schema, which will become the final component of the
   *     schema's resource name.
   *     <p>See https://cloud.google.com/pubsub/docs/admin#resource_names for resource name
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a schema.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Schema schema = Schema.newBuilder().build();
   *   CreateSchemaRequest request = CreateSchemaRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setSchema(schema)
   *     .build();
   *   Schema response = schemaServiceClient.createSchema(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schema createSchema(CreateSchemaRequest request) {
    return createSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a schema.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Schema schema = Schema.newBuilder().build();
   *   CreateSchemaRequest request = CreateSchemaRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setSchema(schema)
   *     .build();
   *   ApiFuture&lt;Schema&gt; future = schemaServiceClient.createSchemaCallable().futureCall(request);
   *   // Do something
   *   Schema response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateSchemaRequest, Schema> createSchemaCallable() {
    return stub.createSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a schema.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   SchemaName name = SchemaName.of("[PROJECT]", "[SCHEMA]");
   *   Schema response = schemaServiceClient.getSchema(name);
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a schema.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   SchemaName name = SchemaName.of("[PROJECT]", "[SCHEMA]");
   *   Schema response = schemaServiceClient.getSchema(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required. The name of the schema to get. Format is
   *     `projects/{project}/schemas/{schema}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schema getSchema(String name) {
    GetSchemaRequest request = GetSchemaRequest.newBuilder().setName(name).build();
    return getSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a schema.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   SchemaName name = SchemaName.of("[PROJECT]", "[SCHEMA]");
   *   GetSchemaRequest request = GetSchemaRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   Schema response = schemaServiceClient.getSchema(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schema getSchema(GetSchemaRequest request) {
    return getSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a schema.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   SchemaName name = SchemaName.of("[PROJECT]", "[SCHEMA]");
   *   GetSchemaRequest request = GetSchemaRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Schema&gt; future = schemaServiceClient.getSchemaCallable().futureCall(request);
   *   // Do something
   *   Schema response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetSchemaRequest, Schema> getSchemaCallable() {
    return stub.getSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists schemas in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (Schema element : schemaServiceClient.listSchemas(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists schemas in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (Schema element : schemaServiceClient.listSchemas(parent.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the project in which to list schemas. Format is
   *     `projects/{project-id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSchemasPagedResponse listSchemas(String parent) {
    ListSchemasRequest request = ListSchemasRequest.newBuilder().setParent(parent).build();
    return listSchemas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists schemas in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ListSchemasRequest request = ListSchemasRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (Schema element : schemaServiceClient.listSchemas(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSchemasPagedResponse listSchemas(ListSchemasRequest request) {
    return listSchemasPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists schemas in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ListSchemasRequest request = ListSchemasRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListSchemasPagedResponse&gt; future = schemaServiceClient.listSchemasPagedCallable().futureCall(request);
   *   // Do something
   *   for (Schema element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListSchemasRequest, ListSchemasPagedResponse>
      listSchemasPagedCallable() {
    return stub.listSchemasPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists schemas in a project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ListSchemasRequest request = ListSchemasRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
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
   * </code></pre>
   */
  public final UnaryCallable<ListSchemasRequest, ListSchemasResponse> listSchemasCallable() {
    return stub.listSchemasCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a schema.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   SchemaName name = SchemaName.of("[PROJECT]", "[SCHEMA]");
   *   schemaServiceClient.deleteSchema(name);
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a schema.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   SchemaName name = SchemaName.of("[PROJECT]", "[SCHEMA]");
   *   schemaServiceClient.deleteSchema(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required. Name of the schema to delete. Format is
   *     `projects/{project}/schemas/{schema}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSchema(String name) {
    DeleteSchemaRequest request = DeleteSchemaRequest.newBuilder().setName(name).build();
    deleteSchema(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a schema.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   SchemaName name = SchemaName.of("[PROJECT]", "[SCHEMA]");
   *   DeleteSchemaRequest request = DeleteSchemaRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   schemaServiceClient.deleteSchema(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSchema(DeleteSchemaRequest request) {
    deleteSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a schema.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   SchemaName name = SchemaName.of("[PROJECT]", "[SCHEMA]");
   *   DeleteSchemaRequest request = DeleteSchemaRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = schemaServiceClient.deleteSchemaCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteSchemaRequest, Empty> deleteSchemaCallable() {
    return stub.deleteSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Validates a schema.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Schema schema = Schema.newBuilder().build();
   *   ValidateSchemaResponse response = schemaServiceClient.validateSchema(parent, schema);
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Validates a schema.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Schema schema = Schema.newBuilder().build();
   *   ValidateSchemaResponse response = schemaServiceClient.validateSchema(parent.toString(), schema);
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Validates a schema.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Schema schema = Schema.newBuilder().build();
   *   ValidateSchemaRequest request = ValidateSchemaRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setSchema(schema)
   *     .build();
   *   ValidateSchemaResponse response = schemaServiceClient.validateSchema(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ValidateSchemaResponse validateSchema(ValidateSchemaRequest request) {
    return validateSchemaCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Validates a schema.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Schema schema = Schema.newBuilder().build();
   *   ValidateSchemaRequest request = ValidateSchemaRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setSchema(schema)
   *     .build();
   *   ApiFuture&lt;ValidateSchemaResponse&gt; future = schemaServiceClient.validateSchemaCallable().futureCall(request);
   *   // Do something
   *   ValidateSchemaResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ValidateSchemaRequest, ValidateSchemaResponse>
      validateSchemaCallable() {
    return stub.validateSchemaCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Validates a message against a schema.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ValidateMessageRequest request = ValidateMessageRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ValidateMessageResponse response = schemaServiceClient.validateMessage(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ValidateMessageResponse validateMessage(ValidateMessageRequest request) {
    return validateMessageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Validates a message against a schema.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (SchemaServiceClient schemaServiceClient = SchemaServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ValidateMessageRequest request = ValidateMessageRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ValidateMessageResponse&gt; future = schemaServiceClient.validateMessageCallable().futureCall(request);
   *   // Do something
   *   ValidateMessageResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ValidateMessageRequest, ValidateMessageResponse>
      validateMessageCallable() {
    return stub.validateMessageCallable();
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
          futurePage,
          new ApiFunction<ListSchemasPage, ListSchemasPagedResponse>() {
            @Override
            public ListSchemasPagedResponse apply(ListSchemasPage input) {
              return new ListSchemasPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
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
}
