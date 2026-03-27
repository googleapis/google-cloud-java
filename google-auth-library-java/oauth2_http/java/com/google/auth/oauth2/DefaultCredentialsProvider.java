/*
 * Copyright 2015, Google Inc. All rights reserved.
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
 *    * Neither the name of Google Inc. nor the names of its
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

import com.google.auth.http.HttpTransportFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessControlException;
import java.util.Collections;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provides the Application Default Credential from the environment.
 *
 * <p>An instance represents the per-process state used to get and cache the credential and allows
 * overriding the state and environment for testing purposes.
 */
class DefaultCredentialsProvider {
  static final DefaultCredentialsProvider DEFAULT = new DefaultCredentialsProvider();
  static final String CREDENTIAL_ENV_VAR = "GOOGLE_APPLICATION_CREDENTIALS";
  static final String QUOTA_PROJECT_ENV_VAR = "GOOGLE_CLOUD_QUOTA_PROJECT";

  static final String WELL_KNOWN_CREDENTIALS_FILE = "application_default_credentials.json";
  static final String CLOUDSDK_CONFIG_DIRECTORY = "gcloud";
  static final String APP_ENGINE_SIGNAL_CLASS = "com.google.appengine.api.utils.SystemProperty";
  static final String CLOUD_SHELL_ENV_VAR = "DEVSHELL_CLIENT_PORT";
  static final String SKIP_APP_ENGINE_ENV_VAR = "GOOGLE_APPLICATION_CREDENTIALS_SKIP_APP_ENGINE";
  static final String SPECIFICATION_VERSION = System.getProperty("java.specification.version");
  static final String GAE_RUNTIME_VERSION =
      System.getProperty("com.google.appengine.runtime.version");
  static final String RUNTIME_JETTY_LOGGER = System.getProperty("org.eclipse.jetty.util.log.class");
  static final Logger LOGGER = Logger.getLogger(DefaultCredentialsProvider.class.getName());
  static final String NO_GCE_CHECK_ENV_VAR = "NO_GCE_CHECK";
  static final String GCE_METADATA_HOST_ENV_VAR = "GCE_METADATA_HOST";
  static final String CLOUDSDK_CLIENT_ID =
      "764086051850-6qr4p6gpi6hn506pt8ejuq83di341hur.apps.googleusercontent.com";
  static final String CLOUDSDK_CREDENTIALS_WARNING =
      "You are authenticating using user credentials. "
          + "For production, we recommend using service account credentials.\n\n"
          + "To learn more about service account credentials, see "
          + "http://cloud.google.com/docs/authentication/external/set-up-adc-on-cloud";

  static final String CLOUDSDK_MISSING_CREDENTIALS =
      "Your default credentials were not found. To set up Application Default Credentials "
          + "for your environment, see "
          + "https://cloud.google.com/docs/authentication/external/set-up-adc.";
  public static final String SUPPRESS_GCLOUD_CREDS_WARNING_ENV_VAR =
      "SUPPRESS_GCLOUD_CREDS_WARNING";

  // These variables should only be accessed inside a synchronized block
  private GoogleCredentials cachedCredentials = null;
  private boolean checkedAppEngine = false;
  private boolean checkedComputeEngine = false;

  DefaultCredentialsProvider() {}

  /**
   * Returns the Application Default Credentials.
   *
   * <p>Returns the Application Default Credentials which are used to identify and authorize the
   * whole application. The following are searched (in order) to find the Application Default
   * Credentials:
   *
   * <ol>
   *   <li>Credentials file pointed to by the {@code GOOGLE_APPLICATION_CREDENTIALS} environment
   *       variable
   *   <li>Credentials provided by the Google Cloud SDK {@code gcloud auth application-default
   *       login} command
   *   <li>Google App Engine built-in credentials
   *   <li>Google Cloud Shell built-in credentials
   *   <li>Google Compute Engine built-in credentials
   * </ol>
   *
   * @param transportFactory HTTP transport factory, creates the transport used to get access
   *     tokens.
   * @return the credentials instance.
   * @throws IOException if the credentials cannot be created in the current environment.
   */
  final GoogleCredentials getDefaultCredentials(HttpTransportFactory transportFactory)
      throws IOException {
    synchronized (this) {
      if (cachedCredentials == null) {
        cachedCredentials = getDefaultCredentialsUnsynchronized(transportFactory);
      }
      if (cachedCredentials != null) {
        return cachedCredentials;
      }
    }

    throw new IOException(CLOUDSDK_MISSING_CREDENTIALS);
  }

  private final GoogleCredentials getDefaultCredentialsUnsynchronized(
      HttpTransportFactory transportFactory) throws IOException {

    // First try the environment variable
    GoogleCredentials credentials = null;
    String credentialsPath = getEnv(CREDENTIAL_ENV_VAR);
    if (credentialsPath != null && credentialsPath.length() > 0) {
      LOGGER.log(
          Level.FINE,
          String.format("Attempting to load credentials from file: %s", credentialsPath));
      InputStream credentialsStream = null;
      try {
        File credentialsFile = new File(credentialsPath);
        if (!isFile(credentialsFile)) {
          // Path will be put in the message from the catch block below
          throw new IOException("File does not exist.");
        }
        credentialsStream = readStream(credentialsFile);
        credentials =
            GoogleCredentials.fromStream(credentialsStream, transportFactory)
                .withSource(
                    String.format("Env Var %s set to %s", CREDENTIAL_ENV_VAR, credentialsPath));
      } catch (IOException e) {
        // Although it is also the cause, the message of the caught exception can have very
        // important information for diagnosing errors, so include its message in the
        // outer exception message also.
        throw new IOException(
            String.format(
                "Error reading credential file from environment variable %s, value '%s': %s",
                CREDENTIAL_ENV_VAR, credentialsPath, e.getMessage()),
            e);
      } catch (AccessControlException expected) {
        // Exception querying file system is expected on App-Engine
      } finally {
        if (credentialsStream != null) {
          credentialsStream.close();
        }
      }
    }

    // Then try the well-known file
    if (credentials == null) {
      File wellKnownFileLocation = getWellKnownCredentialsFile();
      InputStream credentialsStream = null;
      try {
        if (isFile(wellKnownFileLocation)) {
          LOGGER.log(
              Level.FINE,
              String.format(
                  "Attempting to load credentials from well known file: %s",
                  wellKnownFileLocation.getCanonicalPath()));
          credentialsStream = readStream(wellKnownFileLocation);
          credentials =
              GoogleCredentials.fromStream(credentialsStream, transportFactory)
                  .withSource(
                      String.format(
                          "Well Known File at %s", wellKnownFileLocation.getCanonicalPath()));
        }
      } catch (IOException e) {
        throw new IOException(
            String.format(
                "Error reading credential file from location %s: %s",
                wellKnownFileLocation, e.getMessage()));
      } catch (AccessControlException expected) {
        // Exception querying file system is expected on App-Engine
      } finally {
        if (credentialsStream != null) {
          credentialsStream.close();
        }
      }
      warnAboutProblematicCredentials(credentials);
    }

    // Then try GAE 7 standard environment
    if (credentials == null && isOnGAEStandard7() && !skipAppEngineCredentialsCheck()) {
      LOGGER.log(Level.FINE, "Attempting to load credentials from GAE 7 Standard");
      credentials = tryGetAppEngineCredential();
    }

    // Then try Cloud Shell.  This must be done BEFORE checking
    // Compute Engine, as Cloud Shell runs on GCE VMs.
    if (credentials == null) {
      LOGGER.log(Level.FINE, "Attempting to load credentials from Cloud Shell");
      credentials = tryGetCloudShellCredentials();
    }

    // Then try Compute Engine and GAE 8 standard environment
    if (credentials == null) {
      LOGGER.log(Level.FINE, "Attempting to load credentials from GCE");
      credentials = tryGetComputeCredentials(transportFactory);
      // tryGetComputeCredentials can return a null value. This check won't set the source
      // if the ComputeEngineCredentials is unable to be created
      if (credentials != null) {
        credentials =
            credentials.withSource(
                String.format(
                    "Metadata Server URL set to %s",
                    ComputeEngineCredentials.getMetadataServerUrl(this)));
      }
    }

    if (credentials != null) {
      String quotaFromEnv = getEnv(QUOTA_PROJECT_ENV_VAR);

      if (quotaFromEnv != null && quotaFromEnv.trim().length() > 0) {
        credentials = credentials.createWithQuotaProject(quotaFromEnv);
      }
    }

    return credentials;
  }

  private final File getWellKnownCredentialsFile() {
    return GoogleAuthUtils.getWellKnownCredentialsFile(this);
  }

  private void warnAboutProblematicCredentials(GoogleCredentials credentials) {
    if (credentials instanceof UserCredentials
        && !Boolean.parseBoolean(getEnv(SUPPRESS_GCLOUD_CREDS_WARNING_ENV_VAR))
        && ComputeEngineCredentials.checkStaticGceDetection(this)) {
      LOGGER.log(Level.WARNING, CLOUDSDK_CREDENTIALS_WARNING);
    }
  }

  private boolean runningOnAppEngine() {
    Class<?> systemPropertyClass = null;
    try {
      systemPropertyClass = forName(APP_ENGINE_SIGNAL_CLASS);
    } catch (ClassNotFoundException expected) {
      // SystemProperty will always be present on App Engine.
      return false;
    }
    Exception cause;
    Field environmentField;
    try {
      environmentField = systemPropertyClass.getField("environment");
      Object environmentValue = environmentField.get(null);
      Class<?> environmentType = environmentField.getType();
      Method valueMethod = environmentType.getMethod("value");
      Object environmentValueValue = valueMethod.invoke(environmentValue);
      return (environmentValueValue != null);
    } catch (NoSuchFieldException
        | SecurityException
        | IllegalArgumentException
        | IllegalAccessException
        | NoSuchMethodException
        | InvocationTargetException exception) {
      cause = exception;
    }
    throw new RuntimeException(
        String.format(
            "Unexpected error trying to determine if runnning on Google App Engine: %s",
            cause.getMessage()),
        cause);
  }

  private GoogleCredentials tryGetCloudShellCredentials() {
    String port = getEnv(CLOUD_SHELL_ENV_VAR);
    if (port != null) {
      return CloudShellCredentials.create(Integer.parseInt(port));
    } else {
      return null;
    }
  }

  private GoogleCredentials tryGetAppEngineCredential() throws IOException {
    // Checking for App Engine requires a class load, so check only once
    if (checkedAppEngine) {
      return null;
    }
    boolean onAppEngine = runningOnAppEngine();
    checkedAppEngine = true;
    if (!onAppEngine) {
      return null;
    }
    return new AppEngineCredentials(
        Collections.<String>emptyList(), Collections.<String>emptyList());
  }

  private final GoogleCredentials tryGetComputeCredentials(HttpTransportFactory transportFactory) {
    // Checking compute engine requires a round-trip, so check only once
    if (checkedComputeEngine) {
      return null;
    }
    boolean runningOnComputeEngine = ComputeEngineCredentials.isOnGce(transportFactory, this);
    checkedComputeEngine = true;
    if (runningOnComputeEngine) {
      return ComputeEngineCredentials.newBuilder()
          .setHttpTransportFactory(transportFactory)
          .build();
    }
    return null;
  }

  // Skip app engine check if environment variable
  // GOOGLE_APPLICATION_CREDENTIALS_SKIP_APP_ENGINE = 1 or true
  private boolean skipAppEngineCredentialsCheck() {
    boolean skip = false; // do not skip by default
    String value = getEnv(SKIP_APP_ENGINE_ENV_VAR);
    if (value != null) {
      skip = value.equalsIgnoreCase("true") || value.equals("1");
    }
    return skip;
  }

  protected boolean isOnGAEStandard7() {
    return GAE_RUNTIME_VERSION != null
        && (SPECIFICATION_VERSION.equals("1.7") || RUNTIME_JETTY_LOGGER == null);
  }

  String getOsName() {
    return getProperty("os.name", "").toLowerCase(Locale.US);
  }

  /*
   * Start of methods to allow overriding in the test code to isolate from the environment.
   */

  Class<?> forName(String className) throws ClassNotFoundException {
    return Class.forName(className);
  }

  String getEnv(String name) {
    return System.getenv(name);
  }

  String getProperty(String property, String def) {
    return System.getProperty(property, def);
  }

  boolean isFile(File file) {
    return file.isFile();
  }

  InputStream readStream(File file) throws FileNotFoundException {
    return new FileInputStream(file);
  }

  /*
   * End of methods to allow overriding in the test code to isolate from the environment.
   */
}
