mvn clean install -Dskiptests
IF ERRORLEVEL 1 EXIT
sudo docker login
sudo docker build -t joinfut/backend .
sudo docker tag joinfut/backend f4nt0/joinfut
sudo docker push f4nt0/joinfut