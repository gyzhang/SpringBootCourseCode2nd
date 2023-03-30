kubectl delete -n sbc2nd deployment hello-docker-express
kubectl delete -n sbc2nd deployment hello-docker-console
kubectl delete -n sbc2nd deployment hello-docker-order
kubectl delete -n sbc2nd deployment mysql
kubectl delete -n sbc2nd deployment redis
kubectl delete -n sbc2nd deployment rabbitmq
kubectl delete -n sbc2nd service hello-docker-express
kubectl delete -n sbc2nd service hello-docker-console
kubectl delete -n sbc2nd service hello-docker-order
kubectl delete -n sbc2nd service mysql
kubectl delete -n sbc2nd service redis
kubectl delete -n sbc2nd service rabbitmq
kubectl delete -n sbc2nd configmap mysql-init-sql
kubectl delete -n sbc2nd configmap nginx-config
kubectl delete namespace sbc2nd
kubectl create namespace sbc2nd
kubectl apply -f ./k8s/k8s-rabbitmq.yaml
kubectl apply -f ./k8s/k8s-redis.yaml
kubectl apply -f ./k8s/k8s-mysql.yaml
kubectl apply -f ./k8s/k8s-app-order-service.yaml
kubectl apply -f ./k8s/k8s-app-order-console.yaml
kubectl apply -f ./k8s/k8s-app-express.yaml
