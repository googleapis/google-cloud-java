/*
 * Copyright 2020 Google Inc.
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

package com.example.logging;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.Sink;
import com.google.cloud.logging.SinkInfo;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for sink sample. */
@RunWith(JUnit4.class)
public class SinkIT {

  private Logging logging = LoggingOptions.getDefaultInstance().getService();
  private static final String SINK_NAME = "test-sink" + UUID.randomUUID().toString();

  @Before
  public void setUp() {
    // Create sink
    logging.create(
        SinkInfo.newBuilder(SINK_NAME, SinkInfo.Destination.DatasetDestination.of("dataset"))
            .setFilter("severity>=ERROR")
            .setVersionFormat(SinkInfo.VersionFormat.V2)
            .build());
  }

  @After
  public void tearDown() throws Exception {
    // Delete sink
    logging.deleteSink(SINK_NAME);
    logging.close();
  }

  @Test
  public void testGetSinkMetadata() throws Exception {
    Sink sink = logging.getSink(SINK_NAME);
    assertNotNull(sink);
    PrintStream standardOut = System.out;
    ByteArrayOutputStream snippetOutputCapture = new ByteArrayOutputStream();
    System.setOut(new PrintStream(snippetOutputCapture));
    GetSinkMetadata.getSinkMetadata(SINK_NAME);
    String snippetOutput = snippetOutputCapture.toString();
    System.setOut(standardOut);
    assertTrue(snippetOutput.contains(("Name:" + sink.getName())));
    assertTrue(snippetOutput.contains(("Version Format:" + sink.getVersionFormat())));
    assertTrue(snippetOutput.contains(("Filter:" + sink.getFilter())));
    assertTrue(snippetOutput.contains(("Destination:" + sink.getDestination())));
  }
}
