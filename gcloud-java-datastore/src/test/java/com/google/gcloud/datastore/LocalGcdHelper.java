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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Locale;
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
  private static final String GCD = "gcd-v1beta2-rev1-2.1.2b";
  private static final String GCD_FILENAME = GCD + ".zip";
  private static final URL GCD_URL;

  static {
    try {
      GCD_URL = new URL("http://storage.googleapis.com/gcd/tools/" + GCD_FILENAME);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }


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

  /**
   * Starts the local datastore for the specific project.
   *
   * This will unzip the gcd tool, create the project and start it.
   * All content is written to a temporary directory that will be deleted when
   * {@link #stop()} is called or when the program terminates) to make sure that no left-over
   * data from prior runs is used.
   */
  public void start() throws IOException, InterruptedException {
    // send a quick request in case we have a hanging process from a previous run
    sendQuitRequest();
    // Each run is associated with its own folder that is deleted once test completes.
    gcdPath = Files.createTempDirectory("gcd");
    File gcdFolder = gcdPath.toFile();
    gcdFolder.deleteOnExit();

    // check if we already have a local copy of the gcd utility and download it if not.
    File gcdZipFile = new File(System.getProperty("java.io.tmpdir"), GCD_FILENAME);
    if (!gcdZipFile.exists()) {
      ReadableByteChannel rbc = Channels.newChannel(GCD_URL.openStream());
      FileOutputStream fos = new FileOutputStream(gcdZipFile);
      fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
      fos.close();
    }
    // unzip the gcd
    try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(gcdZipFile))) {
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
    // cleanup any possible data for the same project
    File datasetFolder = new File(gcdFolder, GCD + '/' + projectId);
    deleteRecurse(datasetFolder.toPath());

    // create the datastore for the project
    ProcessBuilder processBuilder = new ProcessBuilder()
        .redirectError(ProcessBuilder.Redirect.INHERIT)
        .directory(new File(gcdFolder, GCD));
    if (isWindows()) {
      processBuilder.command("cmd", "/C", "gcd.cmd", "create", "-p", projectId, projectId);
      processBuilder.redirectOutput(new File("NULL:"));
    } else {
      processBuilder.redirectOutput(new File("/dev/null"));
      processBuilder.command("bash", "gcd.sh", "create", "-p", projectId, projectId);
    }

    Process temp = processBuilder.start();
    temp.waitFor();

    // start the datastore for the project
    processBuilder = new ProcessBuilder()
        .directory(new File(gcdFolder, GCD))
        .redirectErrorStream(true);
    if (isWindows()) {
      processBuilder.command("cmd", "/C", "gcd.cmd", "start", "--testing",
          "--allow_remote_shutdown", projectId);
    } else {
      processBuilder.command("bash", "gcd.sh", "start", "--testing", "--allow_remote_shutdown",
          projectId);
    }
    temp = processBuilder.start();
    processReader = ProcessStreamReader.start(temp, "Dev App Server is now running");
  }

  private static boolean isWindows() {
    return System.getProperty("os.name").toLowerCase(Locale.ENGLISH).indexOf("windows") > -1;
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
