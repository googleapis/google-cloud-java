/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.conformance;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public final class ConformanceTestLocator {

  private ConformanceTestLocator() {}

  /**
   * Given the provided {@link MatchPattern matchPattern} list resources on the classpath starting
   * from {@link MatchPattern#getBaseResourcePath() MatchPattern.getBaseResourcePath} and for each
   * resources resource test that it is a file and that matches according to {@link
   * MatchPattern#matches(String) MatchPattern.matches(String)}.
   *
   * <p>Resolution of resources paths will be against the current threads context class loader
   * ({@link Thread#currentThread()}.{@link Thread#getContextClassLoader() getContextClassLoader()}
   *
   * @param matchPattern The {@link MatchPattern} to match against
   * @return The list of all resources on the classpath that match the specified {@code
   *     matchPattern}
   * @throws IOException If there is an error attempting to read a classpath resource (listing the
   *     contents of a directory or jar).
   * @throws URISyntaxException If there is an error translating a classpath URL into a filesystem
   *     URI.
   */
  public static List<String> findAllResourcePaths(final MatchPattern matchPattern)
      throws IOException, URISyntaxException {
    return findAllResourcePaths(matchPattern, Thread.currentThread().getContextClassLoader());
  }

  /**
   * Given the provided {@link MatchPattern matchPattern} list resources on the classpath starting
   * from {@link MatchPattern#getBaseResourcePath() MatchPattern.getBaseResourcePath} and for each
   * resources resource test that it is a file and that matches according to {@link
   * MatchPattern#matches(String) MatchPattern.matches(String)}.
   *
   * <p>Resolution of resources paths will be against the parameter {@code classLoader}
   *
   * @param matchPattern The {@link MatchPattern} to match against
   * @param classLoader The classLoader to scan for resources
   * @return The list of all resources on the classpath that match the specified {@code
   *     matchPattern}
   * @throws IOException If there is an error attempting to read a classpath resource (listing the
   *     contents of a directory or jar).
   * @throws URISyntaxException If there is an error translating a classpath URL into a filesystem
   *     URI.
   */
  public static List<String> findAllResourcePaths(
      final MatchPattern matchPattern, ClassLoader classLoader)
      throws IOException, URISyntaxException {
    final List<String> resourcePaths = new ArrayList<>();
    final Enumeration<URL> pkgDir = classLoader.getResources(matchPattern.getBaseResourcePath());
    while (pkgDir.hasMoreElements()) {
      URL url = pkgDir.nextElement();
      if (url != null) {
        final String scheme = url.getProtocol();
        switch (scheme) {
          case "file":
            final List<String> cf = handleFileScheme(url, matchPattern);
            resourcePaths.addAll(cf);
            break;
          case "jar":
            final List<String> cj = handleJarScheme(url, matchPattern);
            resourcePaths.addAll(cj);
            break;
          default:
            throw new IllegalStateException("Unable to scan scheme '" + scheme + "'");
        }
      }
    }

    return resourcePaths;
  }

  private static List<String> handleFileScheme(final URL url, MatchPattern mp)
      throws IOException, URISyntaxException {
    final Path path = Paths.get(url.toURI());
    return handleFileScheme(mp, path);
  }

  private static List<String> handleFileScheme(final MatchPattern mp, final Path path)
      throws IOException {
    final List<String> resourcePaths = new ArrayList<>();
    try (final DirectoryStream<Path> paths = Files.newDirectoryStream(path)) {
      for (Path p : paths) {
        if (Files.isDirectory(p)) {
          resourcePaths.addAll(handleFileScheme(mp, p));
        } else {
          final String filePath = normalizePath(p);
          final String resourcePath =
              filePath.substring(filePath.indexOf(mp.getBaseResourcePath()));
          if (mp.matches(resourcePath)) {
            resourcePaths.add(resourcePath);
          }
        }
      }
    }
    return resourcePaths;
  }

  private static List<String> handleJarScheme(final URL url, MatchPattern mp) throws IOException {
    final String urlPath = url.getPath();
    final String jarPath = urlPath.substring(5, urlPath.indexOf("!"));

    final List<String> resourcePaths = new ArrayList<>();
    final JarFile jarFile = new JarFile(jarPath);
    final Enumeration<JarEntry> jarEntries = jarFile.entries();
    while (jarEntries.hasMoreElements()) {
      JarEntry je = jarEntries.nextElement();
      if (!je.isDirectory() && mp.matches(je.getName())) {
        resourcePaths.add(je.getName());
      }
    }
    return resourcePaths;
  }

  private static String normalizePath(Path p) {
    final String s = p.normalize().toString();
    if (File.separatorChar == '\\') {
      return s.replace('\\', '/');
    } else {
      return s;
    }
  }

  /**
   * Factory method to create a relatively simple {@link MatchPattern}.
   *
   * @param baseResourcePath The non-null base path to start scanning for resources on the classpath
   * @param suffix The non-null suffix to match found elements against for inclusion
   * @return A new {@link MatchPattern} where classpath scanning will start from {@code
   *     baseResourcePath} walking the classpath and matching to elements that end in {@code
   *     suffix}. Suffix matching is a simple match (non-regex).
   */
  public static MatchPattern newMatchPattern(final String baseResourcePath, final String suffix) {
    if (baseResourcePath == null) {
      throw new IllegalArgumentException("baseResourcePath must be non-null");
    }
    if (suffix == null || suffix.isEmpty()) {
      throw new IllegalArgumentException("suffix must be non-null and non-empty");
    }
    // when listing the resources from the classpath, a leading slash will result in resources
    // not being found. If the baseResourcePath passed in here has a leading slash, detect and
    // remove it.
    int begin = 0;
    if (baseResourcePath.startsWith("/")) {
      begin = 1;
    }
    return new SimpleMatchPattern(baseResourcePath.substring(begin), suffix);
  }

  public interface MatchPattern {
    String getBaseResourcePath();

    boolean matches(String resourcePath);
  }

  private static final class SimpleMatchPattern implements MatchPattern {
    private final String baseResourcePath;
    private final String suffix;

    SimpleMatchPattern(final String baseResourcePath, final String suffix) {
      // parameter construction validation is performed in the factory method #newMatchPattern
      this.baseResourcePath = baseResourcePath;
      this.suffix = suffix;
    }

    @Override
    public String getBaseResourcePath() {
      return baseResourcePath;
    }

    @Override
    public boolean matches(final String resourcePath) {
      return resourcePath.startsWith(baseResourcePath) && resourcePath.endsWith(suffix);
    }
  }
}
