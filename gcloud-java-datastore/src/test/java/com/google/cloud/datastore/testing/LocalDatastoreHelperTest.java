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

package com.google.cloud.datastore.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.cloud.AuthCredentials;
import com.google.cloud.datastore.DatastoreOptions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LocalDatastoreHelperTest {

  private static final double TOLERANCE = 0.00001;
  private static final String PROJECT_ID_PREFIX = "test-project-";
  private static final String NAMESPACE = "namespace";

  @Test
  public void testCreate() {
    LocalDatastoreHelper helper = LocalDatastoreHelper.create(0.75);
    assertTrue(Math.abs(0.75 - helper.consistency()) < TOLERANCE);
    assertTrue(helper.projectId().startsWith(PROJECT_ID_PREFIX));
    helper = LocalDatastoreHelper.create();
    assertTrue(Math.abs(0.9 - helper.consistency()) < TOLERANCE);
    assertTrue(helper.projectId().startsWith(PROJECT_ID_PREFIX));
  }

  @Test
  public void testOptions() {
    LocalDatastoreHelper helper = LocalDatastoreHelper.create();
    DatastoreOptions options = helper.options();
    assertTrue(options.projectId().startsWith(PROJECT_ID_PREFIX));
    assertTrue(options.host().startsWith("localhost:"));
    assertSame(AuthCredentials.noAuth(), options.authCredentials());
    options = helper.options(NAMESPACE);
    assertTrue(options.projectId().startsWith(PROJECT_ID_PREFIX));
    assertTrue(options.host().startsWith("localhost:"));
    assertSame(AuthCredentials.noAuth(), options.authCredentials());
    assertEquals(NAMESPACE, options.namespace());
  }
}
