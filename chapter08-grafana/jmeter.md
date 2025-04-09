## jmeter 

```bash
# 1、下载、安装JMeter
wget -c https://archive.apache.org/dist/jmeter/binaries/apache-jmeter-5.6.3.tgz
# 解压
tar -zxvf apache-jmeter-5.6.3.tgz -C /usr/local/hero
cd /usr/local/hero/apache-jmeter-5.6.3

# 2、配置环境变量
输入命令 vim /etc/profile ，在最下面添加如下内容：
export JMETER_HOME=/usr/local/hero/apache-jmeter-5.6.3
export PATH=$JMETER_HOME/bin:$PATH

# 3、保存后，输入命令 ,使修改的配置生效。
source /etc/profile 
# 4、测试是否安装成功
jmeter -v
```

## 安装 plugins-manager.jar

然后安装：
- PerfMon：监控服务器硬件，如CPU，内存，硬盘读写速度等
- asic Graphs：主要显示平均响应时间，活动线程数，成功/失败交易数等
- Additional Graphs：主要显示吞吐量，连接时间，每秒的点击数等

配置插件：
- 响应时间：jp@gc - Response Times Over Time
- 活动线程数：jp@gc - Active Threads Over Time
- 每秒事务数：jp@gc - Transactions per Second

## JMeter插件Perfmon-监控服务器硬件资源

ServerAgent下载地址：https://github.com/undera/perfmon-agent/blob/master/README.md

```bash
## 默认启动运行 startAgent.sh 脚本即可

## 服务启动默认4444端口，根本连接不上，因此自己创建一个部署脚本文件对此进行部署，且把端口修改为7879
nohup java -jar ./CMDRunner.jar --tool PerfMonAgent --udp-port 7879 --tcp-port 7879 > log.log 2>&1 &

## 赋予可执行权限
chmod 755 startAgent.sh
```


## 集成 InfluxDB

安装InfluxDB：
```bash
docker run -d --name influxdb -p 8086:8086 -p 8083:8083 influxdb
```

添加后端监听器：
```bash
influxdbMetricsSender	org.apache.jmeter.visualizers.backend.influxdb.HttpMetricsSender
influxdbUrl	http://47.93.59.248:8086/write?db=jmeter
application	hero_mall_one
measurement	jmeter
summaryOnly	false
samplersRegex	RT*
percentiles	90;95;99
testTitle	压力测试案例01
eventTags	
```