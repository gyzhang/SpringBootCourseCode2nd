kubectl create namespace sbc2nd
kubectl apply -f ./k8s/k8s-rabbitmq.yaml
kubectl apply -f ./k8s/k8s-redis.yaml
kubectl apply -f ./k8s/k8s-mysql.yaml
kubectl apply -f ./k8s/k8s-app-order-service.yaml
kubectl apply -f ./k8s/k8s-app-order-console.yaml
kubectl apply -f ./k8s/k8s-app-express.yaml
