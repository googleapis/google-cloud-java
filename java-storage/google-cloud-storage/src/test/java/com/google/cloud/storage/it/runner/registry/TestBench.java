/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.storage.it.runner.registry;

import static com.google.cloud.RetryHelper.runWithRetries;
import static java.util.Objects.requireNonNull;

import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.core.NanoClock;
import com.google.api.gax.retrying.BasicResultRetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.Tuple;
import com.google.cloud.conformance.storage.v1.InstructionList;
import com.google.cloud.conformance.storage.v1.Method;
import com.google.cloud.storage.it.runner.SneakyException;
import com.google.common.base.Charsets;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.io.CharStreams;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A {@link ManagedLifecycle} which integrates with the <a target="_blank"
 * href="https://github.com/googleapis/storage-testbench">storage-testbench</a> by pulling the
 * docker image, starting the container, providing methods for interacting with the {@code
 * /retry_test} rest api, stopping the container.
 *
 * <p>A single instance of the testbench is expected to be managed by the {@link
 * com.google.cloud.storage.it.runner.registry.Registry} which is used by {@link
 * com.google.cloud.storage.it.runner.StorageITRunner}. Accessing the testbench can be accomplished
 * by doing the following:
 *
 * <ol>
 *   <li>Annotating your test class {@code @RunWith(StorageITRunner.class)}
 *   <li>Configuring the backend for your integration tests to be {@link
 *       com.google.cloud.storage.it.runner.annotations.Backend#TEST_BENCH} by doing either
 *       <ol>
 *         <li>Annotating your test class with {@code @SingleBackend(Backend.TEST_BENCH)}
 *         <li>Annotating your test class with {@code @CrossRun} and ensuring {@code
 *             Backend.TEST_BENCH} is included in the {@code backends} parameter
 *       </ol>
 *   <li>Specifying {@code @Inject public TestBench testBench;} as a field for the instance of
 *       testbench to be injected to your test
 * </ol>
 */
public final class TestBench implements ManagedLifecycle {

  private static final Logger LOGGER = LoggerFactory.getLogger(TestBench.class);

  private final boolean ignorePullError;
  private volatile String baseUri;
  private volatile String gRPCBaseUri;
  private final String dockerImageName;
  private final String dockerImageTag;
  private final String containerName;

  private final Gson gson;
  private final HttpRequestFactory requestFactory;

  private Process process;
  private Path tempDirectory;
  private Path outPath;
  private Path errPath;

  private boolean runningOutsideAlready;

  private TestBench(
      boolean ignorePullError,
      String baseUri,
      String gRPCBaseUri,
      String dockerImageName,
      String dockerImageTag,
      String containerName) {
    this.ignorePullError = true;
    this.baseUri = baseUri;
    this.gRPCBaseUri = gRPCBaseUri;
    this.dockerImageName = dockerImageName;
    this.dockerImageTag = dockerImageTag;
    this.containerName = containerName;
    this.gson = new Gson();
    this.requestFactory =
        new NetHttpTransport.Builder()
            .build()
            .createRequestFactory(
                request -> {
                  request.setCurlLoggingEnabled(false);
                  request.setConnectTimeout(5000);
                  request.setReadTimeout(10000);
                  request.getHeaders().setAccept("application/json");
                  request
                      .getHeaders()
                      .setUserAgent(
                          String.format(Locale.US, "%s/ test-bench/", this.containerName));
                });
  }

  public String getBaseUri() {
    return baseUri;
  }

  public String getGRPCBaseUri() {
    return gRPCBaseUri;
  }

  public RetryTestResource createRetryTest(RetryTestResource retryTestResource) throws IOException {
    GenericUrl url = new GenericUrl(baseUri + "/retry_test");
    String jsonString = gson.toJson(retryTestResource);
    HttpContent content =
        new ByteArrayContent("application/json", jsonString.getBytes(StandardCharsets.UTF_8));
    HttpRequest req = requestFactory.buildPostRequest(url, content);
    HttpResponse resp = req.execute();
    RetryTestResource result = gson.fromJson(resp.parseAsString(), RetryTestResource.class);
    resp.disconnect();
    return result;
  }

  public void deleteRetryTest(RetryTestResource retryTestResource) throws IOException {
    GenericUrl url = new GenericUrl(baseUri + "/retry_test/" + retryTestResource.id);
    HttpRequest req = requestFactory.buildDeleteRequest(url);
    HttpResponse resp = req.execute();
    resp.disconnect();
  }

  public RetryTestResource getRetryTest(RetryTestResource retryTestResource) throws IOException {
    GenericUrl url = new GenericUrl(baseUri + "/retry_test/" + retryTestResource.id);
    HttpRequest req = requestFactory.buildGetRequest(url);
    HttpResponse resp = req.execute();
    RetryTestResource result = gson.fromJson(resp.parseAsString(), RetryTestResource.class);
    resp.disconnect();
    return result;
  }

  public List<RetryTestResource> listRetryTests() throws IOException {
    GenericUrl url = new GenericUrl(baseUri + "/retry_tests");
    HttpRequest req = requestFactory.buildGetRequest(url);
    HttpResponse resp = req.execute();
    JsonObject result = gson.fromJson(resp.parseAsString(), JsonObject.class);
    JsonArray retryTest = (JsonArray) result.get("retry_test");
    ImmutableList.Builder<RetryTestResource> b = ImmutableList.builder();
    for (JsonElement e : retryTest) {
      b.add(gson.fromJson(e, RetryTestResource.class));
    }
    resp.disconnect();
    return b.build();
  }

  private boolean startGRPCServer(int gRPCPort) throws IOException {
    GenericUrl url = new GenericUrl(baseUri + "/start_grpc?port=9090");
    HttpRequest req = requestFactory.buildGetRequest(url);
    HttpResponse resp = req.execute();
    resp.disconnect();
    return resp.getStatusCode() == 200;
  }

  @Override
  public Object get() {
    return this;
  }

  @Override
  public void start() {
    if (baseUri != null) {
      try {
        listRetryTests();
        LOGGER.info("Using testbench running outside test suite.");
        runningOutsideAlready = true;
        return;
      } catch (IOException ignore) {
        // expected when the server isn't running already
      }
    }
    try {
      tempDirectory = Files.createTempDirectory(containerName);
      outPath = tempDirectory.resolve("stdout");
      errPath = tempDirectory.resolve("stderr");

      File outFile = outPath.toFile();
      File errFile = errPath.toFile();
      LOGGER.info("Redirecting server stdout to: {}", outFile.getAbsolutePath());
      LOGGER.info("Redirecting server stderr to: {}", errFile.getAbsolutePath());
      String dockerImage = String.format(Locale.US, "%s:%s", dockerImageName, dockerImageTag);
      // First try and pull the docker image, this validates docker is available and running
      // on the host, as well as gives time for the image to be downloaded independently of
      // trying to start the container. (Below, when we first start the container we then attempt
      // to issue a call against the api before we yield to run our tests.)
      try {
        Process p =
            new ProcessBuilder()
                .command("docker", "pull", dockerImage)
                .redirectOutput(outFile)
                .redirectError(errFile)
                .start();
        try {
          p.waitFor(5, TimeUnit.MINUTES);
          if (!ignorePullError && p.exitValue() != 0) {
            dumpServerLogs(outPath, errPath);
            throw new IllegalStateException(
                String.format(
                    Locale.US,
                    "Non-zero status while attempting to pull docker image '%s'",
                    dockerImage));
          }
        } finally {
          p.destroyForcibly();
        }
      } catch (InterruptedException | IllegalThreadStateException e) {
        dumpServerLogs(outPath, errPath);
        throw new IllegalStateException(
            String.format(
                Locale.US, "Timeout while attempting to pull docker image '%s'", dockerImage));
      }

      int port = baseUri != null ? URI.create(baseUri).getPort() : 0;
      int gRPCPort = gRPCBaseUri != null ? URI.create(gRPCBaseUri).getPort() : 0;
      final List<String> command =
          ImmutableList.of(
              "docker",
              "run",
              "-d",
              "--rm",
              "--publish",
              (port > 0 ? port + ":" : "") + "9000",
              "--publish",
              (gRPCPort > 0 ? gRPCPort + ":" : "") + "9090",
              String.format(Locale.US, "--name=%s", containerName),
              dockerImage,
              "gunicorn",
              "--bind=0.0.0.0:9000",
              "--worker-class=sync",
              "--threads=10",
              "--access-logfile=-",
              "--keep-alive=0",
              "testbench:run()");
      process =
          new ProcessBuilder()
              .command(command)
              .redirectOutput(outFile)
              .redirectError(errFile)
              .start();
      LOGGER.info(command.toString());
      try {
        try {
          if (!process.waitFor(10, TimeUnit.SECONDS)) {
            throw new IllegalStateException("docker run timed out");
          }
          if (process.exitValue() != 0) {
            dumpServerLogs(outPath, errPath);
            throw new IllegalStateException("docker run failed with exit code " + process.exitValue());
          }
        } finally {
          process.destroyForcibly();
        }

        if (baseUri == null) {
          int allocatedPort = getDockerPort(containerName, 9000);
          this.baseUri = "http://localhost:" + allocatedPort;
          LOGGER.info("Auto-allocated HTTP port: {}", allocatedPort);
        }
        if (gRPCBaseUri == null) {
          int allocatedGrpcPort = getDockerPort(containerName, 9090);
          this.gRPCBaseUri = "http://localhost:" + allocatedGrpcPort;
          LOGGER.info("Auto-allocated gRPC port: {}", allocatedGrpcPort);
        }

        // wait a small amount of time for the server to come up before probing
        Thread.sleep(500);
        // wait for the server to come up
        List<RetryTestResource> existingResources =
            runWithRetries(
                TestBench.this::listRetryTests,
                RetrySettings.newBuilder()
                    .setTotalTimeoutDuration(Duration.ofSeconds(30))
                    .setInitialRetryDelayDuration(Duration.ofMillis(500))
                    .setRetryDelayMultiplier(1.5)
                    .setMaxRetryDelayDuration(Duration.ofSeconds(5))
                    .build(),
                new BasicResultRetryAlgorithm<List<RetryTestResource>>() {
                  @Override
                  public boolean shouldRetry(
                      Throwable previousThrowable, List<RetryTestResource> previousResponse) {
                    return previousThrowable instanceof SocketException;
                  }
                },
                NanoClock.getDefaultClock());
        if (!existingResources.isEmpty()) {
          LOGGER.info(
              "Test Server already has retry tests in it, is it running outside the tests?");
        }
        // Start gRPC Service
        int actualGrpcPort = URI.create(gRPCBaseUri).getPort();
        if (!startGRPCServer(actualGrpcPort)) {
          throw new IllegalStateException(
              "Failed to start server within a reasonable amount of time. Host url(gRPC): "
                  + gRPCBaseUri);
        }
      } catch (RetryHelperException e) {
        dumpServerLogs(outPath, errPath);
        throw new IllegalStateException(
            "Failed to connect to server within a reasonable amount of time. Host url: " + baseUri,
            e.getCause());
      }
    } catch (IOException | InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void stop() {
    if (runningOutsideAlready) {
      // if the server was running outside the tests already simply return
      return;
    }
    try {
      LOGGER.warn("Stopping container: {}", containerName);
      ImmutableList<String> killCommand = ImmutableList.of("docker", "kill", containerName);
      LOGGER.warn(killCommand.toString());
      ProcessBuilder pb = new ProcessBuilder(killCommand);
      File nullFile = new File(System.getProperty("os.name").startsWith("Windows") ? "NUL" : "/dev/null");
      pb.redirectOutput(ProcessBuilder.Redirect.to(nullFile));
      pb.redirectError(ProcessBuilder.Redirect.to(nullFile));
      Process shutdownProcess = pb.start();
      try {
        shutdownProcess.waitFor(5, TimeUnit.SECONDS);
        int shutdownProcessExitValue = shutdownProcess.exitValue();
        LOGGER.warn("Container exit value = {}", shutdownProcessExitValue);
      } finally {
        shutdownProcess.destroyForcibly();
      }

      try {
        Files.delete(errPath);
        Files.delete(outPath);
        Files.delete(tempDirectory);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    } catch (InterruptedException | IOException e) {
      throw new RuntimeException(e);
    }
  }

  private int getDockerPort(String containerName, int containerPort) throws IOException, InterruptedException {
    ProcessBuilder pb = new ProcessBuilder("docker", "port", containerName, String.valueOf(containerPort));
    File nullFile = new File(System.getProperty("os.name").startsWith("Windows") ? "NUL" : "/dev/null");
    pb.redirectError(ProcessBuilder.Redirect.to(nullFile));
    Process p = pb.start();
    try {
      if (!p.waitFor(5, TimeUnit.SECONDS)) {
        throw new IllegalStateException("docker port timed out");
      }
      if (p.exitValue() != 0) {
        throw new IllegalStateException("docker port failed");
      }
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream(), StandardCharsets.UTF_8))) {
        String line = reader.readLine();
        if (line == null) {
          throw new IllegalStateException("No port mapping found");
        }
        // Line format is like "0.0.0.0:49153" or "[::]:49153"
        int colonIndex = line.lastIndexOf(':');
        if (colonIndex == -1) {
          throw new IllegalStateException("Invalid port mapping: " + line);
        }
        return Integer.parseInt(line.substring(colonIndex + 1));
      }
    } finally {
      p.destroyForcibly();
    }
  }

  private void dumpServerLogs(Path outFile, Path errFile) throws IOException {
    try {
      LOGGER.warn("Dumping contents of stdout");
      dumpServerLog("stdout", outFile.toFile());
    } finally {
      LOGGER.warn("Dumping contents of stderr");
      dumpServerLog("stderr", errFile.toFile());
    }
  }

  private void dumpServerLog(String prefix, File out) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(out))) {
      String line;
      while ((line = reader.readLine()) != null) {
        LOGGER.warn("<{}> {}", prefix, line);
      }
    }
  }

  static Builder newBuilder() {
    return new Builder();
  }

  public static final class RetryTestResource {
    public String id;
    public Boolean completed;
    public String transport;
    public JsonObject instructions;

    public RetryTestResource() {}

    public RetryTestResource(JsonObject instructions) {
      this.instructions = instructions;
    }

    public static RetryTestResource newRetryTestResource(
        Method m, InstructionList l, String transport) {
      RetryTestResource resource = new RetryTestResource();
      resource.instructions = new JsonObject();
      JsonArray instructions = new JsonArray();
      for (String s : l.getInstructionsList()) {
        instructions.add(s);
      }
      resource.instructions.add(m.getName(), instructions);
      resource.transport = transport;
      return resource;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("id", id)
          .add("completed", completed)
          .add("transport", transport)
          .add("instructions", instructions)
          .toString();
    }
  }

  static final class Builder {
    private static final String DEFAULT_BASE_URI = "http://localhost:9000";
    private static final String DEFAULT_GRPC_BASE_URI = "http://localhost:9005";
    private static final String DEFAULT_IMAGE_NAME;
    private static final String DEFAULT_IMAGE_TAG;

    static {
      ClassLoader cl = Thread.currentThread().getContextClassLoader();
      Tuple<String, String> nameAndTag =
          SneakyException.unwrap(
                  () -> {
                    InputStream dockerfileText =
                        cl.getResourceAsStream(
                            "com/google/cloud/storage/it/runner/registry/Dockerfile");
                    //noinspection UnstableApiUsage
                    return Optional.ofNullable(dockerfileText)
                        .map(is -> new InputStreamReader(is, Charsets.UTF_8))
                        .flatMap(
                            reader ->
                                SneakyException.sneaky(
                                    () ->
                                        CharStreams.readLines(reader).stream()
                                            .filter(line -> !line.startsWith("#"))
                                            .filter(line -> line.startsWith("FROM"))
                                            .findFirst()
                                            .flatMap(
                                                from -> {
                                                  Pattern pattern =
                                                      Pattern.compile("FROM (.*?):(.*)$");
                                                  Matcher matcher = pattern.matcher(from);
                                                  if (matcher.matches()) {
                                                    return Optional.of(
                                                        Tuple.of(
                                                            matcher.group(1), matcher.group(2)));
                                                  } else {
                                                    return Optional.empty();
                                                  }
                                                })));
                  })
              .orElse(Tuple.of(null, null));
      DEFAULT_IMAGE_NAME = nameAndTag.x();
      DEFAULT_IMAGE_TAG = nameAndTag.y();
    }

    private static final String DEFAULT_CONTAINER_NAME = "default";



    private boolean ignorePullError;
    private String baseUri;
    private String gRPCBaseUri;
    private String dockerImageName;
    private String dockerImageTag;
    private String containerName;

    private Builder() {
      this(
          false,
          null,
          null,
          DEFAULT_IMAGE_NAME,
          DEFAULT_IMAGE_TAG,
          DEFAULT_CONTAINER_NAME);
    }

    private Builder(
        boolean ignorePullError,
        String baseUri,
        String gRPCBaseUri,
        String dockerImageName,
        String dockerImageTag,
        String containerName) {
      this.ignorePullError = ignorePullError;
      this.baseUri = baseUri;
      this.gRPCBaseUri = gRPCBaseUri;
      this.dockerImageName = dockerImageName;
      this.dockerImageTag = dockerImageTag;
      this.containerName = containerName;
    }

    public Builder setIgnorePullError(boolean ignorePullError) {
      this.ignorePullError = ignorePullError;
      return this;
    }

    public Builder setBaseUri(String baseUri) {
      this.baseUri = requireNonNull(baseUri, "host must be non null");
      return this;
    }

    public Builder setGRPCBaseUri(String gRPCBaseUri) {
      this.gRPCBaseUri = requireNonNull(gRPCBaseUri, "gRPC host must be non null");
      return this;
    }

    public Builder setDockerImageName(String dockerImageName) {
      this.dockerImageName = requireNonNull(dockerImageName, "dockerImageName must be non null");
      return this;
    }

    public Builder setDockerImageTag(String dockerImageTag) {
      this.dockerImageTag = requireNonNull(dockerImageTag, "dockerImageTag must be non null");
      return this;
    }

    public Builder setContainerName(String containerName) {
      this.containerName = requireNonNull(containerName, "containerName must be non null");
      return this;
    }

    public TestBench build() {
      String suffix = Optional.ofNullable(System.getProperty("surefire.forkNumber"))
          .orElseGet(() -> java.util.UUID.randomUUID().toString().substring(0, 8));
      return new TestBench(
          ignorePullError,
          baseUri,
          gRPCBaseUri,
          requireNonNull(dockerImageName, "dockerImageName must be non null"),
          requireNonNull(dockerImageTag, "dockerImageTag must be non null"),
          String.format(Locale.US, "storage-testbench_%s_%s", containerName, suffix));
    }
  }

  private static final class NotShutdownException extends RuntimeException {}
}
