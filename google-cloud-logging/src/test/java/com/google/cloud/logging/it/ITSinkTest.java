/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.logging.it;

import static com.google.cloud.logging.testing.RemoteLoggingHelper.formatForTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.api.gax.paging.Page;
import com.google.cloud.logging.BaseSystemTest;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingException;
import com.google.cloud.logging.Sink;
import com.google.cloud.logging.SinkInfo;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSinkTest extends BaseSystemTest {

  @BeforeClass
  public static void setUp() {
    // Cleanup all stucked sinks if any
    Logging.ListOption[] options = {Logging.ListOption.pageSize(50)};
    Page<Sink> sinkPage = logging.listSinks(options);
    Iterator<Sink> iterator = sinkPage.iterateAll().iterator();
    while (iterator.hasNext()) {
      Sink sink = iterator.next();
      try {
        sink.delete();
      } catch (Exception ex) {
        System.err.println("ERROR: Failed to delete a " + sink.getName() + " sink, error: " + ex);
      }
    }
  }

  @Test
  public void testCreateGetUpdateAndDeleteSink() {
    String name = formatForTest("test-create-get-update-sink");
    SinkInfo sinkInfo =
        SinkInfo.newBuilder(name, SinkInfo.Destination.DatasetDestination.of("dataset"))
            .setFilter("severity>=ERROR")
            .setVersionFormat(SinkInfo.VersionFormat.V2)
            .build();
    Sink sink = logging.create(sinkInfo);
    assertEquals(name, sink.getName());
    assertEquals(SinkInfo.VersionFormat.V2, sink.getVersionFormat());
    assertEquals("severity>=ERROR", sink.getFilter());
    SinkInfo.Destination.DatasetDestination datasetDestination = sink.getDestination();
    assertEquals(logging.getOptions().getProjectId(), datasetDestination.getProject());
    assertEquals("dataset", datasetDestination.getDataset());
    assertEquals(sink, logging.getSink(name));
    sink = sink.toBuilder().setFilter("severity<=ERROR").build().update();
    assertEquals(name, sink.getName());
    assertEquals(SinkInfo.VersionFormat.V2, sink.getVersionFormat());
    assertEquals("severity<=ERROR", sink.getFilter());
    assertTrue(sink.delete());
    assertFalse(sink.delete());
  }

  @Test
  public void testUpdateNonExistingSink() {
    String name = formatForTest("test-update-non-existing-sink");
    SinkInfo sinkInfo =
        SinkInfo.newBuilder(name, SinkInfo.Destination.DatasetDestination.of("dataset"))
            .setFilter("severity>=ERROR")
            .setVersionFormat(SinkInfo.VersionFormat.V2)
            .build();
    assertNull(logging.getSink(name));
    try {
      logging.update(sinkInfo);
      fail();
    } catch (LoggingException expected) {
      assertNotNull(expected.getMessage());
    }
  }

  @Test
  public void testListSinks() throws InterruptedException {
    String firstName = formatForTest("test-list-sinks-1");
    String secondName = formatForTest("test-list-sinks-2");
    Sink firstSink =
        logging.create(
            SinkInfo.of(firstName, SinkInfo.Destination.DatasetDestination.of("dataset")));
    Sink secondSink =
        logging.create(
            SinkInfo.of(secondName, SinkInfo.Destination.DatasetDestination.of("dataset")));
    Logging.ListOption[] options = {Logging.ListOption.pageSize(1)};
    Page<Sink> sinkPage = logging.listSinks(options);
    Set<Sink> sinks = Sets.newHashSet(sinkPage.iterateAll());
    while (!sinks.contains(firstSink) || !sinks.contains(secondSink)) {
      Thread.sleep(500);
      sinks = Sets.newHashSet(logging.listSinks(options).iterateAll());
    }
    firstSink.delete();
    secondSink.delete();
  }
}
