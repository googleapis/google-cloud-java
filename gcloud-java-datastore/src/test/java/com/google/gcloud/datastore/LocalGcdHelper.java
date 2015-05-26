/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.datastore;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.common.base.Strings;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Utility to start and stop local Google Cloud Datastore process.
 */
public class LocalGcdHelper {

  private final String projectId;
  private Path gcdPath;
  private ProcessStreamReader processReader;

  public static final String DEFAULT_PROJECT_ID = "projectid1";
  public static final int PORT = 8080;
  private static final String GCD = "gcd-head";
  private static final String GCD_LOC = '/' + GCD + ".zip";

  private static class ProcessStreamReader extends Thread {

    private final Process process;
    private final BufferedReader reader;

    ProcessStreamReader(Process process, String blockUntil) throws IOException {
      super("Local GCD InputStream reader");
      setDaemon(true);
      this.process = process;
      reader =  new BufferedReader(new InputStreamReader(process.getInputStream()));
      if (!Strings.isNullOrEmpty(blockUntil)) {
        String line;
        do {
          line = reader.readLine();
        } while (line != null && !line.contains(blockUntil));
      }
    }

    void terminate() throws InterruptedException, IOException {
      process.destroy();
      process.waitFor();
      reader.close();
    }

    @Override
    public void run() {
      try {
        while (reader.readLine() != null) {
          // consume line
        }
      } catch (IOException e) {
        // ignore
      }
    }

    public static ProcessStreamReader start(Process process, String blockUntil) throws IOException {
      ProcessStreamReader thread = new ProcessStreamReader(process, blockUntil);
      thread.start();
      return thread;
    }
  }

  public LocalGcdHelper(String projectId) {
    this.projectId = projectId;
  }

  public void start() throws IOException, InterruptedException {
    sendQuitRequest();
    gcdPath = Files.createTempDirectory("gcd");
    File gcdFolder = gcdPath.toFile();
    gcdFolder.deleteOnExit();

    try (ZipInputStream zipIn = new ZipInputStream(getClass().getResourceAsStream(GCD_LOC))) {
      ZipEntry entry = zipIn.getNextEntry();
      while (entry != null) {
        File filePath = new File(gcdFolder, entry.getName());
        if (!entry.isDirectory()) {
          extractFile(zipIn, filePath);
        } else {
          filePath.mkdir();
        }
        zipIn.closeEntry();
        entry = zipIn.getNextEntry();
      }
    }

    File datasetFolder = new File(gcdFolder, GCD + '/' + projectId);
    deleteRecurse(datasetFolder.toPath());

    // TODO: if System.getProperty("os.name").startsWith("Windows") use cmd.exe /c and gcd.cmd
    Process temp = new ProcessBuilder()
        .redirectErrorStream(true)
        .directory(new File(gcdFolder, GCD))
        .redirectOutput(new File("/dev/null"))
        .command("bash", "gcd.sh", "create", "-d", projectId, projectId)
        .start();
    temp.waitFor();

    temp = new ProcessBuilder()
        .directory(new File(gcdFolder, GCD))
        .redirectErrorStream(true)
        .command("bash", "gcd.sh", "start", "--testing", "--allow_remote_shutdown", projectId)
        .start();
    processReader = ProcessStreamReader.start(temp, "Dev App Server is now running");
  }

  private static void extractFile(ZipInputStream zipIn, File filePath) throws IOException {
    try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
      byte[] bytesIn = new byte[1024];
      int read;
      while ((read = zipIn.read(bytesIn)) != -1) {
        bos.write(bytesIn, 0, read);
      }
    }
  }

  public static void sendQuitRequest() {
    try {
      URL url = new URL("http", "localhost", PORT, "/_ah/admin/quit");
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("POST");
      con.setDoOutput(true);
      con.setDoInput(true);
      OutputStream out = con.getOutputStream();
      out.write("".getBytes());
      out.flush();
      InputStream in = con.getInputStream();
      while (in.read() != -1) {
        // consume input
      }
    } catch (IOException ignore) {
      // ignore
    }
  }

  public void stop() throws IOException, InterruptedException {
    sendQuitRequest();
    if (processReader != null) {
      processReader.terminate();
    }
    if (gcdPath != null) {
      deleteRecurse(gcdPath);
    }
  }

  private static void deleteRecurse(Path path) throws IOException {
    if (path == null || !Files.exists(path)) {
      return;
    }
    Files.walkFileTree(path, new SimpleFileVisitor<Path>() {

      @Override
      public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        Files.delete(dir);
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Files.delete(file);
        return FileVisitResult.CONTINUE;
      }
    });
  }

  public static LocalGcdHelper start(String projectId) throws IOException, InterruptedException {
    LocalGcdHelper helper = new LocalGcdHelper(projectId);
    helper.start();
    return helper;
  }

  public static void main(String... args) throws IOException, InterruptedException {
    if (args.length == 1) {
      switch (args[0]) {
        case "START":
          if (!isActive(DEFAULT_PROJECT_ID)) {
            LocalGcdHelper helper = start(DEFAULT_PROJECT_ID);
            try (FileWriter writer = new FileWriter(".local_gcd_helper")) {
              writer.write(helper.gcdPath.toAbsolutePath().toString());
            }
          }
          return;
        case "STOP":
          sendQuitRequest();
          File file = new File(".local_gcd_helper");
          if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
              String path = reader.readLine();
              deleteRecurse(Paths.get(path));
            }
            file.delete();
          }
          return;
        default:
          break;
      }
    }
    throw new RuntimeException("expecting only START | STOP");
  }

  public static boolean isActive(String projectId) {
    try {
      StringBuilder urlBuilder = new StringBuilder("http://localhost:").append(PORT);
      urlBuilder.append("/datastore/v1beta2/datasets/").append(projectId).append("/lookup");
      URL url = new URL(urlBuilder.toString());
      try (BufferedReader reader =
               new BufferedReader(new InputStreamReader(url.openStream(), UTF_8))) {
        return "Valid RPC".equals(reader.readLine());
      }
    } catch (IOException ignore) {
      // assume not active
      return false;
    }
  }
}
