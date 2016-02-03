package com.google.gcloud.storage.contrib.nio;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;

import com.google.appengine.tools.cloudstorage.GcsFileOptions;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.ProviderMismatchException;
import java.util.Map;
import java.util.regex.Pattern;

final class CloudStorageUtil {

  private static final Pattern BUCKET_PATTERN = Pattern.compile("[a-z0-9][-._a-z0-9.]+[a-z0-9]");

  static void checkBucket(String bucket) {
    // TODO(b/18998200): The true check is actually more complicated. Consider implementing it.
    checkArgument(BUCKET_PATTERN.matcher(bucket).matches(), ""
        + "Invalid bucket name: '" + bucket + "'. "
        + "GCS bucket names must contain only lowercase letters, numbers, dashes (-), "
        + "underscores (_), and dots (.). Bucket names must start and end with a number or letter. "
        + "See https://developers.google.com/storage/docs/bucketnaming for more details.");
  }

  static CloudStoragePath checkPath(Path path) {
    if (!(checkNotNull(path) instanceof CloudStoragePath)) {
      throw new ProviderMismatchException(String.format(
          "Not a cloud storage path: %s (%s)", path, path.getClass().getSimpleName()));
    }
    return (CloudStoragePath) path;
  }

  static GcsFileOptions.Builder copyFileOptions(GcsFileOptions options) {
    GcsFileOptions.Builder builder = new GcsFileOptions.Builder();
    if (!isNullOrEmpty(options.getAcl())) {
      builder.acl(options.getAcl());
    }
    if (!isNullOrEmpty(options.getCacheControl())) {
      builder.cacheControl(options.getCacheControl());
    }
    if (!isNullOrEmpty(options.getContentDisposition())) {
      builder.contentDisposition(options.getContentDisposition());
    }
    if (!isNullOrEmpty(options.getContentEncoding())) {
      builder.contentEncoding(options.getContentEncoding());
    }
    if (!isNullOrEmpty(options.getMimeType())) {
      builder.mimeType(options.getMimeType());
    }
    for (Map.Entry<String, String> entry : options.getUserMetadata().entrySet()) {
      builder.addUserMetadata(entry.getKey(), entry.getValue());
    }
    return builder;
  }

  @SafeVarargs
  static <T> GcsFileOptions buildFileOptions(GcsFileOptions.Builder builder, T... options) {
    for (Object option : options) {
      if (option instanceof OptionAcl) {
        builder.acl(((OptionAcl) option).acl());
      } else if (option instanceof OptionCacheControl) {
        builder.cacheControl(((OptionCacheControl) option).cacheControl());
      } else if (option instanceof OptionContentDisposition) {
        builder.contentDisposition(((OptionContentDisposition) option).contentDisposition());
      } else if (option instanceof OptionContentEncoding) {
        builder.contentEncoding(((OptionContentEncoding) option).contentEncoding());
      } else if (option instanceof OptionMimeType) {
        builder.mimeType(((OptionMimeType) option).mimeType());
      } else if (option instanceof OptionUserMetadata) {
        OptionUserMetadata metadata = (OptionUserMetadata) option;
        builder.addUserMetadata(metadata.key(), metadata.value());
      }
    }
    return builder.build();
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

  /** Makes NullPointerTester happy. */
  @SafeVarargs
  static <T> void checkNotNullArray(T... values) {
    for (T value : values) {
      checkNotNull(value);
    }
  }

  static boolean getPropertyBoolean(String property, boolean defaultValue) {
    String value = System.getProperty(property);
    return value != null ? Boolean.valueOf(value) : defaultValue;
  }

  private CloudStorageUtil() {}
}
