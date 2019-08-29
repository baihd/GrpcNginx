## ubuntu安装nginx
### 前置环境配置
* 进入`/usr/local`目录下执行以下安装
* 1.gcc
```
sudo apt-get install build-essential
sudo apt-get install libtool
```
* 2.PCRE库
```
sudo apt-get install libpcre3 libpcre3-dev
```
* 3.zlib库
```
sudo apt-get install zlib1g-dev
```
* 4.OpenSSL库
```
sudo apt-get install openssl libssl-dev
```

### nginx安装
* 1.下载压缩包
`wget https://nginx.org/download/nginx-1.16.1.tar.gz`
* 2.解压
`tar -zxvf nginx-1.16.1.tar.gz`
* 3.进入到nginx-1.16.1文件夹下，安装
```
cd nginx-1.16.1
//执行configure
./configure --with-http_ssl_module --with-http_v2_module
// 编译
make
// 安装
make install
```
*  4.nginx.conf中增加以下配置
```
http {
    include       mime.types;
    default_type  application/octet-stream;

    log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
                      '$status $body_bytes_sent "$http_referer" '
                      '"$http_user_agent" "$http_x_forwarded_for"';

    sendfile        on;

    keepalive_timeout  65;

    gzip  on;

    upstream grpcservers {
        server 192.168.1.17:9995;
   	    server 192.168.1.102:9995;
   	    server 192.168.1.171:9995;
    }

    server {
        listen       9993 http2;
        ## 限制整个请求标头列表的最大大小
        http2_max_requests 3000;
        server_name  localhost;

        location / {
            grpc_pass grpc://grpcservers;
        }

    }
}

```
* 5.命令，默认情况下，nginx会安装到/usr/local/nginx/目录
```
cd /usr/local/nginx

//查看版本
./sbin/nginx -v

//检查nginx配置文件
./sbin/nginx -t

//运行nginx
./sbin/nginx

//重启nginx
./sbin/nginx -s reload
```