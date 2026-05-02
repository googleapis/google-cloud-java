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

package com.google.cloud.datastore;

import com.google.cloud.datastore.testing.LocalDatastoreHelper;
import java.io.IOException;
import java.time.Duration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

class DatastoreTestHttp extends AbstractDatastoreTest {

  private static final LocalDatastoreHelper helper = LocalDatastoreHelper.create(1.0, 9090);

  private static DatastoreOptions staticOptions;
  private static Datastore staticDatastore;

  @BeforeAll
  static void beforeAll() throws IOException, InterruptedException {
    helper.start();
    staticOptions = helper.getOptions(); // Use HTTP options as name implies
    staticDatastore = staticOptions.getService();
  }

  @BeforeEach
  void setUp() {
    this.options = staticOptions;
    this.datastore = staticDatastore;
    initialize();
  }

  @AfterAll
  static void afterAll() throws Exception {
    staticDatastore.close();
    helper.stopDuration(Duration.ofMinutes(1));
  }
}
