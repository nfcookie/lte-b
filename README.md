# lte-b

运行TeskUav中的类中的initTask方法,使用的是异步处理(线程池部分有待改进)。

流程为：
1.生成无人机的请求对象，写入到StoreManager的队列中
2.启动Processer的线程，从队列中取出无人机的请求，在请求执行的结束时间之前，
通过随机数执行queryTask还是createTask,通过http请求调用服务器并得到返回值。
processer.setIntervalTime可以设置无人机在执行过程中间隔的时间。
3.当一个无人机的结束后，从队列中取出新的无人机请求，直到队列为空

日志用的是log4j,通过log4.properties制定日志输出的等级，格式和对应文件位置。

