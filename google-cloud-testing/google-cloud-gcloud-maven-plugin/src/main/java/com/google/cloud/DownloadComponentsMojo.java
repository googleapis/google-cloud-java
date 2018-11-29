/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Goal that downloads gcloud components and embeds them as resources in a jar. This is mainly
 * intended to be used to wrapped native emulators in jars. This Mojo makes extensive use of caching
 * which makes it ok to include in the regular build cycle. The initial manifest fetch is cached for
 * 2 hours and the actual binaries are downloaded only when their checksum changed in the manifest.
 */
@Mojo(name = "download")
public class DownloadComponentsMojo extends AbstractMojo {

  private static final long STALE_MS = TimeUnit.HOURS.toMillis(2);

  @Parameter(defaultValue = "https://dl.google.com/dl/cloudsdk/channels/rapid/", required = true)
  private URL baseUrl;

  @Parameter(required = true)
  private List<String> componentNames;

  @Parameter(defaultValue = "${project.build.outputDirectory}/gcloud", required = true)
  private File destinationDir;

  @Parameter(defaultValue = "false", required = true, property = "gcloud.download.force")
  private boolean forceRefresh;

  @Parameter(defaultValue = "false", required = true, property = "gcloud.download.skip")
  private boolean shouldSkipDownload;

  @Parameter(defaultValue = "${session}", readonly = true)
  private MavenSession session;

  public void execute() throws MojoExecutionException {
    if (shouldSkipDownload) {
      return;
    }

    if (session.isOffline() && forceRefresh) {
      throw new MojoExecutionException("Can't force refresh when offline");
    }

    // Ensure that the output directory exists
    destinationDir.mkdirs();

    // Update the cached manifest
    try {
      updateCachedManifest();
    } catch (Exception e) {
      throw new MojoExecutionException("Failed to update the cached manifest", e);
    }

    // Parse the relevant components
    List<Component> components;
    try {
      components = parseManifest();
    } catch (Exception e) {
      throw new MojoExecutionException("Failed to parse the manifest", e);
    }

    // Get the checksums of the existing components
    Map<String, String> checksums;
    try {
      checksums = parseLocalChecksums();
    } catch (Exception e) {
      getLog().warn("Failed to parse local checksums, ignoring", e);
      checksums = new HashMap<>();
    }

    // Download any updated components
    for (Component component : components) {
      if (!forceRefresh && component.getChecksum().equals(checksums.get(component.getId()))) {
        continue;
      }

      try {
        downloadComponent(component);
      } catch (Exception e) {
        throw new MojoExecutionException("Failed to download component " + component.getId(), e);
      }
    }

    // Write the checksums of the newly updated components.
    try {
      writeLocalChecksums(components);
    } catch (IOException e) {
      throw new MojoExecutionException("Failed to update the local checksum cache", e);
    }
  }

  private URL getManifestUrl() throws MalformedURLException {
    return new URL(baseUrl, "components-2.json");
  }

  private File getManifestCache() {
    return new File(destinationDir, "components-2.json");
  }

  private File getComponentPath(Component component) {
    return new File(destinationDir, component.getId());
  }

  private File getChecksumFile() {
    return new File(destinationDir, "checksums.json");
  }

  /**
   * Try to update the locally cached cache manifest. This will be a noop if the cached manifest is
   * fresh enough.
   */
  private void updateCachedManifest() throws IOException {
    URL manifestUrl = getManifestUrl();
    File localCache = getManifestCache();

    boolean isStale = !localCache.exists()
        || new Date().getTime() - localCache.lastModified() < STALE_MS;

    if (forceRefresh && session.isOffline()) {
      throw new IllegalStateException("Can't force manifest refresh while offline");
    }

    if (session.isOffline() && localCache.exists() && isStale) {
      getLog().info("Using stale manifest because offline mode is enabled");
      return;
    }

    if (!forceRefresh && !isStale) {
      getLog().debug("Manifest is up to date, skipping manifest download");
      return;
    }

    if (session.isOffline()) {
      throw new IllegalStateException("Can't download manifest in offline mode");
    }

    getLog().debug("Downloading fresh manifest");

    File tempFile = File.createTempFile(localCache.getName(), "");

    try (BufferedInputStream in = new BufferedInputStream(manifestUrl.openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(tempFile)) {
      byte dataBuffer[] = new byte[1024];
      int bytesRead;
      while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
        fileOutputStream.write(dataBuffer, 0, bytesRead);
      }
    }

    @SuppressWarnings("unused")
    boolean ignored = localCache.delete();

    FileUtils.moveFile(tempFile, localCache);
  }

  /**
   * Parse the locally cached manifest and extract the relevant components.
   */
  private List<Component> parseManifest() throws IOException {
    JsonParser parser = new JsonParser();
    JsonElement json;
    try (FileReader reader = new FileReader(getManifestCache())) {
      json = parser.parse(reader);
    }

    JsonArray jsonComponents = json.getAsJsonObject().get("components").getAsJsonArray();
    List<Component> results = new ArrayList<>();

    for (JsonElement jsonComponent : jsonComponents) {
      JsonObject componentObj = jsonComponent.getAsJsonObject();
      String id = componentObj.get("id").getAsString();

      if (!componentNames.contains(id)) {
        continue;
      }
      results.add(Component.fromJson(baseUrl, componentObj));
    }

    return results;
  }

  /**
   * Parses a local manifest of the downloaded component checksums
   */
  private Map<String, String> parseLocalChecksums() throws IOException {
    JsonElement json = new JsonObject();

    if (getChecksumFile().exists()) {
      JsonParser parser = new JsonParser();

      try (FileReader reader = new FileReader(getChecksumFile())) {
        json = parser.parse(reader);
      }
    }

    Map<String, String> results = new HashMap<>();
    JsonObject checksumMap = json.getAsJsonObject();
    for (String componentName : componentNames) {
      JsonElement checksumJson = checksumMap.get(componentName);
      if (checksumJson != null) {
        results.put(componentName, checksumJson.getAsString());
      }
    }
    return results;
  }

  /**
   * Downloads and extracts the component into the destinationDir.
   */
  private void downloadComponent(Component component) throws IOException, NoSuchAlgorithmException {
    getLog().info("Downloading " + component.getId());

    if (!"tar".equals(component.getFileType())) {
      throw new UnsupportedOperationException(
          "Only tarballs are supported, got: " + component.getFileType());
    }

    // Download and verify the component
    File tmpArchive = File.createTempFile(component.getId(), "");
    tmpArchive.deleteOnExit();

    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    try (InputStream is = component.getSource().openStream();
        FileOutputStream os = new FileOutputStream(tmpArchive)) {

      byte dataBuffer[] = new byte[1024];
      int bytesRead;
      while ((bytesRead = is.read(dataBuffer, 0, 1024)) != -1) {
        digest.update(dataBuffer, 0, bytesRead);
        os.write(dataBuffer, 0, bytesRead);
      }
    }
    String checksum = byteArrayToHex(digest.digest());

    if (!checksum.equals(component.getChecksum())) {
      throw new RuntimeException(String
          .format("Checksum mismatch for %s %s != %s", component.getId(), component.getChecksum(),
              checksum));
    }

    // Stage the expanded archive
    File tmpPath = Files.createTempDirectory(component.getId()).toFile();

    try (TarArchiveInputStream stream = new TarArchiveInputStream(
        new GzipCompressorInputStream(new FileInputStream(tmpArchive)))) {

      ArchiveEntry entry;

      while ((entry = stream.getNextEntry()) != null) {
        File dest = new File(tmpPath, entry.getName());

        if (entry.isDirectory()) {
          if (!dest.mkdirs()) {
            getLog().warn("Failed to expand the directory " + dest);
          }
        } else {
          try (OutputStream outputFileStream = new FileOutputStream(dest)) {
            IOUtils.copy(stream, outputFileStream);
          }
        }
      }
    }

    // Move it into place
    File localPath = getComponentPath(component);
    FileUtils.deleteDirectory(localPath);
    FileUtils.moveDirectory(tmpPath, localPath);
  }

  private static String byteArrayToHex(byte[] a) {
    StringBuilder sb = new StringBuilder(a.length * 2);
    for (byte b : a) {
      sb.append(String.format("%02x", b));
    }
    return sb.toString();
  }


  /**
   * Update the checksums of the downloaded components. This will avoid the need to download them in
   * the future.
   */
  private void writeLocalChecksums(List<Component> components) throws IOException {
    JsonObject results = new JsonObject();

    try {
      JsonParser parser = new JsonParser();
      try (FileReader reader = new FileReader(getChecksumFile())) {
        results = parser.parse(reader).getAsJsonObject();
      }
    } catch (FileNotFoundException e) {
      // ignored
    }

    for (Component component : components) {
      results.add(component.getId(), new JsonPrimitive(component.getChecksum()));
    }

    try (Writer writer = new FileWriter(getChecksumFile())) {
      new Gson().toJson(results, writer);
    }
  }
}
