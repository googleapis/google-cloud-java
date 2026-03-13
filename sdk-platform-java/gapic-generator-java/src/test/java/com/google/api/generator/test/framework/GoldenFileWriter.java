// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.generator.test.framework;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GoldenFileWriter {

  /**
   * Save the generated code from JUnit test to a file for updating goldens. The relative path
   * `com/google/..` which is identical with the location of goldens files which will help us easily
   * replace the original goldens. For example:
   * `src/test/java/com/google/api/generator/gapic/composer/ComposerTest.java` will save the
   * generated code into a file called `ComposerTest.golden` at
   * `src/test/java/com/google/api/generator/gapic/composer/goldens/ComposerTest.golden`.
   *
   * @param clazz the test class.
   * @param fileName the name of saved file, usually a test method name with suffix `.golden`
   * @param codegen the generated code from JUnit test
   */
  public static void saveCodegenToFile(Class<?> clazz, String fileName, String codegen) {
    if (System.getProperty("updateUnitGoldens") == null) {
      return;
    }

    String relativeGoldenDir = getTestoutGoldenDir(clazz);
    saveCodeToFile(relativeGoldenDir, fileName, codegen);
  }

  public static void saveSampleCodegenToFile(
      Class<?> clazz, String sampleDir, String fileName, String codegen) {
    String relativeGoldenDir = getTestoutGoldenDir(clazz) + "/samples/" + sampleDir;
    saveCodeToFile(relativeGoldenDir, fileName, codegen);
  }

  private static void saveCodeToFile(String relativeGoldenDir, String fileName, String codegen) {
    Path testOutputDir = Paths.get("src", "test", "java", relativeGoldenDir);
    testOutputDir.toFile().mkdirs();
    try (FileWriter myWriter = new FileWriter(testOutputDir.resolve(fileName).toFile())) {
      myWriter.write(codegen);
    } catch (IOException e) {
      throw new SaveCodegenToFileException(
          String.format(
              "Error occurred when saving codegen to file %s/%s", relativeGoldenDir, fileName));
    }
  }

  private static String getTestoutGoldenDir(Class<?> clazz) {
    return clazz.getPackage().getName().replace(".", "/") + "/goldens/";
  }

  public static String getGoldenDir(Class<?> clazz) {
    return "src/test/java/" + getTestoutGoldenDir(clazz);
  }

  public static class SaveCodegenToFileException extends RuntimeException {

    public SaveCodegenToFileException(String errorMessage) {
      super(errorMessage);
    }
  }
}
