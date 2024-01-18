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

package com.google.cloud.examples.nio;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.spi.FileSystemProvider;

/**
 * Stat is a super-simple program that just displays the size of the file passed as argument.
 *
 * <p>It's meant to be used to test Google Cloud's integration with Java NIO.
 *
 * <p>You can either use the '--check' argument to see whether Google Cloud Storage is enabled, or
 * you can directly pass in a Google Cloud Storage file name to use. In that case you have to be
 * logged in (using e.g. the gcloud auth command).
 *
 * <p>See the <a
 * href="https://github.com/googleapis/google-cloud-java/blob/master/google-cloud-examples/README.md">
 * README</a> for compilation instructions. Run this code with
 *
 * <pre>{@code target/appassembler/bin/Stat --help | --check | --list | <file>}</pre>
 *
 * <p>In short, this version (in google-cloud-examples) is in a package that lists google-cloud-nio
 * as a dependency, so it will work directly without having to do any special work.
 */
public class Stat {

  /** See the class documentation. */
  public static void main(String[] args) throws IOException {
    if (args.length == 0 || args[0].equals("--help")) {
      help();
      return;
    }
    if (args[0].equals("--list")) {
      listFilesystems();
      return;
    }
    if (args[0].equals("--check")) {
      checkGcs();
      return;
    }
    for (String a : args) {
      statFile(a);
    }
  }

  /**
   * Print the length of the indicated file.
   *
   * <p>This uses the normal Java NIO Api, so it can take advantage of any installed NIO Filesystem
   * provider without any extra effort.
   */
  private static void statFile(String fname) {
    try {
      Path path = Paths.get(new URI(fname));
      long size = Files.size(path);
      System.out.println(fname + ": " + size + " bytes.");
    } catch (Exception ex) {
      System.out.println(fname + ": " + ex.toString());
    }
  }

  private static void help() {
    String[] help = {
      "The arguments can be one of:",
      " * <path>",
      "   to display the length of that file.",
      "",
      " * --list",
      "   to list the filesystem providers.",
      "",
      " * --check",
      "   to double-check the Google Cloud Storage provider is installed.",
      "",
      "The purpose of this tool is to demonstrate that the Google Cloud NIO filesystem provider",
      "can add Google Cloud Storage support to programs not explicitly designed for it.",
      "",
      "This tool normally knows nothing of Google Cloud Storage. If you pass it --check",
      "or a Google Cloud Storage file name (e.g. gs://mybucket/myfile), it will show an error.",
      "However, by just adding the google-cloud-nio jar as a dependency and recompiling, this",
      "tool is made aware of gs:// paths and can access files on the cloud.",
      "",
      "The Google Cloud NIO filesystem provider can similarly enable existing Java 7 programs",
      "to read and write cloud files, even if they have no special built-in cloud support."
    };
    for (String s : help) {
      System.out.println(s);
    }
  }

  private static void listFilesystems() {
    System.out.println("Installed filesystem providers:");
    for (FileSystemProvider p : FileSystemProvider.installedProviders()) {
      System.out.println("  " + p.getScheme());
    }
  }

  private static void checkGcs() {
    FileSystem fs = FileSystems.getFileSystem(URI.create("gs://domain-registry-alpha"));
    System.out.println("Success! We can instantiate a gs:// filesystem.");
    System.out.println("isOpen: " + fs.isOpen());
    System.out.println("isReadOnly: " + fs.isReadOnly());
  }
}
