#!/bin/bash
# start-proxy.sh

set -e

echo "Starting Squid proxy..."
# Run squid in background. 
# On Debian, /usr/sbin/squid is the binary.
# -s sends errors to syslog. -Y during rebuild. -C do not catch fatal signals.
/usr/sbin/squid -sYC

# Wait for squid to be ready and listen on 3128
echo "Waiting for Squid to listen on port 3128..."
timeout=30
while ! curl -s -I -x http://127.0.0.1:3128 https://www.google.com >/dev/null; do
    sleep 1
    timeout=$((timeout - 1))
    if [ $timeout -le 0 ]; then
        echo "Squid failed to start or cannot access the internet."
        exit 1
    fi
done
echo "Squid is ready and working."

# Configure iptables to restrict network access
echo "Configuring iptables rules..."

# 1. Allow loopback traffic
iptables -A OUTPUT -o lo -j ACCEPT

# 2. Allow squid user (proxy) to access the network
iptables -A OUTPUT -m owner --uid-owner proxy -j ACCEPT

# 3. Allow DNS (port 53) for everyone
iptables -A OUTPUT -p udp --dport 53 -j ACCEPT
iptables -A OUTPUT -p tcp --dport 53 -j ACCEPT

# 4. Allow outgoing traffic to port 3128 (proxies) for testing external proxies
iptables -A OUTPUT -p tcp --dport 3128 -j ACCEPT

# 4.5 Allow raw access to Maven Central (repo.maven.apache.org) for dynamic dependency downloads
echo "Resolving repo.maven.apache.org and allowing raw access..."
for ip in $(getent ahosts repo.maven.apache.org | awk '{print $1}' | sort -u); do
    if [[ $ip =~ ^[0-9]+\.[0-9]+\.[0-9]+\.[0-9]+$ ]]; then
        echo "Allowing outbound to $ip"
        iptables -A OUTPUT -d "$ip" -p tcp --dport 443 -j ACCEPT
        iptables -A OUTPUT -d "$ip" -p tcp --dport 80 -j ACCEPT
    fi
done

# 5. Reject all other outgoing TCP/UDP traffic
iptables -A OUTPUT -p tcp -j REJECT --reject-with tcp-reset
iptables -A OUTPUT -p udp -j REJECT

echo "Raw network access is now disabled. All traffic must go through the proxy."

# Execute the main command
exec "$@"
