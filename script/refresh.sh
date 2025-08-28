#!/bin/bash

# URL endpoint refresh pool
URL="http://localhost:8085/api/poll/refresh"

echo "Triggering HikariCP pool refresh..."
RESPONSE=$(curl -s -w "%{http_code}" -o /tmp/response.txt $URL)

HTTP_CODE=$(tail -n1 <<< "$RESPONSE")
BODY=$(cat /tmp/response.txt)

if [ "$HTTP_CODE" == "200" ]; then
  echo "Success: $BODY"
else
  echo "Failed (HTTP $HTTP_CODE): $BODY"
fi

# clean up
rm /tmp/response.txt

