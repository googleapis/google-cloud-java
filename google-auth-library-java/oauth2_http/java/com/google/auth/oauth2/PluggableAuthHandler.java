/*
 * Copyright 2022 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.auth.oauth2;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonParser;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Splitter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/**
 * Internal handler for retrieving 3rd party tokens from user defined scripts/executables for
 * workload identity federation.
 *
 * <p>See {@link PluggableAuthCredentials}.
 */
final class PluggableAuthHandler implements ExecutableHandler {

  // The maximum supported version for the executable response.
  // The executable response always includes a version number that is used
  // to detect compatibility with the response and library verions.
  private static final int EXECUTABLE_SUPPORTED_MAX_VERSION = 1;

  // The GOOGLE_EXTERNAL_ACCOUNT_ALLOW_EXECUTABLES dictates if this feature is enabled.
  // The GOOGLE_EXTERNAL_ACCOUNT_ALLOW_EXECUTABLES environment variable must be set to '1' for
  // security reasons.
  private static final String GOOGLE_EXTERNAL_ACCOUNT_ALLOW_EXECUTABLES =
      "GOOGLE_EXTERNAL_ACCOUNT_ALLOW_EXECUTABLES";

  // The exit status of the 3P script that represents a successful execution.
  private static final int EXIT_CODE_SUCCESS = 0;

  private final EnvironmentProvider environmentProvider;
  private InternalProcessBuilder internalProcessBuilder;

  PluggableAuthHandler(EnvironmentProvider environmentProvider) {
    this.environmentProvider = environmentProvider;
  }

  @VisibleForTesting
  PluggableAuthHandler(
      EnvironmentProvider environmentProvider, InternalProcessBuilder internalProcessBuilder) {
    this.environmentProvider = environmentProvider;
    this.internalProcessBuilder = internalProcessBuilder;
  }

  @Override
  public String retrieveTokenFromExecutable(ExecutableOptions options) throws IOException {
    // Validate that executables are allowed to run. To use Pluggable Auth,
    // The GOOGLE_EXTERNAL_ACCOUNT_ALLOW_EXECUTABLES environment variable must be set to 1
    // for security reasons.
    if (!"1".equals(this.environmentProvider.getEnv(GOOGLE_EXTERNAL_ACCOUNT_ALLOW_EXECUTABLES))) {
      throw new PluggableAuthException(
          "PLUGGABLE_AUTH_DISABLED",
          "Pluggable Auth executables need "
              + "to be explicitly allowed to run by setting the "
              + "GOOGLE_EXTERNAL_ACCOUNT_ALLOW_EXECUTABLES environment variable to 1.");
    }

    // Users can specify an output file path in the Pluggable Auth ADC configuration.
    // This is the file's absolute path. Their executable will handle writing the 3P credentials to
    // this file.
    // If specified, we will first check if we have valid unexpired credentials stored in this
    // location to avoid running the executable until they are expired.
    ExecutableResponse executableResponse = getCachedExecutableResponse(options);

    // If the output_file does not contain a valid response, call the executable.
    if (executableResponse == null) {
      executableResponse = getExecutableResponse(options);
    }

    // If an output file is specified, successful responses must contain the `expiration_time`
    // field.
    if (options.getOutputFilePath() != null
        && !options.getOutputFilePath().isEmpty()
        && executableResponse.isSuccessful()
        && executableResponse.getExpirationTime() == null) {
      throw new PluggableAuthException(
          "INVALID_EXECUTABLE_RESPONSE",
          "The executable response must contain the `expiration_time` field for successful responses when an "
              + "output_file has been specified in the configuration.");
    }

    // The executable response includes a version. Validate that the version is compatible
    // with the library.
    if (executableResponse.getVersion() > EXECUTABLE_SUPPORTED_MAX_VERSION) {
      throw new PluggableAuthException(
          "UNSUPPORTED_VERSION",
          "The version of the executable response is not supported. "
              + String.format(
                  "The maximum version currently supported is %s.",
                  EXECUTABLE_SUPPORTED_MAX_VERSION));
    }

    if (!executableResponse.isSuccessful()) {
      throw new PluggableAuthException(
          executableResponse.getErrorCode(), executableResponse.getErrorMessage());
    }

    if (executableResponse.isExpired()) {
      throw new PluggableAuthException("INVALID_RESPONSE", "The executable response is expired.");
    }

    // Subject token is valid and can be returned.
    return executableResponse.getSubjectToken();
  }

  @Nullable
  ExecutableResponse getCachedExecutableResponse(ExecutableOptions options)
      throws PluggableAuthException {
    ExecutableResponse executableResponse = null;
    if (options.getOutputFilePath() != null && !options.getOutputFilePath().isEmpty()) {
      // Try reading cached response from output_file.
      try {
        File outputFile = new File(options.getOutputFilePath());
        // Check if the output file is valid and not empty.
        if (outputFile.isFile() && outputFile.length() > 0) {
          InputStream inputStream = new FileInputStream(options.getOutputFilePath());
          BufferedReader reader =
              new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
          JsonParser parser = OAuth2Utils.JSON_FACTORY.createJsonParser(reader);
          ExecutableResponse cachedResponse =
              new ExecutableResponse(parser.parseAndClose(GenericJson.class));
          // If the cached response is successful and unexpired, we can use it.
          // Response version will be validated below.
          if (cachedResponse.isValid()) {
            executableResponse = cachedResponse;
          }
        }
      } catch (Exception e) {
        throw new PluggableAuthException(
            "INVALID_OUTPUT_FILE",
            "The output_file specified contains an invalid or malformed response." + e);
      }
    }
    return executableResponse;
  }

  ExecutableResponse getExecutableResponse(ExecutableOptions options) throws IOException {
    List<String> components = Splitter.on(" ").splitToList(options.getExecutableCommand());

    // Create the process.
    InternalProcessBuilder processBuilder = getProcessBuilder(components);

    // Inject environment variables.
    Map<String, String> envMap = processBuilder.environment();
    envMap.putAll(options.getEnvironmentMap());

    // Redirect error stream.
    processBuilder.redirectErrorStream(true);

    // Start the process.
    Process process = processBuilder.start();

    ExecutableResponse execResp;
    String executableOutput = "";
    ExecutorService executor = Executors.newSingleThreadExecutor();
    try {
      // Consume the input stream while waiting for the program to finish so that
      // the process won't hang if the STDOUT buffer is filled.
      Future<String> future =
          executor.submit(
              () -> {
                BufferedReader reader =
                    new BufferedReader(
                        new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8));

                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                  sb.append(line).append(System.lineSeparator());
                }
                return sb.toString().trim();
              });

      boolean success = process.waitFor(options.getExecutableTimeoutMs(), TimeUnit.MILLISECONDS);
      if (!success) {
        // Process has not terminated within the specified timeout.
        throw new PluggableAuthException(
            "TIMEOUT_EXCEEDED", "The executable failed to finish within the timeout specified.");
      }
      int exitCode = process.exitValue();
      if (exitCode != EXIT_CODE_SUCCESS) {
        throw new PluggableAuthException(
            "EXIT_CODE", String.format("The executable failed with exit code %s.", exitCode));
      }

      executableOutput = future.get();
      executor.shutdownNow();

      JsonParser parser = OAuth2Utils.JSON_FACTORY.createJsonParser(executableOutput);
      execResp = new ExecutableResponse(parser.parseAndClose(GenericJson.class));
    } catch (IOException e) {
      // Destroy the process.
      process.destroy();

      // Shutdown executor if needed.
      if (!executor.isShutdown()) {
        executor.shutdownNow();
      }

      if (e instanceof PluggableAuthException) {
        throw e;
      }
      // An error may have occurred in the executable and should be surfaced.
      throw new PluggableAuthException(
          "INVALID_RESPONSE",
          String.format("The executable returned an invalid response: %s.", executableOutput));
    } catch (InterruptedException | ExecutionException e) {
      // Destroy the process.
      process.destroy();

      throw new PluggableAuthException(
          "INTERRUPTED", String.format("The execution was interrupted: %s.", e));
    }

    process.destroy();
    return execResp;
  }

  InternalProcessBuilder getProcessBuilder(List<String> commandComponents) {
    if (internalProcessBuilder != null) {
      return internalProcessBuilder;
    }
    return new DefaultProcessBuilder(new ProcessBuilder(commandComponents));
  }

  /**
   * An interface for creating and managing a process.
   *
   * <p>ProcessBuilder is final and does not implement any interface. This class allows concrete
   * implementations to be specified to test these changes.
   */
  abstract static class InternalProcessBuilder {

    abstract Map<String, String> environment();

    abstract InternalProcessBuilder redirectErrorStream(boolean redirectErrorStream);

    abstract Process start() throws IOException;
  }

  /**
   * A default implementation for {@link InternalProcessBuilder} that wraps {@link ProcessBuilder}.
   */
  static final class DefaultProcessBuilder extends InternalProcessBuilder {
    ProcessBuilder processBuilder;

    DefaultProcessBuilder(ProcessBuilder processBuilder) {
      this.processBuilder = processBuilder;
    }

    @Override
    Map<String, String> environment() {
      return this.processBuilder.environment();
    }

    @Override
    InternalProcessBuilder redirectErrorStream(boolean redirectErrorStream) {
      this.processBuilder.redirectErrorStream(redirectErrorStream);
      return this;
    }

    @Override
    Process start() throws IOException {
      return this.processBuilder.start();
    }
  }
}
