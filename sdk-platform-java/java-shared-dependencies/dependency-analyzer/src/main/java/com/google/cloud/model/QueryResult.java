package com.google.cloud.model;

import com.google.common.collect.ImmutableList;
import java.util.List;

/**
 * Information about multiple package versions.
 * <p>
 * For more information, please refer to <a href="https://docs.deps.dev/api/v3/#query">Query</a>
 */
public record QueryResult(List<Result> results) {

  @Override
  public List<Result> results() {
    return ImmutableList.copyOf(results);
  }
}
