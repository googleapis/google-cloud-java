/*
 * Copyright (c) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.example;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.spi.SubCommand;
import org.kohsuke.args4j.spi.SubCommandHandler;
import org.kohsuke.args4j.spi.SubCommands;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Defines the different sub-commands and their parameters, for command-line invocation.
 */
class CryptFileCommands {
  /**
   * An interface for a command-line sub-command.
   */
  interface Command {
    public void run() throws IOException;
  }

  // Most of the commands take some subset of the same arguments, so specify groups of arguments
  // as classes for greater code reuse.
  static class Args {
    @Option(name = "--project-id", aliases = "-p", required = true, usage = "Your GCP project ID")
    String projectId;
    @Argument(metaVar = "ringId", required = true, index = 0, usage = "The ring id")
    String ringId;
    @Argument(metaVar = "keyId", required = true, index = 1, usage = "The key id")
    String keyId;
    @Argument(metaVar = "inFile", required = true, index = 2, usage = "The source file")
    String inFile;
    @Argument(metaVar = "outFile", required = true, index = 3, usage = "The destination file")
    String outFile;
  }

  public static class EncryptCommand extends Args implements Command {
    public void run() throws IOException {
      byte[] encrypted = CryptFile.encrypt(
          projectId, ringId, keyId,
          Files.readAllBytes(Paths.get(inFile)));

      FileOutputStream stream = new FileOutputStream(outFile);
      try {
        stream.write(encrypted);
      } finally {
        stream.close();
      }
    }
  }

  public static class DecryptCommand extends Args implements Command {
    public void run() throws IOException {
      byte[] decrypted = CryptFile.decrypt(
          projectId, ringId, keyId,
          Files.readAllBytes(Paths.get(inFile)));

      FileOutputStream stream = new FileOutputStream(outFile);
      try {
        stream.write(decrypted);
      } finally {
        stream.close();
      }
    }
  }

  @Argument(metaVar = "command", required = true, handler = SubCommandHandler.class,
      usage = "The subcommand to run")
  @SubCommands({
      @SubCommand(name = "encrypt", impl = EncryptCommand.class),
      @SubCommand(name = "decrypt", impl = DecryptCommand.class)
      })
  Command command;
}
