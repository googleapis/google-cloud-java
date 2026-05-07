/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner.omni;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.AccessToken;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.io.IOException;
import java.util.Date;
import java.util.Base64;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.crypto.tink.util.SecretBytes;

/**
 * Credentials implementation for Spanner Omni. Uses the OPAQUE protocol to
 * authenticate and fetches short-lived access tokens. Supports optional
 * background auto-refreshing before token expiry.
 */
public class SpannerOmniCredentials extends GoogleCredentials {
    private static final Logger logger = Logger.getLogger(SpannerOmniCredentials.class.getName());
    
    private static final ScheduledExecutorService SHARED_EXECUTOR = Executors.newScheduledThreadPool(1, r -> {
        Thread t = new Thread(r, "spanner-omni-refresh");
        t.setDaemon(true);
        return t;
    });
    
    private final String username;
    private final SecretBytes password;
    private final String target;
    private final boolean backgroundRefresh;
    private final ManagedChannel loginChannel;

    private ScheduledFuture<?> refreshTask;

    public SpannerOmniCredentials(String username, SecretBytes password, String target) {
        this(username, password, target, true);
    }

    public SpannerOmniCredentials(String username, SecretBytes password, String target, boolean backgroundRefresh) {
        this.username = username;
        this.password = password;
        this.target = target;
        this.backgroundRefresh = backgroundRefresh;
        this.loginChannel = ManagedChannelBuilder.forTarget(target).build();
    }

    @Override
    public AccessToken refreshAccessToken() throws IOException {
        try {
            LoginClient loginClient = new LoginClient(this.loginChannel);
            google.spanner.omni.v1.AccessToken protoToken = loginClient.login(username, password);
            String tokenValue = Base64.getEncoder().encodeToString(protoToken.toByteArray());
            
            long createTimeMillis = protoToken.getCreationTime().getSeconds() * 1000 +
                                        protoToken.getCreationTime().getNanos() / 1000000;
            long expireTimeMillis = protoToken.getExpirationTime().getSeconds() * 1000 +
                                        protoToken.getExpirationTime().getNanos() / 1000000;
            
            long tokenLifetimeMillis = expireTimeMillis - createTimeMillis;
            if (tokenLifetimeMillis <= 0) {
                tokenLifetimeMillis = TimeUnit.MINUTES.toMillis(60);
            }
            
            AccessToken newAccessToken = new AccessToken(tokenValue, new Date(System.currentTimeMillis() + tokenLifetimeMillis));
            
            if (backgroundRefresh && !SHARED_EXECUTOR.isShutdown()) {
                scheduleRefresh(tokenLifetimeMillis);
            }
            
            return newAccessToken;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to login to Spanner Omni. Username: " + username + ", Target: " + target, e);
            throw new IOException("Failed to login to Spanner Omni", e);
        }
    }

    private void scheduleRefresh(long tokenLifetimeMillis) {
        if (refreshTask != null && !refreshTask.isDone()) {
            refreshTask.cancel(false);
        }
        
        long delayMillis;
        if (tokenLifetimeMillis <= TimeUnit.MINUTES.toMillis(5)) {
            // For very short-lived tokens (e.g. 15s), refresh at half their lifetime
            delayMillis = tokenLifetimeMillis / 2;
        } else {
            // For long-lived tokens, refresh 5 minutes before expiry
            delayMillis = tokenLifetimeMillis - TimeUnit.MINUTES.toMillis(5);
        }
        
        if (delayMillis < 0) {
            delayMillis = 0;
        }
        
        java.lang.ref.WeakReference<SpannerOmniCredentials> weakThis = new java.lang.ref.WeakReference<>(this);
        
        Runnable refreshAction = new Runnable() {
            @Override
            public void run() {
                SpannerOmniCredentials creds = weakThis.get();
                if (creds == null) {
                    // The credentials instance was garbage collected. Stop the background refresh loop.
                    return;
                }
                try {
                    creds.refresh();
                } catch (IOException e) {
                    logger.log(Level.WARNING, "Failed to auto-refresh Spanner Omni credentials", e);
                    // Retry in a short interval on failure
                    long retryDelay = Math.min(TimeUnit.SECONDS.toMillis(5), tokenLifetimeMillis / 4);
                    if (retryDelay <= 0) retryDelay = 1000;
                    creds.refreshTask = SHARED_EXECUTOR.schedule(this, retryDelay, TimeUnit.MILLISECONDS);
                }
            }
        };
        
        refreshTask = SHARED_EXECUTOR.schedule(refreshAction, delayMillis, TimeUnit.MILLISECONDS);
    }
}
