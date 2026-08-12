package com.google.api.gax.httpjson;

import com.google.api.core.BetaApi;
import com.google.api.gax.rpc.ErrorDetails;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
@BetaApi("The surface for custom LRO error parsing is not stable yet and may change.")
public interface HttpJsonLroErrorParser {
  /** Parses custom LRO response object into standard ErrorDetails. */
  @Nullable
  ErrorDetails parse(Object response);

  /** Concatenates custom LRO response errors into a single descriptive message. */
  @Nullable
  String parseErrorMessage(Object response);
}
