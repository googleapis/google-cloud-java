package com.google.cloud.storage.contrib.nio;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.ProviderMismatchException;
import java.util.regex.Pattern;

final class CloudStorageUtil {

  private static final Pattern BUCKET_PATTERN = Pattern.compile("[a-z0-9][-._a-z0-9]+[a-z0-9]");

  static void checkBucket(String bucket) {
    // TODO: The true check is actually more complicated. Consider implementing it.
    checkArgument(
        BUCKET_PATTERN.matcher(bucket).matches(),
        "Invalid bucket name: '"
            + bucket
            + "'. "
            + "GCS bucket names must contain only lowercase letters, numbers, dashes (-), "
            + "underscores (_), and dots (.). Bucket names must start and end with a number or a "
            + "letter. See the following page for more details: "
            + "https://developers.google.com/storage/docs/bucketnaming");
  }

  static CloudStoragePath checkPath(Path path) {
    if (!(checkNotNull(path) instanceof CloudStoragePath)) {
      throw new ProviderMismatchException(
          String.format(
              "Not a cloud storage path: %s (%s)", path, path.getClass().getSimpleName()));
    }
    return (CloudStoragePath) path;
  }

  static URI stripPathFromUri(URI uri) {
    try {
      return new URI(
          uri.getScheme(),
          uri.getUserInfo(),
          uri.getHost(),
          uri.getPort(),
          null,
          uri.getQuery(),
          uri.getFragment());
    } catch (URISyntaxException e) {
      throw new IllegalArgumentException(e.getMessage());
    }
  }

  /**
   * Makes {@code NullPointerTester} happy.
   */
  @SafeVarargs
  static <T> void checkNotNullArray(T... values) {
    for (T value : values) {
      checkNotNull(value);
    }
  }

  private CloudStorageUtil() {}
}
