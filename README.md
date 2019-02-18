# springbootdemo



springboot2.1.1
bootstrap4.0.0


为什么选择Redis？
    1）Redis不仅仅支持简单的k/v类型的数据，同时还提供list，set，zset，hash等数据结构的存储。
    2）Redis支持master-slave(主-从)模式应用
    3）Redis支持数据持久化，可以将内存中的数据保持在磁盘中，重启的时候可以再次加载进行使用。
    4）Redis单个value的最大限制是1GB，memcached只能保存1MB的数据。

Redis是目前业界使用最广泛的内存数据存储。相比memcached，Redis支持更丰富的数据结构，例如hashes, lists, sets等，同时支持数据持久化。除此之外，Redis还提供一些类数据库的特性，比如事务，HA，主从库。可以说Redis兼具了缓存系统和数据库的一些特性，因此有着丰富的应用场景。
1、引入 spring-boot-starter-redis
<dependency>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-starter-redis</artifactId>  
</dependency>
2、添加配置文件



