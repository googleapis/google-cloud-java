/*
 * Copyright 2022 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
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

package com.google.api.gax.nativeimage;

import com.google.api.core.InternalApi;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.graalvm.nativeimage.hosted.Feature.FeatureAccess;
import org.graalvm.nativeimage.hosted.RuntimeReflection;

/** Internal class offering helper methods for registering methods/classes for reflection. */
@InternalApi
public class NativeImageUtils {

  private static final Logger LOGGER = Logger.getLogger(NativeImageUtils.class.getName());
  private static final String CLASS_REFLECTION_ERROR_MESSAGE =
      "Failed to find {0} on the classpath for reflection.";

  private NativeImageUtils() {}

  /** Returns the method of a class or fails if it is not present. */
  public static Method getMethodOrFail(Class<?> clazz, String methodName, Class<?>... params) {
    try {
      return clazz.getDeclaredMethod(methodName, params);
    } catch (NoSuchMethodException e) {
      throw new IllegalStateException(
          String.format("Failed to find method %s for class %s", methodName, clazz.getName()), e);
    }
  }

  /** Registers a class for reflective construction via its default constructor. */
  public static void registerForReflectiveInstantiation(FeatureAccess access, String className) {
    Class<?> clazz = access.findClassByName(className);
    if (clazz != null) {
      RuntimeReflection.register(clazz);
      RuntimeReflection.registerForReflectiveInstantiation(clazz);
    } else {
      LOGGER.log(
          Level.WARNING,
          "Failed to find {0} on the classpath for reflective instantiation.",
          className);
    }
  }

  /** Registers all constructors of a class for reflection. */
  public static void registerConstructorsForReflection(FeatureAccess access, String name) {
    Class<?> clazz = access.findClassByName(name);
    if (clazz != null) {
      RuntimeReflection.register(clazz);
      RuntimeReflection.register(clazz.getDeclaredConstructors());
    } else {
      LOGGER.log(Level.WARNING, CLASS_REFLECTION_ERROR_MESSAGE, name);
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
      LOGGER.log(Level.WARNING, CLASS_REFLECTION_ERROR_MESSAGE, name);
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
      LOGGER.log(Level.WARNING, CLASS_REFLECTION_ERROR_MESSAGE, className);
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
      LOGGER.log(
          Level.WARNING,
          "Failed to find {0} on the classpath for unsafe fields access registration.",
          className);
    }
  }
}
