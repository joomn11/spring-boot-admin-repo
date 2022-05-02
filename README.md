# spring-boot-admin-repo

**spring boot admin 환경을 구성하기 위한 Server, Client sample code** </br>
크게 legacy 환경 (Server, Client), k8s 환경 (Server, Client), k8s 리소스(service, deployment)로 구성되어있다 </br>

</br>

## 목차

- [legacy 환경 Server, Client](#legacy-환경-server-client)
- [k8s 환경 Server, Client](#k8s-환경-server-client)
- [k8s 리소스 (service, deployment..)]

---

## legacy 환경 Server-Client

> On-premise 환경에서의 프로젝트 구성

- 해당 프로젝트 정보
  - sba-server
  - sba-client

### architecture

<img src = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbCBBRg%2Fbtq7AaJj1Ki%2FCCzXYCjWekatXyOPWkkj10%2Fimg.png" width="60%" height="60%">

</br>

[Spring Boot Admin 사용해보기](https://joomn11.tistory.com/68)

</br>

## k8s 환경 Server-Client

> Kubernetes 환경에서의 프로젝트 구성

- 해당 프로젝트 정보
  - sba-k8s-server
  - sba-k8s-client

### architecture

<img src = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FXjL3M%2Fbtq7Q9iWvF4%2FyipHzba1nLuDxALIkFcgl0%2Fimg.png" width="60%" height="60%">

</br>

[Spring Boot Admin Kubernetes 환경에서 사용해보기](https://joomn11.tistory.com/71)

</br>

## k8s 리소스 (service, deployment..)

> Kubernetes 환경에서의 프로젝트 이외의 리소스 정보들

- k8s
  - 0_init (초기 설정 파일들.. Role, ServiceAccount, RoleBinding )
  - 1_admin (server 관련 파일들.. deployment, service, db)
  - 2_client (client 관련 파일들.. deployment, service )

</br>

> k8s server, client image만 준비되어 있다면, 바로 사용 가능하다.

> 각 deployment 파일에 spec.template.spec.containers[0].image 정보 update
