# 微服务全家桶Spring Cloud

## 前言
　　Spring Cloud是基于Spring Boot的一整套实现微服务的框架。他提供了微服务开发所需的配置管理、服务发现、断路器、智能路由、微代理、控制总线、全局锁、决策竞选、分布式会话和集群状态管理等组件。最重要的是， 跟spring boot框架一起使用的话，会让你开发微服务架构的云服务非常好的方便。SpringBoot旨在简化创建产品级的 Spring 应用和服务，简化了配置文件，使用嵌入式web服务器，含有诸多开箱即用微服务功能

　　微服务架构是互联网很热门的话题，是互联网技术发展的必然结果。它提倡将单一应用程序划分成一组小的服务，服务之间互相协调、互相配合，为用户提供最终价值。虽然微服务架构没有公认的技术标准和规范或者草案，但业界已经有一些很有影响力的开源微服务架构框架提供了微服务的关键思路，例如 dubbo 和 Spring Cloud，各大互联网公司也有自研的微服务框架，但其模式都于这二者相差不大。

## 特性
**Spring Cloud子项目包括。**

* Spring Cloud Config：配置管理开发工具包，可以让你把配置放到远程服务器，目前支持本地存储、Git以及Subversion。

* Spring Cloud Bus：事件、消息总线，用于在集群（例如，配置变化事件）中传播状态变化，可与Spring Cloud Config联合实现热部署。

* Spring Cloud Netflix：针对多种Netflix组件提供的开发工具包，其中包括Eureka、Hystrix、Zuul、Archaius等。

* Netflix Eureka：云端负载均衡，一个基于 REST 的服务，用于定位服务，以实现云端的负载均衡和中间层服务器的故障转移。

* Netflix Hystrix：容错管理工具，旨在通过控制服务和第三方库的节点,从而对延迟和故障提供更强大的容错能力。

* Netflix Zuul：边缘服务工具，是提供动态路由，监控，弹性，安全等的边缘服务。

* Netflix Archaius：配置管理API，包含一系列配置管理API，提供动态类型化属性、线程安全配置操作、轮询框架、回调机制等功能。

* Spring Cloud for Cloud Foundry：通过Oauth2协议绑定服务到CloudFoundry，CloudFoundry是VMware推出的开源PaaS云平台。

* Spring Cloud Sleuth：日志收集工具包，封装了Dapper,Zipkin和HTrace操作。

* Spring Cloud Data Flow：大数据操作工具，通过命令行方式操作数据流。

* Spring Cloud Security：安全工具包，为你的应用程序添加安全控制，主要是指OAuth2。

* Spring Cloud Consul：封装了Consul操作，consul是一个服务发现与配置工具，与Docker容器可以无缝集成。

* Spring Cloud Zookeeper：操作Zookeeper的工具包，用于使用zookeeper方式的服务注册和发现。

* Spring Cloud Stream：数据流操作开发包，封装了与Redis,Rabbit、Kafka等发送接收消息。

* Spring Cloud CLI：基于 Spring Boot CLI，可以让你以命令行方式快速建立云组件。

#### 微服务主要的优势如下:

1.降低复杂度

　　将原来偶合在一起的复杂业务拆分为单个服务，规避了原本复杂度无止境的积累。每一个微服务专注于单一功能，并通过定义良好的接口清晰表述服务边界。每个服务开发者只专注服务本身，通过使用缓存、DAL 等各种技术手段来提升系统的性能，而对于消费方来说完全透明。

2.可独立部署

　　由于微服务具备独立的运行进程，所以每个微服务可以独立部署。当业务迭代时只需要发布相关服务的迭代即可，降低了测试的工作量同时也降低了服务发布的风险。

3.容错

　　在微服务架构下，当某一组件发生故障时，故障会被隔离在单个服务中。 通过限流、熔断等方式降低错误导致的危害，保障核心业务正常运行。

4.扩展

　　单块架构应用也可以实现横向扩展，就是将整个应用完整的复制到不同的节点。当应用的不同组件在扩展需求上存在差异时，微服务架构便体现出其灵活性，因为每个服务可以根据实际需求独立进行扩展。


## 1 核心部件

　　微服务的核心要素在于服务的发现、注册、路由、熔断、降级、分布式配置，基于上述几种必要条件对 dubbo 和 Spring Cloud 做出对比。

## 2 总体架构

**Spring Cloud 总体架构**

- `Service Provider`:暴露服务的提供方；
- `Service Consumer`:调用远程服务的服务消费方；
- `Eureka Server`:服务注册中心和服务发现中心。

##  4 通讯协议

Spring Cloud 使用HTTP协议的REST API.

## 5 组件运行流程

Spring Cloud
- 所有请求都统一通过 API 网关（Zuul）来访问内部服务；
- 网关接收到请求后，从注册中心（Eureka）获取可用服务；
- 由 Ribbon 进行均衡负载后，分发到后端的具体实例；
- 微服务之间通过 Feign 进行通信处理业务。
