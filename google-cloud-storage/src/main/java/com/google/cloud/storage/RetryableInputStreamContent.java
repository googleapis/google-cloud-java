package com.google.cloud.storage;

import com.google.api.client.http.AbstractInputStreamContent;
import sun.nio.ch.IOUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class RetryableInputStreamContent extends AbstractInputStreamContent {

    private final RestartableInputStream restartableInputStream;
    private boolean retrySupported = true;

    public RetryableInputStreamContent(String type, RestartableInputStream restartableInputStream) {
        super(type);
        this.restartableInputStream = restartableInputStream;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return restartableInputStream.getInputStream();
    }

    @Override
    public long getLength() {
        return this.length;
    }

    @Override
    public boolean retrySupported() {
        return this.retrySupported;
    }

    public RetryableInputStreamContent setCloseInputStream(boolean closeInputStream) {
        super.setCloseInputStream(closeInputStream);
        return this;
    }

    public RetryableInputStreamContent setRetrySupported(boolean retrySupported) {
        this.retrySupported = retrySupported;
        return this;
    }

    public RetryableInputStreamContent setLength(long length) {
        this.length = length;
        return this;
    }
}
