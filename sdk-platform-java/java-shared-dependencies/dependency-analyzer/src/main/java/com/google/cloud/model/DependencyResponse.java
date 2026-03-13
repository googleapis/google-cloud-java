package com.google.cloud.model;

import com.google.common.collect.ImmutableList;
import java.util.List;

/**
 * A resolved dependency graph for the given package version.
 * <p>
 * For more information, please refer to <a
 * href="https://docs.deps.dev/api/v3/#getdependencies">GetDependencies</a>.
 *
 * @param nodes The first node is the root of the graph.
 */
public record DependencyResponse(List<Node> nodes) {

  @Override
  public List<Node> nodes() {
    return ImmutableList.copyOf(nodes);
  }
}
