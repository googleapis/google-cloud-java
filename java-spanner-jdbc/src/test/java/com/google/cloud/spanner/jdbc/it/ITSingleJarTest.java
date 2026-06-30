/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.spanner.jdbc.it;

import static org.junit.Assert.assertEquals;

import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.common.collect.ImmutableList;
import com.google.common.io.CharStreams;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests that the following works:
 *
 * <ol>
 *   <li>Build a single-jar-with-dependencies
 *   <li>Compile a simple Java application consisting of a single file and no dependencies to a
 *       class file
 *   <li>Run the simple Java application with only itself + the single-jar-with-dependencies on the
 *       class path
 * </ol>
 */
@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITSingleJarTest extends ITAbstractJdbcTest {
  @ClassRule public static JdbcIntegrationTestEnv env = new JdbcIntegrationTestEnv();

  private Database database;

  @Before
  public void setup() {
    database =
        env.getOrCreateDatabase(
            getDialect(),
            ImmutableList.of("create table test (id int64, value string(max)) primary key (id)"));
  }

  @Test
  public void testUseSingleJar() throws Exception {
    buildSingleJar();
    buildMainClass();
    runTestApplication();
  }

  @Test
  public void testUseShadedJar() throws Exception {
    buildShadedJar();
    buildMainClass();
    runTestApplication();
  }

  private void runTestApplication() throws Exception {
    DatabaseId id = database.getId();
    ProcessBuilder builder = new ProcessBuilder();
    if (System.getenv("SPANNER_EMULATOR_HOST") != null) {
      builder.environment().put("SPANNER_EMULATOR_HOST", System.getenv("SPANNER_EMULATOR_HOST"));
    }
    // This runs the simple test application with only the shaded jar on the classpath.
    builder.command(
        "java",
        "-cp",
        "./target/single/test/:target/single/single.jar",
        "com/google/cloud/spanner/jdbc/SingleJarTestApplication",
        id.getInstanceId().getProject(),
        id.getInstanceId().getInstance(),
        id.getDatabase());
    execute(builder);
  }

  private void buildSingleJar() throws Exception {
    ProcessBuilder builder = new ProcessBuilder();
    builder.command("mvn", "clean", "package", "-DskipTests", "-Dalt.build.dir=./target/single");
    execute(builder);
  }

  private void buildShadedJar() throws Exception {
    ProcessBuilder builder = new ProcessBuilder();
    builder.command(
        "mvn", "clean", "-Pshade", "package", "-DskipTests", "-Dalt.build.dir=./target/single");
    execute(builder);
  }

  private void buildMainClass() throws Exception {
    Files.createDirectories(Paths.get("target", "single", "test"));
    ProcessBuilder builder = new ProcessBuilder();
    builder.command(
        "javac",
        "src/test/java/com/google/cloud/spanner/jdbc/SingleJarTestApplication.java",
        "-d",
        "./target/single/test");
    execute(builder);
  }

  private void execute(ProcessBuilder builder) throws Exception {
    Process process = builder.start();
    String errors;
    try (InputStreamReader reader = new InputStreamReader(process.getErrorStream())) {
      errors = CharStreams.toString(reader);
    }
    assertEquals(errors, 0, process.waitFor());
  }
}
