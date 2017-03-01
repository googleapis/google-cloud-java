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

package com.google.cloud.testing;

import com.google.api.client.util.Charsets;
import com.google.cloud.ServiceOptions;
import com.google.cloud.testing.BaseEmulatorHelper.EmulatorRunner;
import com.google.common.collect.ImmutableList;

import org.easymock.EasyMock;
import org.joda.time.Duration;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

public class BaseEmulatorHelperTest {

  private static final String BLOCK_UNTIL = "Block until";

  private static class TestEmulatorHelper extends BaseEmulatorHelper<ServiceOptions> {

    private final List<EmulatorRunner> runners;
    private final String blockUntil;

    private TestEmulatorHelper(List<EmulatorRunner> runners, String blockUntil) {
      super("emulator", 1, "project");
      this.runners = runners;
      this.blockUntil = blockUntil;
    }

    @Override
    protected List<EmulatorRunner> getEmulatorRunners() {
      return runners;
    }

    @Override
    protected Logger getLogger() {
      return null;
    }

    @Override
    public ServiceOptions getOptions() {
      return null;
    }

    @Override
    public void start() throws IOException, InterruptedException {
      startProcess(blockUntil);
    }

    @Override
    public void stop(Duration timeout) throws IOException, InterruptedException, TimeoutException {
      waitForProcess(timeout);
    }

    @Override
    public void reset() throws IOException {
      // do nothing
    }
  }

  @Test
  public void testEmulatorHelper() throws IOException, InterruptedException, TimeoutException {
    Process process = EasyMock.createStrictMock(Process.class);
    InputStream stream = new ByteArrayInputStream(BLOCK_UNTIL.getBytes(Charsets.UTF_8));
    EmulatorRunner emulatorRunner = EasyMock.createStrictMock(EmulatorRunner.class);
    EasyMock.expect(process.getInputStream()).andReturn(stream);
    EasyMock.expect(emulatorRunner.isAvailable()).andReturn(true);
    emulatorRunner.start();
    EasyMock.expectLastCall();
    EasyMock.expect(emulatorRunner.getProcess()).andReturn(process);
    emulatorRunner.waitFor(Duration.standardMinutes(1));
    EasyMock.expectLastCall().andReturn(0);
    EasyMock.replay(process, emulatorRunner);
    TestEmulatorHelper helper =
        new TestEmulatorHelper(ImmutableList.of(emulatorRunner), BLOCK_UNTIL);
    helper.start();
    helper.stop(Duration.standardMinutes(1));
    EasyMock.verify();
  }

  @Test
  public void testEmulatorHelperMultipleRunners() throws IOException, InterruptedException, TimeoutException {
    Process process = EasyMock.createStrictMock(Process.class);
    InputStream stream = new ByteArrayInputStream(BLOCK_UNTIL.getBytes(Charsets.UTF_8));
    EmulatorRunner firstRunner = EasyMock.createStrictMock(EmulatorRunner.class);
    EmulatorRunner secondRunner = EasyMock.createStrictMock(EmulatorRunner.class);
    EasyMock.expect(process.getInputStream()).andReturn(stream);
    EasyMock.expect(firstRunner.isAvailable()).andReturn(false);
    EasyMock.expect(secondRunner.isAvailable()).andReturn(true);
    secondRunner.start();
    EasyMock.expectLastCall();
    EasyMock.expect(secondRunner.getProcess()).andReturn(process);
    secondRunner.waitFor(Duration.standardMinutes(1));
    EasyMock.expectLastCall().andReturn(0);
    EasyMock.replay(process, secondRunner);
    TestEmulatorHelper helper =
        new TestEmulatorHelper(ImmutableList.of(firstRunner, secondRunner), BLOCK_UNTIL);
    helper.start();
    helper.stop(Duration.standardMinutes(1));
    EasyMock.verify();
  }
}
