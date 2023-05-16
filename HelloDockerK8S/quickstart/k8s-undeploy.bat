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
kubectl delete -n sbc2nd ingress hello-docker-console
kubectl delete -n sbc2nd configmap mysql-init-sql
kubectl delete -n sbc2nd configmap nginx-config
kubectl delete namespace sbc2nd