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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.junit.Test;

public class CommandWrapperTest {

  private static final List<String> COMMAND = ImmutableList.of("my", "command");
  private static final List<String> WIN_COMMAND = ImmutableList.of("cmd", "/C", "my", "command");
  private static final List<String> UNIX_COMMAND = ImmutableList.of("bash", "my", "command");
  private static final Path DIRECTORY = Paths.get("my-path");
  private static final File WIN_NULL_FILE = new File("NUL:");
  private static final File UNIX_NULL_FILE = new File("/dev/null");

  @Test
  public void testCommandWrapperCommand() {
    CommandWrapper commandWrapper = CommandWrapper.create();
    commandWrapper.setCommand(COMMAND);
    ProcessBuilder processBuilder = commandWrapper.getBuilder();
    if (BaseEmulatorHelper.isWindows()) {
      assertEquals(WIN_COMMAND, processBuilder.command());
    } else {
      assertEquals(UNIX_COMMAND, processBuilder.command());
    }
    assertNull(processBuilder.directory());
    assertFalse(processBuilder.redirectErrorStream());
    assertEquals(ProcessBuilder.Redirect.PIPE, processBuilder.redirectError());
  }

  @Test
  public void testCommandWrapperRedirectErrorStream() {
    CommandWrapper commandWrapper = CommandWrapper.create();
    commandWrapper.setCommand(COMMAND);
    commandWrapper.setRedirectErrorStream();
    ProcessBuilder processBuilder = commandWrapper.getBuilder();
    if (BaseEmulatorHelper.isWindows()) {
      assertEquals(WIN_COMMAND, processBuilder.command());
    } else {
      assertEquals(UNIX_COMMAND, processBuilder.command());
    }
    assertNull(processBuilder.directory());
    assertTrue(processBuilder.redirectErrorStream());
    assertEquals(ProcessBuilder.Redirect.PIPE, processBuilder.redirectError());
  }

  @Test
  public void testCommandWrapperRedirectErrorInherit() {
    CommandWrapper commandWrapper = CommandWrapper.create();
    commandWrapper.setCommand(COMMAND);
    commandWrapper.setRedirectErrorInherit();
    ProcessBuilder processBuilder = commandWrapper.getBuilder();
    if (BaseEmulatorHelper.isWindows()) {
      assertEquals(WIN_COMMAND, processBuilder.command());
    } else {
      assertEquals(UNIX_COMMAND, processBuilder.command());
    }
    assertNull(processBuilder.directory());
    assertFalse(processBuilder.redirectErrorStream());
    assertEquals(ProcessBuilder.Redirect.INHERIT, processBuilder.redirectError());
  }

  @Test
  public void testCommandWrapperDirectory() {
    CommandWrapper commandWrapper = CommandWrapper.create();
    commandWrapper.setCommand(COMMAND);
    commandWrapper.setDirectory(DIRECTORY);
    ProcessBuilder processBuilder = commandWrapper.getBuilder();
    if (BaseEmulatorHelper.isWindows()) {
      assertEquals(WIN_COMMAND, processBuilder.command());
    } else {
      assertEquals(UNIX_COMMAND, processBuilder.command());
    }
    assertEquals(DIRECTORY, processBuilder.directory().toPath());
    assertFalse(processBuilder.redirectErrorStream());
    assertEquals(ProcessBuilder.Redirect.PIPE, processBuilder.redirectError());
  }

  @Test
  public void testCommandWrapperRedirectOutputToNull() {
    CommandWrapper commandWrapper = CommandWrapper.create();
    commandWrapper.setCommand(COMMAND);
    commandWrapper.setRedirectOutputToNull();
    ProcessBuilder processBuilder = commandWrapper.getBuilder();
    if (BaseEmulatorHelper.isWindows()) {
      assertEquals(WIN_COMMAND, processBuilder.command());
      assertEquals(ProcessBuilder.Redirect.to(WIN_NULL_FILE), processBuilder.redirectOutput());
    } else {
      assertEquals(UNIX_COMMAND, processBuilder.command());
      assertEquals(ProcessBuilder.Redirect.to(UNIX_NULL_FILE), processBuilder.redirectOutput());
    }
    assertNull(processBuilder.directory());
    assertFalse(processBuilder.redirectErrorStream());
    assertEquals(ProcessBuilder.Redirect.PIPE, processBuilder.redirectError());
  }
}
