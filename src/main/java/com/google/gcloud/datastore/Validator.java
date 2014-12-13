package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.base.Strings;

import java.util.regex.Pattern;

/**
 * Utility to validate Datastore type/values.
 */
class Validator {

  private static final Pattern DATASET_PATTERN = Pattern.compile(
      "([a-z\\d\\-]{1,100}~)?([a-z\\d][a-z\\d\\-\\.]{0,99}\\:)?([a-z\\d][a-z\\d\\-]{0,99})");
  private static final int MAX_NAMESPACE_LENGTH = 100;
  private static final Pattern NAMESPACE_PATTERN =
      Pattern.compile(String.format("[0-9A-Za-z\\._\\-]{0,%d}", MAX_NAMESPACE_LENGTH));


  static String validateDataset(String dataset) {
    checkArgument(!Strings.isNullOrEmpty(dataset), "dataset can't be empty or null");
    checkArgument(Validator.DATASET_PATTERN.matcher(dataset).matches(),
          "dataset must match the following pattern: " + Validator.DATASET_PATTERN.pattern());
    return dataset;
  }

  static String validateNamespace(String namespace) {
    if (namespace != null) {
      checkArgument(!namespace.isEmpty(), "namespace must not be an empty string");
      checkArgument(namespace.length() <= 100,
          "namespace must not contain more than 100 characters");
      checkArgument(Validator.NAMESPACE_PATTERN.matcher(namespace).matches(),
          "namespace must the following pattern: " + Validator.NAMESPACE_PATTERN.pattern());
    }
    return namespace;
  }

  static String validateKind(String kind) {
    checkArgument(!Strings.isNullOrEmpty(kind), "kind must not be empty or null");
    checkArgument(kind.length() <= 500, "kind must not contain more than 500 characters");
    return kind;
  }
}
