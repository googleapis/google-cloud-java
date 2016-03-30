/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.datastore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.gcloud.AuthCredentials;
import com.google.gcloud.datastore.testing.LocalDatastoreHelper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

@RunWith(JUnit4.class)
public class LocalDatastoreHelperTest {

  private static final String PROJECT_ID = "some-project-id";
  private static final double TOLERANCE = 0.00001;

  @Test
  public void testStart() throws IOException, InterruptedException {
    LocalDatastoreHelper helper = LocalDatastoreHelper.start(PROJECT_ID, 0.75);
    assertTrue(Math.abs(0.75 - helper.consistency()) < TOLERANCE);
    assertEquals(PROJECT_ID, helper.projectId());
    helper.stop();
    helper = LocalDatastoreHelper.start();
    assertTrue(Math.abs(0.9 - helper.consistency()) < TOLERANCE);
    assertEquals(LocalDatastoreHelper.DEFAULT_PROJECT_ID, helper.projectId());
    helper.stop();
  }

  @Test
  public void testOptions() throws IOException, InterruptedException {
    LocalDatastoreHelper helper = LocalDatastoreHelper.start();
    DatastoreOptions options = helper.options();
    assertEquals(LocalDatastoreHelper.DEFAULT_PROJECT_ID, options.projectId());
    assertEquals("http://localhost:" + helper.port(), options.host());
    assertSame(AuthCredentials.noAuth(), options.authCredentials());
    helper.stop();
  }
}
