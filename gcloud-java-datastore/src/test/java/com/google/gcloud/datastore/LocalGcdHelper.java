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

import java.io.BufferedInputStream;
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
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.regex.Pattern;
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
  private static final String GCD_VERSION = "v1beta2";
  private static final String GCD_FILENAME = GCD + ".zip";
  private static final String MD5_CHECKSUM = "d84384cdfa8658e1204f4f8be51300e8";
  private static final URL GCD_URL;
  private static final String GCLOUD = "gcloud";
  private static final Path INSTALLED_GCD_PATH;

  static {
    INSTALLED_GCD_PATH = installedGcdPath();
    if (INSTALLED_GCD_PATH != null) {
      GCD_URL = null;
    } else {
      try {
        GCD_URL = new URL("http://storage.googleapis.com/gcd/tools/" + GCD_FILENAME);
      } catch (MalformedURLException e) {
        throw new RuntimeException(e);
      }
    }
  }
  
  private static Path installedGcdPath() {
    Path gcloudPath = executablePath(GCLOUD);
    gcloudPath = (gcloudPath == null) ? null : gcloudPath.getParent();
    if (gcloudPath == null) {
      return null;
    }
    Path installedGcdPath = gcloudPath.resolve("platform").resolve("gcd");
    if (Files.exists(installedGcdPath)) {
      try {
        String installedVersion = installedGcdVersion();
        if (installedVersion != null && installedVersion.startsWith(GCD_VERSION)) {
          return installedGcdPath;
        }
      } catch (IOException | InterruptedException ignore) {
        // ignore
      }
    }
    return null;
  }
  
  private static String installedGcdVersion() throws IOException, InterruptedException {
    ProcessBuilder processBuilder = new ProcessBuilder()
      .redirectErrorStream(true);
    if (isWindows()) {
      processBuilder.command("cmd", "/C", "gcloud", "version");
    } else {
      processBuilder.command("bash", "gcloud", "version");
    }
    Process process = processBuilder.start();
    process.waitFor();
    try (BufferedReader reader = 
            new BufferedReader(new InputStreamReader(process.getInputStream()))) {
      for (String line = reader.readLine(); line != null; line = reader.readLine()) {
        if (line.startsWith("gcd-emulator")) {
          String[] lineComponents = line.split(" ");
          if (lineComponents.length > 1) {
            return lineComponents[1];
          }
        }
      }
      return null;
    }

  }
  
  private static Path executablePath(String cmd) {
    String[] paths = System.getenv("PATH").split(Pattern.quote(File.pathSeparator));
    for (String pathString : paths) {
      try {
        Path path = Paths.get(pathString);
        if (Files.exists(path.resolve(cmd))) {
          return path;
        }
      } catch (InvalidPathException ignore) {
        // ignore
      }
    }
    return null;
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

    Path gcdExecutablePath;
    // If cloud is available we use it, otherwise we download and start gcd
    if (INSTALLED_GCD_PATH == null) {
      downloadGcd();
      gcdExecutablePath = gcdPath.resolve(GCD);
    } else {
      gcdExecutablePath = INSTALLED_GCD_PATH;
    }
    startGcd(gcdExecutablePath);
  }
  
  private void downloadGcd() throws IOException {
    // check if we already have a local copy of the gcd utility and download it if not.
    File gcdZipFile = new File(System.getProperty("java.io.tmpdir"), GCD_FILENAME);
    if (!gcdZipFile.exists() || !MD5_CHECKSUM.equals(md5(gcdZipFile))) {
      ReadableByteChannel rbc = Channels.newChannel(GCD_URL.openStream());
      try (FileOutputStream fos = new FileOutputStream(gcdZipFile)) {
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
      }
    }
    // unzip the gcd
    try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(gcdZipFile))) {
      ZipEntry entry = zipIn.getNextEntry();
      while (entry != null) {
        File filePath = new File(gcdPath.toFile(), entry.getName());
        if (!entry.isDirectory()) {
          extractFile(zipIn, filePath);
        } else {
          filePath.mkdir();
        }
        zipIn.closeEntry();
        entry = zipIn.getNextEntry();
      }
    }   
  }
  
  private void startGcd(Path executablePath) throws IOException, InterruptedException {
    // cleanup any possible data for the same project
    File datasetFolder = new File(gcdPath.toFile(), projectId);
    deleteRecurse(datasetFolder.toPath());

    // create the datastore for the project
    ProcessBuilder processBuilder = new ProcessBuilder()
        .redirectError(ProcessBuilder.Redirect.INHERIT)
        .directory(gcdPath.toFile());
    if (isWindows()) {
      Path gcdAbsolutePath = executablePath.toAbsolutePath().resolve("gcd.cmd");
      processBuilder.command("cmd", "/C", gcdAbsolutePath.toString(), "create",
          "-p", projectId, projectId);
    } else {
      Path gcdAbsolutePath = executablePath.toAbsolutePath().resolve("gcd.sh");
      processBuilder.command("bash", gcdAbsolutePath.toString(), "create",
          "-p", projectId, projectId);
    }

    Process temp = processBuilder.start();
    temp.waitFor();

    // start the datastore for the project
    processBuilder = new ProcessBuilder()
        .directory(gcdPath.toFile())
        .redirectErrorStream(true);
    if (isWindows()) {
      Path gcdAbsolutePath = executablePath.toAbsolutePath().resolve("gcd.cmd");
      processBuilder.command("cmd", "/C", gcdAbsolutePath.toString(), "start", "--testing",
          "--allow_remote_shutdown", projectId);
    } else {
      Path gcdAbsolutePath = executablePath.toAbsolutePath().resolve("gcd.sh");
      processBuilder.command("bash", gcdAbsolutePath.toString(), "start", "--testing",
          "--allow_remote_shutdown", projectId);
    }
    temp = processBuilder.start();
    processReader = ProcessStreamReader.start(temp, "Dev App Server is now running");
  }

  private static String md5(File gcdZipFile) throws IOException {
    try {
      MessageDigest md5 = MessageDigest.getInstance("MD5");
      try (InputStream is = new BufferedInputStream(new FileInputStream(gcdZipFile))) {
        byte[] bytes = new byte[4 * 1024 * 1024];
        int len;
        while ((len = is.read(bytes)) >= 0) {
          md5.update(bytes, 0, len);
        }
      }
      return String.format("%032x",new BigInteger(1, md5.digest()));
    } catch (NoSuchAlgorithmException e) {
      throw new IOException(e);
    }
  }

  private static boolean isWindows() {
    return System.getProperty("os.name").toLowerCase(Locale.ENGLISH).contains("windows");
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
