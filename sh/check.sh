# 1. Check if a given number is perfect
echo "\n"
curl http://localhost:8080/check/-1
echo "\n"
curl http://localhost:8080/check/0
echo "\n"
curl http://localhost:8080/check/6.1
echo "\n"
curl http://localhost:8080/check/6,2
echo "\n"
curl http://localhost:8080/check/8
echo "\n"
curl http://localhost:8080/check/42
echo "\n"
curl http://localhost:8080/check/6
echo "\n"
curl http://localhost:8080/check/496