# Spark Streaming with Apache Kafka – 

**Install Kafka:**

While installing `Kafka`, the following issues might appear when trying to do so on **`Windows`** –  

1. Input line is too long, the syntax of command is incorrect  
(To fix this, change the installation directory of kafka, place it just inside C:\ or D:\)  
2. \Common was unexpected at this time.  
(To fix this, go to environment variable and delete the recently added entry from Classpath,  
it would be something like ;path_to_a_weired_jar)  

I've installed Kafka here:  
`C:\kafka_2.12-3.1.0`  

**points** to be noted:  
1. Create a new `data` folder inside kafka main directory:  
and create 2 subfolders with names `kafka` & `zookeeper` inside `data` folder  
2. make sure, java is installed  
3. we must first start zookeeper before starting kafka servers  

To start zookeeper –  
```C:\kafka_2.12-3.1.0>bin\windows\zookeeper-server-start.bat config\zookeeper.properties```
console logs:  
```
C:\kafka_2.12-3.1.0>bin\windows\zookeeper-server-start.bat config\zookeeper.properties
[2022-03-07 22:36:43,721] INFO Reading configuration from: config\zookeeper.properties (org.apache.zookeeper.server.quorum.QuorumPeerConfig)
[2022-03-07 22:36:43,725] WARN config\zookeeper.properties is relative. Prepend .\ to indicate that you're sure! (org.apache.zookeeper.server.quorum.QuorumPeerConfig)
[2022-03-07 22:36:43,733] WARN C:kafka_2.12-3.1.0datazookeeper is relative. Prepend .\ to indicate that you're sure! (org.apache.zookeeper.server.quorum.QuorumPeerConfig)
[2022-03-07 22:36:43,738] INFO clientPortAddress is 0.0.0.0:2181 (org.apache.zookeeper.server.quorum.QuorumPeerConfig)
[2022-03-07 22:36:43,739] INFO secureClientPort is not set (org.apache.zookeeper.server.quorum.QuorumPeerConfig)
[2022-03-07 22:36:43,739] INFO observerMasterPort is not set (org.apache.zookeeper.server.quorum.QuorumPeerConfig)
[2022-03-07 22:36:43,740] INFO metricsProvider.className is org.apache.zookeeper.metrics.impl.DefaultMetricsProvider (org.apache.zookeeper.server.quorum.QuorumPeerConfig)
[2022-03-07 22:36:43,758] INFO autopurge.snapRetainCount set to 3 (org.apache.zookeeper.server.DatadirCleanupManager)
[2022-03-07 22:36:43,759] INFO autopurge.purgeInterval set to 0 (org.apache.zookeeper.server.DatadirCleanupManager)
[2022-03-07 22:36:43,759] INFO Purge task is not scheduled. (org.apache.zookeeper.server.DatadirCleanupManager)
[2022-03-07 22:36:43,759] WARN Either no config or no quorum defined in config, running in standalone mode (org.apache.zookeeper.server.quorum.QuorumPeerMain)
[2022-03-07 22:36:43,766] INFO Log4j 1.2 jmx support found and enabled. (org.apache.zookeeper.jmx.ManagedUtil)
[2022-03-07 22:36:43,790] INFO Reading configuration from: config\zookeeper.properties (org.apache.zookeeper.server.quorum.QuorumPeerConfig)
[2022-03-07 22:36:43,791] WARN config\zookeeper.properties is relative. Prepend .\ to indicate that you're sure! (org.apache.zookeeper.server.quorum.QuorumPeerConfig)
[2022-03-07 22:36:43,792] WARN C:kafka_2.12-3.1.0datazookeeper is relative. Prepend .\ to indicate that you're sure! (org.apache.zookeeper.server.quorum.QuorumPeerConfig)
[2022-03-07 22:36:43,793] INFO clientPortAddress is 0.0.0.0:2181 (org.apache.zookeeper.server.quorum.QuorumPeerConfig)
[2022-03-07 22:36:43,793] INFO secureClientPort is not set (org.apache.zookeeper.server.quorum.QuorumPeerConfig)
[2022-03-07 22:36:43,794] INFO observerMasterPort is not set (org.apache.zookeeper.server.quorum.QuorumPeerConfig)
[2022-03-07 22:36:43,794] INFO metricsProvider.className is org.apache.zookeeper.metrics.impl.DefaultMetricsProvider (org.apache.zookeeper.server.quorum.QuorumPeerConfig)
[2022-03-07 22:36:43,795] INFO Starting server (org.apache.zookeeper.server.ZooKeeperServerMain)
[2022-03-07 22:36:43,842] INFO ServerMetrics initialized with provider org.apache.zookeeper.metrics.impl.DefaultMetricsProvider@64616ca2 (org.apache.zookeeper.server.ServerMetrics)
[2022-03-07 22:36:43,853] INFO zookeeper.snapshot.trust.empty : false (org.apache.zookeeper.server.persistence.FileTxnSnapLog)
[2022-03-07 22:36:43,960] INFO  (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,961] INFO   ______                  _                                           (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,963] INFO  |___  /                 | |                                          (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,964] INFO     / /    ___     ___   | | __   ___    ___   _ __     ___   _ __    (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,965] INFO    / /    / _ \   / _ \  | |/ /  / _ \  / _ \ | '_ \   / _ \ | '__| (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,965] INFO   / /__  | (_) | | (_) | |   <  |  __/ |  __/ | |_) | |  __/ | |     (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,966] INFO  /_____|  \___/   \___/  |_|\_\  \___|  \___| | .__/   \___| |_| (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,966] INFO                                               | |                      (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,967] INFO                                               |_|                      (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,967] INFO  (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,974] INFO Server environment:zookeeper.version=3.6.3--6401e4ad2087061bc6b9f80dec2d69f2e3c8660a, built on 04/08/2021 16:35 GMT (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,974] INFO Server environment:host.name=USFRKMVDIXA0141.ad.us.mrshmc.com (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,976] INFO Server environment:java.version=1.8.0_201 (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,977] INFO Server environment:java.vendor=Oracle Corporation (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,977] INFO Server environment:java.home=C:\Program Files\Java\jdk1.8.0_201\jre (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,978] INFO Server environment:java.class.path=C:\kafka_2.12-3.1.0\libs\activation-1.1.1.jar;C:\kafka_2.12-3.1.0\libs\aopalliance-repackaged-2.6.1.jar;C:\kafka_2.12-3.1.0\libs\argparse4j-0.7.0.jar;C:\kafka_2.12-3.1.0\libs\audience-annotations-0.5.0.jar;C:\kafka_2.12-3.1.0\libs\commons-cli-1.4.jar;C:\kafka_2.12-3.1.0\libs\commons-lang3-3.8.1.jar;C:\kafka_2.12-3.1.0\libs\connect-api-3.1.0.jar;C:\kafka_2.12-3.1.0\libs\connect-basic-auth-extension-3.1.0.jar;C:\kafka_2.12-3.1.0\libs\connect-file-3.1.0.jar;C:\kafka_2.12-3.1.0\libs\connect-json-3.1.0.jar;C:\kafka_2.12-3.1.0\libs\connect-mirror-3.1.0.jar;C:\kafka_2.12-3.1.0\libs\connect-mirror-client-3.1.0.jar;C:\kafka_2.12-3.1.0\libs\connect-runtime-3.1.0.jar;C:\kafka_2.12-3.1.0\libs\connect-transforms-3.1.0.jar;C:\kafka_2.12-3.1.0\libs\hk2-api-2.6.1.jar;C:\kafka_2.12-3.1.0\libs\hk2-locator-2.6.1.jar;C:\kafka_2.12-3.1.0\libs\hk2-utils-2.6.1.jar;C:\kafka_2.12-3.1.0\libs\jackson-annotations-2.12.3.jar;C:\kafka_2.12-3.1.0\libs\jackson-core-2.12.3.jar;C:\kafka_2.12-3.1.0\libs\jackson-databind-2.12.3.jar;C:\kafka_2.12-3.1.0\libs\jackson-dataformat-csv-2.12.3.jar;C:\kafka_2.12-3.1.0\libs\jackson-datatype-jdk8-2.12.3.jar;C:\kafka_2.12-3.1.0\libs\jackson-jaxrs-base-2.12.3.jar;C:\kafka_2.12-3.1.0\libs\jackson-jaxrs-json-provider-2.12.3.jar;C:\kafka_2.12-3.1.0\libs\jackson-module-jaxb-annotations-2.12.3.jar;C:\kafka_2.12-3.1.0\libs\jackson-module-scala_2.12-2.12.3.jar;C:\kafka_2.12-3.1.0\libs\jakarta.activation-api-1.2.1.jar;C:\kafka_2.12-3.1.0\libs\jakarta.annotation-api-1.3.5.jar;C:\kafka_2.12-3.1.0\libs\jakarta.inject-2.6.1.jar;C:\kafka_2.12-3.1.0\libs\jakarta.validation-api-2.0.2.jar;C:\kafka_2.12-3.1.0\libs\jakarta.ws.rs-api-2.1.6.jar;C:\kafka_2.12-3.1.0\libs\jakarta.xml.bind-api-2.3.2.jar;C:\kafka_2.12-3.1.0\libs\javassist-3.27.0-GA.jar;C:\kafka_2.12-3.1.0\libs\javax.servlet-api-3.1.0.jar;C:\kafka_2.12-3.1.0\libs\javax.ws.rs-api-2.1.1.jar;C:\kafka_2.12-3.1.0\libs\jaxb-api-2.3.0.jar;C:\kafka_2.12-3.1.0\libs\jersey-client-2.34.jar;C:\kafka_2.12-3.1.0\libs\jersey-common-2.34.jar;C:\kafka_2.12-3.1.0\libs\jersey-container-servlet-2.34.jar;C:\kafka_2.12-3.1.0\libs\jersey-container-servlet-core-2.34.jar;C:\kafka_2.12-3.1.0\libs\jersey-hk2-2.34.jar;C:\kafka_2.12-3.1.0\libs\jersey-server-2.34.jar;C:\kafka_2.12-3.1.0\libs\jetty-client-9.4.43.v20210629.jar;C:\kafka_2.12-3.1.0\libs\jetty-continuation-9.4.43.v20210629.jar;C:\kafka_2.12-3.1.0\libs\jetty-http-9.4.43.v20210629.jar;C:\kafka_2.12-3.1.0\libs\jetty-io-9.4.43.v20210629.jar;C:\kafka_2.12-3.1.0\libs\jetty-security-9.4.43.v20210629.jar;C:\kafka_2.12-3.1.0\libs\jetty-server-9.4.43.v20210629.jar;C:\kafka_2.12-3.1.0\libs\jetty-servlet-9.4.43.v20210629.jar;C:\kafka_2.12-3.1.0\libs\jetty-servlets-9.4.43.v20210629.jar;C:\kafka_2.12-3.1.0\libs\jetty-util-9.4.43.v20210629.jar;C:\kafka_2.12-3.1.0\libs\jetty-util-ajax-9.4.43.v20210629.jar;C:\kafka_2.12-3.1.0\libs\jline-3.12.1.jar;C:\kafka_2.12-3.1.0\libs\jopt-simple-5.0.4.jar;C:\kafka_2.12-3.1.0\libs\jose4j-0.7.8.jar;C:\kafka_2.12-3.1.0\libs\kafka-clients-3.1.0.jar;C:\kafka_2.12-3.1.0\libs\kafka-log4j-appender-3.1.0.jar;C:\kafka_2.12-3.1.0\libs\kafka-metadata-3.1.0.jar;C:\kafka_2.12-3.1.0\libs\kafka-raft-3.1.0.jar;C:\kafka_2.12-3.1.0\libs\kafka-server-common-3.1.0.jar;C:\kafka_2.12-3.1.0\libs\kafka-shell-3.1.0.jar;C:\kafka_2.12-3.1.0\libs\kafka-storage-3.1.0.jar;C:\kafka_2.12-3.1.0\libs\kafka-storage-api-3.1.0.jar;C:\kafka_2.12-3.1.0\libs\kafka-streams-3.1.0.jar;C:\kafka_2.12-3.1.0\libs\kafka-streams-examples-3.1.0.jar;C:\kafka_2.12-3.1.0\libs\kafka-streams-scala_2.12-3.1.0.jar;C:\kafka_2.12-3.1.0\libs\kafka-streams-test-utils-3.1.0.jar;C:\kafka_2.12-3.1.0\libs\kafka-tools-3.1.0.jar;C:\kafka_2.12-3.1.0\libs\kafka_2.12-3.1.0.jar;C:\kafka_2.12-3.1.0\libs\log4j-1.2.17.jar;C:\kafka_2.12-3.1.0\libs\lz4-java-1.8.0.jar;C:\kafka_2.12-3.1.0\libs\maven-artifact-3.8.1.jar;C:\kafka_2.12-3.1.0\libs\metrics-core-2.2.0.jar;C:\kafka_2.12-3.1.0\libs\metrics-core-4.1.12.1.jar;C:\kafka_2.12-3.1.0\libs\netty-buffer-4.1.68.Final.jar;C:\kafka_2.12-3.1.0\libs\netty-codec-4.1.68.Final.jar;C:\kafka_2.12-3.1.0\libs\netty-common-4.1.68.Final.jar;C:\kafka_2.12-3.1.0\libs\netty-handler-4.1.68.Final.jar;C:\kafka_2.12-3.1.0\libs\netty-resolver-4.1.68.Final.jar;C:\kafka_2.12-3.1.0\libs\netty-transport-4.1.68.Final.jar;C:\kafka_2.12-3.1.0\libs\netty-transport-native-epoll-4.1.68.Final.jar;C:\kafka_2.12-3.1.0\libs\netty-transport-native-unix-common-4.1.68.Final.jar;C:\kafka_2.12-3.1.0\libs\osgi-resource-locator-1.0.3.jar;C:\kafka_2.12-3.1.0\libs\paranamer-2.8.jar;C:\kafka_2.12-3.1.0\libs\plexus-utils-3.2.1.jar;C:\kafka_2.12-3.1.0\libs\reflections-0.9.12.jar;C:\kafka_2.12-3.1.0\libs\rocksdbjni-6.22.1.1.jar;C:\kafka_2.12-3.1.0\libs\scala-collection-compat_2.12-2.4.4.jar;C:\kafka_2.12-3.1.0\libs\scala-java8-compat_2.12-1.0.0.jar;C:\kafka_2.12-3.1.0\libs\scala-library-2.12.14.jar;C:\kafka_2.12-3.1.0\libs\scala-logging_2.12-3.9.3.jar;C:\kafka_2.12-3.1.0\libs\scala-reflect-2.12.14.jar;C:\kafka_2.12-3.1.0\libs\slf4j-api-1.7.30.jar;C:\kafka_2.12-3.1.0\libs\slf4j-log4j12-1.7.30.jar;C:\kafka_2.12-3.1.0\libs\snappy-java-1.1.8.4.jar;C:\kafka_2.12-3.1.0\libs\trogdor-3.1.0.jar;C:\kafka_2.12-3.1.0\libs\zookeeper-3.6.3.jar;C:\kafka_2.12-3.1.0\libs\zookeeper-jute-3.6.3.jar;C:\kafka_2.12-3.1.0\libs\zstd-jni-1.5.0-4.jar (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,979] INFO Server environment:java.library.path=C:\Program Files\Java\jdk1.8.0_201\bin;C:\WINDOWS\Sun\Java\bin;C:\WINDOWS\system32;C:\WINDOWS;C:\Program Files (x86)\Common Files\Oracle\Java\javapath;C:\Users\U1159927\AppData\Local\Programs\Python\Python310\;C:\Users\U1159927\AppData\Local\Programs\Python\Python310\Scripts\;C:\oracle\product\11.2.0\32Bit_client\bin;C:\windows\system32;C:\windows;C:\windows\System32\Wbem;C:\windows\System32\WindowsPowerShell\v1.0\;C:\windows\System32\OpenSSH\;C:\Program Files\Common Files\ThinPrint\;C:\Users\Administrator\AppData\Local\Microsoft\WindowsApps;C:\Program Files (x86)\Adaptiva\AdaptivaClient\bin\x32;C:\Program Files (x86)\Adaptiva\AdaptivaClient\bin\x64;C:\Program Files (x86)\Common Files\;C:\Program Files (x86)\Common Files\EMC;C:\Program Files\Java\jdk1.8.0_201\bin;C:\Users\U1159927\Desktop\marsh\tools_hard\maven\apache-maven-3.6.3\bin;C:\Users\U1159927\Desktop\marsh\tools_hard\maven\apache-maven-3.6.3\bin;C:\Program Files\TortoiseGit\bin;C:\Program Files\Git\cmd;C:\Program Files\Amazon\AWSCLI\;C:\Program Files (x86)\Enterprise Vault\EVClient\;C:\Program Files\dotnet\;C:\WINDOWS\system32;C:\WINDOWS;C:\WINDOWS\System32\Wbem;C:\WINDOWS\System32\WindowsPowerShell\v1.0\;C:\WINDOWS\System32\OpenSSH\;C:\Users\U1159927\Desktop\marsh\tools_soft\spark-3.2.1-bin-hadoop2.7\bin;C:\Program Files\WinZip\;C:\Users\U1159927\Desktop\marsh\tools_soft\spark-3.2.1-bin-hadoop2.7\bin;C:\Program Files\PuTTY\;C:\kafka_2.12-3.1.0\bin;;. (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,980] INFO Server environment:java.io.tmpdir=C:\WINDOWS\TEMP\ (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,980] INFO Server environment:java.compiler=<NA> (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,981] INFO Server environment:os.name=Windows 10 (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,981] INFO Server environment:os.arch=amd64 (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,982] INFO Server environment:os.version=10.0 (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,982] INFO Server environment:user.name=U1159927 (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,982] INFO Server environment:user.home=C:\Users\U1159927 (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,983] INFO Server environment:user.dir=C:\kafka_2.12-3.1.0 (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,984] INFO Server environment:os.memory.free=494MB (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,984] INFO Server environment:os.memory.max=512MB (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,985] INFO Server environment:os.memory.total=512MB (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,985] INFO zookeeper.enableEagerACLCheck = false (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,986] INFO zookeeper.digest.enabled = true (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,990] INFO zookeeper.closeSessionTxn.enabled = true (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,991] INFO zookeeper.flushDelay=0 (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,991] INFO zookeeper.maxWriteQueuePollTime=0 (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,993] INFO zookeeper.maxBatchSize=1000 (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,993] INFO zookeeper.intBufferStartingSizeBytes = 1024 (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:43,997] INFO Weighed connection throttling is disabled (org.apache.zookeeper.server.BlueThrottle)
[2022-03-07 22:36:44,008] INFO minSessionTimeout set to 6000 (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:44,009] INFO maxSessionTimeout set to 60000 (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:44,013] INFO Response cache size is initialized with value 400. (org.apache.zookeeper.server.ResponseCache)
[2022-03-07 22:36:44,014] INFO Response cache size is initialized with value 400. (org.apache.zookeeper.server.ResponseCache)
[2022-03-07 22:36:44,019] INFO zookeeper.pathStats.slotCapacity = 60 (org.apache.zookeeper.server.util.RequestPathMetricsCollector)
[2022-03-07 22:36:44,020] INFO zookeeper.pathStats.slotDuration = 15 (org.apache.zookeeper.server.util.RequestPathMetricsCollector)
[2022-03-07 22:36:44,021] INFO zookeeper.pathStats.maxDepth = 6 (org.apache.zookeeper.server.util.RequestPathMetricsCollector)
[2022-03-07 22:36:44,021] INFO zookeeper.pathStats.initialDelay = 5 (org.apache.zookeeper.server.util.RequestPathMetricsCollector)
[2022-03-07 22:36:44,022] INFO zookeeper.pathStats.delay = 5 (org.apache.zookeeper.server.util.RequestPathMetricsCollector)
[2022-03-07 22:36:44,022] INFO zookeeper.pathStats.enabled = false (org.apache.zookeeper.server.util.RequestPathMetricsCollector)
[2022-03-07 22:36:44,026] INFO The max bytes for all large requests are set to 104857600 (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:44,027] INFO The large request threshold is set to -1 (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:44,028] INFO Created server with tickTime 3000 minSessionTimeout 6000 maxSessionTimeout 60000 clientPortListenBacklog -1 datadir C:kafka_2.12-3.1.0datazookeeper\version-2 snapdir C:kafka_2.12-3.1.0datazookeeper\version-2 (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:44,058] INFO Using org.apache.zookeeper.server.NIOServerCnxnFactory as server connection factory (org.apache.zookeeper.server.ServerCnxnFactory)
[2022-03-07 22:36:44,060] WARN maxCnxns is not configured, using default value 0. (org.apache.zookeeper.server.ServerCnxnFactory)
[2022-03-07 22:36:44,095] INFO Configuring NIO connection handler with 10s sessionless connection timeout, 1 selector thread(s), 4 worker threads, and 64 kB direct buffers. (org.apache.zookeeper.server.NIOServerCnxnFactory)
[2022-03-07 22:36:44,109] INFO binding to port 0.0.0.0/0.0.0.0:2181 (org.apache.zookeeper.server.NIOServerCnxnFactory)
[2022-03-07 22:36:44,164] INFO Using org.apache.zookeeper.server.watch.WatchManager as watch manager (org.apache.zookeeper.server.watch.WatchManagerFactory)
[2022-03-07 22:36:44,164] INFO Using org.apache.zookeeper.server.watch.WatchManager as watch manager (org.apache.zookeeper.server.watch.WatchManagerFactory)
[2022-03-07 22:36:44,166] INFO zookeeper.snapshotSizeFactor = 0.33 (org.apache.zookeeper.server.ZKDatabase)
[2022-03-07 22:36:44,168] INFO zookeeper.commitLogCount=500 (org.apache.zookeeper.server.ZKDatabase)
[2022-03-07 22:36:44,179] INFO zookeeper.snapshot.compression.method = CHECKED (org.apache.zookeeper.server.persistence.SnapStream)
[2022-03-07 22:36:44,179] INFO Snapshotting: 0x0 to C:kafka_2.12-3.1.0datazookeeper\version-2\snapshot.0 (org.apache.zookeeper.server.persistence.FileTxnSnapLog)
[2022-03-07 22:36:44,194] INFO Snapshot loaded in 24 ms, highest zxid is 0x0, digest is 1371985504 (org.apache.zookeeper.server.ZKDatabase)
[2022-03-07 22:36:44,194] INFO Snapshotting: 0x0 to C:kafka_2.12-3.1.0datazookeeper\version-2\snapshot.0 (org.apache.zookeeper.server.persistence.FileTxnSnapLog)
[2022-03-07 22:36:44,196] INFO Snapshot taken in 2 ms (org.apache.zookeeper.server.ZooKeeperServer)
[2022-03-07 22:36:44,248] INFO zookeeper.request_throttler.shutdownTimeout = 10000 (org.apache.zookeeper.server.RequestThrottler)
[2022-03-07 22:36:44,252] INFO PrepRequestProcessor (sid:0) started, reconfigEnabled=false (org.apache.zookeeper.server.PrepRequestProcessor)
[2022-03-07 22:36:44,275] INFO Using checkIntervalMs=60000 maxPerMinute=10000 maxNeverUsedIntervalMs=0 (org.apache.zookeeper.server.ContainerManager)
[2022-03-07 22:36:44,278] INFO ZooKeeper audit is disabled. (org.apache.zookeeper.audit.ZKAuditProvider)
```

Launch Kafka server:  

```
Microsoft Windows [Version 10.0.19042.1466]
(c) Microsoft Corporation. All rights reserved.

C:\Users\U1159927>cd c:\kafka_2.12-3.1.0

c:\kafka_2.12-3.1.0>bin\windows\kafka-server-start.bat config\server.properties
[2022-03-07 22:52:22,610] INFO Registered kafka:type=kafka.Log4jController MBean (kafka.utils.Log4jControllerRegistration$)
[2022-03-07 22:52:24,368] INFO Setting -D jdk.tls.rejectClientInitiatedRenegotiation=true to disable client-initiated TLS renegotiation (org.apache.zookeeper.common.X509Util)
[2022-03-07 22:52:52,665] INFO starting (kafka.server.KafkaServer)
[2022-03-07 22:52:52,667] INFO Connecting to zookeeper on localhost:2181 (kafka.server.KafkaServer)
[2022-03-07 22:52:52,738] INFO [ZooKeeperClient Kafka server] Initializing a new session to localhost:2181. (kafka.zookeeper.ZooKeeperClient)
[2022-03-07 22:52:52,749] INFO Client environment:zookeeper.version=3.6.3--6401e4ad2087061bc6b9f80dec2d69f2e3c8660a, built on 04/08/2021 16:35 GMT (org.apache.zookeeper.ZooKeeper)
[2022-03-07 22:52:52,749] INFO Client environment:host.name=USFRKMVDIXA0141.ad.us.mrshmc.com (org.apache.zookeeper.ZooKeeper)
[2022-03-07 22:52:52,749] INFO Client environment:java.version=1.8.0_201 (org.apache.zookeeper.ZooKeeper)
[2022-03-07 22:52:52,749] INFO Client environment:java.vendor=Oracle Corporation (org.apache.zookeeper.ZooKeeper)
[2022-03-07 22:52:52,749] INFO Client environment:java.home=C:\Program Files\Java\jdk1.8.0_201\jre (org.apache.zookeeper.ZooKeeper)
[2022-03-07 22:52:52,749] INFO Client environment:java.class.path=c:\kafka_2.12-3.1.0\libs\activation-1.1.1.jar;c:\kafka_2.12-3.1.0\libs\aopalliance-repackaged-2.6.1.jar;c:\kafka_2.12-3.1.0\libs\argparse4j-0.7.0.jar;c:\kafka_2.12-3.1.0\libs\audience-annotations-0.5.0.jar;c:\kafka_2.12-3.1.0\libs\commons-cli-1.4.jar;c:\kafka_2.12-3.1.0\libs\commons-lang3-3.8.1.jar;c:\kafka_2.12-3.1.0\libs\connect-api-3.1.0.jar;c:\kafka_2.12-3.1.0\libs\connect-basic-auth-extension-3.1.0.jar;c:\kafka_2.12-3.1.0\libs\connect-file-3.1.0.jar;c:\kafka_2.12-3.1.0\libs\connect-json-3.1.0.jar;c:\kafka_2.12-3.1.0\libs\connect-mirror-3.1.0.jar;c:\kafka_2.12-3.1.0\libs\connect-mirror-client-3.1.0.jar;c:\kafka_2.12-3.1.0\libs\connect-runtime-3.1.0.jar;c:\kafka_2.12-3.1.0\libs\connect-transforms-3.1.0.jar;c:\kafka_2.12-3.1.0\libs\hk2-api-2.6.1.jar;c:\kafka_2.12-3.1.0\libs\hk2-locator-2.6.1.jar;c:\kafka_2.12-3.1.0\libs\hk2-utils-2.6.1.jar;c:\kafka_2.12-3.1.0\libs\jackson-annotations-2.12.3.jar;c:\kafka_2.12-3.1.0\libs\jackson-core-2.12.3.jar;c:\kafka_2.12-3.1.0\libs\jackson-databind-2.12.3.jar;c:\kafka_2.12-3.1.0\libs\jackson-dataformat-csv-2.12.3.jar;c:\kafka_2.12-3.1.0\libs\jackson-datatype-jdk8-2.12.3.jar;c:\kafka_2.12-3.1.0\libs\jackson-jaxrs-base-2.12.3.jar;c:\kafka_2.12-3.1.0\libs\jackson-jaxrs-json-provider-2.12.3.jar;c:\kafka_2.12-3.1.0\libs\jackson-module-jaxb-annotations-2.12.3.jar;c:\kafka_2.12-3.1.0\libs\jackson-module-scala_2.12-2.12.3.jar;c:\kafka_2.12-3.1.0\libs\jakarta.activation-api-1.2.1.jar;c:\kafka_2.12-3.1.0\libs\jakarta.annotation-api-1.3.5.jar;c:\kafka_2.12-3.1.0\libs\jakarta.inject-2.6.1.jar;c:\kafka_2.12-3.1.0\libs\jakarta.validation-api-2.0.2.jar;c:\kafka_2.12-3.1.0\libs\jakarta.ws.rs-api-2.1.6.jar;c:\kafka_2.12-3.1.0\libs\jakarta.xml.bind-api-2.3.2.jar;c:\kafka_2.12-3.1.0\libs\javassist-3.27.0-GA.jar;c:\kafka_2.12-3.1.0\libs\javax.servlet-api-3.1.0.jar;c:\kafka_2.12-3.1.0\libs\javax.ws.rs-api-2.1.1.jar;c:\kafka_2.12-3.1.0\libs\jaxb-api-2.3.0.jar;c:\kafka_2.12-3.1.0\libs\jersey-client-2.34.jar;c:\kafka_2.12-3.1.0\libs\jersey-common-2.34.jar;c:\kafka_2.12-3.1.0\libs\jersey-container-servlet-2.34.jar;c:\kafka_2.12-3.1.0\libs\jersey-container-servlet-core-2.34.jar;c:\kafka_2.12-3.1.0\libs\jersey-hk2-2.34.jar;c:\kafka_2.12-3.1.0\libs\jersey-server-2.34.jar;c:\kafka_2.12-3.1.0\libs\jetty-client-9.4.43.v20210629.jar;c:\kafka_2.12-3.1.0\libs\jetty-continuation-9.4.43.v20210629.jar;c:\kafka_2.12-3.1.0\libs\jetty-http-9.4.43.v20210629.jar;c:\kafka_2.12-3.1.0\libs\jetty-io-9.4.43.v20210629.jar;c:\kafka_2.12-3.1.0\libs\jetty-security-9.4.43.v20210629.jar;c:\kafka_2.12-3.1.0\libs\jetty-server-9.4.43.v20210629.jar;c:\kafka_2.12-3.1.0\libs\jetty-servlet-9.4.43.v20210629.jar;c:\kafka_2.12-3.1.0\libs\jetty-servlets-9.4.43.v20210629.jar;c:\kafka_2.12-3.1.0\libs\jetty-util-9.4.43.v20210629.jar;c:\kafka_2.12-3.1.0\libs\jetty-util-ajax-9.4.43.v20210629.jar;c:\kafka_2.12-3.1.0\libs\jline-3.12.1.jar;c:\kafka_2.12-3.1.0\libs\jopt-simple-5.0.4.jar;c:\kafka_2.12-3.1.0\libs\jose4j-0.7.8.jar;c:\kafka_2.12-3.1.0\libs\kafka-clients-3.1.0.jar;c:\kafka_2.12-3.1.0\libs\kafka-log4j-appender-3.1.0.jar;c:\kafka_2.12-3.1.0\libs\kafka-metadata-3.1.0.jar;c:\kafka_2.12-3.1.0\libs\kafka-raft-3.1.0.jar;c:\kafka_2.12-3.1.0\libs\kafka-server-common-3.1.0.jar;c:\kafka_2.12-3.1.0\libs\kafka-shell-3.1.0.jar;c:\kafka_2.12-3.1.0\libs\kafka-storage-3.1.0.jar;c:\kafka_2.12-3.1.0\libs\kafka-storage-api-3.1.0.jar;c:\kafka_2.12-3.1.0\libs\kafka-streams-3.1.0.jar;c:\kafka_2.12-3.1.0\libs\kafka-streams-examples-3.1.0.jar;c:\kafka_2.12-3.1.0\libs\kafka-streams-scala_2.12-3.1.0.jar;c:\kafka_2.12-3.1.0\libs\kafka-streams-test-utils-3.1.0.jar;c:\kafka_2.12-3.1.0\libs\kafka-tools-3.1.0.jar;c:\kafka_2.12-3.1.0\libs\kafka_2.12-3.1.0.jar;c:\kafka_2.12-3.1.0\libs\log4j-1.2.17.jar;c:\kafka_2.12-3.1.0\libs\lz4-java-1.8.0.jar;c:\kafka_2.12-3.1.0\libs\maven-artifact-3.8.1.jar;c:\kafka_2.12-3.1.0\libs\metrics-core-2.2.0.jar;c:\kafka_2.12-3.1.0\libs\metrics-core-4.1.12.1.jar;c:\kafka_2.12-3.1.0\libs\netty-buffer-4.1.68.Final.jar;c:\kafka_2.12-3.1.0\libs\netty-codec-4.1.68.Final.jar;c:\kafka_2.12-3.1.0\libs\netty-common-4.1.68.Final.jar;c:\kafka_2.12-3.1.0\libs\netty-handler-4.1.68.Final.jar;c:\kafka_2.12-3.1.0\libs\netty-resolver-4.1.68.Final.jar;c:\kafka_2.12-3.1.0\libs\netty-transport-4.1.68.Final.jar;c:\kafka_2.12-3.1.0\libs\netty-transport-native-epoll-4.1.68.Final.jar;c:\kafka_2.12-3.1.0\libs\netty-transport-native-unix-common-4.1.68.Final.jar;c:\kafka_2.12-3.1.0\libs\osgi-resource-locator-1.0.3.jar;c:\kafka_2.12-3.1.0\libs\paranamer-2.8.jar;c:\kafka_2.12-3.1.0\libs\plexus-utils-3.2.1.jar;c:\kafka_2.12-3.1.0\libs\reflections-0.9.12.jar;c:\kafka_2.12-3.1.0\libs\rocksdbjni-6.22.1.1.jar;c:\kafka_2.12-3.1.0\libs\scala-collection-compat_2.12-2.4.4.jar;c:\kafka_2.12-3.1.0\libs\scala-java8-compat_2.12-1.0.0.jar;c:\kafka_2.12-3.1.0\libs\scala-library-2.12.14.jar;c:\kafka_2.12-3.1.0\libs\scala-logging_2.12-3.9.3.jar;c:\kafka_2.12-3.1.0\libs\scala-reflect-2.12.14.jar;c:\kafka_2.12-3.1.0\libs\slf4j-api-1.7.30.jar;c:\kafka_2.12-3.1.0\libs\slf4j-log4j12-1.7.30.jar;c:\kafka_2.12-3.1.0\libs\snappy-java-1.1.8.4.jar;c:\kafka_2.12-3.1.0\libs\trogdor-3.1.0.jar;c:\kafka_2.12-3.1.0\libs\zookeeper-3.6.3.jar;c:\kafka_2.12-3.1.0\libs\zookeeper-jute-3.6.3.jar;c:\kafka_2.12-3.1.0\libs\zstd-jni-1.5.0-4.jar (org.apache.zookeeper.ZooKeeper)
[2022-03-07 22:52:52,751] INFO Client environment:java.library.path=C:\Program Files\Java\jdk1.8.0_201\bin;C:\WINDOWS\Sun\Java\bin;C:\WINDOWS\system32;C:\WINDOWS;C:\Program Files (x86)\Common Files\Oracle\Java\javapath;C:\Users\U1159927\AppData\Local\Programs\Python\Python310\;C:\Users\U1159927\AppData\Local\Programs\Python\Python310\Scripts\;C:\oracle\product\11.2.0\32Bit_client\bin;C:\windows\system32;C:\windows;C:\windows\System32\Wbem;C:\windows\System32\WindowsPowerShell\v1.0\;C:\windows\System32\OpenSSH\;C:\Program Files\Common Files\ThinPrint\;C:\Users\Administrator\AppData\Local\Microsoft\WindowsApps;C:\Program Files (x86)\Adaptiva\AdaptivaClient\bin\x32;C:\Program Files (x86)\Adaptiva\AdaptivaClient\bin\x64;C:\Program Files (x86)\Common Files\;C:\Program Files (x86)\Common Files\EMC;C:\Program Files\Java\jdk1.8.0_201\bin;C:\Users\U1159927\Desktop\marsh\tools_hard\maven\apache-maven-3.6.3\bin;C:\Users\U1159927\Desktop\marsh\tools_hard\maven\apache-maven-3.6.3\bin;C:\Program Files\TortoiseGit\bin;C:\Program Files\Git\cmd;C:\Program Files\Amazon\AWSCLI\;C:\Program Files (x86)\Enterprise Vault\EVClient\;C:\Program Files\dotnet\;C:\WINDOWS\system32;C:\WINDOWS;C:\WINDOWS\System32\Wbem;C:\WINDOWS\System32\WindowsPowerShell\v1.0\;C:\WINDOWS\System32\OpenSSH\;C:\Users\U1159927\Desktop\marsh\tools_soft\spark-3.2.1-bin-hadoop2.7\bin;C:\Program Files\WinZip\;C:\Users\U1159927\Desktop\marsh\tools_soft\spark-3.2.1-bin-hadoop2.7\bin;C:\Program Files\PuTTY\;C:\kafka_2.12-3.1.0\bin;;. (org.apache.zookeeper.ZooKeeper)
[2022-03-07 22:52:52,752] INFO Client environment:java.io.tmpdir=C:\WINDOWS\TEMP\ (org.apache.zookeeper.ZooKeeper)
[2022-03-07 22:52:52,752] INFO Client environment:java.compiler=<NA> (org.apache.zookeeper.ZooKeeper)
[2022-03-07 22:52:52,753] INFO Client environment:os.name=Windows 10 (org.apache.zookeeper.ZooKeeper)
[2022-03-07 22:52:52,753] INFO Client environment:os.arch=amd64 (org.apache.zookeeper.ZooKeeper)
[2022-03-07 22:52:52,753] INFO Client environment:os.version=10.0 (org.apache.zookeeper.ZooKeeper)
[2022-03-07 22:52:52,754] INFO Client environment:user.name=U1159927 (org.apache.zookeeper.ZooKeeper)
[2022-03-07 22:52:52,754] INFO Client environment:user.home=C:\Users\U1159927 (org.apache.zookeeper.ZooKeeper)
[2022-03-07 22:52:52,755] INFO Client environment:user.dir=c:\kafka_2.12-3.1.0 (org.apache.zookeeper.ZooKeeper)
[2022-03-07 22:52:52,755] INFO Client environment:os.memory.free=1013MB (org.apache.zookeeper.ZooKeeper)
[2022-03-07 22:52:52,756] INFO Client environment:os.memory.max=1024MB (org.apache.zookeeper.ZooKeeper)
[2022-03-07 22:52:52,756] INFO Client environment:os.memory.total=1024MB (org.apache.zookeeper.ZooKeeper)
[2022-03-07 22:52:52,760] INFO Initiating client connection, connectString=localhost:2181 sessionTimeout=18000 watcher=kafka.zookeeper.ZooKeeperClient$ZooKeeperClientWatcher$@235834f2 (org.apache.zookeeper.ZooKeeper)
[2022-03-07 22:52:52,782] INFO jute.maxbuffer value is 4194304 Bytes (org.apache.zookeeper.ClientCnxnSocket)
[2022-03-07 22:52:52,791] INFO zookeeper.request.timeout value is 0. feature enabled=false (org.apache.zookeeper.ClientCnxn)
[2022-03-07 22:52:52,811] INFO [ZooKeeperClient Kafka server] Waiting until connected. (kafka.zookeeper.ZooKeeperClient)
[2022-03-07 22:52:52,833] INFO Opening socket connection to server localhost/127.0.0.1:2181. (org.apache.zookeeper.ClientCnxn)
[2022-03-07 22:52:52,839] INFO SASL config status: Will not attempt to authenticate using SASL (unknown error) (org.apache.zookeeper.ClientCnxn)
[2022-03-07 22:52:52,849] INFO Socket connection established, initiating session, client: /127.0.0.1:53276, server: localhost/127.0.0.1:2181 (org.apache.zookeeper.ClientCnxn)
[2022-03-07 22:52:52,919] INFO Session establishment complete on server localhost/127.0.0.1:2181, session id = 0x1000317e0260000, negotiated timeout = 18000 (org.apache.zookeeper.ClientCnxn)
[2022-03-07 22:52:52,925] INFO [ZooKeeperClient Kafka server] Connected. (kafka.zookeeper.ZooKeeperClient)
[2022-03-07 22:52:53,273] INFO [feature-zk-node-event-process-thread]: Starting (kafka.server.FinalizedFeatureChangeListener$ChangeNotificationProcessorThread)
[2022-03-07 22:52:53,321] INFO Feature ZK node at path: /feature does not exist (kafka.server.FinalizedFeatureChangeListener)
[2022-03-07 22:52:53,324] INFO Cleared cache (kafka.server.FinalizedFeatureCache)
[2022-03-07 22:52:53,700] INFO Cluster ID = yqWmFWCDQ4iw-fSTkBTX1w (kafka.server.KafkaServer)
[2022-03-07 22:52:53,709] WARN No meta.properties file under dir C:\kafka_2.12-3.1.0\kafka_2.12-3.1.0datakafka\meta.properties (kafka.server.BrokerMetadataCheckpoint)
[2022-03-07 22:52:53,903] INFO KafkaConfig values:
        advertised.listeners = null
        alter.config.policy.class.name = null
        alter.log.dirs.replication.quota.window.num = 11
        alter.log.dirs.replication.quota.window.size.seconds = 1
        authorizer.class.name =
        auto.create.topics.enable = true
        auto.leader.rebalance.enable = true
        background.threads = 10
        broker.heartbeat.interval.ms = 2000
        broker.id = 0
        broker.id.generation.enable = true
        broker.rack = null
        broker.session.timeout.ms = 9000
        client.quota.callback.class = null
        compression.type = producer
        connection.failed.authentication.delay.ms = 100
        connections.max.idle.ms = 600000
        connections.max.reauth.ms = 0
        control.plane.listener.name = null
        controlled.shutdown.enable = true
        controlled.shutdown.max.retries = 3
        controlled.shutdown.retry.backoff.ms = 5000
        controller.listener.names = null
        controller.quorum.append.linger.ms = 25
        controller.quorum.election.backoff.max.ms = 1000
        controller.quorum.election.timeout.ms = 1000
        controller.quorum.fetch.timeout.ms = 2000
        controller.quorum.request.timeout.ms = 2000
        controller.quorum.retry.backoff.ms = 20
        controller.quorum.voters = []
        controller.quota.window.num = 11
        controller.quota.window.size.seconds = 1
        controller.socket.timeout.ms = 30000
        create.topic.policy.class.name = null
        default.replication.factor = 1
        delegation.token.expiry.check.interval.ms = 3600000
        delegation.token.expiry.time.ms = 86400000
        delegation.token.master.key = null
        delegation.token.max.lifetime.ms = 604800000
        delegation.token.secret.key = null
        delete.records.purgatory.purge.interval.requests = 1
        delete.topic.enable = true
        fetch.max.bytes = 57671680
        fetch.purgatory.purge.interval.requests = 1000
        group.initial.rebalance.delay.ms = 0
        group.max.session.timeout.ms = 1800000
        group.max.size = 2147483647
        group.min.session.timeout.ms = 6000
        initial.broker.registration.timeout.ms = 60000
        inter.broker.listener.name = null
        inter.broker.protocol.version = 3.1-IV0
        kafka.metrics.polling.interval.secs = 10
        kafka.metrics.reporters = []
        leader.imbalance.check.interval.seconds = 300
        leader.imbalance.per.broker.percentage = 10
        listener.security.protocol.map = PLAINTEXT:PLAINTEXT,SSL:SSL,SASL_PLAINTEXT:SASL_PLAINTEXT,SASL_SSL:SASL_SSL
        listeners = PLAINTEXT://:9092
        log.cleaner.backoff.ms = 15000
        log.cleaner.dedupe.buffer.size = 134217728
        log.cleaner.delete.retention.ms = 86400000
        log.cleaner.enable = true
        log.cleaner.io.buffer.load.factor = 0.9
        log.cleaner.io.buffer.size = 524288
        log.cleaner.io.max.bytes.per.second = 1.7976931348623157E308
        log.cleaner.max.compaction.lag.ms = 9223372036854775807
        log.cleaner.min.cleanable.ratio = 0.5
        log.cleaner.min.compaction.lag.ms = 0
        log.cleaner.threads = 1
        log.cleanup.policy = [delete]
        log.dir = /tmp/kafka-logs
        log.dirs = C:kafka_2.12-3.1.0datakafka
        log.flush.interval.messages = 9223372036854775807
        log.flush.interval.ms = null
        log.flush.offset.checkpoint.interval.ms = 60000
        log.flush.scheduler.interval.ms = 9223372036854775807
        log.flush.start.offset.checkpoint.interval.ms = 60000
        log.index.interval.bytes = 4096
        log.index.size.max.bytes = 10485760
        log.message.downconversion.enable = true
        log.message.format.version = 3.0-IV1
        log.message.timestamp.difference.max.ms = 9223372036854775807
        log.message.timestamp.type = CreateTime
        log.preallocate = false
        log.retention.bytes = -1
        log.retention.check.interval.ms = 300000
        log.retention.hours = 168
        log.retention.minutes = null
        log.retention.ms = null
        log.roll.hours = 168
        log.roll.jitter.hours = 0
        log.roll.jitter.ms = null
        log.roll.ms = null
        log.segment.bytes = 1073741824
        log.segment.delete.delay.ms = 60000
        max.connection.creation.rate = 2147483647
        max.connections = 2147483647
        max.connections.per.ip = 2147483647
        max.connections.per.ip.overrides =
        max.incremental.fetch.session.cache.slots = 1000
        message.max.bytes = 1048588
        metadata.log.dir = null
        metadata.log.max.record.bytes.between.snapshots = 20971520
        metadata.log.segment.bytes = 1073741824
        metadata.log.segment.min.bytes = 8388608
        metadata.log.segment.ms = 604800000
        metadata.max.retention.bytes = -1
        metadata.max.retention.ms = 604800000
        metric.reporters = []
        metrics.num.samples = 2
        metrics.recording.level = INFO
        metrics.sample.window.ms = 30000
        min.insync.replicas = 1
        node.id = 0
        num.io.threads = 8
        num.network.threads = 3
        num.partitions = 1
        num.recovery.threads.per.data.dir = 1
        num.replica.alter.log.dirs.threads = null
        num.replica.fetchers = 1
        offset.metadata.max.bytes = 4096
        offsets.commit.required.acks = -1
        offsets.commit.timeout.ms = 5000
        offsets.load.buffer.size = 5242880
        offsets.retention.check.interval.ms = 600000
        offsets.retention.minutes = 10080
        offsets.topic.compression.codec = 0
        offsets.topic.num.partitions = 50
        offsets.topic.replication.factor = 1
        offsets.topic.segment.bytes = 104857600
        password.encoder.cipher.algorithm = AES/CBC/PKCS5Padding
        password.encoder.iterations = 4096
        password.encoder.key.length = 128
        password.encoder.keyfactory.algorithm = null
        password.encoder.old.secret = null
        password.encoder.secret = null
        principal.builder.class = class org.apache.kafka.common.security.authenticator.DefaultKafkaPrincipalBuilder
        process.roles = []
        producer.purgatory.purge.interval.requests = 1000
        queued.max.request.bytes = -1
        queued.max.requests = 500
        quota.window.num = 11
        quota.window.size.seconds = 1
        remote.log.index.file.cache.total.size.bytes = 1073741824
        remote.log.manager.task.interval.ms = 30000
        remote.log.manager.task.retry.backoff.max.ms = 30000
        remote.log.manager.task.retry.backoff.ms = 500
        remote.log.manager.task.retry.jitter = 0.2
        remote.log.manager.thread.pool.size = 10
        remote.log.metadata.manager.class.name = null
        remote.log.metadata.manager.class.path = null
        remote.log.metadata.manager.impl.prefix = null
        remote.log.metadata.manager.listener.name = null
        remote.log.reader.max.pending.tasks = 100
        remote.log.reader.threads = 10
        remote.log.storage.manager.class.name = null
        remote.log.storage.manager.class.path = null
        remote.log.storage.manager.impl.prefix = null
        remote.log.storage.system.enable = false
        replica.fetch.backoff.ms = 1000
        replica.fetch.max.bytes = 1048576
        replica.fetch.min.bytes = 1
        replica.fetch.response.max.bytes = 10485760
        replica.fetch.wait.max.ms = 500
        replica.high.watermark.checkpoint.interval.ms = 5000
        replica.lag.time.max.ms = 30000
        replica.selector.class = null
        replica.socket.receive.buffer.bytes = 65536
        replica.socket.timeout.ms = 30000
        replication.quota.window.num = 11
        replication.quota.window.size.seconds = 1
        request.timeout.ms = 30000
        reserved.broker.max.id = 1000
        sasl.client.callback.handler.class = null
        sasl.enabled.mechanisms = [GSSAPI]
        sasl.jaas.config = null
        sasl.kerberos.kinit.cmd = /usr/bin/kinit
        sasl.kerberos.min.time.before.relogin = 60000
        sasl.kerberos.principal.to.local.rules = [DEFAULT]
        sasl.kerberos.service.name = null
        sasl.kerberos.ticket.renew.jitter = 0.05
        sasl.kerberos.ticket.renew.window.factor = 0.8
        sasl.login.callback.handler.class = null
        sasl.login.class = null
        sasl.login.connect.timeout.ms = null
        sasl.login.read.timeout.ms = null
        sasl.login.refresh.buffer.seconds = 300
        sasl.login.refresh.min.period.seconds = 60
        sasl.login.refresh.window.factor = 0.8
        sasl.login.refresh.window.jitter = 0.05
        sasl.login.retry.backoff.max.ms = 10000
        sasl.login.retry.backoff.ms = 100
        sasl.mechanism.controller.protocol = GSSAPI
        sasl.mechanism.inter.broker.protocol = GSSAPI
        sasl.oauthbearer.clock.skew.seconds = 30
        sasl.oauthbearer.expected.audience = null
        sasl.oauthbearer.expected.issuer = null
        sasl.oauthbearer.jwks.endpoint.refresh.ms = 3600000
        sasl.oauthbearer.jwks.endpoint.retry.backoff.max.ms = 10000
        sasl.oauthbearer.jwks.endpoint.retry.backoff.ms = 100
        sasl.oauthbearer.jwks.endpoint.url = null
        sasl.oauthbearer.scope.claim.name = scope
        sasl.oauthbearer.sub.claim.name = sub
        sasl.oauthbearer.token.endpoint.url = null
        sasl.server.callback.handler.class = null
        security.inter.broker.protocol = PLAINTEXT
        security.providers = null
        socket.connection.setup.timeout.max.ms = 30000
        socket.connection.setup.timeout.ms = 10000
        socket.receive.buffer.bytes = 102400
        socket.request.max.bytes = 104857600
        socket.send.buffer.bytes = 102400
        ssl.cipher.suites = []
        ssl.client.auth = none
        ssl.enabled.protocols = [TLSv1.2]
        ssl.endpoint.identification.algorithm = https
        ssl.engine.factory.class = null
        ssl.key.password = null
        ssl.keymanager.algorithm = SunX509
        ssl.keystore.certificate.chain = null
        ssl.keystore.key = null
        ssl.keystore.location = null
        ssl.keystore.password = null
        ssl.keystore.type = JKS
        ssl.principal.mapping.rules = DEFAULT
        ssl.protocol = TLSv1.2
        ssl.provider = null
        ssl.secure.random.implementation = null
        ssl.trustmanager.algorithm = PKIX
        ssl.truststore.certificates = null
        ssl.truststore.location = null
        ssl.truststore.password = null
        ssl.truststore.type = JKS
        transaction.abort.timed.out.transaction.cleanup.interval.ms = 10000
        transaction.max.timeout.ms = 900000
        transaction.remove.expired.transaction.cleanup.interval.ms = 3600000
        transaction.state.log.load.buffer.size = 5242880
        transaction.state.log.min.isr = 1
        transaction.state.log.num.partitions = 50
        transaction.state.log.replication.factor = 1
        transaction.state.log.segment.bytes = 104857600
        transactional.id.expiration.ms = 604800000
        unclean.leader.election.enable = false
        zookeeper.clientCnxnSocket = null
        zookeeper.connect = localhost:2181
        zookeeper.connection.timeout.ms = 18000
        zookeeper.max.in.flight.requests = 10
        zookeeper.session.timeout.ms = 18000
        zookeeper.set.acl = false
        zookeeper.ssl.cipher.suites = null
        zookeeper.ssl.client.enable = false
        zookeeper.ssl.crl.enable = false
        zookeeper.ssl.enabled.protocols = null
        zookeeper.ssl.endpoint.identification.algorithm = HTTPS
        zookeeper.ssl.keystore.location = null
        zookeeper.ssl.keystore.password = null
        zookeeper.ssl.keystore.type = null
        zookeeper.ssl.ocsp.enable = false
        zookeeper.ssl.protocol = TLSv1.2
        zookeeper.ssl.truststore.location = null
        zookeeper.ssl.truststore.password = null
        zookeeper.ssl.truststore.type = null
        zookeeper.sync.time.ms = 2000
 (kafka.server.KafkaConfig)
[2022-03-07 22:52:53,933] INFO KafkaConfig values:
        advertised.listeners = null
        alter.config.policy.class.name = null
        alter.log.dirs.replication.quota.window.num = 11
        alter.log.dirs.replication.quota.window.size.seconds = 1
        authorizer.class.name =
        auto.create.topics.enable = true
        auto.leader.rebalance.enable = true
        background.threads = 10
        broker.heartbeat.interval.ms = 2000
        broker.id = 0
        broker.id.generation.enable = true
        broker.rack = null
        broker.session.timeout.ms = 9000
        client.quota.callback.class = null
        compression.type = producer
        connection.failed.authentication.delay.ms = 100
        connections.max.idle.ms = 600000
        connections.max.reauth.ms = 0
        control.plane.listener.name = null
        controlled.shutdown.enable = true
        controlled.shutdown.max.retries = 3
        controlled.shutdown.retry.backoff.ms = 5000
        controller.listener.names = null
        controller.quorum.append.linger.ms = 25
        controller.quorum.election.backoff.max.ms = 1000
        controller.quorum.election.timeout.ms = 1000
        controller.quorum.fetch.timeout.ms = 2000
        controller.quorum.request.timeout.ms = 2000
        controller.quorum.retry.backoff.ms = 20
        controller.quorum.voters = []
        controller.quota.window.num = 11
        controller.quota.window.size.seconds = 1
        controller.socket.timeout.ms = 30000
        create.topic.policy.class.name = null
        default.replication.factor = 1
        delegation.token.expiry.check.interval.ms = 3600000
        delegation.token.expiry.time.ms = 86400000
        delegation.token.master.key = null
        delegation.token.max.lifetime.ms = 604800000
        delegation.token.secret.key = null
        delete.records.purgatory.purge.interval.requests = 1
        delete.topic.enable = true
        fetch.max.bytes = 57671680
        fetch.purgatory.purge.interval.requests = 1000
        group.initial.rebalance.delay.ms = 0
        group.max.session.timeout.ms = 1800000
        group.max.size = 2147483647
        group.min.session.timeout.ms = 6000
        initial.broker.registration.timeout.ms = 60000
        inter.broker.listener.name = null
        inter.broker.protocol.version = 3.1-IV0
        kafka.metrics.polling.interval.secs = 10
        kafka.metrics.reporters = []
        leader.imbalance.check.interval.seconds = 300
        leader.imbalance.per.broker.percentage = 10
        listener.security.protocol.map = PLAINTEXT:PLAINTEXT,SSL:SSL,SASL_PLAINTEXT:SASL_PLAINTEXT,SASL_SSL:SASL_SSL
        listeners = PLAINTEXT://:9092
        log.cleaner.backoff.ms = 15000
        log.cleaner.dedupe.buffer.size = 134217728
        log.cleaner.delete.retention.ms = 86400000
        log.cleaner.enable = true
        log.cleaner.io.buffer.load.factor = 0.9
        log.cleaner.io.buffer.size = 524288
        log.cleaner.io.max.bytes.per.second = 1.7976931348623157E308
        log.cleaner.max.compaction.lag.ms = 9223372036854775807
        log.cleaner.min.cleanable.ratio = 0.5
        log.cleaner.min.compaction.lag.ms = 0
        log.cleaner.threads = 1
        log.cleanup.policy = [delete]
        log.dir = /tmp/kafka-logs
        log.dirs = C:kafka_2.12-3.1.0datakafka
        log.flush.interval.messages = 9223372036854775807
        log.flush.interval.ms = null
        log.flush.offset.checkpoint.interval.ms = 60000
        log.flush.scheduler.interval.ms = 9223372036854775807
        log.flush.start.offset.checkpoint.interval.ms = 60000
        log.index.interval.bytes = 4096
        log.index.size.max.bytes = 10485760
        log.message.downconversion.enable = true
        log.message.format.version = 3.0-IV1
        log.message.timestamp.difference.max.ms = 9223372036854775807
        log.message.timestamp.type = CreateTime
        log.preallocate = false
        log.retention.bytes = -1
        log.retention.check.interval.ms = 300000
        log.retention.hours = 168
        log.retention.minutes = null
        log.retention.ms = null
        log.roll.hours = 168
        log.roll.jitter.hours = 0
        log.roll.jitter.ms = null
        log.roll.ms = null
        log.segment.bytes = 1073741824
        log.segment.delete.delay.ms = 60000
        max.connection.creation.rate = 2147483647
        max.connections = 2147483647
        max.connections.per.ip = 2147483647
        max.connections.per.ip.overrides =
        max.incremental.fetch.session.cache.slots = 1000
        message.max.bytes = 1048588
        metadata.log.dir = null
        metadata.log.max.record.bytes.between.snapshots = 20971520
        metadata.log.segment.bytes = 1073741824
        metadata.log.segment.min.bytes = 8388608
        metadata.log.segment.ms = 604800000
        metadata.max.retention.bytes = -1
        metadata.max.retention.ms = 604800000
        metric.reporters = []
        metrics.num.samples = 2
        metrics.recording.level = INFO
        metrics.sample.window.ms = 30000
        min.insync.replicas = 1
        node.id = 0
        num.io.threads = 8
        num.network.threads = 3
        num.partitions = 1
        num.recovery.threads.per.data.dir = 1
        num.replica.alter.log.dirs.threads = null
        num.replica.fetchers = 1
        offset.metadata.max.bytes = 4096
        offsets.commit.required.acks = -1
        offsets.commit.timeout.ms = 5000
        offsets.load.buffer.size = 5242880
        offsets.retention.check.interval.ms = 600000
        offsets.retention.minutes = 10080
        offsets.topic.compression.codec = 0
        offsets.topic.num.partitions = 50
        offsets.topic.replication.factor = 1
        offsets.topic.segment.bytes = 104857600
        password.encoder.cipher.algorithm = AES/CBC/PKCS5Padding
        password.encoder.iterations = 4096
        password.encoder.key.length = 128
        password.encoder.keyfactory.algorithm = null
        password.encoder.old.secret = null
        password.encoder.secret = null
        principal.builder.class = class org.apache.kafka.common.security.authenticator.DefaultKafkaPrincipalBuilder
        process.roles = []
        producer.purgatory.purge.interval.requests = 1000
        queued.max.request.bytes = -1
        queued.max.requests = 500
        quota.window.num = 11
        quota.window.size.seconds = 1
        remote.log.index.file.cache.total.size.bytes = 1073741824
        remote.log.manager.task.interval.ms = 30000
        remote.log.manager.task.retry.backoff.max.ms = 30000
        remote.log.manager.task.retry.backoff.ms = 500
        remote.log.manager.task.retry.jitter = 0.2
        remote.log.manager.thread.pool.size = 10
        remote.log.metadata.manager.class.name = null
        remote.log.metadata.manager.class.path = null
        remote.log.metadata.manager.impl.prefix = null
        remote.log.metadata.manager.listener.name = null
        remote.log.reader.max.pending.tasks = 100
        remote.log.reader.threads = 10
        remote.log.storage.manager.class.name = null
        remote.log.storage.manager.class.path = null
        remote.log.storage.manager.impl.prefix = null
        remote.log.storage.system.enable = false
        replica.fetch.backoff.ms = 1000
        replica.fetch.max.bytes = 1048576
        replica.fetch.min.bytes = 1
        replica.fetch.response.max.bytes = 10485760
        replica.fetch.wait.max.ms = 500
        replica.high.watermark.checkpoint.interval.ms = 5000
        replica.lag.time.max.ms = 30000
        replica.selector.class = null
        replica.socket.receive.buffer.bytes = 65536
        replica.socket.timeout.ms = 30000
        replication.quota.window.num = 11
        replication.quota.window.size.seconds = 1
        request.timeout.ms = 30000
        reserved.broker.max.id = 1000
        sasl.client.callback.handler.class = null
        sasl.enabled.mechanisms = [GSSAPI]
        sasl.jaas.config = null
        sasl.kerberos.kinit.cmd = /usr/bin/kinit
        sasl.kerberos.min.time.before.relogin = 60000
        sasl.kerberos.principal.to.local.rules = [DEFAULT]
        sasl.kerberos.service.name = null
        sasl.kerberos.ticket.renew.jitter = 0.05
        sasl.kerberos.ticket.renew.window.factor = 0.8
        sasl.login.callback.handler.class = null
        sasl.login.class = null
        sasl.login.connect.timeout.ms = null
        sasl.login.read.timeout.ms = null
        sasl.login.refresh.buffer.seconds = 300
        sasl.login.refresh.min.period.seconds = 60
        sasl.login.refresh.window.factor = 0.8
        sasl.login.refresh.window.jitter = 0.05
        sasl.login.retry.backoff.max.ms = 10000
        sasl.login.retry.backoff.ms = 100
        sasl.mechanism.controller.protocol = GSSAPI
        sasl.mechanism.inter.broker.protocol = GSSAPI
        sasl.oauthbearer.clock.skew.seconds = 30
        sasl.oauthbearer.expected.audience = null
        sasl.oauthbearer.expected.issuer = null
        sasl.oauthbearer.jwks.endpoint.refresh.ms = 3600000
        sasl.oauthbearer.jwks.endpoint.retry.backoff.max.ms = 10000
        sasl.oauthbearer.jwks.endpoint.retry.backoff.ms = 100
        sasl.oauthbearer.jwks.endpoint.url = null
        sasl.oauthbearer.scope.claim.name = scope
        sasl.oauthbearer.sub.claim.name = sub
        sasl.oauthbearer.token.endpoint.url = null
        sasl.server.callback.handler.class = null
        security.inter.broker.protocol = PLAINTEXT
        security.providers = null
        socket.connection.setup.timeout.max.ms = 30000
        socket.connection.setup.timeout.ms = 10000
        socket.receive.buffer.bytes = 102400
        socket.request.max.bytes = 104857600
        socket.send.buffer.bytes = 102400
        ssl.cipher.suites = []
        ssl.client.auth = none
        ssl.enabled.protocols = [TLSv1.2]
        ssl.endpoint.identification.algorithm = https
        ssl.engine.factory.class = null
        ssl.key.password = null
        ssl.keymanager.algorithm = SunX509
        ssl.keystore.certificate.chain = null
        ssl.keystore.key = null
        ssl.keystore.location = null
        ssl.keystore.password = null
        ssl.keystore.type = JKS
        ssl.principal.mapping.rules = DEFAULT
        ssl.protocol = TLSv1.2
        ssl.provider = null
        ssl.secure.random.implementation = null
        ssl.trustmanager.algorithm = PKIX
        ssl.truststore.certificates = null
        ssl.truststore.location = null
        ssl.truststore.password = null
        ssl.truststore.type = JKS
        transaction.abort.timed.out.transaction.cleanup.interval.ms = 10000
        transaction.max.timeout.ms = 900000
        transaction.remove.expired.transaction.cleanup.interval.ms = 3600000
        transaction.state.log.load.buffer.size = 5242880
        transaction.state.log.min.isr = 1
        transaction.state.log.num.partitions = 50
        transaction.state.log.replication.factor = 1
        transaction.state.log.segment.bytes = 104857600
        transactional.id.expiration.ms = 604800000
        unclean.leader.election.enable = false
        zookeeper.clientCnxnSocket = null
        zookeeper.connect = localhost:2181
        zookeeper.connection.timeout.ms = 18000
        zookeeper.max.in.flight.requests = 10
        zookeeper.session.timeout.ms = 18000
        zookeeper.set.acl = false
        zookeeper.ssl.cipher.suites = null
        zookeeper.ssl.client.enable = false
        zookeeper.ssl.crl.enable = false
        zookeeper.ssl.enabled.protocols = null
        zookeeper.ssl.endpoint.identification.algorithm = HTTPS
        zookeeper.ssl.keystore.location = null
        zookeeper.ssl.keystore.password = null
        zookeeper.ssl.keystore.type = null
        zookeeper.ssl.ocsp.enable = false
        zookeeper.ssl.protocol = TLSv1.2
        zookeeper.ssl.truststore.location = null
        zookeeper.ssl.truststore.password = null
        zookeeper.ssl.truststore.type = null
        zookeeper.sync.time.ms = 2000
 (kafka.server.KafkaConfig)
[2022-03-07 22:52:54,078] INFO [ThrottledChannelReaper-Fetch]: Starting (kafka.server.ClientQuotaManager$ThrottledChannelReaper)
[2022-03-07 22:52:54,082] INFO [ThrottledChannelReaper-Produce]: Starting (kafka.server.ClientQuotaManager$ThrottledChannelReaper)
[2022-03-07 22:52:54,082] INFO [ThrottledChannelReaper-Request]: Starting (kafka.server.ClientQuotaManager$ThrottledChannelReaper)
[2022-03-07 22:52:54,087] INFO [ThrottledChannelReaper-ControllerMutation]: Starting (kafka.server.ClientQuotaManager$ThrottledChannelReaper)
[2022-03-07 22:52:54,141] INFO Log directory C:\kafka_2.12-3.1.0\kafka_2.12-3.1.0datakafka not found, creating it. (kafka.log.LogManager)
[2022-03-07 22:52:54,185] INFO Loading logs from log dirs ArrayBuffer(C:\kafka_2.12-3.1.0\kafka_2.12-3.1.0datakafka) (kafka.log.LogManager)
[2022-03-07 22:52:54,197] INFO Attempting recovery for all logs in C:\kafka_2.12-3.1.0\kafka_2.12-3.1.0datakafka since no clean shutdown file was found (kafka.log.LogManager)
[2022-03-07 22:52:54,219] INFO Loaded 0 logs in 31ms. (kafka.log.LogManager)
[2022-03-07 22:52:54,221] INFO Starting log cleanup with a period of 300000 ms. (kafka.log.LogManager)
[2022-03-07 22:52:54,227] INFO Starting log flusher with a default period of 9223372036854775807 ms. (kafka.log.LogManager)
[2022-03-07 22:52:55,367] INFO [BrokerToControllerChannelManager broker=0 name=forwarding]: Starting (kafka.server.BrokerToControllerRequestThread)
[2022-03-07 22:52:55,696] INFO Updated connection-accept-rate max connection creation rate to 2147483647 (kafka.network.ConnectionQuotas)
[2022-03-07 22:52:55,703] INFO Awaiting socket connections on 0.0.0.0:9092. (kafka.network.Acceptor)
[2022-03-07 22:52:55,756] INFO [SocketServer listenerType=ZK_BROKER, nodeId=0] Created data-plane acceptor and processors for endpoint : ListenerName(PLAINTEXT) (kafka.network.SocketServer)
[2022-03-07 22:52:55,777] INFO [BrokerToControllerChannelManager broker=0 name=alterIsr]: Starting (kafka.server.BrokerToControllerRequestThread)
[2022-03-07 22:52:55,847] INFO [ExpirationReaper-0-Produce]: Starting (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2022-03-07 22:52:55,851] INFO [ExpirationReaper-0-Fetch]: Starting (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2022-03-07 22:52:55,852] INFO [ExpirationReaper-0-DeleteRecords]: Starting (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2022-03-07 22:52:55,855] INFO [ExpirationReaper-0-ElectLeader]: Starting (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2022-03-07 22:52:55,892] INFO [LogDirFailureHandler]: Starting (kafka.server.ReplicaManager$LogDirFailureHandler)
[2022-03-07 22:52:55,947] INFO Creating /brokers/ids/0 (is it secure? false) (kafka.zk.KafkaZkClient)
[2022-03-07 22:52:56,000] INFO Stat of the created znode at /brokers/ids/0 is: 25,25,1646673775974,1646673775974,1,0,0,72060995117645824,248,0,25
 (kafka.zk.KafkaZkClient)
[2022-03-07 22:52:56,001] INFO Registered broker 0 at path /brokers/ids/0 with addresses: PLAINTEXT://USFRKMVDIXA0141.ad.us.mrshmc.com:9092, czxid (broker epoch): 25 (kafka.zk.KafkaZkClient)
[2022-03-07 22:52:56,148] INFO [ExpirationReaper-0-topic]: Starting (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2022-03-07 22:52:56,170] INFO [ExpirationReaper-0-Heartbeat]: Starting (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2022-03-07 22:52:56,171] INFO [ExpirationReaper-0-Rebalance]: Starting (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2022-03-07 22:52:56,229] INFO Successfully created /controller_epoch with initial epoch 0 (kafka.zk.KafkaZkClient)
[2022-03-07 22:52:56,234] INFO [GroupCoordinator 0]: Starting up. (kafka.coordinator.group.GroupCoordinator)
[2022-03-07 22:52:56,247] INFO [GroupCoordinator 0]: Startup complete. (kafka.coordinator.group.GroupCoordinator)
[2022-03-07 22:52:56,274] INFO Feature ZK node created at path: /feature (kafka.server.FinalizedFeatureChangeListener)
[2022-03-07 22:52:56,361] INFO [TransactionCoordinator id=0] Starting up. (kafka.coordinator.transaction.TransactionCoordinator)
[2022-03-07 22:52:56,373] INFO [TransactionCoordinator id=0] Startup complete. (kafka.coordinator.transaction.TransactionCoordinator)
[2022-03-07 22:52:56,373] INFO [Transaction Marker Channel Manager 0]: Starting (kafka.coordinator.transaction.TransactionMarkerChannelManager)
[2022-03-07 22:52:56,387] INFO Updated cache from existing <empty> to latest FinalizedFeaturesAndEpoch(features=Features{}, epoch=0). (kafka.server.FinalizedFeatureCache)
[2022-03-07 22:52:56,530] INFO [SocketServer listenerType=ZK_BROKER, nodeId=0] Starting socket server acceptors and processors (kafka.network.SocketServer)
[2022-03-07 22:52:56,536] INFO [/config/changes-event-process-thread]: Starting (kafka.common.ZkNodeChangeNotificationListener$ChangeEventProcessThread)
[2022-03-07 22:52:56,535] INFO [ExpirationReaper-0-AlterAcls]: Starting (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2022-03-07 22:52:56,709] INFO [SocketServer listenerType=ZK_BROKER, nodeId=0] Started data-plane acceptor and processor(s) for endpoint : ListenerName(PLAINTEXT) (kafka.network.SocketServer)
[2022-03-07 22:52:56,758] INFO [SocketServer listenerType=ZK_BROKER, nodeId=0] Started socket server acceptors and processors (kafka.network.SocketServer)
[2022-03-07 22:52:56,815] INFO Kafka version: 3.1.0 (org.apache.kafka.common.utils.AppInfoParser)
[2022-03-07 22:52:56,867] INFO Kafka commitId: 37edeed0777bacb3 (org.apache.kafka.common.utils.AppInfoParser)
[2022-03-07 22:52:56,875] INFO Kafka startTimeMs: 1646673776773 (org.apache.kafka.common.utils.AppInfoParser)
[2022-03-07 22:52:56,930] INFO [KafkaServer id=0] started (kafka.server.KafkaServer)
[2022-03-07 22:52:56,978] INFO [BrokerToControllerChannelManager broker=0 name=alterIsr]: Recorded new controller, from now on will use broker USFRKMVDIXA0141.ad.us.mrshmc.com:9092 (id: 0 rack: null) (kafka.server.BrokerToControllerRequestThread)
[2022-03-07 22:52:56,995] INFO [BrokerToControllerChannelManager broker=0 name=forwarding]: Recorded new controller, from now on will use broker USFRKMVDIXA0141.ad.us.mrshmc.com:9092 (id: 0 rack: null) (kafka.server.BrokerToControllerRequestThread)
```

