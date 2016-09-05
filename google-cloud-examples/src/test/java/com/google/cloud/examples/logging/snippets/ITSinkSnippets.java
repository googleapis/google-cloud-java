/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.examples.logging.snippets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.logging.Logging;
import com.google.cloud.logging.Sink;
import com.google.cloud.logging.SinkInfo;
import com.google.cloud.logging.SinkInfo.Destination;
import com.google.cloud.logging.testing.RemoteLoggingHelper;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

public class ITSinkSnippets {

  private static final String SINK_NAME = RemoteLoggingHelper.formatForTest("it_sink_snippets");
  private static final String SINK_FILTER = "severity>=ERROR";
  private static final String UPDATED_SINK_FILTER = "severity<=ERROR";
  private static final String DESTINATION = "dataset";

  private static Logging logging;
  private static SinkSnippets sinkSnippets;

  @BeforeClass
  public static void beforeClass() {
    RemoteLoggingHelper helper = RemoteLoggingHelper.create();
    logging = helper.options().service();
    SinkInfo sinkInfo = SinkInfo.builder(SINK_NAME, Destination.DatasetDestination.of(DESTINATION))
        .filter(SINK_FILTER)
        .build();
    sinkSnippets = new SinkSnippets(logging.create(sinkInfo));
  }

  @AfterClass
  public static void afterClass() throws Exception {
    if (logging != null) {
      logging.close();
    }
  }

  @Test
  public void testSink() throws InterruptedException, ExecutionException {
    Sink sink = sinkSnippets.reload();
    assertNotNull(sink);
    Sink updatedSink = sinkSnippets.update();
    assertEquals(UPDATED_SINK_FILTER, updatedSink.filter());
    updatedSink = sinkSnippets.reloadAsync();
    assertNotNull(updatedSink);
    assertEquals(UPDATED_SINK_FILTER, updatedSink.filter());
    sink.update();
    updatedSink = sinkSnippets.updateAsync();
    assertEquals(UPDATED_SINK_FILTER, updatedSink.filter());
    assertTrue(sinkSnippets.delete());
    assertFalse(sinkSnippets.deleteAsync());
  }
}
