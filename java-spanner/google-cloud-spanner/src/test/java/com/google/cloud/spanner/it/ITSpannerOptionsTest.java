/*
 * Copyright 2019 Google LLC
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

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITSpannerOptionsTest {
  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static Database db;

  @BeforeClass
  public static void setUp() {
    db = env.getTestHelper().createTestDatabase();
  }

  @AfterClass
  public static void tearDown() {
    db.drop();
  }

  @Test
  public void testCompression() {
    for (String compressorName : new String[] {"gzip", "identity", null}) {
      SpannerOptions options =
          env.getTestHelper().getOptions().toBuilder().setCompressorName(compressorName).build();
      try (Spanner spanner = options.getService()) {
        DatabaseClient client = spanner.getDatabaseClient(db.getId());
        try (ResultSet rs = client.singleUse().executeQuery(Statement.of("SELECT 1 AS COL1"))) {
          assertThat(rs.next()).isTrue();
          assertThat(rs.getLong(0)).isEqualTo(1L);
          assertThat(rs.next()).isFalse();
        }
      }
    }
  }
}
