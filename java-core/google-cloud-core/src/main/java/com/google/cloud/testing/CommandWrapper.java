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

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/** Utility class that executes system commands on both Windows and Unix. */
class CommandWrapper {

  private final List<String> prefix;
  private List<String> command;
  private String nullFilename;
  private boolean redirectOutputToNull;
  private boolean redirectErrorStream;
  private boolean redirectErrorInherit;
  private Path directory;

  private CommandWrapper() {
    this.prefix = new ArrayList<>();
    if (BaseEmulatorHelper.isWindows()) {
      this.prefix.add("cmd");
      this.prefix.add("/C");
      this.nullFilename = "NUL:";
    } else {
      this.prefix.add("bash");
      this.nullFilename = "/dev/null";
    }
  }

  CommandWrapper setCommand(List<String> command) {
    this.command = new ArrayList<>(command.size() + this.prefix.size());
    this.command.addAll(prefix);
    this.command.addAll(command);
    return this;
  }

  CommandWrapper setRedirectOutputToNull() {
    this.redirectOutputToNull = true;
    return this;
  }

  CommandWrapper setRedirectErrorStream() {
    this.redirectErrorStream = true;
    return this;
  }

  CommandWrapper setRedirectErrorInherit() {
    this.redirectErrorInherit = true;
    return this;
  }

  CommandWrapper setDirectory(Path directory) {
    this.directory = directory;
    return this;
  }

  ProcessBuilder getBuilder() {
    ProcessBuilder builder = new ProcessBuilder(command);
    if (redirectOutputToNull) {
      builder.redirectOutput(new File(nullFilename));
    }
    if (directory != null) {
      builder.directory(directory.toFile());
    }
    if (redirectErrorStream) {
      builder.redirectErrorStream(true);
    }
    if (redirectErrorInherit) {
      builder.redirectError(ProcessBuilder.Redirect.INHERIT);
    }
    return builder;
  }

  public Process start() throws IOException {
    return getBuilder().start();
  }

  static CommandWrapper create() {
    return new CommandWrapper();
  }
}
