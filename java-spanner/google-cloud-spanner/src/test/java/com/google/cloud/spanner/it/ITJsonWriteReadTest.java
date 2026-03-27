/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.it;

import static com.google.cloud.spanner.testing.ExperimentalHostHelper.isExperimentalHost;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assume.assumeFalse;

import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Value;
import com.google.cloud.spanner.testing.RemoteSpannerHelper;
import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITJsonWriteReadTest {

  private static final String RESOURCES_DIR = "com/google/cloud/spanner/it/";
  private static final String VALID_JSON_DIR = "valid";
  private static final String INVALID_JSON_DIR = "invalid";

  private static final String TABLE_NAME = "TestTable";

  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();

  private static DatabaseClient databaseClient;

  @BeforeClass
  public static void beforeClass() {
    final RemoteSpannerHelper testHelper = env.getTestHelper();
    final Database database =
        testHelper.createTestDatabase(
            "CREATE TABLE "
                + TABLE_NAME
                + "("
                + "Id INT64 NOT NULL,"
                + "json JSON"
                + ") PRIMARY KEY (Id)");
    databaseClient = testHelper.getDatabaseClient(database);
  }

  @Test
  public void testWriteValidJsonValues() throws IOException {
    List<String> resources = getJsonFilePaths(RESOURCES_DIR + File.separator + VALID_JSON_DIR);

    long id = 0L;
    List<Mutation> mutations = new ArrayList<>();
    for (String resource : resources) {
      String jsonStr =
          Resources.toString(
              Resources.getResource(this.getClass(), VALID_JSON_DIR + File.separator + resource),
              StandardCharsets.UTF_8);
      Mutation mutation =
          Mutation.newInsertBuilder(TABLE_NAME)
              .set("Id")
              .to(id++)
              .set("json")
              .to(Value.json(jsonStr))
              .build();
      mutations.add(mutation);
    }
    databaseClient.write(mutations);

    try (ResultSet resultSet =
        databaseClient
            .singleUse()
            .executeQuery(Statement.of("SELECT COUNT(*) FROM " + TABLE_NAME))) {
      resultSet.next();
      assertEquals(resultSet.getLong(0), resources.size());
    }
  }

  @Test
  public void testWriteAndReadInvalidJsonValues() throws IOException {
    assumeFalse("Tracking the failure via b/441255097 for experimental host", isExperimentalHost());
    List<String> resources = getJsonFilePaths(RESOURCES_DIR + File.separator + INVALID_JSON_DIR);

    AtomicLong id = new AtomicLong(100);
    for (String resource : resources) {
      String jsonStr =
          Resources.toString(
              Resources.getResource(this.getClass(), INVALID_JSON_DIR + File.separator + resource),
              StandardCharsets.UTF_8);

      SpannerException exception =
          assertThrows(
              SpannerException.class,
              () ->
                  databaseClient.write(
                      Collections.singletonList(
                          Mutation.newInsertBuilder(TABLE_NAME)
                              .set("Id")
                              .to(id.getAndIncrement())
                              .set("json")
                              .to(Value.json(jsonStr))
                              .build())));

      if (env.getTestHelper()
          .getOptions()
          .getSessionPoolOptions()
          .getUseMultiplexedSessionForRW()) {
        assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
      } else {
        assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
      }
    }
  }

  private List<String> getJsonFilePaths(String folder) throws IOException {
    String fixturesRoot = Resources.getResource(folder).getPath();
    final Path fixturesRootPath = Paths.get(fixturesRoot);
    return Files.walk(fixturesRootPath)
        .filter(Files::isRegularFile)
        .map(path -> fixturesRootPath.relativize(path).toString())
        .filter(path -> path.endsWith(".json"))
        .collect(Collectors.toList());
  }
}
