package com.google.gcloud.nio.examples;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.spi.FileSystemProvider;

/**
 * ListFilesystems is a super-simple program that lists the available NIO filesystems.

 */
public class ListFilesystems {

  /**
   * See the class documentation.
   */
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
