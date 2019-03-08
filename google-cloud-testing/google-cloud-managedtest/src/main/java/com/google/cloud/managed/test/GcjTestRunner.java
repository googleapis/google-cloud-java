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
package com.google.cloud.managed.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

public class GcjTestRunner implements Runnable {
  private final JUnitCore unit;
  private final ByteArrayOutputStream resultBytes;
  private final PrintStream resultStream;
  private final List<Class<?>> classes;

  public GcjTestRunner(List<Class<?>> classes) {
    this.unit = new JUnitCore();
    this.resultBytes = new ByteArrayOutputStream();
    this.resultStream = new PrintStream(this.resultBytes);
    this.unit.addListener(new TextListener(this.resultStream));
    this.classes = new ArrayList<>(classes);
  }

  @Override
  public void run() {
    synchronized (resultStream) {
      resultBytes.reset();
    }
    for (Class<?> clazz : classes) {
      resultStream.append("\n").append("Running ").append(clazz.getName());
      ClassLoader classLoader = clazz.getClassLoader();
      resultStream.append(" (loaded by ").append(classLoader.getClass().getName()).append(")\n\n");
      unit.run(clazz);
    }

    resultStream.append("ALL TESTS COMPLETED");
  }

  public String getOutput() {
    // works because PrintStream is thread safe synchronizing on "this".
    synchronized (resultStream) {
      try {
        return resultBytes.toString("UTF-8");
      } catch (UnsupportedEncodingException e) {
        return null;
      }
    }
  }
}
