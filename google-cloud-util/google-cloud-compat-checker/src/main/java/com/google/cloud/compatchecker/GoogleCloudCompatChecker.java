/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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
    Properties osProperties = new Properties();
    new OsDetector().detect(osProperties, Lists.<String>newArrayList());
    System.out.println("OS details:");
    System.out.println("  " + Detector.DETECTED_NAME + ": " + osProperties.get(Detector.DETECTED_NAME));
    System.out.println("  " + Detector.DETECTED_ARCH + ": " + osProperties.get(Detector.DETECTED_ARCH));
    System.out.println("  " + Detector.DETECTED_CLASSIFIER + ": " + osProperties.get(Detector.DETECTED_CLASSIFIER));
    System.out.println("  " + Detector.DETECTED_RELEASE + ": " + osProperties.get(Detector.DETECTED_RELEASE));
    System.out.println("  " + Detector.DETECTED_RELEASE_VERSION + ": " + osProperties.get(Detector.DETECTED_RELEASE_VERSION));

    String osClassifier = (String)osProperties.get(Detector.DETECTED_CLASSIFIER);

    boolean compatible = true;
    System.out.println("Checking compatibility...");
    if (supportedClassifiers.contains(osClassifier)) {
      System.out.println("  This OS + architecture is supported by Forked Tomcat Native.");
    } else {
      System.out.println("  This OS + architecture is NOT supported by Forked Tomcat Native.");
      System.out.println("  See http://netty.io/wiki/forked-tomcat-native.html for details.");
      compatible = false;
    }
    if (!compatible) {
      System.out.println("Result: FAIL");
    } else {
      System.out.println("Result: UNKNOWN (checker implementation not complete)");
    }
  }
}
