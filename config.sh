mvn clean install -Dskiptests
IF ERRORLEVEL 1 EXIT
docker build -t joinfut/backend .
docker tag joinfut/backend f4nt0/joinfut
docker push f4nt0/joinfut