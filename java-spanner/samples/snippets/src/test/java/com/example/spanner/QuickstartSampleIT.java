/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.spanner;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for quickstart sample.
 */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class QuickstartSampleIT {
  private static String instanceId = System.getProperty("spanner.test.instance");
  private static String dbId = formatForTest(System.getProperty("spanner.quickstart.database"));
  private static Spanner spanner;
  private static DatabaseAdminClient dbClient;

  private ByteArrayOutputStream bout;
  private PrintStream stdOut = System.out;
  private PrintStream out;

  @BeforeClass
  public static void createDatabase() throws InterruptedException, ExecutionException {
    final SpannerOptions options =
        SpannerOptions.newBuilder().setAutoThrottleAdministrativeRequests().build();
    spanner = options.getService();
    dbClient = spanner.getDatabaseAdminClient();
    dbClient.createDatabase(instanceId, dbId, Collections.emptyList()).get();
  }

  @AfterClass
  public static void dropDatabase() {
    dbClient.dropDatabase(instanceId, dbId);
    spanner.close();
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() {
    System.setOut(stdOut);
  }

  @Test
  public void testQuickstart() throws Exception {
    assertThat(instanceId).isNotNull();
    assertThat(dbId).isNotNull();
    QuickstartSample.main(instanceId, dbId);
    String got = bout.toString();
    assertThat(got).contains("1");
  }

  private static String formatForTest(String name) {
    return name + "-" + UUID.randomUUID().toString().substring(0, 20);
  }
}
