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

package com.google.gcloud.datastore.testing;

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
import java.net.ServerSocket;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Utility to start and stop local Google Cloud Datastore process.
 */
public class LocalGcdHelper {
  private static final Logger log = Logger.getLogger(LocalGcdHelper.class.getName());

  private final String projectId;
  private Path gcdPath;
  private Process startProcess;
  private ProcessStreamReader processReader;
  private ProcessErrorStreamReader processErrorReader;
  private final int port;

  public static final String DEFAULT_PROJECT_ID = "projectid1";
  public static final int DEFAULT_PORT = 8080;
  private static final String GCD_VERSION = "v1beta2";
  private static final String GCD_BUILD = "rev1-2.1.2b";
  private static final String GCD_BASENAME = "gcd-" + GCD_VERSION + "-" + GCD_BUILD;
  private static final String GCD_FILENAME = GCD_BASENAME + ".zip";
  private static final String MD5_CHECKSUM = "d84384cdfa8658e1204f4f8be51300e8";
  private static final URL GCD_URL;
  private static final String GCLOUD = "gcloud";
  private static final Path INSTALLED_GCD_PATH;
  private static final String GCD_VERSION_PREFIX = "gcd-emulator ";

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

  public static int findAvailablePort(int defaultPort) {
    try (ServerSocket tempSocket = new ServerSocket(0)) {
      return tempSocket.getLocalPort();
    } catch (IOException e) {
      return defaultPort;
    }
  }

  private static Path installedGcdPath() {
    String gcloudExecutableName;
    if (isWindows()) {
      gcloudExecutableName = GCLOUD + ".cmd";
    } else {
      gcloudExecutableName = GCLOUD;
    }
    Path gcloudPath = executablePath(gcloudExecutableName);
    gcloudPath = (gcloudPath == null) ? null : gcloudPath.getParent();
    if (gcloudPath == null) {
      if (log.isLoggable(Level.FINE)) {
        log.fine("SDK not found");
      }
      return null;
    }
    if (log.isLoggable(Level.FINE)) {
      log.fine("SDK found, looking for datastore emulator");
    }
    Path installedGcdPath = gcloudPath.resolve("platform").resolve("gcd");
    if (Files.exists(installedGcdPath)) {
      try {
        String installedVersion = installedGcdVersion();
        if (installedVersion != null && installedVersion.startsWith(GCD_VERSION)) {
          if (log.isLoggable(Level.FINE)) {
            log.fine("SDK datastore emulator found");
          }
          return installedGcdPath;
        } else {
          if (log.isLoggable(Level.FINE)) {
            log.fine("SDK datastore emulator found but version mismatch");
          }
        }
      } catch (IOException | InterruptedException ignore) {
        // ignore
      }
    }
    return null;
  }

  private static String installedGcdVersion() throws IOException, InterruptedException {
    Process process =
        CommandWrapper.create().command("gcloud", "version").redirectErrorStream().start();
    process.waitFor();
    try (BufferedReader reader =
        new BufferedReader(new InputStreamReader(process.getInputStream()))) {
      for (String line = reader.readLine(); line != null; line = reader.readLine()) {
        if (line.startsWith(GCD_VERSION_PREFIX)) {
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
    private final BufferedReader reader;

    ProcessStreamReader(InputStream inputStream) {
      super("Local GCD InputStream reader");
      setDaemon(true);
      reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    void terminate() throws IOException {
      reader.close();
    }

    @Override
    public void run() {
      try {
        while (!(reader.readLine() != null)) {
          // consume line
        }
      } catch (IOException e) {
        // ignore
      }
    }

    public static ProcessStreamReader start(InputStream inputStream) {
      ProcessStreamReader thread = new ProcessStreamReader(inputStream);
      thread.start();
      return thread;
    }
  }

  private static class ProcessErrorStreamReader extends Thread {
    private static final int LOG_LENGTH_LIMIT = 50000;
    private static final String GCD_LOGGING_CLASS =
        "com.google.apphosting.client.serviceapp.BaseApiServlet";

    private final BufferedReader errorReader;
    private String currentLog = null;
    private Level currentLogLevel = null;

    ProcessErrorStreamReader(InputStream errorStream, String blockUntil) throws IOException {
      super("Local GCD ErrorStream reader");
      setDaemon(true);
      errorReader = new BufferedReader(new InputStreamReader(errorStream));
      if (!Strings.isNullOrEmpty(blockUntil)) {
        String line;
        do {
          line = errorReader.readLine();
        } while (line != null && !line.contains(blockUntil));
      }
    }

    void terminate() throws IOException {
      writeLog(currentLogLevel, currentLog);
      errorReader.close();
    }

    @Override
    public void run() {
      try {
        boolean errorReaderDone = false;
        String previousLine = "";
        String currentLine = "";
        while (!errorReaderDone) {
          previousLine = currentLine;
          currentLine = errorReader.readLine();
          if (currentLine == null) {
            errorReaderDone = true;
          } else {
            processLogLine(previousLine, currentLine);
          }
        }
      } catch (IOException e) {
        // ignore
      }
    }

    private void processLogLine(String previousLine, String currentLine) {
      // Each gcd log is two lines with the following format:
      //     [Date] [Time] [GCD_LOGGING_CLASS] [method]
      //     [LEVEL]: error message
      // Exceptions and stack traces are included in gcd error stream, separated by a newline
      Level nextLogLevel = getLevel(currentLine);
      if (previousLine.contains(GCD_LOGGING_CLASS) && nextLogLevel != null) {
        writeLog(currentLogLevel, currentLog);
        if (currentLine.startsWith("SEVERE: ")) {
          // don't show duplicate error messages from gcd.sh (see issue #258)
          currentLog = null;
          currentLogLevel = null;
        } else {
          currentLog = "GCD" + currentLine.split(":", 2)[1] + System.getProperty("line.separator");
          currentLogLevel = nextLogLevel;
        }
      } else if (currentLog != null && currentLog.length() > LOG_LENGTH_LIMIT) {
        // log processing may be off, so drop some logs before the string becomes too big
        currentLog = null;
        currentLogLevel = null;
      } else if (currentLog != null && isUsefulLogInfo(currentLine)) {
        currentLog += currentLine + System.getProperty("line.separator");
      }
    }

    private static void writeLog(Level level, String msg) {
      if (level != null && !Strings.isNullOrEmpty(msg)) {
        log.log(level, msg.trim());
      }
    }

    private static boolean isUsefulLogInfo(String line) {
      return !line.trim().startsWith("at ") && !line.contains(GCD_LOGGING_CLASS);
    }

    private static Level getLevel(String line) {
      try {
        return Level.parse(line.split(":")[0]);
      } catch (IllegalArgumentException e) {
        return null; // level wasn't supplied in this log line
      }
    }

    public static ProcessErrorStreamReader start(InputStream errorStream, String blockUntil)
        throws IOException {
      ProcessErrorStreamReader thread = new ProcessErrorStreamReader(errorStream, blockUntil);
      thread.start();
      return thread;
    }
  }

  private static class CommandWrapper {
    private final List<String> prefix;
    private List<String> command;
    private String nullFilename;
    private boolean redirectOutputToNull;
    private boolean redirectErrorStream;
    private boolean redirectErrorInherit;
    private Path directory;

    private CommandWrapper() {
      this.prefix = new ArrayList<>();
      if (isWindows()) {
        this.prefix.add("cmd");
        this.prefix.add("/C");
        this.nullFilename = "NUL:";
      } else {
        this.prefix.add("bash");
        this.nullFilename = "/dev/null";
      }
    }

    public CommandWrapper command(String... command) {
      this.command = new ArrayList<>(command.length + this.prefix.size());
      this.command.addAll(prefix);
      this.command.addAll(Arrays.asList(command));
      return this;
    }

    public CommandWrapper redirectOutputToNull() {
      this.redirectOutputToNull = true;
      return this;
    }

    public CommandWrapper redirectErrorStream() {
      this.redirectErrorStream = true;
      return this;
    }

    public CommandWrapper redirectErrorInherit() {
      this.redirectErrorInherit = true;
      return this;
    }

    public CommandWrapper directory(Path directory) {
      this.directory = directory;
      return this;
    }

    public ProcessBuilder builder() {
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
      return builder().start();
    }

    public static CommandWrapper create() {
      return new CommandWrapper();
    }
  }

  public LocalGcdHelper(String projectId, int port) {
    this.projectId = projectId;
    this.port = port;
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
    sendQuitRequest(port);
    // Each run is associated with its own folder that is deleted once test completes.
    gcdPath = Files.createTempDirectory("gcd");
    File gcdFolder = gcdPath.toFile();
    gcdFolder.deleteOnExit();

    Path gcdExecutablePath;
    // If cloud is available we use it, otherwise we download and start gcd
    if (INSTALLED_GCD_PATH == null) {
      downloadGcd();
      gcdExecutablePath = gcdPath.resolve(GCD_BASENAME);
    } else {
      gcdExecutablePath = INSTALLED_GCD_PATH;
    }
    startGcd(gcdExecutablePath);
  }

  private void downloadGcd() throws IOException {
    // check if we already have a local copy of the gcd utility and download it if not.
    File gcdZipFile = new File(System.getProperty("java.io.tmpdir"), GCD_FILENAME);
    if (!gcdZipFile.exists() || !MD5_CHECKSUM.equals(md5(gcdZipFile))) {
      if (log.isLoggable(Level.FINE)) {
        log.fine("Fetching datastore emulator");
      }
      ReadableByteChannel rbc = Channels.newChannel(GCD_URL.openStream());
      try (FileOutputStream fos = new FileOutputStream(gcdZipFile)) {
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
      }
    } else {
      if (log.isLoggable(Level.FINE)) {
        log.fine("Using cached datastore emulator");
      }
    }
    // unzip the gcd
    try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(gcdZipFile))) {
      if (log.isLoggable(Level.FINE)) {
        log.fine("Unzipping datastore emulator");
      }
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

    // Get path to cmd executable
    Path gcdAbsolutePath;
    if (isWindows()) {
      gcdAbsolutePath = executablePath.toAbsolutePath().resolve("gcd.cmd");
    } else {
      gcdAbsolutePath = executablePath.toAbsolutePath().resolve("gcd.sh");
    }

    // create the datastore for the project
    if (log.isLoggable(Level.FINE)) {
      log.log(Level.FINE, "Creating datastore for the project: {0}", projectId);
    }
    Process createProcess =
        CommandWrapper.create()
            .command(gcdAbsolutePath.toString(), "create", "-p", projectId, projectId)
            .redirectErrorInherit()
            .directory(gcdPath)
            .redirectOutputToNull()
            .start();
    createProcess.waitFor();

    // start the datastore for the project
    if (log.isLoggable(Level.FINE)) {
      log.log(Level.FINE, "Starting datastore emulator for the project: {0}", projectId);
    }
    startProcess =
        CommandWrapper.create()
            .command(gcdAbsolutePath.toString(), "start", "--testing", "--allow_remote_shutdown",
                "--port=" + Integer.toString(port), projectId)
            .directory(gcdPath)
            .start();
    processReader = ProcessStreamReader.start(startProcess.getInputStream());
    processErrorReader = ProcessErrorStreamReader.start(
        startProcess.getErrorStream(), "Dev App Server is now running");
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
      return String.format("%032x", new BigInteger(1, md5.digest()));
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

  public static void sendQuitRequest(int port) {
    try {
      URL url = new URL("http", "localhost", port, "/_ah/admin/quit");
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
    sendQuitRequest(port);
    if (processReader != null) {
      processReader.terminate();
      processErrorReader.terminate();
      startProcess.destroy();
      startProcess.waitFor();
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

  public static LocalGcdHelper start(String projectId, int port)
      throws IOException, InterruptedException {
    LocalGcdHelper helper = new LocalGcdHelper(projectId, port);
    helper.start();
    return helper;
  }

  public static void main(String... args) throws IOException, InterruptedException {
    Map<String, String> parsedArgs = parseArgs(args);
    String action = parsedArgs.get("action");
    int port =
        (parsedArgs.get("port") == null) ? DEFAULT_PORT : Integer.parseInt(parsedArgs.get("port"));
    switch (action) {
      case "START":
        if (!isActive(DEFAULT_PROJECT_ID, port)) {
          LocalGcdHelper helper = start(DEFAULT_PROJECT_ID, port);
          try (FileWriter writer = new FileWriter(".local_gcd_helper")) {
            writer.write(helper.gcdPath.toAbsolutePath().toString() + System.lineSeparator());
            writer.write(Integer.toString(port));
          }
        }
        return;
      case "STOP":
        File file = new File(".local_gcd_helper");
        String path = null;
        boolean fileExists = file.exists();
        if (fileExists) {
          try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            path = reader.readLine();
            port = Integer.parseInt(reader.readLine());
          }
        }
        sendQuitRequest(port);
        if (fileExists) {
          deleteRecurse(Paths.get(path));
          file.delete();
        }
        return;
      default:
        break;
    }
  }

  private static Map<String, String> parseArgs(String[] args) {
    Map<String, String> parsedArgs = new HashMap<String, String>();
    for (String arg : args) {
      if (arg.startsWith("--port=")) {
        parsedArgs.put("port", arg.substring("--port=".length()));
      } else if (arg.equals("START") || arg.equals("STOP")) {
        parsedArgs.put("action", arg);
      } else {
        throw new RuntimeException("Only accepts START, STOP, and --port=<port #> as arguments");
      }
    }
    if (parsedArgs.get("action") == null) {
      throw new RuntimeException("EXPECTING START | STOP");
    }
    return parsedArgs;
  }

  public static boolean isActive(String projectId, int port) {
    try {
      StringBuilder urlBuilder = new StringBuilder("http://localhost:").append(port);
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
