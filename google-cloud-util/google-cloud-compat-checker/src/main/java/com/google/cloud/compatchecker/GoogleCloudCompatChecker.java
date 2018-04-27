/*
 * Copyright 2017 Google LLC
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
package com.google.cloud.compatchecker;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import io.netty.handler.ssl.OpenSsl;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import kr.motd.maven.os.Detector;

public class GoogleCloudCompatChecker {
  private static Set<String> supportedClassifiers =
      ImmutableSet.of("linux-x86_64", "osx-x86_64", "windows-x86_64");

  private static class OsDetector extends Detector {
    public void detect(Properties props, List<String> classifierWithLikes) {
      super.detect(props, classifierWithLikes);
    }

    @Override
    protected void log(String s) {
      // meh
    }

    @Override
    protected void logProperty(String s, String s1) {
      // meh
    }
  }

  public static void main(String[] args) {
    if (!check()) {
      System.exit(1);
    }
  }

  public static boolean check() {
    Properties osProperties = new Properties();
    new OsDetector().detect(osProperties, Lists.<String>newArrayList());

    String bitMode = System.getProperty("sun.arch.data.model");

    boolean openSslIsAvailable = OpenSsl.isAvailable();
    boolean openSslAlpnIsSupported = OpenSsl.isAlpnSupported();
    String javaVersion = Runtime.class.getPackage().getImplementationVersion();
    String javaSpecificationVersion = System.getProperty("java.specification.version");

    System.out.println("OS details:");
    System.out.println("  " + Detector.DETECTED_NAME + ": " + osProperties.get(Detector.DETECTED_NAME));
    System.out.println("  " + Detector.DETECTED_ARCH + ": " + osProperties.get(Detector.DETECTED_ARCH));
    System.out.println("  " + Detector.DETECTED_CLASSIFIER + ": " + osProperties.get(Detector.DETECTED_CLASSIFIER));
    System.out.println("  " + Detector.DETECTED_RELEASE + ": " + osProperties.get(Detector.DETECTED_RELEASE));
    System.out.println("  " + Detector.DETECTED_RELEASE_VERSION + ": " + osProperties.get(Detector.DETECTED_RELEASE_VERSION));
    System.out.println("JVM details:");
    System.out.println("  Java version: " + javaVersion);
    System.out.println("  Java specification version: " + javaSpecificationVersion);
    System.out.println("  JVM bit mode: " + bitMode);
    System.out.println("OpenSSL details:");
    System.out.println("  open ssl is available: " + openSslIsAvailable);
    System.out.println("  ALPN is supported: " + openSslAlpnIsSupported);

    String osClassifier = (String)osProperties.get(Detector.DETECTED_CLASSIFIER);

    boolean compatible = true;
    boolean warnings = false;
    System.out.println("Checking compatibility...");
    if (supportedClassifiers.contains(osClassifier)) {
      System.out.println("  [PASS] This OS + architecture is supported.");
    } else {
      System.out.println("  [FAIL] This OS + architecture is NOT supported.");
      compatible = false;
    }
    if (bitMode.equals("64")) {
      System.out.println("  [PASS] 64-bit JVM is supported.");
    } else {
      System.out.println("  [FAIL] " + bitMode + "-bit JVM is NOT supported.");
      compatible = false;
    }
    if (openSslIsAvailable) {
      System.out.println("  [PASS] Open SSL is available");
    } else {
      System.out.println("  [FAIL] Open SSL is NOT available");
      if (OpenSsl.unavailabilityCause() != null) {
        System.out.println("         Open SSL Unavailability cause:");
        OpenSsl.unavailabilityCause().printStackTrace(System.out);
      }
      compatible = false;
    }
    if (openSslAlpnIsSupported) {
      System.out.println("  [PASS] Open SSL ALPN is supported");
    } else {
      System.out.println("  [FAIL] Open SSL ALPN is NOT supported");
      compatible = false;
    }
    if (javaSpecificationVersion == null) {
      System.out.println("  [WARN] Couldn't detect java specification version.");
      warnings = true;
    } else if (javaSpecificationVersion.equals("1.7")) {
      System.out.println("  [WARN] gRPC doesn't work on Google App Engine Standard under Java 1.7");
      warnings = true;
    }
    if (!compatible) {
      System.out.println("Result: FAIL");
      System.out.println("  Your environment is not supported by Forked Tomcat Native.");
      System.out.println("  See http://netty.io/wiki/forked-tomcat-native.html for details.");
      System.out.println("  This means that you won't be able to use grpc-based APIs, but");
      System.out.println("  http1-based APIs should still work.");
    } else {
      System.out.println("Result: UNKNOWN (checker implementation not complete)");
      System.out.println("  Based on what was checked, nothing was identified that would");
      System.out.println("  prevent you from using grpc-based APIs.");
      if (warnings) {
        System.out.println("  However, there were some warnings to watch out for.");
      }
    }

    return compatible;
  }
}
