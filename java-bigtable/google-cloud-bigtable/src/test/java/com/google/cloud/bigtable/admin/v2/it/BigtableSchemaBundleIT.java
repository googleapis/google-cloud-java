/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigtable.admin.v2.it;

import static com.google.common.truth.Truth.assertWithMessage;
import static com.google.common.truth.TruthJUnit.assume;
import static org.junit.Assert.fail;

import com.google.api.gax.batching.Batcher;
import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.models.CreateSchemaBundleRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.SchemaBundle;
import com.google.cloud.bigtable.admin.v2.models.Table;
import com.google.cloud.bigtable.admin.v2.models.UpdateSchemaBundleRequest;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.RowMutationEntry;
import com.google.cloud.bigtable.test_helpers.env.EmulatorEnv;
import com.google.cloud.bigtable.test_helpers.env.PrefixGenerator;
import com.google.cloud.bigtable.test_helpers.env.TestEnvRule;
import com.google.protobuf.ByteString;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BigtableSchemaBundleIT {
  @ClassRule public static final TestEnvRule testEnvRule = new TestEnvRule();
  @Rule public final PrefixGenerator prefixGenerator = new PrefixGenerator();
  private static final Logger LOGGER = Logger.getLogger(BigtableSchemaBundleIT.class.getName());
  private static final int[] BACKOFF_DURATION = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
  // Location: `google-cloud-bigtable/src/test/resources/proto_schema_bundle.pb`
  private static final String TEST_PROTO_SCHEMA_BUNDLE = "proto_schema_bundle.pb";
  // Location:
  // `google-cloud-bigtable/src/test/resources/updated_proto_schema_bundle.pb`
  private static final String TEST_UPDATED_PROTO_SCHEMA_BUNDLE = "updated_proto_schema_bundle.pb";

  private static BigtableTableAdminClient tableAdmin;
  private static BigtableDataClient dataClient;
  private Table testTable;

  @BeforeClass
  public static void setUpClass() throws InterruptedException {
    assume()
        .withMessage("BigtableInstanceAdminClient is not supported on Emulator")
        .that(testEnvRule.env())
        .isNotInstanceOf(EmulatorEnv.class);

    tableAdmin = testEnvRule.env().getTableAdminClient();
    dataClient = testEnvRule.env().getDataClient();
  }

  @Before
  public void setUp() throws InterruptedException {
    testTable = createAndPopulateTestTable(tableAdmin, dataClient);
  }

  @After
  public void tearDown() {
    if (testTable != null) {
      try {
        tableAdmin.deleteTable(testTable.getId());
      } catch (Exception e) {
        // Ignore.
      }
    }
  }

  @Test
  public void createSchemaBundleAndGetSchemaBundleTest() throws IOException, URISyntaxException {
    String SchemaBundleId = prefixGenerator.newPrefix();
    byte[] content = Files.readAllBytes(Paths.get(getResourceFilePath(TEST_PROTO_SCHEMA_BUNDLE)));

    CreateSchemaBundleRequest request =
        CreateSchemaBundleRequest.of(testTable.getId(), SchemaBundleId)
            .setProtoSchemaFile(getResourceFilePath(TEST_PROTO_SCHEMA_BUNDLE));
    try {
      SchemaBundle response = tableAdmin.createSchemaBundle(request);
      assertWithMessage("Got wrong schema bundle Id in createSchemaBundle")
          .that(response.getId())
          .isEqualTo(SchemaBundleId);
      assertWithMessage("Got wrong proto schema in createSchemaBundle")
          .that(response.getProtoSchema())
          .isEqualTo(ByteString.copyFrom(content));

      response = tableAdmin.getSchemaBundle(testTable.getId(), SchemaBundleId);
      assertWithMessage("Got wrong schema bundle Id in getSchemaBundle")
          .that(response.getId())
          .isEqualTo(SchemaBundleId);
      assertWithMessage("Got wrong proto schema in getSchemaBundle")
          .that(response.getProtoSchema())
          .isEqualTo(ByteString.copyFrom(content));
    } finally {
      tableAdmin.deleteSchemaBundle(testTable.getId(), SchemaBundleId);
    }
  }

  @Test
  public void listSchemaBundlesTest() throws IOException, URISyntaxException {
    String SchemaBundleId1 = prefixGenerator.newPrefix();
    String SchemaBundleId2 = prefixGenerator.newPrefix();

    tableAdmin.createSchemaBundle(createSchemaBundleRequest(SchemaBundleId1));
    tableAdmin.createSchemaBundle(createSchemaBundleRequest(SchemaBundleId2));

    List<String> response = tableAdmin.listSchemaBundles(testTable.getId());
    // Concurrent tests running may cause flakiness. Use containsAtLeast instead of
    // containsExactly.
    assertWithMessage("Got wrong schema bundle Ids in listSchemaBundles")
        .that(response)
        .containsAtLeast(
            tableAdmin.getSchemaBundle(testTable.getId(), SchemaBundleId1).getId(),
            tableAdmin.getSchemaBundle(testTable.getId(), SchemaBundleId2).getId());
  }

  @Test
  public void updateSchemaBundleAndDeleteSchemaBundleTest()
      throws InterruptedException, IOException, URISyntaxException {
    String SchemaBundleId = prefixGenerator.newPrefix();

    // Create a schema bundle.
    CreateSchemaBundleRequest request = createSchemaBundleRequest(SchemaBundleId);

    SchemaBundle response = tableAdmin.createSchemaBundle(request);

    // Update the schema bundle.
    byte[] content =
        Files.readAllBytes(Paths.get(getResourceFilePath(TEST_UPDATED_PROTO_SCHEMA_BUNDLE)));
    UpdateSchemaBundleRequest updateRequest =
        UpdateSchemaBundleRequest.of(testTable.getId(), SchemaBundleId)
            .setProtoSchemaFile(getResourceFilePath(TEST_UPDATED_PROTO_SCHEMA_BUNDLE));
    response = tableAdmin.updateSchemaBundle(updateRequest);
    assertWithMessage("Got wrong deletion protection in UpdateSchemaBundle")
        .that(response.getProtoSchema())
        .isEqualTo(ByteString.copyFrom(content));

    // Now we should be able to successfully delete the SchemaBundle.
    tableAdmin.deleteSchemaBundle(testTable.getId(), SchemaBundleId);
    try {
      for (int i = 0; i < BACKOFF_DURATION.length; i++) {
        tableAdmin.getSchemaBundle(testTable.getId(), SchemaBundleId);

        LOGGER.info(
            "Wait for "
                + BACKOFF_DURATION[i]
                + " seconds for deleting schema bundle "
                + SchemaBundleId);
        Thread.sleep(BACKOFF_DURATION[i] * 1000);
      }
      fail("SchemaBundle was not deleted.");
    } catch (NotFoundException e) {
      assertWithMessage("Incorrect exception type")
          .that(e.getCause())
          .isInstanceOf(StatusRuntimeException.class);
    }
  }

  private CreateSchemaBundleRequest createSchemaBundleRequest(String SchemaBundleId)
      throws IOException, URISyntaxException {
    return CreateSchemaBundleRequest.of(testTable.getId(), SchemaBundleId)
        .setProtoSchemaFile(getResourceFilePath(TEST_PROTO_SCHEMA_BUNDLE));
  }

  private static Table createAndPopulateTestTable(
      BigtableTableAdminClient tableAdmin, BigtableDataClient dataClient)
      throws InterruptedException {
    String tableId = PrefixGenerator.newPrefix("BigtableSchemaBundleIT#createAndPopulateTestTable");
    Table testTable = tableAdmin.createTable(CreateTableRequest.of(tableId).addFamily("cf1"));

    // Populate test data.
    byte[] rowBytes = new byte[1024];
    Random random = new Random();
    random.nextBytes(rowBytes);

    try (Batcher<RowMutationEntry, Void> batcher = dataClient.newBulkMutationBatcher(tableId)) {
      for (int i = 0; i < 10; i++) {
        batcher.add(
            RowMutationEntry.create("test-row-" + i)
                .setCell("cf1", ByteString.EMPTY, ByteString.copyFrom(rowBytes)));
      }
    }
    return testTable;
  }

  private String getResourceFilePath(String filePath) throws URISyntaxException {
    ClassLoader cl = Thread.currentThread().getContextClassLoader();
    URL protoSchema = cl.getResource(filePath);
    return Paths.get(protoSchema.toURI()).toAbsolutePath().toString();
  }
}
