/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.nativeimage.features.clients;

import static com.google.cloud.nativeimage.features.NativeImageUtils.registerClassForReflection;
import static com.google.cloud.nativeimage.features.NativeImageUtils.registerClassHierarchyForReflection;

import com.oracle.svm.core.annotate.AutomaticFeature;
import com.oracle.svm.core.configure.ResourcesRegistry;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.function.Consumer;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;
import org.graalvm.nativeimage.ImageSingletons;
import org.graalvm.nativeimage.hosted.Feature;
import org.graalvm.nativeimage.hosted.RuntimeReflection;

/** A feature which registers reflective usages of the Cloud Functions library. */
@AutomaticFeature
final class CloudFunctionsFeature implements Feature {

  private static final String FUNCTION_INVOKER_CLASS =
      "com.google.cloud.functions.invoker.runner.Invoker";

  private static final List<String> FUNCTIONS_CLASSES =
      Arrays.asList(
          "com.google.cloud.functions.HttpFunction",
          "com.google.cloud.functions.RawBackgroundFunction",
          "com.google.cloud.functions.BackgroundFunction");

  @Override
  public void beforeAnalysis(BeforeAnalysisAccess access) {
    Class<?> invokerClass = access.findClassByName(FUNCTION_INVOKER_CLASS);
    if (invokerClass != null) {
      // JCommander libraries
      registerClassForReflection(access, "com.beust.jcommander.converters.StringConverter");
      registerClassForReflection(access, "com.beust.jcommander.validators.NoValidator");
      registerClassForReflection(access, "com.beust.jcommander.validators.NoValueValidator");

      // Jetty libraries
      registerClassForReflection(access, "org.eclipse.jetty.http.HttpTokens");
      registerClassForReflection(access, "org.eclipse.jetty.util.TypeUtil");

      // Cloud Functions core
      registerClassForReflection(
          access, "com.google.cloud.functions.invoker.runner.Invoker$Options");

      // Register Jetty Resources.
      ResourcesRegistry resourcesRegistry = ImageSingletons.lookup(ResourcesRegistry.class);
      resourcesRegistry.addResources(
          "\\QMETA-INF/services/org.eclipse.jetty.http.HttpFieldPreEncoder\\E");
      resourcesRegistry.addResources("\\Qorg/eclipse/jetty/http/encoding.properties\\E");
      resourcesRegistry.addResources("\\Qorg/eclipse/jetty/http/mime.properties\\E");
      resourcesRegistry.addResources("\\Qorg/eclipse/jetty/version/build.properties\\E");
      resourcesRegistry.addResourceBundles("javax.servlet.LocalStrings");
      resourcesRegistry.addResourceBundles("javax.servlet.http.LocalStrings");

      // Register user-implemented Function classes
      List<Class<?>> functionClasses =
          FUNCTIONS_CLASSES.stream()
              .map(name -> access.findClassByName(name))
              .collect(Collectors.toList());

      scanJarClasspath(
          access,
          clazz -> {
            boolean isFunctionSubtype =
                functionClasses.stream()
                    .anyMatch(
                        function ->
                            function.isAssignableFrom(clazz)
                                && !Modifier.isAbstract(clazz.getModifiers()));

            if (isFunctionSubtype) {
              RuntimeReflection.register(clazz);
              RuntimeReflection.register(clazz.getDeclaredConstructors());
              RuntimeReflection.register(clazz.getDeclaredMethods());

              // This part is to register the parameterized class of BackgroundFunctions
              // for reflection; i.e. register type T in BackgroundFunction<T>
              for (Type type : clazz.getGenericInterfaces()) {
                if (type instanceof ParameterizedType) {
                  ParameterizedType paramType = (ParameterizedType) type;
                  for (Type argument : paramType.getActualTypeArguments()) {
                    registerClassHierarchyForReflection(access, argument.getTypeName());
                  }
                }
              }
            }
          });
    }
  }

  /**
   * Scan the JAR classpath for classes. The {@code classProcessorFunction} is run once for each
   * class in the classpath.
   */
  private static void scanJarClasspath(
      FeatureAccess access, Consumer<Class<?>> classProcessorCallback) {

    List<Path> classPath = access.getApplicationClassPath();
    try {
      for (Path path : classPath) {
        JarFile jarFile = new JarFile(path.toFile());
        Enumeration<JarEntry> entries = jarFile.entries();

        while (entries.hasMoreElements()) {
          JarEntry jarEntry = entries.nextElement();
          String fileName = jarEntry.getName();
          if (fileName.endsWith(".class")) {
            String className = fileName.substring(0, fileName.length() - 6).replaceAll("/", ".");

            Class<?> clazz = access.findClassByName(className);
            if (clazz != null) {
              classProcessorCallback.accept(clazz);
            }
          }
        }
      }
    } catch (IOException e) {
      throw new RuntimeException("Failed to read classpath: ", e);
    }
  }
}
