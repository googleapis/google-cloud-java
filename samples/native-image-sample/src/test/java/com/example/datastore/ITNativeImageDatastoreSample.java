/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.datastore;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Key;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link com.example.datastore.NativeImageDatastoreSample}
 */
public class ITNativeImageDatastoreSample {

  private Datastore datastore;
  private ByteArrayOutputStream bout;
  private PrintStream out;

  @Before
  public void setUp() {
    datastore = DatastoreOptions.getDefaultInstance().getService();
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);

  }

  @Test
  public void testAddAndGetEntity() {
    bout.reset();
    String testId = "test-id-" + UUID.randomUUID();
    NativeImageDatastoreSample.addEntity(datastore, testId);
    NativeImageDatastoreSample.getEntity(datastore, testId);
    assertThat(bout.toString()).contains(
        "Reading entity: " + testId);

    NativeImageDatastoreSample.deleteEntity(datastore, testId);
  }

  @Test
  public void testRunTransactionalCallable() {
    bout.reset();
    String testId = "test-id-" + UUID.randomUUID();
    Key key = NativeImageDatastoreSample.createKey(datastore, testId);
    NativeImageDatastoreSample.runTransactionCallable(datastore, key);
    assertThat(bout.toString()).contains(
        "Found entity:" + "\n\t\tname=" + testId + "\n\t\tkind=test-kind"
            + "\n\t\tnamespace=nativeimage-test-namespace"
            + "\n\t\tproperties={description=StringValue{valueType=STRING, excludeFromIndexes=false,"
            + " meaning=0, value=hello world}}\n"
            + "Ran transaction callable.");

    NativeImageDatastoreSample.deleteEntity(datastore, "test-id");
  }
}