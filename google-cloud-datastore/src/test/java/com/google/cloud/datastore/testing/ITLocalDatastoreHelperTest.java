/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.datastore.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.cloud.NoCredentials;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreException;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeoutException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class ITLocalDatastoreHelperTest {

  private static final double TOLERANCE = 0.00001;
  private static final String PROJECT_ID_PREFIX = "test-project-";
  private static final String NAMESPACE = "namespace";
  private Path dataDir;

  @Before
  public void setUp() throws IOException {
    dataDir = Files.createTempDirectory("gcd");
  }

  @After
  public void tearDown() throws IOException {
    LocalDatastoreHelper.deleteRecursively(dataDir);
  }

  @Test
  public void testCreate() {
    LocalDatastoreHelper helper = LocalDatastoreHelper.create(0.75);
    assertTrue(Math.abs(0.75 - helper.getConsistency()) < TOLERANCE);
    assertTrue(helper.getProjectId().startsWith(PROJECT_ID_PREFIX));
    helper = LocalDatastoreHelper.create();
    assertTrue(Math.abs(0.9 - helper.getConsistency()) < TOLERANCE);
    assertTrue(helper.getProjectId().startsWith(PROJECT_ID_PREFIX));
  }

  @Test
  public void testCreateWithBuilder() {
    LocalDatastoreHelper helper =
        LocalDatastoreHelper.newBuilder()
            .setConsistency(0.75)
            .setPort(8081)
            .setStoreOnDisk(false)
            .setDataDir(dataDir)
            .build();
    assertTrue(Math.abs(0.75 - helper.getConsistency()) < TOLERANCE);
    assertTrue(helper.getProjectId().startsWith(PROJECT_ID_PREFIX));
    assertFalse(helper.isStoreOnDisk());
    assertEquals(8081, helper.getPort());
    assertEquals(dataDir, helper.getGcdPath());
    LocalDatastoreHelper incompleteHelper = LocalDatastoreHelper.newBuilder().build();
    assertTrue(Math.abs(0.9 - incompleteHelper.getConsistency()) < TOLERANCE);
    assertTrue(incompleteHelper.getProjectId().startsWith(PROJECT_ID_PREFIX));
  }

  @Test
  public void testCreateWithToBuilder() throws IOException {
    LocalDatastoreHelper helper =
        LocalDatastoreHelper.newBuilder()
            .setConsistency(0.75)
            .setPort(8081)
            .setStoreOnDisk(false)
            .setDataDir(dataDir)
            .build();
    assertTrue(Math.abs(0.75 - helper.getConsistency()) < TOLERANCE);
    assertTrue(helper.getProjectId().startsWith(PROJECT_ID_PREFIX));
    assertFalse(helper.isStoreOnDisk());
    assertEquals(8081, helper.getPort());
    assertEquals(dataDir, helper.getGcdPath());
    LocalDatastoreHelper actualHelper = helper.toBuilder().build();
    assertLocalDatastoreHelpersEquivelent(helper, actualHelper);
    Path dataDir = Files.createTempDirectory("gcd_data_dir");
    actualHelper =
        helper
            .toBuilder()
            .setConsistency(0.85)
            .setPort(9091)
            .setStoreOnDisk(true)
            .setDataDir(dataDir)
            .build();
    assertTrue(Math.abs(0.85 - actualHelper.getConsistency()) < TOLERANCE);
    assertTrue(actualHelper.isStoreOnDisk());
    assertEquals(9091, actualHelper.getPort());
    assertEquals(dataDir, actualHelper.getGcdPath());
    LocalDatastoreHelper.deleteRecursively(dataDir);
  }

  @Test
  public void testCreatePort() {
    LocalDatastoreHelper helper = LocalDatastoreHelper.create(0.75, 8888);
    DatastoreOptions options = helper.getOptions(NAMESPACE);
    assertTrue(options.getHost().endsWith("8888"));
    assertTrue(Math.abs(0.75 - helper.getConsistency()) < TOLERANCE);
    helper = LocalDatastoreHelper.create();
    options = helper.getOptions(NAMESPACE);
    assertTrue(Math.abs(0.9 - helper.getConsistency()) < TOLERANCE);
    assertFalse(options.getHost().endsWith("8888"));
    assertFalse(options.getHost().endsWith("8080"));
    helper = LocalDatastoreHelper.create(9999);
    options = helper.getOptions(NAMESPACE);
    assertTrue(Math.abs(0.9 - helper.getConsistency()) < TOLERANCE);
    assertTrue(options.getHost().endsWith("9999"));
  }

  @Test
  public void testOptions() {
    LocalDatastoreHelper helper = LocalDatastoreHelper.create();
    DatastoreOptions options = helper.getOptions();
    assertTrue(options.getProjectId().startsWith(PROJECT_ID_PREFIX));
    assertTrue(options.getHost().startsWith("localhost:"));
    assertSame(NoCredentials.getInstance(), options.getCredentials());
    options = helper.getOptions(NAMESPACE);
    assertTrue(options.getProjectId().startsWith(PROJECT_ID_PREFIX));
    assertTrue(options.getHost().startsWith("localhost:"));
    assertSame(NoCredentials.getInstance(), options.getCredentials());
    assertEquals(NAMESPACE, options.getNamespace());
  }

  @Test
  public void testStartStopReset() throws IOException, InterruptedException, TimeoutException {
    try {
      LocalDatastoreHelper helper = LocalDatastoreHelper.create();
      helper.start();
      Datastore datastore = helper.getOptions().getService();
      Key key = datastore.newKeyFactory().setKind("kind").newKey("name");
      datastore.put(Entity.newBuilder(key).build());
      assertNotNull(datastore.get(key));
      helper.reset();
      assertNull(datastore.get(key));
      helper.stop(Duration.ofMinutes(1));
      datastore.get(key);
      Assert.fail();
    } catch (DatastoreException ex) {
      assertNotNull(ex.getMessage());
    }
  }

  @Test
  public void testStartStopResetWithBuilder()
      throws IOException, InterruptedException, TimeoutException {
    try {
      LocalDatastoreHelper helper = LocalDatastoreHelper.newBuilder().build();
      helper.start();
      Datastore datastore = helper.getOptions().getService();
      Key key = datastore.newKeyFactory().setKind("kind").newKey("name");
      datastore.put(Entity.newBuilder(key).build());
      assertNotNull(datastore.get(key));
      helper.reset();
      assertNull(datastore.get(key));
      helper.stop(Duration.ofMinutes(1));
      datastore.get(key);
      Assert.fail();
    } catch (DatastoreException ex) {
      assertNotNull(ex.getMessage());
    }
  }

  public void assertLocalDatastoreHelpersEquivelent(
      LocalDatastoreHelper expected, LocalDatastoreHelper actual) {
    assertEquals(expected.getConsistency(), actual.getConsistency(), 0);
    assertEquals(expected.isStoreOnDisk(), actual.isStoreOnDisk());
    assertEquals(expected.getGcdPath(), actual.getGcdPath());
  }
}
