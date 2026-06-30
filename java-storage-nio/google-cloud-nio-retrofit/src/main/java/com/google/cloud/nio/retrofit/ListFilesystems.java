/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.nio.retrofit;

import java.io.IOException;
import java.nio.file.spi.FileSystemProvider;

/**
 * ListFilesystems is a simple program that lists the available NIO filesystems.
 *
 * <p>Note that the code here doesn't do anything special to link in the google-cloud-nio code. It
 * doesn't use any of its methods.
 *
 * <p>The README explains how, by just adding the google-cloud-nio JAR in the classpath, this
 * program will magically gain the ability to read files on Google Cloud Storage.
 */
public class ListFilesystems {

  /** See the class documentation. */
  public static void main(String[] args) throws IOException {
    listFilesystems();
  }

  private static void listFilesystems() {
    System.out.println("Installed filesystem providers:");
    for (FileSystemProvider p : FileSystemProvider.installedProviders()) {
      System.out.println("  " + p.getScheme());
    }
  }
}
