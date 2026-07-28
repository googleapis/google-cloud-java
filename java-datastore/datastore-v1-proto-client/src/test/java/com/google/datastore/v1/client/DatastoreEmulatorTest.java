/*
 * Copyright 2015 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.datastore.v1.client;

import static org.junit.Assert.fail;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for {@link DatastoreEmulator}. */
@RunWith(JUnit4.class)
public class DatastoreEmulatorTest {

  @Test
  public void testLifecycle() throws DatastoreEmulatorException {
    DatastoreEmulatorOptions options =
        new DatastoreEmulatorOptions.Builder().setCommand("/yar").setProjectId("myproject").build();

    DatastoreEmulator datastore =
        new DatastoreEmulator(null, "blar", options) {
          @Override
          void startEmulatorInternal(
              String emulatorDir, String projectId, List<String> cmdLineOpts) {
            // no-op for testing
          }

          @Override
          protected void stopEmulatorInternal() {
            // no-op for testing
          }
        };

    datastore.start();
    try {
      datastore.start();
      fail("expected exception");
    } catch (IllegalStateException e) {
      // good
    }

    datastore.stop();
    // It's ok to stop if we've already stopped.
    datastore.stop();

    // Once we've stopped we can't start again.
    try {
      datastore.start();
      fail("expected exception");
    } catch (IllegalStateException e) {
      // good
    }
  }
}
