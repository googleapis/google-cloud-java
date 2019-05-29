/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.testing;

import static org.junit.Assert.assertEquals;

import com.google.api.client.util.Charsets;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class BlockingProcessStreamReaderTest {

  private static final String BLOCK_UNTIL = "Dev App Server is now running";
  private static final String OUTPUT = "First Line\n" + "Second Line\n" + BLOCK_UNTIL;
  private static final String OUTPUT_WITH_LOGS =
      "First Line\n"
          + BLOCK_UNTIL
          + "\n"
          + "Nov 08, 2016 2:05:44 PM io.netty.buffer.PooledByteBufAllocator <clinit>\n"
          + "INFO: log line 1\n"
          + "log line 2\n"
          + "Nov 08, 2016 2:05:44 PM io.netty.buffer.PooledByteBufAllocator <clinit>\n"
          + "FINE: log line 3\n";
  private static final String TAGGED_OUTPUT_WITH_LOGS =
      "[emulator] First Line\n"
          + "[emulator]"
          + BLOCK_UNTIL
          + "\n"
          + "[emulator] Nov 08, 2016 2:05:44 PM io.netty.buffer.PooledByteBufAllocator <clinit>\n"
          + "[emulator] INFO: log line 1\n"
          + "[emulator] log line 2\n"
          + "[emulator] Nov 08, 2016 2:05:44 PM io.netty.buffer.PooledByteBufAllocator <clinit>\n"
          + "[emulator] FINE: log line 3\n";

  @Rule public Timeout globalTimeout = Timeout.seconds(10);

  private static final class TestLogger extends Logger {

    private final Multimap<Level, String> logs = LinkedHashMultimap.create();

    private TestLogger() {
      super("text-logger", null);
    }

    public void log(Level level, String msg) {
      logs.put(level, msg);
    }

    Multimap<Level, String> getLogs() {
      return logs;
    }
  }

  @Test
  public void testForwardLogEntry() throws IOException, InterruptedException {
    TestLogger logger = new TestLogger();
    InputStream stream = new ByteArrayInputStream(OUTPUT_WITH_LOGS.getBytes(Charsets.UTF_8));
    BlockingProcessStreamReader.start("emulator", stream, BLOCK_UNTIL, logger).join();
    assertEquals(
        "[emulator] log line 1" + System.lineSeparator() + "[emulator] log line 2",
        logger.getLogs().get(Level.INFO).iterator().next());
    assertEquals("[emulator] log line 3", logger.getLogs().get(Level.FINE).iterator().next());
    stream.close();
  }

  @Test
  public void testForwardAlreadyTaggedLogs() throws IOException, InterruptedException {
    TestLogger logger = new TestLogger();
    InputStream stream = new ByteArrayInputStream(TAGGED_OUTPUT_WITH_LOGS.getBytes(Charsets.UTF_8));
    BlockingProcessStreamReader.start("emulator", stream, BLOCK_UNTIL, logger).join();
    assertEquals(
        "[emulator] log line 1" + System.lineSeparator() + "[emulator] log line 2",
        logger.getLogs().get(Level.INFO).iterator().next());
    assertEquals("[emulator] log line 3", logger.getLogs().get(Level.FINE).iterator().next());
    stream.close();
  }
}
