#!/bin/sh

echo "Supervisor started. Monitoring example-send..."

while docker ps | grep example-send >/dev/null; do
  sleep 5
done

echo "example-send exited. Waiting 2 minutes before shutdown..."
sleep 120

echo "Gracefully shutting down all services..."
docker compose down
