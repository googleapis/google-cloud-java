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

package com.google.cloud.nativeimage.features;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Logger;
import org.graalvm.nativeimage.hosted.Feature.FeatureAccess;
import org.graalvm.nativeimage.hosted.RuntimeReflection;

/** Internal class offering helper methods for registering methods/classes for reflection. */
public class NativeImageUtils {

  private static final Logger LOGGER = Logger.getLogger(NativeImageUtils.class.getName());

  /** Returns the method of a class or fails if it is not present. */
  public static Method getMethodOrFail(Class<?> clazz, String methodName, Class<?>... params) {
    try {
      return clazz.getDeclaredMethod(methodName, params);
    } catch (NoSuchMethodException e) {
      throw new RuntimeException(
          "Failed to find method " + methodName + " for class " + clazz.getName(), e);
    }
  }

  /** Registers a class for reflective construction via its default constructor. */
  public static void registerForReflectiveInstantiation(FeatureAccess access, String className) {
    Class<?> clazz = access.findClassByName(className);
    if (clazz != null) {
      RuntimeReflection.register(clazz);
      RuntimeReflection.registerForReflectiveInstantiation(clazz);
    } else {
      LOGGER.warning(
          "Failed to find " + className + " on the classpath for reflective instantiation.");
    }
  }

  /** Registers all constructors of a class for reflection. */
  public static void registerConstructorsForReflection(FeatureAccess access, String name) {
    Class<?> clazz = access.findClassByName(name);
    if (clazz != null) {
      RuntimeReflection.register(clazz);
      RuntimeReflection.register(clazz.getDeclaredConstructors());
    } else {
      LOGGER.warning("Failed to find " + name + " on the classpath for reflection.");
    }
  }

  /** Registers an entire class for reflection use. */
  public static void registerClassForReflection(FeatureAccess access, String name) {
    Class<?> clazz = access.findClassByName(name);
    if (clazz != null) {
      RuntimeReflection.register(clazz);
      RuntimeReflection.register(clazz.getDeclaredConstructors());
      RuntimeReflection.register(clazz.getDeclaredFields());
      RuntimeReflection.register(clazz.getDeclaredMethods());
    } else {
      LOGGER.warning("Failed to find " + name + " on the classpath for reflection.");
    }
  }

  /**
   * Registers the transitive class hierarchy of the provided {@code className} for reflection.
   *
   * <p>The transitive class hierarchy contains the class itself and its transitive set of
   * *non-private* nested subclasses.
   */
  public static void registerClassHierarchyForReflection(FeatureAccess access, String className) {
    Class<?> clazz = access.findClassByName(className);
    if (clazz != null) {
      registerClassForReflection(access, className);
      for (Class<?> nestedClass : clazz.getDeclaredClasses()) {
        if (!Modifier.isPrivate(nestedClass.getModifiers())) {
          registerClassHierarchyForReflection(access, nestedClass.getName());
        }
      }
    } else {
      LOGGER.warning("Failed to find " + className + " on the classpath for reflection.");
    }
  }

  /** Registers a class for unsafe reflective field access. */
  public static void registerForUnsafeFieldAccess(
      FeatureAccess access, String className, String... fields) {
    Class<?> clazz = access.findClassByName(className);
    if (clazz != null) {
      RuntimeReflection.register(clazz);
      for (String fieldName : fields) {
        try {
          RuntimeReflection.register(clazz.getDeclaredField(fieldName));
        } catch (NoSuchFieldException ex) {
          LOGGER.warning("Failed to register field " + fieldName + " for class " + className);
          LOGGER.warning(ex.getMessage());
        }
      }
    } else {
      LOGGER.warning(
          "Failed to find "
              + className
              + " on the classpath for unsafe fields access registration.");
    }
  }

  /** Registers all the classes under the specified package for reflection. */
  public static void registerPackageForReflection(FeatureAccess access, String packageName) {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    try {
      String path = packageName.replace('.', '/');

      Enumeration<URL> resources = classLoader.getResources(path);
      while (resources.hasMoreElements()) {
        URL url = resources.nextElement();

        URLConnection connection = url.openConnection();
        if (connection instanceof JarURLConnection) {
          List<String> classes = findClassesInJar((JarURLConnection) connection, packageName);
          for (String className : classes) {
            registerClassHierarchyForReflection(access, className);
          }
        }
      }
    } catch (IOException e) {
      throw new RuntimeException("Failed to load classes under package name.", e);
    }
  }

  private static List<String> findClassesInJar(JarURLConnection urlConnection, String packageName)
      throws IOException {

    List<String> result = new ArrayList<>();

    final JarFile jarFile = urlConnection.getJarFile();
    final Enumeration<JarEntry> entries = jarFile.entries();

    while (entries.hasMoreElements()) {
      JarEntry entry = entries.nextElement();
      String entryName = entry.getName();

      if (entryName.endsWith(".class")) {
        String javaClassName = entryName.replace(".class", "").replace('/', '.');

        if (javaClassName.startsWith(packageName)) {
          result.add(javaClassName);
        }
      }
    }

    return result;
  }
}
