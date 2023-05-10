# Jedis for BudWk

fork from [https://github.com/redis/jedis](https://github.com/redis/jedis)

解决 Jedis 新版本与旧版不兼容的问题，ps：nutzmore/nutzboot 中 jedis 老版本升级改造成本太高

```xml
<dependency>
    <groupId>com.budwk</groupId>
    <artifactId>jedis</artifactId>
    <version>4.4.0-SNAPSHOT</version>
</dependency>
```

```xml
<repositories>
        <repository>
            <id>nutz</id>
            <url>https://jfrog.nutz.cn/artifactory/libs-release</url>
        </repository>
        <repository>
            <id>nutz-snapshots</id>
            <url>https://jfrog.nutz.cn/artifactory/snapshots</url>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
            <releases>
                <enabled>false</enabled>
            </releases>
        </repository>
</repositories>
```