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

import com.github.difflib.DiffUtils;
import com.github.difflib.UnifiedDiffUtils;
import com.github.difflib.patch.Patch;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

class Differ {
  private static final String LINE_SPLITTER = "\\r?\\n";

  static List<String> diff(Path goldenFilePath, String codegen) {
    List<String> revised = Arrays.asList(codegen.split(LINE_SPLITTER));
    List<String> original = null;
    try {
      original = Files.readAllLines(goldenFilePath);
    } catch (IOException e) {
      throw new GoldenFileReadException(
          String.format("Error occurs when reading golden file %s", goldenFilePath), e);
    }
    return diffTwoStringLists(original, revised);
  }

  static List<String> diff(String expectedStr, String actualStr) {
    List<String> revised = Arrays.asList(actualStr.split(LINE_SPLITTER));
    List<String> original = Arrays.asList(expectedStr.split(LINE_SPLITTER));
    return diffTwoStringLists(original, revised);
  }

  static List<String> diffTwoStringLists(List<String> original, List<String> revised) {
    Patch<String> diff = null;
    try {
      diff = DiffUtils.diff(original, revised);
    } catch (RuntimeException e) {
      throw new ComputeDiffException("Could not compute the differences.", e);
    }
    List<String> unifiedDiff =
        UnifiedDiffUtils.generateUnifiedDiff("golden", "codegen", original, diff, 2);
    return unifiedDiff;
  }

  private static class GoldenFileReadException extends RuntimeException {

    private static final long serialVersionUID = 7423787084310530945L;

    GoldenFileReadException(String errorMessage, Throwable cause) {
      super(errorMessage, cause);
    }
  }

  private static class ComputeDiffException extends RuntimeException {

    private static final long serialVersionUID = -7480557222244987342L;

    ComputeDiffException(String errorMessage, Throwable cause) {
      super(errorMessage, cause);
    }
  }
}
