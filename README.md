Alibaba Dubbo OSGi Demo
=======================

这是一个在OSGi容器里运行dubbo的demo。Dubbo：https://github.com/alibaba/dubbo。

我所测试的OSGi容器是eclipse virgo-tomcat-server-3.5.0.RELEASE。

### 部署步骤：

1. 生成OSGi描述信息。Dubbo目前还没有OSGi所需要的描述信息，我创建了http://code.alibabatech.com/jira/browse/DUBBO-615，并上传了相应的diff。大家需要下载dubbo源代码后应用这个diff，并重新运行 mvn clean install 命令。

2. 下载dubbo-osgi-demo的源代码。进入dubbo-osgi-demo目录，运行 mvn clean package。

3. 将 assembly/target/dubbo 目录下的所有jar复制到virgo/repository/usr目录。

4. 启动zookeeper服务，默认 127.0.0.1:2181。如果不是需要修改services和consumer里的module-context.xml文件。

5. 启动virgo服务。

6. 先将 services/target/dubbo-demo-services-0.0.1.BUILD-SNAPSHOT.jar 复制到 virgo/pickup 目录。会看virgo的启动终端看到下面的输出：

    [2012-11-16 14:56:26.224] fs-watcher                   <HD0001I> Hot deployer processing 'CREATED' event for file 'dubbo-demo-services-0.0.1.BUILD-SNAPSHOT.jar'.
    [2012-11-16 14:56:26.306] fs-watcher                   <DE0000I> Installing bundle 'dubbo-demo-services' version '0.0.1.BUILD-SNAPSHOT'. 
    [2012-11-16 14:56:26.947] fs-watcher                   <DE0001I> Installed bundle 'dubbo-demo-services' version '0.0.1.BUILD-SNAPSHOT'. 
    [2012-11-16 14:56:26.956] fs-watcher                   <DE0004I> Starting bundle 'dubbo-demo-services' version '0.0.1.BUILD-SNAPSHOT'. 
    [2012-11-16 14:56:28.035] start-signalling-2           <DE0005I> Started bundle 'dubbo-demo-services' version '0.0.1.BUILD-SNAPSHOT'. 

7. 在将consumer/target/dubbo-demo-consumer-0.0.1.BUILD-SNAPSHOT.jar复制到 virgo/pickup 目录，会看到以下输出：

    [2012-11-16 14:58:51.047] fs-watcher                   <HD0001I> Hot deployer processing 'CREATED' event for file 'dubbo-demo-consumer-0.0.1.BUILD-SNAPSHOT.jar'. 
    [2012-11-16 14:58:51.114] fs-watcher                   <DE0000I> Installing bundle 'dubbo-demo-consumer' version '0.0.1.BUILD-SNAPSHOT'. 
    [2012-11-16 14:58:51.231] fs-watcher                   <DE0001I> Installed bundle 'dubbo-demo-consumer' version '0.0.1.BUILD-SNAPSHOT'. 
    [2012-11-16 14:58:51.255] fs-watcher                   <DE0004I> Starting bundle 'dubbo-demo-consumer' version '0.0.1.BUILD-SNAPSHOT'. 
    [2012-11-16 14:58:51.968] start-signalling-1           <DE0005I> Started bundle 'dubbo-demo-consumer' version '0.0.1.BUILD-SNAPSHOT'.

8. 察看 virgo/serviceability/logs/log.log 文件，看到里面有下面的输出表示调用服务成功：

    [2012-11-16 14:58:51.963] INFO  region-dm-14                 System.out                                                        Get Customer [name=1, createTime=Fri Nov 16 14:56:27 CST 2012, version=0, shortName=tech, fullName=TechSupcon] from CustomerService.

### 分布部署：

也可以将services和consumer分别部署在两个virgo服务中，也能够正确调用。

