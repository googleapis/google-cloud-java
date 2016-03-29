/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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
package com.google.datastore.v1beta3.client;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link LocalDevelopmentDatastore}.
 */
@RunWith(JUnit4.class)
public class LocalDevelopmentDatastoreTest {

  private static final LocalDevelopmentDatastoreOptions options =
      new LocalDevelopmentDatastoreOptions.Builder().build();

  @Test
  public void testArgs() throws LocalDevelopmentDatastoreException {
    LocalDevelopmentDatastore datastore = new LocalDevelopmentDatastore(null, "blar", options) {
      @Override
      void startDatastoreInternal(String sdkPath, String dataset, String... cmdLineOpts) {
        // no-op for testing
      }
    };

    try {
      datastore.start(null, "dataset");
      fail("expected exception");
    } catch (NullPointerException npe) {
      // good
    }

    try {
      datastore.start("path/to/sdk", null);
      fail("expected exception");
    } catch (NullPointerException npe) {
      // good
    }

    datastore.start("path/to/sdk", "dataset");
  }

  @Test
  public void testLifecycle() throws LocalDevelopmentDatastoreException {
    LocalDevelopmentDatastore datastore = new LocalDevelopmentDatastore(null, "blar", options) {
      @Override
      void startDatastoreInternal(String sdkPath, String dataset, String... cmdLineOpts) {
        // no-op for testing
      }

      @Override
      protected void stopDatastoreInternal() {
        // no-op for testing
      }
    };

    String sdkPath = "/yar";
    String myApp = "myapp";

    datastore.start(sdkPath, myApp);
    try {
      datastore.start(sdkPath, myApp);
      fail("expected exception");
    } catch (IllegalStateException e) {
      // good
    }

    datastore.stop();
    // it's ok to stop if we've already stopped
    datastore.stop();

    // once we've stopped we can't start again
    try {
      datastore.start(sdkPath, myApp);
      fail("expected exception");
    } catch (IllegalStateException e) {
      // good
    }
  }
}
