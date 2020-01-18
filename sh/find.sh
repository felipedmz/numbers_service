# 2. Find all perfect numbers between a range (start-end)

echo "\n"
curl -X POST \
    -H "Content-Type: application/json" \
    -d '{"start": 8, "end": 25}' \
    http://localhost:8080/find
echo "\n"
curl -X POST \
    -H "Content-Type: application/json" \
    -d '{"start": 3, "end": 7}' \
    http://localhost:8080/find
echo "\n"
curl -X POST \
    -H "Content-Type: application/json" \
    -d '{"start": 0, "end": 500}' \
    http://localhost:8080/find
echo "\n"