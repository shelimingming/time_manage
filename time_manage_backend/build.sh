mvn clean package -Dmaven.test.skip=true
docker build -t time_manage_backend:1.0 .
sudo docker tag time_manage_backend:1.0 registry.cn-qingdao.aliyuncs.com/time_manage/time_manage_backend:1.0-SNAPSHOT
sudo docker push registry.cn-qingdao.aliyuncs.com/time_manage/time_manage_backend:1.0-SNAPSHOT